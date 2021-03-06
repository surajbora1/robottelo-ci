def compose_versions = ['7']
def tools_compose_versions = ['7', '6', '5']

def os_versions = ['7']

def satellite_short_version = 63
def satellite_main_version = '6.3'
def satellite_version = '6.3.0'

def satellite_repositories = [
    "Satellite 6.3 RHEL7",
    "Satellite 6.3 Puppet 4 RHEL7"
]

def capsule_repositories = [
    "Satellite Capsule 6.3 RHEL7",
    "Satellite Capsule 6.3 Puppet 4 RHEL7"
]

def tools_repositories = [
    "Satellite Tools 6.3 RHEL7 x86_64",
    "Satellite Tools 6.3 RHEL7 ppc64le",
    "Satellite Tools 6.3 RHEL7 ppc64",
    "Satellite Tools 6.3 RHEL7 s390x",
    "Satellite Tools 6.3 RHEL7 aarch64",
    "Satellite Tools 6.3 RHEL6 x86_64",
    "Satellite Tools 6.3 RHEL6 i386",
    "Satellite Tools 6.3 RHEL6 ppc64",
    "Satellite Tools 6.3 RHEL6 s390x",
    "Satellite Tools 6.3 RHEL5 x86_64",
    "Satellite Tools 6.3 RHEL5 i386",
    "Satellite Tools 6.3 RHEL5 s390x",
    "Satellite Tools Puppet 4 6.3 RHEL7 x86_64",
    "Satellite Tools Puppet 4 6.3 RHEL6 x86_64",
    "Satellite Tools Puppet 4 6.3 RHEL6 i386",
    "Satellite Tools Puppet 4 6.3 RHEL5 x86_64",
    "Satellite Tools Puppet 4 6.3 RHEL5 i386",
]

def satellite_content_views = [
    'Satellite 6.3 RHEL7'
]

def capsule_content_views = [
    'Capsule 6.3 RHEL7'
]

def tools_content_views = [
    'Tools 6.3 RHEL7',
    'Tools 6.3 RHEL6',
    'Tools 6.3 RHEL5'
]

def content_views = satellite_content_views + capsule_content_views + tools_content_views

def satellite_composite_content_views = [
    'Satellite 6.3 with RHEL7 Server'
]
def capsule_composite_content_views = [
    'Capsule 6.3 with RHEL7 Server'
]
def tools_composite_content_views = [
    'Tools 6.3 with RHEL7 Server',
    'Tools 6.3 with RHEL6 Server',
    'Tools 6.3 with RHEL5 Server'
]
def composite_content_views = satellite_composite_content_views + capsule_composite_content_views + tools_composite_content_views

def satellite_activation_keys = [
    'satellite-6.3.0-qa-rhel7'
]
def capsule_activation_keys = [
    'capsule-6.3.0-qa-rhel7'
]
def tools_activation_keys = [
    'satellite-tools-6.3.0-qa-rhel7',
    'satellite-tools-6.3.0-qa-rhel6',
    'satellite-tools-6.3.0-qa-rhel5'
]
