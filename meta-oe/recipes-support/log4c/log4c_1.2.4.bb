SUMMARY = "Log4c is a C library for flexible logging to files, syslog and other destinations"
HOMEPAGE = "http://log4c.sourceforge.net"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BP}.tar.gz \
           file://fix_configure_with-expat.patch \
           file://0001-Use-the-API-properly-in-the-example-format-security-.patch \
          "

SRC_URI[sha256sum] = "5991020192f52cc40fa852fbf6bbf5bd5db5d5d00aa9905c67f6f0eadeed48ea"

PACKAGECONFIG ??= "expat"
PACKAGECONFIG[expat] = "--with-expat,--without-expat,expat"

BINCONFIG = "${bindir}/log4c-config"

inherit autotools binconfig-disabled

BBCLASSEXTEND = "native"
