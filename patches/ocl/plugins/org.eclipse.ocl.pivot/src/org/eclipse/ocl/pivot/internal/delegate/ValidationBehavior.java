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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.SemanticException;

/**
 */
public class ValidationBehavior extends AbstractDelegatedBehavior<EClassifier, EValidator.ValidationDelegate.Registry, ValidationDelegate.Factory>
{
	public static final @NonNull ValidationBehavior INSTANCE = new ValidationBehavior();
	public static final @NonNull String NAME = "validationDelegates"; //$NON-NLS-1$

	public Constraint getConstraint(@NonNull MetamodelManager metamodelManager, @NonNull EClassifier eClassifier, @NonNull String constraintName) throws OCLDelegateException {
		Resource ecoreMetamodel = ClassUtil.nonNullEMF(eClassifier.eResource());
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreMetamodel, (EnvironmentFactoryInternal) metamodelManager.getEnvironmentFactory());
		Type type = ecore2as.getCreated(Type.class, eClassifier);
		if (type != null) {
			Constraint constraint = NameUtil.getNameable(((MetamodelManagerInternal)metamodelManager).getAllInvariants(type), constraintName);
			if (constraint != null) {
				return constraint;
			}
		}
		throw new OCLDelegateException(new SemanticException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, type, PivotConstantsInternal.CONSTRAINT_ROLE));
	}

	@Override
	public ValidationDelegate.@Nullable Factory getDefaultFactory() {
		return (ValidationDelegate.Factory) ValidationDelegate.Factory.Registry.INSTANCE.getValidationDelegate(getName());
	}

	@Override
	public EValidator.ValidationDelegate.@NonNull Registry getDefaultRegistry() {
		return ClassUtil.nonNullEMF(ValidationDelegate.Factory.Registry.INSTANCE);
	}

	@Override
	public @NonNull EPackage getEPackage(@NonNull EClassifier eClassifier) {
		return ClassUtil.nonNullEMF(eClassifier.getEPackage());
	}

	/*	public ExpressionInOCL getExpressionInOCL(MetamodelManager metamodelManager, EClassifier eClassifier, String constraintName) throws OCLDelegateException {
		Resource ecoreMetamodel = eClassifier.eResource();
		Ecore2AS ecore2as = Ecore2AS.getAdapter(ecoreMetamodel, metamodelManager);
		Type type = ecore2as.getCreated(Type.class, eClassifier);
		Constraint constraint = PivotUtil.getNamedElement(type.getOwnedRule(), constraintName);
		if (constraint != null) {
			ExpressionInOCL expressionInOCL = getExpressionInOCL(metamodelManager, type, constraint);
			if (expressionInOCL != null) {
				return expressionInOCL;
			}
		}
		String message = NLS.bind(OCLMessages.MissingBodyForInvocationDelegate_ERROR_, type);
		throw new OCLDelegateException(message);
	} */

	@Override
	public ValidationDelegate.@Nullable Factory getFactory(@NonNull DelegateDomain delegateDomain, @NonNull EClassifier eClassifier) {
		Class<EValidator.ValidationDelegate.@NonNull Registry> castClass = ValidationDelegate.Registry.class;
		EValidator.ValidationDelegate.@NonNull Registry registry = OCLDelegateDomain.getDelegateResourceSetRegistry(eClassifier, castClass, getDefaultRegistry());
		String delegateURI = delegateDomain.getURI();
		org.eclipse.emf.ecore.EValidator.ValidationDelegate validationDelegate = registry.getValidationDelegate(delegateURI);
		return (ValidationDelegate.Factory) validationDelegate;
	}

	@Override
	public @NonNull Class<ValidationDelegate.Factory> getFactoryClass() {
		return ValidationDelegate.Factory.class;
	}

	@Override
	public @NonNull String getName() {
		return NAME;
	}

	/**
	 * Return the operation body associated with operation, if necessary using
	 * <code>ocl</code> to create the relevant parsing environment for a textual
	 * definition.
	 * @throws OCLDelegateException
	 */
	public @NonNull ExpressionInOCL getQueryOrThrow(@NonNull MetamodelManager metamodelManager, @NonNull Constraint constraint) throws OCLDelegateException {
		LanguageExpression specification = constraint.getOwnedSpecification();
		if (specification == null) {
			throw new OCLDelegateException(new SemanticException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, constraint, PivotConstantsInternal.INVARIANT_ROLE));
		}
		try {
			return ((EnvironmentFactoryInternalExtension)metamodelManager.getEnvironmentFactory()).parseSpecification(specification);
		} catch (ParserException e) {
			throw new OCLDelegateException(e);
		}
	}

	@Override
	public @NonNull Class<ValidationDelegate.Factory.Registry> getRegistryClass() {
		return ValidationDelegate.Factory.Registry.class;
	}
}