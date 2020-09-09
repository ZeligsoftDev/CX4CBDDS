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
package com.zeligsoft.domain.omg.corba.codegen.xtend;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrDecl;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.IdlFactory;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;

public class XtendUtils {
	
	@SuppressWarnings("nls")
	public static void debug(Object obj ) {
		System.out.println("****** DEBUG ******");
		System.out.println(obj);
		System.out.println("****** END DEBUG ******");
	}
	
	protected static List<Package> fileStack = new ArrayList<Package>();
	
	/*
	 * Return the file stack in a way that doesn't encourage modification.
	 */
	public static Object[] getFileStack() {
		return fileStack.toArray();
	}
	
	public static void generate(Package idlFile) throws Exception {
		generateHelper(idlFile, 
				"com.zeligsoft.domain.omg.corba.codegen", //$NON-NLS-1$
				"workflow/idlFileWorkflow.oaw"); //$NON-NLS-1$
		
	}
	
	protected static void generateHelper(Package idlFile, String bundleName, 
			String workflowPath) {
		for( Package p : fileStack ) {
			if( p == idlFile ) {
				return;
			}
		}

		// Code copied from com.zeligsoft.domain.sca.descriptorgeneration.utils.xtend.
		// Should refactor.
		if (!ZDLUtil.isZDLConcept(idlFile, CXDomainNames.IDLFILE))
		{
			throw new IllegalArgumentException();		
		}
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("modelURI", idlFile.getModel().eResource().getURI().toString()); //$NON-NLS-1$
		
		// Use the location of the original IDL generated.
		IProject project = null;
		if(!fileStack.isEmpty()) {
			project = ProjectFactory.getProject(fileStack.get(0), null, ProjectFactory.MODE_NO_CREATE);
		}
		
		if( project == null || project.getLocation() == null) { 
			return;
		}
		String srcGen = project.getLocation().makeAbsolute().toOSString();		
		parameters.put("src-gen", srcGen);//$NON-NLS-1$
		
		Map<String, Object> slotContents = new HashMap<String, Object>();
		slotContents.put("element", idlFile);//$NON-NLS-1$
		
		Bundle bundle = Platform.getBundle(bundleName); 
		URL workflow = bundle.getResource(workflowPath);
		
		WorkflowUtil.executeWorkflow (workflow, new NullProgressMonitor(), parameters, slotContents);
	}
	
	public static void pushFile(Package idlFile) {
		fileStack.add(idlFile);
	}
	
	public static void popFile(Package idlFile) {
		fileStack.remove(idlFile);
	}
	
	/**
	 * Add a name to the AttrDecl
	 * 
	 * @param attr The AttrDecl that the name is being added to
	 * @param name The name as a String that is being added to the attribute declaration
	 */
	public static void addName(AttrDecl attr, String name){
		attr.getNames().add(name);
	}
	
	/**
	 * Workaround for oaW to return the name of a uml::EnumerationLiteral
	 * 
	 * @param literal The literal whose name you want to retrieve
	 * @return The name of the literal passed in.
	 */
	public static String literalName(EnumerationLiteral literal) {
		return literal.getName();
	}
	
	public static String literalNameHelper(Object literal) {
		return literal.toString();
	}
	
	/**
	 * Workaround for oaW's handling of Enumerations and EnumerationLiterals, that will set
	 * the direction feature of a ParamDcl based on the uml::Parameter's direction literal.
	 * 
	 * @param decl 
	 * 		The parameter declaration to be set
	 * @param literal 
	 * 		The direction that needs to be mapped.
	 */
	public static void setDirection(ParamDcl decl, org.eclipse.uml2.uml.ParameterDirectionKind literal) {
		if(literal.name().equals(org.eclipse.uml2.uml.ParameterDirectionKind.IN_LITERAL.name())){
			decl.setDirection(ParamDirection.IN);
		} 
		else if(literal.name().equals(org.eclipse.uml2.uml.ParameterDirectionKind.OUT_LITERAL.name())) {
			decl.setDirection(ParamDirection.OUT);
		}
		else if(literal.name().equals(org.eclipse.uml2.uml.ParameterDirectionKind.INOUT_LITERAL.name())) {
			decl.setDirection(ParamDirection.IN_OUT);
		}
		else if(literal.name().equals(org.eclipse.uml2.uml.ParameterDirectionKind.RETURN_LITERAL.name())) {
			decl.setDirection(ParamDirection.RETURN);
		}
		else {
			decl.setDirection(null);
		}
	}
	
