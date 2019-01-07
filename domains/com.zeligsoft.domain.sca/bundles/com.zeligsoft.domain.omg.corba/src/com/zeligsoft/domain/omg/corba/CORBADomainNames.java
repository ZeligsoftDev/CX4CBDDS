/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.omg.corba;

/**
 * Constants for the ZDL model CORBADomain
 * @generated
 *
 */
public final class CORBADomainNames {

	private CORBADomainNames() {
		super();
	}

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAAnonymousArray. 
	 * @generated
	 */
	public static final String CORBAANONYMOUS_ARRAY = "CORBADomain::IDL::CORBAAnonymousArray";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAAnonymousSequence. 
	 * @generated
	 */
	public static final String CORBAANONYMOUS_SEQUENCE = "CORBADomain::IDL::CORBAAnonymousSequence";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAArray. 
	 * @generated
	 */
	public static final String CORBAARRAY = "CORBADomain::IDL::CORBAArray";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAArray::bounds. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static final String CORBAARRAY__BOUNDS = "bounds";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: CORBAArray::index. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBAARRAY__INDEX = "index";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAAttribute. 
	 * @generated
	 */
	public static final String CORBAATTRIBUTE = "CORBADomain::IDL::CORBAAttribute";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBAAttribute::getraises. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAATTRIBUTE__GETRAISES = "getraises";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAAttribute::isReadOnly. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAATTRIBUTE__IS_READ_ONLY = "isReadOnly";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAAttribute::owner. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAATTRIBUTE__OWNER = "owner";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAAttribute::setraises. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAATTRIBUTE__SETRAISES = "setraises";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBABound. 
	 * @generated
	 */
	public static final String CORBABOUND = "CORBADomain::IDL::CORBABound";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBABound::constant. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBABOUND__CONSTANT = "constant";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: CORBABound::value. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBABOUND__VALUE = "value";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBABounded. 
	 * @generated
	 */
	public static final String CORBABOUNDED = "CORBADomain::IDL::CORBABounded";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBABounded::bound. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBABOUNDED__BOUND = "bound";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: CORBABounded::bounds. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBABOUNDED__BOUNDS = "bounds";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBABoxedValue. 
	 * @generated
	 */
	public static final String CORBABOXED_VALUE = "CORBADomain::IDL::CORBABoxedValue";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBACase. 
	 * @generated
	 */
	public static final String CORBACASE = "CORBADomain::IDL::CORBACase";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBACase::label. 
	 * Lower: 1 Upper: * 
	 * @generated
	 */
	public static final String CORBACASE__LABEL = "label";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAClassifier. 
	 * @generated
	 */
	public static final String CORBACLASSIFIER = "CORBADomain::IDL::CORBAClassifier";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAClassifier::contents. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBACLASSIFIER__CONTENTS = "contents";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: CORBAClassifier::ownedAttribute. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBACLASSIFIER__OWNED_ATTRIBUTE = "ownedAttribute";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: CORBAClassifier::ownedConstants. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBACLASSIFIER__OWNED_CONSTANTS = "ownedConstants";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: CORBAClassifier::ownedOperation. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBACLASSIFIER__OWNED_OPERATION = "ownedOperation";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAClassifierContained. 
	 * @generated
	 */
	public static final String CORBACLASSIFIER_CONTAINED = "CORBADomain::IDL::CORBAClassifierContained";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAConstant. 
	 * @generated
	 */
	public static final String CORBACONSTANT = "CORBADomain::IDL::CORBAConstant";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBAConstant::default. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBACONSTANT__DEFAULT = "default";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAConstants. 
	 * @generated
	 */
	public static final String CORBACONSTANTS = "CORBADomain::IDL::CORBAConstants";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAConstructed. 
	 * @generated
	 */
	public static final String CORBACONSTRUCTED = "CORBADomain::IDL::CORBAConstructed";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBADefault. 
	 * @generated
	 */
	public static final String CORBADEFAULT = "CORBADomain::IDL::CORBADefault";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAEnum. 
	 * @generated
	 */
	public static final String CORBAENUM = "CORBADomain::IDL::CORBAEnum";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAException. 
	 * @generated
	 */
	public static final String CORBAEXCEPTION = "CORBADomain::IDL::CORBAException";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAException::members. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAEXCEPTION__MEMBERS = "members";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAField. 
	 * @generated
	 */
	public static final String CORBAFIELD = "CORBADomain::IDL::CORBAField";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBAField::bound. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBAFIELD__BOUND = "bound";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: CORBAField::bounds. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAFIELD__BOUNDS = "bounds";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAInterface. 
	 * @generated
	 */
	public static final String CORBAINTERFACE = "CORBADomain::IDL::CORBAInterface";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAInterface::generals. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAINTERFACE__GENERALS = "generals";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: CORBAInterface::isAbstract. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAINTERFACE__IS_ABSTRACT = "isAbstract";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAInterface::isAsynchronous. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAINTERFACE__IS_ASYNCHRONOUS = "isAsynchronous";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAInterface::isLocal. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAINTERFACE__IS_LOCAL = "isLocal";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAModule. 
	 * @generated
	 */
	public static final String CORBAMODULE = "CORBADomain::IDL::CORBAModule";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAModule::contents. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAMODULE__CONTENTS = "contents";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAModuleContained. 
	 * @generated
	 */
	public static final String CORBAMODULE_CONTAINED = "CORBADomain::IDL::CORBAModuleContained";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBANamedElement. 
	 * @generated
	 */
	public static final String CORBANAMED_ELEMENT = "CORBADomain::IDL::CORBANamedElement";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAOperation. 
	 * @generated
	 */
	public static final String CORBAOPERATION = "CORBADomain::IDL::CORBAOperation";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAOperation::exceptionDef. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAOPERATION__EXCEPTION_DEF = "exceptionDef";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: CORBAOperation::idlType. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBAOPERATION__IDL_TYPE = "idlType";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: CORBAOperation::isOneWay. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAOPERATION__IS_ONE_WAY = "isOneWay";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: CORBAOperation::ownedParameter. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBAOPERATION__OWNED_PARAMETER = "ownedParameter";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: CORBAOperation::owner. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAOPERATION__OWNER = "owner";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAParameter. 
	 * @generated
	 */
	public static final String CORBAPARAMETER = "CORBADomain::IDL::CORBAParameter";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBAParameter::direction. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAPARAMETER__DIRECTION = "direction";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAPrimitive. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE = "CORBADomain::IDL::CORBAPrimitive";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBAPrimitive::type. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAPRIMITIVE__TYPE = "type";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBASequence. 
	 * @generated
	 */
	public static final String CORBASEQUENCE = "CORBADomain::IDL::CORBASequence";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBASequence::bound. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBASEQUENCE__BOUND = "bound";//$NON-NLS-1$  

