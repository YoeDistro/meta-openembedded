DESCRIPTION = "Fetch location and size of physical screens."
HOMEPAGE = "https://github.com/rr-/screeninfo"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=a23813181e06852d377bc25ae5563a97"

SRC_URI[sha256sum] = "9983076bcc7e34402a1a9e4d7dabf3729411fd2abb3f3b4be7eba73519cd2ed1"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-core \
    python3-profile \
"