	/**
	 * Queries the return parameter of given Operation
	 * 
	 * @param op
	 * @return
	 */
	public static Comment getReturnParameterComment(Operation op) {

		for (Parameter p : op.getOwnedParameters()) {
			if (p.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
				if (!p.getOwnedComments().isEmpty()) {
					return p.getOwnedComments().get(0);
				}
				break;
			}
		}
		return UMLFactory.eINSTANCE.createComment();
	}

	/**
	 * Converts a qualified name as modeled in CX to an IDL scoped name that would be accurate in the repository.
	 * This is done by skipping the package and IDLFile parts of the qualified name.
	 * 
	 * @param qualifiedName
	 * @return
	 */
	@SuppressWarnings("nls")
	public static String scopedNameFromNamedElement(NamedElement element) {
	
		String retVal = "";
		NamedElement iterator = element;
		
		while( iterator != null )
		{
			if (iterator instanceof Package
					&& !ZDLUtil.isZDLConcept(iterator,
							CXDomainNames.CXNAMED_ELEMENT)
					|| ZDLUtil.isZDLConcept(iterator,
							CXDomainNames.CXCONSTANTS)) {
				iterator = (NamedElement) iterator.getOwner();
				continue;
			}
			if( ZDLUtil.isZDLConcept(iterator, CXDomainNames.IDLFILE) ||
					!ZDLUtil.isZDLConcept(iterator, CXDomainNames.CXNAMED_ELEMENT))
				break;
			if( retVal != "")
			{
				retVal = "::" + retVal;
			}
			retVal = iterator.getName() + retVal;
			iterator = (NamedElement)iterator.getOwner();
		}
		
		return retVal;
	}
	
	/**
	 * Return the type of the passed CXUnion by getting its switchType attribute.
	 * 
	 * @param datatype
	 * @return
	 */
	public static Type getCORBAUnionType(DataType datatype) {
		for( Property p : datatype.getOwnedAttributes())
		{ 
			if( p.getName().equals("switchType")) //$NON-NLS-1$
			{
				return p.getType();
			}
		}
		return null;
	}
	
	/**
	 * Produces an IDL AttrRaisesExpr object out of a CORBAAttribute's setraises/getraises list.
	 * 
	 * @param exceptionList
	 * @return
	 */
	public static AttrRaisesExpr toAttrRaisesException(Collection<DynamicEObjectImpl> exceptionList) {
		AttrRaisesExpr retVal = IdlFactory.eINSTANCE.createAttrRaisesExpr();
		retVal.setExceptions(IdlFactory.eINSTANCE.createExceptionList());
		// We get passed the stereotype applications as opposed to the DataType, so we'll use UMLUtil to get the base type
		// once we know that we're dealing with a CORBAException.
		for( EObject eobj : exceptionList ) {
			if( eobj != null && ZDLUtil.isZDLConcept(eobj, CXDomainNames.CXEXCEPTION)) {				
				ScopedName scopedName = IdlFactory.eINSTANCE.createScopedName();
				scopedName.getName().add(scopedNameFromNamedElement((NamedElement) eobj));
				retVal.getExceptions().getException().add(scopedName);
			} 
		}
		return retVal;
	}

	public static int getIntValue(String value) {
		return Integer.parseInt(value);
	}
	
	public static String getConstantDefault(Property constant) {
		String value = (String) ZDLUtil.getValue(constant,
				CXDomainNames.CXCONSTANT,
				CXDomainNames.CXCONSTANT__DEFAULT);
		if (constant.getType() != null
				&& ZDLUtil.isZDLConcept(constant.getType(),
						CXDomainNames.CXENUM)) {
			int index = 0;
			for (EnumerationLiteral l : (((Enumeration) constant.getType())
					.getOwnedLiterals())) {
				if (l.getName().equals(value)) {
					return String.valueOf(index);
				}
				index++;
			}
			return UML2Util.EMPTY_STRING;
		}
		return value == null ? UML2Util.EMPTY_STRING : value;
	}
}
