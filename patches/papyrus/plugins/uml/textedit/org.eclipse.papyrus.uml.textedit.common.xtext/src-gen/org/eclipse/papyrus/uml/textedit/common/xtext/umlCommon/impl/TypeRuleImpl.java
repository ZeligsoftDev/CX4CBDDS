/**
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.TypeRuleImpl#getPath <em>Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.impl.TypeRuleImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeRuleImpl extends MinimalEObjectImpl.Container implements TypeRule {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName path;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TypeRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlCommonPackage.Literals.TYPE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QualifiedName getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPath(QualifiedName newPath, NotificationChain msgs) {
		QualifiedName oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlCommonPackage.TYPE_RULE__PATH, oldPath, newPath);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPath(QualifiedName newPath) {
		if (newPath != path) {
			NotificationChain msgs = null;
			if (path != null)
				msgs = ((InternalEObject) path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlCommonPackage.TYPE_RULE__PATH, null, msgs);
			if (newPath != null)
				msgs = ((InternalEObject) newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlCommonPackage.TYPE_RULE__PATH, null, msgs);
			msgs = basicSetPath(newPath, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlCommonPackage.TYPE_RULE__PATH, newPath, newPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (Type) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlCommonPackage.TYPE_RULE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlCommonPackage.TYPE_RULE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UmlCommonPackage.TYPE_RULE__PATH:
			return basicSetPath(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UmlCommonPackage.TYPE_RULE__PATH:
			return getPath();
		case UmlCommonPackage.TYPE_RULE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UmlCommonPackage.TYPE_RULE__PATH:
			setPath((QualifiedName) newValue);
			return;
		case UmlCommonPackage.TYPE_RULE__TYPE:
			setType((Type) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case UmlCommonPackage.TYPE_RULE__PATH:
			setPath((QualifiedName) null);
			return;
		case UmlCommonPackage.TYPE_RULE__TYPE:
			setType((Type) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case UmlCommonPackage.TYPE_RULE__PATH:
			return path != null;
		case UmlCommonPackage.TYPE_RULE__TYPE:
			return type != null;
		}
		return super.eIsSet(featureID);
	}

} // TypeRuleImpl
