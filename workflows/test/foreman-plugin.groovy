def version_map = branch_map[env.gitlabTargetBranch]
def ruby = version_map['ruby']

pipeline {
    options {
        timestamps()
        timeout(time: 2, unit: 'HOURS')
        ansiColor('xterm')
        buildDiscarder(logRotator(numToKeepStr: '15'))
    }

    agent { label 'sat6-build' }

    stages {

        stage('Setup Git Repos') {

            steps {

                deleteDir()

                dir('foreman') {
                    script {
                        if (env.gitlabTargetBranch == 'master') {
                            git url: "https://github.com/theforeman/foreman.git", branch: "develop"
                        } else {
                            gitlab_clone('foreman')
                        }
                    }
                }

                dir('plugin') {
                    gitlab_clone_and_merge(plugin_name)
                }

            }

        }

        stage('Configure Environment') {

            steps {

                dir('foreman') {
                    configure_foreman_environment()
                }

            }

        }

        stage('Configure Database') {

            steps {

                dir('foreman') {
                    setup_foreman(ruby)
                }

            }

        }

        stage('Setup plugin') {

            steps {

                dir('foreman') {
                    setup_plugin(plugin_name, ruby)
                }

            }

        }

        stage('Run Tests') {
            parallel {
                stage('tests') {
                    steps {
                        dir('foreman') {
                            gitlabCommitStatus(name: "tests") {
                                withRVM(["bundle exec rake ${plugin_tests}"], ruby)
                                withRVM(['bundle exec rake db:drop db:create db:migrate'], ruby)
                                withRVM(['bundle exec rake db:seed'], ruby)
                            }
                        }
                    }
                }
                stage('assets-precompile') {
                    steps {
                        dir('foreman') {
                            gitlabCommitStatus(name: "assets-precompile") {
                                sh "npm install npm"
                                withRVM(["bundle exec node_modules/.bin/npm install"], ruby)
                                withRVM(["bundle exec rake plugin:assets:precompile[${plugin_name}] RAILS_ENV=production --trace"], ruby)
                            }
                        }
                    }
                }
            }
        }
    }

    post {
        failure {
            updateGitlabCommitStatus name: 'jenkins', state: 'failed'
        }
        success {
            updateGitlabCommitStatus name: 'jenkins', state: 'success'
        }
        always {
            dir('foreman') {
                archiveArtifacts artifacts: "Gemfile.lock, pkg/*"
                cleanup(ruby)
            }
        }
    }
}
