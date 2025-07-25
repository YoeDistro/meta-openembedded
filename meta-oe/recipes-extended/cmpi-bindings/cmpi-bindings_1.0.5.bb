SUMMARY = "Adapter to write and run CMPI-type CIM providers"
DESCRIPTION = "CMPI-compliant provider interface for various languages via SWIG"
HOMEPAGE = "http://github.com/kkaempf/cmpi-bindings"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=b19ee058d2d5f69af45da98051d91064"
SECTION = "Development/Libraries"
DEPENDS = "swig-native sblim-cmpi-devel python3-setuptools-native"

SRC_URI = "git://github.com/kkaempf/cmpi-bindings.git;protocol=https;branch=main \
           file://cmpi-bindings-0.4.17-no-ruby-perl.patch \
           file://cmpi-bindings-0.4.17-sblim-sigsegv.patch \
           file://0001-Fix-error.patch \
           file://0002-allow-build-with-cmake-4.patch \
           "

SRCREV = "49d6dcfc71ca421100fcf325e31625817c469fc9"

inherit cmake python3targetconfig

EXTRA_OECMAKE = "-DLIB='${baselib}' \
                 -DPYTHON_INCLUDE_PATH=${STAGING_INCDIR}/python${PYTHON_BASEVERSION} \
                 -DPYTHON_ABI=${PYTHON_ABI} \
                 -DBUILD_PYTHON3=NO \
                 -DPython3_SITE_DIR=${PYTHON_SITEPACKAGES_DIR} \
                 "

# With Ninja it fails with:
# ninja: error: build.ninja:282: bad $-escape (literal $ must be written as $$)
OECMAKE_GENERATOR = "Unix Makefiles"

FILES:${PN} =+ "${libdir}/cmpi/libpy3CmpiProvider.so ${PYTHON_SITEPACKAGES_DIR}/*"
FILES:${PN}-dbg =+ "${libdir}/cmpi/.debug/libpyCmpiProvider.so"

BBCLASSEXTEND = "native"

# http://errors.yoctoproject.org/Errors/Details/766910/
# cmpi-bindings/1.0.4/git/swig/python/../../src/target_python.c:168:21: error: passing argument 1 of 'Py_SetProgramName' from incompatible pointer type [-Wincompatible-pointer-types]
CFLAGS += "-Wno-error=incompatible-pointer-types"
