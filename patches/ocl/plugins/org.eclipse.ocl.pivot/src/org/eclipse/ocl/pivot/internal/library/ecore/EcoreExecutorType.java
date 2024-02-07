/*******************************************************************************
 * Copyright (c) 2012, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.BuiltInTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class EcoreExecutorType extends ExecutorType
{
	protected @Nullable EClassifier eClassifier;
	private @Nullable TypeId typeId = null;

	/**
	 * Construct an executable type descriptor in the absence of a known EClassifier. A subsequent
	 * call of {@link #initFragments(ExecutorFragment[], int[], EClassifier)} may define an EClassifier.
	 */
	public EcoreExecutorType(@NonNull String name, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter @NonNull ... typeParameters) {
		super(name, evaluationPackage, flags, typeParameters);
		this.eClassifier = null;
	}

	/**
	 * Construct an executable type descriptor in the absence of a known EClassifier. A subsequent
	 * call of {@link #initFragments(ExecutorFragment[], int[], EClassifier)} may define an EClassifier.
	 */
	public EcoreExecutorType(@NonNull BuiltInTypeId typeId, @NonNull ExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter @NonNull ... typeParameters) {
		super(typeId.getName(), evaluationPackage, flags, typeParameters);
		this.eClassifier = null;
		this.typeId = typeId;
	}

	/**
	 * Construct an executable type descriptor for a known EClassifier.
	 */
	public EcoreExecutorType(/*@NonNull*/ EClassifier eClassifier, @NonNull EcoreExecutorPackage evaluationPackage, int flags, @NonNull ExecutorTypeParameter @NonNull ... typeParameters) {
		super(ClassUtil.nonNullModel(eClassifier.getName()), evaluationPackage, flags, typeParameters);
		this.eClassifier = eClassifier;
	}

	@Override
	public @NonNull EObject createInstance() {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 instanceof EClass) {
			EClass eClass = (EClass)eClassifier2;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
//			TypeId typeId = IdManager.getTypeId(eClass);
			return /*ValuesUtil.createObjectValue(typeId, */ClassUtil.nonNullEMF(element); //);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Object createInstance(@NonNull String value) {
		EClassifier eClassifier2 = eClassifier;
		if (eClassifier2 instanceof EDataType) {
			EDataType eDataType = (EDataType) eClassifier2;
			Object element = eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
			return /*ValuesUtil.valueOf(*/ClassUtil.nonNullEMF(element); //);
		}
		throw new UnsupportedOperationException();
	}

	public final EClassifier getEClassifier() {
		return eClassifier;
	}

	@Override
	public EObject getESObject() {
		return eClassifier;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		if (eClassifier != null) {					// FIXME Enforce @NonNull
			return ClassUtil.nonNullModel(ClassUtil.nonNullState(eClassifier).getName());
		}
		else {
			return getTypeId().getMetaTypeName();
		}
	}

	@Override
	public @NonNull TypeId getTypeId() {
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			synchronized (this) {
				typeId2 = typeId;
				if (typeId2 == null) {
					EClassifier eClassifier2 = eClassifier;
					if (eClassifier2 != null) {
						typeId2 = IdManager.getTypeId(eClassifier2);
					}
					else {
						PackageId packageTypeId = evaluationPackage.getPackageId(); //IdManager.getPackageId(evaluationPackage);
						TemplateParameters typeParameters = getTypeParameters();
						if (eClassifier instanceof EDataType) {
							typeId2 = packageTypeId.getDataTypeId(name, typeParameters.parametersSize());
						}
						else {
							typeId2 = packageTypeId.getClassId(name, typeParameters.parametersSize());
						}
					}
					typeId = typeId2;
				}
			}
		}
		return typeId2;
	}

	/**
	 * Define the EClassifier associated with an executable type. This initialization may
	 * be performed once to allow an Ecore-aware package of type descriptors to re-use and
	 * enhance an Ecore-unaware package. This occurs for the PivotTables that enhance the
	 * OCLstdlibTables.
	 */
	public @NonNull EcoreExecutorType initFragments(@NonNull ExecutorFragment @NonNull [] fragments, int[] depthCounts, /*@NonNull*/ EClassifier eClassifier) {
		assert eClassifier != null;
		assert this.eClassifier == null;
		assert name.equals(eClassifier.getName());
		this.eClassifier = ClassUtil.nonNullState(eClassifier);
		initFragments(fragments, depthCounts);
		return this;
	}
}
