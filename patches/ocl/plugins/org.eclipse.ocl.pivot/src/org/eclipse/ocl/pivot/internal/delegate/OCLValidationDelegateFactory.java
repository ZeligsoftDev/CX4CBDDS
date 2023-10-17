/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * Factory for OCL derived-classifier validation delegates.
 */
public class OCLValidationDelegateFactory extends AbstractOCLDelegateFactory
		implements ValidationDelegate.Factory, ValidationDelegate
{
	public OCLValidationDelegateFactory(@NonNull String delegateURI) {
		super(delegateURI);
	}

	@Override
	public @Nullable ValidationDelegate createValidationDelegate(@NonNull EClassifier classifier) {
		EPackage ePackage = ClassUtil.nonNullEMF(classifier.getEPackage());
		OCLDelegateDomain delegateDomain = getDelegateDomain(ePackage);
		if (delegateDomain == null) {
			return null;
		}
		return new OCLValidationDelegate(delegateDomain, classifier);
	}

	protected @Nullable ValidationDelegate getValidationDelegate(@NonNull EClassifier eClassifier) {
		DelegateEClassifierAdapter ecAdapter = DelegateEClassifierAdapter.getAdapter(eClassifier);
		ValidationDelegate validationDelegate = ecAdapter.getValidationDelegate(delegateURI);
		return validationDelegate;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		if (eClass == null) {
			throw new NullPointerException("Null EClass");
		}
		ValidationDelegate validationDelegate = getValidationDelegate(eClass);
		if (validationDelegate == null) {
			throw new IllegalStateException("No '" + delegateURI + "' ValidationDelegate for '" + EObjectValidator.getObjectLabel(eObject, context) + "'");
		}
		return validationDelegate.validate(eClass, eObject, context, invariant, expression);
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		if (eClass == null) {
			throw new NullPointerException("Null EClass");
		}
		ValidationDelegate validationDelegate = getValidationDelegate(eClass);
		if (validationDelegate == null) {
			throw new IllegalStateException("No '" + delegateURI + "' ValidationDelegate for '" + EObjectValidator.getObjectLabel(eObject, context) + "'");
		}
		return validationDelegate.validate(eClass, eObject, context, constraint, expression);
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		if (eDataType == null) {
			throw new NullPointerException("Null EDataType");
		}
		ValidationDelegate validationDelegate = getValidationDelegate(eDataType);
		if (validationDelegate == null) {
			throw new IllegalStateException("No '" + delegateURI + "' ValidationDelegate for '" + EObjectValidator.getValueLabel(eDataType, value, context) + "'");
		}
		return validationDelegate.validate(eDataType, value, context, constraint, expression);
	}

	@Override
	public boolean validate(@NonNull EClass eClass, @NonNull EObject eObject,
			@Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull EOperation invariant, String expression, int severity, String source, int code) {
		ValidationDelegate validationDelegate = getValidationDelegate(eClass);
		if (validationDelegate == null) {
			throw new IllegalStateException("No '" + delegateURI + "' ValidationDelegate for '" + EObjectValidator.getObjectLabel(eObject, context) + "'");
		}
		return validationDelegate.validate(eClass, eObject, diagnostics, context, invariant, expression, severity, source, code);
	}

	@Override
	public boolean validate(@NonNull EClass eClass, @NonNull EObject eObject,
			@Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String constraint, String expression, int severity, String source, int code) {
		ValidationDelegate validationDelegate = getValidationDelegate(eClass);
		if (validationDelegate == null) {
			throw new IllegalStateException("No '" + delegateURI + "' ValidationDelegate for '" + EObjectValidator.getObjectLabel(eObject, context) + "'");
		}
		return validationDelegate.validate(eClass, eObject, diagnostics, context, constraint, expression, severity, source, code);
	}

	@Override
	public boolean validate(@NonNull EDataType eDataType, @NonNull Object value,
			@Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String constraint, String expression, int severity, String source, int code) {
		ValidationDelegate validationDelegate = getValidationDelegate(eDataType);
		if (validationDelegate == null) {
			throw new IllegalStateException("No '" + delegateURI + "' ValidationDelegate for '" + EObjectValidator.getValueLabel(eDataType, value, context) + "'");
		}
		return validationDelegate.validate(eDataType, value, diagnostics, context, constraint, expression, severity, source, code);
	}

	/**
	 * The Global variant of the Factory delegates to a local ResourceSet factory if one
	 * can be located at the EOperation.Internal.InvocationDelegate.Factory.Registry
	 * by the DelegateResourceSetAdapter.
	 */
	public static class Global extends OCLValidationDelegateFactory
	{
		public static final @NonNull Global INSTANCE = new Global();
		
		public Global() {
			super(PivotConstants.OCL_DELEGATE_URI_PIVOT);
		}

		@Override
		public @Nullable ValidationDelegate createValidationDelegate(@NonNull EClassifier classifier) {
			Class<ValidationDelegate.Factory.@NonNull Registry> castClass = ValidationDelegate.Factory.Registry.class;
			ValidationDelegate.Factory.@Nullable Registry localRegistry = OCLDelegateDomain.getDelegateResourceSetRegistry(classifier, castClass, null);
			if (localRegistry != null) {
				ValidationDelegate.Factory factory = localRegistry.getValidationDelegate(delegateURI);
				if (factory != null) {
					return factory.createValidationDelegate(classifier);
				}
			}
			return super.createValidationDelegate(classifier);
		}	
	}
}
