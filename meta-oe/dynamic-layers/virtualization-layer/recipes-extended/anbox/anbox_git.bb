LICENSE = "GPLv3 & Apache-2.0 & LGPLv2.1 & LGPLv3 & MIT"
LIC_FILES_CHKSUM = "file://COPYING.GPL;md5=f27defe1e96c2e1ecd4e0c9be8967949 \
                    file://android/audio/MODULE_LICENSE_APACHE2;md5=d41d8cd98f00b204e9800998ecf8427e \
                    file://external/sdbus-cpp/COPYING;md5=1803fa9c2c3ce8cb06b4861d75310742 \
                    file://external/sdbus-cpp/tools/COPYING;md5=1803fa9c2c3ce8cb06b4861d75310742 \
                    file://external/xdg/LICENSE;md5=959bffe2993816eb32ec4bc1ec1d5875 \
                    file://external/backward-cpp/LICENSE.txt;md5=74ea9734864a5514a5d672f385e3b382 \
                    file://external/cpu_features/LICENSE;md5=175792518e4ac015ab6696d16c4f607e \
                    file://external/process-cpp-minimal/COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = "gitsm://github.com/anbox/anbox;protocol=https \
           file://0001-Disable-warnings-as-errors.patch \
           file://0002-cmake-Condiitonally-use-native-sdbus-c-xml2cpp-for-x.patch \
           file://0003-emugen-Sett-cmake-C-C-flags-to-host-cflags.patch \
           file://0004-Use-python3-during-build.patch \
           file://0005-define-sec-usec-based-on-platform-wordlength.patch \
           file://0006-Do-not-mark-includes-as-const-function.patch \
           file://0007-disable-tests-in-xdg-module.patch \
           file://0008-android-emugl-Respect-flags-passed-from-environment.patch \
           "

PV = "1.0+git${SRCPV}"
SRCREV = "c1e75506bad0c479c8591970ce422aa8646654ac"

S = "${WORKDIR}/git"

DEPENDS = "virtual/egl virtual/libgles2 virtual/libsdl2 \
           libsdl2-image boost protobuf elfutils gmock gtest lxc glm \
           properties-cpp sdbus-c++ libcap \
           sdbus-c++-tools-native protobuf-c-native"

PACKAGECONFIG ?= "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)}"

PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND=ON,-DENABLE_WAYLAND=OFF,wayland"

inherit cmake pkgconfig features_check systemd

REQUIRED_DISTRO_FEATURES += "opengl"

EXTRA_OECMAKE = "-DHOST_CMAKE_CXX_COMPILER='${BUILD_CXX}' -DHOST_CMAKE_CXX_FLAGS='${BUILD_CXXFLAGS}' -DXML2CPP=sdbus-c++-xml2cpp"

RDEPENDS_${PN} += "libgles2"
