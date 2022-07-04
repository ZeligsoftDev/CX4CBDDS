package com.zeligsoft.domain.ngc.ccm.descriptorgeneration.utils;

import org.eclipse.uml2.uml.Property;

import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;


public class FilterUtil {

	public static boolean filterPort(Property perPort, Property port) {
		return IDL3PlusUtil.filter(perPort, port);
	}

}
