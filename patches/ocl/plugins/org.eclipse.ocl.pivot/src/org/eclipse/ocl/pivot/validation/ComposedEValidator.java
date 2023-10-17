/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A ComposedEValidator supports validation over a list of EValidators, validation terminating prematurely at
 * the first child EValidator that returns false.
 * <p>
 * A ComposedEValidator may be installed to displace an EValidator.Registry.INSTANCE entry. This in itself is
 * harmless but since the EValidator.Registry.INSTANCE is global, any additional EValidators added to the
 * ComposedEValidator should restrict their activities to ResourceSets in which they are required.
 */
public class ComposedEValidator implements EValidator
{
	private static @Nullable Object getEValidator(EValidator.@NonNull Registry eValidatorRegistry, @NonNull EClass eClass) {		
	      List<EClass> eSuperTypes = eClass.getESuperTypes();
	      EClass eSuperClass = eSuperTypes.size() > 0 ? eSuperTypes.get(0) : null;
	      if (eSuperClass == null) {
	    	  return eValidatorRegistry.get(null);
	      }
		  Object eValidator = eValidatorRegistry.get(eSuperClass.eContainer());
		  if (eValidator != null) {
			  return eValidator;
		  }
		  return getEValidator(eValidatorRegistry, eSuperClass);
	}

	/**
	 * Install a ComposedEValidator for ePackage displacing the prevailing EValidator.Registry.INSTANCE
	 * entry and adding it as the first ComposedEValidator child.
	 */
	public static synchronized @NonNull ComposedEValidator install(@NonNull EPackage ePackage) {
		Registry eValidatorRegistry = EValidator.Registry.INSTANCE;
		synchronized (eValidatorRegistry) {
			Object oldEValidator = eValidatorRegistry.get(ePackage);
			if (oldEValidator == null) {
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						oldEValidator = getEValidator(eValidatorRegistry, (EClass)eClassifier);
						if (oldEValidator != null) {
							break;
						}
					}
				}
			}
			if (oldEValidator instanceof ComposedEValidator) {
				return (ComposedEValidator) oldEValidator;
			}
			if (oldEValidator instanceof EValidator.Descriptor) {
				oldEValidator = ((EValidator.Descriptor)oldEValidator).getEValidator();
			}
			ComposedEValidator newEValidator = new ComposedEValidator(oldEValidator instanceof EValidator ? (EValidator) oldEValidator : null);
			eValidatorRegistry.put(ePackage, newEValidator);
			return newEValidator;
		}
	}

	protected final @NonNull List<EValidator> eValidators = new ArrayList<EValidator>();

	public ComposedEValidator(@Nullable EValidator eValidator) {
		if (eValidator != null) {
			eValidators.add(eValidator);
		}
	}

	/**
	 * Add a child EValidator, suppressing null and duplicates.
	 */
	public void addChild(@Nullable EValidator eValidator) {
		if (eValidator != null) {
			synchronized (this) {
				if (!eValidators.contains(eValidator)) {
					eValidators.add(eValidator);
				}
			}
		}
	}

	public @NonNull List<EValidator> getChildren() {
		return eValidators;
	}

	public boolean removeChild(@Nullable EValidator eValidator) {
		return eValidators.remove(eValidator);
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (EValidator eValidator : eValidators) {
			if (allOk || (diagnostics != null)) {
		    	allOk &= eValidator.validate(eObject, diagnostics, context);
			}
		}
		return allOk;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (EValidator eValidator : eValidators) {
		    if (allOk || (diagnostics != null)) {
		    	allOk &= eValidator.validate(eClass, eObject, diagnostics, context);
			}
		}
		return allOk;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (EValidator eValidator : eValidators) {
			if (allOk || (diagnostics != null)) {
		    	allOk &= eValidator.validate(eDataType, value, diagnostics, context);
			}
		}
		return allOk;
	}
}
