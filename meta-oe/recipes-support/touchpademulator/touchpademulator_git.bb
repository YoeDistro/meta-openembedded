SUMMARY = "Emulate a touchpad mouse device using a touchscreen on Linux"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f744a106227710d355bcc787e464ba2d \
                    file://debian/copyright;md5=7bed05b78c0e4abec501cf82c4b85d9c"

SRC_URI = "git://gitlab.com/CalcProgrammer1/TouchpadEmulator;protocol=https;branch=master \
           file://0001-makefile-Use-CC-instead-of-hardcoding-gcc-calls.patch \
           file://0002-LaunchTouchpadEmulator.sh-Demand-sh-instead-of-bash.patch \
           "

PV = "1.0+git"
SRCREV = "7800f4c3af4defaf1be1083c93983ed4ff0e3b32"

inherit pkgconfig

DEPENDS += "dbus dbus-glib"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install 'DESTDIR=${D}'
}

FILES:${PN} += "${datadir}/icons"
