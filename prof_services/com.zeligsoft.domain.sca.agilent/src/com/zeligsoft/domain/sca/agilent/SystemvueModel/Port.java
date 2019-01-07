/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getBusSize <em>Bus Size</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDirection <em>Direction</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getMemberName <em>Member Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRate <em>Rate</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRateVariableName <em>Rate Variable Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort()
 * @model extendedMetaData="name='port' kind='empty'"
 * @generated
 */
public interface Port extends EObject {
	/**
	 * Returns the value of the '<em><b>Bus Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bus Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus Size</em>' attribute.
	 * @see #setBusSize(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_BusSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='bus_size' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getBusSize();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getBusSize <em>Bus Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Size</em>' attribute.
	 * @see #getBusSize()
	 * @generated
	 */
	void setBusSize(Object value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getDescription();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Object value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #setDirection(DirectionType)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_Direction()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='direction' namespace='##targetNamespace'"
	 * @generated
	 */
	DirectionType getDirection();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
	 * @see #isSetDirection()
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionType value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDirection()
	 * @see #getDirection()
	 * @see #setDirection(DirectionType)
	 * @generated
	 */
	void unsetDirection();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDirection <em>Direction</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Direction</em>' attribute is set.
	 * @see #unsetDirection()
	 * @see #getDirection()
	 * @see #setDirection(DirectionType)
	 * @generated
	 */
	boolean isSetDirection();

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
	 * @see #isSetImplementation()
	 * @see #unsetImplementation()
	 * @see #setImplementation(ImplementationType)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_Implementation()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='implementation' namespace='##targetNamespace'"
	 * @generated
	 */
	ImplementationType getImplementation();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
	 * @see #isSetImplementation()
	 * @see #unsetImplementation()
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(ImplementationType value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetImplementation()
	 * @see #getImplementation()
	 * @see #setImplementation(ImplementationType)
	 * @generated
	 */
	void unsetImplementation();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getImplementation <em>Implementation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Implementation</em>' attribute is set.
	 * @see #unsetImplementation()
	 * @see #getImplementation()
	 * @see #setImplementation(ImplementationType)
	 * @generated
	 */
	boolean isSetImplementation();

	/**
	 * Returns the value of the '<em><b>Member Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Name</em>' attribute.
	 * @see #setMemberName(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_MemberName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='member_name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getMemberName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getMemberName <em>Member Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Name</em>' attribute.
	 * @see #getMemberName()
	 * @generated
	 */
	void setMemberName(Object value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate</em>' attribute.
	 * @see #setRate(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_Rate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='rate' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getRate();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate</em>' attribute.
	 * @see #getRate()
	 * @generated
	 */
	void setRate(Object value);

	/**
	 * Returns the value of the '<em><b>Rate Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate Variable Name</em>' attribute.
	 * @see #setRateVariableName(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_RateVariableName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='rate_variable_name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getRateVariableName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRateVariableName <em>Rate Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate Variable Name</em>' attribute.
	 * @see #getRateVariableName()
	 * @generated
	 */
	void setRateVariableName(Object value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
	 * @see #isSetTypeName()
	 * @see #unsetTypeName()
	 * @see #setTypeName(TypeNameType)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getPort_TypeName()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='type_name' namespace='##targetNamespace'"
	 * @generated
	 */
	TypeNameType getTypeName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
	 * @see #isSetTypeName()
	 * @see #unsetTypeName()
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(TypeNameType value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTypeName()
	 * @see #getTypeName()
	 * @see #setTypeName(TypeNameType)
	 * @generated
	 */
	void unsetTypeName();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getTypeName <em>Type Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type Name</em>' attribute is set.
	 * @see #unsetTypeName()
	 * @see #getTypeName()
	 * @see #setTypeName(TypeNameType)
	 * @generated
	 */
	boolean isSetTypeName();

} // Port
