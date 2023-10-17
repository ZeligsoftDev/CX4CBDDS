/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink (CEA LIST) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Perform the validation of delegated OCL constraints and invariants.
 * <p>
 * This class is largely a clone of EObjectValidator$DynamicEClassValidator
 */
public class OCLDelegateValidator extends EObjectValidator
{
	protected static void reportInvariantDelegateViolation(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context, EOperation invariant, int severity, String source, int code) {
		String contextName = invariant.getEContainingClass().getName() + "::" + invariant.getName();
		diagnostics.add(new BasicDiagnostic(severity, source, code,
			EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[]{contextName, getObjectLabel(eObject, context)}),
			new Object[]{eObject}));
	}

	protected final @Nullable EObjectValidator eValidator;

	public OCLDelegateValidator(@Nullable EObjectValidator eValidator) {
		this.eValidator = eValidator;
//		PivotUtilInternal.debugPrintln("Create " + NameUtil.debugSimpleName(this));	
	}

	protected void reportWrappedException(@Nullable Object object, @NonNull DiagnosticChain diagnostics, Map<Object, Object> context,
			int severity, String source, int code, @NonNull WrappedException wrappedException) {
		String message = wrappedException.getLocalizedMessage();
		Exception exception = wrappedException.exception();
		if (exception == null) {
			exception = wrappedException;
		}
		else {
			assert message != null;
//			message = exception.getLocalizedMessage();
//			Throwable nestedException = exception.getCause();
//			if ((nestedException != null) && !(exception instanceof EvaluationException)) {
//				message = message + "\n - " + nestedException.getLocalizedMessage();
//			}
		}
		diagnostics.add(new BasicDiagnostic(severity, source, code, message, new Object[]{object, exception}));
	}

	@Override
	protected boolean validate(int classifierID, Object object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (classifierID != EcorePackage.EOBJECT) {
			return true;
		}
		else if (eValidator != null) {
			return eValidator.validate_EveryDefaultConstraint((EObject) object, diagnostics, context);
		}
		else {
			return validate_EveryDefaultConstraint((EObject) object, diagnostics, context);
		}
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		PivotUtilInternal.debugPrintln("Validating " + LabelUtil.getLabel(eClass));	
		assert eClass != null;
		assert eObject != null;
		boolean result = validateDelegatedInvariants(eClass, eObject, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validateDelegatedConstraints(eClass, eObject, diagnostics, context);
			if (result || diagnostics != null) {
				List<EClass> eSuperTypes = eClass.getESuperTypes();
				result &= eSuperTypes.isEmpty()
					? validate_EveryDefaultConstraint(eObject, diagnostics, context)
					: eClass.eContainer() == getEPackage()
						? validate(eClass.getClassifierID(), eObject, diagnostics, context)
						: validate(eSuperTypes.get(0), eObject, diagnostics, context);
			}
		}
//		PivotUtilInternal.debugPrintln("Validated " + LabelUtil.getLabel(eClass));	
		return result;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context,
			String validationDelegate, String constraint, String expression, int severity, String source, int code) {
		assert eClass != null;
		assert eObject != null;
		assert constraint != null;
		assert validationDelegate != null;
		return validateDelegatedConstraint(eClass, eObject, diagnostics, context, validationDelegate, constraint, expression, severity, source, code);
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context, String validationDelegate, String constraint, String expression, int severity,
			String source, int code) {
		assert eDataType != null;
		assert value != null;
		assert constraint != null;
		assert validationDelegate != null;
		return validateDelegatedConstraint(eDataType, value, diagnostics, context, validationDelegate, constraint, expression, severity, source, code);
	}

	protected boolean validateDelegatedConstraints(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		List<String> validationDelegates = EcoreUtil.getValidationDelegates(eClass.getEPackage());
		if (!validationDelegates.isEmpty()) {
			CONSTRAINTS : for (String constraint : EcoreUtil.getConstraints(eClass)) {
				if (constraint != null) {
					for (String validationDelegate : validationDelegates) {
						if (validationDelegate != null) {
							String expression = EcoreUtil.getAnnotation(eClass, validationDelegate, constraint);
							if (expression != null) {
								result &= validateDelegatedConstraint(eClass, eObject, diagnostics, context, validationDelegate,
									constraint, expression, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
								if (!result && diagnostics == null)
									break CONSTRAINTS;
							}
						}
					}
				}
			}
		}
		return result;
	}

	public boolean validateDelegatedConstraint(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String validationDelegate, @NonNull String constraint, String expression, int severity, String source, int code) {
		ValidationDelegate delegate = getValidationDelegateRegistry(context).getValidationDelegate(validationDelegate);
		if (delegate != null) {
			try {
				if (delegate instanceof ValidationDelegateExtension) {
					return ((ValidationDelegateExtension) delegate).validate(eClass, eObject, diagnostics, context, constraint, expression, severity, source, code);
				}
				if (!delegate.validate(eClass, eObject, context, constraint, expression)) {
					if (diagnostics != null)
						reportConstraintDelegateViolation(eClass, eObject, diagnostics, context, constraint, severity, source, code);
					return false;
				}
			} 
			catch (WrappedException e) {
				if (diagnostics != null) {
					reportWrappedException(eObject, diagnostics, context, severity, source, code, e);
				}
			} 
			catch (Throwable throwable) {
				if (diagnostics != null) {
					reportConstraintDelegateException(eClass, eObject, diagnostics, context, constraint, severity, source, code, throwable);
				}
			}
		} else {
			if (diagnostics != null) {
				reportConstraintDelegateNotFound(eClass, eObject, diagnostics, context, constraint, severity, source, code, validationDelegate);
			}
		}
		return true;
	}

	public boolean validateDelegatedConstraint(@NonNull EDataType eDataType, @NonNull Object value, DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String validationDelegate, @NonNull String constraint, String expression, int severity, String source, int code) {
		ValidationDelegate delegate = getValidationDelegateRegistry(context).getValidationDelegate(validationDelegate);
		if (delegate != null) {
			try {
				if (delegate instanceof ValidationDelegateExtension) {
					return ((ValidationDelegateExtension) delegate).validate(eDataType, value, diagnostics, context, constraint, expression, severity, source, code);
				}
				if (!delegate.validate(eDataType, value, context, constraint, expression)) {
					if (diagnostics != null) {
						reportConstraintDelegateViolation(eDataType, value, diagnostics, context, constraint, severity, source, code);
					}
					return false;
				}
			}
			catch (WrappedException e) {
				if (diagnostics != null) {
					reportWrappedException(value, diagnostics, context, severity, source, code, e);
				}
			} 
			catch (Throwable throwable) {
				if (diagnostics != null) {
					reportConstraintDelegateException(eDataType, value, diagnostics, context, constraint, severity, source, code, throwable);
				}
			}
		} else {
			if (diagnostics != null) {
				reportConstraintDelegateNotFound(eDataType, value, diagnostics, context, constraint, severity, source, code, validationDelegate);
			}
		}
		return true;
	}

	protected boolean validateDelegatedInvariants(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		List<String> validationDelegates = EcoreUtil.getValidationDelegates(eClass.getEPackage());
		if (!validationDelegates.isEmpty()) {
			INVARIANTS : for (EOperation eOperation : eClass.getEOperations()) {
				if ((eOperation != null) && EcoreUtil.isInvariant(eOperation)) {
					for (String validationDelegate : validationDelegates) {
						if (validationDelegate != null) {
							String expression = EcoreUtil.getAnnotation(eOperation, validationDelegate, "body");
							if (expression != null) {
								result &= validateDelegatedInvariant(eClass, eObject, diagnostics, context,
									validationDelegate, eOperation, expression, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
								if (!result && diagnostics == null)
									break INVARIANTS;
							}
						}
					}
				}
			}
		}
		return result;
	}

	public boolean validateDelegatedInvariant(@NonNull EClass eClass, @NonNull EObject eObject, @Nullable DiagnosticChain diagnostics, Map<Object, Object> context,
			@NonNull String validationDelegate, @NonNull EOperation invariant, @NonNull String expression, int severity, String source, int code) {
		ValidationDelegate delegate = getValidationDelegateRegistry(context) .getValidationDelegate(validationDelegate);
		if (delegate != null) {
			try {
				if (delegate instanceof ValidationDelegateExtension) {
					return ((ValidationDelegateExtension) delegate).validate(eClass, eObject, diagnostics, context, invariant, expression, severity, source, code);
				}
				if (!delegate.validate(eClass, eObject, context, invariant, expression)) {
					if (diagnostics != null) {
						reportInvariantDelegateViolation(eClass, eObject, diagnostics, context, invariant, severity, source, code);
					}
					return false;
				}
			} catch (WrappedException e) {
				if (diagnostics != null) {
					reportWrappedException(eObject, diagnostics, context, severity, source, code, e);
				}
			} catch (Throwable throwable) {
				if (diagnostics != null) {
					reportInvariantDelegateException(eClass, eObject, diagnostics, context, invariant, severity, source, code, throwable);
				}
			}
		} else {
			if (diagnostics != null) {
				reportInvariantDelegateNotFound(eClass, eObject, diagnostics, context, invariant, severity, source, code, validationDelegate);
			}
		}
		return true;
	}
}
