DESCRIPTION = "C++ bindings for ZeroMQ"
HOMEPAGE = "http://www.zeromq.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db174eaf7b55a34a7c89551197f66e94"
DEPENDS = "zeromq"

SRCREV = "c94c20743ed7d4aa37835a5c46567ab0790d4acc"

SRC_URI = "git://github.com/zeromq/cppzmq.git;branch=master;protocol=https"


inherit cmake

EXTRA_OECMAKE = "-DCPPZMQ_BUILD_TESTS=OFF"

ALLOW_EMPTY:${PN} = "1"
