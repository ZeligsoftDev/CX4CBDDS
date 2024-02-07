/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Self Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SelfTypeImpl extends ClassImpl implements SelfType
{
	/**
	 * The number of structural features of the '<em>Self Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SELF_TYPE_FEATURE_COUNT = ClassImpl.CLASS_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Self Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SELF_TYPE_OPERATION_COUNT = ClassImpl.CLASS_OPERATION_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelfTypeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return PivotPackage.Literals.SELF_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case 0:
				return allOwnedElements();
			case 1:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case 2:
				return flattenedType();
			case 3:
				return isClass();
			case 4:
				return isTemplateParameter();
			case 8:
				return specializeIn((CallExp)arguments.get(0), (Type)arguments.get(1));
			case 6:
				return validateNameIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 7:
				return validateUniqueInvariantName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSelfType(this);
	}

	@Override
	public @NonNull TypeId computeId() {
		return TypeId.OCL_SELF;
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		throw new UnsupportedOperationException();		// WIP
	}

	@Override
	public @NonNull Type specializeIn(/*@NonNull*/ CallExp expr, @Nullable Type selfType) {
		if (selfType instanceof org.eclipse.ocl.pivot.Class) {
			TemplateSignature templateSignature = ((TemplateableElement)selfType).getOwnedSignature();
			if (templateSignature != null) {
				EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
				if (environmentFactory != null) {
					assert expr != null;
					return environmentFactory.getMetamodelManager().specializeType(selfType, expr, selfType, null); // FIXME is this a no-op
				}
				else {
					return this;
				}
			}
		}
		return selfType != null ? selfType : this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == Type.class)
		{
			switch (baseOperationID)
			{
				case 5: return 8;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}
} //SelfTypeImpl
