SUMMARY = "Provides a wrapper in Python to LDAP"
DESCRIPTION = "This module provides access to the LDAP \
(Lightweight Directory Access Protocol) through Python operations \
instead of C API. The module mainly acts as a wrapper for the \
OpenLDAP 2.x libraries. Errors will appear as exceptions."
HOMEPAGE = "https://www.python-ldap.org/"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENCE;md5=36ce9d726d0321b73c1521704d07db1b"

DEPENDS = "python3 openldap cyrus-sasl python3-setuptools-scm-native"

PYPI_PACKAGE = "python_ldap"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "83d6b65c7cbe627d81e556d0d03f3f450e3ac35ba9c1b6011f0097ac92effeb1"

do_configure:prepend() {
    sed -i -e 's:^library_dirs =.*::' \
        -e 's:^include_dirs =.*:include_dirs = =/usr/include/sasl/:' \
        -e 's/= ldap_r/= ldap/g' ${S}/setup.cfg
}

RDEPENDS:${PN} = " \
    python3-pprint \
    python3-pyasn1 \
    python3-pyasn1-modules \
    python3-threading \
    python3-unittest \
"

CVE_PRODUCT = "python-ldap"
