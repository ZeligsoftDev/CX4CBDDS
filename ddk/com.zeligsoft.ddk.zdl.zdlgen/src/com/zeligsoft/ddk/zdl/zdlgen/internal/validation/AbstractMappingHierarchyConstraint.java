/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.validation;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory;

/**
 * @author prismtech
 *
 */
public class AbstractMappingHierarchyConstraint extends AbstractModelConstraint {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		final EObject eObj = ctx.getTarget();
		final EMFEventType eType = ctx.getEventType();
		
		if(eType == EMFEventType.NULL) {
			if(eObj instanceof GenDomainConcept) {
				final GenDomainConcept genDomainConcept = (GenDomainConcept) eObj;
				if(genDomainConcept.getCategory() == GenDomainConceptCategory.ABSTRACT) {
					final List<GenDomainConcept> generals = genDomainConcept.allGenerals();
					
					for(GenDomainConcept g : generals) {
						if(g.getCategory() != GenDomainConceptCategory.ABSTRACT) {
							return ctx.createFailureStatus(genDomainConcept);
						}
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}

}
