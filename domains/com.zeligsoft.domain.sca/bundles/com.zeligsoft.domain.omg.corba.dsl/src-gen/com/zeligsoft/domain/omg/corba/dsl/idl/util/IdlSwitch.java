/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.zeligsoft.domain.omg.corba.dsl.idl.util;

import com.zeligsoft.domain.omg.corba.dsl.idl.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.zeligsoft.domain.omg.corba.dsl.idl.IdlPackage
 * @generated
 */
public class IdlSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IdlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdlSwitch() {
		if (modelPackage == null) {
			modelPackage = IdlPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IdlPackage.SPECIFICATION: {
				Specification specification = (Specification)theEObject;
				T result = caseSpecification(specification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC: {
				Preproc preproc = (Preproc)theEObject;
				T result = casePreproc(preproc);
				if (result == null) result = caseDefinition(preproc);
				if (result == null) result = caseExport(preproc);
				if (result == null) result = caseComponentExport(preproc);
				if (result == null) result = caseHomeExport(preproc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_INCLUDE: {
				Preproc_Include preproc_Include = (Preproc_Include)theEObject;
				T result = casePreproc_Include(preproc_Include);
				if (result == null) result = casePreproc(preproc_Include);
				if (result == null) result = caseDefinition(preproc_Include);
				if (result == null) result = caseExport(preproc_Include);
				if (result == null) result = caseComponentExport(preproc_Include);
				if (result == null) result = caseHomeExport(preproc_Include);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FILE_NAME: {
				FileName fileName = (FileName)theEObject;
				T result = caseFileName(fileName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_IFDEF: {
				Preproc_Ifdef preproc_Ifdef = (Preproc_Ifdef)theEObject;
				T result = casePreproc_Ifdef(preproc_Ifdef);
				if (result == null) result = casePreproc(preproc_Ifdef);
				if (result == null) result = caseDefinition(preproc_Ifdef);
				if (result == null) result = caseExport(preproc_Ifdef);
				if (result == null) result = caseComponentExport(preproc_Ifdef);
				if (result == null) result = caseHomeExport(preproc_Ifdef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_IFNDEF: {
				Preproc_Ifndef preproc_Ifndef = (Preproc_Ifndef)theEObject;
				T result = casePreproc_Ifndef(preproc_Ifndef);
				if (result == null) result = casePreproc(preproc_Ifndef);
				if (result == null) result = caseDefinition(preproc_Ifndef);
				if (result == null) result = caseExport(preproc_Ifndef);
				if (result == null) result = caseComponentExport(preproc_Ifndef);
				if (result == null) result = caseHomeExport(preproc_Ifndef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_UNDEF: {
				Preproc_Undef preproc_Undef = (Preproc_Undef)theEObject;
				T result = casePreproc_Undef(preproc_Undef);
				if (result == null) result = casePreproc(preproc_Undef);
				if (result == null) result = caseDefinition(preproc_Undef);
				if (result == null) result = caseExport(preproc_Undef);
				if (result == null) result = caseComponentExport(preproc_Undef);
				if (result == null) result = caseHomeExport(preproc_Undef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_IF: {
				Preproc_If preproc_If = (Preproc_If)theEObject;
				T result = casePreproc_If(preproc_If);
				if (result == null) result = casePreproc(preproc_If);
				if (result == null) result = caseDefinition(preproc_If);
				if (result == null) result = caseExport(preproc_If);
				if (result == null) result = caseComponentExport(preproc_If);
				if (result == null) result = caseHomeExport(preproc_If);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_IF_COMPARE: {
				Preproc_If_Compare preproc_If_Compare = (Preproc_If_Compare)theEObject;
				T result = casePreproc_If_Compare(preproc_If_Compare);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_IF_VAL: {
				Preproc_If_Val preproc_If_Val = (Preproc_If_Val)theEObject;
				T result = casePreproc_If_Val(preproc_If_Val);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_ELSE: {
				Preproc_Else preproc_Else = (Preproc_Else)theEObject;
				T result = casePreproc_Else(preproc_Else);
				if (result == null) result = casePreproc(preproc_Else);
				if (result == null) result = caseDefinition(preproc_Else);
				if (result == null) result = caseExport(preproc_Else);
				if (result == null) result = caseComponentExport(preproc_Else);
				if (result == null) result = caseHomeExport(preproc_Else);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_ERROR: {
				Preproc_Error preproc_Error = (Preproc_Error)theEObject;
				T result = casePreproc_Error(preproc_Error);
				if (result == null) result = casePreproc(preproc_Error);
				if (result == null) result = caseDefinition(preproc_Error);
				if (result == null) result = caseExport(preproc_Error);
				if (result == null) result = caseComponentExport(preproc_Error);
				if (result == null) result = caseHomeExport(preproc_Error);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_DEFINE: {
				Preproc_Define preproc_Define = (Preproc_Define)theEObject;
				T result = casePreproc_Define(preproc_Define);
				if (result == null) result = casePreproc(preproc_Define);
				if (result == null) result = caseDefinition(preproc_Define);
				if (result == null) result = caseExport(preproc_Define);
				if (result == null) result = caseComponentExport(preproc_Define);
				if (result == null) result = caseHomeExport(preproc_Define);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_ENDIF: {
				Preproc_Endif preproc_Endif = (Preproc_Endif)theEObject;
				T result = casePreproc_Endif(preproc_Endif);
				if (result == null) result = casePreproc(preproc_Endif);
				if (result == null) result = caseDefinition(preproc_Endif);
				if (result == null) result = caseExport(preproc_Endif);
				if (result == null) result = caseComponentExport(preproc_Endif);
				if (result == null) result = caseHomeExport(preproc_Endif);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA: {
				Preproc_Pragma preproc_Pragma = (Preproc_Pragma)theEObject;
				T result = casePreproc_Pragma(preproc_Pragma);
				if (result == null) result = casePreproc(preproc_Pragma);
				if (result == null) result = caseDefinition(preproc_Pragma);
				if (result == null) result = caseExport(preproc_Pragma);
				if (result == null) result = caseComponentExport(preproc_Pragma);
				if (result == null) result = caseHomeExport(preproc_Pragma);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_PREFIX: {
				Preproc_Pragma_Prefix preproc_Pragma_Prefix = (Preproc_Pragma_Prefix)theEObject;
				T result = casePreproc_Pragma_Prefix(preproc_Pragma_Prefix);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Prefix);
				if (result == null) result = casePreproc(preproc_Pragma_Prefix);
				if (result == null) result = caseDefinition(preproc_Pragma_Prefix);
				if (result == null) result = caseExport(preproc_Pragma_Prefix);
				if (result == null) result = caseComponentExport(preproc_Pragma_Prefix);
				if (result == null) result = caseHomeExport(preproc_Pragma_Prefix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_CIAO_LEM: {
				Preproc_Pragma_Ciao_Lem preproc_Pragma_Ciao_Lem = (Preproc_Pragma_Ciao_Lem)theEObject;
				T result = casePreproc_Pragma_Ciao_Lem(preproc_Pragma_Ciao_Lem);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Ciao_Lem);
				if (result == null) result = casePreproc(preproc_Pragma_Ciao_Lem);
				if (result == null) result = caseDefinition(preproc_Pragma_Ciao_Lem);
				if (result == null) result = caseExport(preproc_Pragma_Ciao_Lem);
				if (result == null) result = caseComponentExport(preproc_Pragma_Ciao_Lem);
				if (result == null) result = caseHomeExport(preproc_Pragma_Ciao_Lem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_CIAO_AMI4CCM_INTERFACE: {
				Preproc_Pragma_Ciao_Ami4ccm_Interface preproc_Pragma_Ciao_Ami4ccm_Interface = (Preproc_Pragma_Ciao_Ami4ccm_Interface)theEObject;
				T result = casePreproc_Pragma_Ciao_Ami4ccm_Interface(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = casePreproc(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = caseDefinition(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = caseExport(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = caseComponentExport(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = caseHomeExport(preproc_Pragma_Ciao_Ami4ccm_Interface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_CIAO_AMI4CCM_RECEPTACLE: {
				Preproc_Pragma_Ciao_Ami4ccm_Receptacle preproc_Pragma_Ciao_Ami4ccm_Receptacle = (Preproc_Pragma_Ciao_Ami4ccm_Receptacle)theEObject;
				T result = casePreproc_Pragma_Ciao_Ami4ccm_Receptacle(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = casePreproc(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = caseDefinition(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = caseExport(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = caseComponentExport(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = caseHomeExport(preproc_Pragma_Ciao_Ami4ccm_Receptacle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_CIAO_AMI4CCM_IDL: {
				Preproc_Pragma_Ciao_Ami4ccm_Idl preproc_Pragma_Ciao_Ami4ccm_Idl = (Preproc_Pragma_Ciao_Ami4ccm_Idl)theEObject;
				T result = casePreproc_Pragma_Ciao_Ami4ccm_Idl(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = casePreproc(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = caseDefinition(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = caseExport(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = caseComponentExport(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = caseHomeExport(preproc_Pragma_Ciao_Ami4ccm_Idl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_NDDS: {
				Preproc_Pragma_Ndds preproc_Pragma_Ndds = (Preproc_Pragma_Ndds)theEObject;
				T result = casePreproc_Pragma_Ndds(preproc_Pragma_Ndds);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Ndds);
				if (result == null) result = casePreproc(preproc_Pragma_Ndds);
				if (result == null) result = caseDefinition(preproc_Pragma_Ndds);
				if (result == null) result = caseExport(preproc_Pragma_Ndds);
				if (result == null) result = caseComponentExport(preproc_Pragma_Ndds);
				if (result == null) result = caseHomeExport(preproc_Pragma_Ndds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_COMPONENT: {
				Preproc_Pragma_Component preproc_Pragma_Component = (Preproc_Pragma_Component)theEObject;
				T result = casePreproc_Pragma_Component(preproc_Pragma_Component);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Component);
				if (result == null) result = casePreproc(preproc_Pragma_Component);
				if (result == null) result = caseDefinition(preproc_Pragma_Component);
				if (result == null) result = caseExport(preproc_Pragma_Component);
				if (result == null) result = caseComponentExport(preproc_Pragma_Component);
				if (result == null) result = caseHomeExport(preproc_Pragma_Component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_HOME: {
				Preproc_Pragma_Home preproc_Pragma_Home = (Preproc_Pragma_Home)theEObject;
				T result = casePreproc_Pragma_Home(preproc_Pragma_Home);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Home);
				if (result == null) result = casePreproc(preproc_Pragma_Home);
				if (result == null) result = caseDefinition(preproc_Pragma_Home);
				if (result == null) result = caseExport(preproc_Pragma_Home);
				if (result == null) result = caseComponentExport(preproc_Pragma_Home);
				if (result == null) result = caseHomeExport(preproc_Pragma_Home);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_DDS4CCM_IMPL: {
				Preproc_Pragma_DDS4CCM_Impl preproc_Pragma_DDS4CCM_Impl = (Preproc_Pragma_DDS4CCM_Impl)theEObject;
				T result = casePreproc_Pragma_DDS4CCM_Impl(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = casePreproc(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = caseDefinition(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = caseExport(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = caseComponentExport(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = caseHomeExport(preproc_Pragma_DDS4CCM_Impl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PREPROC_PRAGMA_MISC: {
				Preproc_Pragma_Misc preproc_Pragma_Misc = (Preproc_Pragma_Misc)theEObject;
				T result = casePreproc_Pragma_Misc(preproc_Pragma_Misc);
				if (result == null) result = casePreproc_Pragma(preproc_Pragma_Misc);
				if (result == null) result = casePreproc(preproc_Pragma_Misc);
				if (result == null) result = caseDefinition(preproc_Pragma_Misc);
				if (result == null) result = caseExport(preproc_Pragma_Misc);
				if (result == null) result = caseComponentExport(preproc_Pragma_Misc);
				if (result == null) result = caseHomeExport(preproc_Pragma_Misc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FILE_MARKER: {
				File_Marker file_Marker = (File_Marker)theEObject;
				T result = caseFile_Marker(file_Marker);
				if (result == null) result = casePreproc(file_Marker);
				if (result == null) result = caseDefinition(file_Marker);
				if (result == null) result = caseExport(file_Marker);
				if (result == null) result = caseComponentExport(file_Marker);
				if (result == null) result = caseHomeExport(file_Marker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EXCLUDED_FILE_MARKER: {
				Excluded_File_Marker excluded_File_Marker = (Excluded_File_Marker)theEObject;
				T result = caseExcluded_File_Marker(excluded_File_Marker);
				if (result == null) result = casePreproc(excluded_File_Marker);
				if (result == null) result = caseDefinition(excluded_File_Marker);
				if (result == null) result = caseExport(excluded_File_Marker);
				if (result == null) result = caseComponentExport(excluded_File_Marker);
				if (result == null) result = caseHomeExport(excluded_File_Marker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.IMPORT_DECL: {
				Import_decl import_decl = (Import_decl)theEObject;
				T result = caseImport_decl(import_decl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.DEFINITION: {
				Definition definition = (Definition)theEObject;
				T result = caseDefinition(definition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.MODULE: {
				Module module = (Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = caseDefinition(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.INTERFACE_OR_FORWARD_DECL: {
				Interface_or_Forward_Decl interface_or_Forward_Decl = (Interface_or_Forward_Decl)theEObject;
				T result = caseInterface_or_Forward_Decl(interface_or_Forward_Decl);
				if (result == null) result = caseDefinition(interface_or_Forward_Decl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.INTERFACE_DECL: {
				Interface_decl interface_decl = (Interface_decl)theEObject;
				T result = caseInterface_decl(interface_decl);
				if (result == null) result = caseInterface_or_Forward_Decl(interface_decl);
				if (result == null) result = caseTemplateDefinition(interface_decl);
				if (result == null) result = caseFixedDefinition(interface_decl);
				if (result == null) result = caseDefinition(interface_decl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FORWARD_DECL: {
				Forward_decl forward_decl = (Forward_decl)theEObject;
				T result = caseForward_decl(forward_decl);
				if (result == null) result = caseInterface_or_Forward_Decl(forward_decl);
				if (result == null) result = caseDefinition(forward_decl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.INTERFACE_HEADER: {
				Interface_header interface_header = (Interface_header)theEObject;
				T result = caseInterface_header(interface_header);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.INTERFACE_BODY: {
				InterfaceBody interfaceBody = (InterfaceBody)theEObject;
				T result = caseInterfaceBody(interfaceBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EXPORT: {
				Export export = (Export)theEObject;
				T result = caseExport(export);
				if (result == null) result = caseHomeExport(export);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ATTR_DECL: {
				AttrDecl attrDecl = (AttrDecl)theEObject;
				T result = caseAttrDecl(attrDecl);
				if (result == null) result = caseExport(attrDecl);
				if (result == null) result = caseComponentExport(attrDecl);
				if (result == null) result = casePortExport(attrDecl);
				if (result == null) result = caseConnectorExport(attrDecl);
				if (result == null) result = caseHomeExport(attrDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ATTR_SPEC: {
				AttrSpec attrSpec = (AttrSpec)theEObject;
				T result = caseAttrSpec(attrSpec);
				if (result == null) result = caseAttrDecl(attrSpec);
				if (result == null) result = caseExport(attrSpec);
				if (result == null) result = caseComponentExport(attrSpec);
				if (result == null) result = casePortExport(attrSpec);
				if (result == null) result = caseConnectorExport(attrSpec);
				if (result == null) result = caseHomeExport(attrSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.READ_ONLY_ATTR_SPEC: {
				ReadOnlyAttrSpec readOnlyAttrSpec = (ReadOnlyAttrSpec)theEObject;
				T result = caseReadOnlyAttrSpec(readOnlyAttrSpec);
				if (result == null) result = caseAttrDecl(readOnlyAttrSpec);
				if (result == null) result = caseExport(readOnlyAttrSpec);
				if (result == null) result = caseComponentExport(readOnlyAttrSpec);
				if (result == null) result = casePortExport(readOnlyAttrSpec);
				if (result == null) result = caseConnectorExport(readOnlyAttrSpec);
				if (result == null) result = caseHomeExport(readOnlyAttrSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ATTR_RAISES_EXPR: {
				AttrRaisesExpr attrRaisesExpr = (AttrRaisesExpr)theEObject;
				T result = caseAttrRaisesExpr(attrRaisesExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EXCEPTION_LIST: {
				ExceptionList exceptionList = (ExceptionList)theEObject;
				T result = caseExceptionList(exceptionList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.OP_DECL: {
				OpDecl opDecl = (OpDecl)theEObject;
				T result = caseOpDecl(opDecl);
				if (result == null) result = caseExport(opDecl);
				if (result == null) result = caseHomeExport(opDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.OP_TYPE_DECL: {
				OpTypeDecl opTypeDecl = (OpTypeDecl)theEObject;
				T result = caseOpTypeDecl(opTypeDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PARAMETER_DECLS: {
				ParameterDecls parameterDecls = (ParameterDecls)theEObject;
				T result = caseParameterDecls(parameterDecls);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PARAM_DCL: {
				ParamDcl paramDcl = (ParamDcl)theEObject;
				T result = caseParamDcl(paramDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONTEXT_EXPR: {
				ContextExpr contextExpr = (ContextExpr)theEObject;
				T result = caseContextExpr(contextExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PARAM_TYPE_SPEC: {
				ParamTypeSpec paramTypeSpec = (ParamTypeSpec)theEObject;
				T result = caseParamTypeSpec(paramTypeSpec);
				if (result == null) result = caseOpTypeDecl(paramTypeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SCOPED_NAME: {
				ScopedName scopedName = (ScopedName)theEObject;
				T result = caseScopedName(scopedName);
				if (result == null) result = caseParamTypeSpec(scopedName);
				if (result == null) result = caseSimpleTypeSpec(scopedName);
				if (result == null) result = caseSwitchTypeSpec(scopedName);
				if (result == null) result = caseConstType(scopedName);
				if (result == null) result = casePrimaryExpr(scopedName);
				if (result == null) result = caseOpTypeDecl(scopedName);
				if (result == null) result = caseTypeSpec(scopedName);
				if (result == null) result = caseConstParamType(scopedName);
				if (result == null) result = caseActualParameter(scopedName);
				if (result == null) result = caseFormalParameterType(scopedName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.BASE_TYPE_SPEC: {
				BaseTypeSpec baseTypeSpec = (BaseTypeSpec)theEObject;
				T result = caseBaseTypeSpec(baseTypeSpec);
				if (result == null) result = caseParamTypeSpec(baseTypeSpec);
				if (result == null) result = caseSimpleTypeSpec(baseTypeSpec);
				if (result == null) result = caseOpTypeDecl(baseTypeSpec);
				if (result == null) result = caseTypeSpec(baseTypeSpec);
				if (result == null) result = caseActualParameter(baseTypeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FLOATING_PT_TYPE: {
				FloatingPtType floatingPtType = (FloatingPtType)theEObject;
				T result = caseFloatingPtType(floatingPtType);
				if (result == null) result = caseBaseTypeSpec(floatingPtType);
				if (result == null) result = caseConstType(floatingPtType);
				if (result == null) result = caseParamTypeSpec(floatingPtType);
				if (result == null) result = caseSimpleTypeSpec(floatingPtType);
				if (result == null) result = caseConstParamType(floatingPtType);
				if (result == null) result = caseOpTypeDecl(floatingPtType);
				if (result == null) result = caseTypeSpec(floatingPtType);
				if (result == null) result = caseFormalParameterType(floatingPtType);
				if (result == null) result = caseActualParameter(floatingPtType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FLOAT_TYPE: {
				FloatType floatType = (FloatType)theEObject;
				T result = caseFloatType(floatType);
				if (result == null) result = caseFloatingPtType(floatType);
				if (result == null) result = caseBaseTypeSpec(floatType);
				if (result == null) result = caseConstType(floatType);
				if (result == null) result = caseParamTypeSpec(floatType);
				if (result == null) result = caseSimpleTypeSpec(floatType);
				if (result == null) result = caseConstParamType(floatType);
				if (result == null) result = caseOpTypeDecl(floatType);
				if (result == null) result = caseTypeSpec(floatType);
				if (result == null) result = caseFormalParameterType(floatType);
				if (result == null) result = caseActualParameter(floatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.DOUBLE_TYPE: {
				DoubleType doubleType = (DoubleType)theEObject;
				T result = caseDoubleType(doubleType);
				if (result == null) result = caseFloatingPtType(doubleType);
				if (result == null) result = caseBaseTypeSpec(doubleType);
				if (result == null) result = caseConstType(doubleType);
				if (result == null) result = caseParamTypeSpec(doubleType);
				if (result == null) result = caseSimpleTypeSpec(doubleType);
				if (result == null) result = caseConstParamType(doubleType);
				if (result == null) result = caseOpTypeDecl(doubleType);
				if (result == null) result = caseTypeSpec(doubleType);
				if (result == null) result = caseFormalParameterType(doubleType);
				if (result == null) result = caseActualParameter(doubleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.LONG_DOUBLE_TYPE: {
				LongDoubleType longDoubleType = (LongDoubleType)theEObject;
				T result = caseLongDoubleType(longDoubleType);
				if (result == null) result = caseFloatingPtType(longDoubleType);
				if (result == null) result = caseBaseTypeSpec(longDoubleType);
				if (result == null) result = caseConstType(longDoubleType);
				if (result == null) result = caseParamTypeSpec(longDoubleType);
				if (result == null) result = caseSimpleTypeSpec(longDoubleType);
				if (result == null) result = caseConstParamType(longDoubleType);
				if (result == null) result = caseOpTypeDecl(longDoubleType);
				if (result == null) result = caseTypeSpec(longDoubleType);
				if (result == null) result = caseFormalParameterType(longDoubleType);
				if (result == null) result = caseActualParameter(longDoubleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType)theEObject;
				T result = caseIntegerType(integerType);
				if (result == null) result = caseBaseTypeSpec(integerType);
				if (result == null) result = caseSwitchTypeSpec(integerType);
				if (result == null) result = caseConstType(integerType);
				if (result == null) result = caseParamTypeSpec(integerType);
				if (result == null) result = caseSimpleTypeSpec(integerType);
				if (result == null) result = caseConstParamType(integerType);
				if (result == null) result = caseOpTypeDecl(integerType);
				if (result == null) result = caseTypeSpec(integerType);
				if (result == null) result = caseFormalParameterType(integerType);
				if (result == null) result = caseActualParameter(integerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SIGNED_INT: {
				SignedInt signedInt = (SignedInt)theEObject;
				T result = caseSignedInt(signedInt);
				if (result == null) result = caseIntegerType(signedInt);
				if (result == null) result = caseBaseTypeSpec(signedInt);
				if (result == null) result = caseSwitchTypeSpec(signedInt);
				if (result == null) result = caseConstType(signedInt);
				if (result == null) result = caseParamTypeSpec(signedInt);
				if (result == null) result = caseSimpleTypeSpec(signedInt);
				if (result == null) result = caseConstParamType(signedInt);
				if (result == null) result = caseOpTypeDecl(signedInt);
				if (result == null) result = caseTypeSpec(signedInt);
				if (result == null) result = caseFormalParameterType(signedInt);
				if (result == null) result = caseActualParameter(signedInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SIGNED_SHORT_INT: {
				SignedShortInt signedShortInt = (SignedShortInt)theEObject;
				T result = caseSignedShortInt(signedShortInt);
				if (result == null) result = caseSignedInt(signedShortInt);
				if (result == null) result = caseIntegerType(signedShortInt);
				if (result == null) result = caseBaseTypeSpec(signedShortInt);
				if (result == null) result = caseSwitchTypeSpec(signedShortInt);
				if (result == null) result = caseConstType(signedShortInt);
				if (result == null) result = caseParamTypeSpec(signedShortInt);
				if (result == null) result = caseSimpleTypeSpec(signedShortInt);
				if (result == null) result = caseConstParamType(signedShortInt);
				if (result == null) result = caseOpTypeDecl(signedShortInt);
				if (result == null) result = caseTypeSpec(signedShortInt);
				if (result == null) result = caseFormalParameterType(signedShortInt);
				if (result == null) result = caseActualParameter(signedShortInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SIGNED_LONG_INT: {
				SignedLongInt signedLongInt = (SignedLongInt)theEObject;
				T result = caseSignedLongInt(signedLongInt);
				if (result == null) result = caseSignedInt(signedLongInt);
				if (result == null) result = caseIntegerType(signedLongInt);
				if (result == null) result = caseBaseTypeSpec(signedLongInt);
				if (result == null) result = caseSwitchTypeSpec(signedLongInt);
				if (result == null) result = caseConstType(signedLongInt);
				if (result == null) result = caseParamTypeSpec(signedLongInt);
				if (result == null) result = caseSimpleTypeSpec(signedLongInt);
				if (result == null) result = caseConstParamType(signedLongInt);
				if (result == null) result = caseOpTypeDecl(signedLongInt);
				if (result == null) result = caseTypeSpec(signedLongInt);
				if (result == null) result = caseFormalParameterType(signedLongInt);
				if (result == null) result = caseActualParameter(signedLongInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SIGNED_LONG_LONG_INT: {
				SignedLongLongInt signedLongLongInt = (SignedLongLongInt)theEObject;
				T result = caseSignedLongLongInt(signedLongLongInt);
				if (result == null) result = caseSignedInt(signedLongLongInt);
				if (result == null) result = caseIntegerType(signedLongLongInt);
				if (result == null) result = caseBaseTypeSpec(signedLongLongInt);
				if (result == null) result = caseSwitchTypeSpec(signedLongLongInt);
				if (result == null) result = caseConstType(signedLongLongInt);
				if (result == null) result = caseParamTypeSpec(signedLongLongInt);
				if (result == null) result = caseSimpleTypeSpec(signedLongLongInt);
				if (result == null) result = caseConstParamType(signedLongLongInt);
				if (result == null) result = caseOpTypeDecl(signedLongLongInt);
				if (result == null) result = caseTypeSpec(signedLongLongInt);
				if (result == null) result = caseFormalParameterType(signedLongLongInt);
				if (result == null) result = caseActualParameter(signedLongLongInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNSIGNED_INT: {
				UnsignedInt unsignedInt = (UnsignedInt)theEObject;
				T result = caseUnsignedInt(unsignedInt);
				if (result == null) result = caseIntegerType(unsignedInt);
				if (result == null) result = caseBaseTypeSpec(unsignedInt);
				if (result == null) result = caseSwitchTypeSpec(unsignedInt);
				if (result == null) result = caseConstType(unsignedInt);
				if (result == null) result = caseParamTypeSpec(unsignedInt);
				if (result == null) result = caseSimpleTypeSpec(unsignedInt);
				if (result == null) result = caseConstParamType(unsignedInt);
				if (result == null) result = caseOpTypeDecl(unsignedInt);
				if (result == null) result = caseTypeSpec(unsignedInt);
				if (result == null) result = caseFormalParameterType(unsignedInt);
				if (result == null) result = caseActualParameter(unsignedInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNSIGNED_SHORT_INT: {
				UnsignedShortInt unsignedShortInt = (UnsignedShortInt)theEObject;
				T result = caseUnsignedShortInt(unsignedShortInt);
				if (result == null) result = caseUnsignedInt(unsignedShortInt);
				if (result == null) result = caseIntegerType(unsignedShortInt);
				if (result == null) result = caseBaseTypeSpec(unsignedShortInt);
				if (result == null) result = caseSwitchTypeSpec(unsignedShortInt);
				if (result == null) result = caseConstType(unsignedShortInt);
				if (result == null) result = caseParamTypeSpec(unsignedShortInt);
				if (result == null) result = caseSimpleTypeSpec(unsignedShortInt);
				if (result == null) result = caseConstParamType(unsignedShortInt);
				if (result == null) result = caseOpTypeDecl(unsignedShortInt);
				if (result == null) result = caseTypeSpec(unsignedShortInt);
				if (result == null) result = caseFormalParameterType(unsignedShortInt);
				if (result == null) result = caseActualParameter(unsignedShortInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNSIGNED_LONG_INT: {
				UnsignedLongInt unsignedLongInt = (UnsignedLongInt)theEObject;
				T result = caseUnsignedLongInt(unsignedLongInt);
				if (result == null) result = caseUnsignedInt(unsignedLongInt);
				if (result == null) result = caseIntegerType(unsignedLongInt);
				if (result == null) result = caseBaseTypeSpec(unsignedLongInt);
				if (result == null) result = caseSwitchTypeSpec(unsignedLongInt);
				if (result == null) result = caseConstType(unsignedLongInt);
				if (result == null) result = caseParamTypeSpec(unsignedLongInt);
				if (result == null) result = caseSimpleTypeSpec(unsignedLongInt);
				if (result == null) result = caseConstParamType(unsignedLongInt);
				if (result == null) result = caseOpTypeDecl(unsignedLongInt);
				if (result == null) result = caseTypeSpec(unsignedLongInt);
				if (result == null) result = caseFormalParameterType(unsignedLongInt);
				if (result == null) result = caseActualParameter(unsignedLongInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNSIGNED_LONG_LONG_INT: {
				UnsignedLongLongInt unsignedLongLongInt = (UnsignedLongLongInt)theEObject;
				T result = caseUnsignedLongLongInt(unsignedLongLongInt);
				if (result == null) result = caseUnsignedInt(unsignedLongLongInt);
				if (result == null) result = caseIntegerType(unsignedLongLongInt);
				if (result == null) result = caseBaseTypeSpec(unsignedLongLongInt);
				if (result == null) result = caseSwitchTypeSpec(unsignedLongLongInt);
				if (result == null) result = caseConstType(unsignedLongLongInt);
				if (result == null) result = caseParamTypeSpec(unsignedLongLongInt);
				if (result == null) result = caseSimpleTypeSpec(unsignedLongLongInt);
				if (result == null) result = caseConstParamType(unsignedLongLongInt);
				if (result == null) result = caseOpTypeDecl(unsignedLongLongInt);
				if (result == null) result = caseTypeSpec(unsignedLongLongInt);
				if (result == null) result = caseFormalParameterType(unsignedLongLongInt);
				if (result == null) result = caseActualParameter(unsignedLongLongInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CHAR_TYPE: {
				CharType charType = (CharType)theEObject;
				T result = caseCharType(charType);
				if (result == null) result = caseBaseTypeSpec(charType);
				if (result == null) result = caseSwitchTypeSpec(charType);
				if (result == null) result = caseConstType(charType);
				if (result == null) result = caseParamTypeSpec(charType);
				if (result == null) result = caseSimpleTypeSpec(charType);
				if (result == null) result = caseConstParamType(charType);
				if (result == null) result = caseOpTypeDecl(charType);
				if (result == null) result = caseTypeSpec(charType);
				if (result == null) result = caseFormalParameterType(charType);
				if (result == null) result = caseActualParameter(charType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.WIDE_CHAR_TYPE: {
				WideCharType wideCharType = (WideCharType)theEObject;
				T result = caseWideCharType(wideCharType);
				if (result == null) result = caseBaseTypeSpec(wideCharType);
				if (result == null) result = caseConstType(wideCharType);
				if (result == null) result = caseParamTypeSpec(wideCharType);
				if (result == null) result = caseSimpleTypeSpec(wideCharType);
				if (result == null) result = caseConstParamType(wideCharType);
				if (result == null) result = caseOpTypeDecl(wideCharType);
				if (result == null) result = caseTypeSpec(wideCharType);
				if (result == null) result = caseFormalParameterType(wideCharType);
				if (result == null) result = caseActualParameter(wideCharType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = caseBaseTypeSpec(booleanType);
				if (result == null) result = caseSwitchTypeSpec(booleanType);
				if (result == null) result = caseConstType(booleanType);
				if (result == null) result = caseParamTypeSpec(booleanType);
				if (result == null) result = caseSimpleTypeSpec(booleanType);
				if (result == null) result = caseConstParamType(booleanType);
				if (result == null) result = caseOpTypeDecl(booleanType);
				if (result == null) result = caseTypeSpec(booleanType);
				if (result == null) result = caseFormalParameterType(booleanType);
				if (result == null) result = caseActualParameter(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.OCTET_TYPE: {
				OctetType octetType = (OctetType)theEObject;
				T result = caseOctetType(octetType);
				if (result == null) result = caseBaseTypeSpec(octetType);
				if (result == null) result = caseConstType(octetType);
				if (result == null) result = caseParamTypeSpec(octetType);
				if (result == null) result = caseSimpleTypeSpec(octetType);
				if (result == null) result = caseConstParamType(octetType);
				if (result == null) result = caseOpTypeDecl(octetType);
				if (result == null) result = caseTypeSpec(octetType);
				if (result == null) result = caseFormalParameterType(octetType);
				if (result == null) result = caseActualParameter(octetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ANY_TYPE: {
				AnyType anyType = (AnyType)theEObject;
				T result = caseAnyType(anyType);
				if (result == null) result = caseBaseTypeSpec(anyType);
				if (result == null) result = caseParamTypeSpec(anyType);
				if (result == null) result = caseSimpleTypeSpec(anyType);
				if (result == null) result = caseOpTypeDecl(anyType);
				if (result == null) result = caseTypeSpec(anyType);
				if (result == null) result = caseActualParameter(anyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.OBJECT_TYPE: {
				ObjectType objectType = (ObjectType)theEObject;
				T result = caseObjectType(objectType);
				if (result == null) result = caseBaseTypeSpec(objectType);
				if (result == null) result = caseParamTypeSpec(objectType);
				if (result == null) result = caseSimpleTypeSpec(objectType);
				if (result == null) result = caseOpTypeDecl(objectType);
				if (result == null) result = caseTypeSpec(objectType);
				if (result == null) result = caseActualParameter(objectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.VALUE_BASE_TYPE: {
				ValueBaseType valueBaseType = (ValueBaseType)theEObject;
				T result = caseValueBaseType(valueBaseType);
				if (result == null) result = caseBaseTypeSpec(valueBaseType);
				if (result == null) result = caseParamTypeSpec(valueBaseType);
				if (result == null) result = caseSimpleTypeSpec(valueBaseType);
				if (result == null) result = caseOpTypeDecl(valueBaseType);
				if (result == null) result = caseTypeSpec(valueBaseType);
				if (result == null) result = caseActualParameter(valueBaseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = caseParamTypeSpec(stringType);
				if (result == null) result = caseTemplateTypeSpec(stringType);
				if (result == null) result = caseConstType(stringType);
				if (result == null) result = caseOpTypeDecl(stringType);
				if (result == null) result = caseSimpleTypeSpec(stringType);
				if (result == null) result = caseConstParamType(stringType);
				if (result == null) result = caseTypeSpec(stringType);
				if (result == null) result = caseFormalParameterType(stringType);
				if (result == null) result = caseActualParameter(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.WIDE_STRING_TYPE: {
				WideStringType wideStringType = (WideStringType)theEObject;
				T result = caseWideStringType(wideStringType);
				if (result == null) result = caseParamTypeSpec(wideStringType);
				if (result == null) result = caseTemplateTypeSpec(wideStringType);
				if (result == null) result = caseConstType(wideStringType);
				if (result == null) result = caseOpTypeDecl(wideStringType);
				if (result == null) result = caseSimpleTypeSpec(wideStringType);
				if (result == null) result = caseConstParamType(wideStringType);
				if (result == null) result = caseTypeSpec(wideStringType);
				if (result == null) result = caseFormalParameterType(wideStringType);
				if (result == null) result = caseActualParameter(wideStringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EXCEPT_DECL: {
				ExceptDecl exceptDecl = (ExceptDecl)theEObject;
				T result = caseExceptDecl(exceptDecl);
				if (result == null) result = caseDefinition(exceptDecl);
				if (result == null) result = caseExport(exceptDecl);
				if (result == null) result = caseTemplateDefinition(exceptDecl);
				if (result == null) result = caseFixedDefinition(exceptDecl);
				if (result == null) result = caseHomeExport(exceptDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.MEMBER: {
				Member member = (Member)theEObject;
				T result = caseMember(member);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.DECLARATOR: {
				Declarator declarator = (Declarator)theEObject;
				T result = caseDeclarator(declarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SIMPLE_DECLARATOR: {
				SimpleDeclarator simpleDeclarator = (SimpleDeclarator)theEObject;
				T result = caseSimpleDeclarator(simpleDeclarator);
				if (result == null) result = caseDeclarator(simpleDeclarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.COMPLEX_DECLARATOR: {
				ComplexDeclarator complexDeclarator = (ComplexDeclarator)theEObject;
				T result = caseComplexDeclarator(complexDeclarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ARRAY_DECLARATOR: {
				ArrayDeclarator arrayDeclarator = (ArrayDeclarator)theEObject;
				T result = caseArrayDeclarator(arrayDeclarator);
				if (result == null) result = caseDeclarator(arrayDeclarator);
				if (result == null) result = caseComplexDeclarator(arrayDeclarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.STRUCT_TYPE: {
				StructType structType = (StructType)theEObject;
				T result = caseStructType(structType);
				if (result == null) result = caseTypeDecl(structType);
				if (result == null) result = caseConstrTypeSpec(structType);
				if (result == null) result = caseDefinition(structType);
				if (result == null) result = caseExport(structType);
				if (result == null) result = caseTemplateDefinition(structType);
				if (result == null) result = caseFixedDefinition(structType);
				if (result == null) result = caseTypeSpec(structType);
				if (result == null) result = caseHomeExport(structType);
				if (result == null) result = caseActualParameter(structType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TYPE_DECL: {
				TypeDecl typeDecl = (TypeDecl)theEObject;
				T result = caseTypeDecl(typeDecl);
				if (result == null) result = caseDefinition(typeDecl);
				if (result == null) result = caseExport(typeDecl);
				if (result == null) result = caseTemplateDefinition(typeDecl);
				if (result == null) result = caseFixedDefinition(typeDecl);
				if (result == null) result = caseHomeExport(typeDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TYPE_DECLARATOR: {
				TypeDeclarator typeDeclarator = (TypeDeclarator)theEObject;
				T result = caseTypeDeclarator(typeDeclarator);
				if (result == null) result = caseTypeDecl(typeDeclarator);
				if (result == null) result = caseDefinition(typeDeclarator);
				if (result == null) result = caseExport(typeDeclarator);
				if (result == null) result = caseTemplateDefinition(typeDeclarator);
				if (result == null) result = caseFixedDefinition(typeDeclarator);
				if (result == null) result = caseHomeExport(typeDeclarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TYPE_SPEC: {
				TypeSpec typeSpec = (TypeSpec)theEObject;
				T result = caseTypeSpec(typeSpec);
				if (result == null) result = caseActualParameter(typeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SIMPLE_TYPE_SPEC: {
				SimpleTypeSpec simpleTypeSpec = (SimpleTypeSpec)theEObject;
				T result = caseSimpleTypeSpec(simpleTypeSpec);
				if (result == null) result = caseTypeSpec(simpleTypeSpec);
				if (result == null) result = caseActualParameter(simpleTypeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TEMPLATE_TYPE_SPEC: {
				TemplateTypeSpec templateTypeSpec = (TemplateTypeSpec)theEObject;
				T result = caseTemplateTypeSpec(templateTypeSpec);
				if (result == null) result = caseSimpleTypeSpec(templateTypeSpec);
				if (result == null) result = caseTypeSpec(templateTypeSpec);
				if (result == null) result = caseActualParameter(templateTypeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONSTR_TYPE_SPEC: {
				ConstrTypeSpec constrTypeSpec = (ConstrTypeSpec)theEObject;
				T result = caseConstrTypeSpec(constrTypeSpec);
				if (result == null) result = caseTypeSpec(constrTypeSpec);
				if (result == null) result = caseActualParameter(constrTypeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNION_TYPE: {
				UnionType unionType = (UnionType)theEObject;
				T result = caseUnionType(unionType);
				if (result == null) result = caseTypeDecl(unionType);
				if (result == null) result = caseConstrTypeSpec(unionType);
				if (result == null) result = caseDefinition(unionType);
				if (result == null) result = caseExport(unionType);
				if (result == null) result = caseTemplateDefinition(unionType);
				if (result == null) result = caseFixedDefinition(unionType);
				if (result == null) result = caseTypeSpec(unionType);
				if (result == null) result = caseHomeExport(unionType);
				if (result == null) result = caseActualParameter(unionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SWITCH_TYPE_SPEC: {
				SwitchTypeSpec switchTypeSpec = (SwitchTypeSpec)theEObject;
				T result = caseSwitchTypeSpec(switchTypeSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SWITCH_BODY: {
				SwitchBody switchBody = (SwitchBody)theEObject;
				T result = caseSwitchBody(switchBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CASE: {
				Case case_ = (Case)theEObject;
				T result = caseCase(case_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CASE_LABEL: {
				CaseLabel caseLabel = (CaseLabel)theEObject;
				T result = caseCaseLabel(caseLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ELEMENT_SPEC: {
				ElementSpec elementSpec = (ElementSpec)theEObject;
				T result = caseElementSpec(elementSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ENUM_TYPE: {
				EnumType enumType = (EnumType)theEObject;
				T result = caseEnumType(enumType);
				if (result == null) result = caseTypeDecl(enumType);
				if (result == null) result = caseConstrTypeSpec(enumType);
				if (result == null) result = caseSwitchTypeSpec(enumType);
				if (result == null) result = caseDefinition(enumType);
				if (result == null) result = caseExport(enumType);
				if (result == null) result = caseTemplateDefinition(enumType);
				if (result == null) result = caseFixedDefinition(enumType);
				if (result == null) result = caseTypeSpec(enumType);
				if (result == null) result = caseHomeExport(enumType);
				if (result == null) result = caseActualParameter(enumType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType)theEObject;
				T result = caseSequenceType(sequenceType);
				if (result == null) result = caseTemplateTypeSpec(sequenceType);
				if (result == null) result = caseFormalParameterType(sequenceType);
				if (result == null) result = caseSimpleTypeSpec(sequenceType);
				if (result == null) result = caseTypeSpec(sequenceType);
				if (result == null) result = caseActualParameter(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.NATIVE_TYPE: {
				NativeType nativeType = (NativeType)theEObject;
				T result = caseNativeType(nativeType);
				if (result == null) result = caseDefinition(nativeType);
				if (result == null) result = caseTemplateDefinition(nativeType);
				if (result == null) result = caseFixedDefinition(nativeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FIXED_PT_TYPE: {
				FixedPtType fixedPtType = (FixedPtType)theEObject;
				T result = caseFixedPtType(fixedPtType);
				if (result == null) result = caseTemplateTypeSpec(fixedPtType);
				if (result == null) result = caseSimpleTypeSpec(fixedPtType);
				if (result == null) result = caseTypeSpec(fixedPtType);
				if (result == null) result = caseActualParameter(fixedPtType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONSTR_FORWARD_DECL: {
				ConstrForwardDecl constrForwardDecl = (ConstrForwardDecl)theEObject;
				T result = caseConstrForwardDecl(constrForwardDecl);
				if (result == null) result = caseTypeDecl(constrForwardDecl);
				if (result == null) result = caseDefinition(constrForwardDecl);
				if (result == null) result = caseExport(constrForwardDecl);
				if (result == null) result = caseTemplateDefinition(constrForwardDecl);
				if (result == null) result = caseFixedDefinition(constrForwardDecl);
				if (result == null) result = caseHomeExport(constrForwardDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.STRUCT_FORWARD_DECL: {
				StructForwardDecl structForwardDecl = (StructForwardDecl)theEObject;
				T result = caseStructForwardDecl(structForwardDecl);
				if (result == null) result = caseConstrForwardDecl(structForwardDecl);
				if (result == null) result = caseTypeDecl(structForwardDecl);
				if (result == null) result = caseDefinition(structForwardDecl);
				if (result == null) result = caseExport(structForwardDecl);
				if (result == null) result = caseTemplateDefinition(structForwardDecl);
				if (result == null) result = caseFixedDefinition(structForwardDecl);
				if (result == null) result = caseHomeExport(structForwardDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNION_FORWARD_DECL: {
				UnionForwardDecl unionForwardDecl = (UnionForwardDecl)theEObject;
				T result = caseUnionForwardDecl(unionForwardDecl);
				if (result == null) result = caseConstrForwardDecl(unionForwardDecl);
				if (result == null) result = caseTypeDecl(unionForwardDecl);
				if (result == null) result = caseDefinition(unionForwardDecl);
				if (result == null) result = caseExport(unionForwardDecl);
				if (result == null) result = caseTemplateDefinition(unionForwardDecl);
				if (result == null) result = caseFixedDefinition(unionForwardDecl);
				if (result == null) result = caseHomeExport(unionForwardDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.POSITIVE_INT_CONST: {
				PositiveIntConst positiveIntConst = (PositiveIntConst)theEObject;
				T result = casePositiveIntConst(positiveIntConst);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONST_DECL: {
				ConstDecl constDecl = (ConstDecl)theEObject;
				T result = caseConstDecl(constDecl);
				if (result == null) result = caseDefinition(constDecl);
				if (result == null) result = caseExport(constDecl);
				if (result == null) result = caseTemplateDefinition(constDecl);
				if (result == null) result = caseFixedDefinition(constDecl);
				if (result == null) result = caseHomeExport(constDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONST_TYPE: {
				ConstType constType = (ConstType)theEObject;
				T result = caseConstType(constType);
				if (result == null) result = caseConstParamType(constType);
				if (result == null) result = caseFormalParameterType(constType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FIXED_PT_CONST_TYPE: {
				FixedPtConstType fixedPtConstType = (FixedPtConstType)theEObject;
				T result = caseFixedPtConstType(fixedPtConstType);
				if (result == null) result = caseConstType(fixedPtConstType);
				if (result == null) result = caseConstParamType(fixedPtConstType);
				if (result == null) result = caseFormalParameterType(fixedPtConstType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONST_EXP: {
				ConstExp constExp = (ConstExp)theEObject;
				T result = caseConstExp(constExp);
				if (result == null) result = casePrimaryExpr(constExp);
				if (result == null) result = caseActualParameter(constExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.OR_EXPR: {
				OrExpr orExpr = (OrExpr)theEObject;
				T result = caseOrExpr(orExpr);
				if (result == null) result = caseConstExp(orExpr);
				if (result == null) result = casePrimaryExpr(orExpr);
				if (result == null) result = caseActualParameter(orExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.XOR_EXPR: {
				XOrExpr xOrExpr = (XOrExpr)theEObject;
				T result = caseXOrExpr(xOrExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.AND_EXPR: {
				AndExpr andExpr = (AndExpr)theEObject;
				T result = caseAndExpr(andExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SHIFT_EXPR: {
				ShiftExpr shiftExpr = (ShiftExpr)theEObject;
				T result = caseShiftExpr(shiftExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ADD_EXPR: {
				AddExpr addExpr = (AddExpr)theEObject;
				T result = caseAddExpr(addExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.MULT_EXPR: {
				MultExpr multExpr = (MultExpr)theEObject;
				T result = caseMultExpr(multExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNARY_EXPR: {
				UnaryExpr unaryExpr = (UnaryExpr)theEObject;
				T result = caseUnaryExpr(unaryExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PRIMARY_EXPR: {
				PrimaryExpr primaryExpr = (PrimaryExpr)theEObject;
				T result = casePrimaryExpr(primaryExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = casePrimaryExpr(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.COMPONENT_DECL: {
				ComponentDecl componentDecl = (ComponentDecl)theEObject;
				T result = caseComponentDecl(componentDecl);
				if (result == null) result = caseDefinition(componentDecl);
				if (result == null) result = caseTemplateDefinition(componentDecl);
				if (result == null) result = caseFixedDefinition(componentDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.COMPONENT_EXPORT: {
				ComponentExport componentExport = (ComponentExport)theEObject;
				T result = caseComponentExport(componentExport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PROVIDES_DCL: {
				ProvidesDcl providesDcl = (ProvidesDcl)theEObject;
				T result = caseProvidesDcl(providesDcl);
				if (result == null) result = caseComponentExport(providesDcl);
				if (result == null) result = casePortExport(providesDcl);
				if (result == null) result = caseConnectorExport(providesDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.USES_DCL: {
				UsesDcl usesDcl = (UsesDcl)theEObject;
				T result = caseUsesDcl(usesDcl);
				if (result == null) result = caseComponentExport(usesDcl);
				if (result == null) result = casePortExport(usesDcl);
				if (result == null) result = caseConnectorExport(usesDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PUBLISHES_DCL: {
				PublishesDcl publishesDcl = (PublishesDcl)theEObject;
				T result = casePublishesDcl(publishesDcl);
				if (result == null) result = caseComponentExport(publishesDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EMIT_DCL: {
				EmitDcl emitDcl = (EmitDcl)theEObject;
				T result = caseEmitDcl(emitDcl);
				if (result == null) result = caseComponentExport(emitDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONSUMES_DCL: {
				ConsumesDcl consumesDcl = (ConsumesDcl)theEObject;
				T result = caseConsumesDcl(consumesDcl);
				if (result == null) result = caseComponentExport(consumesDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.COMPONENT_FORWARD_DECL: {
				ComponentForwardDecl componentForwardDecl = (ComponentForwardDecl)theEObject;
				T result = caseComponentForwardDecl(componentForwardDecl);
				if (result == null) result = caseDefinition(componentForwardDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.HOME_DECL: {
				HomeDecl homeDecl = (HomeDecl)theEObject;
				T result = caseHomeDecl(homeDecl);
				if (result == null) result = caseDefinition(homeDecl);
				if (result == null) result = caseTemplateDefinition(homeDecl);
				if (result == null) result = caseFixedDefinition(homeDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PRIMARY_KEY_SPEC: {
				PrimaryKeySpec primaryKeySpec = (PrimaryKeySpec)theEObject;
				T result = casePrimaryKeySpec(primaryKeySpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.HOME_EXPORT: {
				HomeExport homeExport = (HomeExport)theEObject;
				T result = caseHomeExport(homeExport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FACTORY_DCL: {
				FactoryDcl factoryDcl = (FactoryDcl)theEObject;
				T result = caseFactoryDcl(factoryDcl);
				if (result == null) result = caseHomeExport(factoryDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FINDER_DCL: {
				FinderDcl finderDcl = (FinderDcl)theEObject;
				T result = caseFinderDcl(finderDcl);
				if (result == null) result = caseHomeExport(finderDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseDefinition(event);
				if (result == null) result = caseTemplateDefinition(event);
				if (result == null) result = caseFixedDefinition(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EVENT_DCL: {
				EventDcl eventDcl = (EventDcl)theEObject;
				T result = caseEventDcl(eventDcl);
				if (result == null) result = caseEvent(eventDcl);
				if (result == null) result = caseDefinition(eventDcl);
				if (result == null) result = caseTemplateDefinition(eventDcl);
				if (result == null) result = caseFixedDefinition(eventDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.STATE_MEMBER: {
				StateMember stateMember = (StateMember)theEObject;
				T result = caseStateMember(stateMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EVENT_FORWARD_DCL: {
				EventForwardDcl eventForwardDcl = (EventForwardDcl)theEObject;
				T result = caseEventForwardDcl(eventForwardDcl);
				if (result == null) result = caseEvent(eventForwardDcl);
				if (result == null) result = caseDefinition(eventForwardDcl);
				if (result == null) result = caseTemplateDefinition(eventForwardDcl);
				if (result == null) result = caseFixedDefinition(eventForwardDcl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PORT_TYPE_DECL: {
				PortTypeDecl portTypeDecl = (PortTypeDecl)theEObject;
				T result = casePortTypeDecl(portTypeDecl);
				if (result == null) result = caseDefinition(portTypeDecl);
				if (result == null) result = caseTemplateDefinition(portTypeDecl);
				if (result == null) result = caseFixedDefinition(portTypeDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PORT_EXPORT: {
				PortExport portExport = (PortExport)theEObject;
				T result = casePortExport(portExport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.PORT_DECL: {
				PortDecl portDecl = (PortDecl)theEObject;
				T result = casePortDecl(portDecl);
				if (result == null) result = caseComponentExport(portDecl);
				if (result == null) result = caseConnectorExport(portDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseDefinition(connector);
				if (result == null) result = caseTemplateDefinition(connector);
				if (result == null) result = caseFixedDefinition(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONNECTOR_HEADER: {
				ConnectorHeader connectorHeader = (ConnectorHeader)theEObject;
				T result = caseConnectorHeader(connectorHeader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONNECTOR_EXPORT: {
				ConnectorExport connectorExport = (ConnectorExport)theEObject;
				T result = caseConnectorExport(connectorExport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TEMPLATE_MODULE: {
				TemplateModule templateModule = (TemplateModule)theEObject;
				T result = caseTemplateModule(templateModule);
				if (result == null) result = caseDefinition(templateModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FORMAL_PARAMETER: {
				FormalParameter formalParameter = (FormalParameter)theEObject;
				T result = caseFormalParameter(formalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FORMAL_PARAMETER_TYPE: {
				FormalParameterType formalParameterType = (FormalParameterType)theEObject;
				T result = caseFormalParameterType(formalParameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TYPENAME_PARAM_TYPE: {
				TypenameParamType typenameParamType = (TypenameParamType)theEObject;
				T result = caseTypenameParamType(typenameParamType);
				if (result == null) result = caseFormalParameterType(typenameParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.INTERFACE_PARAM_TYPE: {
				InterfaceParamType interfaceParamType = (InterfaceParamType)theEObject;
				T result = caseInterfaceParamType(interfaceParamType);
				if (result == null) result = caseFormalParameterType(interfaceParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.VALUETYPE_PARAM_TYPE: {
				ValuetypeParamType valuetypeParamType = (ValuetypeParamType)theEObject;
				T result = caseValuetypeParamType(valuetypeParamType);
				if (result == null) result = caseFormalParameterType(valuetypeParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EVENT_PARAM_TYPE: {
				EventParamType eventParamType = (EventParamType)theEObject;
				T result = caseEventParamType(eventParamType);
				if (result == null) result = caseFormalParameterType(eventParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.STRUCT_PARAM_TYPE: {
				StructParamType structParamType = (StructParamType)theEObject;
				T result = caseStructParamType(structParamType);
				if (result == null) result = caseFormalParameterType(structParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.UNION_PARAM_TYPE: {
				UnionParamType unionParamType = (UnionParamType)theEObject;
				T result = caseUnionParamType(unionParamType);
				if (result == null) result = caseFormalParameterType(unionParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.EXCEPTION_PARAM_TYPE: {
				ExceptionParamType exceptionParamType = (ExceptionParamType)theEObject;
				T result = caseExceptionParamType(exceptionParamType);
				if (result == null) result = caseFormalParameterType(exceptionParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ENUM_PARAM_TYPE: {
				EnumParamType enumParamType = (EnumParamType)theEObject;
				T result = caseEnumParamType(enumParamType);
				if (result == null) result = caseFormalParameterType(enumParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.SEQUENCE_PARAM_TYPE: {
				SequenceParamType sequenceParamType = (SequenceParamType)theEObject;
				T result = caseSequenceParamType(sequenceParamType);
				if (result == null) result = caseFormalParameterType(sequenceParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.CONST_PARAM_TYPE: {
				ConstParamType constParamType = (ConstParamType)theEObject;
				T result = caseConstParamType(constParamType);
				if (result == null) result = caseFormalParameterType(constParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TEMPLATE_DEFINITION: {
				TemplateDefinition templateDefinition = (TemplateDefinition)theEObject;
				T result = caseTemplateDefinition(templateDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FIXED_MODULE: {
				FixedModule fixedModule = (FixedModule)theEObject;
				T result = caseFixedModule(fixedModule);
				if (result == null) result = caseTemplateDefinition(fixedModule);
				if (result == null) result = caseFixedDefinition(fixedModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.FIXED_DEFINITION: {
				FixedDefinition fixedDefinition = (FixedDefinition)theEObject;
				T result = caseFixedDefinition(fixedDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TEMPLATE_MODULE_INST: {
				TemplateModuleInst templateModuleInst = (TemplateModuleInst)theEObject;
				T result = caseTemplateModuleInst(templateModuleInst);
				if (result == null) result = caseDefinition(templateModuleInst);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.ACTUAL_PARAMETER: {
				ActualParameter actualParameter = (ActualParameter)theEObject;
				T result = caseActualParameter(actualParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.TEMPLATE_MODULE_REF: {
				TemplateModuleRef templateModuleRef = (TemplateModuleRef)theEObject;
				T result = caseTemplateModuleRef(templateModuleRef);
				if (result == null) result = caseTemplateDefinition(templateModuleRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IdlPackage.IDL_COMMENT: {
				IDLComment idlComment = (IDLComment)theEObject;
				T result = caseIDLComment(idlComment);
				if (result == null) result = caseDefinition(idlComment);
				if (result == null) result = caseExport(idlComment);
				if (result == null) result = caseComponentExport(idlComment);
				if (result == null) result = casePortExport(idlComment);
				if (result == null) result = caseConnectorExport(idlComment);
				if (result == null) result = caseTemplateDefinition(idlComment);
				if (result == null) result = caseFixedDefinition(idlComment);
				if (result == null) result = caseHomeExport(idlComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecification(Specification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc(Preproc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Include</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Include</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Include(Preproc_Include object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileName(FileName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Ifdef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Ifdef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Ifdef(Preproc_Ifdef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Ifndef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Ifndef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Ifndef(Preproc_Ifndef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Undef</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Undef</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Undef(Preproc_Undef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_If(Preproc_If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc If Compare</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc If Compare</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_If_Compare(Preproc_If_Compare object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc If Val</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc If Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_If_Val(Preproc_If_Val object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Else</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Else</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Else(Preproc_Else object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Error</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Error</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Error(Preproc_Error object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Define</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Define</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Define(Preproc_Define object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Endif</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Endif</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Endif(Preproc_Endif object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma(Preproc_Pragma object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Prefix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Prefix(Preproc_Pragma_Prefix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Lem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Lem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Ciao_Lem(Preproc_Pragma_Ciao_Lem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Ami4ccm Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Ami4ccm Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Ciao_Ami4ccm_Interface(Preproc_Pragma_Ciao_Ami4ccm_Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Ami4ccm Receptacle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Ami4ccm Receptacle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Ciao_Ami4ccm_Receptacle(Preproc_Pragma_Ciao_Ami4ccm_Receptacle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Ami4ccm Idl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Ciao Ami4ccm Idl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Ciao_Ami4ccm_Idl(Preproc_Pragma_Ciao_Ami4ccm_Idl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Ndds</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Ndds</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Ndds(Preproc_Pragma_Ndds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Component(Preproc_Pragma_Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Home</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Home</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Home(Preproc_Pragma_Home object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma DDS4CCM Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma DDS4CCM Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_DDS4CCM_Impl(Preproc_Pragma_DDS4CCM_Impl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preproc Pragma Misc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preproc Pragma Misc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreproc_Pragma_Misc(Preproc_Pragma_Misc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFile_Marker(File_Marker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Excluded File Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Excluded File Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExcluded_File_Marker(Excluded_File_Marker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport_decl(Import_decl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinition(Definition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface or Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface or Forward Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface_or_Forward_Decl(Interface_or_Forward_Decl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface_decl(Interface_decl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forward decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forward decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForward_decl(Forward_decl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface header</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface header</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface_header(Interface_header object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceBody(InterfaceBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Export</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Export</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExport(Export object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attr Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attr Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttrDecl(AttrDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attr Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attr Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttrSpec(AttrSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Only Attr Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Only Attr Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReadOnlyAttrSpec(ReadOnlyAttrSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attr Raises Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attr Raises Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttrRaisesExpr(AttrRaisesExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptionList(ExceptionList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Op Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Op Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpDecl(OpDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Op Type Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Op Type Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpTypeDecl(OpTypeDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Decls</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Decls</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDecls(ParameterDecls object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamDcl(ParamDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextExpr(ContextExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamTypeSpec(ParamTypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scoped Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scoped Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopedName(ScopedName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseTypeSpec(BaseTypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Floating Pt Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Floating Pt Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatingPtType(FloatingPtType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatType(FloatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleType(DoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongDoubleType(LongDoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signed Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signed Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignedInt(SignedInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signed Short Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signed Short Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignedShortInt(SignedShortInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signed Long Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signed Long Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignedLongInt(SignedLongInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signed Long Long Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signed Long Long Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignedLongLongInt(SignedLongLongInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unsigned Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unsigned Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsignedInt(UnsignedInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unsigned Short Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unsigned Short Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsignedShortInt(UnsignedShortInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unsigned Long Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unsigned Long Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsignedLongInt(UnsignedLongInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unsigned Long Long Int</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unsigned Long Long Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsignedLongLongInt(UnsignedLongLongInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Char Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Char Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharType(CharType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wide Char Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wide Char Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWideCharType(WideCharType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Octet Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Octet Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOctetType(OctetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectType(ObjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Base Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Base Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueBaseType(ValueBaseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wide String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wide String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWideStringType(WideStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Except Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Except Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptDecl(ExceptDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMember(Member object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclarator(Declarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleDeclarator(SimpleDeclarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexDeclarator(ComplexDeclarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayDeclarator(ArrayDeclarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructType(StructType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDecl(TypeDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDeclarator(TypeDeclarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSpec(TypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleTypeSpec(SimpleTypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateTypeSpec(TemplateTypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constr Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constr Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstrTypeSpec(ConstrTypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnionType(UnionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Type Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Type Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchTypeSpec(SwitchTypeSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchBody(SwitchBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCase(Case object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseLabel(CaseLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementSpec(ElementSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumType(EnumType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Native Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Native Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNativeType(NativeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Pt Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Pt Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedPtType(FixedPtType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constr Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constr Forward Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstrForwardDecl(ConstrForwardDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Forward Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructForwardDecl(StructForwardDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union Forward Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnionForwardDecl(UnionForwardDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Positive Int Const</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Positive Int Const</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositiveIntConst(PositiveIntConst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstDecl(ConstDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstType(ConstType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Pt Const Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Pt Const Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedPtConstType(FixedPtConstType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstExp(ConstExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrExpr(OrExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XOr Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XOr Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXOrExpr(XOrExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndExpr(AndExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shift Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shift Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShiftExpr(ShiftExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddExpr(AddExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mult Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mult Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultExpr(MultExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpr(UnaryExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimaryExpr(PrimaryExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentDecl(ComponentDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Export</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Export</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentExport(ComponentExport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provides Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provides Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProvidesDcl(ProvidesDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uses Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uses Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsesDcl(UsesDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publishes Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publishes Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishesDcl(PublishesDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Emit Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Emit Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmitDcl(EmitDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consumes Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consumes Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsumesDcl(ConsumesDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Forward Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentForwardDecl(ComponentForwardDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Home Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Home Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomeDecl(HomeDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Key Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Key Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimaryKeySpec(PrimaryKeySpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Home Export</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Home Export</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHomeExport(HomeExport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Factory Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Factory Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFactoryDcl(FactoryDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Finder Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Finder Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinderDcl(FinderDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDcl(EventDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMember(StateMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Forward Dcl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Forward Dcl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventForwardDcl(EventForwardDcl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Type Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Type Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortTypeDecl(PortTypeDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Export</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Export</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortExport(PortExport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortDecl(PortDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Header</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Header</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorHeader(ConnectorHeader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Export</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Export</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorExport(ConnectorExport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateModule(TemplateModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalParameter(FormalParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalParameterType(FormalParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typename Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typename Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypenameParamType(TypenameParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceParamType(InterfaceParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Valuetype Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Valuetype Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValuetypeParamType(ValuetypeParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventParamType(EventParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructParamType(StructParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Union Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Union Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnionParamType(UnionParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExceptionParamType(ExceptionParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumParamType(EnumParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceParamType(SequenceParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstParamType(ConstParamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateDefinition(TemplateDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedModule(FixedModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedDefinition(FixedDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Module Inst</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Module Inst</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateModuleInst(TemplateModuleInst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actual Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actual Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActualParameter(ActualParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Module Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Module Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateModuleRef(TemplateModuleRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDL Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDL Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDLComment(IDLComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //IdlSwitch
