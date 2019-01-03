SUMMARY = "A New System Troubleshooting Tool Built for the Way You Work"
DESCRIPTION = "Sysdig is open source, system-level exploration: capture \
system state and activity from a running Linux instance, then save, \
filter and analyze."
HOMEPAGE = "http://www.sysdig.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=f8fee3d59797546cffab04f3b88b2d44"

inherit cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"
JIT ?= "jit"
JIT_mipsarchn32 = ""
JIT_mipsarchn64 = ""
JIT_aarch64 = ""

DEPENDS = "lua${JIT} zlib ncurses jsoncpp tbb jq openssl elfutils protobuf"
RDEPENDS_${PN} = "bash"

SRC_URI = "git://github.com/draios/sysdig.git;branch=dev \
           file://0001-libsinsp-Port-to-build-with-lua-5.2.patch \
           file://0001-Fix-build-with-musl-backtrace-APIs-are-glibc-specifi.patch \
          "
# v0.26.4
SRCREV = "5e3b3c287c0661d27400617f329bd13b3759eb17"
PV = "0.26.4"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = "\
                -DBUILD_DRIVER=OFF \
                -DUSE_BUNDLED_DEPS=ON \
                -DUSE_BUNDLED_LUAJIT=OFF \
                -DUSE_BUNDLED_B64=ON \
                -DUSE_BUNDLED_CARES=ON \
                -DUSE_BUNDLED_PROTOBUF=ON \
                -DUSE_BUNDLED_ZLIB=ON \
                -DUSE_BUNDLED_GRPC=ON \
                -DDIR_ETC=${sysconfdir} \
"

FILES_${PN} += " \
    ${DIR_ETC}/* \
    ${datadir}/zsh/* \
    ${prefix}/src/*  \
"

SECURITY_CFLAGS = ""
SECURITY_LDFLAGS = ""

PNBLACKLIST[sysdig] = "configure: error: in 'TOPDIR/build/tmpfs/work/core2-64-yoe-linux/sysdig/0.26.4-r0/build/c-ares-prefix/src/c-ares'"
