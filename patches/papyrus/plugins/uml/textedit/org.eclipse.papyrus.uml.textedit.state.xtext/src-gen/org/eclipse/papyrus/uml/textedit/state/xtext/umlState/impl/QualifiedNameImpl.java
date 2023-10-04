/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;
import org.eclipse.uml2.uml.Namespace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl.QualifiedNameImpl#getPath <em>Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl.QualifiedNameImpl#getRemaining <em>Remaining</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNameImpl extends MinimalEObjectImpl.Container implements QualifiedName {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected Namespace path;

	/**
	 * The cached value of the '{@link #getRemaining() <em>Remaining</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRemaining()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName remaining;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QualifiedNameImpl() {
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
		return UmlStatePackage.Literals.QUALIFIED_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Namespace getPath() {
		if (path != null && path.eIsProxy()) {
			InternalEObject oldPath = (InternalEObject) path;
			path = (Namespace) eResolveProxy(oldPath);
			if (path != oldPath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlStatePackage.QUALIFIED_NAME__PATH, oldPath, path));
			}
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Namespace basicGetPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPath(Namespace newPath) {
		Namespace oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlStatePackage.QUALIFIED_NAME__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QualifiedName getRemaining() {
		return remaining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRemaining(QualifiedName newRemaining, NotificationChain msgs) {
		QualifiedName oldRemaining = remaining;
		remaining = newRemaining;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlStatePackage.QUALIFIED_NAME__REMAINING, oldRemaining, newRemaining);
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
	public void setRemaining(QualifiedName newRemaining) {
		if (newRemaining != remaining) {
			NotificationChain msgs = null;
			if (remaining != null)
				msgs = ((InternalEObject) remaining).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlStatePackage.QUALIFIED_NAME__REMAINING, null, msgs);
			if (newRemaining != null)
				msgs = ((InternalEObject) newRemaining).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlStatePackage.QUALIFIED_NAME__REMAINING, null, msgs);
			msgs = basicSetRemaining(newRemaining, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlStatePackage.QUALIFIED_NAME__REMAINING, newRemaining, newRemaining));
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
		case UmlStatePackage.QUALIFIED_NAME__REMAINING:
			return basicSetRemaining(null, msgs);
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
		case UmlStatePackage.QUALIFIED_NAME__PATH:
			if (resolve)
				return getPath();
			return basicGetPath();
		case UmlStatePackage.QUALIFIED_NAME__REMAINING:
			return getRemaining();
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
		case UmlStatePackage.QUALIFIED_NAME__PATH:
			setPath((Namespace) newValue);
			return;
		case UmlStatePackage.QUALIFIED_NAME__REMAINING:
			setRemaining((QualifiedName) newValue);
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
		case UmlStatePackage.QUALIFIED_NAME__PATH:
			setPath((Namespace) null);
			return;
		case UmlStatePackage.QUALIFIED_NAME__REMAINING:
			setRemaining((QualifiedName) null);
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
		case UmlStatePackage.QUALIFIED_NAME__PATH:
			return path != null;
		case UmlStatePackage.QUALIFIED_NAME__REMAINING:
			return remaining != null;
		}
		return super.eIsSet(featureID);
	}

} // QualifiedNameImpl
