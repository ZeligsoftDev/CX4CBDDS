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
package com.zeligsoft.domain.idl3plus.idlimport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Usage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.ActualParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.Connector;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.EventParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameter;
import com.zeligsoft.domain.omg.corba.dsl.idl.FormalParameterType;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlFactory;
import com.zeligsoft.domain.omg.corba.dsl.idl.InterfaceParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ProvidesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.StructParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypenameParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.UsesDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ValuetypeParamType;
import com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr;
import com.zeligsoft.domain.omg.corba.idlimport.XtendUtils;
import com.zeligsoft.domain.omg.corba.idlimport.XtendUtils.unresolvedLookups;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Utility methods for IDL3+ import.
 * 
 * @author smcfee
 *
 */
@SuppressWarnings("nls")
public class ImportUtils {

	/**
	 * Add the IDL3+ Scope to an IDL import operation.
	 */
	public static void addIdl3PlusScope() {
		IDL3PlusScopeFinder.INSTANCE().init();
		XtendUtils.addScope(IDL3PlusScopeFinder.INSTANCE());
	}
	
	/**
	 * Creates a provides relationship under a port type.
	 * 
	 * @param providesDecl
	 * @param zPortType
	 */
	public static void createProvides(
			ProvidesDcl providesDecl,
			org.eclipse.uml2.uml.Class zPortType
			) {
		
		ScopedName name = providesDecl.getType();
		
		if( name != null ) {
			Type type = XtendUtils.getType(zPortType, name);
			if( type != null && ZDLUtil.isZDLConcept(type, CXDomainNames.CXINTERFACE)) {
				zPortType.createInterfaceRealization(providesDecl.getName(), (Interface)type);
			} else {
				unresolvedLookups.put(zPortType, name, unresolvedLookups.LookupContext.DEPENDENCY);
			}
		}
	}
	
	/**
	 * Creates a uses relationship under a port type.
	 * 
	 * @param usesDecl
	 * @param zPortType
	 */
	public static void createUses(
			UsesDcl usesDecl,
			org.eclipse.uml2.uml.Class zPortType
			) {
		
		ScopedName name = usesDecl.getType();
		
		if( name != null ) {
			Type type = XtendUtils.getType(zPortType, name);
			if( type != null && ZDLUtil.isZDLConcept(type, CXDomainNames.CXINTERFACE)) {
				Usage u = zPortType.createUsage((Interface)type);
				u.setName(usesDecl.getName());
			} else {
				unresolvedLookups.put(zPortType, name, unresolvedLookups.LookupContext.DEPENDENCY);
			}
		}
	}
	
	/**
	 * Find a port type with a given scoped name.
	 * 
	 * @param element
	 * @param s
	 * @return
	 */
	public static Class findPortType(Element element, ScopedName s) {
		
		Type portType = XtendUtils.getType(element, s);
		
		return (Class)portType;
	}
	
