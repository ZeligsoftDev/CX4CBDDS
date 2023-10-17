/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.values.OCLValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class TypeImpl
extends NamedElementImpl
implements Type {

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class isClass()
	{
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!Type!isClass()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateParameter isTemplateParameter()
	{
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!Type!isTemplateParameter()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type specializeIn(final CallExp expr, final Type selfType)
	{
		/**
		 * self
		 */
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type flattenedType()
	{
		/**
		 * self
		 */
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
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
			case 5:
				return specializeIn((CallExp)arguments.get(0), (Type)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitType(this);
	}

	@Override
	public boolean conformsTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		CompleteInheritance thisInheritance = this.getInheritance(standardLibrary);
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.isSubInheritanceOf(thatInheritance);
	}

	/**
	 * Create and return an instance of this type.
	 *
	 * Beware: this functionality is invalid if this type is in a dynamically loaded Ecore metamodel and has a supertype
	 * from a generated Ecore metamodel. See Bug 532561. Direct creation of a DynamicEObjectImpl may be much better.
	 *
	 * This functionality is broken if the esObject has not been set. At this point the environmentFactory is not available
	 * to perform a lazy AS2Ecore. The caller probably can.
	 *
	 * @deprecated caller can do better without this bad helper method.
	 */
	@Deprecated
	public @NonNull EObject createInstance() {
		EObject eTarget = getESObject();
		if (eTarget instanceof EClass) {
			EClass eClass = (EClass) eTarget;
			EObject element = eClass.getEPackage().getEFactoryInstance().create(eClass);
			assert element != null;
			return element;
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Create and return an instance of this data type from iytds string representation.
	 *
	 * This functionality is broken if the esObject has not been set. At this point the environmentFactory is not available
	 * to perform a lazy AS2Ecore. The caller probably can.
	 *
	 * @deprecated caller can do better without this bad helper method.
	 */
	@Deprecated
	public @Nullable Object createInstance(@NonNull String value) {
		EObject eTarget = getESObject();
		if (eTarget instanceof EDataType) {
			EDataType eDataType = (EDataType) eTarget;
			return eDataType.getEPackage().getEFactoryInstance().createFromString(eDataType, value);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Type getCommonType(@NonNull IdResolver idResolver, @NonNull Type type) {
		if (type == this) {
			return this;
		}
		StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		CompleteInheritance thisInheritance = this.getInheritance(standardLibrary);
		CompleteInheritance thatInheritance = type.getInheritance(standardLibrary);
		return thisInheritance.getCommonInheritance(thatInheritance).getPivotClass();
	}

	@Override
	public boolean isEqualTo(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		Type thisType = this.getNormalizedType(standardLibrary);
		Type thatType = type.getNormalizedType(standardLibrary);
		return thisType == thatType;
	}

	@Override
	public boolean isEqualToUnspecializedType(@NonNull StandardLibrary standardLibrary, @NonNull Type type) {
		if (this == type) {
			return true;
		}
		return false;
	}

	//	@Override
	//	public boolean isInvalid() {
	//		return false;
	//	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		if (!(thatValue instanceof Type)) {
			return false;
		}
		TypeId thisTypeId = getTypeId();
		TypeId thatTypeId = ((Type)thatValue).getTypeId();
		return thisTypeId.equals(thatTypeId);
	}

	@Override
	public int oclHashCode() {
		return getTypeId().hashCode();
	}

	//	@Override
	//	@NonNull
	//	public List<? extends Constraint> getOwnedRule() {
	//		throw new UnsupportedOperationException();		// FIXME
	//	}

	public org.eclipse.ocl.pivot.Package getPackage() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull TemplateParameters getTypeParameters() {
		throw new UnsupportedOperationException();		// FIXME
	}
} //TypeImpl
