/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.validation;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateValidator;

/**
 * A OCLinEcoreEObjectValidator enhances the standard EObjectValidator to allow validation failures
 * to obtain a corresponding diagnostic from the validation delegate rather using the default
 * delegate exception message.
 *
 * This class may go obsolete once Bug 337792 resolved.
 */
public class OCLinEcoreEObjectValidator extends OCLDelegateValidator
{
	public OCLinEcoreEObjectValidator() {
		super(null);
	}

	// Overridden to invoke OCLDelegateValidator
	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (eObject.eIsProxy()) {
			if (context != null && context.get(ROOT_OBJECT) != null) {
				if (diagnostics != null) {
					diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
							EOBJECT__EVERY_PROXY_RESOLVES, "_UI_UnresolvedProxy_diagnostic",
							new Object[] {
								getFeatureLabel(eObject.eContainmentFeature(), context),
								getObjectLabel(eObject.eContainer(), context),
								getObjectLabel(eObject, context) },
							new Object[] {
								eObject.eContainer(),
								eObject.eContainmentFeature(),
								eObject },
							context));
				}
				return false;
			} else {
				return true;
			}
		}
		else if (eClass.eContainer() == getEPackage()) {
			return validate(eClass.getClassifierID(), eObject, diagnostics, context);
		}
		else {
			return new OCLDelegateValidator(this) {
				// Ensure that the class loader for this class will be used downstream.
			}.validate(eClass, eObject, diagnostics, context);
		}
	}
}
