/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.delegate;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.pivot.internal.delegate.SettingBehavior;
import org.eclipse.ocl.pivot.internal.helper.BasicQueryImpl;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.Query;
import org.eclipse.ocl.pivot.utilities.SemanticException;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 *
 * @since 3.0
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	protected final OCLDelegateDomain delegateDomain;
	private Property property;
	private ExpressionInOCL specification;

	/**
	 * Initializes me with my structural feature.
	 *
	 * @param structuralFeature
	 *            the structural feature that I handle
	 */
	public OCLSettingDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EStructuralFeature structuralFeature) {
		super(structuralFeature);
		this.delegateDomain = delegateDomain;
	}

	@Override
	protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
		try {
			EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(owner);
			MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
			ExpressionInOCL specification2 = specification;
			if (specification2 == null) {
				Property property2 = getProperty();
				specification2 = specification = SettingBehavior.INSTANCE.getQueryOrThrow(metamodelManager, property2);
				SettingBehavior.INSTANCE.validate(property2);
			}
			Query query = new BasicQueryImpl(environmentFactory, specification2);
			Object ecoreResult = query.evaluateEcore(eStructuralFeature.getEType().getInstanceClass(), owner);
			return ecoreResult;
		}
		catch (EvaluationException e) {
			throw new OCLDelegateException(new EvaluationException(e, PivotMessagesInternal.EvaluationResultIsInvalid_ERROR_, property));
		}
	}

	public @NonNull Property getProperty() {
		Property property2 = property;
		if (property2 == null) {
			property2 = property = delegateDomain.getPivot(Property.class, ClassUtil.nonNullEMF(eStructuralFeature));
			if (property2 == null) {
				throw new OCLDelegateException(new SemanticException("No pivot property for " + eStructuralFeature)) ;
			}
		}
		return property2;
	}

	@Override
	protected boolean isSet(InternalEObject owner) {
		return false; // derived features are, implicitly, never set
	}

	@Override
	public String toString() {
		if (property != null) {
			return "<" + delegateDomain.getURI() + ":setting> " + property; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eStructuralFeature.getEContainingClass().getEPackage().getName()
			+ "::" + eStructuralFeature.getEContainingClass().getName()
			+ "." + eStructuralFeature.getName();
			return "<" + delegateDomain.getURI() + ":setting> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
