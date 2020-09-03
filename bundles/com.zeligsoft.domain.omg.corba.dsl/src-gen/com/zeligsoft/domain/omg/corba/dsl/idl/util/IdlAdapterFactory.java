/**
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.util;

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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage
 * @generated
 */
public class IdlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static IdlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = IdlPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IdlSwitch<Adapter> modelSwitch =
    new IdlSwitch<Adapter>()
    {
      @Override
      public Adapter caseSpecification(Specification object)
      {
        return createSpecificationAdapter();
      }
      @Override
      public Adapter casePreproc(Preproc object)
      {
        return createPreprocAdapter();
      }
      @Override
      public Adapter casePreproc_Include(Preproc_Include object)
      {
        return createPreproc_IncludeAdapter();
      }
      @Override
      public Adapter caseFileName(FileName object)
      {
        return createFileNameAdapter();
      }
      @Override
      public Adapter casePreproc_Ifdef(Preproc_Ifdef object)
      {
        return createPreproc_IfdefAdapter();
      }
      @Override
      public Adapter casePreproc_Ifndef(Preproc_Ifndef object)
      {
        return createPreproc_IfndefAdapter();
      }
      @Override
      public Adapter casePreproc_Undef(Preproc_Undef object)
      {
        return createPreproc_UndefAdapter();
      }
      @Override
      public Adapter casePreproc_If(Preproc_If object)
      {
        return createPreproc_IfAdapter();
      }
      @Override
      public Adapter casePreproc_If_Compare(Preproc_If_Compare object)
      {
        return createPreproc_If_CompareAdapter();
      }
      @Override
      public Adapter casePreproc_If_Val(Preproc_If_Val object)
      {
        return createPreproc_If_ValAdapter();
      }
      @Override
      public Adapter casePreproc_Else(Preproc_Else object)
      {
        return createPreproc_ElseAdapter();
      }
      @Override
      public Adapter casePreproc_Error(Preproc_Error object)
      {
        return createPreproc_ErrorAdapter();
      }
      @Override
      public Adapter casePreproc_Define(Preproc_Define object)
      {
        return createPreproc_DefineAdapter();
      }
      @Override
      public Adapter casePreproc_Endif(Preproc_Endif object)
      {
        return createPreproc_EndifAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma(Preproc_Pragma object)
      {
        return createPreproc_PragmaAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Prefix(Preproc_Pragma_Prefix object)
      {
        return createPreproc_Pragma_PrefixAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Conn_Type(Preproc_Pragma_Conn_Type object)
      {
        return createPreproc_Pragma_Conn_TypeAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Ciao_Lem(Preproc_Pragma_Ciao_Lem object)
      {
        return createPreproc_Pragma_Ciao_LemAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Ciao_Ami4ccm_Interface(Preproc_Pragma_Ciao_Ami4ccm_Interface object)
      {
        return createPreproc_Pragma_Ciao_Ami4ccm_InterfaceAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Ciao_Ami4ccm_Receptacle(Preproc_Pragma_Ciao_Ami4ccm_Receptacle object)
      {
        return createPreproc_Pragma_Ciao_Ami4ccm_ReceptacleAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Ciao_Ami4ccm_Idl(Preproc_Pragma_Ciao_Ami4ccm_Idl object)
      {
        return createPreproc_Pragma_Ciao_Ami4ccm_IdlAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Ndds(Preproc_Pragma_Ndds object)
      {
        return createPreproc_Pragma_NddsAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Component(Preproc_Pragma_Component object)
      {
        return createPreproc_Pragma_ComponentAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Home(Preproc_Pragma_Home object)
      {
        return createPreproc_Pragma_HomeAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_DDS4CCM_Impl(Preproc_Pragma_DDS4CCM_Impl object)
      {
        return createPreproc_Pragma_DDS4CCM_ImplAdapter();
      }
      @Override
      public Adapter casePreproc_Pragma_Misc(Preproc_Pragma_Misc object)
      {
        return createPreproc_Pragma_MiscAdapter();
      }
      @Override
      public Adapter caseFile_Marker(File_Marker object)
      {
        return createFile_MarkerAdapter();
      }
      @Override
      public Adapter caseExcluded_File_Marker(Excluded_File_Marker object)
      {
        return createExcluded_File_MarkerAdapter();
      }
      @Override
      public Adapter caseImport_decl(Import_decl object)
      {
        return createImport_declAdapter();
      }
      @Override
      public Adapter caseDefinition(Definition object)
      {
        return createDefinitionAdapter();
      }
      @Override
      public Adapter caseModule(com.zeligsoft.domain.omg.corba.dsl.idl.Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseInterface_or_Forward_Decl(Interface_or_Forward_Decl object)
      {
        return createInterface_or_Forward_DeclAdapter();
      }
      @Override
      public Adapter caseInterface_decl(Interface_decl object)
      {
        return createInterface_declAdapter();
      }
      @Override
      public Adapter caseForward_decl(Forward_decl object)
      {
        return createForward_declAdapter();
      }
      @Override
      public Adapter caseInterface_header(Interface_header object)
      {
        return createInterface_headerAdapter();
      }
      @Override
      public Adapter caseInterfaceBody(InterfaceBody object)
      {
        return createInterfaceBodyAdapter();
      }
      @Override
      public Adapter caseExport(Export object)
      {
        return createExportAdapter();
      }
      @Override
      public Adapter caseAttrDecl(AttrDecl object)
      {
        return createAttrDeclAdapter();
      }
      @Override
      public Adapter caseAttrSpec(AttrSpec object)
      {
        return createAttrSpecAdapter();
      }
      @Override
      public Adapter caseReadOnlyAttrSpec(ReadOnlyAttrSpec object)
      {
        return createReadOnlyAttrSpecAdapter();
      }
      @Override
      public Adapter caseAttrRaisesExpr(AttrRaisesExpr object)
      {
        return createAttrRaisesExprAdapter();
      }
      @Override
      public Adapter caseExceptionList(ExceptionList object)
      {
        return createExceptionListAdapter();
      }
      @Override
      public Adapter caseOpDecl(OpDecl object)
      {
        return createOpDeclAdapter();
      }
      @Override
      public Adapter caseOpTypeDecl(OpTypeDecl object)
      {
        return createOpTypeDeclAdapter();
      }
      @Override
      public Adapter caseParameterDecls(ParameterDecls object)
      {
        return createParameterDeclsAdapter();
      }
      @Override
      public Adapter caseParamDcl(ParamDcl object)
      {
        return createParamDclAdapter();
      }
      @Override
      public Adapter caseContextExpr(ContextExpr object)
      {
        return createContextExprAdapter();
      }
      @Override
      public Adapter caseParamTypeSpec(ParamTypeSpec object)
      {
        return createParamTypeSpecAdapter();
      }
      @Override
      public Adapter caseScopedName(ScopedName object)
      {
        return createScopedNameAdapter();
      }
      @Override
      public Adapter caseBaseTypeSpec(BaseTypeSpec object)
      {
        return createBaseTypeSpecAdapter();
      }
      @Override
      public Adapter caseFloatingPtType(FloatingPtType object)
      {
        return createFloatingPtTypeAdapter();
      }
      @Override
      public Adapter caseFloatType(FloatType object)
      {
        return createFloatTypeAdapter();
      }
      @Override
      public Adapter caseDoubleType(DoubleType object)
      {
        return createDoubleTypeAdapter();
      }
      @Override
      public Adapter caseLongDoubleType(LongDoubleType object)
      {
        return createLongDoubleTypeAdapter();
      }
      @Override
      public Adapter caseIntegerType(IntegerType object)
      {
        return createIntegerTypeAdapter();
      }
      @Override
      public Adapter caseSignedInt(SignedInt object)
      {
        return createSignedIntAdapter();
      }
      @Override
      public Adapter caseSignedShortInt(SignedShortInt object)
      {
        return createSignedShortIntAdapter();
      }
      @Override
      public Adapter caseSignedLongInt(SignedLongInt object)
      {
        return createSignedLongIntAdapter();
      }
      @Override
      public Adapter caseSignedLongLongInt(SignedLongLongInt object)
      {
        return createSignedLongLongIntAdapter();
      }
      @Override
      public Adapter caseUnsignedInt(UnsignedInt object)
      {
        return createUnsignedIntAdapter();
      }
      @Override
      public Adapter caseUnsignedShortInt(UnsignedShortInt object)
      {
        return createUnsignedShortIntAdapter();
      }
      @Override
      public Adapter caseUnsignedLongInt(UnsignedLongInt object)
      {
        return createUnsignedLongIntAdapter();
      }
      @Override
      public Adapter caseUnsignedLongLongInt(UnsignedLongLongInt object)
      {
        return createUnsignedLongLongIntAdapter();
      }
      @Override
      public Adapter caseCharType(CharType object)
      {
        return createCharTypeAdapter();
      }
      @Override
      public Adapter caseWideCharType(WideCharType object)
      {
        return createWideCharTypeAdapter();
      }
      @Override
      public Adapter caseBooleanType(BooleanType object)
      {
        return createBooleanTypeAdapter();
      }
      @Override
      public Adapter caseOctetType(OctetType object)
      {
        return createOctetTypeAdapter();
      }
      @Override
      public Adapter caseAnyType(AnyType object)
      {
        return createAnyTypeAdapter();
      }
      @Override
      public Adapter caseObjectType(ObjectType object)
      {
        return createObjectTypeAdapter();
      }
      @Override
      public Adapter caseValueBaseType(ValueBaseType object)
      {
        return createValueBaseTypeAdapter();
      }
      @Override
      public Adapter caseStringType(StringType object)
      {
        return createStringTypeAdapter();
      }
      @Override
      public Adapter caseWideStringType(WideStringType object)
      {
        return createWideStringTypeAdapter();
      }
      @Override
      public Adapter caseExceptDecl(ExceptDecl object)
      {
        return createExceptDeclAdapter();
      }
      @Override
      public Adapter caseMember(Member object)
      {
        return createMemberAdapter();
      }
      @Override
      public Adapter caseDeclarator(Declarator object)
      {
        return createDeclaratorAdapter();
      }
      @Override
      public Adapter caseSimpleDeclarator(SimpleDeclarator object)
      {
        return createSimpleDeclaratorAdapter();
      }
      @Override
      public Adapter caseComplexDeclarator(ComplexDeclarator object)
      {
        return createComplexDeclaratorAdapter();
      }
      @Override
      public Adapter caseArrayDeclarator(ArrayDeclarator object)
      {
        return createArrayDeclaratorAdapter();
      }
      @Override
      public Adapter caseStructType(StructType object)
      {
        return createStructTypeAdapter();
      }
      @Override
      public Adapter caseTypeDecl(TypeDecl object)
      {
        return createTypeDeclAdapter();
      }
      @Override
      public Adapter caseTypeDeclarator(TypeDeclarator object)
      {
        return createTypeDeclaratorAdapter();
      }
      @Override
      public Adapter caseTypeSpec(TypeSpec object)
      {
        return createTypeSpecAdapter();
      }
      @Override
      public Adapter caseSimpleTypeSpec(SimpleTypeSpec object)
      {
        return createSimpleTypeSpecAdapter();
      }
      @Override
      public Adapter caseTemplateTypeSpec(TemplateTypeSpec object)
      {
        return createTemplateTypeSpecAdapter();
      }
      @Override
      public Adapter caseConstrTypeSpec(ConstrTypeSpec object)
      {
        return createConstrTypeSpecAdapter();
      }
      @Override
      public Adapter caseUnionType(UnionType object)
      {
        return createUnionTypeAdapter();
      }
      @Override
      public Adapter caseSwitchTypeSpec(SwitchTypeSpec object)
      {
        return createSwitchTypeSpecAdapter();
      }
      @Override
      public Adapter caseSwitchBody(SwitchBody object)
      {
        return createSwitchBodyAdapter();
      }
      @Override
      public Adapter caseCase(Case object)
      {
        return createCaseAdapter();
      }
      @Override
      public Adapter caseCaseLabel(CaseLabel object)
      {
        return createCaseLabelAdapter();
      }
      @Override
      public Adapter caseElementSpec(ElementSpec object)
      {
        return createElementSpecAdapter();
      }
      @Override
      public Adapter caseEnumType(EnumType object)
      {
        return createEnumTypeAdapter();
      }
      @Override
      public Adapter caseSequenceType(SequenceType object)
      {
        return createSequenceTypeAdapter();
      }
      @Override
      public Adapter caseNativeType(NativeType object)
      {
        return createNativeTypeAdapter();
      }
      @Override
      public Adapter caseFixedPtType(FixedPtType object)
      {
        return createFixedPtTypeAdapter();
      }
      @Override
      public Adapter caseConstrForwardDecl(ConstrForwardDecl object)
      {
        return createConstrForwardDeclAdapter();
      }
      @Override
      public Adapter caseStructForwardDecl(StructForwardDecl object)
      {
        return createStructForwardDeclAdapter();
      }
      @Override
      public Adapter caseUnionForwardDecl(UnionForwardDecl object)
      {
        return createUnionForwardDeclAdapter();
      }
      @Override
      public Adapter casePositiveIntConst(PositiveIntConst object)
      {
        return createPositiveIntConstAdapter();
      }
      @Override
      public Adapter caseConstDecl(ConstDecl object)
      {
        return createConstDeclAdapter();
      }
      @Override
      public Adapter caseConstType(ConstType object)
      {
        return createConstTypeAdapter();
      }
      @Override
      public Adapter caseFixedPtConstType(FixedPtConstType object)
      {
        return createFixedPtConstTypeAdapter();
      }
      @Override
      public Adapter caseConstExp(ConstExp object)
      {
        return createConstExpAdapter();
      }
      @Override
      public Adapter caseOrExpr(OrExpr object)
      {
        return createOrExprAdapter();
      }
      @Override
      public Adapter caseXOrExpr(XOrExpr object)
      {
        return createXOrExprAdapter();
      }
      @Override
      public Adapter caseAndExpr(AndExpr object)
      {
        return createAndExprAdapter();
      }
      @Override
      public Adapter caseShiftExpr(ShiftExpr object)
      {
        return createShiftExprAdapter();
      }
      @Override
      public Adapter caseAddExpr(AddExpr object)
      {
        return createAddExprAdapter();
      }
      @Override
      public Adapter caseMultExpr(MultExpr object)
      {
        return createMultExprAdapter();
      }
      @Override
      public Adapter caseUnaryExpr(UnaryExpr object)
      {
        return createUnaryExprAdapter();
      }
      @Override
      public Adapter casePrimaryExpr(PrimaryExpr object)
      {
        return createPrimaryExprAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseComponentDecl(ComponentDecl object)
      {
        return createComponentDeclAdapter();
      }
      @Override
      public Adapter caseComponentExport(ComponentExport object)
      {
        return createComponentExportAdapter();
      }
      @Override
      public Adapter caseProvidesDcl(ProvidesDcl object)
      {
        return createProvidesDclAdapter();
      }
      @Override
      public Adapter caseUsesDcl(UsesDcl object)
      {
        return createUsesDclAdapter();
      }
      @Override
      public Adapter casePublishesDcl(PublishesDcl object)
      {
        return createPublishesDclAdapter();
      }
      @Override
      public Adapter caseEmitDcl(EmitDcl object)
      {
        return createEmitDclAdapter();
      }
      @Override
      public Adapter caseConsumesDcl(ConsumesDcl object)
      {
        return createConsumesDclAdapter();
      }
      @Override
      public Adapter caseComponentForwardDecl(ComponentForwardDecl object)
      {
        return createComponentForwardDeclAdapter();
      }
      @Override
      public Adapter caseHomeDecl(HomeDecl object)
      {
        return createHomeDeclAdapter();
      }
      @Override
      public Adapter casePrimaryKeySpec(PrimaryKeySpec object)
      {
        return createPrimaryKeySpecAdapter();
      }
      @Override
      public Adapter caseHomeExport(HomeExport object)
      {
        return createHomeExportAdapter();
      }
      @Override
      public Adapter caseFactoryDcl(FactoryDcl object)
      {
        return createFactoryDclAdapter();
      }
      @Override
      public Adapter caseFinderDcl(FinderDcl object)
      {
        return createFinderDclAdapter();
      }
      @Override
      public Adapter caseEvent(Event object)
      {
        return createEventAdapter();
      }
      @Override
      public Adapter caseEventDcl(EventDcl object)
      {
        return createEventDclAdapter();
      }
      @Override
      public Adapter caseStateMember(StateMember object)
      {
        return createStateMemberAdapter();
      }
      @Override
      public Adapter caseEventForwardDcl(EventForwardDcl object)
      {
        return createEventForwardDclAdapter();
      }
      @Override
      public Adapter casePortTypeDecl(PortTypeDecl object)
      {
        return createPortTypeDeclAdapter();
      }
      @Override
      public Adapter casePortExport(PortExport object)
      {
        return createPortExportAdapter();
      }
      @Override
      public Adapter casePortDecl(PortDecl object)
      {
        return createPortDeclAdapter();
      }
      @Override
      public Adapter caseConnector(Connector object)
      {
        return createConnectorAdapter();
      }
      @Override
      public Adapter caseConnectorHeader(ConnectorHeader object)
      {
        return createConnectorHeaderAdapter();
      }
      @Override
      public Adapter caseConnectorExport(ConnectorExport object)
      {
        return createConnectorExportAdapter();
      }
      @Override
      public Adapter caseTemplateModule(TemplateModule object)
      {
        return createTemplateModuleAdapter();
      }
      @Override
      public Adapter caseFormalParameter(FormalParameter object)
      {
        return createFormalParameterAdapter();
      }
      @Override
      public Adapter caseFormalParameterType(FormalParameterType object)
      {
        return createFormalParameterTypeAdapter();
      }
      @Override
      public Adapter caseTypenameParamType(TypenameParamType object)
      {
        return createTypenameParamTypeAdapter();
      }
      @Override
      public Adapter caseInterfaceParamType(InterfaceParamType object)
      {
        return createInterfaceParamTypeAdapter();
      }
      @Override
      public Adapter caseValuetypeParamType(ValuetypeParamType object)
      {
        return createValuetypeParamTypeAdapter();
      }
      @Override
      public Adapter caseEventParamType(EventParamType object)
      {
        return createEventParamTypeAdapter();
      }
      @Override
      public Adapter caseStructParamType(StructParamType object)
      {
        return createStructParamTypeAdapter();
      }
      @Override
      public Adapter caseUnionParamType(UnionParamType object)
      {
        return createUnionParamTypeAdapter();
      }
      @Override
      public Adapter caseExceptionParamType(ExceptionParamType object)
      {
        return createExceptionParamTypeAdapter();
      }
      @Override
      public Adapter caseEnumParamType(EnumParamType object)
      {
        return createEnumParamTypeAdapter();
      }
      @Override
      public Adapter caseSequenceParamType(SequenceParamType object)
      {
        return createSequenceParamTypeAdapter();
      }
      @Override
      public Adapter caseConstParamType(ConstParamType object)
      {
        return createConstParamTypeAdapter();
      }
      @Override
      public Adapter caseTemplateDefinition(TemplateDefinition object)
      {
        return createTemplateDefinitionAdapter();
      }
      @Override
      public Adapter caseFixedModule(FixedModule object)
      {
        return createFixedModuleAdapter();
      }
      @Override
      public Adapter caseFixedDefinition(FixedDefinition object)
      {
        return createFixedDefinitionAdapter();
      }
      @Override
      public Adapter caseTemplateModuleInst(TemplateModuleInst object)
      {
        return createTemplateModuleInstAdapter();
      }
      @Override
      public Adapter caseActualParameter(ActualParameter object)
      {
        return createActualParameterAdapter();
      }
      @Override
      public Adapter caseTemplateModuleRef(TemplateModuleRef object)
      {
        return createTemplateModuleRefAdapter();
      }
      @Override
      public Adapter caseIDLComment(IDLComment object)
      {
        return createIDLCommentAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Specification
   * @generated
   */
  public Adapter createSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc <em>Preproc</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc
   * @generated
   */
  public Adapter createPreprocAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include <em>Preproc Include</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include
   * @generated
   */
  public Adapter createPreproc_IncludeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FileName <em>File Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FileName
   * @generated
   */
  public Adapter createFileNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef <em>Preproc Ifdef</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifdef
   * @generated
   */
  public Adapter createPreproc_IfdefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef <em>Preproc Ifndef</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Ifndef
   * @generated
   */
  public Adapter createPreproc_IfndefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef <em>Preproc Undef</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Undef
   * @generated
   */
  public Adapter createPreproc_UndefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If <em>Preproc If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If
   * @generated
   */
  public Adapter createPreproc_IfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare <em>Preproc If Compare</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Compare
   * @generated
   */
  public Adapter createPreproc_If_CompareAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val <em>Preproc If Val</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_If_Val
   * @generated
   */
  public Adapter createPreproc_If_ValAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Else <em>Preproc Else</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Else
   * @generated
   */
  public Adapter createPreproc_ElseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error <em>Preproc Error</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Error
   * @generated
   */
  public Adapter createPreproc_ErrorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define <em>Preproc Define</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Define
   * @generated
   */
  public Adapter createPreproc_DefineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif <em>Preproc Endif</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Endif
   * @generated
   */
  public Adapter createPreproc_EndifAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma <em>Preproc Pragma</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma
   * @generated
   */
  public Adapter createPreproc_PragmaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix <em>Preproc Pragma Prefix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Prefix
   * @generated
   */
  public Adapter createPreproc_Pragma_PrefixAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type <em>Preproc Pragma Conn Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Conn_Type
   * @generated
   */
  public Adapter createPreproc_Pragma_Conn_TypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem <em>Preproc Pragma Ciao Lem</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Lem
   * @generated
   */
  public Adapter createPreproc_Pragma_Ciao_LemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface <em>Preproc Pragma Ciao Ami4ccm Interface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Interface
   * @generated
   */
  public Adapter createPreproc_Pragma_Ciao_Ami4ccm_InterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle <em>Preproc Pragma Ciao Ami4ccm Receptacle</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Receptacle
   * @generated
   */
  public Adapter createPreproc_Pragma_Ciao_Ami4ccm_ReceptacleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl <em>Preproc Pragma Ciao Ami4ccm Idl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ciao_Ami4ccm_Idl
   * @generated
   */
  public Adapter createPreproc_Pragma_Ciao_Ami4ccm_IdlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds <em>Preproc Pragma Ndds</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Ndds
   * @generated
   */
  public Adapter createPreproc_Pragma_NddsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component <em>Preproc Pragma Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Component
   * @generated
   */
  public Adapter createPreproc_Pragma_ComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home <em>Preproc Pragma Home</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Home
   * @generated
   */
  public Adapter createPreproc_Pragma_HomeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl <em>Preproc Pragma DDS4CCM Impl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_DDS4CCM_Impl
   * @generated
   */
  public Adapter createPreproc_Pragma_DDS4CCM_ImplAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Misc <em>Preproc Pragma Misc</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Pragma_Misc
   * @generated
   */
  public Adapter createPreproc_Pragma_MiscAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker <em>File Marker</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker
   * @generated
   */
  public Adapter createFile_MarkerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker <em>Excluded File Marker</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker
   * @generated
   */
  public Adapter createExcluded_File_MarkerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl <em>Import decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Import_decl
   * @generated
   */
  public Adapter createImport_declAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Definition
   * @generated
   */
  public Adapter createDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_or_Forward_Decl <em>Interface or Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_or_Forward_Decl
   * @generated
   */
  public Adapter createInterface_or_Forward_DeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl <em>Interface decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl
   * @generated
   */
  public Adapter createInterface_declAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl <em>Forward decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Forward_decl
   * @generated
   */
  public Adapter createForward_declAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header <em>Interface header</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Interface_header
   * @generated
   */
  public Adapter createInterface_headerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody <em>Interface Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceBody
   * @generated
   */
  public Adapter createInterfaceBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Export <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Export
   * @generated
   */
  public Adapter createExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl <em>Attr Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl
   * @generated
   */
  public Adapter createAttrDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec <em>Attr Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrSpec
   * @generated
   */
  public Adapter createAttrSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec <em>Read Only Attr Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ReadOnlyAttrSpec
   * @generated
   */
  public Adapter createReadOnlyAttrSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr <em>Attr Raises Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr
   * @generated
   */
  public Adapter createAttrRaisesExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList <em>Exception List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList
   * @generated
   */
  public Adapter createExceptionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl <em>Op Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpDecl
   * @generated
   */
  public Adapter createOpDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OpTypeDecl <em>Op Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OpTypeDecl
   * @generated
   */
  public Adapter createOpTypeDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls <em>Parameter Decls</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParameterDecls
   * @generated
   */
  public Adapter createParameterDeclsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl <em>Param Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl
   * @generated
   */
  public Adapter createParamDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr <em>Context Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ContextExpr
   * @generated
   */
  public Adapter createContextExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ParamTypeSpec <em>Param Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ParamTypeSpec
   * @generated
   */
  public Adapter createParamTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName <em>Scoped Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName
   * @generated
   */
  public Adapter createScopedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.BaseTypeSpec <em>Base Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.BaseTypeSpec
   * @generated
   */
  public Adapter createBaseTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FloatingPtType <em>Floating Pt Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FloatingPtType
   * @generated
   */
  public Adapter createFloatingPtTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FloatType <em>Float Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FloatType
   * @generated
   */
  public Adapter createFloatTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.DoubleType <em>Double Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.DoubleType
   * @generated
   */
  public Adapter createDoubleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.LongDoubleType <em>Long Double Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.LongDoubleType
   * @generated
   */
  public Adapter createLongDoubleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IntegerType
   * @generated
   */
  public Adapter createIntegerTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedInt <em>Signed Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedInt
   * @generated
   */
  public Adapter createSignedIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedShortInt <em>Signed Short Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedShortInt
   * @generated
   */
  public Adapter createSignedShortIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongInt <em>Signed Long Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongInt
   * @generated
   */
  public Adapter createSignedLongIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongLongInt <em>Signed Long Long Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SignedLongLongInt
   * @generated
   */
  public Adapter createSignedLongLongIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedInt <em>Unsigned Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedInt
   * @generated
   */
  public Adapter createUnsignedIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedShortInt <em>Unsigned Short Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedShortInt
   * @generated
   */
  public Adapter createUnsignedShortIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongInt <em>Unsigned Long Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongInt
   * @generated
   */
  public Adapter createUnsignedLongIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongLongInt <em>Unsigned Long Long Int</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnsignedLongLongInt
   * @generated
   */
  public Adapter createUnsignedLongLongIntAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CharType <em>Char Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CharType
   * @generated
   */
  public Adapter createCharTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideCharType <em>Wide Char Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.WideCharType
   * @generated
   */
  public Adapter createWideCharTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.BooleanType
   * @generated
   */
  public Adapter createBooleanTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OctetType <em>Octet Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OctetType
   * @generated
   */
  public Adapter createOctetTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AnyType <em>Any Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AnyType
   * @generated
   */
  public Adapter createAnyTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ObjectType <em>Object Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ObjectType
   * @generated
   */
  public Adapter createObjectTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ValueBaseType <em>Value Base Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ValueBaseType
   * @generated
   */
  public Adapter createValueBaseTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StringType
   * @generated
   */
  public Adapter createStringTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType <em>Wide String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType
   * @generated
   */
  public Adapter createWideStringTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl <em>Except Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptDecl
   * @generated
   */
  public Adapter createExceptDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Member <em>Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Member
   * @generated
   */
  public Adapter createMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Declarator
   * @generated
   */
  public Adapter createDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SimpleDeclarator <em>Simple Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SimpleDeclarator
   * @generated
   */
  public Adapter createSimpleDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComplexDeclarator <em>Complex Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComplexDeclarator
   * @generated
   */
  public Adapter createComplexDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator <em>Array Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator
   * @generated
   */
  public Adapter createArrayDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructType <em>Struct Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructType
   * @generated
   */
  public Adapter createStructTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDecl <em>Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDecl
   * @generated
   */
  public Adapter createTypeDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator <em>Type Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator
   * @generated
   */
  public Adapter createTypeDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec <em>Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec
   * @generated
   */
  public Adapter createTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SimpleTypeSpec <em>Simple Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SimpleTypeSpec
   * @generated
   */
  public Adapter createSimpleTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateTypeSpec <em>Template Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateTypeSpec
   * @generated
   */
  public Adapter createTemplateTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstrTypeSpec <em>Constr Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstrTypeSpec
   * @generated
   */
  public Adapter createConstrTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionType <em>Union Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionType
   * @generated
   */
  public Adapter createUnionTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SwitchTypeSpec <em>Switch Type Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SwitchTypeSpec
   * @generated
   */
  public Adapter createSwitchTypeSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody <em>Switch Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SwitchBody
   * @generated
   */
  public Adapter createSwitchBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Case <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Case
   * @generated
   */
  public Adapter createCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel <em>Case Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel
   * @generated
   */
  public Adapter createCaseLabelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec <em>Element Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec
   * @generated
   */
  public Adapter createElementSpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumType
   * @generated
   */
  public Adapter createEnumTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType <em>Sequence Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType
   * @generated
   */
  public Adapter createSequenceTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.NativeType <em>Native Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.NativeType
   * @generated
   */
  public Adapter createNativeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType <em>Fixed Pt Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtType
   * @generated
   */
  public Adapter createFixedPtTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl <em>Constr Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstrForwardDecl
   * @generated
   */
  public Adapter createConstrForwardDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructForwardDecl <em>Struct Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructForwardDecl
   * @generated
   */
  public Adapter createStructForwardDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionForwardDecl <em>Union Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionForwardDecl
   * @generated
   */
  public Adapter createUnionForwardDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst <em>Positive Int Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PositiveIntConst
   * @generated
   */
  public Adapter createPositiveIntConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl <em>Const Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstDecl
   * @generated
   */
  public Adapter createConstDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstType <em>Const Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstType
   * @generated
   */
  public Adapter createConstTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtConstType <em>Fixed Pt Const Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedPtConstType
   * @generated
   */
  public Adapter createFixedPtConstTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp <em>Const Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp
   * @generated
   */
  public Adapter createConstExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr
   * @generated
   */
  public Adapter createOrExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr <em>XOr Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr
   * @generated
   */
  public Adapter createXOrExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr
   * @generated
   */
  public Adapter createAndExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr <em>Shift Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr
   * @generated
   */
  public Adapter createShiftExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr <em>Add Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr
   * @generated
   */
  public Adapter createAddExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr <em>Mult Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr
   * @generated
   */
  public Adapter createMultExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr
   * @generated
   */
  public Adapter createUnaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr <em>Primary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr
   * @generated
   */
  public Adapter createPrimaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl <em>Component Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentDecl
   * @generated
   */
  public Adapter createComponentDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport <em>Component Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentExport
   * @generated
   */
  public Adapter createComponentExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl <em>Provides Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl
   * @generated
   */
  public Adapter createProvidesDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl <em>Uses Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl
   * @generated
   */
  public Adapter createUsesDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl <em>Publishes Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PublishesDcl
   * @generated
   */
  public Adapter createPublishesDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl <em>Emit Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EmitDcl
   * @generated
   */
  public Adapter createEmitDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl <em>Consumes Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConsumesDcl
   * @generated
   */
  public Adapter createConsumesDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl <em>Component Forward Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ComponentForwardDecl
   * @generated
   */
  public Adapter createComponentForwardDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl <em>Home Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeDecl
   * @generated
   */
  public Adapter createHomeDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec <em>Primary Key Spec</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryKeySpec
   * @generated
   */
  public Adapter createPrimaryKeySpecAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport <em>Home Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.HomeExport
   * @generated
   */
  public Adapter createHomeExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl <em>Factory Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FactoryDcl
   * @generated
   */
  public Adapter createFactoryDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl <em>Finder Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FinderDcl
   * @generated
   */
  public Adapter createFinderDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Event
   * @generated
   */
  public Adapter createEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl <em>Event Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventDcl
   * @generated
   */
  public Adapter createEventDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StateMember <em>State Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StateMember
   * @generated
   */
  public Adapter createStateMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventForwardDcl <em>Event Forward Dcl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventForwardDcl
   * @generated
   */
  public Adapter createEventForwardDclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl <em>Port Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortTypeDecl
   * @generated
   */
  public Adapter createPortTypeDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortExport <em>Port Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortExport
   * @generated
   */
  public Adapter createPortExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl <em>Port Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.PortDecl
   * @generated
   */
  public Adapter createPortDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.Connector <em>Connector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.Connector
   * @generated
   */
  public Adapter createConnectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader <em>Connector Header</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorHeader
   * @generated
   */
  public Adapter createConnectorHeaderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorExport <em>Connector Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConnectorExport
   * @generated
   */
  public Adapter createConnectorExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule <em>Template Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModule
   * @generated
   */
  public Adapter createTemplateModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter <em>Formal Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter
   * @generated
   */
  public Adapter createFormalParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType <em>Formal Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType
   * @generated
   */
  public Adapter createFormalParameterTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType <em>Typename Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType
   * @generated
   */
  public Adapter createTypenameParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType <em>Interface Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType
   * @generated
   */
  public Adapter createInterfaceParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType <em>Valuetype Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType
   * @generated
   */
  public Adapter createValuetypeParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType <em>Event Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType
   * @generated
   */
  public Adapter createEventParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType <em>Struct Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType
   * @generated
   */
  public Adapter createStructParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType <em>Union Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType
   * @generated
   */
  public Adapter createUnionParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType <em>Exception Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType
   * @generated
   */
  public Adapter createExceptionParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType <em>Enum Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType
   * @generated
   */
  public Adapter createEnumParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType <em>Sequence Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType
   * @generated
   */
  public Adapter createSequenceParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType <em>Const Param Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType
   * @generated
   */
  public Adapter createConstParamTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition <em>Template Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateDefinition
   * @generated
   */
  public Adapter createTemplateDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule <em>Fixed Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedModule
   * @generated
   */
  public Adapter createFixedModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition <em>Fixed Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.FixedDefinition
   * @generated
   */
  public Adapter createFixedDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst <em>Template Module Inst</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst
   * @generated
   */
  public Adapter createTemplateModuleInstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter <em>Actual Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter
   * @generated
   */
  public Adapter createActualParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef <em>Template Module Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef
   * @generated
   */
  public Adapter createTemplateModuleRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment <em>IDL Comment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.zeligsoft.domain.omg.corba.dsl.idl.IDLComment
   * @generated
   */
  public Adapter createIDLCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //IdlAdapterFactory
