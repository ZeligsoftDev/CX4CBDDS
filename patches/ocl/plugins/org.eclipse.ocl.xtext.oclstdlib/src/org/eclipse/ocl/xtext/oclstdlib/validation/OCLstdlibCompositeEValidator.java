/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.xtext.validation.CompositeEValidator;

public class OCLstdlibCompositeEValidator extends CompositeEValidator
{
	@Override
	public boolean validate(EObject csObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (csObject instanceof Pivotable) {
			EObject pivotObject = ((Pivotable)csObject).getPivot();
			if (pivotObject != null) {
				return super.validate(pivotObject, diagnostics, context);
			}
		}
		return super.validate(csObject, diagnostics, context);
	}

	@Override
	public boolean validate(EClass eClass, EObject csObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (csObject instanceof Pivotable) {
			EObject pivotObject = ((Pivotable)csObject).getPivot();
			if (pivotObject != null) {
				return super.validate(pivotObject.eClass(), pivotObject, diagnostics, context);
			}
		}
		return super.validate(eClass, csObject, diagnostics, context);
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return super.validate(eDataType, value, diagnostics, context);
	}
}