	/**
	 * Adds generalization relationships to an imported connector.
	 *  
	 * @param zConnector
	 * 		The ZDL connector being created.
	 * @param idlConn
	 * 		The IDL connector being read.
	 */
	public static void addConnectorGeneralization(Component zConnector, Connector idlConn) {
		
		if( idlConn.getHeader().getBase() != null ) {
			Type type = XtendUtils.getType(zConnector, idlConn.getHeader().getBase());
			if( type != null && ZDLUtil.isZDLConcept(type, IDL3PlusNames.CONNECTOR_DEF)) {
				zConnector.createGeneralization((Classifier)type);
			} else {
				unresolvedLookups.put(zConnector, idlConn.getHeader().getBase(), unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}	
	}
	
	/**
	 * Create a template parameter.
	 * 
	 * @param parameter
	 * @param templateModule
	 * @return
	 */
	public static EObject createTemplateParameter(FormalParameter parameter, Package templateModule) {
		return IDL3PlusUtil.INSTANCE.createTemplateParameter(
				templateModule, parameter.getName(), parameterString(parameter.getType()));
	}
	
	private static String parameterString(FormalParameterType o ) {
		if( o instanceof TypenameParamType ) {
			return "typename";
		} else if( o instanceof InterfaceParamType) {
			return "interface";
		} else if( o instanceof ValuetypeParamType) {
			return "valuetype";
		} else if( o instanceof EventParamType) {
			return "eventtype";
		} else if( o instanceof StructParamType) {
			return "struct";
		} else if( o instanceof UnionParamType) {
			return "union";
		} else if( o instanceof ExceptionParamType) {
			return "exception";
		} else if( o instanceof SequenceParamType) {
			return "sequence";
		} else if( o instanceof ConstParamType) {
			return "const";
		} else if( o instanceof SequenceType) {
			return "sequence";
		} else if( o instanceof EnumParamType) {
			return "enum";
		}
		return "";
	}
	
	/*
	 * Aliases
	 */
	public static void createModuleInstantiation(
			com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleRef moduleRef,
			org.eclipse.uml2.uml.Package pkg) {
	
		List<ActualParameter> parameterList = new ArrayList<ActualParameter>();
		for( String str : moduleRef.getId()) {
			ScopedName s = IdlFactory.eINSTANCE.createScopedName();
			s.getName().add(str);
			parameterList.add(encodeScopedName(s));
		}
		createModuleInstantiation(pkg, moduleRef.getType(), parameterList, moduleRef.getName());
			
	}
	
	/*
	 * Module instantiations
	 */
	public static void createModuleInstantiation(
			com.zeligsoft.domain.omg.corba.dsl.idl.TemplateModuleInst moduleInst,
			org.eclipse.uml2.uml.Package pkg) {
		
		createModuleInstantiation(pkg, moduleInst.getType(), moduleInst.getParameter(), moduleInst.getName());
		
	}
	
	/**
	 * Instantiate a template module. Looks up each of the template parameters and creates a map that
	 * can be passed to the existing module instantiation code used in the tool.
	 */
	private static void createModuleInstantiation(
			org.eclipse.uml2.uml.Package pkg,
			ScopedName type,
			List<ActualParameter> parameters,
			String instName) {
		
		Package tempPackage = pkg.createNestedPackage(UUID.randomUUID().toString());
		Package templateModule = (Package)XtendUtils.getIDLElement(tempPackage, type);
		
		if( templateModule == null ) {
			StringBuilder s = new StringBuilder();
			for( String name : type.getName()) {
				if( s.length() > 0 ) {
					s.append("::");
				}
				s.append(name);
			}
			throw new IllegalArgumentException("Cannot find template module to instantiate: " + s.toString());
		}
		
		TemplateParameter[] templateParameters = (TemplateParameter[])templateModule.getOwnedTemplateSignature().getOwnedParameters().toArray();
		//ActualParameter[] actualParameters = (ActualParameter[])parameters.toArray();	
		
		Map<ClassifierTemplateParameter, EObject> instantiationMap = new HashMap<ClassifierTemplateParameter, EObject>();
		for( int i = 0; i < templateParameters.length; i++) {

			Element mapValue = null;
			
			if( parameters.get(i) instanceof OrExpr) {
				// Assume a scoped name
				mapValue = XtendUtils.getIDLElement(tempPackage, extractScopedName(parameters.get(i)));
			} else if( parameters.get(i) instanceof TypeSpec) {
				throw new IllegalArgumentException("I don't know how to instantiate a typespec.");
			}
			
			instantiationMap.put((ClassifierTemplateParameter)templateParameters[i], mapValue);
			
		}
	
		
		EObject newModuleInstantiation = IDL3PlusUtil.INSTANCE.instantiateTemplateModule(				
				pkg, 
				templateModule,
				instantiationMap);
		ZDLUtil.setValue(newModuleInstantiation, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME, instName);
		
		tempPackage.destroy();
		
	}
	
	/**
	 * Currently the assumption is that if a parameter type is an expression, it's actually a scoped name that is wrapped up. 
	 * 
	 * This method does not yet support TypeSpec for a parameter.
	 * 
	 * @param p
	 * @return
	 */
	private static ScopedName extractScopedName(ActualParameter p) {
		if( p instanceof OrExpr ) {
			OrExpr expr = (OrExpr)p;
			
			PrimaryExpr pe = expr.getLhs().getLhs().getLhs().getLhs().getLhs().getLhs().getExpr();
			
			if( pe instanceof ScopedName ) {
				return (ScopedName)pe;
			} 

		}
		return null;
	}
	
	/**
	 * Encode an IDL Scoped Name into an Actual Parameter for use in template module instantiations.
	 * 
	 * @param s
	 * @return
	 */
	private static ActualParameter encodeScopedName(ScopedName s) {
		
		UnaryExpr expr = IdlFactory.eINSTANCE.createUnaryExpr();
		expr.setExpr(s);
		MultExpr mult = IdlFactory.eINSTANCE.createMultExpr();
		mult.setLhs(expr);
		AddExpr add = IdlFactory.eINSTANCE.createAddExpr();
		add.setLhs(mult);
		ShiftExpr shift = IdlFactory.eINSTANCE.createShiftExpr();
		shift.setLhs(add);
		AndExpr and = IdlFactory.eINSTANCE.createAndExpr();
		and.setLhs(shift);
		XOrExpr xor = IdlFactory.eINSTANCE.createXOrExpr();
		xor.setLhs(and);
		OrExpr or = IdlFactory.eINSTANCE.createOrExpr();
		or.setLhs(xor);
		return or;
		
	}
	
}
