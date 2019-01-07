/**
 * The Software and documentation are Copyright 2012 Prismtech Canada Inc. All rights reserved. 
 */

package com.prismtech.domain.sca.ppls.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;

/**
 * Variation Point Constraint verifying whether the constrained elements of a
 * Variation Point With Settings are of the proper types.
 * 
 * @author mciobanu
 * 
 */

public class ConstrainedElementsForVariationPointWithSettings extends AbstractModelConstraint{
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();
		
		if (!containsValidConstrainedElements(objToVerify)) {
			return ctx.createFailureStatus(new Object[] {((NamedElement) objToVerify).getName()});
		}
		
		return ctx.createSuccessStatus();
	}
	
	private boolean containsValidConstrainedElements(EObject element) {
		if (element instanceof Constraint) {
			for (Stereotype s : ((Constraint) element).getAppliedStereotypes()) {
				if( s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_SETTINGS)){
					for (Element constrainedElement : ((Constraint) element)
							.getConstrainedElements()) {
						if (!(ZDLUtil.isZDLConcept(constrainedElement,SCANames.SCAPLATFORM_ELEMENT_PART)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.PROPERTY_PROVIDER)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.SCAASSEMBLY)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.SCAFREE_STANDING_PORT))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
