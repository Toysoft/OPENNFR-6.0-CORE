DESCRIPTION = "Merge machine and distro options to create a enigma2 machine task/package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "6.0"
PR = "r2"

inherit packagegroup

DEPENDS = "opennfr-feeds"

RDEPENDS_${PN} = "\
    	enigma2-plugin-extensions-autotimer \
	enigma2-plugin-extensions-epgsearch \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-menusort \
	enigma2-plugin-extensions-customsubservices \
	enigma2-plugin-extensions-infopanel \
	enigma2-plugin-extensions-imdb \
	enigma2-plugin-extensions-mediaportal \
	enigma2-plugin-extensions-nfr4xboot \	
    	enigma2-plugin-extensions-epgimport \
	\
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-hotplug \
  	\
	enigma2-plugin-skins-utopia-hd \
	 \
	${@bb.utils.contains("MACHINE_FEATURES", "boxmodel", "boxmodel" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "webkithbbtv", "webkit-hbbtv-browser", "", d)} \
    	${@bb.utils.contains("MACHINE_FEATURES", "chromiumos", "enigma2-plugin-extensions-chromium", "", d)} \        
	"
