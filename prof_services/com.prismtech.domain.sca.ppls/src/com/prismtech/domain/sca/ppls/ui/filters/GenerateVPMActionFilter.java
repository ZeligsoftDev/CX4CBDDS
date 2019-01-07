/**
 * The Software and documentation are Copyright 2013 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.ui.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;

/**
 * Filter used to decide whether or not to show the "Generate Variation Point Model" 
 * context menu item based on the presence of the VariationPointProfile on the model 
 * and add it to the Generate All workflow
 * 
 * @author mciobanu
 * 
 */
public class GenerateVPMActionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if (toTest != null) {
			if (toTest instanceof Model) {
				for (Profile p : ((Model) toTest).getAllAppliedProfiles()) {
					if (!UMLUtil.isEmpty(p.getName())) {
						if (p.getName()
								.equals(PLMNames.VARIATION_POINT_PROFILE)) {
							return true;
						}
					}
				}
			} else if ((toTest instanceof Element)
					&& (ZDLUtil.isZDLConcept((EObject) toTest,
							SCANames.SCAASSEMBLY) || ZDLUtil.isZDLConcept(
							(EObject) toTest, SCANames.SCAPLATFORM))) {
				if (ZDLUtil.getZDLProfiles((Element) toTest).size() > 0) {
					for (ProfileApplication p : ((Element) toTest).getModel()
							.getAllProfileApplications()) {
						if (!UMLUtil.isEmpty(p.getAppliedProfile().getName())) {
							if (p.getAppliedProfile().getName()
									.equals(PLMNames.VARIATION_POINT_PROFILE)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
