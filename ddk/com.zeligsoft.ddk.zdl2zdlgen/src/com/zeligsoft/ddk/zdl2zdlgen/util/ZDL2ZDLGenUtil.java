package com.zeligsoft.ddk.zdl2zdlgen.util;

import java.net.URL;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ZDL2ZDLGenUtil {

	public static String getAbsoluteIconUri(org.eclipse.uml2.uml.Class iconProvider) {

		URL icon = ZDLUtil.getIcon(iconProvider);
		if(icon != null) {
			return icon.toString();
		}
		return null;
	}
}
