SUMMARY = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "OE-Alliance"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = " \
    freetype \
    gettext-native \
    gstreamer1.0-plugins-base gstreamer1.0 \
    jpeg \
    libdreamdvd libdvbsi++ libfribidi libmad libpng libsigc++-1.2 giflib libxml2 libxmlccwrap \
    openssl \
    ${@bb.utils.contains("DISTRO_NAME", "openmips", "avahi libudfread", "", d)} \
    ${@bb.utils.contains("DISTRO_NAME", "openatv", "avahi libudfread", "", d)} \
    ${@bb.utils.contains("DISTRO_NAME", "opennfr", "avahi libudfread", "", d)} \
    ${@bb.utils.contains("DISTRO_NAME", "egami", "avahi libudfread", "", d)} \
    ${@bb.utils.contains("DISTRO_NAME", "openvix", "avahi libudfread", "", d)} \
    ${@bb.utils.contains("DISTRO_NAME", "openbh", "avahi libudfread", "", d)} \
    ${@bb.utils.contains("DISTRO_NAME", "openspa", "avahi libudfread", "", d)} \
    python python-imaging python-twisted python-wifi \
    swig-native \
    tuxtxt-enigma2 \
    ${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "vuplus-libgles-${MACHINE} libvugles2" , "", d)} \
    "

RDEPENDS_${PN} = " \
    alsa-conf \
    enigma2-fonts \
    ethtool \
    glibc-gconv-iso8859-15 \
    glibc-gconv-cp1250 \
    hotplug-e2-helper \
    ${PYTHON_RDEPS} \
    ${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "vuplus-libgles-${MACHINE} libvugles2" , "", d)} \
    oe-alliance-branding \
    "

RRECOMMENDS_${PN} = " \
    glib-networking \
    glibc-gconv-utf-16 \
    gstreamer1.0-plugin-subsink \
    ${GST_BASE_RDEPS} \
    ${GST_GOOD_RDEPS} \
    ${GST_BAD_RDEPS} \
    ${GST_UGLY_RDEPS} \
    ${@bb.utils.contains("GST_VERSION", "1.0", "${GST_BAD_OPUS}", "", d)} \
    "

PYTHON_RDEPS = " \
    python-codecs \
    python-core \
    python-crypt \
    python-fcntl \
    python-lang \
    python-importlib \
    python-netclient \
    python-netserver \
    python-pickle \
    python-re \
    python-shell \
    python-threading \
    python-twisted-core \
    python-twisted-web \
    python-utf8-hack \
    python-xml \
    python-zlib \
    python-zopeinterface \
    python-email \
    python-mime \
    python-pyusb \
    python-subprocess \
    python-process \
    python-imaging \
    python-pycrypto \
    python-json \
    python-misc \
    python-textutils \
    python-compression \
    python-robotparser \
    python-mechanize \
    python-pyopenssl \
    python-html \
    "

GST_BASE_RDEPS = "  \
    gstreamer1.0-plugins-base-alsa \
    gstreamer1.0-plugins-base-app \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-audiorate \
    gstreamer1.0-plugins-base-videoconvert \
    gstreamer1.0-plugins-base-ivorbisdec \
    gstreamer1.0-plugins-base-ogg \
    gstreamer1.0-plugins-base-playback \
    gstreamer1.0-plugins-base-subparse \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-base-vorbis \
    "

GST_GOOD_RDEPS = " \
    gstreamer1.0-plugins-good-apetag \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-autodetect \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-flac \
    gstreamer1.0-plugins-good-flv \
    gstreamer1.0-plugins-good-icydemux \
    gstreamer1.0-plugins-good-id3demux \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-matroska \
    gstreamer1.0-plugins-good-rtp \
    gstreamer1.0-plugins-good-rtpmanager \
    gstreamer1.0-plugins-good-rtsp \
    gstreamer1.0-plugins-good-souphttpsrc \
    gstreamer1.0-plugins-good-udp \
    gstreamer1.0-plugins-good-wavparse \
    gstreamer1.0-plugins-good-wavpack \
    "

GST_BAD_RDEPS = " \
    gstreamer1.0-plugins-bad-dashdemux \
    gstreamer1.0-plugins-bad-mms \
    gstreamer1.0-plugins-bad-mpegpsdemux \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-smoothstreaming \
    gstreamer1.0-plugins-bad-faad \
    gstreamer1.0-plugins-bad-rtmp \   
    gstreamer1.0-plugins-bad-hls \ 
    gstreamer1.0-plugins-bad-videoparsersbad \
    gstreamer1.0-plugins-bad-autoconvert \
    gstreamer1.0-plugins-bad-faac \
    gstreamer1.0-plugins-bad-libmms \  
    "
