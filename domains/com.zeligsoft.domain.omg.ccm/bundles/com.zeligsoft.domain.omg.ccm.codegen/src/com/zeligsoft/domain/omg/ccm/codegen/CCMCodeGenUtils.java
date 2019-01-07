package com.zeligsoft.domain.omg.ccm.codegen;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class CCMCodeGenUtils {

	public static org.eclipse.uml2.uml.Interface getSupportedInterface(Component comp) {
		
		if( ZDLUtil.isZDLConcept(comp, CCMNames.MONOLITHIC_IMPLEMENTATION)) {
			org.eclipse.uml2.uml.Class CCMComponent = comp.getSuperClasses().get(0);
			if( ZDLUtil.isZDLConcept(CCMComponent, CCMNames.CCMCOMPONENT)) {
				if( CCMComponent.getInterfaceRealizations().size() > 0 ) {
					return CCMComponent.getInterfaceRealizations().get(0).getContract();
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Scans the component to see if its component interface has provide ports with a specified interface.  It 
	 * returns a list of all the provide ports with that interface.
	 * 
	 * @param comp
	 * @param interfaceName
	 * @return
	 */
	public static Collection<Port> getProvidesPortsWithInterface(Component comp, Interface inter)
	{
		ArrayList<Port> portList = new ArrayList<Port>();
		
		for (Port port: comp.getSuperClasses().get(0).getOwnedPorts())
		{
			if (ZDLUtil.isZDLConcept(port, ZMLMMNames.MESSAGE_PORT))
			{
				for (Interface inter2 : port.getProvideds())
				{
					if( inter2 == inter || inter2.allParents().contains(inter))
						portList.add(port);
				}
			}
		}				
		
		return portList;
	}
}
