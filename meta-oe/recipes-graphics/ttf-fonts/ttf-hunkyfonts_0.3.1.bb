require ttf.inc

SUMMARY = "Hunky fonts - TTF Version"
HOMEPAGE = "http://sourceforge.net/projects/hunkyfonts"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://../COPYRIGHT.TXT;md5=70d34478e38b1ad9995079f9921f9ef7"

SRC_URI = "${SOURCEFORGE_MIRROR}/hunkyfonts/hunkyfonts-${PV}.tar.bz2"

S = "${UNPACKDIR}/hunkyfonts-${PV}/TTF"

PACKAGES = "ttf-hunky-sans ttf-hunky-serif"
FONT_PACKAGES = "ttf-hunky-sans ttf-hunky-serif"

FILES:ttf-hunky-sans = "${datadir}/fonts/truetype/HunkySans*.ttf"
FILES:ttf-hunky-serif = "${datadir}/fonts/truetype/HunkySerif*.ttf"

SRC_URI[sha256sum] = "3fc528737ccd12ec3c09c4a91447d241d3c5bceeeb4d24b7f2c29b15c9735328"
