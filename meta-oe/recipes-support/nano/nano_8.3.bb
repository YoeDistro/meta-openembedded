SUMMARY = "Small and friendly console text editor"
DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
HOMEPAGE = "http://www.nano-editor.org/"
SECTION = "console/utils"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

DEPENDS = "ncurses"
RDEPENDS:${PN} = "ncurses-terminfo-base"

PV_MAJOR = "${@d.getVar('PV').split('.')[0]}"

SRC_URI = "https://nano-editor.org/dist/v${PV_MAJOR}/nano-${PV}.tar.xz"
SRC_URI[sha256sum] = "551b717b2e28f7e90f749323686a1b5bbbd84cfa1390604d854a3ca3778f111e"

UPSTREAM_CHECK_URI = "https://ftp.gnu.org/gnu/nano"

inherit autotools gettext pkgconfig

PACKAGECONFIG[tiny] = "--enable-tiny,"
