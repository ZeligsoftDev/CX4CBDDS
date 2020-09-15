package com.zeligsoft.domain.omg.corba.api.extensions

import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface
import java.util.List
import com.zeligsoft.base.zdl.staticapi.util.ZListExtensions
import com.google.inject.Inject

class CORBAInterfaceExtensions {
    @Inject extension ZListExtensions
	def List<CXInterface> generals(CXInterface intf) {
	    intf.asInterface.generals.typeSelect(CXInterface::type)
	} 
}