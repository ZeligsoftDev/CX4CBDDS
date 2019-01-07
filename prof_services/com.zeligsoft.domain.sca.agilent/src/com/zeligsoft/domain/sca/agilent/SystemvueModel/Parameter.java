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
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getMemberName <em>Member Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getSizeName <em>Size Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter()
 * @model extendedMetaData="name='parameter' kind='empty'"
 * @generated
 */
public interface Parameter extends EObject {
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
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getDescription();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Object value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
	 * @see #isSetImplementation()
	 * @see #unsetImplementation()
	 * @see #setImplementation(Implementation)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter_Implementation()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='implementation' namespace='##targetNamespace'"
	 * @generated
	 */
	Implementation getImplementation();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
	 * @see #isSetImplementation()
	 * @see #unsetImplementation()
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(Implementation value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetImplementation()
	 * @see #getImplementation()
	 * @see #setImplementation(Implementation)
	 * @generated
	 */
	void unsetImplementation();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getImplementation <em>Implementation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Implementation</em>' attribute is set.
	 * @see #unsetImplementation()
	 * @see #getImplementation()
	 * @see #setImplementation(Implementation)
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
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter_MemberName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='member_name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getMemberName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getMemberName <em>Member Name</em>}' attribute.
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
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

	/**
	 * Returns the value of the '<em><b>Size Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Name</em>' attribute.
	 * @see #setSizeName(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter_SizeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='size_name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getSizeName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getSizeName <em>Size Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Name</em>' attribute.
	 * @see #getSizeName()
	 * @generated
	 */
	void setSizeName(Object value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
	 * @see #isSetTypeName()
	 * @see #unsetTypeName()
	 * @see #setTypeName(TypeName)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getParameter_TypeName()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='type_name' namespace='##targetNamespace'"
	 * @generated
	 */
	TypeName getTypeName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
	 * @see #isSetTypeName()
	 * @see #unsetTypeName()
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(TypeName value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTypeName()
	 * @see #getTypeName()
	 * @see #setTypeName(TypeName)
	 * @generated
	 */
	void unsetTypeName();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getTypeName <em>Type Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type Name</em>' attribute is set.
	 * @see #unsetTypeName()
	 * @see #getTypeName()
	 * @see #setTypeName(TypeName)
	 * @generated
	 */
	boolean isSetTypeName();

} // Parameter
