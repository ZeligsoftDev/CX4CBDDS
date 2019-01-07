package com.zeligsoft.domain.omg.corba.api.extensions

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface
import java.util.List
import com.zeligsoft.base.zdl.staticapi.util.ZListExtensions
import com.google.inject.Inject

class CORBAInterfaceExtensions {
    @Inject extension ZListExtensions
	def List<CORBAInterface> generals(CORBAInterface self) {
	    self.asInterface.generals.typeSelect(CORBAInterface::type)
	} 
}