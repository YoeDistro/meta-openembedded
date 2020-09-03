SUMMARY = "Traitlets Python config system"
HOMEPAGE = "http://ipython.org"
AUTHOR = "IPython Development Team <ipython-dev@scipy.org>"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=eec4de4d599518742e54e75954e33b46"

PYPI_PACKAGE = "traitlets"

SRC_URI[md5sum] = "7dc642d19d1268a8268f46f33ff871c6"
SRC_URI[sha256sum] = "4c9a7212db9642056ea4fcd4ba9e18d302eb617daf679f45fd8cb5d19687b640"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-ipython-genutils \
    ${PYTHON_PN}-decorator \
"

inherit setuptools3 pypi
