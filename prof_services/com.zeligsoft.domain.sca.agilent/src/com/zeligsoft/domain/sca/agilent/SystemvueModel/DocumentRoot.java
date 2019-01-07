/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getHeaderFile <em>Header File</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getParameter <em>Parameter</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getPort <em>Port</em>}</li>
 *   <li>{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getSystemvueModel <em>Systemvue Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Header File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header File</em>' containment reference.
	 * @see #setHeaderFile(HeaderFile)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_HeaderFile()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='header_file' namespace='##targetNamespace'"
	 * @generated
	 */
	HeaderFile getHeaderFile();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getHeaderFile <em>Header File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header File</em>' containment reference.
	 * @see #getHeaderFile()
	 * @generated
	 */
	void setHeaderFile(HeaderFile value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference.
	 * @see #setParameter(Parameter)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_Parameter()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='parameter' namespace='##targetNamespace'"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getParameter <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' containment reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference.
	 * @see #setPort(Port)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_Port()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='port' namespace='##targetNamespace'"
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getPort <em>Port</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' containment reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

	/**
	 * Returns the value of the '<em><b>Systemvue Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Systemvue Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Systemvue Model</em>' containment reference.
	 * @see #setSystemvueModel(SystemvueModel)
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelPackage#getDocumentRoot_SystemvueModel()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='systemvue_model' namespace='##targetNamespace'"
	 * @generated
	 */
	SystemvueModel getSystemvueModel();

	/**
	 * Sets the value of the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getSystemvueModel <em>Systemvue Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Systemvue Model</em>' containment reference.
	 * @see #getSystemvueModel()
	 * @generated
	 */
	void setSystemvueModel(SystemvueModel value);

} // DocumentRoot
