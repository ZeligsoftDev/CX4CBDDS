/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visibility Kind</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl#getPublic <em>Public</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl#getPrivate <em>Private</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl#getProtected <em>Protected</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.VisibilityKindImpl#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VisibilityKindImpl extends MinimalEObjectImpl.Container implements VisibilityKind {
	/**
	 * The default value of the '{@link #getPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPublic()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPublic()
	 * @generated
	 * @ordered
	 */
	protected String public_ = PUBLIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPrivate()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIVATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPrivate()
	 * @generated
	 * @ordered
	 */
	protected String private_ = PRIVATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtected() <em>Protected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProtected()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTECTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtected() <em>Protected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProtected()
	 * @generated
	 * @ordered
	 */
	protected String protected_ = PROTECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VisibilityKindImpl() {
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
		return UmlValueSpecificationPackage.Literals.VISIBILITY_KIND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPublic() {
		return public_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPublic(String newPublic) {
		String oldPublic = public_;
		public_ = newPublic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.VISIBILITY_KIND__PUBLIC, oldPublic, public_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPrivate() {
		return private_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPrivate(String newPrivate) {
		String oldPrivate = private_;
		private_ = newPrivate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.VISIBILITY_KIND__PRIVATE, oldPrivate, private_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProtected() {
		return protected_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProtected(String newProtected) {
		String oldProtected = protected_;
		protected_ = newProtected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.VISIBILITY_KIND__PROTECTED, oldProtected, protected_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.VISIBILITY_KIND__PACKAGE, oldPackage, package_));
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
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PUBLIC:
			return getPublic();
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PRIVATE:
			return getPrivate();
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PROTECTED:
			return getProtected();
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PACKAGE:
			return getPackage();
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
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PUBLIC:
			setPublic((String) newValue);
			return;
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PRIVATE:
			setPrivate((String) newValue);
			return;
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PROTECTED:
			setProtected((String) newValue);
			return;
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PACKAGE:
			setPackage((String) newValue);
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
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PUBLIC:
			setPublic(PUBLIC_EDEFAULT);
			return;
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PRIVATE:
			setPrivate(PRIVATE_EDEFAULT);
			return;
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PROTECTED:
			setProtected(PROTECTED_EDEFAULT);
			return;
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PACKAGE:
			setPackage(PACKAGE_EDEFAULT);
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
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PUBLIC:
			return PUBLIC_EDEFAULT == null ? public_ != null : !PUBLIC_EDEFAULT.equals(public_);
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PRIVATE:
			return PRIVATE_EDEFAULT == null ? private_ != null : !PRIVATE_EDEFAULT.equals(private_);
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PROTECTED:
			return PROTECTED_EDEFAULT == null ? protected_ != null : !PROTECTED_EDEFAULT.equals(protected_);
		case UmlValueSpecificationPackage.VISIBILITY_KIND__PACKAGE:
			return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (public: ");
		result.append(public_);
		result.append(", private: ");
		result.append(private_);
		result.append(", protected: ");
		result.append(protected_);
		result.append(", package: ");
		result.append(package_);
		result.append(')');
		return result.toString();
	}

} // VisibilityKindImpl
