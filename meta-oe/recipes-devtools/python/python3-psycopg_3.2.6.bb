SUMMARY = "Psycopg 3 is the implementation of a PostgreSQL adapter for Python."
DESCRIPTION = "Psycopg is the most popular PostgreSQL adapter for the Python \
programming language. Its core is a complete implementation of the Python DB \
API 2.0 specifications. Several extensions allow access to many of the \
features offered by PostgreSQL."

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI[sha256sum] = "16fa094efa2698f260f2af74f3710f781e4a6f226efe9d1fd0c37f384639ed8a"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "libpq"
