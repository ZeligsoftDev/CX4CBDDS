#!/bin/sh

export LD_LIBRARY_PATH=/opt/cf/lib:/opt/eorb/lib/linux-gcc-x86:.
cd ../platform
BootLoader_g -DCD\_FILENAME DecryptorNode.dcd.xml -ORBInitRef NameService=corbaloc:iiop:1.2@127.0.1.1:2809/NameService -CFLogLevel D
