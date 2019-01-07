/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.ui.menus.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.uml.navigator.ModelServerElement;
import com.prismtech.domain.sca.ppls.Activator;
import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.ui.menus.providers.DomainSpecificMenuProvider;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * PLM menu property tester to test if the Add PLM menu should be visible
 * 
 * @author mciobanu
 * 
 */

public class PLMMenuPropertyTester extends PropertyTester {

	@SuppressWarnings("unchecked")
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {		
		
		if(Activator.checkLicense().isOK()){
			EObject testObject = null;
			Object element;
			if(receiver instanceof List){
				if (!((List<Object>) receiver).isEmpty()) {
					if(((List<Object>) receiver).size() > 1){
						return false;
					}
					Object obj = ((List<Object>) receiver).get(0);
					
					if (obj instanceof ModelServerElement) {
						element = ((ModelServerElement) obj).getElement();
						if (element instanceof EObject) {
							testObject = (EObject) element;
						}
					}else if (obj instanceof IGraphicalEditPart){
						IGraphicalEditPart part = (IGraphicalEditPart)obj;
						element = part.getNotationView().getElement();
						if (element instanceof EObject) {
							testObject = (EObject)element;
						}
					}
				}	
			}
			if (testObject != null) {
				if (testObject instanceof Model){
					// We always want to show the 'Add PLM' menu on a Model, to allow the user to enable the PLM Capability
					return true;
				}
				if (testObject instanceof Element) {
					
					if (ZDLUtil.getZDLProfiles((Element) testObject).size() > 0) {
						boolean foundVPProfile = false;
						for( ProfileApplication p : ((Element)testObject).getModel().getAllProfileApplications()) {
							if( !UMLUtil.isEmpty(p.getAppliedProfile().getName())){
								if( p.getAppliedProfile().getName().equals(PLMNames.VARIATION_POINT_PROFILE)) {											
									// We want to show the 'Add PLM' menu for PLM 
									foundVPProfile = true;
									return true;
								}
							}
						}
						if(foundVPProfile==false){
							return false;
						}
					} else {
						return false;
					}
				}
							
				Collection<IContributionItem> menuItems = DomainSpecificMenuProvider
						.calculateContributionItems(testObject);
				if (menuItems.size() > 0) {
					return true;
				}
			}			
		}
		return false;
	}
}
