SUMMARY = "Dispatcher service for systemd-networkd connection status changes"
DESCRIPTION = "This daemon is similar to NetworkManager-dispatcher, but is much \
more limited in the types of events it supports due to the limited nature of \
systemd-networkd(8)."

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit features_check systemd

RDEPENDS:${PN} = "python3-pygobject python3-dbus python3-json"
REQUIRED_DISTRO_FEATURES = "systemd gobject-introspection-data"

SRCREV = "dfd26d72793914eb3da910ef8c71de6d7c8942a2"
SRC_URI = "git://gitlab.com/craftyguy/networkd-dispatcher;protocol=https;nobranch=1"


SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "networkd-dispatcher.service"
SYSTEMD_AUTO_ENABLE = "disable"

# Nothing to build, just a python script to install
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -D -m 0755 ${S}/networkd-dispatcher ${D}${bindir}/networkd-dispatcher
    install -D -m 0644 ${S}/networkd-dispatcher.service ${D}/${systemd_system_unitdir}/networkd-dispatcher.service
    install -D -m 0644 ${S}/networkd-dispatcher.conf ${D}/${sysconfdir}/conf.d/networkd-dispatcher.conf
}
