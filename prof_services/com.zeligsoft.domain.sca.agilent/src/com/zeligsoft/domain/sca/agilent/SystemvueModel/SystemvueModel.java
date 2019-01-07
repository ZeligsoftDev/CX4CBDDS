/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Systemvue Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getGroup <em>Group</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getParameter <em>Parameter</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getHeaderFile <em>Header File</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getPort <em>Port</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel()
 * @model extendedMetaData="name='systemvue_model' kind='elementOnly'"
 * @generated
 */
public interface SystemvueModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_Parameter()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='parameter' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<Parameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Header File</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header File</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header File</em>' containment reference list.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_HeaderFile()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='header_file' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<HeaderFile> getHeaderFile();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference list.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_Port()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='port' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<Port> getPort();

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
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getDescription();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Object value);

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
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='namespace' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getNamespace();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(Object value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(Object)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getSystemvueModel_TypeName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
	 *        extendedMetaData="kind='attribute' name='type_name' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getTypeName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getTypeName <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(Object value);

} // SystemvueModel
