SUMMARY = "meta package for usbserial drivers"
RDEPENDS_${PN} = "kernel-module-usbserial kernel-module-ftdi-sio kernel-module-pl2303"
RRECOMMENDS_${PN} = "kernel-module-belkin-sa kernel-module-keyspan"

require conf/license/license-gplv2.inc

PV = "1.0"
PR = "r1"

ALLOW_EMPTY_${PN} = "1"
