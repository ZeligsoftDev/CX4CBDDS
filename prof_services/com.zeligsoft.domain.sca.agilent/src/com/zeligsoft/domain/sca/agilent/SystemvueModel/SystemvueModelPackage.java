/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.sca.agilent.SystemvueModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModelFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface SystemvueModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SystemvueModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.agilent.com/2009/SystemvueModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SystemvueModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemvueModelPackage eINSTANCE = com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Header File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HEADER_FILE = 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PORT = 5;

	/**
	 * The feature id for the '<em><b>Systemvue Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SYSTEMVUE_MODEL = 6;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.HeaderFileImpl <em>Header File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.HeaderFileImpl
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getHeaderFile()
	 * @generated
	 */
	int HEADER_FILE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_FILE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Header File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_FILE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IMPLEMENTATION = 1;

	/**
	 * The feature id for the '<em><b>Member Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MEMBER_NAME = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 3;

	/**
	 * The feature id for the '<em><b>Size Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__SIZE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE_NAME = 5;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 3;

	/**
	 * The feature id for the '<em><b>Bus Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BUS_SIZE = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DIRECTION = 2;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IMPLEMENTATION = 3;

	/**
	 * The feature id for the '<em><b>Member Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MEMBER_NAME = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 5;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__RATE = 6;

	/**
	 * The feature id for the '<em><b>Rate Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__RATE_VARIABLE_NAME = 7;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE_NAME = 8;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl <em>Systemvue Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getSystemvueModel()
	 * @generated
	 */
	int SYSTEMVUE_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Header File</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__HEADER_FILE = 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__PORT = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__NAME = 5;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__NAMESPACE = 6;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL__TYPE_NAME = 7;

	/**
	 * The number of structural features of the '<em>Systemvue Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEMVUE_MODEL_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType <em>Direction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getDirectionType()
	 * @generated
	 */
	int DIRECTION_TYPE = 5;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation <em>Implementation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 6;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType <em>Implementation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementationType()
	 * @generated
	 */
	int IMPLEMENTATION_TYPE = 7;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName <em>Type Name</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeName()
	 * @generated
	 */
	int TYPE_NAME = 8;

	/**
	 * The meta object id for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType <em>Type Name Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeNameType()
	 * @generated
	 */
	int TYPE_NAME_TYPE = 9;

	/**
	 * The meta object id for the '<em>Direction Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getDirectionTypeObject()
	 * @generated
	 */
	int DIRECTION_TYPE_OBJECT = 10;

	/**
	 * The meta object id for the '<em>Implementation Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementationObject()
	 * @generated
	 */
	int IMPLEMENTATION_OBJECT = 11;

	/**
	 * The meta object id for the '<em>Implementation Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementationTypeObject()
	 * @generated
	 */
	int IMPLEMENTATION_TYPE_OBJECT = 12;

	/**
	 * The meta object id for the '<em>Type Name Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeNameObject()
	 * @generated
	 */
	int TYPE_NAME_OBJECT = 13;

	/**
	 * The meta object id for the '<em>Type Name Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeNameTypeObject()
	 * @generated
	 */
	int TYPE_NAME_TYPE_OBJECT = 14;


	/**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getHeaderFile <em>Header File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header File</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getHeaderFile()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_HeaderFile();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getParameter()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Port</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getPort()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Port();

	/**
	 * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getSystemvueModel <em>Systemvue Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Systemvue Model</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DocumentRoot#getSystemvueModel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SystemvueModel();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile <em>Header File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header File</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile
	 * @generated
	 */
	EClass getHeaderFile();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.HeaderFile#getName()
	 * @see #getHeaderFile()
	 * @generated
	 */
	EAttribute getHeaderFile_Name();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getDescription()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getImplementation()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Implementation();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getMemberName <em>Member Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getMemberName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_MemberName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getSizeName <em>Size Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getSizeName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_SizeName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Parameter#getTypeName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_TypeName();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getBusSize <em>Bus Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bus Size</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getBusSize()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_BusSize();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDescription()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getDirection()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Direction();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getImplementation()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Implementation();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getMemberName <em>Member Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Member Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getMemberName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_MemberName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRate()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Rate();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRateVariableName <em>Rate Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate Variable Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getRateVariableName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_RateVariableName();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Port#getTypeName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_TypeName();

	/**
	 * Returns the meta object for class '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel <em>Systemvue Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Systemvue Model</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel
	 * @generated
	 */
	EClass getSystemvueModel();

	/**
	 * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getGroup()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EAttribute getSystemvueModel_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getParameter()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EReference getSystemvueModel_Parameter();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getHeaderFile <em>Header File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Header File</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getHeaderFile()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EReference getSystemvueModel_HeaderFile();

	/**
	 * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getPort()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EReference getSystemvueModel_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getDescription()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EAttribute getSystemvueModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getName()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EAttribute getSystemvueModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getNamespace()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EAttribute getSystemvueModel_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.SystemvueModel#getTypeName()
	 * @see #getSystemvueModel()
	 * @generated
	 */
	EAttribute getSystemvueModel_TypeName();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType <em>Direction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Type</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
	 * @generated
	 */
	EEnum getDirectionType();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Implementation</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
	 * @generated
	 */
	EEnum getImplementation();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType <em>Implementation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Implementation Type</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
	 * @generated
	 */
	EEnum getImplementationType();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Name</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
	 * @generated
	 */
	EEnum getTypeName();

	/**
	 * Returns the meta object for enum '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType <em>Type Name Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Name Type</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
	 * @generated
	 */
	EEnum getTypeNameType();

	/**
	 * Returns the meta object for data type '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType <em>Direction Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Direction Type Object</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
	 * @model instanceClass="com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType"
	 *        extendedMetaData="name='direction_._type:Object' baseType='direction_._type'"
	 * @generated
	 */
	EDataType getDirectionTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation <em>Implementation Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Implementation Object</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
	 * @model instanceClass="com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation"
	 *        extendedMetaData="name='implementation:Object' baseType='implementation'"
	 * @generated
	 */
	EDataType getImplementationObject();

	/**
	 * Returns the meta object for data type '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType <em>Implementation Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Implementation Type Object</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
	 * @model instanceClass="com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType"
	 *        extendedMetaData="name='implementation_._type:Object' baseType='implementation_._type'"
	 * @generated
	 */
	EDataType getImplementationTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName <em>Type Name Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Name Object</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
	 * @model instanceClass="com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName"
	 *        extendedMetaData="name='type_name:Object' baseType='type_name'"
	 * @generated
	 */
	EDataType getTypeNameObject();

	/**
	 * Returns the meta object for data type '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType <em>Type Name Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Name Type Object</em>'.
	 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
	 * @model instanceClass="com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType"
	 *        extendedMetaData="name='type_name_._type:Object' baseType='type_name_._type'"
	 * @generated
	 */
	EDataType getTypeNameTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemvueModelFactory getSystemvueModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.DocumentRootImpl
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Header File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HEADER_FILE = eINSTANCE.getDocumentRoot_HeaderFile();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PARAMETER = eINSTANCE.getDocumentRoot_Parameter();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PORT = eINSTANCE.getDocumentRoot_Port();

		/**
		 * The meta object literal for the '<em><b>Systemvue Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SYSTEMVUE_MODEL = eINSTANCE.getDocumentRoot_SystemvueModel();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.HeaderFileImpl <em>Header File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.HeaderFileImpl
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getHeaderFile()
		 * @generated
		 */
		EClass HEADER_FILE = eINSTANCE.getHeaderFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER_FILE__NAME = eINSTANCE.getHeaderFile_Name();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.ParameterImpl
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DESCRIPTION = eINSTANCE.getParameter_Description();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IMPLEMENTATION = eINSTANCE.getParameter_Implementation();

		/**
		 * The meta object literal for the '<em><b>Member Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__MEMBER_NAME = eINSTANCE.getParameter_MemberName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Size Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__SIZE_NAME = eINSTANCE.getParameter_SizeName();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__TYPE_NAME = eINSTANCE.getParameter_TypeName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.PortImpl
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Bus Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__BUS_SIZE = eINSTANCE.getPort_BusSize();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__DESCRIPTION = eINSTANCE.getPort_Description();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__DIRECTION = eINSTANCE.getPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__IMPLEMENTATION = eINSTANCE.getPort_Implementation();

		/**
		 * The meta object literal for the '<em><b>Member Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__MEMBER_NAME = eINSTANCE.getPort_MemberName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__RATE = eINSTANCE.getPort_Rate();

		/**
		 * The meta object literal for the '<em><b>Rate Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__RATE_VARIABLE_NAME = eINSTANCE.getPort_RateVariableName();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TYPE_NAME = eINSTANCE.getPort_TypeName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl <em>Systemvue Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelImpl
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getSystemvueModel()
		 * @generated
		 */
		EClass SYSTEMVUE_MODEL = eINSTANCE.getSystemvueModel();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEMVUE_MODEL__GROUP = eINSTANCE.getSystemvueModel_Group();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEMVUE_MODEL__PARAMETER = eINSTANCE.getSystemvueModel_Parameter();

		/**
		 * The meta object literal for the '<em><b>Header File</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEMVUE_MODEL__HEADER_FILE = eINSTANCE.getSystemvueModel_HeaderFile();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEMVUE_MODEL__PORT = eINSTANCE.getSystemvueModel_Port();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEMVUE_MODEL__DESCRIPTION = eINSTANCE.getSystemvueModel_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEMVUE_MODEL__NAME = eINSTANCE.getSystemvueModel_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEMVUE_MODEL__NAMESPACE = eINSTANCE.getSystemvueModel_Namespace();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEMVUE_MODEL__TYPE_NAME = eINSTANCE.getSystemvueModel_TypeName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType <em>Direction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getDirectionType()
		 * @generated
		 */
		EEnum DIRECTION_TYPE = eINSTANCE.getDirectionType();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation <em>Implementation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementation()
		 * @generated
		 */
		EEnum IMPLEMENTATION = eINSTANCE.getImplementation();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType <em>Implementation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementationType()
		 * @generated
		 */
		EEnum IMPLEMENTATION_TYPE = eINSTANCE.getImplementationType();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName <em>Type Name</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeName()
		 * @generated
		 */
		EEnum TYPE_NAME = eINSTANCE.getTypeName();

		/**
		 * The meta object literal for the '{@link com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType <em>Type Name Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeNameType()
		 * @generated
		 */
		EEnum TYPE_NAME_TYPE = eINSTANCE.getTypeNameType();

		/**
		 * The meta object literal for the '<em>Direction Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.DirectionType
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getDirectionTypeObject()
		 * @generated
		 */
		EDataType DIRECTION_TYPE_OBJECT = eINSTANCE.getDirectionTypeObject();

		/**
		 * The meta object literal for the '<em>Implementation Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.Implementation
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementationObject()
		 * @generated
		 */
		EDataType IMPLEMENTATION_OBJECT = eINSTANCE.getImplementationObject();

		/**
		 * The meta object literal for the '<em>Implementation Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.ImplementationType
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getImplementationTypeObject()
		 * @generated
		 */
		EDataType IMPLEMENTATION_TYPE_OBJECT = eINSTANCE.getImplementationTypeObject();

		/**
		 * The meta object literal for the '<em>Type Name Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeName
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeNameObject()
		 * @generated
		 */
		EDataType TYPE_NAME_OBJECT = eINSTANCE.getTypeNameObject();

		/**
		 * The meta object literal for the '<em>Type Name Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.TypeNameType
		 * @see com.zeligsoft.domain.sca.agilent.SystemvueModel.impl.SystemvueModelPackageImpl#getTypeNameTypeObject()
		 * @generated
		 */
		EDataType TYPE_NAME_TYPE_OBJECT = eINSTANCE.getTypeNameTypeObject();

	}

} //SystemvueModelPackage