	/**
	 * ZDL DomainReference: CORBASequence::bounds. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBASEQUENCE__BOUNDS = "bounds";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAString. 
	 * @generated
	 */
	public static final String CORBASTRING = "CORBADomain::IDL::CORBAString";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAStruct. 
	 * @generated
	 */
	public static final String CORBASTRUCT = "CORBADomain::IDL::CORBAStruct";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBAStruct::members. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String CORBASTRUCT__MEMBERS = "members";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBASupports. 
	 * @generated
	 */
	public static final String CORBASUPPORTS = "CORBADomain::IDL::CORBASupports";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBATemplate. 
	 * @generated
	 */
	public static final String CORBATEMPLATE = "CORBADomain::IDL::CORBATemplate";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAType. 
	 * @generated
	 */
	public static final String CORBATYPE = "CORBADomain::IDL::CORBAType";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBATypeDef. 
	 * @generated
	 */
	public static final String CORBATYPE_DEF = "CORBADomain::IDL::CORBATypeDef";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBATypeDef::type. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String CORBATYPE_DEF__TYPE = "type";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBATyped. 
	 * @generated
	 */
	public static final String CORBATYPED = "CORBADomain::IDL::CORBATyped";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: CORBATyped::idlType. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBATYPED__IDL_TYPE = "idlType";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAUnion. 
	 * @generated
	 */
	public static final String CORBAUNION = "CORBADomain::IDL::CORBAUnion";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAUnionField. 
	 * @generated
	 */
	public static final String CORBAUNION_FIELD = "CORBADomain::IDL::CORBAUnionField";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAValue. 
	 * @generated
	 */
	public static final String CORBAVALUE = "CORBADomain::IDL::CORBAValue";//$NON-NLS-1$

