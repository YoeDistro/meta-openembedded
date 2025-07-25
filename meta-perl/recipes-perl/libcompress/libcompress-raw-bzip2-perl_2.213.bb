SUMMARY = "Low-Level Interface to bzip2 compression library"
DESCRIPTION = ""Compress::Raw::Bzip2" provides an interface to the in-memory \
compression/uncompression functions from the bzip2 compression library."
HOMEPAGE = "https://metacpan.org/release/Compress-Raw-Bzip2"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0-or-later"

LIC_FILES_CHKSUM = "file://README;beginline=8;endline=10;md5=cd551ef796cc7fa34351ced771a3a7f9"

SRC_URI = "${CPAN_MIRROR}/authors/id/P/PM/PMQS/Compress-Raw-Bzip2-${PV}.tar.gz"

SRC_URI[sha256sum] = "8d75d3d366c9101ca18061b00d438d3da39478c06159147dea3c666770577c7b"

DEPENDS += "bzip2"

S = "${UNPACKDIR}/Compress-Raw-Bzip2-${PV}"

inherit cpan

export BUILD_BZIP2 = "0"
export BZIP2_INCLUDE = "-I${STAGING_DIR_HOST}${includedir}"

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
