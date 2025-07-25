SUMMARY = "Management Component Control Protocol utilities"
HOMEPAGE = "http://www.github.com/CodeConstruct/mctp"
SECTION = "net"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE;md5=4cc91856b08b094b4f406a29dc61db21"

SRCREV = "dd944cf5b5a8b834f3685bcb2017190258dbcd0b"

SRC_URI = "git://github.com/CodeConstruct/mctp;branch=main;protocol=https \
           file://0001-mctp-bench-Adjust-headers.patch"


inherit meson pkgconfig systemd

EXTRA_OEMESON = " \
    -Dtests=false \
"

PACKAGECONFIG ??= " \
    ${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
"

# mctpd will only be built if pkg-config detects libsystemd; in which case
# we'll want to declare the dep and install the service.
PACKAGECONFIG[systemd] = ",,systemd,libsystemd"
SYSTEMD_SERVICE:${PN} = "mctpd.service mctp.target mctp-local.target"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install:append () {
    if ${@bb.utils.contains('PACKAGECONFIG', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${S}/conf/mctpd.service \
                ${D}${systemd_system_unitdir}/mctpd.service
        install -m 0644 ${S}/conf/*.target \
                ${D}${systemd_system_unitdir}/
        install -d ${D}${datadir}/dbus-1/system.d
        install -m 0644 ${S}/conf/mctpd-dbus.conf \
                ${D}${datadir}/dbus-1/system.d/mctpd.conf
    fi
}

FILES:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', \
            '${datadir}/dbus-1/system.d/mctpd.conf', '', d)} \
"
