SUMMARY = "An unofficial GTK3 port of libadwaita."
HOMEPAGE = "http://github.com/lassekongo83/adw-gtk3"
SECTION = "graphics"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

DEPENDS = "sassc-native"

inherit meson

SRC_URI = "git://github.com/lassekongo83/adw-gtk3.git;protocol=https;branch=main"

S = "${WORKDIR}/git"
SRCREV = "91aac01e4f4bfbbe233cf7f4bb7a8e4cff73bc5f"

FILES:${PN} = "${datadir}/themes"
