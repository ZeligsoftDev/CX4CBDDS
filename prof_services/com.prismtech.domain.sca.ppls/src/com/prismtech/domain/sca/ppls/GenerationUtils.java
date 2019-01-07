/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.prismtech.domain.sca.ppls.utils.PLMUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.zml.util.ZMLUtil;

/**
 * Static helpers for oAW transformations defined in this plug-in. 
 * 
 * @author smcfee
 */
public class GenerationUtils {

	/**
	 * Our typical printf debugging method.
	 * 
	 * @param o
	 */
	public static void debug(Object o) {
		System.out.println("***************** DEBUG ******************** "); //$NON-NLS-1$
		System.out.println(o);
		System.out.println("*************** END DEBUG ****************** "); //$NON-NLS-1$
	}
	
	/**
	 * Get the URI for the model in which a CX model element is stored.
	 * 
	 * @param e
	 * @return
	 */
	public static String getSource(Element e) {
		return e.eResource().getURI().toString();
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static List<Artifact> getImplementation(Component c) {
		return ZMLUtil.getComponentImplementations(c);
	}
	
	/**
	 * Helper method to retrieve the settable attributes for a variation point with settings in the VPModel.
	 * </br>
	 * Add pertaining attributes for constrained elements here. 
	 * @param e element for which to add specific attributes
	 * @return attributes which are to be set in a variation point with settings
	 */
	public static List<String> getAttributesFromElement(Element e){
		List<String> attributes = new ArrayList<String>();
		if(ZDLUtil.isZDLConcept(e, SCANames.SCAPLATFORM_ELEMENT_PART)){
			attributes.add(SCANames.SCAPLATFORM_ELEMENT_PART__DEPLOYONDEVICE);
		}else if(ZDLUtil.isZDLConcept(e, SCANames.SCAASSEMBLY)){
			if(ZDLUtil.isZDLConcept(e, SCANames.SCAAPPLICATION)){
				attributes.add(SCANames.SCAAPPLICATION___SADFILE_NAME);
			}else if(ZDLUtil.isZDLConcept(e, SCANames.SCANODE)){
				attributes.add(SCANames.SCANODE___DCDFILE_NAME);
				attributes.add(SCANames.SCANODE__NAMINGSERVICE);
			}	
		}else if(ZDLUtil.isZDLConcept(e, SCANames.PROPERTY_PROVIDER)){
			attributes.add(SCANames.PROPERTY_PROVIDER___PRFFILE_NAME);
			if(ZDLUtil.isZDLConcept(e, SCANames.SCASOFTWARE_PACKAGE)){
				attributes.add(SCANames.SCASOFTWARE_PACKAGE___SPDFILE_NAME);
				attributes.add(SCANames.SCANAMED_ELEMENT__NAME);
			}else if(ZDLUtil.isZDLConcept(e, SCANames.SCAIMPLEMENTATION)){
				attributes.add(SCANames.SCABINARY__FILE);
				attributes.add(SCANames.SCABINARY__PRIORITY);
			}else if(ZDLUtil.isZDLConcept(e, SCANames.SCACOMPONENT_INTERFACE)){
				attributes.add(SCANames.SCACOMPONENT_INTERFACE___SCDFILE_NAME);
			}
		}else if(ZDLUtil.isZDLConcept(e, SCANames.SCAFREE_STANDING_PORT)){
			attributes.add(SCANames.SCAFREE_STANDING_PORT__FINDBY_PORT_NAME);
			if(ZDLUtil.isZDLConcept(e, SCANames.SCAFINDBY_FREE_STANDING_PORT)){
				attributes.add(SCANames.SCAFINDBY_FREE_STANDING_PORT__FINDBY_ELEMENT_NAME);
			}
		}
		return attributes;
	}
	
	/**
	 * Helper method to retrieve the unique id from a constraint with variation point stereotype applied
	 * @param c - constraint to check for applied variation point stereotype
	 * @return the unique id of the constraint
	 */
	public static String getIDfromVariationPoint(Constraint c){
		for(Stereotype s : c.getAppliedStereotypes()){
			if (s.getQualifiedName().equals(PLMNames.VARIATION_POINT)
					|| s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_VALUE)
					|| s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_SETTINGS)){
				return c.getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString();
			}
		}
		return null;
	}
	
	/**
	 * Helper method to retrieve the variation point constraining an element
	 * @param e - constrained element 
	 * @return variation point constraining the element
	 */
	public static List<Element> getConstraints(Element e){	
		return PLMUtil.getConstraints(e);
	}
	
}
