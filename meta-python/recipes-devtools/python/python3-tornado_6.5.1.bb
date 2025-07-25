SUMMARY  = "Tornado is an open source version of the scalable, non-blocking web server and tools that power FriendFeed."
DESCRIPTION = "Tornado is a Python web framework and asynchronous networking library, originally developed at FriendFeed. \
By using non-blocking network I/O, Tornado can scale to tens of thousands of open connections, making it ideal for long \
polling, WebSockets, and other applications that require a long-lived connection to each user."
HOMEPAGE = "https://www.tornadoweb.org/en/stable/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "84ceece391e8eb9b2b95578db65e920d2a61070260594819589609ba9bc6308c"

inherit pypi python_setuptools_build_meta

# Requires _compression which is currently located in misc
RDEPENDS:${PN} += " \
    python3-asyncio \
    python3-certifi \
    python3-compression \
    python3-ctypes \
    python3-email \
    python3-html \
    python3-json \
    python3-misc \
    python3-multiprocessing \
    python3-numbers \
    python3-pkgutil \
    python3-pycurl \
    python3-threading \
    python3-unittest \
"

RDEPENDS:${PN}-test += "python3-unittest"

PACKAGES =+ "\
    ${PN}-test \
"

FILES:${PN}-test = " \
    ${PYTHON_SITEPACKAGES_DIR}/*/test \
"

BBCLASSEXTEND  += "native nativesdk"
