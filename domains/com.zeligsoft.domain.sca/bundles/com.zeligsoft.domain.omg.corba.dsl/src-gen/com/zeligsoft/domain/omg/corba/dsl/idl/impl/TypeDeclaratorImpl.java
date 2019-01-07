/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.Declarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl#getDeclarators <em>Declarators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeDeclaratorImpl extends TypeDeclImpl implements TypeDeclarator {
	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList<IDLComment> comments;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeSpec type;

	/**
	 * The cached value of the '{@link #getDeclarators() <em>Declarators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarators()
	 * @generated
	 * @ordered
	 */
	protected EList<Declarator> declarators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeDeclaratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IdlPackage.Literals.TYPE_DECLARATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IDLComment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentEList<IDLComment>(IDLComment.class, this, IdlPackage.TYPE_DECLARATOR__COMMENTS);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpec getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeSpec newType, NotificationChain msgs) {
		TypeSpec oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IdlPackage.TYPE_DECLARATOR__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeSpec newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IdlPackage.TYPE_DECLARATOR__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IdlPackage.TYPE_DECLARATOR__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IdlPackage.TYPE_DECLARATOR__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declarator> getDeclarators() {
		if (declarators == null) {
			declarators = new EObjectContainmentEList<Declarator>(Declarator.class, this, IdlPackage.TYPE_DECLARATOR__DECLARATORS);
		}
		return declarators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IdlPackage.TYPE_DECLARATOR__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case IdlPackage.TYPE_DECLARATOR__TYPE:
				return basicSetType(null, msgs);
			case IdlPackage.TYPE_DECLARATOR__DECLARATORS:
				return ((InternalEList<?>)getDeclarators()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IdlPackage.TYPE_DECLARATOR__COMMENTS:
				return getComments();
			case IdlPackage.TYPE_DECLARATOR__TYPE:
				return getType();
			case IdlPackage.TYPE_DECLARATOR__DECLARATORS:
				return getDeclarators();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IdlPackage.TYPE_DECLARATOR__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends IDLComment>)newValue);
				return;
			case IdlPackage.TYPE_DECLARATOR__TYPE:
				setType((TypeSpec)newValue);
				return;
			case IdlPackage.TYPE_DECLARATOR__DECLARATORS:
				getDeclarators().clear();
				getDeclarators().addAll((Collection<? extends Declarator>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IdlPackage.TYPE_DECLARATOR__COMMENTS:
				getComments().clear();
				return;
			case IdlPackage.TYPE_DECLARATOR__TYPE:
				setType((TypeSpec)null);
				return;
			case IdlPackage.TYPE_DECLARATOR__DECLARATORS:
				getDeclarators().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IdlPackage.TYPE_DECLARATOR__COMMENTS:
				return comments != null && !comments.isEmpty();
			case IdlPackage.TYPE_DECLARATOR__TYPE:
				return type != null;
			case IdlPackage.TYPE_DECLARATOR__DECLARATORS:
				return declarators != null && !declarators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TypeDeclaratorImpl
