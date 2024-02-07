/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.helper.BasicQueryImpl;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.SemanticException;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

/**
 * An implementation of a setting delegate that computes OCL derived features.
 */
public class OCLSettingDelegate extends BasicSettingDelegate.Stateless
{
	/**
	 * An implementation of a setting delegate that computes OCL derived features
	 * and caches explicitly changed values.
	 *
	 * @since 3.5
	 */
	public static class Changeable extends OCLSettingDelegate
	{
		private Map<InternalEObject, Object> valueMap = null;

		public Changeable(@NonNull OCLDelegateDomain delegateDomain, @NonNull EStructuralFeature structuralFeature) {
			super(delegateDomain, structuralFeature);
		}

		@Override
		protected Object get(InternalEObject owner, boolean resolve, boolean coreType) {
			if ((valueMap != null) && valueMap.containsKey(owner)) {
				return valueMap.get(owner);
			}
			return super.get(owner, resolve, coreType);
		}

		@Override
		protected boolean isSet(InternalEObject owner) {
			return (valueMap != null) && valueMap.containsKey(owner);
		}

		@Override
		protected void set(InternalEObject owner, Object newValue) {
			if (owner != null) {
				if (valueMap == null) {
					valueMap = new HashMap<InternalEObject, Object>();
				}
				valueMap.put(owner, newValue);
			}
		}

		@Override
		protected void unset(InternalEObject owner) {
			if (valueMap != null) {
				valueMap.remove(owner);
			}
		}
	}

	protected final @NonNull OCLDelegateDomain delegateDomain;
	private Property property;
	private ExpressionInOCL query;

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

	/**
	 * @since 1.7
	 */
	protected @Nullable Property basicGetProperty() {
		return property;
	}

	@Deprecated /* @deprecated not used any more */
	protected @Nullable Object evaluateEcore(@NonNull OCL ocl, @NonNull ExpressionInOCL query, @Nullable Object unboxedObject) {
		EnvironmentFactory environmentFactory = ocl.getEnvironmentFactory();
		ModelManager modelManager = ocl.getModelManager();
		if (modelManager == null) {
			modelManager = environmentFactory.createModelManager(unboxedObject);
		}
		BasicQueryImpl query2 = new BasicQueryImpl(environmentFactory, query);
		return query2.evaluateEcore(eStructuralFeature.getEType().getInstanceClass(), unboxedObject);
	}

	@Override
	protected Object get(InternalEObject ecoreObject, boolean resolve, boolean coreType) {
		assert ecoreObject != null;
		try {
			EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(ecoreObject);
			Executor executor = PivotUtil.getExecutor(ecoreObject);
			ModelManager modelManager = executor.getModelManager();
			ExpressionInOCL query = getQuery();
			Executor savedExecutor = ThreadLocalExecutor.basicGetExecutor();
			try {
				if (savedExecutor != null) {
					ThreadLocalExecutor.setExecutor(null);		// New evaluation needs new root EvaluationEnvironment and so new Executor, but old modelManager
				}
				VariableDeclaration contextVariable = PivotUtil.getOwnedContext(query);
				OCLExpression expression = PivotUtil.getOwnedBody(query);
				Class<?> instanceClass = eStructuralFeature.getEType().getInstanceClass();
				IdResolver idResolver = environmentFactory.getIdResolver();
				Object boxedValue = idResolver.boxedValueOf(ecoreObject);
				EvaluationEnvironment evaluationEnvironment = environmentFactory.createEvaluationEnvironment(query, modelManager);
				evaluationEnvironment.add(contextVariable, boxedValue);
				EvaluationVisitor ev = environmentFactory.createEvaluationVisitor(evaluationEnvironment);
			//	try {
					Object boxedResult = expression.accept(ev);
					return idResolver.ecoreValueOf(instanceClass, boxedResult);
			//	} catch (EvaluationHaltedException e) {
			//		throw e;
			//	}
			}
			finally {
				ThreadLocalExecutor.setExecutor(savedExecutor);		// Restore invoker's executor
			}
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

	/**
	 * @since 1.7
	 */
	protected @NonNull ExpressionInOCL getQuery() {
		ExpressionInOCL query2 = query;
		if (query2 == null) {
		//	OCL ocl = delegateDomain.getOCL();
		//	MetamodelManager metamodelManager = ocl.getMetamodelManager();
			EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(null);
			Property property2 = getProperty();
			query2 = query = SettingBehavior.INSTANCE.getQueryOrThrow(environmentFactory.getMetamodelManager(), property2);
			SettingBehavior.INSTANCE.validate(property2);
		}
		return query2;
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
