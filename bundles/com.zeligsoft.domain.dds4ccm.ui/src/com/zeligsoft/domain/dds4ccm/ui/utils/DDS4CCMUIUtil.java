package com.zeligsoft.domain.dds4ccm.ui.utils;

public class DDS4CCMUIUtil {
	public static boolean isAxciomaSupported(){
		boolean isAxciomaSupported = true;
		try {
			Class axciomaClass = Class.forName("com.zeligsoft.domain.dds4ccm.ui.axcioma.AxciomaSupport");
			if(axciomaClass == null){
				isAxciomaSupported = false;
			}
		} catch (ClassNotFoundException e) {
			isAxciomaSupported = false;
		}
		return isAxciomaSupported;
	}
}
