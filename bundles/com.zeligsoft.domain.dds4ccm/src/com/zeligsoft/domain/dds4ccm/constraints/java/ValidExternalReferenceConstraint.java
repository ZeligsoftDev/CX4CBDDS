/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.domain.dds4ccm.constraints.java;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * In a complete model, if a source port has delegation connectors to a set of
 * delegated target ports, then the union of the interfaces of these target
 * ports must be signature compatible with the interface that types the source
 * port.
 * 
 * @author ysroh
 * 
 */
public class ValidExternalReferenceConstraint extends AbstractModelConstraint {

	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		List<org.eclipse.uml2.uml.Class> concepts = ZDLUtil.getZDLConcepts(objToVerify);
		for (org.eclipse.uml2.uml.Class clazz : concepts) {
			for (Property p : clazz.getOwnedAttributes()) {
				if (p.getType() instanceof PrimitiveType) {
					// no need to check primitive types
					continue;
				}
				Object value = ZDLUtil.getRawValue(objToVerify, clazz, p.getName());
				if (value != null) {
					if (value instanceof List) {
						for (Object o : (List<Object>) value) {
							if (isPathmapProxy(o)) {
								return ctx.createFailureStatus(objToVerify, p.getName(), o.toString());
							}
						}
					} else {
						if (isPathmapProxy(value)) {
							return ctx.createFailureStatus(objToVerify, p.getName(), value.toString());
						}
					}
				}
			}
		}

		return ctx.createSuccessStatus();
	}


	private static boolean isPathmapProxy(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			if (eObject.eIsProxy()) {
				URI uri = ((MinimalEObjectImpl) eObject).eProxyURI();
				if ("pathmap".equals(uri.scheme())) { //$NON-NLS-1$
					return true;
				}
			}
		}
		return false;
	}
}