GST_BAD_OPUS = " \
    ${@bb.utils.contains("TARGET_ARCH", "arm", " gstreamer1.0-plugins-base-opus gstreamer1.0-plugins-bad-opusparse", "", d)} \
    "
GST_UGLY_RDEPS = " \
    gstreamer1.0-plugins-ugly-amrnb \
    gstreamer1.0-plugins-ugly-amrwbdec \
    gstreamer1.0-plugins-ugly-asf \
    gstreamer1.0-plugins-ugly-cdio \
    gstreamer1.0-plugins-ugly-dvdsub \
    gstreamer1.0-plugins-ugly-mad \
    gstreamer1.0-plugins-ugly-amrwb \
    gstreamer1.0-plugins-ugly-dvdread \
    "

# DVD playback is integrated, we need the libraries
RDEPENDS_${PN} += " \
    libdreamdvd \
    "

RRECOMMENDS_${PN} += "libdvdcss"

# We depend on the font which we use for TXT subtitles (defined in skin_subtitles.xml)
RDEPENDS_${PN} += "font-valis-enigma"

RDEPENDS_${PN} += "${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbc", "virtual/blindscan-dvbc" , "", d)}"

#make sure default skin is installed.
RDEPENDS_${PN} += "${E2DEFAULTSKIN} "

DEMUXTOOL ?= "replex"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "python-twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "python-twisted-web"
DESCRIPTION_append_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "python-twisted-mail python-twisted-names python-compression python-mime python-email"
DESCRIPTION_append_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
DESCRIPTION_append_enigma2-plugin-extensions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
# Note that these tools lack recipes
RDEPENDS_enigma2-plugin-extensions-dvdburn = "dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging ${DEMUXTOOL}"
RDEPENDS_enigma2-plugin-systemplugins-hotplug = "hotplug-e2-helper"
CONFFILES_enigma2-plugin-extensions-openxtareader = "/usr/lib/enigma2/python/Plugins/Extensions/OpenXtaReader/db/favoriten"
RDEPENDS_enigma2-plugin-extensions-openxtareader = "python-lxml"
RDEPENDS_enigma2-plugin-systemplugins-fsblupdater = "python-distutils"

inherit autotools-brokensep gitpkgv pkgconfig pythonnative

PV = "${IMAGE_VERSION}+git${SRCPV}"
PKGV = "${IMAGE_VERSION}+git${GITPKGV}"
PR = "r8"

SRC_URI = "${ENIGMA2_URI}"

SRC_URI_append_azboxhd = " \
    file://azboxe2.patch \
    file://lcdchar.patch \
    file://e2_pcr.patch \
    file://add_more_timeout.patch \
    file://pic_show.patch \
    ${@bb.utils.contains("DISTRO_NAME", "openatv", "file://azboxHDe2py.patch", "", d)} \
    "
SRC_URI_append_azboxme = " \
    file://azboxe2.patch \
    file://e2_pcr.patch \
    file://add_more_timeout.patch \
    file://pic_show.patch \
    ${@bb.utils.contains("DISTRO_NAME", "openatv", "file://azboxMEe2py.patch", "", d)} \
    "
SRC_URI_append_azboxminime = " \
    file://azboxe2.patch \
    file://e2_pcr.patch \
    file://add_more_timeout.patch \
    file://pic_show.patch \
    ${@bb.utils.contains("DISTRO_NAME", "openatv", "file://azboxMEe2py.patch", "", d)} \
    "
SRC_URI_append_vuduo = " \
    file://duo_VFD.patch \
    "

SRC_URI_append_openatv = " \
    file://tuxbox_fix_DVB_API_VERSION_check_for_gcc5.patch \
    "

SRC_URI_append_wetekplay2 = " \
    ${@bb.utils.contains("DISTRO_NAME", "openatv", "file://0001-have-64-bit-action-long-int-update.patch", "", d)} \
    "

SRC_URI_append_odroidc2 = " \
    ${@bb.utils.contains("DISTRO_NAME", "openatv", "file://0001-have-64-bit-action-long-int-update.patch", "", d)} \
    "

SRC_URI_append_openhdf = " \
    file://tuxbox_fix_DVB_API_VERSION_check_for_gcc5.patch \
    "
SRC_URI_append_opennfr = " \
    file://tuxbox_fix_DVB_API_VERSION_check_for_gcc5.patch \
    "
SRC_URI_append_opendroid = " \
    file://tuxbox_fix_DVB_API_VERSION_check_for_gcc5.patch \
    "
