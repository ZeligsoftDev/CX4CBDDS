/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.IdlFactory;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdlPackageImpl extends EPackageImpl implements IdlPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected String packageFilename = "idl.ecore";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preprocEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_IncludeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fileNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_IfdefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_IfndefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_UndefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_IfEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_If_CompareEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_If_ValEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_ElseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_ErrorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_DefineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_EndifEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_PragmaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_PrefixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_Conn_TypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_Ciao_LemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_Ciao_Ami4ccm_InterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_Ciao_Ami4ccm_ReceptacleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_Ciao_Ami4ccm_IdlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_NddsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_ComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_HomeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_DDS4CCM_ImplEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preproc_Pragma_MiscEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass file_MarkerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass excluded_File_MarkerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass import_declEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass definitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interface_or_Forward_DeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interface_declEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forward_declEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interface_headerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass readOnlyAttrSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrRaisesExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exceptionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass opDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass opTypeDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterDeclsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramTypeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scopedNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass baseTypeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatingPtTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass longDoubleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signedIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signedShortIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signedLongIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signedLongLongIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unsignedIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unsignedShortIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unsignedLongIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unsignedLongLongIntEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass charTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wideCharTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass octetTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anyTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueBaseTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wideStringTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exceptDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass memberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDeclaratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleTypeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateTypeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constrTypeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unionTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchTypeSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass switchBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass caseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass caseLabelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nativeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixedPtTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constrForwardDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structForwardDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unionForwardDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass positiveIntConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixedPtConstTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xOrExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentExportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass providesDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usesDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass publishesDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emitDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass consumesDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentForwardDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass homeDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryKeySpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass homeExportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factoryDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass finderDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateMemberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventForwardDclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portTypeDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portExportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass connectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass connectorHeaderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass connectorExportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateModuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typenameParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valuetypeParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unionParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exceptionParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constParamTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixedModuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixedDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateModuleInstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actualParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass templateModuleRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idlCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum paramDirectionEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private IdlPackageImpl()
  {
    super(eNS_URI, IdlFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link IdlPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @generated
   */
  public static IdlPackage init()
  {
    if (isInited) return (IdlPackage)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredIdlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    IdlPackageImpl theIdlPackage = registeredIdlPackage instanceof IdlPackageImpl ? (IdlPackageImpl)registeredIdlPackage : new IdlPackageImpl();

    isInited = true;

    // Load packages
    theIdlPackage.loadPackage();

    // Fix loaded packages
    theIdlPackage.fixPackageContents();

    // Mark meta-data to indicate it can't be changed
    theIdlPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IdlPackage.eNS_URI, theIdlPackage);
    return theIdlPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecification()
  {
    if (specificationEClass == null)
    {
      specificationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(0);
    }
    return specificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Imports()
  {
        return (EReference)getSpecification().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Definitions()
  {
        return (EReference)getSpecification().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc()
  {
    if (preprocEClass == null)
    {
      preprocEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(1);
    }
    return preprocEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Include()
  {
    if (preproc_IncludeEClass == null)
    {
      preproc_IncludeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(2);
    }
    return preproc_IncludeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreproc_Include_Value()
  {
        return (EReference)getPreproc_Include().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Include_StrValue()
  {
        return (EAttribute)getPreproc_Include().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFileName()
  {
    if (fileNameEClass == null)
    {
      fileNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(3);
    }
    return fileNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFileName_Name()
  {
        return (EAttribute)getFileName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Ifdef()
  {
    if (preproc_IfdefEClass == null)
    {
      preproc_IfdefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(4);
    }
    return preproc_IfdefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Ifdef_Value()
  {
        return (EAttribute)getPreproc_Ifdef().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Ifndef()
  {
    if (preproc_IfndefEClass == null)
    {
      preproc_IfndefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(5);
    }
    return preproc_IfndefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Ifndef_Value()
  {
        return (EAttribute)getPreproc_Ifndef().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Undef()
  {
    if (preproc_UndefEClass == null)
    {
      preproc_UndefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(6);
    }
    return preproc_UndefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Undef_Value()
  {
        return (EAttribute)getPreproc_Undef().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_If()
  {
    if (preproc_IfEClass == null)
    {
      preproc_IfEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(7);
    }
    return preproc_IfEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_If_Negation()
  {
        return (EAttribute)getPreproc_If().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreproc_If_Value()
  {
        return (EReference)getPreproc_If().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_If_Compare()
  {
    if (preproc_If_CompareEClass == null)
    {
      preproc_If_CompareEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(8);
    }
    return preproc_If_CompareEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreproc_If_Compare_Lhs()
  {
        return (EReference)getPreproc_If_Compare().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_If_Compare_Op()
  {
        return (EAttribute)getPreproc_If_Compare().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreproc_If_Compare_Rhs()
  {
        return (EReference)getPreproc_If_Compare().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_If_Val()
  {
    if (preproc_If_ValEClass == null)
    {
      preproc_If_ValEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(9);
    }
    return preproc_If_ValEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreproc_If_Val_Value()
  {
        return (EReference)getPreproc_If_Val().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Else()
  {
    if (preproc_ElseEClass == null)
    {
      preproc_ElseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(10);
    }
    return preproc_ElseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Error()
  {
    if (preproc_ErrorEClass == null)
    {
      preproc_ErrorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(11);
    }
    return preproc_ErrorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Error_Value()
  {
        return (EAttribute)getPreproc_Error().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Define()
  {
    if (preproc_DefineEClass == null)
    {
      preproc_DefineEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(12);
    }
    return preproc_DefineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Define_Value()
  {
        return (EAttribute)getPreproc_Define().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreproc_Define_Exp()
  {
        return (EReference)getPreproc_Define().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Endif()
  {
    if (preproc_EndifEClass == null)
    {
      preproc_EndifEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(13);
    }
    return preproc_EndifEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma()
  {
    if (preproc_PragmaEClass == null)
    {
      preproc_PragmaEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(14);
    }
    return preproc_PragmaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Prefix()
  {
    if (preproc_Pragma_PrefixEClass == null)
    {
      preproc_Pragma_PrefixEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(15);
    }
    return preproc_Pragma_PrefixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Prefix_Value()
  {
        return (EAttribute)getPreproc_Pragma_Prefix().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Conn_Type()
  {
    if (preproc_Pragma_Conn_TypeEClass == null)
    {
      preproc_Pragma_Conn_TypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(16);
    }
    return preproc_Pragma_Conn_TypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Conn_Type_ValuePort()
  {
        return (EAttribute)getPreproc_Pragma_Conn_Type().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Conn_Type_ValueConnType()
  {
        return (EAttribute)getPreproc_Pragma_Conn_Type().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Ciao_Lem()
  {
    if (preproc_Pragma_Ciao_LemEClass == null)
    {
      preproc_Pragma_Ciao_LemEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(17);
    }
    return preproc_Pragma_Ciao_LemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Ciao_Lem_Value()
  {
        return (EAttribute)getPreproc_Pragma_Ciao_Lem().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Ciao_Ami4ccm_Interface()
  {
    if (preproc_Pragma_Ciao_Ami4ccm_InterfaceEClass == null)
    {
      preproc_Pragma_Ciao_Ami4ccm_InterfaceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(18);
    }
    return preproc_Pragma_Ciao_Ami4ccm_InterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Ciao_Ami4ccm_Interface_Value()
  {
        return (EAttribute)getPreproc_Pragma_Ciao_Ami4ccm_Interface().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Ciao_Ami4ccm_Receptacle()
  {
    if (preproc_Pragma_Ciao_Ami4ccm_ReceptacleEClass == null)
    {
      preproc_Pragma_Ciao_Ami4ccm_ReceptacleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(19);
    }
    return preproc_Pragma_Ciao_Ami4ccm_ReceptacleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Ciao_Ami4ccm_Receptacle_Value()
  {
        return (EAttribute)getPreproc_Pragma_Ciao_Ami4ccm_Receptacle().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Ciao_Ami4ccm_Idl()
  {
    if (preproc_Pragma_Ciao_Ami4ccm_IdlEClass == null)
    {
      preproc_Pragma_Ciao_Ami4ccm_IdlEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(20);
    }
    return preproc_Pragma_Ciao_Ami4ccm_IdlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Ciao_Ami4ccm_Idl_Value()
  {
        return (EAttribute)getPreproc_Pragma_Ciao_Ami4ccm_Idl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Ndds()
  {
    if (preproc_Pragma_NddsEClass == null)
    {
      preproc_Pragma_NddsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(21);
    }
    return preproc_Pragma_NddsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Ndds_Value()
  {
        return (EAttribute)getPreproc_Pragma_Ndds().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Component()
  {
    if (preproc_Pragma_ComponentEClass == null)
    {
      preproc_Pragma_ComponentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(22);
    }
    return preproc_Pragma_ComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Component_Value()
  {
        return (EAttribute)getPreproc_Pragma_Component().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Home()
  {
    if (preproc_Pragma_HomeEClass == null)
    {
      preproc_Pragma_HomeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(23);
    }
    return preproc_Pragma_HomeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_Home_Value()
  {
        return (EAttribute)getPreproc_Pragma_Home().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_DDS4CCM_Impl()
  {
    if (preproc_Pragma_DDS4CCM_ImplEClass == null)
    {
      preproc_Pragma_DDS4CCM_ImplEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(24);
    }
    return preproc_Pragma_DDS4CCM_ImplEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreproc_Pragma_DDS4CCM_Impl_Value()
  {
        return (EAttribute)getPreproc_Pragma_DDS4CCM_Impl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreproc_Pragma_Misc()
  {
    if (preproc_Pragma_MiscEClass == null)
    {
      preproc_Pragma_MiscEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(25);
    }
    return preproc_Pragma_MiscEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFile_Marker()
  {
    if (file_MarkerEClass == null)
    {
      file_MarkerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(26);
    }
    return file_MarkerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFile_Marker_File()
  {
        return (EAttribute)getFile_Marker().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExcluded_File_Marker()
  {
    if (excluded_File_MarkerEClass == null)
    {
      excluded_File_MarkerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(27);
    }
    return excluded_File_MarkerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExcluded_File_Marker_File()
  {
        return (EAttribute)getExcluded_File_Marker().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport_decl()
  {
    if (import_declEClass == null)
    {
      import_declEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(28);
    }
    return import_declEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_decl_Imported_scope()
  {
        return (EAttribute)getImport_decl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefinition()
  {
    if (definitionEClass == null)
    {
      definitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(29);
    }
    return definitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    if (moduleEClass == null)
    {
      moduleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(30);
    }
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Name()
  {
        return (EAttribute)getModule().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Comments()
  {
        return (EReference)getModule().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Definitions()
  {
        return (EReference)getModule().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterface_or_Forward_Decl()
  {
    if (interface_or_Forward_DeclEClass == null)
    {
      interface_or_Forward_DeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(31);
    }
    return interface_or_Forward_DeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterface_decl()
  {
    if (interface_declEClass == null)
    {
      interface_declEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(32);
    }
    return interface_declEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterface_decl_Header()
  {
        return (EReference)getInterface_decl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterface_decl_InterfaceBody()
  {
        return (EReference)getInterface_decl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForward_decl()
  {
    if (forward_declEClass == null)
    {
      forward_declEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(33);
    }
    return forward_declEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForward_decl_Name()
  {
        return (EAttribute)getForward_decl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterface_header()
  {
    if (interface_headerEClass == null)
    {
      interface_headerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(34);
    }
    return interface_headerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterface_header_IsAbstract()
  {
        return (EAttribute)getInterface_header().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterface_header_IsLocal()
  {
        return (EAttribute)getInterface_header().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterface_header_Name()
  {
        return (EAttribute)getInterface_header().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterface_header_Specializes()
  {
        return (EReference)getInterface_header().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterface_header_Comments()
  {
        return (EReference)getInterface_header().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceBody()
  {
    if (interfaceBodyEClass == null)
    {
      interfaceBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(35);
    }
    return interfaceBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceBody_Export()
  {
        return (EReference)getInterfaceBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExport()
  {
    if (exportEClass == null)
    {
      exportEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(36);
    }
    return exportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttrDecl()
  {
    if (attrDeclEClass == null)
    {
      attrDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(37);
    }
    return attrDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttrDecl_Comments()
  {
        return (EReference)getAttrDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttrDecl_Type()
  {
        return (EReference)getAttrDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttrDecl_Names()
  {
        return (EAttribute)getAttrDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttrSpec()
  {
    if (attrSpecEClass == null)
    {
      attrSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(38);
    }
    return attrSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttrSpec_GetRaises()
  {
        return (EReference)getAttrSpec().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttrSpec_SetRaises()
  {
        return (EReference)getAttrSpec().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReadOnlyAttrSpec()
  {
    if (readOnlyAttrSpecEClass == null)
    {
      readOnlyAttrSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(39);
    }
    return readOnlyAttrSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReadOnlyAttrSpec_Raises()
  {
        return (EReference)getReadOnlyAttrSpec().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttrRaisesExpr()
  {
    if (attrRaisesExprEClass == null)
    {
      attrRaisesExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(40);
    }
    return attrRaisesExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttrRaisesExpr_Exceptions()
  {
        return (EReference)getAttrRaisesExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExceptionList()
  {
    if (exceptionListEClass == null)
    {
      exceptionListEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(41);
    }
    return exceptionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExceptionList_Exception()
  {
        return (EReference)getExceptionList().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOpDecl()
  {
    if (opDeclEClass == null)
    {
      opDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(42);
    }
    return opDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOpDecl_Comments()
  {
        return (EReference)getOpDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOpDecl_IsOneway()
  {
        return (EAttribute)getOpDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOpDecl_Type()
  {
        return (EReference)getOpDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOpDecl_Name()
  {
        return (EAttribute)getOpDecl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOpDecl_Params()
  {
        return (EReference)getOpDecl().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOpDecl_Raises()
  {
        return (EReference)getOpDecl().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOpDecl_Context()
  {
        return (EReference)getOpDecl().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOpTypeDecl()
  {
    if (opTypeDeclEClass == null)
    {
      opTypeDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(43);
    }
    return opTypeDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterDecls()
  {
    if (parameterDeclsEClass == null)
    {
      parameterDeclsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(44);
    }
    return parameterDeclsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDecls_Comments()
  {
        return (EReference)getParameterDecls().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDecls_Decls()
  {
        return (EReference)getParameterDecls().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParamDcl()
  {
    if (paramDclEClass == null)
    {
      paramDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(45);
    }
    return paramDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParamDcl_Direction()
  {
        return (EAttribute)getParamDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParamDcl_Type()
  {
        return (EReference)getParamDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParamDcl_Name()
  {
        return (EAttribute)getParamDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextExpr()
  {
    if (contextExprEClass == null)
    {
      contextExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(47);
    }
    return contextExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContextExpr_Literal()
  {
        return (EAttribute)getContextExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParamTypeSpec()
  {
    if (paramTypeSpecEClass == null)
    {
      paramTypeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(48);
    }
    return paramTypeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScopedName()
  {
    if (scopedNameEClass == null)
    {
      scopedNameEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(49);
    }
    return scopedNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScopedName_Name()
  {
        return (EAttribute)getScopedName().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBaseTypeSpec()
  {
    if (baseTypeSpecEClass == null)
    {
      baseTypeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(50);
    }
    return baseTypeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloatingPtType()
  {
    if (floatingPtTypeEClass == null)
    {
      floatingPtTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(51);
    }
    return floatingPtTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloatType()
  {
    if (floatTypeEClass == null)
    {
      floatTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(52);
    }
    return floatTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoubleType()
  {
    if (doubleTypeEClass == null)
    {
      doubleTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(53);
    }
    return doubleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLongDoubleType()
  {
    if (longDoubleTypeEClass == null)
    {
      longDoubleTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(54);
    }
    return longDoubleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerType()
  {
    if (integerTypeEClass == null)
    {
      integerTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(55);
    }
    return integerTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignedInt()
  {
    if (signedIntEClass == null)
    {
      signedIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(56);
    }
    return signedIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignedShortInt()
  {
    if (signedShortIntEClass == null)
    {
      signedShortIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(57);
    }
    return signedShortIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignedLongInt()
  {
    if (signedLongIntEClass == null)
    {
      signedLongIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(58);
    }
    return signedLongIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignedLongLongInt()
  {
    if (signedLongLongIntEClass == null)
    {
      signedLongLongIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(59);
    }
    return signedLongLongIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnsignedInt()
  {
    if (unsignedIntEClass == null)
    {
      unsignedIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(60);
    }
    return unsignedIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnsignedShortInt()
  {
    if (unsignedShortIntEClass == null)
    {
      unsignedShortIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(61);
    }
    return unsignedShortIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnsignedLongInt()
  {
    if (unsignedLongIntEClass == null)
    {
      unsignedLongIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(62);
    }
    return unsignedLongIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnsignedLongLongInt()
  {
    if (unsignedLongLongIntEClass == null)
    {
      unsignedLongLongIntEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(63);
    }
    return unsignedLongLongIntEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCharType()
  {
    if (charTypeEClass == null)
    {
      charTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(64);
    }
    return charTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWideCharType()
  {
    if (wideCharTypeEClass == null)
    {
      wideCharTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(65);
    }
    return wideCharTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanType()
  {
    if (booleanTypeEClass == null)
    {
      booleanTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(66);
    }
    return booleanTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOctetType()
  {
    if (octetTypeEClass == null)
    {
      octetTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(67);
    }
    return octetTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnyType()
  {
    if (anyTypeEClass == null)
    {
      anyTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(68);
    }
    return anyTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectType()
  {
    if (objectTypeEClass == null)
    {
      objectTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(69);
    }
    return objectTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueBaseType()
  {
    if (valueBaseTypeEClass == null)
    {
      valueBaseTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(70);
    }
    return valueBaseTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringType()
  {
    if (stringTypeEClass == null)
    {
      stringTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(71);
    }
    return stringTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringType_Size()
  {
        return (EReference)getStringType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWideStringType()
  {
    if (wideStringTypeEClass == null)
    {
      wideStringTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(72);
    }
    return wideStringTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWideStringType_Size()
  {
        return (EReference)getWideStringType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExceptDecl()
  {
    if (exceptDeclEClass == null)
    {
      exceptDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(73);
    }
    return exceptDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExceptDecl_Name()
  {
        return (EAttribute)getExceptDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExceptDecl_Comments()
  {
        return (EReference)getExceptDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExceptDecl_Members()
  {
        return (EReference)getExceptDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMember()
  {
    if (memberEClass == null)
    {
      memberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(74);
    }
    return memberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMember_Type()
  {
        return (EReference)getMember().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMember_Decl()
  {
        return (EReference)getMember().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMember_Comment()
  {
        return (EReference)getMember().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclarator()
  {
    if (declaratorEClass == null)
    {
      declaratorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(75);
    }
    return declaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeclarator_Id()
  {
        return (EAttribute)getDeclarator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleDeclarator()
  {
    if (simpleDeclaratorEClass == null)
    {
      simpleDeclaratorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(76);
    }
    return simpleDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexDeclarator()
  {
    if (complexDeclaratorEClass == null)
    {
      complexDeclaratorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(77);
    }
    return complexDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayDeclarator()
  {
    if (arrayDeclaratorEClass == null)
    {
      arrayDeclaratorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(78);
    }
    return arrayDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayDeclarator_Size()
  {
        return (EReference)getArrayDeclarator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructType()
  {
    if (structTypeEClass == null)
    {
      structTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(79);
    }
    return structTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructType_IsAppendable()
  {
        return (EAttribute)getStructType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructType_IsFinal()
  {
        return (EAttribute)getStructType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructType_Name()
  {
        return (EAttribute)getStructType().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructType_Comments()
  {
        return (EReference)getStructType().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructType_Members()
  {
        return (EReference)getStructType().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDecl()
  {
    if (typeDeclEClass == null)
    {
      typeDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(80);
    }
    return typeDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDeclarator()
  {
    if (typeDeclaratorEClass == null)
    {
      typeDeclaratorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(81);
    }
    return typeDeclaratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDeclarator_Comments()
  {
        return (EReference)getTypeDeclarator().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDeclarator_Type()
  {
        return (EReference)getTypeDeclarator().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDeclarator_Declarators()
  {
        return (EReference)getTypeDeclarator().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSpec()
  {
    if (typeSpecEClass == null)
    {
      typeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(82);
    }
    return typeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleTypeSpec()
  {
    if (simpleTypeSpecEClass == null)
    {
      simpleTypeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(83);
    }
    return simpleTypeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateTypeSpec()
  {
    if (templateTypeSpecEClass == null)
    {
      templateTypeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(84);
    }
    return templateTypeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstrTypeSpec()
  {
    if (constrTypeSpecEClass == null)
    {
      constrTypeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(85);
    }
    return constrTypeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnionType()
  {
    if (unionTypeEClass == null)
    {
      unionTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(86);
    }
    return unionTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnionType_Extensibility()
  {
        return (EAttribute)getUnionType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnionType_Name()
  {
        return (EAttribute)getUnionType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnionType_Comments()
  {
        return (EReference)getUnionType().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnionType_Switch()
  {
        return (EReference)getUnionType().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnionType_Body()
  {
        return (EReference)getUnionType().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchTypeSpec()
  {
    if (switchTypeSpecEClass == null)
    {
      switchTypeSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(87);
    }
    return switchTypeSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSwitchBody()
  {
    if (switchBodyEClass == null)
    {
      switchBodyEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(88);
    }
    return switchBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSwitchBody_Case()
  {
        return (EReference)getSwitchBody().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCase()
  {
    if (caseEClass == null)
    {
      caseEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(89);
    }
    return caseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCase_Comments()
  {
        return (EReference)getCase().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCase_Label()
  {
        return (EReference)getCase().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCase_Spec()
  {
        return (EReference)getCase().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCaseLabel()
  {
    if (caseLabelEClass == null)
    {
      caseLabelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(90);
    }
    return caseLabelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCaseLabel_IsCase()
  {
        return (EAttribute)getCaseLabel().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseLabel_ConstExp()
  {
        return (EReference)getCaseLabel().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCaseLabel_IsDefault()
  {
        return (EAttribute)getCaseLabel().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElementSpec()
  {
    if (elementSpecEClass == null)
    {
      elementSpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(91);
    }
    return elementSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElementSpec_Type()
  {
        return (EReference)getElementSpec().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElementSpec_Declarator()
  {
        return (EReference)getElementSpec().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumType()
  {
    if (enumTypeEClass == null)
    {
      enumTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(92);
    }
    return enumTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumType_Name()
  {
        return (EAttribute)getEnumType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumType_Comments()
  {
        return (EReference)getEnumType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumType_Literal()
  {
        return (EAttribute)getEnumType().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceType()
  {
    if (sequenceTypeEClass == null)
    {
      sequenceTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(93);
    }
    return sequenceTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceType_Type()
  {
        return (EReference)getSequenceType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequenceType_Size()
  {
        return (EReference)getSequenceType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNativeType()
  {
    if (nativeTypeEClass == null)
    {
      nativeTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(94);
    }
    return nativeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNativeType_Name()
  {
        return (EAttribute)getNativeType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixedPtType()
  {
    if (fixedPtTypeEClass == null)
    {
      fixedPtTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(95);
    }
    return fixedPtTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFixedPtType_Lower()
  {
        return (EReference)getFixedPtType().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFixedPtType_Upper()
  {
        return (EReference)getFixedPtType().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstrForwardDecl()
  {
    if (constrForwardDeclEClass == null)
    {
      constrForwardDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(96);
    }
    return constrForwardDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstrForwardDecl_Name()
  {
        return (EAttribute)getConstrForwardDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructForwardDecl()
  {
    if (structForwardDeclEClass == null)
    {
      structForwardDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(97);
    }
    return structForwardDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnionForwardDecl()
  {
    if (unionForwardDeclEClass == null)
    {
      unionForwardDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(98);
    }
    return unionForwardDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPositiveIntConst()
  {
    if (positiveIntConstEClass == null)
    {
      positiveIntConstEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(99);
    }
    return positiveIntConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPositiveIntConst_Exp()
  {
        return (EReference)getPositiveIntConst().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstDecl()
  {
    if (constDeclEClass == null)
    {
      constDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(100);
    }
    return constDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstDecl_Type()
  {
        return (EReference)getConstDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstDecl_Name()
  {
        return (EAttribute)getConstDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstDecl_Value()
  {
        return (EReference)getConstDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstDecl_Comments()
  {
        return (EReference)getConstDecl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstType()
  {
    if (constTypeEClass == null)
    {
      constTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(101);
    }
    return constTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixedPtConstType()
  {
    if (fixedPtConstTypeEClass == null)
    {
      fixedPtConstTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(102);
    }
    return fixedPtConstTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstExp()
  {
    if (constExpEClass == null)
    {
      constExpEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(103);
    }
    return constExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpr()
  {
    if (orExprEClass == null)
    {
      orExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(104);
    }
    return orExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpr_Lhs()
  {
        return (EReference)getOrExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrExpr_Op()
  {
        return (EAttribute)getOrExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpr_Rhs()
  {
        return (EReference)getOrExpr().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXOrExpr()
  {
    if (xOrExprEClass == null)
    {
      xOrExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(105);
    }
    return xOrExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXOrExpr_Lhs()
  {
        return (EReference)getXOrExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXOrExpr_Op()
  {
        return (EAttribute)getXOrExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXOrExpr_Rhs()
  {
        return (EReference)getXOrExpr().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpr()
  {
    if (andExprEClass == null)
    {
      andExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(106);
    }
    return andExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpr_Lhs()
  {
        return (EReference)getAndExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAndExpr_Op()
  {
        return (EAttribute)getAndExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpr_Rhs()
  {
        return (EReference)getAndExpr().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpr()
  {
    if (shiftExprEClass == null)
    {
      shiftExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(107);
    }
    return shiftExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpr_Lhs()
  {
        return (EReference)getShiftExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpr_Op()
  {
        return (EAttribute)getShiftExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpr_Rhs()
  {
        return (EReference)getShiftExpr().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddExpr()
  {
    if (addExprEClass == null)
    {
      addExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(108);
    }
    return addExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddExpr_Lhs()
  {
        return (EReference)getAddExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAddExpr_Op()
  {
        return (EAttribute)getAddExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddExpr_Rhs()
  {
        return (EReference)getAddExpr().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultExpr()
  {
    if (multExprEClass == null)
    {
      multExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(109);
    }
    return multExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultExpr_Lhs()
  {
        return (EReference)getMultExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultExpr_Op()
  {
        return (EAttribute)getMultExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultExpr_Rhs()
  {
        return (EReference)getMultExpr().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpr()
  {
    if (unaryExprEClass == null)
    {
      unaryExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(110);
    }
    return unaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpr_Op()
  {
        return (EAttribute)getUnaryExpr().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpr_Expr()
  {
        return (EReference)getUnaryExpr().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpr()
  {
    if (primaryExprEClass == null)
    {
      primaryExprEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(111);
    }
    return primaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteral()
  {
    if (literalEClass == null)
    {
      literalEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(112);
    }
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteral_Value()
  {
        return (EAttribute)getLiteral().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentDecl()
  {
    if (componentDeclEClass == null)
    {
      componentDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(113);
    }
    return componentDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentDecl_Comments()
  {
        return (EReference)getComponentDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponentDecl_Name()
  {
        return (EAttribute)getComponentDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentDecl_Base()
  {
        return (EReference)getComponentDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentDecl_Supports()
  {
        return (EReference)getComponentDecl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentDecl_Export()
  {
        return (EReference)getComponentDecl().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentExport()
  {
    if (componentExportEClass == null)
    {
      componentExportEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(114);
    }
    return componentExportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProvidesDcl()
  {
    if (providesDclEClass == null)
    {
      providesDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(115);
    }
    return providesDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProvidesDcl_Type()
  {
        return (EReference)getProvidesDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProvidesDcl_Name()
  {
        return (EAttribute)getProvidesDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProvidesDcl_Comments()
  {
        return (EReference)getProvidesDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUsesDcl()
  {
    if (usesDclEClass == null)
    {
      usesDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(116);
    }
    return usesDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUsesDcl_IsMultiple()
  {
        return (EAttribute)getUsesDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUsesDcl_Type()
  {
        return (EReference)getUsesDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUsesDcl_Name()
  {
        return (EAttribute)getUsesDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUsesDcl_Comments()
  {
        return (EReference)getUsesDcl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPublishesDcl()
  {
    if (publishesDclEClass == null)
    {
      publishesDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(117);
    }
    return publishesDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPublishesDcl_Type()
  {
        return (EReference)getPublishesDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPublishesDcl_Name()
  {
        return (EAttribute)getPublishesDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPublishesDcl_Comments()
  {
        return (EReference)getPublishesDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmitDcl()
  {
    if (emitDclEClass == null)
    {
      emitDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(118);
    }
    return emitDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEmitDcl_Type()
  {
        return (EReference)getEmitDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEmitDcl_Name()
  {
        return (EAttribute)getEmitDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEmitDcl_Comments()
  {
        return (EReference)getEmitDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConsumesDcl()
  {
    if (consumesDclEClass == null)
    {
      consumesDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(119);
    }
    return consumesDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConsumesDcl_Type()
  {
        return (EReference)getConsumesDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConsumesDcl_Name()
  {
        return (EAttribute)getConsumesDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConsumesDcl_Comments()
  {
        return (EReference)getConsumesDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentForwardDecl()
  {
    if (componentForwardDeclEClass == null)
    {
      componentForwardDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(120);
    }
    return componentForwardDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponentForwardDecl_Name()
  {
        return (EAttribute)getComponentForwardDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHomeDecl()
  {
    if (homeDeclEClass == null)
    {
      homeDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(121);
    }
    return homeDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHomeDecl_Comments()
  {
        return (EReference)getHomeDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHomeDecl_Name()
  {
        return (EAttribute)getHomeDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHomeDecl_Base()
  {
        return (EReference)getHomeDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHomeDecl_Supports()
  {
        return (EReference)getHomeDecl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHomeDecl_Manages()
  {
        return (EReference)getHomeDecl().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHomeDecl_Primary_key()
  {
        return (EReference)getHomeDecl().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHomeDecl_Export()
  {
        return (EReference)getHomeDecl().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryKeySpec()
  {
    if (primaryKeySpecEClass == null)
    {
      primaryKeySpecEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(122);
    }
    return primaryKeySpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryKeySpec_Key()
  {
        return (EReference)getPrimaryKeySpec().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHomeExport()
  {
    if (homeExportEClass == null)
    {
      homeExportEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(123);
    }
    return homeExportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFactoryDcl()
  {
    if (factoryDclEClass == null)
    {
      factoryDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(124);
    }
    return factoryDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryDcl_Comments()
  {
        return (EReference)getFactoryDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFactoryDcl_Name()
  {
        return (EAttribute)getFactoryDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryDcl_Params()
  {
        return (EReference)getFactoryDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFactoryDcl_Raises()
  {
        return (EReference)getFactoryDcl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFinderDcl()
  {
    if (finderDclEClass == null)
    {
      finderDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(125);
    }
    return finderDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFinderDcl_Comments()
  {
        return (EReference)getFinderDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFinderDcl_Name()
  {
        return (EAttribute)getFinderDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFinderDcl_Params()
  {
        return (EReference)getFinderDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFinderDcl_Raises()
  {
        return (EReference)getFinderDcl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvent()
  {
    if (eventEClass == null)
    {
      eventEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(126);
    }
    return eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvent_IsAbstract()
  {
        return (EAttribute)getEvent().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvent_Name()
  {
        return (EAttribute)getEvent().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventDcl()
  {
    if (eventDclEClass == null)
    {
      eventDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(127);
    }
    return eventDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventDcl_IsCustom()
  {
        return (EAttribute)getEventDcl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventDcl_IsTruncatable()
  {
        return (EAttribute)getEventDcl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDcl_Base()
  {
        return (EReference)getEventDcl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDcl_Supports()
  {
        return (EReference)getEventDcl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDcl_Export()
  {
        return (EReference)getEventDcl().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDcl_Member()
  {
        return (EReference)getEventDcl().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateMember()
  {
    if (stateMemberEClass == null)
    {
      stateMemberEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(128);
    }
    return stateMemberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateMember_IsPublic()
  {
        return (EAttribute)getStateMember().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateMember_Type()
  {
        return (EReference)getStateMember().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateMember_Names()
  {
        return (EAttribute)getStateMember().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventForwardDcl()
  {
    if (eventForwardDclEClass == null)
    {
      eventForwardDclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(129);
    }
    return eventForwardDclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPortTypeDecl()
  {
    if (portTypeDeclEClass == null)
    {
      portTypeDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(130);
    }
    return portTypeDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortTypeDecl_Comments()
  {
        return (EReference)getPortTypeDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPortTypeDecl_Name()
  {
        return (EAttribute)getPortTypeDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortTypeDecl_Exports()
  {
        return (EReference)getPortTypeDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPortExport()
  {
    if (portExportEClass == null)
    {
      portExportEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(131);
    }
    return portExportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPortDecl()
  {
    if (portDeclEClass == null)
    {
      portDeclEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(132);
    }
    return portDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPortDecl_IsMirror()
  {
        return (EAttribute)getPortDecl().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortDecl_Type()
  {
        return (EReference)getPortDecl().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPortDecl_Name()
  {
        return (EAttribute)getPortDecl().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortDecl_Comments()
  {
        return (EReference)getPortDecl().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConnector()
  {
    if (connectorEClass == null)
    {
      connectorEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(133);
    }
    return connectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConnector_Header()
  {
        return (EReference)getConnector().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConnector_Exports()
  {
        return (EReference)getConnector().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConnectorHeader()
  {
    if (connectorHeaderEClass == null)
    {
      connectorHeaderEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(134);
    }
    return connectorHeaderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConnectorHeader_Name()
  {
        return (EAttribute)getConnectorHeader().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConnectorHeader_Base()
  {
        return (EReference)getConnectorHeader().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConnectorExport()
  {
    if (connectorExportEClass == null)
    {
      connectorExportEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(135);
    }
    return connectorExportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateModule()
  {
    if (templateModuleEClass == null)
    {
      templateModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(136);
    }
    return templateModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTemplateModule_Name()
  {
        return (EAttribute)getTemplateModule().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateModule_Parameters()
  {
        return (EReference)getTemplateModule().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateModule_Definitions()
  {
        return (EReference)getTemplateModule().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameter()
  {
    if (formalParameterEClass == null)
    {
      formalParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(137);
    }
    return formalParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameter_Type()
  {
        return (EReference)getFormalParameter().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_Name()
  {
        return (EAttribute)getFormalParameter().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameterType()
  {
    if (formalParameterTypeEClass == null)
    {
      formalParameterTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(138);
    }
    return formalParameterTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypenameParamType()
  {
    if (typenameParamTypeEClass == null)
    {
      typenameParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(139);
    }
    return typenameParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceParamType()
  {
    if (interfaceParamTypeEClass == null)
    {
      interfaceParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(140);
    }
    return interfaceParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValuetypeParamType()
  {
    if (valuetypeParamTypeEClass == null)
    {
      valuetypeParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(141);
    }
    return valuetypeParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventParamType()
  {
    if (eventParamTypeEClass == null)
    {
      eventParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(142);
    }
    return eventParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructParamType()
  {
    if (structParamTypeEClass == null)
    {
      structParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(143);
    }
    return structParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnionParamType()
  {
    if (unionParamTypeEClass == null)
    {
      unionParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(144);
    }
    return unionParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExceptionParamType()
  {
    if (exceptionParamTypeEClass == null)
    {
      exceptionParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(145);
    }
    return exceptionParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumParamType()
  {
    if (enumParamTypeEClass == null)
    {
      enumParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(146);
    }
    return enumParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceParamType()
  {
    if (sequenceParamTypeEClass == null)
    {
      sequenceParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(147);
    }
    return sequenceParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstParamType()
  {
    if (constParamTypeEClass == null)
    {
      constParamTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(148);
    }
    return constParamTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateDefinition()
  {
    if (templateDefinitionEClass == null)
    {
      templateDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(149);
    }
    return templateDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixedModule()
  {
    if (fixedModuleEClass == null)
    {
      fixedModuleEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(150);
    }
    return fixedModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFixedModule_Name()
  {
        return (EAttribute)getFixedModule().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFixedModule_Definitions()
  {
        return (EReference)getFixedModule().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixedDefinition()
  {
    if (fixedDefinitionEClass == null)
    {
      fixedDefinitionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(151);
    }
    return fixedDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateModuleInst()
  {
    if (templateModuleInstEClass == null)
    {
      templateModuleInstEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(152);
    }
    return templateModuleInstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateModuleInst_Type()
  {
        return (EReference)getTemplateModuleInst().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateModuleInst_Parameter()
  {
        return (EReference)getTemplateModuleInst().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTemplateModuleInst_Name()
  {
        return (EAttribute)getTemplateModuleInst().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateModuleInst_Comments()
  {
        return (EReference)getTemplateModuleInst().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActualParameter()
  {
    if (actualParameterEClass == null)
    {
      actualParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(153);
    }
    return actualParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTemplateModuleRef()
  {
    if (templateModuleRefEClass == null)
    {
      templateModuleRefEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(154);
    }
    return templateModuleRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTemplateModuleRef_Type()
  {
        return (EReference)getTemplateModuleRef().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTemplateModuleRef_Id()
  {
        return (EAttribute)getTemplateModuleRef().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTemplateModuleRef_Name()
  {
        return (EAttribute)getTemplateModuleRef().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIDLComment()
  {
    if (idlCommentEClass == null)
    {
      idlCommentEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(155);
    }
    return idlCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIDLComment_Body()
  {
        return (EAttribute)getIDLComment().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getParamDirection()
  {
    if (paramDirectionEEnum == null)
    {
      paramDirectionEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(IdlPackage.eNS_URI).getEClassifiers().get(46);
    }
    return paramDirectionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdlFactory getIdlFactory()
  {
    return (IdlFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isLoaded = false;

  /**
   * Laods the package and any sub-packages from their serialized form.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void loadPackage()
  {
    if (isLoaded) return;
    isLoaded = true;

    URL url = getClass().getResource(packageFilename);
    if (url == null)
    {
      throw new RuntimeException("Missing serialized package: " + packageFilename);
    }
    URI uri = URI.createURI(url.toString());
    Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
    try
    {
      resource.load(null);
    }
    catch (IOException exception)
    {
      throw new WrappedException(exception);
    }
    initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
    createResource(eNS_URI);
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isFixed = false;

  /**
   * Fixes up the loaded package, to make it appear as if it had been programmatically built.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fixPackageContents()
  {
    if (isFixed) return;
    isFixed = true;
    fixEClassifiers();
  }

  /**
   * Sets the instance class on the given classifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void fixInstanceClass(EClassifier eClassifier)
  {
    if (eClassifier.getInstanceClassName() == null)
    {
      eClassifier.setInstanceClassName("com.zeligsoft.domain.omg.corba.dsl.idl." + eClassifier.getName());
      setGeneratedClassName(eClassifier);
    }
  }

} //IdlPackageImpl
