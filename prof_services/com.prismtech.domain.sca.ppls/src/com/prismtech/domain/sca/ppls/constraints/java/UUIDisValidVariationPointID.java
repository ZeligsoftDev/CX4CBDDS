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
import com.prismtech.domain.sca.ppls.utils.PLMUtil;

/**
 * Variation Point Constraint verifying whether the UUID generated for the
 * VariationPoint is of the valid format
 * 
 * @author mciobanu
 * 
 */

public class UUIDisValidVariationPointID extends AbstractModelConstraint{
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();
		
		if (!containsValidVPUUID(objToVerify)) {
			return ctx.createFailureStatus(new Object[] {((NamedElement) objToVerify).getName()});
		}
		
		return ctx.createSuccessStatus();
	}
	
	private boolean containsValidVPUUID(EObject element) {
		if (element instanceof Constraint) {
			if(PLMUtil.isPLMConcept(element)){
				for (Stereotype s : ((Constraint) element).getAppliedStereotypes()) {
					String qualifiedName = s.getQualifiedName(); 
					if (qualifiedName.equals(PLMNames.VARIATION_POINT)
							|| qualifiedName.equals(PLMNames.VARIATION_POINT_WITH_VALUE)
							|| qualifiedName.equals(PLMNames.VARIATION_POINT_WITH_SETTINGS)) {						
							String uuid = ((Element) element).getValue(s, PLMNames.VARIATION_POINT__VP_ID).toString();
						if(!uuid.matches("VP-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")){ //$NON-NLS-1$
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
