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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.SemanticException;
import org.eclipse.osgi.util.NLS;

/**
 */
public class SettingBehavior extends AbstractDelegatedBehavior<EStructuralFeature, SettingDelegate.Factory.Registry, SettingDelegate.Factory>
{
	public static final @NonNull SettingBehavior INSTANCE = new SettingBehavior();
	public static final @NonNull String DERIVATION_CONSTRAINT_KEY = "derivation"; //$NON-NLS-1$
	public static final @NonNull String INITIAL_CONSTRAINT_KEY = "initial"; //$NON-NLS-1$
	public static final @NonNull String NAME = "settingDelegates"; //$NON-NLS-1$

	@Override
	public SettingDelegate.@Nullable Factory getDefaultFactory() {
		return SettingDelegate.Factory.Registry.INSTANCE.getFactory(getName());
	}

	@Override
	public SettingDelegate.Factory.@NonNull Registry getDefaultRegistry() {
		return ClassUtil.nonNullEMF(SettingDelegate.Factory.Registry.INSTANCE);
	}

	@Override
	public @NonNull EPackage getEPackage(@NonNull EStructuralFeature eStructuralFeature) {
		return ClassUtil.nonNullEMF(eStructuralFeature.getEContainingClass().getEPackage());
	}

	/**
	 * Return the feature body associated with structuralFeature, if necessary using ocl to
	 * create the relevant parsing environment for a textual definition..
	 * @throws OCLDelegateException
	 */
	public @NonNull ExpressionInOCL getQueryOrThrow(@NonNull MetamodelManager metamodelManager, @NonNull Property property) throws OCLDelegateException {
		LanguageExpression specification = property.getOwnedExpression();
		if (specification == null) {
			String message = NLS.bind(PivotMessagesInternal.MissingDerivationForSettingDelegate_ERROR_, property);
			throw new OCLDelegateException(new SemanticException(message));
		}
		try {
			return ((EnvironmentFactoryInternalExtension)metamodelManager.getEnvironmentFactory()).parseSpecification(specification);
		} catch (ParserException e) {
			throw new OCLDelegateException(e);
		}
	}

	@Override
	public SettingDelegate.@Nullable Factory getFactory(@NonNull DelegateDomain delegateDomain, @NonNull EStructuralFeature eStructuralFeature) {
		@SuppressWarnings("null")Class<SettingDelegate.Factory.@NonNull Registry> castClass = getRegistryClass();
		SettingDelegate.Factory.Registry registry = OCLDelegateDomain.getDelegateResourceSetRegistry(eStructuralFeature, castClass, getDefaultRegistry());
		return registry.getFactory(delegateDomain.getURI());
	}

	@Override
	public @NonNull Class<SettingDelegate.Factory> getFactoryClass() {
		return SettingDelegate.Factory.class;
	}

	@Override
	public @NonNull String getName() {
		return NAME;
	}

	@Override
	public @NonNull Class<SettingDelegate.Factory.Registry> getRegistryClass() {
		return SettingDelegate.Factory.Registry.class;
	}
}