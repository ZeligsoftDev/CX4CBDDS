/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlFactory
 * @model kind="package"
 * @generated
 */
public interface IdlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "idl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.zeligsoft.com/2008/idl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "idl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IdlPackage eINSTANCE = com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl.init();

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SpecificationImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSpecification()
   * @generated
   */
  int SPECIFICATION = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__DEFINITIONS = 1;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.DefinitionImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 29;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PreprocImpl <em>Preproc</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PreprocImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc()
   * @generated
   */
  int PREPROC = 1;

  /**
   * The number of structural features of the '<em>Preproc</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IncludeImpl <em>Preproc Include</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IncludeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Include()
   * @generated
   */
  int PREPROC_INCLUDE = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_INCLUDE__VALUE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Str Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_INCLUDE__STR_VALUE = PREPROC_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Preproc Include</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_INCLUDE_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FileNameImpl <em>File Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FileNameImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFileName()
   * @generated
   */
  int FILE_NAME = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_NAME__NAME = 0;

  /**
   * The number of structural features of the '<em>File Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfdefImpl <em>Preproc Ifdef</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfdefImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Ifdef()
   * @generated
   */
  int PREPROC_IFDEF = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IFDEF__VALUE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Ifdef</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IFDEF_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfndefImpl <em>Preproc Ifndef</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfndefImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Ifndef()
   * @generated
   */
  int PREPROC_IFNDEF = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IFNDEF__VALUE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Ifndef</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IFNDEF_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_UndefImpl <em>Preproc Undef</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_UndefImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Undef()
   * @generated
   */
  int PREPROC_UNDEF = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_UNDEF__VALUE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Undef</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_UNDEF_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfImpl <em>Preproc If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_If()
   * @generated
   */
  int PREPROC_IF = 7;

  /**
   * The feature id for the '<em><b>Negation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF__NEGATION = PREPROC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF__VALUE = PREPROC_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Preproc If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_CompareImpl <em>Preproc If Compare</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_CompareImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_If_Compare()
   * @generated
   */
  int PREPROC_IF_COMPARE = 8;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_COMPARE__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_COMPARE__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_COMPARE__RHS = 2;

  /**
   * The number of structural features of the '<em>Preproc If Compare</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_COMPARE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_ValImpl <em>Preproc If Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_ValImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_If_Val()
   * @generated
   */
  int PREPROC_IF_VAL = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_VAL__VALUE = 0;

  /**
   * The number of structural features of the '<em>Preproc If Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_IF_VAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ElseImpl <em>Preproc Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ElseImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Else()
   * @generated
   */
  int PREPROC_ELSE = 10;

  /**
   * The number of structural features of the '<em>Preproc Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_ELSE_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ErrorImpl <em>Preproc Error</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ErrorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Error()
   * @generated
   */
  int PREPROC_ERROR = 11;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_ERROR__VALUE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Error</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_ERROR_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_DefineImpl <em>Preproc Define</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_DefineImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Define()
   * @generated
   */
  int PREPROC_DEFINE = 12;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_DEFINE__VALUE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_DEFINE__EXP = PREPROC_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Preproc Define</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_DEFINE_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_EndifImpl <em>Preproc Endif</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_EndifImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Endif()
   * @generated
   */
  int PREPROC_ENDIF = 13;

  /**
   * The number of structural features of the '<em>Preproc Endif</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_ENDIF_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_PragmaImpl <em>Preproc Pragma</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_PragmaImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma()
   * @generated
   */
  int PREPROC_PRAGMA = 14;

  /**
   * The number of structural features of the '<em>Preproc Pragma</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_PrefixImpl <em>Preproc Pragma Prefix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_PrefixImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Prefix()
   * @generated
   */
  int PREPROC_PRAGMA_PREFIX = 15;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_PREFIX__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Prefix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_PREFIX_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Conn_TypeImpl <em>Preproc Pragma Conn Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Conn_TypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Conn_Type()
   * @generated
   */
  int PREPROC_PRAGMA_CONN_TYPE = 16;

  /**
   * The feature id for the '<em><b>Value Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value Conn Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Preproc Pragma Conn Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CONN_TYPE_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_LemImpl <em>Preproc Pragma Ciao Lem</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_LemImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Lem()
   * @generated
   */
  int PREPROC_PRAGMA_CIAO_LEM = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_LEM__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Ciao Lem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_LEM_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_InterfaceImpl <em>Preproc Pragma Ciao Ami4ccm Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_InterfaceImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Ami4ccm_Interface()
   * @generated
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE = 18;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Ciao Ami4ccm Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_ReceptacleImpl <em>Preproc Pragma Ciao Ami4ccm Receptacle</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_ReceptacleImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Ami4ccm_Receptacle()
   * @generated
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE = 19;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Ciao Ami4ccm Receptacle</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_IdlImpl <em>Preproc Pragma Ciao Ami4ccm Idl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_IdlImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Ami4ccm_Idl()
   * @generated
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_IDL = 20;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_IDL__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Ciao Ami4ccm Idl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_CIAO_AMI4CCM_IDL_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_NddsImpl <em>Preproc Pragma Ndds</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_NddsImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ndds()
   * @generated
   */
  int PREPROC_PRAGMA_NDDS = 21;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_NDDS__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Ndds</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_NDDS_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_ComponentImpl <em>Preproc Pragma Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_ComponentImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Component()
   * @generated
   */
  int PREPROC_PRAGMA_COMPONENT = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_COMPONENT__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_COMPONENT_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_HomeImpl <em>Preproc Pragma Home</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_HomeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Home()
   * @generated
   */
  int PREPROC_PRAGMA_HOME = 23;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_HOME__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma Home</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_HOME_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_DDS4CCM_ImplImpl <em>Preproc Pragma DDS4CCM Impl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_DDS4CCM_ImplImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_DDS4CCM_Impl()
   * @generated
   */
  int PREPROC_PRAGMA_DDS4CCM_IMPL = 24;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_DDS4CCM_IMPL__VALUE = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Preproc Pragma DDS4CCM Impl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_DDS4CCM_IMPL_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_MiscImpl <em>Preproc Pragma Misc</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_MiscImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Misc()
   * @generated
   */
  int PREPROC_PRAGMA_MISC = 25;

  /**
   * The number of structural features of the '<em>Preproc Pragma Misc</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREPROC_PRAGMA_MISC_FEATURE_COUNT = PREPROC_PRAGMA_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.File_MarkerImpl <em>File Marker</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.File_MarkerImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFile_Marker()
   * @generated
   */
  int FILE_MARKER = 26;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_MARKER__FILE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>File Marker</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_MARKER_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Excluded_File_MarkerImpl <em>Excluded File Marker</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Excluded_File_MarkerImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExcluded_File_Marker()
   * @generated
   */
  int EXCLUDED_FILE_MARKER = 27;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDED_FILE_MARKER__FILE = PREPROC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Excluded File Marker</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDED_FILE_MARKER_FEATURE_COUNT = PREPROC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Import_declImpl <em>Import decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Import_declImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getImport_decl()
   * @generated
   */
  int IMPORT_DECL = 28;

  /**
   * The feature id for the '<em><b>Imported scope</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_DECL__IMPORTED_SCOPE = 0;

  /**
   * The number of structural features of the '<em>Import decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_DECL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ModuleImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getModule()
   * @generated
   */
  int MODULE = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__COMMENTS = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__DEFINITIONS = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_or_Forward_DeclImpl <em>Interface or Forward Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_or_Forward_DeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterface_or_Forward_Decl()
   * @generated
   */
  int INTERFACE_OR_FORWARD_DECL = 31;

  /**
   * The number of structural features of the '<em>Interface or Forward Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_OR_FORWARD_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_declImpl <em>Interface decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_declImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterface_decl()
   * @generated
   */
  int INTERFACE_DECL = 32;

  /**
   * The feature id for the '<em><b>Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECL__HEADER = INTERFACE_OR_FORWARD_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Interface Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECL__INTERFACE_BODY = INTERFACE_OR_FORWARD_DECL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Interface decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DECL_FEATURE_COUNT = INTERFACE_OR_FORWARD_DECL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Forward_declImpl <em>Forward decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Forward_declImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getForward_decl()
   * @generated
   */
  int FORWARD_DECL = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORWARD_DECL__NAME = INTERFACE_OR_FORWARD_DECL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Forward decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORWARD_DECL_FEATURE_COUNT = INTERFACE_OR_FORWARD_DECL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_headerImpl <em>Interface header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_headerImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterface_header()
   * @generated
   */
  int INTERFACE_HEADER = 34;

  /**
   * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_HEADER__IS_ABSTRACT = 0;

  /**
   * The feature id for the '<em><b>Is Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_HEADER__IS_LOCAL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_HEADER__NAME = 2;

  /**
   * The feature id for the '<em><b>Specializes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_HEADER__SPECIALIZES = 3;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_HEADER__COMMENTS = 4;

  /**
   * The number of structural features of the '<em>Interface header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_HEADER_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceBodyImpl <em>Interface Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceBodyImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterfaceBody()
   * @generated
   */
  int INTERFACE_BODY = 35;

  /**
   * The feature id for the '<em><b>Export</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_BODY__EXPORT = 0;

  /**
   * The number of structural features of the '<em>Interface Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeExportImpl <em>Home Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeExportImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getHomeExport()
   * @generated
   */
  int HOME_EXPORT = 122;

  /**
   * The number of structural features of the '<em>Home Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_EXPORT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExportImpl <em>Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExportImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExport()
   * @generated
   */
  int EXPORT = 36;

  /**
   * The number of structural features of the '<em>Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT_FEATURE_COUNT = HOME_EXPORT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrDeclImpl <em>Attr Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAttrDecl()
   * @generated
   */
  int ATTR_DECL = 37;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_DECL__COMMENTS = EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_DECL__TYPE = EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_DECL__NAMES = EXPORT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Attr Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_DECL_FEATURE_COUNT = EXPORT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrSpecImpl <em>Attr Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAttrSpec()
   * @generated
   */
  int ATTR_SPEC = 38;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_SPEC__COMMENTS = ATTR_DECL__COMMENTS;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_SPEC__TYPE = ATTR_DECL__TYPE;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_SPEC__NAMES = ATTR_DECL__NAMES;

  /**
   * The feature id for the '<em><b>Get Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_SPEC__GET_RAISES = ATTR_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Set Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_SPEC__SET_RAISES = ATTR_DECL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attr Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_SPEC_FEATURE_COUNT = ATTR_DECL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ReadOnlyAttrSpecImpl <em>Read Only Attr Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ReadOnlyAttrSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getReadOnlyAttrSpec()
   * @generated
   */
  int READ_ONLY_ATTR_SPEC = 39;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int READ_ONLY_ATTR_SPEC__COMMENTS = ATTR_DECL__COMMENTS;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int READ_ONLY_ATTR_SPEC__TYPE = ATTR_DECL__TYPE;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int READ_ONLY_ATTR_SPEC__NAMES = ATTR_DECL__NAMES;

  /**
   * The feature id for the '<em><b>Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int READ_ONLY_ATTR_SPEC__RAISES = ATTR_DECL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Read Only Attr Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int READ_ONLY_ATTR_SPEC_FEATURE_COUNT = ATTR_DECL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrRaisesExprImpl <em>Attr Raises Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrRaisesExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAttrRaisesExpr()
   * @generated
   */
  int ATTR_RAISES_EXPR = 40;

  /**
   * The feature id for the '<em><b>Exceptions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_RAISES_EXPR__EXCEPTIONS = 0;

  /**
   * The number of structural features of the '<em>Attr Raises Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_RAISES_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionListImpl <em>Exception List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionListImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExceptionList()
   * @generated
   */
  int EXCEPTION_LIST = 41;

  /**
   * The feature id for the '<em><b>Exception</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION_LIST__EXCEPTION = 0;

  /**
   * The number of structural features of the '<em>Exception List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpDeclImpl <em>Op Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOpDecl()
   * @generated
   */
  int OP_DECL = 42;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__COMMENTS = EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is Oneway</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__IS_ONEWAY = EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__TYPE = EXPORT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__NAME = EXPORT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__PARAMS = EXPORT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__RAISES = EXPORT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL__CONTEXT = EXPORT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Op Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DECL_FEATURE_COUNT = EXPORT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpTypeDeclImpl <em>Op Type Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpTypeDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOpTypeDecl()
   * @generated
   */
  int OP_TYPE_DECL = 43;

  /**
   * The number of structural features of the '<em>Op Type Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_TYPE_DECL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParameterDeclsImpl <em>Parameter Decls</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParameterDeclsImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParameterDecls()
   * @generated
   */
  int PARAMETER_DECLS = 44;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLS__COMMENTS = 0;

  /**
   * The feature id for the '<em><b>Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLS__DECLS = 1;

  /**
   * The number of structural features of the '<em>Parameter Decls</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamDclImpl <em>Param Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParamDcl()
   * @generated
   */
  int PARAM_DCL = 45;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_DCL__DIRECTION = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_DCL__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_DCL__NAME = 2;

  /**
   * The number of structural features of the '<em>Param Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_DCL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ContextExprImpl <em>Context Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ContextExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getContextExpr()
   * @generated
   */
  int CONTEXT_EXPR = 46;

  /**
   * The feature id for the '<em><b>Literal</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_EXPR__LITERAL = 0;

  /**
   * The number of structural features of the '<em>Context Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamTypeSpecImpl <em>Param Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamTypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParamTypeSpec()
   * @generated
   */
  int PARAM_TYPE_SPEC = 47;

  /**
   * The number of structural features of the '<em>Param Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_TYPE_SPEC_FEATURE_COUNT = OP_TYPE_DECL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ScopedNameImpl <em>Scoped Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ScopedNameImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getScopedName()
   * @generated
   */
  int SCOPED_NAME = 48;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPED_NAME__NAME = PARAM_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Scoped Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPED_NAME_FEATURE_COUNT = PARAM_TYPE_SPEC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.BaseTypeSpecImpl <em>Base Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.BaseTypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getBaseTypeSpec()
   * @generated
   */
  int BASE_TYPE_SPEC = 49;

  /**
   * The number of structural features of the '<em>Base Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_TYPE_SPEC_FEATURE_COUNT = PARAM_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatingPtTypeImpl <em>Floating Pt Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatingPtTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFloatingPtType()
   * @generated
   */
  int FLOATING_PT_TYPE = 50;

  /**
   * The number of structural features of the '<em>Floating Pt Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOATING_PT_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatTypeImpl <em>Float Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFloatType()
   * @generated
   */
  int FLOAT_TYPE = 51;

  /**
   * The number of structural features of the '<em>Float Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_TYPE_FEATURE_COUNT = FLOATING_PT_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.DoubleTypeImpl <em>Double Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.DoubleTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getDoubleType()
   * @generated
   */
  int DOUBLE_TYPE = 52;

  /**
   * The number of structural features of the '<em>Double Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_TYPE_FEATURE_COUNT = FLOATING_PT_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.LongDoubleTypeImpl <em>Long Double Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.LongDoubleTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getLongDoubleType()
   * @generated
   */
  int LONG_DOUBLE_TYPE = 53;

  /**
   * The number of structural features of the '<em>Long Double Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_DOUBLE_TYPE_FEATURE_COUNT = FLOATING_PT_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IntegerTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getIntegerType()
   * @generated
   */
  int INTEGER_TYPE = 54;

  /**
   * The number of structural features of the '<em>Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedIntImpl <em>Signed Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedInt()
   * @generated
   */
  int SIGNED_INT = 55;

  /**
   * The number of structural features of the '<em>Signed Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNED_INT_FEATURE_COUNT = INTEGER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedShortIntImpl <em>Signed Short Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedShortIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedShortInt()
   * @generated
   */
  int SIGNED_SHORT_INT = 56;

  /**
   * The number of structural features of the '<em>Signed Short Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNED_SHORT_INT_FEATURE_COUNT = SIGNED_INT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongIntImpl <em>Signed Long Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedLongInt()
   * @generated
   */
  int SIGNED_LONG_INT = 57;

  /**
   * The number of structural features of the '<em>Signed Long Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNED_LONG_INT_FEATURE_COUNT = SIGNED_INT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongLongIntImpl <em>Signed Long Long Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongLongIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedLongLongInt()
   * @generated
   */
  int SIGNED_LONG_LONG_INT = 58;

  /**
   * The number of structural features of the '<em>Signed Long Long Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNED_LONG_LONG_INT_FEATURE_COUNT = SIGNED_INT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedIntImpl <em>Unsigned Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedInt()
   * @generated
   */
  int UNSIGNED_INT = 59;

  /**
   * The number of structural features of the '<em>Unsigned Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSIGNED_INT_FEATURE_COUNT = INTEGER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedShortIntImpl <em>Unsigned Short Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedShortIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedShortInt()
   * @generated
   */
  int UNSIGNED_SHORT_INT = 60;

  /**
   * The number of structural features of the '<em>Unsigned Short Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSIGNED_SHORT_INT_FEATURE_COUNT = UNSIGNED_INT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongIntImpl <em>Unsigned Long Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedLongInt()
   * @generated
   */
  int UNSIGNED_LONG_INT = 61;

  /**
   * The number of structural features of the '<em>Unsigned Long Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSIGNED_LONG_INT_FEATURE_COUNT = UNSIGNED_INT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongLongIntImpl <em>Unsigned Long Long Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongLongIntImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedLongLongInt()
   * @generated
   */
  int UNSIGNED_LONG_LONG_INT = 62;

  /**
   * The number of structural features of the '<em>Unsigned Long Long Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSIGNED_LONG_LONG_INT_FEATURE_COUNT = UNSIGNED_INT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CharTypeImpl <em>Char Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.CharTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getCharType()
   * @generated
   */
  int CHAR_TYPE = 63;

  /**
   * The number of structural features of the '<em>Char Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAR_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideCharTypeImpl <em>Wide Char Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideCharTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getWideCharType()
   * @generated
   */
  int WIDE_CHAR_TYPE = 64;

  /**
   * The number of structural features of the '<em>Wide Char Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDE_CHAR_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.BooleanTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 65;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OctetTypeImpl <em>Octet Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OctetTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOctetType()
   * @generated
   */
  int OCTET_TYPE = 66;

  /**
   * The number of structural features of the '<em>Octet Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCTET_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AnyTypeImpl <em>Any Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AnyTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAnyType()
   * @generated
   */
  int ANY_TYPE = 67;

  /**
   * The number of structural features of the '<em>Any Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ObjectTypeImpl <em>Object Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ObjectTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getObjectType()
   * @generated
   */
  int OBJECT_TYPE = 68;

  /**
   * The number of structural features of the '<em>Object Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValueBaseTypeImpl <em>Value Base Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValueBaseTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getValueBaseType()
   * @generated
   */
  int VALUE_BASE_TYPE = 69;

  /**
   * The number of structural features of the '<em>Value Base Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_BASE_TYPE_FEATURE_COUNT = BASE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StringTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 70;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE__SIZE = PARAM_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = PARAM_TYPE_SPEC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideStringTypeImpl <em>Wide String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideStringTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getWideStringType()
   * @generated
   */
  int WIDE_STRING_TYPE = 71;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDE_STRING_TYPE__SIZE = PARAM_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Wide String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WIDE_STRING_TYPE_FEATURE_COUNT = PARAM_TYPE_SPEC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptDeclImpl <em>Except Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExceptDecl()
   * @generated
   */
  int EXCEPT_DECL = 72;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPT_DECL__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPT_DECL__COMMENTS = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPT_DECL__MEMBERS = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Except Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPT_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.MemberImpl <em>Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.MemberImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getMember()
   * @generated
   */
  int MEMBER = 73;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER__DECL = 1;

  /**
   * The feature id for the '<em><b>Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER__COMMENT = 2;

  /**
   * The number of structural features of the '<em>Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.DeclaratorImpl <em>Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.DeclaratorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getDeclarator()
   * @generated
   */
  int DECLARATOR = 74;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__ID = 0;

  /**
   * The number of structural features of the '<em>Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleDeclaratorImpl <em>Simple Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleDeclaratorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSimpleDeclarator()
   * @generated
   */
  int SIMPLE_DECLARATOR = 75;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_DECLARATOR__ID = DECLARATOR__ID;

  /**
   * The number of structural features of the '<em>Simple Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_DECLARATOR_FEATURE_COUNT = DECLARATOR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComplexDeclaratorImpl <em>Complex Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComplexDeclaratorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComplexDeclarator()
   * @generated
   */
  int COMPLEX_DECLARATOR = 76;

  /**
   * The number of structural features of the '<em>Complex Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_DECLARATOR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ArrayDeclaratorImpl <em>Array Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ArrayDeclaratorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getArrayDeclarator()
   * @generated
   */
  int ARRAY_DECLARATOR = 77;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DECLARATOR__ID = DECLARATOR__ID;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DECLARATOR__SIZE = DECLARATOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DECLARATOR_FEATURE_COUNT = DECLARATOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructTypeImpl <em>Struct Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStructType()
   * @generated
   */
  int STRUCT_TYPE = 78;

  /**
   * The feature id for the '<em><b>Extensibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_TYPE__EXTENSIBILITY = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_TYPE__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_TYPE__COMMENTS = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_TYPE__MEMBERS = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Struct Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_TYPE_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclImpl <em>Type Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypeDecl()
   * @generated
   */
  int TYPE_DECL = 79;

  /**
   * The number of structural features of the '<em>Type Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl <em>Type Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypeDeclarator()
   * @generated
   */
  int TYPE_DECLARATOR = 80;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATOR__COMMENTS = TYPE_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATOR__TYPE = TYPE_DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Declarators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATOR__DECLARATORS = TYPE_DECL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Type Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATOR_FEATURE_COUNT = TYPE_DECL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ActualParameterImpl <em>Actual Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ActualParameterImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getActualParameter()
   * @generated
   */
  int ACTUAL_PARAMETER = 152;

  /**
   * The number of structural features of the '<em>Actual Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PARAMETER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeSpecImpl <em>Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypeSpec()
   * @generated
   */
  int TYPE_SPEC = 81;

  /**
   * The number of structural features of the '<em>Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPEC_FEATURE_COUNT = ACTUAL_PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleTypeSpecImpl <em>Simple Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleTypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSimpleTypeSpec()
   * @generated
   */
  int SIMPLE_TYPE_SPEC = 82;

  /**
   * The number of structural features of the '<em>Simple Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TYPE_SPEC_FEATURE_COUNT = TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateTypeSpecImpl <em>Template Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateTypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateTypeSpec()
   * @generated
   */
  int TEMPLATE_TYPE_SPEC = 83;

  /**
   * The number of structural features of the '<em>Template Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_TYPE_SPEC_FEATURE_COUNT = SIMPLE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrTypeSpecImpl <em>Constr Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrTypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstrTypeSpec()
   * @generated
   */
  int CONSTR_TYPE_SPEC = 84;

  /**
   * The number of structural features of the '<em>Constr Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTR_TYPE_SPEC_FEATURE_COUNT = TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionTypeImpl <em>Union Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnionType()
   * @generated
   */
  int UNION_TYPE = 85;

  /**
   * The feature id for the '<em><b>Extensibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__EXTENSIBILITY = TYPE_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__NAME = TYPE_DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__COMMENTS = TYPE_DECL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Switch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__SWITCH = TYPE_DECL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__BODY = TYPE_DECL_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Union Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE_FEATURE_COUNT = TYPE_DECL_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchTypeSpecImpl <em>Switch Type Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchTypeSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSwitchTypeSpec()
   * @generated
   */
  int SWITCH_TYPE_SPEC = 86;

  /**
   * The number of structural features of the '<em>Switch Type Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_TYPE_SPEC_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchBodyImpl <em>Switch Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchBodyImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSwitchBody()
   * @generated
   */
  int SWITCH_BODY = 87;

  /**
   * The feature id for the '<em><b>Case</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_BODY__CASE = 0;

  /**
   * The number of structural features of the '<em>Switch Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseImpl <em>Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getCase()
   * @generated
   */
  int CASE = 88;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE__COMMENTS = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE__LABEL = 1;

  /**
   * The feature id for the '<em><b>Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE__SPEC = 2;

  /**
   * The number of structural features of the '<em>Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl <em>Case Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getCaseLabel()
   * @generated
   */
  int CASE_LABEL = 89;

  /**
   * The feature id for the '<em><b>Is Case</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_LABEL__IS_CASE = 0;

  /**
   * The feature id for the '<em><b>Const Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_LABEL__CONST_EXP = 1;

  /**
   * The feature id for the '<em><b>Is Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_LABEL__IS_DEFAULT = 2;

  /**
   * The number of structural features of the '<em>Case Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_LABEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ElementSpecImpl <em>Element Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ElementSpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getElementSpec()
   * @generated
   */
  int ELEMENT_SPEC = 90;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SPEC__TYPE = 0;

  /**
   * The feature id for the '<em><b>Declarator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SPEC__DECLARATOR = 1;

  /**
   * The number of structural features of the '<em>Element Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SPEC_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumTypeImpl <em>Enum Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEnumType()
   * @generated
   */
  int ENUM_TYPE = 91;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__NAME = TYPE_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__COMMENTS = TYPE_DECL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Literal</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__LITERAL = TYPE_DECL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Enum Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_FEATURE_COUNT = TYPE_DECL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSequenceType()
   * @generated
   */
  int SEQUENCE_TYPE = 92;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_TYPE__TYPE = TEMPLATE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_TYPE__SIZE = TEMPLATE_TYPE_SPEC_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Sequence Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_TYPE_FEATURE_COUNT = TEMPLATE_TYPE_SPEC_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.NativeTypeImpl <em>Native Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.NativeTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getNativeType()
   * @generated
   */
  int NATIVE_TYPE = 93;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_TYPE__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Native Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_TYPE_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtTypeImpl <em>Fixed Pt Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedPtType()
   * @generated
   */
  int FIXED_PT_TYPE = 94;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_PT_TYPE__LOWER = TEMPLATE_TYPE_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_PT_TYPE__UPPER = TEMPLATE_TYPE_SPEC_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fixed Pt Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_PT_TYPE_FEATURE_COUNT = TEMPLATE_TYPE_SPEC_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrForwardDeclImpl <em>Constr Forward Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrForwardDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstrForwardDecl()
   * @generated
   */
  int CONSTR_FORWARD_DECL = 95;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTR_FORWARD_DECL__NAME = TYPE_DECL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constr Forward Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTR_FORWARD_DECL_FEATURE_COUNT = TYPE_DECL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructForwardDeclImpl <em>Struct Forward Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructForwardDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStructForwardDecl()
   * @generated
   */
  int STRUCT_FORWARD_DECL = 96;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_FORWARD_DECL__NAME = CONSTR_FORWARD_DECL__NAME;

  /**
   * The number of structural features of the '<em>Struct Forward Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_FORWARD_DECL_FEATURE_COUNT = CONSTR_FORWARD_DECL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionForwardDeclImpl <em>Union Forward Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionForwardDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnionForwardDecl()
   * @generated
   */
  int UNION_FORWARD_DECL = 97;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_FORWARD_DECL__NAME = CONSTR_FORWARD_DECL__NAME;

  /**
   * The number of structural features of the '<em>Union Forward Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_FORWARD_DECL_FEATURE_COUNT = CONSTR_FORWARD_DECL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PositiveIntConstImpl <em>Positive Int Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PositiveIntConstImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPositiveIntConst()
   * @generated
   */
  int POSITIVE_INT_CONST = 98;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITIVE_INT_CONST__EXP = 0;

  /**
   * The number of structural features of the '<em>Positive Int Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITIVE_INT_CONST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstDeclImpl <em>Const Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstDecl()
   * @generated
   */
  int CONST_DECL = 99;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DECL__TYPE = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DECL__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DECL__VALUE = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DECL__COMMENTS = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Const Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterTypeImpl <em>Formal Parameter Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFormalParameterType()
   * @generated
   */
  int FORMAL_PARAMETER_TYPE = 137;

  /**
   * The number of structural features of the '<em>Formal Parameter Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstParamTypeImpl <em>Const Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstParamType()
   * @generated
   */
  int CONST_PARAM_TYPE = 147;

  /**
   * The number of structural features of the '<em>Const Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstTypeImpl <em>Const Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstType()
   * @generated
   */
  int CONST_TYPE = 100;

  /**
   * The number of structural features of the '<em>Const Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_TYPE_FEATURE_COUNT = CONST_PARAM_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtConstTypeImpl <em>Fixed Pt Const Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtConstTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedPtConstType()
   * @generated
   */
  int FIXED_PT_CONST_TYPE = 101;

  /**
   * The number of structural features of the '<em>Fixed Pt Const Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_PT_CONST_TYPE_FEATURE_COUNT = CONST_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryExprImpl <em>Primary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPrimaryExpr()
   * @generated
   */
  int PRIMARY_EXPR = 110;

  /**
   * The number of structural features of the '<em>Primary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstExpImpl <em>Const Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstExpImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstExp()
   * @generated
   */
  int CONST_EXP = 102;

  /**
   * The number of structural features of the '<em>Const Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONST_EXP_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OrExprImpl <em>Or Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OrExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOrExpr()
   * @generated
   */
  int OR_EXPR = 103;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR__LHS = CONST_EXP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR__OP = CONST_EXP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR__RHS = CONST_EXP_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Or Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR_FEATURE_COUNT = CONST_EXP_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.XOrExprImpl <em>XOr Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.XOrExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getXOrExpr()
   * @generated
   */
  int XOR_EXPR = 104;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>XOr Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AndExprImpl <em>And Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AndExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAndExpr()
   * @generated
   */
  int AND_EXPR = 105;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>And Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ShiftExprImpl <em>Shift Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ShiftExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getShiftExpr()
   * @generated
   */
  int SHIFT_EXPR = 106;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>Shift Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AddExprImpl <em>Add Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AddExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAddExpr()
   * @generated
   */
  int ADD_EXPR = 107;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>Add Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.MultExprImpl <em>Mult Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.MultExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getMultExpr()
   * @generated
   */
  int MULT_EXPR = 108;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>Mult Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnaryExprImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnaryExpr()
   * @generated
   */
  int UNARY_EXPR = 109;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OP = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__EXPR = 1;

  /**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.LiteralImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 111;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__VALUE = PRIMARY_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = PRIMARY_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl <em>Component Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComponentDecl()
   * @generated
   */
  int COMPONENT_DECL = 112;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_DECL__COMMENTS = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_DECL__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_DECL__BASE = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Supports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_DECL__SUPPORTS = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Export</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_DECL__EXPORT = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Component Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentExportImpl <em>Component Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentExportImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComponentExport()
   * @generated
   */
  int COMPONENT_EXPORT = 113;

  /**
   * The number of structural features of the '<em>Component Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_EXPORT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ProvidesDclImpl <em>Provides Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ProvidesDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getProvidesDcl()
   * @generated
   */
  int PROVIDES_DCL = 114;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDES_DCL__TYPE = COMPONENT_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDES_DCL__NAME = COMPONENT_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDES_DCL__COMMENTS = COMPONENT_EXPORT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Provides Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDES_DCL_FEATURE_COUNT = COMPONENT_EXPORT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl <em>Uses Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUsesDcl()
   * @generated
   */
  int USES_DCL = 115;

  /**
   * The feature id for the '<em><b>Is Multiple</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_DCL__IS_MULTIPLE = COMPONENT_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_DCL__TYPE = COMPONENT_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_DCL__NAME = COMPONENT_EXPORT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_DCL__COMMENTS = COMPONENT_EXPORT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Uses Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_DCL_FEATURE_COUNT = COMPONENT_EXPORT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PublishesDclImpl <em>Publishes Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PublishesDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPublishesDcl()
   * @generated
   */
  int PUBLISHES_DCL = 116;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUBLISHES_DCL__TYPE = COMPONENT_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUBLISHES_DCL__NAME = COMPONENT_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUBLISHES_DCL__COMMENTS = COMPONENT_EXPORT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Publishes Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUBLISHES_DCL_FEATURE_COUNT = COMPONENT_EXPORT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EmitDclImpl <em>Emit Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EmitDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEmitDcl()
   * @generated
   */
  int EMIT_DCL = 117;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMIT_DCL__TYPE = COMPONENT_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMIT_DCL__NAME = COMPONENT_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMIT_DCL__COMMENTS = COMPONENT_EXPORT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Emit Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMIT_DCL_FEATURE_COUNT = COMPONENT_EXPORT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConsumesDclImpl <em>Consumes Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConsumesDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConsumesDcl()
   * @generated
   */
  int CONSUMES_DCL = 118;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMES_DCL__TYPE = COMPONENT_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMES_DCL__NAME = COMPONENT_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMES_DCL__COMMENTS = COMPONENT_EXPORT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Consumes Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSUMES_DCL_FEATURE_COUNT = COMPONENT_EXPORT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentForwardDeclImpl <em>Component Forward Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentForwardDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComponentForwardDecl()
   * @generated
   */
  int COMPONENT_FORWARD_DECL = 119;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_FORWARD_DECL__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Component Forward Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_FORWARD_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl <em>Home Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getHomeDecl()
   * @generated
   */
  int HOME_DECL = 120;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__COMMENTS = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__BASE = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Supports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__SUPPORTS = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Manages</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__MANAGES = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Primary key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__PRIMARY_KEY = DEFINITION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Export</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL__EXPORT = DEFINITION_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Home Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOME_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryKeySpecImpl <em>Primary Key Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryKeySpecImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPrimaryKeySpec()
   * @generated
   */
  int PRIMARY_KEY_SPEC = 121;

  /**
   * The feature id for the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_KEY_SPEC__KEY = 0;

  /**
   * The number of structural features of the '<em>Primary Key Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_KEY_SPEC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FactoryDclImpl <em>Factory Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FactoryDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFactoryDcl()
   * @generated
   */
  int FACTORY_DCL = 123;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_DCL__COMMENTS = HOME_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_DCL__NAME = HOME_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_DCL__PARAMS = HOME_EXPORT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_DCL__RAISES = HOME_EXPORT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Factory Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_DCL_FEATURE_COUNT = HOME_EXPORT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl <em>Finder Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFinderDcl()
   * @generated
   */
  int FINDER_DCL = 124;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINDER_DCL__COMMENTS = HOME_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINDER_DCL__NAME = HOME_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINDER_DCL__PARAMS = HOME_EXPORT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Raises</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINDER_DCL__RAISES = HOME_EXPORT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Finder Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINDER_DCL_FEATURE_COUNT = HOME_EXPORT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 125;

  /**
   * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__IS_ABSTRACT = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl <em>Event Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEventDcl()
   * @generated
   */
  int EVENT_DCL = 126;

  /**
   * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__IS_ABSTRACT = EVENT__IS_ABSTRACT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__NAME = EVENT__NAME;

  /**
   * The feature id for the '<em><b>Is Custom</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__IS_CUSTOM = EVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is Truncatable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__IS_TRUNCATABLE = EVENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__BASE = EVENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Supports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__SUPPORTS = EVENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Export</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__EXPORT = EVENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Member</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL__MEMBER = EVENT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Event Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DCL_FEATURE_COUNT = EVENT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StateMemberImpl <em>State Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StateMemberImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStateMember()
   * @generated
   */
  int STATE_MEMBER = 127;

  /**
   * The feature id for the '<em><b>Is Public</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MEMBER__IS_PUBLIC = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MEMBER__TYPE = 1;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MEMBER__NAMES = 2;

  /**
   * The number of structural features of the '<em>State Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MEMBER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventForwardDclImpl <em>Event Forward Dcl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventForwardDclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEventForwardDcl()
   * @generated
   */
  int EVENT_FORWARD_DCL = 128;

  /**
   * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FORWARD_DCL__IS_ABSTRACT = EVENT__IS_ABSTRACT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FORWARD_DCL__NAME = EVENT__NAME;

  /**
   * The number of structural features of the '<em>Event Forward Dcl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FORWARD_DCL_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortTypeDeclImpl <em>Port Type Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortTypeDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPortTypeDecl()
   * @generated
   */
  int PORT_TYPE_DECL = 129;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_TYPE_DECL__COMMENTS = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_TYPE_DECL__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_TYPE_DECL__EXPORTS = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Port Type Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_TYPE_DECL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortExportImpl <em>Port Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortExportImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPortExport()
   * @generated
   */
  int PORT_EXPORT = 130;

  /**
   * The number of structural features of the '<em>Port Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_EXPORT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl <em>Port Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPortDecl()
   * @generated
   */
  int PORT_DECL = 131;

  /**
   * The feature id for the '<em><b>Is Mirror</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DECL__IS_MIRROR = COMPONENT_EXPORT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DECL__TYPE = COMPONENT_EXPORT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DECL__NAME = COMPONENT_EXPORT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DECL__COMMENTS = COMPONENT_EXPORT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Port Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DECL_FEATURE_COUNT = COMPONENT_EXPORT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorImpl <em>Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConnector()
   * @generated
   */
  int CONNECTOR = 132;

  /**
   * The feature id for the '<em><b>Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__HEADER = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__EXPORTS = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorHeaderImpl <em>Connector Header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorHeaderImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConnectorHeader()
   * @generated
   */
  int CONNECTOR_HEADER = 133;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_HEADER__NAME = 0;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_HEADER__BASE = 1;

  /**
   * The number of structural features of the '<em>Connector Header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_HEADER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorExportImpl <em>Connector Export</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorExportImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConnectorExport()
   * @generated
   */
  int CONNECTOR_EXPORT = 134;

  /**
   * The number of structural features of the '<em>Connector Export</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_EXPORT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleImpl <em>Template Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateModule()
   * @generated
   */
  int TEMPLATE_MODULE = 135;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE__PARAMETERS = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE__DEFINITIONS = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Template Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFormalParameter()
   * @generated
   */
  int FORMAL_PARAMETER = 136;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER__NAME = 1;

  /**
   * The number of structural features of the '<em>Formal Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypenameParamTypeImpl <em>Typename Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypenameParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypenameParamType()
   * @generated
   */
  int TYPENAME_PARAM_TYPE = 138;

  /**
   * The number of structural features of the '<em>Typename Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPENAME_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceParamTypeImpl <em>Interface Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterfaceParamType()
   * @generated
   */
  int INTERFACE_PARAM_TYPE = 139;

  /**
   * The number of structural features of the '<em>Interface Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValuetypeParamTypeImpl <em>Valuetype Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValuetypeParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getValuetypeParamType()
   * @generated
   */
  int VALUETYPE_PARAM_TYPE = 140;

  /**
   * The number of structural features of the '<em>Valuetype Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUETYPE_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventParamTypeImpl <em>Event Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEventParamType()
   * @generated
   */
  int EVENT_PARAM_TYPE = 141;

  /**
   * The number of structural features of the '<em>Event Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructParamTypeImpl <em>Struct Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStructParamType()
   * @generated
   */
  int STRUCT_PARAM_TYPE = 142;

  /**
   * The number of structural features of the '<em>Struct Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionParamTypeImpl <em>Union Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnionParamType()
   * @generated
   */
  int UNION_PARAM_TYPE = 143;

  /**
   * The number of structural features of the '<em>Union Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionParamTypeImpl <em>Exception Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExceptionParamType()
   * @generated
   */
  int EXCEPTION_PARAM_TYPE = 144;

  /**
   * The number of structural features of the '<em>Exception Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumParamTypeImpl <em>Enum Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEnumParamType()
   * @generated
   */
  int ENUM_PARAM_TYPE = 145;

  /**
   * The number of structural features of the '<em>Enum Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceParamTypeImpl <em>Sequence Param Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceParamTypeImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSequenceParamType()
   * @generated
   */
  int SEQUENCE_PARAM_TYPE = 146;

  /**
   * The number of structural features of the '<em>Sequence Param Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_PARAM_TYPE_FEATURE_COUNT = FORMAL_PARAMETER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateDefinitionImpl <em>Template Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateDefinitionImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateDefinition()
   * @generated
   */
  int TEMPLATE_DEFINITION = 148;

  /**
   * The number of structural features of the '<em>Template Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_DEFINITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedModuleImpl <em>Fixed Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedModuleImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedModule()
   * @generated
   */
  int FIXED_MODULE = 149;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_MODULE__NAME = TEMPLATE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_MODULE__DEFINITIONS = TEMPLATE_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fixed Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_MODULE_FEATURE_COUNT = TEMPLATE_DEFINITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedDefinitionImpl <em>Fixed Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedDefinitionImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedDefinition()
   * @generated
   */
  int FIXED_DEFINITION = 150;

  /**
   * The number of structural features of the '<em>Fixed Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_DEFINITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleInstImpl <em>Template Module Inst</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleInstImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateModuleInst()
   * @generated
   */
  int TEMPLATE_MODULE_INST = 151;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_INST__TYPE = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_INST__PARAMETER = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_INST__NAME = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_INST__COMMENTS = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Template Module Inst</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_INST_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleRefImpl <em>Template Module Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleRefImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateModuleRef()
   * @generated
   */
  int TEMPLATE_MODULE_REF = 153;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_REF__TYPE = TEMPLATE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_REF__ID = TEMPLATE_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_REF__NAME = TEMPLATE_DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Template Module Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEMPLATE_MODULE_REF_FEATURE_COUNT = TEMPLATE_DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.IDLCommentImpl <em>IDL Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IDLCommentImpl
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getIDLComment()
   * @generated
   */
  int IDL_COMMENT = 154;

  /**
   * The feature id for the '<em><b>Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDL_COMMENT__BODY = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>IDL Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDL_COMMENT_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection <em>Param Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParamDirection()
   * @generated
   */
  int PARAM_DIRECTION = 155;


  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Specification
   * @generated
   */
  EClass getSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Specification#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Specification#getImports()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Specification#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Specification#getDefinitions()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Definitions();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc <em>Preproc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc
   * @generated
   */
  EClass getPreproc();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include <em>Preproc Include</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Include</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include
   * @generated
   */
  EClass getPreproc_Include();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getValue()
   * @see #getPreproc_Include()
   * @generated
   */
  EReference getPreproc_Include_Value();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getStrValue <em>Str Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include#getStrValue()
   * @see #getPreproc_Include()
   * @generated
   */
  EAttribute getPreproc_Include_StrValue();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FileName <em>File Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FileName
   * @generated
   */
  EClass getFileName();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FileName#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FileName#getName()
   * @see #getFileName()
   * @generated
   */
  EAttribute getFileName_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef <em>Preproc Ifdef</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Ifdef</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef
   * @generated
   */
  EClass getPreproc_Ifdef();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef#getValue()
   * @see #getPreproc_Ifdef()
   * @generated
   */
  EAttribute getPreproc_Ifdef_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef <em>Preproc Ifndef</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Ifndef</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef
   * @generated
   */
  EClass getPreproc_Ifndef();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef#getValue()
   * @see #getPreproc_Ifndef()
   * @generated
   */
  EAttribute getPreproc_Ifndef_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef <em>Preproc Undef</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Undef</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef
   * @generated
   */
  EClass getPreproc_Undef();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef#getValue()
   * @see #getPreproc_Undef()
   * @generated
   */
  EAttribute getPreproc_Undef_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If <em>Preproc If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc If</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If
   * @generated
   */
  EClass getPreproc_If();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#isNegation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Negation</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#isNegation()
   * @see #getPreproc_If()
   * @generated
   */
  EAttribute getPreproc_If_Negation();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If#getValue()
   * @see #getPreproc_If()
   * @generated
   */
  EReference getPreproc_If_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare <em>Preproc If Compare</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc If Compare</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare
   * @generated
   */
  EClass getPreproc_If_Compare();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare#getLhs()
   * @see #getPreproc_If_Compare()
   * @generated
   */
  EReference getPreproc_If_Compare_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare#getOp()
   * @see #getPreproc_If_Compare()
   * @generated
   */
  EAttribute getPreproc_If_Compare_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare#getRhs()
   * @see #getPreproc_If_Compare()
   * @generated
   */
  EReference getPreproc_If_Compare_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val <em>Preproc If Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc If Val</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val
   * @generated
   */
  EClass getPreproc_If_Val();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val#getValue()
   * @see #getPreproc_If_Val()
   * @generated
   */
  EReference getPreproc_If_Val_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Else <em>Preproc Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Else</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Else
   * @generated
   */
  EClass getPreproc_Else();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error <em>Preproc Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Error</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error
   * @generated
   */
  EClass getPreproc_Error();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error#getValue()
   * @see #getPreproc_Error()
   * @generated
   */
  EAttribute getPreproc_Error_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define <em>Preproc Define</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Define</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define
   * @generated
   */
  EClass getPreproc_Define();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getValue()
   * @see #getPreproc_Define()
   * @generated
   */
  EAttribute getPreproc_Define_Value();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define#getExp()
   * @see #getPreproc_Define()
   * @generated
   */
  EReference getPreproc_Define_Exp();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif <em>Preproc Endif</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Endif</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif
   * @generated
   */
  EClass getPreproc_Endif();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma <em>Preproc Pragma</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma
   * @generated
   */
  EClass getPreproc_Pragma();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix <em>Preproc Pragma Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Prefix</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix
   * @generated
   */
  EClass getPreproc_Pragma_Prefix();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix#getValue()
   * @see #getPreproc_Pragma_Prefix()
   * @generated
   */
  EAttribute getPreproc_Pragma_Prefix_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type <em>Preproc Pragma Conn Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Conn Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type
   * @generated
   */
  EClass getPreproc_Pragma_Conn_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type#getValuePort <em>Value Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value Port</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type#getValuePort()
   * @see #getPreproc_Pragma_Conn_Type()
   * @generated
   */
  EAttribute getPreproc_Pragma_Conn_Type_ValuePort();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type#getValueConnType <em>Value Conn Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value Conn Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type#getValueConnType()
   * @see #getPreproc_Pragma_Conn_Type()
   * @generated
   */
  EAttribute getPreproc_Pragma_Conn_Type_ValueConnType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem <em>Preproc Pragma Ciao Lem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Ciao Lem</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem
   * @generated
   */
  EClass getPreproc_Pragma_Ciao_Lem();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem#getValue()
   * @see #getPreproc_Pragma_Ciao_Lem()
   * @generated
   */
  EAttribute getPreproc_Pragma_Ciao_Lem_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface <em>Preproc Pragma Ciao Ami4ccm Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Ciao Ami4ccm Interface</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface
   * @generated
   */
  EClass getPreproc_Pragma_Ciao_Ami4ccm_Interface();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface#getValue()
   * @see #getPreproc_Pragma_Ciao_Ami4ccm_Interface()
   * @generated
   */
  EAttribute getPreproc_Pragma_Ciao_Ami4ccm_Interface_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle <em>Preproc Pragma Ciao Ami4ccm Receptacle</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Ciao Ami4ccm Receptacle</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle
   * @generated
   */
  EClass getPreproc_Pragma_Ciao_Ami4ccm_Receptacle();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle#getValue()
   * @see #getPreproc_Pragma_Ciao_Ami4ccm_Receptacle()
   * @generated
   */
  EAttribute getPreproc_Pragma_Ciao_Ami4ccm_Receptacle_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl <em>Preproc Pragma Ciao Ami4ccm Idl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Ciao Ami4ccm Idl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl
   * @generated
   */
  EClass getPreproc_Pragma_Ciao_Ami4ccm_Idl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl#getValue()
   * @see #getPreproc_Pragma_Ciao_Ami4ccm_Idl()
   * @generated
   */
  EAttribute getPreproc_Pragma_Ciao_Ami4ccm_Idl_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds <em>Preproc Pragma Ndds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Ndds</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds
   * @generated
   */
  EClass getPreproc_Pragma_Ndds();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds#getValue()
   * @see #getPreproc_Pragma_Ndds()
   * @generated
   */
  EAttribute getPreproc_Pragma_Ndds_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component <em>Preproc Pragma Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Component</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component
   * @generated
   */
  EClass getPreproc_Pragma_Component();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component#getValue()
   * @see #getPreproc_Pragma_Component()
   * @generated
   */
  EAttribute getPreproc_Pragma_Component_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home <em>Preproc Pragma Home</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Home</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home
   * @generated
   */
  EClass getPreproc_Pragma_Home();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home#getValue()
   * @see #getPreproc_Pragma_Home()
   * @generated
   */
  EAttribute getPreproc_Pragma_Home_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl <em>Preproc Pragma DDS4CCM Impl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma DDS4CCM Impl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl
   * @generated
   */
  EClass getPreproc_Pragma_DDS4CCM_Impl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl#getValue()
   * @see #getPreproc_Pragma_DDS4CCM_Impl()
   * @generated
   */
  EAttribute getPreproc_Pragma_DDS4CCM_Impl_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Misc <em>Preproc Pragma Misc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Preproc Pragma Misc</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Misc
   * @generated
   */
  EClass getPreproc_Pragma_Misc();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker <em>File Marker</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File Marker</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker
   * @generated
   */
  EClass getFile_Marker();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker#getFile()
   * @see #getFile_Marker()
   * @generated
   */
  EAttribute getFile_Marker_File();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker <em>Excluded File Marker</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Excluded File Marker</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker
   * @generated
   */
  EClass getExcluded_File_Marker();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker#getFile()
   * @see #getExcluded_File_Marker()
   * @generated
   */
  EAttribute getExcluded_File_Marker_File();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl <em>Import decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl
   * @generated
   */
  EClass getImport_decl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl#getImported_scope <em>Imported scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported scope</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl#getImported_scope()
   * @see #getImport_decl()
   * @generated
   */
  EAttribute getImport_decl_Imported_scope();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Module#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Module#getComments()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Comments();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Module#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Module#getDefinitions()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Definitions();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_or_Forward_Decl <em>Interface or Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface or Forward Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_or_Forward_Decl
   * @generated
   */
  EClass getInterface_or_Forward_Decl();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl <em>Interface decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl
   * @generated
   */
  EClass getInterface_decl();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getHeader <em>Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Header</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getHeader()
   * @see #getInterface_decl()
   * @generated
   */
  EReference getInterface_decl_Header();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getInterfaceBody <em>Interface Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Interface Body</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl#getInterfaceBody()
   * @see #getInterface_decl()
   * @generated
   */
  EReference getInterface_decl_InterfaceBody();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl <em>Forward decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Forward decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl
   * @generated
   */
  EClass getForward_decl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl#getName()
   * @see #getForward_decl()
   * @generated
   */
  EAttribute getForward_decl_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header <em>Interface header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface header</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header
   * @generated
   */
  EClass getInterface_header();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsAbstract <em>Is Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Abstract</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsAbstract()
   * @see #getInterface_header()
   * @generated
   */
  EAttribute getInterface_header_IsAbstract();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsLocal <em>Is Local</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Local</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#isIsLocal()
   * @see #getInterface_header()
   * @generated
   */
  EAttribute getInterface_header_IsLocal();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getName()
   * @see #getInterface_header()
   * @generated
   */
  EAttribute getInterface_header_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getSpecializes <em>Specializes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Specializes</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getSpecializes()
   * @see #getInterface_header()
   * @generated
   */
  EReference getInterface_header_Specializes();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header#getComments()
   * @see #getInterface_header()
   * @generated
   */
  EReference getInterface_header_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody <em>Interface Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Body</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody
   * @generated
   */
  EClass getInterfaceBody();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody#getExport <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody#getExport()
   * @see #getInterfaceBody()
   * @generated
   */
  EReference getInterfaceBody_Export();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Export <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Export
   * @generated
   */
  EClass getExport();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl <em>Attr Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl
   * @generated
   */
  EClass getAttrDecl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl#getComments()
   * @see #getAttrDecl()
   * @generated
   */
  EReference getAttrDecl_Comments();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl#getType()
   * @see #getAttrDecl()
   * @generated
   */
  EReference getAttrDecl_Type();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Names</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl#getNames()
   * @see #getAttrDecl()
   * @generated
   */
  EAttribute getAttrDecl_Names();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec <em>Attr Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec
   * @generated
   */
  EClass getAttrSpec();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getGetRaises <em>Get Raises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Get Raises</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getGetRaises()
   * @see #getAttrSpec()
   * @generated
   */
  EReference getAttrSpec_GetRaises();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getSetRaises <em>Set Raises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Set Raises</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec#getSetRaises()
   * @see #getAttrSpec()
   * @generated
   */
  EReference getAttrSpec_SetRaises();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec <em>Read Only Attr Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Read Only Attr Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec
   * @generated
   */
  EClass getReadOnlyAttrSpec();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec#getRaises <em>Raises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Raises</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec#getRaises()
   * @see #getReadOnlyAttrSpec()
   * @generated
   */
  EReference getReadOnlyAttrSpec_Raises();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr <em>Attr Raises Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Raises Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr
   * @generated
   */
  EClass getAttrRaisesExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr#getExceptions <em>Exceptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exceptions</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr#getExceptions()
   * @see #getAttrRaisesExpr()
   * @generated
   */
  EReference getAttrRaisesExpr_Exceptions();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList <em>Exception List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exception List</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList
   * @generated
   */
  EClass getExceptionList();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList#getException <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exception</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList#getException()
   * @see #getExceptionList()
   * @generated
   */
  EReference getExceptionList_Exception();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl <em>Op Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl
   * @generated
   */
  EClass getOpDecl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getComments()
   * @see #getOpDecl()
   * @generated
   */
  EReference getOpDecl_Comments();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#isIsOneway <em>Is Oneway</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Oneway</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#isIsOneway()
   * @see #getOpDecl()
   * @generated
   */
  EAttribute getOpDecl_IsOneway();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getType()
   * @see #getOpDecl()
   * @generated
   */
  EReference getOpDecl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getName()
   * @see #getOpDecl()
   * @generated
   */
  EAttribute getOpDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Params</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getParams()
   * @see #getOpDecl()
   * @generated
   */
  EReference getOpDecl_Params();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getRaises <em>Raises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Raises</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getRaises()
   * @see #getOpDecl()
   * @generated
   */
  EReference getOpDecl_Raises();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Context</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl#getContext()
   * @see #getOpDecl()
   * @generated
   */
  EReference getOpDecl_Context();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpTypeDecl <em>Op Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Type Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpTypeDecl
   * @generated
   */
  EClass getOpTypeDecl();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls <em>Parameter Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Decls</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls
   * @generated
   */
  EClass getParameterDecls();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls#getComments()
   * @see #getParameterDecls()
   * @generated
   */
  EReference getParameterDecls_Comments();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls#getDecls <em>Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decls</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls#getDecls()
   * @see #getParameterDecls()
   * @generated
   */
  EReference getParameterDecls_Decls();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl <em>Param Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl
   * @generated
   */
  EClass getParamDcl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl#getDirection()
   * @see #getParamDcl()
   * @generated
   */
  EAttribute getParamDcl_Direction();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl#getType()
   * @see #getParamDcl()
   * @generated
   */
  EReference getParamDcl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl#getName()
   * @see #getParamDcl()
   * @generated
   */
  EAttribute getParamDcl_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr <em>Context Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr
   * @generated
   */
  EClass getContextExpr();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Literal</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr#getLiteral()
   * @see #getContextExpr()
   * @generated
   */
  EAttribute getContextExpr_Literal();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamTypeSpec <em>Param Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamTypeSpec
   * @generated
   */
  EClass getParamTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName <em>Scoped Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scoped Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName
   * @generated
   */
  EClass getScopedName();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName#getName()
   * @see #getScopedName()
   * @generated
   */
  EAttribute getScopedName_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.BaseTypeSpec <em>Base Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.BaseTypeSpec
   * @generated
   */
  EClass getBaseTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FloatingPtType <em>Floating Pt Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Floating Pt Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FloatingPtType
   * @generated
   */
  EClass getFloatingPtType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FloatType <em>Float Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FloatType
   * @generated
   */
  EClass getFloatType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.DoubleType <em>Double Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.DoubleType
   * @generated
   */
  EClass getDoubleType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.LongDoubleType <em>Long Double Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Long Double Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.LongDoubleType
   * @generated
   */
  EClass getLongDoubleType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IntegerType
   * @generated
   */
  EClass getIntegerType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedInt <em>Signed Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signed Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedInt
   * @generated
   */
  EClass getSignedInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedShortInt <em>Signed Short Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signed Short Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedShortInt
   * @generated
   */
  EClass getSignedShortInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongInt <em>Signed Long Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signed Long Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongInt
   * @generated
   */
  EClass getSignedLongInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongLongInt <em>Signed Long Long Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signed Long Long Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongLongInt
   * @generated
   */
  EClass getSignedLongLongInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedInt <em>Unsigned Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unsigned Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedInt
   * @generated
   */
  EClass getUnsignedInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedShortInt <em>Unsigned Short Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unsigned Short Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedShortInt
   * @generated
   */
  EClass getUnsignedShortInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongInt <em>Unsigned Long Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unsigned Long Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongInt
   * @generated
   */
  EClass getUnsignedLongInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongLongInt <em>Unsigned Long Long Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unsigned Long Long Int</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongLongInt
   * @generated
   */
  EClass getUnsignedLongLongInt();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CharType <em>Char Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Char Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CharType
   * @generated
   */
  EClass getCharType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideCharType <em>Wide Char Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wide Char Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.WideCharType
   * @generated
   */
  EClass getWideCharType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.BooleanType
   * @generated
   */
  EClass getBooleanType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OctetType <em>Octet Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Octet Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OctetType
   * @generated
   */
  EClass getOctetType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AnyType <em>Any Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AnyType
   * @generated
   */
  EClass getAnyType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ObjectType <em>Object Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ObjectType
   * @generated
   */
  EClass getObjectType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ValueBaseType <em>Value Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Base Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ValueBaseType
   * @generated
   */
  EClass getValueBaseType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StringType#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StringType#getSize()
   * @see #getStringType()
   * @generated
   */
  EReference getStringType_Size();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType <em>Wide String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wide String Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType
   * @generated
   */
  EClass getWideStringType();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType#getSize()
   * @see #getWideStringType()
   * @generated
   */
  EReference getWideStringType_Size();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl <em>Except Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Except Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl
   * @generated
   */
  EClass getExceptDecl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl#getName()
   * @see #getExceptDecl()
   * @generated
   */
  EAttribute getExceptDecl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl#getComments()
   * @see #getExceptDecl()
   * @generated
   */
  EReference getExceptDecl_Comments();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl#getMembers()
   * @see #getExceptDecl()
   * @generated
   */
  EReference getExceptDecl_Members();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Member <em>Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Member</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Member
   * @generated
   */
  EClass getMember();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Member#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Member#getType()
   * @see #getMember()
   * @generated
   */
  EReference getMember_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Member#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Member#getDecl()
   * @see #getMember()
   * @generated
   */
  EReference getMember_Decl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Member#getComment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Member#getComment()
   * @see #getMember()
   * @generated
   */
  EReference getMember_Comment();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Declarator
   * @generated
   */
  EClass getDeclarator();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Declarator#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Declarator#getId()
   * @see #getDeclarator()
   * @generated
   */
  EAttribute getDeclarator_Id();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SimpleDeclarator <em>Simple Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Declarator</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SimpleDeclarator
   * @generated
   */
  EClass getSimpleDeclarator();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComplexDeclarator <em>Complex Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Declarator</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComplexDeclarator
   * @generated
   */
  EClass getComplexDeclarator();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator <em>Array Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Declarator</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator
   * @generated
   */
  EClass getArrayDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Size</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator#getSize()
   * @see #getArrayDeclarator()
   * @generated
   */
  EReference getArrayDeclarator_Size();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructType <em>Struct Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructType
   * @generated
   */
  EClass getStructType();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getExtensibility <em>Extensibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extensibility</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getExtensibility()
   * @see #getStructType()
   * @generated
   */
  EAttribute getStructType_Extensibility();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getName()
   * @see #getStructType()
   * @generated
   */
  EAttribute getStructType_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getComments()
   * @see #getStructType()
   * @generated
   */
  EReference getStructType_Comments();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructType#getMembers()
   * @see #getStructType()
   * @generated
   */
  EReference getStructType_Members();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDecl <em>Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDecl
   * @generated
   */
  EClass getTypeDecl();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator <em>Type Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Declarator</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator
   * @generated
   */
  EClass getTypeDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getComments()
   * @see #getTypeDeclarator()
   * @generated
   */
  EReference getTypeDeclarator_Comments();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getType()
   * @see #getTypeDeclarator()
   * @generated
   */
  EReference getTypeDeclarator_Type();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getDeclarators <em>Declarators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarators</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator#getDeclarators()
   * @see #getTypeDeclarator()
   * @generated
   */
  EReference getTypeDeclarator_Declarators();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec <em>Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec
   * @generated
   */
  EClass getTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SimpleTypeSpec <em>Simple Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SimpleTypeSpec
   * @generated
   */
  EClass getSimpleTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateTypeSpec <em>Template Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateTypeSpec
   * @generated
   */
  EClass getTemplateTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstrTypeSpec <em>Constr Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constr Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstrTypeSpec
   * @generated
   */
  EClass getConstrTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType <em>Union Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType
   * @generated
   */
  EClass getUnionType();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getExtensibility <em>Extensibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extensibility</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getExtensibility()
   * @see #getUnionType()
   * @generated
   */
  EAttribute getUnionType_Extensibility();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getName()
   * @see #getUnionType()
   * @generated
   */
  EAttribute getUnionType_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getComments()
   * @see #getUnionType()
   * @generated
   */
  EReference getUnionType_Comments();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getSwitch <em>Switch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Switch</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getSwitch()
   * @see #getUnionType()
   * @generated
   */
  EReference getUnionType_Switch();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType#getBody()
   * @see #getUnionType()
   * @generated
   */
  EReference getUnionType_Body();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SwitchTypeSpec <em>Switch Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch Type Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SwitchTypeSpec
   * @generated
   */
  EClass getSwitchTypeSpec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody <em>Switch Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch Body</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody
   * @generated
   */
  EClass getSwitchBody();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody#getCase <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody#getCase()
   * @see #getSwitchBody()
   * @generated
   */
  EReference getSwitchBody_Case();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Case
   * @generated
   */
  EClass getCase();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Case#getComments()
   * @see #getCase()
   * @generated
   */
  EReference getCase_Comments();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Label</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Case#getLabel()
   * @see #getCase()
   * @generated
   */
  EReference getCase_Label();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case#getSpec <em>Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Case#getSpec()
   * @see #getCase()
   * @generated
   */
  EReference getCase_Spec();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel <em>Case Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Label</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel
   * @generated
   */
  EClass getCaseLabel();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsCase <em>Is Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Case</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsCase()
   * @see #getCaseLabel()
   * @generated
   */
  EAttribute getCaseLabel_IsCase();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#getConstExp <em>Const Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Const Exp</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#getConstExp()
   * @see #getCaseLabel()
   * @generated
   */
  EReference getCaseLabel_ConstExp();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsDefault <em>Is Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Default</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel#isIsDefault()
   * @see #getCaseLabel()
   * @generated
   */
  EAttribute getCaseLabel_IsDefault();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec <em>Element Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec
   * @generated
   */
  EClass getElementSpec();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getType()
   * @see #getElementSpec()
   * @generated
   */
  EReference getElementSpec_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getDeclarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Declarator</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec#getDeclarator()
   * @see #getElementSpec()
   * @generated
   */
  EReference getElementSpec_Declarator();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumType
   * @generated
   */
  EClass getEnumType();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumType#getName()
   * @see #getEnumType()
   * @generated
   */
  EAttribute getEnumType_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumType#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumType#getComments()
   * @see #getEnumType()
   * @generated
   */
  EReference getEnumType_Comments();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumType#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Literal</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumType#getLiteral()
   * @see #getEnumType()
   * @generated
   */
  EAttribute getEnumType_Literal();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType <em>Sequence Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType
   * @generated
   */
  EClass getSequenceType();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getType()
   * @see #getSequenceType()
   * @generated
   */
  EReference getSequenceType_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType#getSize()
   * @see #getSequenceType()
   * @generated
   */
  EReference getSequenceType_Size();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.NativeType <em>Native Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Native Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.NativeType
   * @generated
   */
  EClass getNativeType();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.NativeType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.NativeType#getName()
   * @see #getNativeType()
   * @generated
   */
  EAttribute getNativeType_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType <em>Fixed Pt Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Pt Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType
   * @generated
   */
  EClass getFixedPtType();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getLower()
   * @see #getFixedPtType()
   * @generated
   */
  EReference getFixedPtType_Lower();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType#getUpper()
   * @see #getFixedPtType()
   * @generated
   */
  EReference getFixedPtType_Upper();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl <em>Constr Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constr Forward Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl
   * @generated
   */
  EClass getConstrForwardDecl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl#getName()
   * @see #getConstrForwardDecl()
   * @generated
   */
  EAttribute getConstrForwardDecl_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructForwardDecl <em>Struct Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Forward Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructForwardDecl
   * @generated
   */
  EClass getStructForwardDecl();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionForwardDecl <em>Union Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Forward Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionForwardDecl
   * @generated
   */
  EClass getUnionForwardDecl();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst <em>Positive Int Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Positive Int Const</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst
   * @generated
   */
  EClass getPositiveIntConst();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst#getExp()
   * @see #getPositiveIntConst()
   * @generated
   */
  EReference getPositiveIntConst_Exp();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl <em>Const Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl
   * @generated
   */
  EClass getConstDecl();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getType()
   * @see #getConstDecl()
   * @generated
   */
  EReference getConstDecl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getName()
   * @see #getConstDecl()
   * @generated
   */
  EAttribute getConstDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getValue()
   * @see #getConstDecl()
   * @generated
   */
  EReference getConstDecl_Value();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl#getComments()
   * @see #getConstDecl()
   * @generated
   */
  EReference getConstDecl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstType <em>Const Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstType
   * @generated
   */
  EClass getConstType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtConstType <em>Fixed Pt Const Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Pt Const Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtConstType
   * @generated
   */
  EClass getFixedPtConstType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp <em>Const Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Exp</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp
   * @generated
   */
  EClass getConstExp();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr
   * @generated
   */
  EClass getOrExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr#getLhs()
   * @see #getOrExpr()
   * @generated
   */
  EReference getOrExpr_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr#getOp()
   * @see #getOrExpr()
   * @generated
   */
  EAttribute getOrExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr#getRhs()
   * @see #getOrExpr()
   * @generated
   */
  EReference getOrExpr_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr <em>XOr Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XOr Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr
   * @generated
   */
  EClass getXOrExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr#getLhs()
   * @see #getXOrExpr()
   * @generated
   */
  EReference getXOrExpr_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr#getOp()
   * @see #getXOrExpr()
   * @generated
   */
  EAttribute getXOrExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr#getRhs()
   * @see #getXOrExpr()
   * @generated
   */
  EReference getXOrExpr_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr
   * @generated
   */
  EClass getAndExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr#getLhs()
   * @see #getAndExpr()
   * @generated
   */
  EReference getAndExpr_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr#getOp()
   * @see #getAndExpr()
   * @generated
   */
  EAttribute getAndExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr#getRhs()
   * @see #getAndExpr()
   * @generated
   */
  EReference getAndExpr_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr <em>Shift Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr
   * @generated
   */
  EClass getShiftExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getLhs()
   * @see #getShiftExpr()
   * @generated
   */
  EReference getShiftExpr_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getOp()
   * @see #getShiftExpr()
   * @generated
   */
  EAttribute getShiftExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr#getRhs()
   * @see #getShiftExpr()
   * @generated
   */
  EReference getShiftExpr_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr <em>Add Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr
   * @generated
   */
  EClass getAddExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr#getLhs()
   * @see #getAddExpr()
   * @generated
   */
  EReference getAddExpr_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr#getOp()
   * @see #getAddExpr()
   * @generated
   */
  EAttribute getAddExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr#getRhs()
   * @see #getAddExpr()
   * @generated
   */
  EReference getAddExpr_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr <em>Mult Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mult Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr
   * @generated
   */
  EClass getMultExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getLhs()
   * @see #getMultExpr()
   * @generated
   */
  EReference getMultExpr_Lhs();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getOp()
   * @see #getMultExpr()
   * @generated
   */
  EAttribute getMultExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr#getRhs()
   * @see #getMultExpr()
   * @generated
   */
  EReference getMultExpr_Rhs();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr
   * @generated
   */
  EClass getUnaryExpr();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr#getOp()
   * @see #getUnaryExpr()
   * @generated
   */
  EAttribute getUnaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr#getExpr()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr <em>Primary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expr</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr
   * @generated
   */
  EClass getPrimaryExpr();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Literal#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Literal#getValue()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Value();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl <em>Component Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl
   * @generated
   */
  EClass getComponentDecl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getComments()
   * @see #getComponentDecl()
   * @generated
   */
  EReference getComponentDecl_Comments();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getName()
   * @see #getComponentDecl()
   * @generated
   */
  EAttribute getComponentDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getBase()
   * @see #getComponentDecl()
   * @generated
   */
  EReference getComponentDecl_Base();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getSupports <em>Supports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supports</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getSupports()
   * @see #getComponentDecl()
   * @generated
   */
  EReference getComponentDecl_Supports();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getExport <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl#getExport()
   * @see #getComponentDecl()
   * @generated
   */
  EReference getComponentDecl_Export();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport <em>Component Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport
   * @generated
   */
  EClass getComponentExport();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl <em>Provides Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Provides Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl
   * @generated
   */
  EClass getProvidesDcl();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl#getType()
   * @see #getProvidesDcl()
   * @generated
   */
  EReference getProvidesDcl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl#getName()
   * @see #getProvidesDcl()
   * @generated
   */
  EAttribute getProvidesDcl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl#getComments()
   * @see #getProvidesDcl()
   * @generated
   */
  EReference getProvidesDcl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl <em>Uses Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uses Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl
   * @generated
   */
  EClass getUsesDcl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#isIsMultiple <em>Is Multiple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Multiple</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#isIsMultiple()
   * @see #getUsesDcl()
   * @generated
   */
  EAttribute getUsesDcl_IsMultiple();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#getType()
   * @see #getUsesDcl()
   * @generated
   */
  EReference getUsesDcl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#getName()
   * @see #getUsesDcl()
   * @generated
   */
  EAttribute getUsesDcl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl#getComments()
   * @see #getUsesDcl()
   * @generated
   */
  EReference getUsesDcl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl <em>Publishes Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Publishes Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl
   * @generated
   */
  EClass getPublishesDcl();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl#getType()
   * @see #getPublishesDcl()
   * @generated
   */
  EReference getPublishesDcl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl#getName()
   * @see #getPublishesDcl()
   * @generated
   */
  EAttribute getPublishesDcl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl#getComments()
   * @see #getPublishesDcl()
   * @generated
   */
  EReference getPublishesDcl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl <em>Emit Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Emit Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl
   * @generated
   */
  EClass getEmitDcl();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl#getType()
   * @see #getEmitDcl()
   * @generated
   */
  EReference getEmitDcl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl#getName()
   * @see #getEmitDcl()
   * @generated
   */
  EAttribute getEmitDcl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl#getComments()
   * @see #getEmitDcl()
   * @generated
   */
  EReference getEmitDcl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl <em>Consumes Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Consumes Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl
   * @generated
   */
  EClass getConsumesDcl();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl#getType()
   * @see #getConsumesDcl()
   * @generated
   */
  EReference getConsumesDcl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl#getName()
   * @see #getConsumesDcl()
   * @generated
   */
  EAttribute getConsumesDcl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl#getComments()
   * @see #getConsumesDcl()
   * @generated
   */
  EReference getConsumesDcl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl <em>Component Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Forward Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl
   * @generated
   */
  EClass getComponentForwardDecl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl#getName()
   * @see #getComponentForwardDecl()
   * @generated
   */
  EAttribute getComponentForwardDecl_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl <em>Home Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Home Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl
   * @generated
   */
  EClass getHomeDecl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getComments()
   * @see #getHomeDecl()
   * @generated
   */
  EReference getHomeDecl_Comments();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getName()
   * @see #getHomeDecl()
   * @generated
   */
  EAttribute getHomeDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getBase()
   * @see #getHomeDecl()
   * @generated
   */
  EReference getHomeDecl_Base();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getSupports <em>Supports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supports</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getSupports()
   * @see #getHomeDecl()
   * @generated
   */
  EReference getHomeDecl_Supports();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getManages <em>Manages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Manages</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getManages()
   * @see #getHomeDecl()
   * @generated
   */
  EReference getHomeDecl_Manages();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getPrimary_key <em>Primary key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary key</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getPrimary_key()
   * @see #getHomeDecl()
   * @generated
   */
  EReference getHomeDecl_Primary_key();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getExport <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl#getExport()
   * @see #getHomeDecl()
   * @generated
   */
  EReference getHomeDecl_Export();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec <em>Primary Key Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Key Spec</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec
   * @generated
   */
  EClass getPrimaryKeySpec();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Key</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec#getKey()
   * @see #getPrimaryKeySpec()
   * @generated
   */
  EReference getPrimaryKeySpec_Key();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport <em>Home Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Home Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport
   * @generated
   */
  EClass getHomeExport();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl <em>Factory Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl
   * @generated
   */
  EClass getFactoryDcl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getComments()
   * @see #getFactoryDcl()
   * @generated
   */
  EReference getFactoryDcl_Comments();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getName()
   * @see #getFactoryDcl()
   * @generated
   */
  EAttribute getFactoryDcl_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Params</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getParams()
   * @see #getFactoryDcl()
   * @generated
   */
  EReference getFactoryDcl_Params();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getRaises <em>Raises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Raises</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl#getRaises()
   * @see #getFactoryDcl()
   * @generated
   */
  EReference getFactoryDcl_Raises();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl <em>Finder Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Finder Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl
   * @generated
   */
  EClass getFinderDcl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getComments()
   * @see #getFinderDcl()
   * @generated
   */
  EReference getFinderDcl_Comments();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getName()
   * @see #getFinderDcl()
   * @generated
   */
  EAttribute getFinderDcl_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Params</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getParams()
   * @see #getFinderDcl()
   * @generated
   */
  EReference getFinderDcl_Params();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getRaises <em>Raises</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Raises</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl#getRaises()
   * @see #getFinderDcl()
   * @generated
   */
  EReference getFinderDcl_Raises();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Event#isIsAbstract <em>Is Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Abstract</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Event#isIsAbstract()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_IsAbstract();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Event#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Event#getName()
   * @see #getEvent()
   * @generated
   */
  EAttribute getEvent_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl <em>Event Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl
   * @generated
   */
  EClass getEventDcl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsCustom <em>Is Custom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Custom</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsCustom()
   * @see #getEventDcl()
   * @generated
   */
  EAttribute getEventDcl_IsCustom();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsTruncatable <em>Is Truncatable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Truncatable</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#isIsTruncatable()
   * @see #getEventDcl()
   * @generated
   */
  EAttribute getEventDcl_IsTruncatable();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Base</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getBase()
   * @see #getEventDcl()
   * @generated
   */
  EReference getEventDcl_Base();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getSupports <em>Supports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supports</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getSupports()
   * @see #getEventDcl()
   * @generated
   */
  EReference getEventDcl_Supports();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getExport <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getExport()
   * @see #getEventDcl()
   * @generated
   */
  EReference getEventDcl_Export();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getMember <em>Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Member</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl#getMember()
   * @see #getEventDcl()
   * @generated
   */
  EReference getEventDcl_Member();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember <em>State Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Member</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StateMember
   * @generated
   */
  EClass getStateMember();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#isIsPublic <em>Is Public</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Public</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#isIsPublic()
   * @see #getStateMember()
   * @generated
   */
  EAttribute getStateMember_IsPublic();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getType()
   * @see #getStateMember()
   * @generated
   */
  EReference getStateMember_Type();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Names</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StateMember#getNames()
   * @see #getStateMember()
   * @generated
   */
  EAttribute getStateMember_Names();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventForwardDcl <em>Event Forward Dcl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Forward Dcl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventForwardDcl
   * @generated
   */
  EClass getEventForwardDcl();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl <em>Port Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Type Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl
   * @generated
   */
  EClass getPortTypeDecl();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl#getComments()
   * @see #getPortTypeDecl()
   * @generated
   */
  EReference getPortTypeDecl_Comments();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl#getName()
   * @see #getPortTypeDecl()
   * @generated
   */
  EAttribute getPortTypeDecl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl#getExports <em>Exports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exports</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl#getExports()
   * @see #getPortTypeDecl()
   * @generated
   */
  EReference getPortTypeDecl_Exports();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortExport <em>Port Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortExport
   * @generated
   */
  EClass getPortExport();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl <em>Port Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Decl</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl
   * @generated
   */
  EClass getPortDecl();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#isIsMirror <em>Is Mirror</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Mirror</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#isIsMirror()
   * @see #getPortDecl()
   * @generated
   */
  EAttribute getPortDecl_IsMirror();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getType()
   * @see #getPortDecl()
   * @generated
   */
  EReference getPortDecl_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getName()
   * @see #getPortDecl()
   * @generated
   */
  EAttribute getPortDecl_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl#getComments()
   * @see #getPortDecl()
   * @generated
   */
  EReference getPortDecl_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Connector <em>Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connector</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Connector
   * @generated
   */
  EClass getConnector();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Connector#getHeader <em>Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Header</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Connector#getHeader()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_Header();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Connector#getExports <em>Exports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exports</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Connector#getExports()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_Exports();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader <em>Connector Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connector Header</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader
   * @generated
   */
  EClass getConnectorHeader();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader#getName()
   * @see #getConnectorHeader()
   * @generated
   */
  EAttribute getConnectorHeader_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader#getBase()
   * @see #getConnectorHeader()
   * @generated
   */
  EReference getConnectorHeader_Base();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorExport <em>Connector Export</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connector Export</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorExport
   * @generated
   */
  EClass getConnectorExport();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule <em>Template Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Module</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule
   * @generated
   */
  EClass getTemplateModule();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule#getName()
   * @see #getTemplateModule()
   * @generated
   */
  EAttribute getTemplateModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule#getParameters()
   * @see #getTemplateModule()
   * @generated
   */
  EReference getTemplateModule_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule#getDefinitions()
   * @see #getTemplateModule()
   * @generated
   */
  EReference getTemplateModule_Definitions();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameter</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter
   * @generated
   */
  EClass getFormalParameter();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter#getType()
   * @see #getFormalParameter()
   * @generated
   */
  EReference getFormalParameter_Type();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter#getName()
   * @see #getFormalParameter()
   * @generated
   */
  EAttribute getFormalParameter_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType <em>Formal Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Parameter Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType
   * @generated
   */
  EClass getFormalParameterType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType <em>Typename Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typename Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType
   * @generated
   */
  EClass getTypenameParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType <em>Interface Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType
   * @generated
   */
  EClass getInterfaceParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType <em>Valuetype Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Valuetype Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType
   * @generated
   */
  EClass getValuetypeParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType <em>Event Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType
   * @generated
   */
  EClass getEventParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType <em>Struct Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType
   * @generated
   */
  EClass getStructParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType <em>Union Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType
   * @generated
   */
  EClass getUnionParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType <em>Exception Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exception Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType
   * @generated
   */
  EClass getExceptionParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType <em>Enum Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType
   * @generated
   */
  EClass getEnumParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType <em>Sequence Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType
   * @generated
   */
  EClass getSequenceParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType <em>Const Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Param Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType
   * @generated
   */
  EClass getConstParamType();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition <em>Template Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Definition</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition
   * @generated
   */
  EClass getTemplateDefinition();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule <em>Fixed Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Module</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule
   * @generated
   */
  EClass getFixedModule();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getName()
   * @see #getFixedModule()
   * @generated
   */
  EAttribute getFixedModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule#getDefinitions()
   * @see #getFixedModule()
   * @generated
   */
  EReference getFixedModule_Definitions();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition <em>Fixed Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Definition</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition
   * @generated
   */
  EClass getFixedDefinition();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst <em>Template Module Inst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Module Inst</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst
   * @generated
   */
  EClass getTemplateModuleInst();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getType()
   * @see #getTemplateModuleInst()
   * @generated
   */
  EReference getTemplateModuleInst_Type();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getParameter()
   * @see #getTemplateModuleInst()
   * @generated
   */
  EReference getTemplateModuleInst_Parameter();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getName()
   * @see #getTemplateModuleInst()
   * @generated
   */
  EAttribute getTemplateModuleInst_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comments</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst#getComments()
   * @see #getTemplateModuleInst()
   * @generated
   */
  EReference getTemplateModuleInst_Comments();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter <em>Actual Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actual Parameter</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter
   * @generated
   */
  EClass getActualParameter();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef <em>Template Module Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Template Module Ref</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef
   * @generated
   */
  EClass getTemplateModuleRef();

  /**
   * Returns the meta object for the containment reference '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef#getType()
   * @see #getTemplateModuleRef()
   * @generated
   */
  EReference getTemplateModuleRef_Type();

  /**
   * Returns the meta object for the attribute list '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef#getId()
   * @see #getTemplateModuleRef()
   * @generated
   */
  EAttribute getTemplateModuleRef_Id();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef#getName()
   * @see #getTemplateModuleRef()
   * @generated
   */
  EAttribute getTemplateModuleRef_Name();

  /**
   * Returns the meta object for class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment <em>IDL Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IDL Comment</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment
   * @generated
   */
  EClass getIDLComment();

  /**
   * Returns the meta object for the attribute '{@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Body</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment#getBody()
   * @see #getIDLComment()
   * @generated
   */
  EAttribute getIDLComment_Body();

  /**
   * Returns the meta object for enum '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection <em>Param Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Param Direction</em>'.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection
   * @generated
   */
  EEnum getParamDirection();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IdlFactory getIdlFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SpecificationImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSpecification()
     * @generated
     */
    EClass SPECIFICATION = eINSTANCE.getSpecification();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__IMPORTS = eINSTANCE.getSpecification_Imports();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__DEFINITIONS = eINSTANCE.getSpecification_Definitions();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PreprocImpl <em>Preproc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PreprocImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc()
     * @generated
     */
    EClass PREPROC = eINSTANCE.getPreproc();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IncludeImpl <em>Preproc Include</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IncludeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Include()
     * @generated
     */
    EClass PREPROC_INCLUDE = eINSTANCE.getPreproc_Include();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROC_INCLUDE__VALUE = eINSTANCE.getPreproc_Include_Value();

    /**
     * The meta object literal for the '<em><b>Str Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_INCLUDE__STR_VALUE = eINSTANCE.getPreproc_Include_StrValue();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FileNameImpl <em>File Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FileNameImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFileName()
     * @generated
     */
    EClass FILE_NAME = eINSTANCE.getFileName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE_NAME__NAME = eINSTANCE.getFileName_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfdefImpl <em>Preproc Ifdef</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfdefImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Ifdef()
     * @generated
     */
    EClass PREPROC_IFDEF = eINSTANCE.getPreproc_Ifdef();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_IFDEF__VALUE = eINSTANCE.getPreproc_Ifdef_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfndefImpl <em>Preproc Ifndef</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfndefImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Ifndef()
     * @generated
     */
    EClass PREPROC_IFNDEF = eINSTANCE.getPreproc_Ifndef();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_IFNDEF__VALUE = eINSTANCE.getPreproc_Ifndef_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_UndefImpl <em>Preproc Undef</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_UndefImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Undef()
     * @generated
     */
    EClass PREPROC_UNDEF = eINSTANCE.getPreproc_Undef();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_UNDEF__VALUE = eINSTANCE.getPreproc_Undef_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfImpl <em>Preproc If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_IfImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_If()
     * @generated
     */
    EClass PREPROC_IF = eINSTANCE.getPreproc_If();

    /**
     * The meta object literal for the '<em><b>Negation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_IF__NEGATION = eINSTANCE.getPreproc_If_Negation();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROC_IF__VALUE = eINSTANCE.getPreproc_If_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_CompareImpl <em>Preproc If Compare</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_CompareImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_If_Compare()
     * @generated
     */
    EClass PREPROC_IF_COMPARE = eINSTANCE.getPreproc_If_Compare();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROC_IF_COMPARE__LHS = eINSTANCE.getPreproc_If_Compare_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_IF_COMPARE__OP = eINSTANCE.getPreproc_If_Compare_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROC_IF_COMPARE__RHS = eINSTANCE.getPreproc_If_Compare_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_ValImpl <em>Preproc If Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_If_ValImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_If_Val()
     * @generated
     */
    EClass PREPROC_IF_VAL = eINSTANCE.getPreproc_If_Val();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROC_IF_VAL__VALUE = eINSTANCE.getPreproc_If_Val_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ElseImpl <em>Preproc Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ElseImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Else()
     * @generated
     */
    EClass PREPROC_ELSE = eINSTANCE.getPreproc_Else();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ErrorImpl <em>Preproc Error</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_ErrorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Error()
     * @generated
     */
    EClass PREPROC_ERROR = eINSTANCE.getPreproc_Error();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_ERROR__VALUE = eINSTANCE.getPreproc_Error_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_DefineImpl <em>Preproc Define</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_DefineImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Define()
     * @generated
     */
    EClass PREPROC_DEFINE = eINSTANCE.getPreproc_Define();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_DEFINE__VALUE = eINSTANCE.getPreproc_Define_Value();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREPROC_DEFINE__EXP = eINSTANCE.getPreproc_Define_Exp();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_EndifImpl <em>Preproc Endif</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_EndifImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Endif()
     * @generated
     */
    EClass PREPROC_ENDIF = eINSTANCE.getPreproc_Endif();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_PragmaImpl <em>Preproc Pragma</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_PragmaImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma()
     * @generated
     */
    EClass PREPROC_PRAGMA = eINSTANCE.getPreproc_Pragma();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_PrefixImpl <em>Preproc Pragma Prefix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_PrefixImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Prefix()
     * @generated
     */
    EClass PREPROC_PRAGMA_PREFIX = eINSTANCE.getPreproc_Pragma_Prefix();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_PREFIX__VALUE = eINSTANCE.getPreproc_Pragma_Prefix_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Conn_TypeImpl <em>Preproc Pragma Conn Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Conn_TypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Conn_Type()
     * @generated
     */
    EClass PREPROC_PRAGMA_CONN_TYPE = eINSTANCE.getPreproc_Pragma_Conn_Type();

    /**
     * The meta object literal for the '<em><b>Value Port</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_CONN_TYPE__VALUE_PORT = eINSTANCE.getPreproc_Pragma_Conn_Type_ValuePort();

    /**
     * The meta object literal for the '<em><b>Value Conn Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_CONN_TYPE__VALUE_CONN_TYPE = eINSTANCE.getPreproc_Pragma_Conn_Type_ValueConnType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_LemImpl <em>Preproc Pragma Ciao Lem</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_LemImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Lem()
     * @generated
     */
    EClass PREPROC_PRAGMA_CIAO_LEM = eINSTANCE.getPreproc_Pragma_Ciao_Lem();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_CIAO_LEM__VALUE = eINSTANCE.getPreproc_Pragma_Ciao_Lem_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_InterfaceImpl <em>Preproc Pragma Ciao Ami4ccm Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_InterfaceImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Ami4ccm_Interface()
     * @generated
     */
    EClass PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE = eINSTANCE.getPreproc_Pragma_Ciao_Ami4ccm_Interface();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE__VALUE = eINSTANCE.getPreproc_Pragma_Ciao_Ami4ccm_Interface_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_ReceptacleImpl <em>Preproc Pragma Ciao Ami4ccm Receptacle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_ReceptacleImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Ami4ccm_Receptacle()
     * @generated
     */
    EClass PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE = eINSTANCE.getPreproc_Pragma_Ciao_Ami4ccm_Receptacle();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE__VALUE = eINSTANCE.getPreproc_Pragma_Ciao_Ami4ccm_Receptacle_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_IdlImpl <em>Preproc Pragma Ciao Ami4ccm Idl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_Ciao_Ami4ccm_IdlImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ciao_Ami4ccm_Idl()
     * @generated
     */
    EClass PREPROC_PRAGMA_CIAO_AMI4CCM_IDL = eINSTANCE.getPreproc_Pragma_Ciao_Ami4ccm_Idl();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_CIAO_AMI4CCM_IDL__VALUE = eINSTANCE.getPreproc_Pragma_Ciao_Ami4ccm_Idl_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_NddsImpl <em>Preproc Pragma Ndds</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_NddsImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Ndds()
     * @generated
     */
    EClass PREPROC_PRAGMA_NDDS = eINSTANCE.getPreproc_Pragma_Ndds();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_NDDS__VALUE = eINSTANCE.getPreproc_Pragma_Ndds_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_ComponentImpl <em>Preproc Pragma Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_ComponentImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Component()
     * @generated
     */
    EClass PREPROC_PRAGMA_COMPONENT = eINSTANCE.getPreproc_Pragma_Component();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_COMPONENT__VALUE = eINSTANCE.getPreproc_Pragma_Component_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_HomeImpl <em>Preproc Pragma Home</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_HomeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Home()
     * @generated
     */
    EClass PREPROC_PRAGMA_HOME = eINSTANCE.getPreproc_Pragma_Home();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_HOME__VALUE = eINSTANCE.getPreproc_Pragma_Home_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_DDS4CCM_ImplImpl <em>Preproc Pragma DDS4CCM Impl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_DDS4CCM_ImplImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_DDS4CCM_Impl()
     * @generated
     */
    EClass PREPROC_PRAGMA_DDS4CCM_IMPL = eINSTANCE.getPreproc_Pragma_DDS4CCM_Impl();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREPROC_PRAGMA_DDS4CCM_IMPL__VALUE = eINSTANCE.getPreproc_Pragma_DDS4CCM_Impl_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_MiscImpl <em>Preproc Pragma Misc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Preproc_Pragma_MiscImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPreproc_Pragma_Misc()
     * @generated
     */
    EClass PREPROC_PRAGMA_MISC = eINSTANCE.getPreproc_Pragma_Misc();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.File_MarkerImpl <em>File Marker</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.File_MarkerImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFile_Marker()
     * @generated
     */
    EClass FILE_MARKER = eINSTANCE.getFile_Marker();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE_MARKER__FILE = eINSTANCE.getFile_Marker_File();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Excluded_File_MarkerImpl <em>Excluded File Marker</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Excluded_File_MarkerImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExcluded_File_Marker()
     * @generated
     */
    EClass EXCLUDED_FILE_MARKER = eINSTANCE.getExcluded_File_Marker();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCLUDED_FILE_MARKER__FILE = eINSTANCE.getExcluded_File_Marker_File();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Import_declImpl <em>Import decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Import_declImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getImport_decl()
     * @generated
     */
    EClass IMPORT_DECL = eINSTANCE.getImport_decl();

    /**
     * The meta object literal for the '<em><b>Imported scope</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_DECL__IMPORTED_SCOPE = eINSTANCE.getImport_decl_Imported_scope();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.DefinitionImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ModuleImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__COMMENTS = eINSTANCE.getModule_Comments();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__DEFINITIONS = eINSTANCE.getModule_Definitions();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_or_Forward_DeclImpl <em>Interface or Forward Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_or_Forward_DeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterface_or_Forward_Decl()
     * @generated
     */
    EClass INTERFACE_OR_FORWARD_DECL = eINSTANCE.getInterface_or_Forward_Decl();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_declImpl <em>Interface decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_declImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterface_decl()
     * @generated
     */
    EClass INTERFACE_DECL = eINSTANCE.getInterface_decl();

    /**
     * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_DECL__HEADER = eINSTANCE.getInterface_decl_Header();

    /**
     * The meta object literal for the '<em><b>Interface Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_DECL__INTERFACE_BODY = eINSTANCE.getInterface_decl_InterfaceBody();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Forward_declImpl <em>Forward decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Forward_declImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getForward_decl()
     * @generated
     */
    EClass FORWARD_DECL = eINSTANCE.getForward_decl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORWARD_DECL__NAME = eINSTANCE.getForward_decl_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_headerImpl <em>Interface header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.Interface_headerImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterface_header()
     * @generated
     */
    EClass INTERFACE_HEADER = eINSTANCE.getInterface_header();

    /**
     * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_HEADER__IS_ABSTRACT = eINSTANCE.getInterface_header_IsAbstract();

    /**
     * The meta object literal for the '<em><b>Is Local</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_HEADER__IS_LOCAL = eINSTANCE.getInterface_header_IsLocal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_HEADER__NAME = eINSTANCE.getInterface_header_Name();

    /**
     * The meta object literal for the '<em><b>Specializes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_HEADER__SPECIALIZES = eINSTANCE.getInterface_header_Specializes();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_HEADER__COMMENTS = eINSTANCE.getInterface_header_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceBodyImpl <em>Interface Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceBodyImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterfaceBody()
     * @generated
     */
    EClass INTERFACE_BODY = eINSTANCE.getInterfaceBody();

    /**
     * The meta object literal for the '<em><b>Export</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_BODY__EXPORT = eINSTANCE.getInterfaceBody_Export();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExportImpl <em>Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExportImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExport()
     * @generated
     */
    EClass EXPORT = eINSTANCE.getExport();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrDeclImpl <em>Attr Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAttrDecl()
     * @generated
     */
    EClass ATTR_DECL = eINSTANCE.getAttrDecl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_DECL__COMMENTS = eINSTANCE.getAttrDecl_Comments();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_DECL__TYPE = eINSTANCE.getAttrDecl_Type();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR_DECL__NAMES = eINSTANCE.getAttrDecl_Names();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrSpecImpl <em>Attr Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAttrSpec()
     * @generated
     */
    EClass ATTR_SPEC = eINSTANCE.getAttrSpec();

    /**
     * The meta object literal for the '<em><b>Get Raises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_SPEC__GET_RAISES = eINSTANCE.getAttrSpec_GetRaises();

    /**
     * The meta object literal for the '<em><b>Set Raises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_SPEC__SET_RAISES = eINSTANCE.getAttrSpec_SetRaises();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ReadOnlyAttrSpecImpl <em>Read Only Attr Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ReadOnlyAttrSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getReadOnlyAttrSpec()
     * @generated
     */
    EClass READ_ONLY_ATTR_SPEC = eINSTANCE.getReadOnlyAttrSpec();

    /**
     * The meta object literal for the '<em><b>Raises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference READ_ONLY_ATTR_SPEC__RAISES = eINSTANCE.getReadOnlyAttrSpec_Raises();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrRaisesExprImpl <em>Attr Raises Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AttrRaisesExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAttrRaisesExpr()
     * @generated
     */
    EClass ATTR_RAISES_EXPR = eINSTANCE.getAttrRaisesExpr();

    /**
     * The meta object literal for the '<em><b>Exceptions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_RAISES_EXPR__EXCEPTIONS = eINSTANCE.getAttrRaisesExpr_Exceptions();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionListImpl <em>Exception List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionListImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExceptionList()
     * @generated
     */
    EClass EXCEPTION_LIST = eINSTANCE.getExceptionList();

    /**
     * The meta object literal for the '<em><b>Exception</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEPTION_LIST__EXCEPTION = eINSTANCE.getExceptionList_Exception();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpDeclImpl <em>Op Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOpDecl()
     * @generated
     */
    EClass OP_DECL = eINSTANCE.getOpDecl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DECL__COMMENTS = eINSTANCE.getOpDecl_Comments();

    /**
     * The meta object literal for the '<em><b>Is Oneway</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OP_DECL__IS_ONEWAY = eINSTANCE.getOpDecl_IsOneway();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DECL__TYPE = eINSTANCE.getOpDecl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OP_DECL__NAME = eINSTANCE.getOpDecl_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DECL__PARAMS = eINSTANCE.getOpDecl_Params();

    /**
     * The meta object literal for the '<em><b>Raises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DECL__RAISES = eINSTANCE.getOpDecl_Raises();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OP_DECL__CONTEXT = eINSTANCE.getOpDecl_Context();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpTypeDeclImpl <em>Op Type Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OpTypeDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOpTypeDecl()
     * @generated
     */
    EClass OP_TYPE_DECL = eINSTANCE.getOpTypeDecl();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParameterDeclsImpl <em>Parameter Decls</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParameterDeclsImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParameterDecls()
     * @generated
     */
    EClass PARAMETER_DECLS = eINSTANCE.getParameterDecls();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_DECLS__COMMENTS = eINSTANCE.getParameterDecls_Comments();

    /**
     * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_DECLS__DECLS = eINSTANCE.getParameterDecls_Decls();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamDclImpl <em>Param Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParamDcl()
     * @generated
     */
    EClass PARAM_DCL = eINSTANCE.getParamDcl();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM_DCL__DIRECTION = eINSTANCE.getParamDcl_Direction();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_DCL__TYPE = eINSTANCE.getParamDcl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAM_DCL__NAME = eINSTANCE.getParamDcl_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ContextExprImpl <em>Context Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ContextExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getContextExpr()
     * @generated
     */
    EClass CONTEXT_EXPR = eINSTANCE.getContextExpr();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT_EXPR__LITERAL = eINSTANCE.getContextExpr_Literal();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamTypeSpecImpl <em>Param Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ParamTypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParamTypeSpec()
     * @generated
     */
    EClass PARAM_TYPE_SPEC = eINSTANCE.getParamTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ScopedNameImpl <em>Scoped Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ScopedNameImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getScopedName()
     * @generated
     */
    EClass SCOPED_NAME = eINSTANCE.getScopedName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCOPED_NAME__NAME = eINSTANCE.getScopedName_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.BaseTypeSpecImpl <em>Base Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.BaseTypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getBaseTypeSpec()
     * @generated
     */
    EClass BASE_TYPE_SPEC = eINSTANCE.getBaseTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatingPtTypeImpl <em>Floating Pt Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatingPtTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFloatingPtType()
     * @generated
     */
    EClass FLOATING_PT_TYPE = eINSTANCE.getFloatingPtType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatTypeImpl <em>Float Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFloatType()
     * @generated
     */
    EClass FLOAT_TYPE = eINSTANCE.getFloatType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.DoubleTypeImpl <em>Double Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.DoubleTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getDoubleType()
     * @generated
     */
    EClass DOUBLE_TYPE = eINSTANCE.getDoubleType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.LongDoubleTypeImpl <em>Long Double Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.LongDoubleTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getLongDoubleType()
     * @generated
     */
    EClass LONG_DOUBLE_TYPE = eINSTANCE.getLongDoubleType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IntegerTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getIntegerType()
     * @generated
     */
    EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedIntImpl <em>Signed Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedInt()
     * @generated
     */
    EClass SIGNED_INT = eINSTANCE.getSignedInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedShortIntImpl <em>Signed Short Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedShortIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedShortInt()
     * @generated
     */
    EClass SIGNED_SHORT_INT = eINSTANCE.getSignedShortInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongIntImpl <em>Signed Long Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedLongInt()
     * @generated
     */
    EClass SIGNED_LONG_INT = eINSTANCE.getSignedLongInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongLongIntImpl <em>Signed Long Long Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongLongIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSignedLongLongInt()
     * @generated
     */
    EClass SIGNED_LONG_LONG_INT = eINSTANCE.getSignedLongLongInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedIntImpl <em>Unsigned Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedInt()
     * @generated
     */
    EClass UNSIGNED_INT = eINSTANCE.getUnsignedInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedShortIntImpl <em>Unsigned Short Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedShortIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedShortInt()
     * @generated
     */
    EClass UNSIGNED_SHORT_INT = eINSTANCE.getUnsignedShortInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongIntImpl <em>Unsigned Long Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedLongInt()
     * @generated
     */
    EClass UNSIGNED_LONG_INT = eINSTANCE.getUnsignedLongInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongLongIntImpl <em>Unsigned Long Long Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongLongIntImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnsignedLongLongInt()
     * @generated
     */
    EClass UNSIGNED_LONG_LONG_INT = eINSTANCE.getUnsignedLongLongInt();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CharTypeImpl <em>Char Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.CharTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getCharType()
     * @generated
     */
    EClass CHAR_TYPE = eINSTANCE.getCharType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideCharTypeImpl <em>Wide Char Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideCharTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getWideCharType()
     * @generated
     */
    EClass WIDE_CHAR_TYPE = eINSTANCE.getWideCharType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.BooleanTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getBooleanType()
     * @generated
     */
    EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OctetTypeImpl <em>Octet Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OctetTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOctetType()
     * @generated
     */
    EClass OCTET_TYPE = eINSTANCE.getOctetType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AnyTypeImpl <em>Any Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AnyTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAnyType()
     * @generated
     */
    EClass ANY_TYPE = eINSTANCE.getAnyType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ObjectTypeImpl <em>Object Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ObjectTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getObjectType()
     * @generated
     */
    EClass OBJECT_TYPE = eINSTANCE.getObjectType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValueBaseTypeImpl <em>Value Base Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValueBaseTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getValueBaseType()
     * @generated
     */
    EClass VALUE_BASE_TYPE = eINSTANCE.getValueBaseType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StringTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_TYPE__SIZE = eINSTANCE.getStringType_Size();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideStringTypeImpl <em>Wide String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideStringTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getWideStringType()
     * @generated
     */
    EClass WIDE_STRING_TYPE = eINSTANCE.getWideStringType();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WIDE_STRING_TYPE__SIZE = eINSTANCE.getWideStringType_Size();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptDeclImpl <em>Except Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExceptDecl()
     * @generated
     */
    EClass EXCEPT_DECL = eINSTANCE.getExceptDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCEPT_DECL__NAME = eINSTANCE.getExceptDecl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEPT_DECL__COMMENTS = eINSTANCE.getExceptDecl_Comments();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEPT_DECL__MEMBERS = eINSTANCE.getExceptDecl_Members();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.MemberImpl <em>Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.MemberImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getMember()
     * @generated
     */
    EClass MEMBER = eINSTANCE.getMember();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMBER__TYPE = eINSTANCE.getMember_Type();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMBER__DECL = eINSTANCE.getMember_Decl();

    /**
     * The meta object literal for the '<em><b>Comment</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMBER__COMMENT = eINSTANCE.getMember_Comment();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.DeclaratorImpl <em>Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.DeclaratorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getDeclarator()
     * @generated
     */
    EClass DECLARATOR = eINSTANCE.getDeclarator();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATOR__ID = eINSTANCE.getDeclarator_Id();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleDeclaratorImpl <em>Simple Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleDeclaratorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSimpleDeclarator()
     * @generated
     */
    EClass SIMPLE_DECLARATOR = eINSTANCE.getSimpleDeclarator();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComplexDeclaratorImpl <em>Complex Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComplexDeclaratorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComplexDeclarator()
     * @generated
     */
    EClass COMPLEX_DECLARATOR = eINSTANCE.getComplexDeclarator();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ArrayDeclaratorImpl <em>Array Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ArrayDeclaratorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getArrayDeclarator()
     * @generated
     */
    EClass ARRAY_DECLARATOR = eINSTANCE.getArrayDeclarator();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_DECLARATOR__SIZE = eINSTANCE.getArrayDeclarator_Size();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructTypeImpl <em>Struct Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStructType()
     * @generated
     */
    EClass STRUCT_TYPE = eINSTANCE.getStructType();

    /**
     * The meta object literal for the '<em><b>Extensibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_TYPE__EXTENSIBILITY = eINSTANCE.getStructType_Extensibility();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_TYPE__NAME = eINSTANCE.getStructType_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_TYPE__COMMENTS = eINSTANCE.getStructType_Comments();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_TYPE__MEMBERS = eINSTANCE.getStructType_Members();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclImpl <em>Type Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypeDecl()
     * @generated
     */
    EClass TYPE_DECL = eINSTANCE.getTypeDecl();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl <em>Type Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeDeclaratorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypeDeclarator()
     * @generated
     */
    EClass TYPE_DECLARATOR = eINSTANCE.getTypeDeclarator();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECLARATOR__COMMENTS = eINSTANCE.getTypeDeclarator_Comments();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECLARATOR__TYPE = eINSTANCE.getTypeDeclarator_Type();

    /**
     * The meta object literal for the '<em><b>Declarators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECLARATOR__DECLARATORS = eINSTANCE.getTypeDeclarator_Declarators();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeSpecImpl <em>Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypeSpec()
     * @generated
     */
    EClass TYPE_SPEC = eINSTANCE.getTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleTypeSpecImpl <em>Simple Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SimpleTypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSimpleTypeSpec()
     * @generated
     */
    EClass SIMPLE_TYPE_SPEC = eINSTANCE.getSimpleTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateTypeSpecImpl <em>Template Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateTypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateTypeSpec()
     * @generated
     */
    EClass TEMPLATE_TYPE_SPEC = eINSTANCE.getTemplateTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrTypeSpecImpl <em>Constr Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrTypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstrTypeSpec()
     * @generated
     */
    EClass CONSTR_TYPE_SPEC = eINSTANCE.getConstrTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionTypeImpl <em>Union Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnionType()
     * @generated
     */
    EClass UNION_TYPE = eINSTANCE.getUnionType();

    /**
     * The meta object literal for the '<em><b>Extensibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNION_TYPE__EXTENSIBILITY = eINSTANCE.getUnionType_Extensibility();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNION_TYPE__NAME = eINSTANCE.getUnionType_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNION_TYPE__COMMENTS = eINSTANCE.getUnionType_Comments();

    /**
     * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNION_TYPE__SWITCH = eINSTANCE.getUnionType_Switch();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNION_TYPE__BODY = eINSTANCE.getUnionType_Body();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchTypeSpecImpl <em>Switch Type Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchTypeSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSwitchTypeSpec()
     * @generated
     */
    EClass SWITCH_TYPE_SPEC = eINSTANCE.getSwitchTypeSpec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchBodyImpl <em>Switch Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SwitchBodyImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSwitchBody()
     * @generated
     */
    EClass SWITCH_BODY = eINSTANCE.getSwitchBody();

    /**
     * The meta object literal for the '<em><b>Case</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_BODY__CASE = eINSTANCE.getSwitchBody_Case();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseImpl <em>Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getCase()
     * @generated
     */
    EClass CASE = eINSTANCE.getCase();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE__COMMENTS = eINSTANCE.getCase_Comments();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE__LABEL = eINSTANCE.getCase_Label();

    /**
     * The meta object literal for the '<em><b>Spec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE__SPEC = eINSTANCE.getCase_Spec();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl <em>Case Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.CaseLabelImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getCaseLabel()
     * @generated
     */
    EClass CASE_LABEL = eINSTANCE.getCaseLabel();

    /**
     * The meta object literal for the '<em><b>Is Case</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_LABEL__IS_CASE = eINSTANCE.getCaseLabel_IsCase();

    /**
     * The meta object literal for the '<em><b>Const Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_LABEL__CONST_EXP = eINSTANCE.getCaseLabel_ConstExp();

    /**
     * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_LABEL__IS_DEFAULT = eINSTANCE.getCaseLabel_IsDefault();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ElementSpecImpl <em>Element Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ElementSpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getElementSpec()
     * @generated
     */
    EClass ELEMENT_SPEC = eINSTANCE.getElementSpec();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_SPEC__TYPE = eINSTANCE.getElementSpec_Type();

    /**
     * The meta object literal for the '<em><b>Declarator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_SPEC__DECLARATOR = eINSTANCE.getElementSpec_Declarator();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumTypeImpl <em>Enum Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEnumType()
     * @generated
     */
    EClass ENUM_TYPE = eINSTANCE.getEnumType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_TYPE__NAME = eINSTANCE.getEnumType_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_TYPE__COMMENTS = eINSTANCE.getEnumType_Comments();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_TYPE__LITERAL = eINSTANCE.getEnumType_Literal();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSequenceType()
     * @generated
     */
    EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE_TYPE__TYPE = eINSTANCE.getSequenceType_Type();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE_TYPE__SIZE = eINSTANCE.getSequenceType_Size();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.NativeTypeImpl <em>Native Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.NativeTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getNativeType()
     * @generated
     */
    EClass NATIVE_TYPE = eINSTANCE.getNativeType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NATIVE_TYPE__NAME = eINSTANCE.getNativeType_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtTypeImpl <em>Fixed Pt Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedPtType()
     * @generated
     */
    EClass FIXED_PT_TYPE = eINSTANCE.getFixedPtType();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIXED_PT_TYPE__LOWER = eINSTANCE.getFixedPtType_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIXED_PT_TYPE__UPPER = eINSTANCE.getFixedPtType_Upper();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrForwardDeclImpl <em>Constr Forward Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstrForwardDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstrForwardDecl()
     * @generated
     */
    EClass CONSTR_FORWARD_DECL = eINSTANCE.getConstrForwardDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTR_FORWARD_DECL__NAME = eINSTANCE.getConstrForwardDecl_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructForwardDeclImpl <em>Struct Forward Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructForwardDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStructForwardDecl()
     * @generated
     */
    EClass STRUCT_FORWARD_DECL = eINSTANCE.getStructForwardDecl();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionForwardDeclImpl <em>Union Forward Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionForwardDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnionForwardDecl()
     * @generated
     */
    EClass UNION_FORWARD_DECL = eINSTANCE.getUnionForwardDecl();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PositiveIntConstImpl <em>Positive Int Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PositiveIntConstImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPositiveIntConst()
     * @generated
     */
    EClass POSITIVE_INT_CONST = eINSTANCE.getPositiveIntConst();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSITIVE_INT_CONST__EXP = eINSTANCE.getPositiveIntConst_Exp();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstDeclImpl <em>Const Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstDecl()
     * @generated
     */
    EClass CONST_DECL = eINSTANCE.getConstDecl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONST_DECL__TYPE = eINSTANCE.getConstDecl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONST_DECL__NAME = eINSTANCE.getConstDecl_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONST_DECL__VALUE = eINSTANCE.getConstDecl_Value();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONST_DECL__COMMENTS = eINSTANCE.getConstDecl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstTypeImpl <em>Const Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstType()
     * @generated
     */
    EClass CONST_TYPE = eINSTANCE.getConstType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtConstTypeImpl <em>Fixed Pt Const Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedPtConstTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedPtConstType()
     * @generated
     */
    EClass FIXED_PT_CONST_TYPE = eINSTANCE.getFixedPtConstType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstExpImpl <em>Const Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstExpImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstExp()
     * @generated
     */
    EClass CONST_EXP = eINSTANCE.getConstExp();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.OrExprImpl <em>Or Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.OrExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getOrExpr()
     * @generated
     */
    EClass OR_EXPR = eINSTANCE.getOrExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPR__LHS = eINSTANCE.getOrExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OR_EXPR__OP = eINSTANCE.getOrExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPR__RHS = eINSTANCE.getOrExpr_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.XOrExprImpl <em>XOr Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.XOrExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getXOrExpr()
     * @generated
     */
    EClass XOR_EXPR = eINSTANCE.getXOrExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XOR_EXPR__LHS = eINSTANCE.getXOrExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XOR_EXPR__OP = eINSTANCE.getXOrExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XOR_EXPR__RHS = eINSTANCE.getXOrExpr_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AndExprImpl <em>And Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AndExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAndExpr()
     * @generated
     */
    EClass AND_EXPR = eINSTANCE.getAndExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPR__LHS = eINSTANCE.getAndExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AND_EXPR__OP = eINSTANCE.getAndExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPR__RHS = eINSTANCE.getAndExpr_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ShiftExprImpl <em>Shift Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ShiftExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getShiftExpr()
     * @generated
     */
    EClass SHIFT_EXPR = eINSTANCE.getShiftExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPR__LHS = eINSTANCE.getShiftExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPR__OP = eINSTANCE.getShiftExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPR__RHS = eINSTANCE.getShiftExpr_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.AddExprImpl <em>Add Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.AddExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getAddExpr()
     * @generated
     */
    EClass ADD_EXPR = eINSTANCE.getAddExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_EXPR__LHS = eINSTANCE.getAddExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADD_EXPR__OP = eINSTANCE.getAddExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_EXPR__RHS = eINSTANCE.getAddExpr_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.MultExprImpl <em>Mult Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.MultExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getMultExpr()
     * @generated
     */
    EClass MULT_EXPR = eINSTANCE.getMultExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT_EXPR__LHS = eINSTANCE.getMultExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULT_EXPR__OP = eINSTANCE.getMultExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT_EXPR__RHS = eINSTANCE.getMultExpr_Rhs();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnaryExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnaryExpr()
     * @generated
     */
    EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPR__OP = eINSTANCE.getUnaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__EXPR = eINSTANCE.getUnaryExpr_Expr();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryExprImpl <em>Primary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryExprImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPrimaryExpr()
     * @generated
     */
    EClass PRIMARY_EXPR = eINSTANCE.getPrimaryExpr();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.LiteralImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl <em>Component Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComponentDecl()
     * @generated
     */
    EClass COMPONENT_DECL = eINSTANCE.getComponentDecl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_DECL__COMMENTS = eINSTANCE.getComponentDecl_Comments();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT_DECL__NAME = eINSTANCE.getComponentDecl_Name();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_DECL__BASE = eINSTANCE.getComponentDecl_Base();

    /**
     * The meta object literal for the '<em><b>Supports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_DECL__SUPPORTS = eINSTANCE.getComponentDecl_Supports();

    /**
     * The meta object literal for the '<em><b>Export</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_DECL__EXPORT = eINSTANCE.getComponentDecl_Export();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentExportImpl <em>Component Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentExportImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComponentExport()
     * @generated
     */
    EClass COMPONENT_EXPORT = eINSTANCE.getComponentExport();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ProvidesDclImpl <em>Provides Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ProvidesDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getProvidesDcl()
     * @generated
     */
    EClass PROVIDES_DCL = eINSTANCE.getProvidesDcl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROVIDES_DCL__TYPE = eINSTANCE.getProvidesDcl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROVIDES_DCL__NAME = eINSTANCE.getProvidesDcl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROVIDES_DCL__COMMENTS = eINSTANCE.getProvidesDcl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl <em>Uses Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UsesDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUsesDcl()
     * @generated
     */
    EClass USES_DCL = eINSTANCE.getUsesDcl();

    /**
     * The meta object literal for the '<em><b>Is Multiple</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USES_DCL__IS_MULTIPLE = eINSTANCE.getUsesDcl_IsMultiple();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USES_DCL__TYPE = eINSTANCE.getUsesDcl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USES_DCL__NAME = eINSTANCE.getUsesDcl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USES_DCL__COMMENTS = eINSTANCE.getUsesDcl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PublishesDclImpl <em>Publishes Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PublishesDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPublishesDcl()
     * @generated
     */
    EClass PUBLISHES_DCL = eINSTANCE.getPublishesDcl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PUBLISHES_DCL__TYPE = eINSTANCE.getPublishesDcl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PUBLISHES_DCL__NAME = eINSTANCE.getPublishesDcl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PUBLISHES_DCL__COMMENTS = eINSTANCE.getPublishesDcl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EmitDclImpl <em>Emit Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EmitDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEmitDcl()
     * @generated
     */
    EClass EMIT_DCL = eINSTANCE.getEmitDcl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EMIT_DCL__TYPE = eINSTANCE.getEmitDcl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EMIT_DCL__NAME = eINSTANCE.getEmitDcl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EMIT_DCL__COMMENTS = eINSTANCE.getEmitDcl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConsumesDclImpl <em>Consumes Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConsumesDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConsumesDcl()
     * @generated
     */
    EClass CONSUMES_DCL = eINSTANCE.getConsumesDcl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSUMES_DCL__TYPE = eINSTANCE.getConsumesDcl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSUMES_DCL__NAME = eINSTANCE.getConsumesDcl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSUMES_DCL__COMMENTS = eINSTANCE.getConsumesDcl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentForwardDeclImpl <em>Component Forward Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ComponentForwardDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getComponentForwardDecl()
     * @generated
     */
    EClass COMPONENT_FORWARD_DECL = eINSTANCE.getComponentForwardDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT_FORWARD_DECL__NAME = eINSTANCE.getComponentForwardDecl_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl <em>Home Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getHomeDecl()
     * @generated
     */
    EClass HOME_DECL = eINSTANCE.getHomeDecl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOME_DECL__COMMENTS = eINSTANCE.getHomeDecl_Comments();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HOME_DECL__NAME = eINSTANCE.getHomeDecl_Name();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOME_DECL__BASE = eINSTANCE.getHomeDecl_Base();

    /**
     * The meta object literal for the '<em><b>Supports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOME_DECL__SUPPORTS = eINSTANCE.getHomeDecl_Supports();

    /**
     * The meta object literal for the '<em><b>Manages</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOME_DECL__MANAGES = eINSTANCE.getHomeDecl_Manages();

    /**
     * The meta object literal for the '<em><b>Primary key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOME_DECL__PRIMARY_KEY = eINSTANCE.getHomeDecl_Primary_key();

    /**
     * The meta object literal for the '<em><b>Export</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HOME_DECL__EXPORT = eINSTANCE.getHomeDecl_Export();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryKeySpecImpl <em>Primary Key Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PrimaryKeySpecImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPrimaryKeySpec()
     * @generated
     */
    EClass PRIMARY_KEY_SPEC = eINSTANCE.getPrimaryKeySpec();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_KEY_SPEC__KEY = eINSTANCE.getPrimaryKeySpec_Key();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeExportImpl <em>Home Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.HomeExportImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getHomeExport()
     * @generated
     */
    EClass HOME_EXPORT = eINSTANCE.getHomeExport();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FactoryDclImpl <em>Factory Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FactoryDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFactoryDcl()
     * @generated
     */
    EClass FACTORY_DCL = eINSTANCE.getFactoryDcl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_DCL__COMMENTS = eINSTANCE.getFactoryDcl_Comments();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTORY_DCL__NAME = eINSTANCE.getFactoryDcl_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_DCL__PARAMS = eINSTANCE.getFactoryDcl_Params();

    /**
     * The meta object literal for the '<em><b>Raises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_DCL__RAISES = eINSTANCE.getFactoryDcl_Raises();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl <em>Finder Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FinderDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFinderDcl()
     * @generated
     */
    EClass FINDER_DCL = eINSTANCE.getFinderDcl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FINDER_DCL__COMMENTS = eINSTANCE.getFinderDcl_Comments();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FINDER_DCL__NAME = eINSTANCE.getFinderDcl_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FINDER_DCL__PARAMS = eINSTANCE.getFinderDcl_Params();

    /**
     * The meta object literal for the '<em><b>Raises</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FINDER_DCL__RAISES = eINSTANCE.getFinderDcl_Raises();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__IS_ABSTRACT = eINSTANCE.getEvent_IsAbstract();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl <em>Event Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEventDcl()
     * @generated
     */
    EClass EVENT_DCL = eINSTANCE.getEventDcl();

    /**
     * The meta object literal for the '<em><b>Is Custom</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_DCL__IS_CUSTOM = eINSTANCE.getEventDcl_IsCustom();

    /**
     * The meta object literal for the '<em><b>Is Truncatable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_DCL__IS_TRUNCATABLE = eINSTANCE.getEventDcl_IsTruncatable();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DCL__BASE = eINSTANCE.getEventDcl_Base();

    /**
     * The meta object literal for the '<em><b>Supports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DCL__SUPPORTS = eINSTANCE.getEventDcl_Supports();

    /**
     * The meta object literal for the '<em><b>Export</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DCL__EXPORT = eINSTANCE.getEventDcl_Export();

    /**
     * The meta object literal for the '<em><b>Member</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DCL__MEMBER = eINSTANCE.getEventDcl_Member();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StateMemberImpl <em>State Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StateMemberImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStateMember()
     * @generated
     */
    EClass STATE_MEMBER = eINSTANCE.getStateMember();

    /**
     * The meta object literal for the '<em><b>Is Public</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_MEMBER__IS_PUBLIC = eINSTANCE.getStateMember_IsPublic();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MEMBER__TYPE = eINSTANCE.getStateMember_Type();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_MEMBER__NAMES = eINSTANCE.getStateMember_Names();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventForwardDclImpl <em>Event Forward Dcl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventForwardDclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEventForwardDcl()
     * @generated
     */
    EClass EVENT_FORWARD_DCL = eINSTANCE.getEventForwardDcl();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortTypeDeclImpl <em>Port Type Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortTypeDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPortTypeDecl()
     * @generated
     */
    EClass PORT_TYPE_DECL = eINSTANCE.getPortTypeDecl();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_TYPE_DECL__COMMENTS = eINSTANCE.getPortTypeDecl_Comments();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_TYPE_DECL__NAME = eINSTANCE.getPortTypeDecl_Name();

    /**
     * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_TYPE_DECL__EXPORTS = eINSTANCE.getPortTypeDecl_Exports();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortExportImpl <em>Port Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortExportImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPortExport()
     * @generated
     */
    EClass PORT_EXPORT = eINSTANCE.getPortExport();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl <em>Port Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.PortDeclImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getPortDecl()
     * @generated
     */
    EClass PORT_DECL = eINSTANCE.getPortDecl();

    /**
     * The meta object literal for the '<em><b>Is Mirror</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_DECL__IS_MIRROR = eINSTANCE.getPortDecl_IsMirror();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_DECL__TYPE = eINSTANCE.getPortDecl_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_DECL__NAME = eINSTANCE.getPortDecl_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_DECL__COMMENTS = eINSTANCE.getPortDecl_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorImpl <em>Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConnector()
     * @generated
     */
    EClass CONNECTOR = eINSTANCE.getConnector();

    /**
     * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__HEADER = eINSTANCE.getConnector_Header();

    /**
     * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__EXPORTS = eINSTANCE.getConnector_Exports();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorHeaderImpl <em>Connector Header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorHeaderImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConnectorHeader()
     * @generated
     */
    EClass CONNECTOR_HEADER = eINSTANCE.getConnectorHeader();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTOR_HEADER__NAME = eINSTANCE.getConnectorHeader_Name();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR_HEADER__BASE = eINSTANCE.getConnectorHeader_Base();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorExportImpl <em>Connector Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConnectorExportImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConnectorExport()
     * @generated
     */
    EClass CONNECTOR_EXPORT = eINSTANCE.getConnectorExport();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleImpl <em>Template Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateModule()
     * @generated
     */
    EClass TEMPLATE_MODULE = eINSTANCE.getTemplateModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEMPLATE_MODULE__NAME = eINSTANCE.getTemplateModule_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_MODULE__PARAMETERS = eINSTANCE.getTemplateModule_Parameters();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_MODULE__DEFINITIONS = eINSTANCE.getTemplateModule_Definitions();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterImpl <em>Formal Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFormalParameter()
     * @generated
     */
    EClass FORMAL_PARAMETER = eINSTANCE.getFormalParameter();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_PARAMETER__TYPE = eINSTANCE.getFormalParameter_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMAL_PARAMETER__NAME = eINSTANCE.getFormalParameter_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterTypeImpl <em>Formal Parameter Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FormalParameterTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFormalParameterType()
     * @generated
     */
    EClass FORMAL_PARAMETER_TYPE = eINSTANCE.getFormalParameterType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypenameParamTypeImpl <em>Typename Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TypenameParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTypenameParamType()
     * @generated
     */
    EClass TYPENAME_PARAM_TYPE = eINSTANCE.getTypenameParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceParamTypeImpl <em>Interface Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.InterfaceParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getInterfaceParamType()
     * @generated
     */
    EClass INTERFACE_PARAM_TYPE = eINSTANCE.getInterfaceParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValuetypeParamTypeImpl <em>Valuetype Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ValuetypeParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getValuetypeParamType()
     * @generated
     */
    EClass VALUETYPE_PARAM_TYPE = eINSTANCE.getValuetypeParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventParamTypeImpl <em>Event Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EventParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEventParamType()
     * @generated
     */
    EClass EVENT_PARAM_TYPE = eINSTANCE.getEventParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructParamTypeImpl <em>Struct Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.StructParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getStructParamType()
     * @generated
     */
    EClass STRUCT_PARAM_TYPE = eINSTANCE.getStructParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionParamTypeImpl <em>Union Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnionParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getUnionParamType()
     * @generated
     */
    EClass UNION_PARAM_TYPE = eINSTANCE.getUnionParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionParamTypeImpl <em>Exception Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ExceptionParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getExceptionParamType()
     * @generated
     */
    EClass EXCEPTION_PARAM_TYPE = eINSTANCE.getExceptionParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumParamTypeImpl <em>Enum Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.EnumParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getEnumParamType()
     * @generated
     */
    EClass ENUM_PARAM_TYPE = eINSTANCE.getEnumParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceParamTypeImpl <em>Sequence Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.SequenceParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getSequenceParamType()
     * @generated
     */
    EClass SEQUENCE_PARAM_TYPE = eINSTANCE.getSequenceParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstParamTypeImpl <em>Const Param Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ConstParamTypeImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getConstParamType()
     * @generated
     */
    EClass CONST_PARAM_TYPE = eINSTANCE.getConstParamType();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateDefinitionImpl <em>Template Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateDefinitionImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateDefinition()
     * @generated
     */
    EClass TEMPLATE_DEFINITION = eINSTANCE.getTemplateDefinition();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedModuleImpl <em>Fixed Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedModuleImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedModule()
     * @generated
     */
    EClass FIXED_MODULE = eINSTANCE.getFixedModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIXED_MODULE__NAME = eINSTANCE.getFixedModule_Name();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIXED_MODULE__DEFINITIONS = eINSTANCE.getFixedModule_Definitions();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedDefinitionImpl <em>Fixed Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.FixedDefinitionImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getFixedDefinition()
     * @generated
     */
    EClass FIXED_DEFINITION = eINSTANCE.getFixedDefinition();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleInstImpl <em>Template Module Inst</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleInstImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateModuleInst()
     * @generated
     */
    EClass TEMPLATE_MODULE_INST = eINSTANCE.getTemplateModuleInst();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_MODULE_INST__TYPE = eINSTANCE.getTemplateModuleInst_Type();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_MODULE_INST__PARAMETER = eINSTANCE.getTemplateModuleInst_Parameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEMPLATE_MODULE_INST__NAME = eINSTANCE.getTemplateModuleInst_Name();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_MODULE_INST__COMMENTS = eINSTANCE.getTemplateModuleInst_Comments();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.ActualParameterImpl <em>Actual Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.ActualParameterImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getActualParameter()
     * @generated
     */
    EClass ACTUAL_PARAMETER = eINSTANCE.getActualParameter();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleRefImpl <em>Template Module Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.TemplateModuleRefImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getTemplateModuleRef()
     * @generated
     */
    EClass TEMPLATE_MODULE_REF = eINSTANCE.getTemplateModuleRef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEMPLATE_MODULE_REF__TYPE = eINSTANCE.getTemplateModuleRef_Type();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEMPLATE_MODULE_REF__ID = eINSTANCE.getTemplateModuleRef_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEMPLATE_MODULE_REF__NAME = eINSTANCE.getTemplateModuleRef_Name();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.impl.IDLCommentImpl <em>IDL Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IDLCommentImpl
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getIDLComment()
     * @generated
     */
    EClass IDL_COMMENT = eINSTANCE.getIDLComment();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDL_COMMENT__BODY = eINSTANCE.getIDLComment_Body();

    /**
     * The meta object literal for the '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection <em>Param Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection
     * @see com.zeligsoft.domain.omg.corba.dsl.idl.impl.IdlPackageImpl#getParamDirection()
     * @generated
     */
    EEnum PARAM_DIRECTION = eINSTANCE.getParamDirection();

  }

} //IdlPackage
