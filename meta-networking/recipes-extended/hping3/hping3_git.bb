# Copyright (C) 2020 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "hping is a command-line oriented TCP/IP packet assembler/analyzer"
HOMEPAGE = "http://www.hping.org/"
SECTION = "net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3728a6c4c9630a9e796ad4b82dacd887"

SRC_URI = "git://github.com/antirez/hping;protocol=https \
           file://0001-Fix-build-with-fcommon.patch \
           file://0002-Use-pcap-bpf.h-instead-of-net-bpf.h.patch \
           file://0003-Remove-assumption-on-native-compile.patch \
           file://0004-Fix-indentation-to-clarify-the-logic.patch \
           file://0005-scan-Fix-the-size-for-memcpy.patch \
           file://0006-Address-unused-but-set-compiler-diagnostics.patch \
           "

PV = "1.0+git${SRCPV}"

SRCREV = "3547c7691742c6eaa31f8402e0ccbb81387c1b99"

S = "${WORKDIR}/git"
B = "${S}"

inherit pkgconfig siteinfo

DEPENDS += "libpcap tcl"

do_configure () {
    # Specify any needed configure commands here
    BYTEORDER="${@oe.utils.conditional('SITEINFO_ENDIANNESS', 'le', '__LITTLE_ENDIAN_BITFIELD', '__BIG_ENDIAN_BITFIELD', d)}" \
    CONFIGOSTYPE="LINUX" ./configure
}

do_compile () {
    oe_runmake
}

do_install() {
    install -d ${D}${docdir}/hping3
    oe_runmake DESTDIR=${D} install
    for f in ${S}/docs/HPING2-HOWTO.txt ${S}/docs/HPING2-IS-OPEN \
        ${S}/docs/MORE-FUN-WITH-IPID ${S}/docs/SPOOFED_SCAN.txt \
        ${S}/docs/AS-BACKDOOR docs/APD.txt 
    do
        install -m 0644 $f ${D}${docdir}/hping3
    done
}