SRC_URI_append_egami = " \
    file://tuxbox_fix_DVB_API_VERSION_check_for_gcc5.patch \
    "
SRC_URI_append_openxta = " \
    file://tuxbox_fix_DVB_API_VERSION_check_for_gcc5.patch \
    "

SRC_URI_append_openspa = " \
    file://skin_default.patch \
    "

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES =+ "${PN}-src"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINEBUILD}"

PACKAGES =+ "enigma2-fonts"
FILES_enigma2-fonts = "${datadir}/fonts"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-boxtype=${MACHINE} \
    --with-machinebuild="${MACHINEBUILD}" \
    --with-libsdl=no \
    --enable-dependency-tracking \
    ${@bb.utils.contains("GST_VERSION", "1.0", "--with-gstversion=1.0", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "textlcd", "--with-textlcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd", "--with-colorlcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd128", "--with-colorlcd128" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd220", "--with-colorlcd220" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd400", "--with-colorlcd400" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd480", "--with-colorlcd480" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd720", "--with-colorlcd720" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "colorlcd800", "--with-colorlcd800" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "bwlcd96", "--with-bwlcd96" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "bwlcd128", "--with-bwlcd128" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "bwlcd140", "--with-bwlcd140" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "bwlcd255", "--with-bwlcd255" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "fullgraphiclcd", "--with-fullgraphiclcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "gigabluelcd", "--with-gigabluelcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "nolcd", "--with-nolcd" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "--with-libvugles2" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "--with-osdanimation" , "", d)} \
    "

LDFLAGS_prepend = "${@bb.utils.contains('GST_VERSION', '1.0', ' -lxml2 ', '', d)}"

# Swig generated 200k enigma.py file has no purpose for end users
FILES_${PN}-dbg += "\
    /usr/lib/enigma2/python/enigma.py \
    "

# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES_${PN}-dbg += "\
    /usr/lib/enigma2/python/*/.debug \
    /usr/lib/enigma2/python/*/*/*.debug \
    /usr/lib/enigma2/python/*/*/*/.debug \
    /usr/lib/enigma2/python/*/*/*/*/.debug \
    /usr/lib/enigma2/python/Plugins/*/*/.debug \
    "

# Save some space by not installing sources (mytest.py must remain)
FILES_${PN}-src = "\
    /usr/lib/enigma2/python/GlobalActions.py \
    /usr/lib/enigma2/python/Navigation.py \
    /usr/lib/enigma2/python/NavigationInstance.py \
    /usr/lib/enigma2/python/RecordTimer.py \
    /usr/lib/enigma2/python/ServiceReference.py \
    /usr/lib/enigma2/python/SleepTimer.py \
    /usr/lib/enigma2/python/e2reactor.py \
    /usr/lib/enigma2/python/keyids.py \
    /usr/lib/enigma2/python/keymapparser.py \
    /usr/lib/enigma2/python/skin.py \
    /usr/lib/enigma2/python/timer.py \
    /usr/lib/enigma2/python/upgrade.py \
    /usr/lib/enigma2/python/PowerTimer.py \
    /usr/lib/enigma2/python/*/*.py \
    /usr/lib/enigma2/python/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*.py \
    "

FILES_${PN} += " \
    ${bindir} ${sysconfdir}/e2-git.log"

# Save po files
PACKAGES =+ "${PN}-po"
FILES_${PN}-po = "${datadir}/enigma2/po/*.po ${datadir}/enigma2/po/*.pot"

do_install_append() {
    install -d ${D}/usr/share/keymaps
    find ${D}/usr/lib/enigma2/python/ -name '*.pyc' -exec rm {} \;
    ln -s /usr/lib/enigma2/python/Tools/StbHardware.pyo ${D}/usr/lib/enigma2/python/Tools/DreamboxHardware.pyo
    ln -s /usr/lib/enigma2/python/Components/PackageInfo.pyo ${D}/usr/lib/enigma2/python/Components/DreamboxInfoHandler.pyo
    install -d ${D}${sysconfdir}
    git --git-dir=${S}/.git log --since=10.weeks --pretty=format:"%s" > ${D}${sysconfdir}/e2-git.log
    git --git-dir=${S}/.git log --since=10.weeks --pretty=format:"%s" > ${D}${sysconfdir}/oe-git.log
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)

    enigma2_podir = bb.data.expand('${datadir}/enigma2/po', d)
    do_split_packages(d, enigma2_podir, '^(\w+)/[a-zA-Z0-9_/]+.*$', 'enigma2-locale-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
}