	/**
	 * ZDL DomainAttribute: CORBAValue::isAbstract. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAVALUE__IS_ABSTRACT = "isAbstract";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAValue::isCustom. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAVALUE__IS_CUSTOM = "isCustom";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: CORBAValue::isTruncatable. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String CORBAVALUE__IS_TRUNCATABLE = "isTruncatable";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAValueFactory. 
	 * @generated
	 */
	public static final String CORBAVALUE_FACTORY = "CORBADomain::IDL::CORBAValueFactory";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAWString. 
	 * @generated
	 */
	public static final String CORBAWSTRING = "CORBADomain::IDL::CORBAWString";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: CORBAWrapper. 
	 * @generated
	 */
	public static final String CORBAWRAPPER = "CORBADomain::IDL::CORBAWrapper";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: Contained. 
	 * @generated
	 */
	public static final String CONTAINED = "CORBADomain::IDL::Contained";//$NON-NLS-1$

	/**
	 * Fully qualified name for the ZDL DomainConcept: IDLFile. 
	 * @generated
	 */
	public static final String IDLFILE = "CORBADomain::IDLFileSupport::IDLFile";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: IDLFile::contents. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String IDLFILE__CONTENTS = "contents";//$NON-NLS-1$ 

	/**
	 * ZDL DomainReference: IDLFile::importee. 
	 * Lower: 0 Upper: * 
	 * @generated
	 */
	public static final String IDLFILE__IMPORTEE = "importee";//$NON-NLS-1$ 

	/**
	 * ZDL DomainAttribute: IDLFile::location. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String IDLFILE__LOCATION = "location";//$NON-NLS-1$  

	/**
	 * ZDL DomainAttribute: IDLFile::prefix. 
	 * Lower: 0 Upper: 1 
	 * @generated
	 */
	public static final String IDLFILE__PREFIX = "prefix";//$NON-NLS-1$  

	/**
	 * Fully qualified name for the ZDL DomainConcept: IDLImport. 
	 * @generated
	 */
	public static final String IDLIMPORT = "CORBADomain::IDLFileSupport::IDLImport";//$NON-NLS-1$

	/**
	 * ZDL DomainReference: IDLImport::target. 
	 * Multiplicity: 1  
	 * @generated
	 */
	public static final String IDLIMPORT__TARGET = "target";//$NON-NLS-1$ 

	/**
	 * Fully qualified name for the ZDL DomainConcept: Native. 
	 * @generated
	 */
	public static final String NATIVE = "CORBADomain::IDL::Native";//$NON-NLS-1$

	/**
	 * ZDL DomainEnum: CORBAPrimitiveKind. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND = "CORBADomain::IDL::CORBAPrimitiveKind";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAAny. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAANY = "CORBAAny";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBABoolean. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBABOOLEAN = "CORBABoolean";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAChar. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBACHAR = "CORBAChar";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBADouble. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBADOUBLE = "CORBADouble";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAFloat. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAFLOAT = "CORBAFloat";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBALong. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBALONG = "CORBALong";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBALongDouble. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBALONG_DOUBLE = "CORBALongDouble";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBALongLong. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBALONG_LONG = "CORBALongLong";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAObjectRef. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAOBJECT_REF = "CORBAObjectRef";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAOctet. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAOCTET = "CORBAOctet";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAShort. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBASHORT = "CORBAShort";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAString. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBASTRING = "CORBAString";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBATypecode. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBATYPECODE = "CORBATypecode";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAUnsignedLong. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAUNSIGNED_LONG = "CORBAUnsignedLong";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAUnsignedLongLong. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAUNSIGNED_LONG_LONG = "CORBAUnsignedLongLong";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAUnsignedShort. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAUNSIGNED_SHORT = "CORBAUnsignedShort";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAVoid. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAVOID = "CORBAVoid";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAWChar. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAWCHAR = "CORBAWChar";//$NON-NLS-1$

	/**
	 * ZDL DomainEnumLiteral: CORBAPrimitiveKind::CORBAWString. 
	 * @generated
	 */
	public static final String CORBAPRIMITIVE_KIND___CORBAWSTRING = "CORBAWString";//$NON-NLS-1$

}
