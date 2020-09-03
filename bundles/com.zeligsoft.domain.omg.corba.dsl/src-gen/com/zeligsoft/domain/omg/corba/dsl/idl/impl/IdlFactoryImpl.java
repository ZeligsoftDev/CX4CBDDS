/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.impl;

import com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AnyType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.BaseTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.BooleanType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Case;
import com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel;
import com.zeligsoft.domain.omg.corba.dsl.idl.CharType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComplexDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Connector;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstrTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.Declarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.Definition;
import com.zeligsoft.domain.omg.corba.dsl.idl.DoubleType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Event;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventForwardDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker;
import com.zeligsoft.domain.omg.corba.dsl.idl.Export;
import com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.FileName;
import com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker;
import com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition;
import com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtConstType;
import com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType;
import com.zeligsoft.domain.omg.corba.dsl.idl.FloatType;
import com.zeligsoft.domain.omg.corba.dsl.idl.FloatingPtType;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlFactory;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage;
import com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.IntegerType;
import com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody;
import com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_or_Forward_Decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Literal;
import com.zeligsoft.domain.omg.corba.dsl.idl.LongDoubleType;
import com.zeligsoft.domain.omg.corba.dsl.idl.Member;
import com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.NativeType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ObjectType;
import com.zeligsoft.domain.omg.corba.dsl.idl.OctetType;
import com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.OpTypeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortExport;
import com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Else;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Misc;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef;
import com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SignedShortInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.SimpleDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.SimpleTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.Specification;
import com.zeligsoft.domain.omg.corba.dsl.idl.StateMember;
import com.zeligsoft.domain.omg.corba.dsl.idl.StringType;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructForwardDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructType;
import com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody;
import com.zeligsoft.domain.omg.corba.dsl.idl.SwitchTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef;
import com.zeligsoft.domain.omg.corba.dsl.idl.TemplateTypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionForwardDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongLongInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedShortInt;
import com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ValueBaseType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.WideCharType;
import com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType;
import com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdlFactoryImpl extends EFactoryImpl implements IdlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IdlFactory init()
  {
    try
    {
      IdlFactory theIdlFactory = (IdlFactory)EPackage.Registry.INSTANCE.getEFactory(IdlPackage.eNS_URI);
      if (theIdlFactory != null)
      {
        return theIdlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new IdlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case IdlPackage.SPECIFICATION: return (EObject)createSpecification();
      case IdlPackage.PREPROC: return (EObject)createPreproc();
      case IdlPackage.PREPROC_INCLUDE: return (EObject)createPreproc_Include();
      case IdlPackage.FILE_NAME: return (EObject)createFileName();
      case IdlPackage.PREPROC_IFDEF: return (EObject)createPreproc_Ifdef();
      case IdlPackage.PREPROC_IFNDEF: return (EObject)createPreproc_Ifndef();
      case IdlPackage.PREPROC_UNDEF: return (EObject)createPreproc_Undef();
      case IdlPackage.PREPROC_IF: return (EObject)createPreproc_If();
      case IdlPackage.PREPROC_IF_COMPARE: return (EObject)createPreproc_If_Compare();
      case IdlPackage.PREPROC_IF_VAL: return (EObject)createPreproc_If_Val();
      case IdlPackage.PREPROC_ELSE: return (EObject)createPreproc_Else();
      case IdlPackage.PREPROC_ERROR: return (EObject)createPreproc_Error();
      case IdlPackage.PREPROC_DEFINE: return (EObject)createPreproc_Define();
      case IdlPackage.PREPROC_ENDIF: return (EObject)createPreproc_Endif();
      case IdlPackage.PREPROC_PRAGMA: return (EObject)createPreproc_Pragma();
      case IdlPackage.PREPROC_PRAGMA_PREFIX: return (EObject)createPreproc_Pragma_Prefix();
      case IdlPackage.PREPROC_PRAGMA_CONN_TYPE: return (EObject)createPreproc_Pragma_Conn_Type();
      case IdlPackage.PREPROC_PRAGMA_CIAO_LEM: return (EObject)createPreproc_Pragma_Ciao_Lem();
      case IdlPackage.PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE: return (EObject)createPreproc_Pragma_Ciao_Ami4ccm_Interface();
      case IdlPackage.PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE: return (EObject)createPreproc_Pragma_Ciao_Ami4ccm_Receptacle();
      case IdlPackage.PREPROC_PRAGMA_CIAO_AMI4CCM_IDL: return (EObject)createPreproc_Pragma_Ciao_Ami4ccm_Idl();
      case IdlPackage.PREPROC_PRAGMA_NDDS: return (EObject)createPreproc_Pragma_Ndds();
      case IdlPackage.PREPROC_PRAGMA_COMPONENT: return (EObject)createPreproc_Pragma_Component();
      case IdlPackage.PREPROC_PRAGMA_HOME: return (EObject)createPreproc_Pragma_Home();
      case IdlPackage.PREPROC_PRAGMA_DDS4CCM_IMPL: return (EObject)createPreproc_Pragma_DDS4CCM_Impl();
      case IdlPackage.PREPROC_PRAGMA_MISC: return (EObject)createPreproc_Pragma_Misc();
      case IdlPackage.FILE_MARKER: return (EObject)createFile_Marker();
      case IdlPackage.EXCLUDED_FILE_MARKER: return (EObject)createExcluded_File_Marker();
      case IdlPackage.IMPORT_DECL: return (EObject)createImport_decl();
      case IdlPackage.DEFINITION: return (EObject)createDefinition();
      case IdlPackage.MODULE: return (EObject)createModule();
      case IdlPackage.INTERFACE_OR_FORWARD_DECL: return (EObject)createInterface_or_Forward_Decl();
      case IdlPackage.INTERFACE_DECL: return (EObject)createInterface_decl();
      case IdlPackage.FORWARD_DECL: return (EObject)createForward_decl();
      case IdlPackage.INTERFACE_HEADER: return (EObject)createInterface_header();
      case IdlPackage.INTERFACE_BODY: return (EObject)createInterfaceBody();
      case IdlPackage.EXPORT: return (EObject)createExport();
      case IdlPackage.ATTR_DECL: return (EObject)createAttrDecl();
      case IdlPackage.ATTR_SPEC: return (EObject)createAttrSpec();
      case IdlPackage.READ_ONLY_ATTR_SPEC: return (EObject)createReadOnlyAttrSpec();
      case IdlPackage.ATTR_RAISES_EXPR: return (EObject)createAttrRaisesExpr();
      case IdlPackage.EXCEPTION_LIST: return (EObject)createExceptionList();
      case IdlPackage.OP_DECL: return (EObject)createOpDecl();
      case IdlPackage.OP_TYPE_DECL: return (EObject)createOpTypeDecl();
      case IdlPackage.PARAMETER_DECLS: return (EObject)createParameterDecls();
      case IdlPackage.PARAM_DCL: return (EObject)createParamDcl();
      case IdlPackage.CONTEXT_EXPR: return (EObject)createContextExpr();
      case IdlPackage.PARAM_TYPE_SPEC: return (EObject)createParamTypeSpec();
      case IdlPackage.SCOPED_NAME: return (EObject)createScopedName();
      case IdlPackage.BASE_TYPE_SPEC: return (EObject)createBaseTypeSpec();
      case IdlPackage.FLOATING_PT_TYPE: return (EObject)createFloatingPtType();
      case IdlPackage.FLOAT_TYPE: return (EObject)createFloatType();
      case IdlPackage.DOUBLE_TYPE: return (EObject)createDoubleType();
      case IdlPackage.LONG_DOUBLE_TYPE: return (EObject)createLongDoubleType();
      case IdlPackage.INTEGER_TYPE: return (EObject)createIntegerType();
      case IdlPackage.SIGNED_INT: return (EObject)createSignedInt();
      case IdlPackage.SIGNED_SHORT_INT: return (EObject)createSignedShortInt();
      case IdlPackage.SIGNED_LONG_INT: return (EObject)createSignedLongInt();
      case IdlPackage.SIGNED_LONG_LONG_INT: return (EObject)createSignedLongLongInt();
      case IdlPackage.UNSIGNED_INT: return (EObject)createUnsignedInt();
      case IdlPackage.UNSIGNED_SHORT_INT: return (EObject)createUnsignedShortInt();
      case IdlPackage.UNSIGNED_LONG_INT: return (EObject)createUnsignedLongInt();
      case IdlPackage.UNSIGNED_LONG_LONG_INT: return (EObject)createUnsignedLongLongInt();
      case IdlPackage.CHAR_TYPE: return (EObject)createCharType();
      case IdlPackage.WIDE_CHAR_TYPE: return (EObject)createWideCharType();
      case IdlPackage.BOOLEAN_TYPE: return (EObject)createBooleanType();
      case IdlPackage.OCTET_TYPE: return (EObject)createOctetType();
      case IdlPackage.ANY_TYPE: return (EObject)createAnyType();
      case IdlPackage.OBJECT_TYPE: return (EObject)createObjectType();
      case IdlPackage.VALUE_BASE_TYPE: return (EObject)createValueBaseType();
      case IdlPackage.STRING_TYPE: return (EObject)createStringType();
      case IdlPackage.WIDE_STRING_TYPE: return (EObject)createWideStringType();
      case IdlPackage.EXCEPT_DECL: return (EObject)createExceptDecl();
      case IdlPackage.MEMBER: return (EObject)createMember();
      case IdlPackage.DECLARATOR: return (EObject)createDeclarator();
      case IdlPackage.SIMPLE_DECLARATOR: return (EObject)createSimpleDeclarator();
      case IdlPackage.COMPLEX_DECLARATOR: return (EObject)createComplexDeclarator();
      case IdlPackage.ARRAY_DECLARATOR: return (EObject)createArrayDeclarator();
      case IdlPackage.STRUCT_TYPE: return (EObject)createStructType();
      case IdlPackage.TYPE_DECL: return (EObject)createTypeDecl();
      case IdlPackage.TYPE_DECLARATOR: return (EObject)createTypeDeclarator();
      case IdlPackage.TYPE_SPEC: return (EObject)createTypeSpec();
      case IdlPackage.SIMPLE_TYPE_SPEC: return (EObject)createSimpleTypeSpec();
      case IdlPackage.TEMPLATE_TYPE_SPEC: return (EObject)createTemplateTypeSpec();
      case IdlPackage.CONSTR_TYPE_SPEC: return (EObject)createConstrTypeSpec();
      case IdlPackage.UNION_TYPE: return (EObject)createUnionType();
      case IdlPackage.SWITCH_TYPE_SPEC: return (EObject)createSwitchTypeSpec();
      case IdlPackage.SWITCH_BODY: return (EObject)createSwitchBody();
      case IdlPackage.CASE: return (EObject)createCase();
      case IdlPackage.CASE_LABEL: return (EObject)createCaseLabel();
      case IdlPackage.ELEMENT_SPEC: return (EObject)createElementSpec();
      case IdlPackage.ENUM_TYPE: return (EObject)createEnumType();
      case IdlPackage.SEQUENCE_TYPE: return (EObject)createSequenceType();
      case IdlPackage.NATIVE_TYPE: return (EObject)createNativeType();
      case IdlPackage.FIXED_PT_TYPE: return (EObject)createFixedPtType();
      case IdlPackage.CONSTR_FORWARD_DECL: return (EObject)createConstrForwardDecl();
      case IdlPackage.STRUCT_FORWARD_DECL: return (EObject)createStructForwardDecl();
      case IdlPackage.UNION_FORWARD_DECL: return (EObject)createUnionForwardDecl();
      case IdlPackage.POSITIVE_INT_CONST: return (EObject)createPositiveIntConst();
      case IdlPackage.CONST_DECL: return (EObject)createConstDecl();
      case IdlPackage.CONST_TYPE: return (EObject)createConstType();
      case IdlPackage.FIXED_PT_CONST_TYPE: return (EObject)createFixedPtConstType();
      case IdlPackage.CONST_EXP: return (EObject)createConstExp();
      case IdlPackage.OR_EXPR: return (EObject)createOrExpr();
      case IdlPackage.XOR_EXPR: return (EObject)createXOrExpr();
      case IdlPackage.AND_EXPR: return (EObject)createAndExpr();
      case IdlPackage.SHIFT_EXPR: return (EObject)createShiftExpr();
      case IdlPackage.ADD_EXPR: return (EObject)createAddExpr();
      case IdlPackage.MULT_EXPR: return (EObject)createMultExpr();
      case IdlPackage.UNARY_EXPR: return (EObject)createUnaryExpr();
      case IdlPackage.PRIMARY_EXPR: return (EObject)createPrimaryExpr();
      case IdlPackage.LITERAL: return (EObject)createLiteral();
      case IdlPackage.COMPONENT_DECL: return (EObject)createComponentDecl();
      case IdlPackage.COMPONENT_EXPORT: return (EObject)createComponentExport();
      case IdlPackage.PROVIDES_DCL: return (EObject)createProvidesDcl();
      case IdlPackage.USES_DCL: return (EObject)createUsesDcl();
      case IdlPackage.PUBLISHES_DCL: return (EObject)createPublishesDcl();
      case IdlPackage.EMIT_DCL: return (EObject)createEmitDcl();
      case IdlPackage.CONSUMES_DCL: return (EObject)createConsumesDcl();
      case IdlPackage.COMPONENT_FORWARD_DECL: return (EObject)createComponentForwardDecl();
      case IdlPackage.HOME_DECL: return (EObject)createHomeDecl();
      case IdlPackage.PRIMARY_KEY_SPEC: return (EObject)createPrimaryKeySpec();
      case IdlPackage.HOME_EXPORT: return (EObject)createHomeExport();
      case IdlPackage.FACTORY_DCL: return (EObject)createFactoryDcl();
      case IdlPackage.FINDER_DCL: return (EObject)createFinderDcl();
      case IdlPackage.EVENT: return (EObject)createEvent();
      case IdlPackage.EVENT_DCL: return (EObject)createEventDcl();
      case IdlPackage.STATE_MEMBER: return (EObject)createStateMember();
      case IdlPackage.EVENT_FORWARD_DCL: return (EObject)createEventForwardDcl();
      case IdlPackage.PORT_TYPE_DECL: return (EObject)createPortTypeDecl();
      case IdlPackage.PORT_EXPORT: return (EObject)createPortExport();
      case IdlPackage.PORT_DECL: return (EObject)createPortDecl();
      case IdlPackage.CONNECTOR: return (EObject)createConnector();
      case IdlPackage.CONNECTOR_HEADER: return (EObject)createConnectorHeader();
      case IdlPackage.CONNECTOR_EXPORT: return (EObject)createConnectorExport();
      case IdlPackage.TEMPLATE_MODULE: return (EObject)createTemplateModule();
      case IdlPackage.FORMAL_PARAMETER: return (EObject)createFormalParameter();
      case IdlPackage.FORMAL_PARAMETER_TYPE: return (EObject)createFormalParameterType();
      case IdlPackage.TYPENAME_PARAM_TYPE: return (EObject)createTypenameParamType();
      case IdlPackage.INTERFACE_PARAM_TYPE: return (EObject)createInterfaceParamType();
      case IdlPackage.VALUETYPE_PARAM_TYPE: return (EObject)createValuetypeParamType();
      case IdlPackage.EVENT_PARAM_TYPE: return (EObject)createEventParamType();
      case IdlPackage.STRUCT_PARAM_TYPE: return (EObject)createStructParamType();
      case IdlPackage.UNION_PARAM_TYPE: return (EObject)createUnionParamType();
      case IdlPackage.EXCEPTION_PARAM_TYPE: return (EObject)createExceptionParamType();
      case IdlPackage.ENUM_PARAM_TYPE: return (EObject)createEnumParamType();
      case IdlPackage.SEQUENCE_PARAM_TYPE: return (EObject)createSequenceParamType();
      case IdlPackage.CONST_PARAM_TYPE: return (EObject)createConstParamType();
      case IdlPackage.TEMPLATE_DEFINITION: return (EObject)createTemplateDefinition();
      case IdlPackage.FIXED_MODULE: return (EObject)createFixedModule();
      case IdlPackage.FIXED_DEFINITION: return (EObject)createFixedDefinition();
      case IdlPackage.TEMPLATE_MODULE_INST: return (EObject)createTemplateModuleInst();
      case IdlPackage.ACTUAL_PARAMETER: return (EObject)createActualParameter();
      case IdlPackage.TEMPLATE_MODULE_REF: return (EObject)createTemplateModuleRef();
      case IdlPackage.IDL_COMMENT: return (EObject)createIDLComment();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case IdlPackage.PARAM_DIRECTION:
        return createParamDirectionFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case IdlPackage.PARAM_DIRECTION:
        return convertParamDirectionToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Specification createSpecification()
  {
    SpecificationImpl specification = new SpecificationImpl();
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc createPreproc()
  {
    PreprocImpl preproc = new PreprocImpl();
    return preproc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Include createPreproc_Include()
  {
    Preproc_IncludeImpl preproc_Include = new Preproc_IncludeImpl();
    return preproc_Include;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FileName createFileName()
  {
    FileNameImpl fileName = new FileNameImpl();
    return fileName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Ifdef createPreproc_Ifdef()
  {
    Preproc_IfdefImpl preproc_Ifdef = new Preproc_IfdefImpl();
    return preproc_Ifdef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Ifndef createPreproc_Ifndef()
  {
    Preproc_IfndefImpl preproc_Ifndef = new Preproc_IfndefImpl();
    return preproc_Ifndef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Undef createPreproc_Undef()
  {
    Preproc_UndefImpl preproc_Undef = new Preproc_UndefImpl();
    return preproc_Undef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_If createPreproc_If()
  {
    Preproc_IfImpl preproc_If = new Preproc_IfImpl();
    return preproc_If;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_If_Compare createPreproc_If_Compare()
  {
    Preproc_If_CompareImpl preproc_If_Compare = new Preproc_If_CompareImpl();
    return preproc_If_Compare;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_If_Val createPreproc_If_Val()
  {
    Preproc_If_ValImpl preproc_If_Val = new Preproc_If_ValImpl();
    return preproc_If_Val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Else createPreproc_Else()
  {
    Preproc_ElseImpl preproc_Else = new Preproc_ElseImpl();
    return preproc_Else;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Error createPreproc_Error()
  {
    Preproc_ErrorImpl preproc_Error = new Preproc_ErrorImpl();
    return preproc_Error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Define createPreproc_Define()
  {
    Preproc_DefineImpl preproc_Define = new Preproc_DefineImpl();
    return preproc_Define;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Endif createPreproc_Endif()
  {
    Preproc_EndifImpl preproc_Endif = new Preproc_EndifImpl();
    return preproc_Endif;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma createPreproc_Pragma()
  {
    Preproc_PragmaImpl preproc_Pragma = new Preproc_PragmaImpl();
    return preproc_Pragma;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Prefix createPreproc_Pragma_Prefix()
  {
    Preproc_Pragma_PrefixImpl preproc_Pragma_Prefix = new Preproc_Pragma_PrefixImpl();
    return preproc_Pragma_Prefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Conn_Type createPreproc_Pragma_Conn_Type()
  {
    Preproc_Pragma_Conn_TypeImpl preproc_Pragma_Conn_Type = new Preproc_Pragma_Conn_TypeImpl();
    return preproc_Pragma_Conn_Type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Ciao_Lem createPreproc_Pragma_Ciao_Lem()
  {
    Preproc_Pragma_Ciao_LemImpl preproc_Pragma_Ciao_Lem = new Preproc_Pragma_Ciao_LemImpl();
    return preproc_Pragma_Ciao_Lem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Ciao_Ami4ccm_Interface createPreproc_Pragma_Ciao_Ami4ccm_Interface()
  {
    Preproc_Pragma_Ciao_Ami4ccm_InterfaceImpl preproc_Pragma_Ciao_Ami4ccm_Interface = new Preproc_Pragma_Ciao_Ami4ccm_InterfaceImpl();
    return preproc_Pragma_Ciao_Ami4ccm_Interface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Ciao_Ami4ccm_Receptacle createPreproc_Pragma_Ciao_Ami4ccm_Receptacle()
  {
    Preproc_Pragma_Ciao_Ami4ccm_ReceptacleImpl preproc_Pragma_Ciao_Ami4ccm_Receptacle = new Preproc_Pragma_Ciao_Ami4ccm_ReceptacleImpl();
    return preproc_Pragma_Ciao_Ami4ccm_Receptacle;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Ciao_Ami4ccm_Idl createPreproc_Pragma_Ciao_Ami4ccm_Idl()
  {
    Preproc_Pragma_Ciao_Ami4ccm_IdlImpl preproc_Pragma_Ciao_Ami4ccm_Idl = new Preproc_Pragma_Ciao_Ami4ccm_IdlImpl();
    return preproc_Pragma_Ciao_Ami4ccm_Idl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Ndds createPreproc_Pragma_Ndds()
  {
    Preproc_Pragma_NddsImpl preproc_Pragma_Ndds = new Preproc_Pragma_NddsImpl();
    return preproc_Pragma_Ndds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Component createPreproc_Pragma_Component()
  {
    Preproc_Pragma_ComponentImpl preproc_Pragma_Component = new Preproc_Pragma_ComponentImpl();
    return preproc_Pragma_Component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Home createPreproc_Pragma_Home()
  {
    Preproc_Pragma_HomeImpl preproc_Pragma_Home = new Preproc_Pragma_HomeImpl();
    return preproc_Pragma_Home;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_DDS4CCM_Impl createPreproc_Pragma_DDS4CCM_Impl()
  {
    Preproc_Pragma_DDS4CCM_ImplImpl preproc_Pragma_DDS4CCM_Impl = new Preproc_Pragma_DDS4CCM_ImplImpl();
    return preproc_Pragma_DDS4CCM_Impl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preproc_Pragma_Misc createPreproc_Pragma_Misc()
  {
    Preproc_Pragma_MiscImpl preproc_Pragma_Misc = new Preproc_Pragma_MiscImpl();
    return preproc_Pragma_Misc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File_Marker createFile_Marker()
  {
    File_MarkerImpl file_Marker = new File_MarkerImpl();
    return file_Marker;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Excluded_File_Marker createExcluded_File_Marker()
  {
    Excluded_File_MarkerImpl excluded_File_Marker = new Excluded_File_MarkerImpl();
    return excluded_File_Marker;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import_decl createImport_decl()
  {
    Import_declImpl import_decl = new Import_declImpl();
    return import_decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.zeligsoft.domain.omg.corba.dsl.idl.Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface_or_Forward_Decl createInterface_or_Forward_Decl()
  {
    Interface_or_Forward_DeclImpl interface_or_Forward_Decl = new Interface_or_Forward_DeclImpl();
    return interface_or_Forward_Decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface_decl createInterface_decl()
  {
    Interface_declImpl interface_decl = new Interface_declImpl();
    return interface_decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Forward_decl createForward_decl()
  {
    Forward_declImpl forward_decl = new Forward_declImpl();
    return forward_decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interface_header createInterface_header()
  {
    Interface_headerImpl interface_header = new Interface_headerImpl();
    return interface_header;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceBody createInterfaceBody()
  {
    InterfaceBodyImpl interfaceBody = new InterfaceBodyImpl();
    return interfaceBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Export createExport()
  {
    ExportImpl export = new ExportImpl();
    return export;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttrDecl createAttrDecl()
  {
    AttrDeclImpl attrDecl = new AttrDeclImpl();
    return attrDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttrSpec createAttrSpec()
  {
    AttrSpecImpl attrSpec = new AttrSpecImpl();
    return attrSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReadOnlyAttrSpec createReadOnlyAttrSpec()
  {
    ReadOnlyAttrSpecImpl readOnlyAttrSpec = new ReadOnlyAttrSpecImpl();
    return readOnlyAttrSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttrRaisesExpr createAttrRaisesExpr()
  {
    AttrRaisesExprImpl attrRaisesExpr = new AttrRaisesExprImpl();
    return attrRaisesExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExceptionList createExceptionList()
  {
    ExceptionListImpl exceptionList = new ExceptionListImpl();
    return exceptionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OpDecl createOpDecl()
  {
    OpDeclImpl opDecl = new OpDeclImpl();
    return opDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OpTypeDecl createOpTypeDecl()
  {
    OpTypeDeclImpl opTypeDecl = new OpTypeDeclImpl();
    return opTypeDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDecls createParameterDecls()
  {
    ParameterDeclsImpl parameterDecls = new ParameterDeclsImpl();
    return parameterDecls;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParamDcl createParamDcl()
  {
    ParamDclImpl paramDcl = new ParamDclImpl();
    return paramDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextExpr createContextExpr()
  {
    ContextExprImpl contextExpr = new ContextExprImpl();
    return contextExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParamTypeSpec createParamTypeSpec()
  {
    ParamTypeSpecImpl paramTypeSpec = new ParamTypeSpecImpl();
    return paramTypeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScopedName createScopedName()
  {
    ScopedNameImpl scopedName = new ScopedNameImpl();
    return scopedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseTypeSpec createBaseTypeSpec()
  {
    BaseTypeSpecImpl baseTypeSpec = new BaseTypeSpecImpl();
    return baseTypeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FloatingPtType createFloatingPtType()
  {
    FloatingPtTypeImpl floatingPtType = new FloatingPtTypeImpl();
    return floatingPtType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FloatType createFloatType()
  {
    FloatTypeImpl floatType = new FloatTypeImpl();
    return floatType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleType createDoubleType()
  {
    DoubleTypeImpl doubleType = new DoubleTypeImpl();
    return doubleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongDoubleType createLongDoubleType()
  {
    LongDoubleTypeImpl longDoubleType = new LongDoubleTypeImpl();
    return longDoubleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerType createIntegerType()
  {
    IntegerTypeImpl integerType = new IntegerTypeImpl();
    return integerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedInt createSignedInt()
  {
    SignedIntImpl signedInt = new SignedIntImpl();
    return signedInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedShortInt createSignedShortInt()
  {
    SignedShortIntImpl signedShortInt = new SignedShortIntImpl();
    return signedShortInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedLongInt createSignedLongInt()
  {
    SignedLongIntImpl signedLongInt = new SignedLongIntImpl();
    return signedLongInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedLongLongInt createSignedLongLongInt()
  {
    SignedLongLongIntImpl signedLongLongInt = new SignedLongLongIntImpl();
    return signedLongLongInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnsignedInt createUnsignedInt()
  {
    UnsignedIntImpl unsignedInt = new UnsignedIntImpl();
    return unsignedInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnsignedShortInt createUnsignedShortInt()
  {
    UnsignedShortIntImpl unsignedShortInt = new UnsignedShortIntImpl();
    return unsignedShortInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnsignedLongInt createUnsignedLongInt()
  {
    UnsignedLongIntImpl unsignedLongInt = new UnsignedLongIntImpl();
    return unsignedLongInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnsignedLongLongInt createUnsignedLongLongInt()
  {
    UnsignedLongLongIntImpl unsignedLongLongInt = new UnsignedLongLongIntImpl();
    return unsignedLongLongInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CharType createCharType()
  {
    CharTypeImpl charType = new CharTypeImpl();
    return charType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WideCharType createWideCharType()
  {
    WideCharTypeImpl wideCharType = new WideCharTypeImpl();
    return wideCharType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanType createBooleanType()
  {
    BooleanTypeImpl booleanType = new BooleanTypeImpl();
    return booleanType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OctetType createOctetType()
  {
    OctetTypeImpl octetType = new OctetTypeImpl();
    return octetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnyType createAnyType()
  {
    AnyTypeImpl anyType = new AnyTypeImpl();
    return anyType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectType createObjectType()
  {
    ObjectTypeImpl objectType = new ObjectTypeImpl();
    return objectType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueBaseType createValueBaseType()
  {
    ValueBaseTypeImpl valueBaseType = new ValueBaseTypeImpl();
    return valueBaseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringType createStringType()
  {
    StringTypeImpl stringType = new StringTypeImpl();
    return stringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WideStringType createWideStringType()
  {
    WideStringTypeImpl wideStringType = new WideStringTypeImpl();
    return wideStringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExceptDecl createExceptDecl()
  {
    ExceptDeclImpl exceptDecl = new ExceptDeclImpl();
    return exceptDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Member createMember()
  {
    MemberImpl member = new MemberImpl();
    return member;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declarator createDeclarator()
  {
    DeclaratorImpl declarator = new DeclaratorImpl();
    return declarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleDeclarator createSimpleDeclarator()
  {
    SimpleDeclaratorImpl simpleDeclarator = new SimpleDeclaratorImpl();
    return simpleDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexDeclarator createComplexDeclarator()
  {
    ComplexDeclaratorImpl complexDeclarator = new ComplexDeclaratorImpl();
    return complexDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayDeclarator createArrayDeclarator()
  {
    ArrayDeclaratorImpl arrayDeclarator = new ArrayDeclaratorImpl();
    return arrayDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructType createStructType()
  {
    StructTypeImpl structType = new StructTypeImpl();
    return structType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDecl createTypeDecl()
  {
    TypeDeclImpl typeDecl = new TypeDeclImpl();
    return typeDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclarator createTypeDeclarator()
  {
    TypeDeclaratorImpl typeDeclarator = new TypeDeclaratorImpl();
    return typeDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSpec createTypeSpec()
  {
    TypeSpecImpl typeSpec = new TypeSpecImpl();
    return typeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleTypeSpec createSimpleTypeSpec()
  {
    SimpleTypeSpecImpl simpleTypeSpec = new SimpleTypeSpecImpl();
    return simpleTypeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateTypeSpec createTemplateTypeSpec()
  {
    TemplateTypeSpecImpl templateTypeSpec = new TemplateTypeSpecImpl();
    return templateTypeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstrTypeSpec createConstrTypeSpec()
  {
    ConstrTypeSpecImpl constrTypeSpec = new ConstrTypeSpecImpl();
    return constrTypeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnionType createUnionType()
  {
    UnionTypeImpl unionType = new UnionTypeImpl();
    return unionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchTypeSpec createSwitchTypeSpec()
  {
    SwitchTypeSpecImpl switchTypeSpec = new SwitchTypeSpecImpl();
    return switchTypeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchBody createSwitchBody()
  {
    SwitchBodyImpl switchBody = new SwitchBodyImpl();
    return switchBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Case createCase()
  {
    CaseImpl case_ = new CaseImpl();
    return case_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseLabel createCaseLabel()
  {
    CaseLabelImpl caseLabel = new CaseLabelImpl();
    return caseLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementSpec createElementSpec()
  {
    ElementSpecImpl elementSpec = new ElementSpecImpl();
    return elementSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumType createEnumType()
  {
    EnumTypeImpl enumType = new EnumTypeImpl();
    return enumType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceType createSequenceType()
  {
    SequenceTypeImpl sequenceType = new SequenceTypeImpl();
    return sequenceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NativeType createNativeType()
  {
    NativeTypeImpl nativeType = new NativeTypeImpl();
    return nativeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixedPtType createFixedPtType()
  {
    FixedPtTypeImpl fixedPtType = new FixedPtTypeImpl();
    return fixedPtType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstrForwardDecl createConstrForwardDecl()
  {
    ConstrForwardDeclImpl constrForwardDecl = new ConstrForwardDeclImpl();
    return constrForwardDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructForwardDecl createStructForwardDecl()
  {
    StructForwardDeclImpl structForwardDecl = new StructForwardDeclImpl();
    return structForwardDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnionForwardDecl createUnionForwardDecl()
  {
    UnionForwardDeclImpl unionForwardDecl = new UnionForwardDeclImpl();
    return unionForwardDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PositiveIntConst createPositiveIntConst()
  {
    PositiveIntConstImpl positiveIntConst = new PositiveIntConstImpl();
    return positiveIntConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstDecl createConstDecl()
  {
    ConstDeclImpl constDecl = new ConstDeclImpl();
    return constDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstType createConstType()
  {
    ConstTypeImpl constType = new ConstTypeImpl();
    return constType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixedPtConstType createFixedPtConstType()
  {
    FixedPtConstTypeImpl fixedPtConstType = new FixedPtConstTypeImpl();
    return fixedPtConstType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstExp createConstExp()
  {
    ConstExpImpl constExp = new ConstExpImpl();
    return constExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpr createOrExpr()
  {
    OrExprImpl orExpr = new OrExprImpl();
    return orExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XOrExpr createXOrExpr()
  {
    XOrExprImpl xOrExpr = new XOrExprImpl();
    return xOrExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpr createAndExpr()
  {
    AndExprImpl andExpr = new AndExprImpl();
    return andExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpr createShiftExpr()
  {
    ShiftExprImpl shiftExpr = new ShiftExprImpl();
    return shiftExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AddExpr createAddExpr()
  {
    AddExprImpl addExpr = new AddExprImpl();
    return addExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultExpr createMultExpr()
  {
    MultExprImpl multExpr = new MultExprImpl();
    return multExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpr createUnaryExpr()
  {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpr createPrimaryExpr()
  {
    PrimaryExprImpl primaryExpr = new PrimaryExprImpl();
    return primaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentDecl createComponentDecl()
  {
    ComponentDeclImpl componentDecl = new ComponentDeclImpl();
    return componentDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentExport createComponentExport()
  {
    ComponentExportImpl componentExport = new ComponentExportImpl();
    return componentExport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProvidesDcl createProvidesDcl()
  {
    ProvidesDclImpl providesDcl = new ProvidesDclImpl();
    return providesDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UsesDcl createUsesDcl()
  {
    UsesDclImpl usesDcl = new UsesDclImpl();
    return usesDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PublishesDcl createPublishesDcl()
  {
    PublishesDclImpl publishesDcl = new PublishesDclImpl();
    return publishesDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmitDcl createEmitDcl()
  {
    EmitDclImpl emitDcl = new EmitDclImpl();
    return emitDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConsumesDcl createConsumesDcl()
  {
    ConsumesDclImpl consumesDcl = new ConsumesDclImpl();
    return consumesDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentForwardDecl createComponentForwardDecl()
  {
    ComponentForwardDeclImpl componentForwardDecl = new ComponentForwardDeclImpl();
    return componentForwardDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HomeDecl createHomeDecl()
  {
    HomeDeclImpl homeDecl = new HomeDeclImpl();
    return homeDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryKeySpec createPrimaryKeySpec()
  {
    PrimaryKeySpecImpl primaryKeySpec = new PrimaryKeySpecImpl();
    return primaryKeySpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HomeExport createHomeExport()
  {
    HomeExportImpl homeExport = new HomeExportImpl();
    return homeExport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryDcl createFactoryDcl()
  {
    FactoryDclImpl factoryDcl = new FactoryDclImpl();
    return factoryDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FinderDcl createFinderDcl()
  {
    FinderDclImpl finderDcl = new FinderDclImpl();
    return finderDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventDcl createEventDcl()
  {
    EventDclImpl eventDcl = new EventDclImpl();
    return eventDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMember createStateMember()
  {
    StateMemberImpl stateMember = new StateMemberImpl();
    return stateMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventForwardDcl createEventForwardDcl()
  {
    EventForwardDclImpl eventForwardDcl = new EventForwardDclImpl();
    return eventForwardDcl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortTypeDecl createPortTypeDecl()
  {
    PortTypeDeclImpl portTypeDecl = new PortTypeDeclImpl();
    return portTypeDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortExport createPortExport()
  {
    PortExportImpl portExport = new PortExportImpl();
    return portExport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortDecl createPortDecl()
  {
    PortDeclImpl portDecl = new PortDeclImpl();
    return portDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connector createConnector()
  {
    ConnectorImpl connector = new ConnectorImpl();
    return connector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectorHeader createConnectorHeader()
  {
    ConnectorHeaderImpl connectorHeader = new ConnectorHeaderImpl();
    return connectorHeader;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectorExport createConnectorExport()
  {
    ConnectorExportImpl connectorExport = new ConnectorExportImpl();
    return connectorExport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateModule createTemplateModule()
  {
    TemplateModuleImpl templateModule = new TemplateModuleImpl();
    return templateModule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameter createFormalParameter()
  {
    FormalParameterImpl formalParameter = new FormalParameterImpl();
    return formalParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalParameterType createFormalParameterType()
  {
    FormalParameterTypeImpl formalParameterType = new FormalParameterTypeImpl();
    return formalParameterType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypenameParamType createTypenameParamType()
  {
    TypenameParamTypeImpl typenameParamType = new TypenameParamTypeImpl();
    return typenameParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceParamType createInterfaceParamType()
  {
    InterfaceParamTypeImpl interfaceParamType = new InterfaceParamTypeImpl();
    return interfaceParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValuetypeParamType createValuetypeParamType()
  {
    ValuetypeParamTypeImpl valuetypeParamType = new ValuetypeParamTypeImpl();
    return valuetypeParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventParamType createEventParamType()
  {
    EventParamTypeImpl eventParamType = new EventParamTypeImpl();
    return eventParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructParamType createStructParamType()
  {
    StructParamTypeImpl structParamType = new StructParamTypeImpl();
    return structParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnionParamType createUnionParamType()
  {
    UnionParamTypeImpl unionParamType = new UnionParamTypeImpl();
    return unionParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExceptionParamType createExceptionParamType()
  {
    ExceptionParamTypeImpl exceptionParamType = new ExceptionParamTypeImpl();
    return exceptionParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumParamType createEnumParamType()
  {
    EnumParamTypeImpl enumParamType = new EnumParamTypeImpl();
    return enumParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceParamType createSequenceParamType()
  {
    SequenceParamTypeImpl sequenceParamType = new SequenceParamTypeImpl();
    return sequenceParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstParamType createConstParamType()
  {
    ConstParamTypeImpl constParamType = new ConstParamTypeImpl();
    return constParamType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateDefinition createTemplateDefinition()
  {
    TemplateDefinitionImpl templateDefinition = new TemplateDefinitionImpl();
    return templateDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixedModule createFixedModule()
  {
    FixedModuleImpl fixedModule = new FixedModuleImpl();
    return fixedModule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixedDefinition createFixedDefinition()
  {
    FixedDefinitionImpl fixedDefinition = new FixedDefinitionImpl();
    return fixedDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateModuleInst createTemplateModuleInst()
  {
    TemplateModuleInstImpl templateModuleInst = new TemplateModuleInstImpl();
    return templateModuleInst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualParameter createActualParameter()
  {
    ActualParameterImpl actualParameter = new ActualParameterImpl();
    return actualParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateModuleRef createTemplateModuleRef()
  {
    TemplateModuleRefImpl templateModuleRef = new TemplateModuleRefImpl();
    return templateModuleRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IDLComment createIDLComment()
  {
    IDLCommentImpl idlComment = new IDLCommentImpl();
    return idlComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParamDirection createParamDirectionFromString(EDataType eDataType, String initialValue)
  {
    ParamDirection result = ParamDirection.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertParamDirectionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdlPackage getIdlPackage()
  {
    return (IdlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IdlPackage getPackage()
  {
    return IdlPackage.eINSTANCE;
  }

} //IdlFactoryImpl
