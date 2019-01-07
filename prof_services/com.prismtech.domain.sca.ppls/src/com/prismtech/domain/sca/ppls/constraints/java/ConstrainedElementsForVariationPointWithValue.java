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
 * Variation Point With Value are of the proper types.
 * 
 * @author mciobanu
 * 
 */

public class ConstrainedElementsForVariationPointWithValue extends AbstractModelConstraint{
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
				if( s.getQualifiedName().equals(PLMNames.VARIATION_POINT_WITH_VALUE)){
					for (Element constrainedElement : ((Constraint) element)
							.getConstrainedElements()) {
						if (!(ZDLUtil.isZDLConcept(constrainedElement,SCANames.SCAPROPERTY))) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
