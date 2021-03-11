/**
 */
package dds4ccm.impl;

import dds4ccm.DDS4CCMPackage;
import dds4ccm.TypeConstraint;
import dds4ccm.TypeParameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.ClassifierTemplateParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.TypeParameterImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link dds4ccm.impl.TypeParameterImpl#getBase_ClassifierTemplateParameter <em>Base Classifier Template Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeParameterImpl extends MinimalEObjectImpl.Container implements TypeParameter {
	/**
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final TypeConstraint CONSTRAINT_EDEFAULT = TypeConstraint.TYPENAME;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected TypeConstraint constraint = CONSTRAINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_ClassifierTemplateParameter() <em>Base Classifier Template Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ClassifierTemplateParameter()
	 * @generated
	 * @ordered
	 */
	protected ClassifierTemplateParameter base_ClassifierTemplateParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getTypeParameter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeConstraint getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstraint(TypeConstraint newConstraint) {
		TypeConstraint oldConstraint = constraint;
		constraint = newConstraint == null ? CONSTRAINT_EDEFAULT : newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.TYPE_PARAMETER__CONSTRAINT, oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassifierTemplateParameter getBase_ClassifierTemplateParameter() {
		if (base_ClassifierTemplateParameter != null && base_ClassifierTemplateParameter.eIsProxy()) {
			InternalEObject oldBase_ClassifierTemplateParameter = (InternalEObject)base_ClassifierTemplateParameter;
			base_ClassifierTemplateParameter = (ClassifierTemplateParameter)eResolveProxy(oldBase_ClassifierTemplateParameter);
			if (base_ClassifierTemplateParameter != oldBase_ClassifierTemplateParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER, oldBase_ClassifierTemplateParameter, base_ClassifierTemplateParameter));
			}
		}
		return base_ClassifierTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierTemplateParameter basicGetBase_ClassifierTemplateParameter() {
		return base_ClassifierTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_ClassifierTemplateParameter(ClassifierTemplateParameter newBase_ClassifierTemplateParameter) {
		ClassifierTemplateParameter oldBase_ClassifierTemplateParameter = base_ClassifierTemplateParameter;
		base_ClassifierTemplateParameter = newBase_ClassifierTemplateParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER, oldBase_ClassifierTemplateParameter, base_ClassifierTemplateParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.TYPE_PARAMETER__CONSTRAINT:
				return getConstraint();
			case DDS4CCMPackage.TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER:
				if (resolve) return getBase_ClassifierTemplateParameter();
				return basicGetBase_ClassifierTemplateParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DDS4CCMPackage.TYPE_PARAMETER__CONSTRAINT:
				setConstraint((TypeConstraint)newValue);
				return;
			case DDS4CCMPackage.TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER:
				setBase_ClassifierTemplateParameter((ClassifierTemplateParameter)newValue);
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
			case DDS4CCMPackage.TYPE_PARAMETER__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
				return;
			case DDS4CCMPackage.TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER:
				setBase_ClassifierTemplateParameter((ClassifierTemplateParameter)null);
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
			case DDS4CCMPackage.TYPE_PARAMETER__CONSTRAINT:
				return constraint != CONSTRAINT_EDEFAULT;
			case DDS4CCMPackage.TYPE_PARAMETER__BASE_CLASSIFIER_TEMPLATE_PARAMETER:
				return base_ClassifierTemplateParameter != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (constraint: ");
		result.append(constraint);
		result.append(')');
		return result.toString();
	}

} //TypeParameterImpl
