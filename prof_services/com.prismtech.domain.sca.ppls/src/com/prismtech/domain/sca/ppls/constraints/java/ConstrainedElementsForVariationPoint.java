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
import org.eclipse.uml2.uml.util.UMLUtil;

import com.prismtech.domain.sca.ppls.utils.PLMNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Variation Point Constraint verifying whether the constrained elements of a
 * Variation Point are of the proper types.
 * 
 * @author mciobanu
 * 
 */

public class ConstrainedElementsForVariationPoint extends AbstractModelConstraint{
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
				if( s.getQualifiedName().equals(PLMNames.VARIATION_POINT)){
					for (Element constrainedElement : ((Constraint) element)
							.getConstrainedElements()) {
						if (!((ZDLUtil.isZDLConcept(constrainedElement,SCANames.SCAPORT)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.SCANODE_PART)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.SCACOMPONENT_PART)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.SCAOPERATING_SYSTEM_DEPENDENCY) 
								|| ZDLUtil.isZDLConcept(constrainedElement,	SCANames.SCAPROCESSOR_DEPENDENCY)
								|| ZDLUtil.isZDLConcept(constrainedElement, SCANames.SCACONNECTOR)) 
								&& !UMLUtil.isEmpty((String) (ZDLUtil.getValue(constrainedElement, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME)))
								)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
