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
package com.zeligsoft.domain.omg.corba.idlimport;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtend.util.stdlib.ExtIssueReporter;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.dsl.idl.AddExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.AndExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ArrayDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.AttrRaisesExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.Case;
import com.zeligsoft.domain.omg.corba.dsl.idl.CaseLabel;
import com.zeligsoft.domain.omg.corba.dsl.idl.ConstExp;
import com.zeligsoft.domain.omg.corba.dsl.idl.ElementSpec;
import com.zeligsoft.domain.omg.corba.dsl.idl.EnumType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ExceptionList;
import com.zeligsoft.domain.omg.corba.dsl.idl.Excluded_File_Marker;
import com.zeligsoft.domain.omg.corba.dsl.idl.File_Marker;
import com.zeligsoft.domain.omg.corba.dsl.idl.Interface_decl;
import com.zeligsoft.domain.omg.corba.dsl.idl.Literal;
import com.zeligsoft.domain.omg.corba.dsl.idl.MultExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.OrExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDcl;
import com.zeligsoft.domain.omg.corba.dsl.idl.ParamDirection;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc;
import com.zeligsoft.domain.omg.corba.dsl.idl.Preproc_Include;
import com.zeligsoft.domain.omg.corba.dsl.idl.PrimaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.ScopedName;
import com.zeligsoft.domain.omg.corba.dsl.idl.SequenceType;
import com.zeligsoft.domain.omg.corba.dsl.idl.ShiftExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.StringType;
import com.zeligsoft.domain.omg.corba.dsl.idl.TypeDeclarator;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnaryExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.UnionType;
import com.zeligsoft.domain.omg.corba.dsl.idl.WideStringType;
import com.zeligsoft.domain.omg.corba.dsl.idl.XOrExpr;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.AnyTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.BooleanTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.CharTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.DoubleTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.FloatTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.LongDoubleTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.ObjectTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.OctetTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongIntImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedLongLongIntImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.SignedShortIntImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.StringTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongIntImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedLongLongIntImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.UnsignedShortIntImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideCharTypeImpl;
import com.zeligsoft.domain.omg.corba.dsl.idl.impl.WideStringTypeImpl;


/**
 * Utility functions for the IDL DSL-to-ZDL M2M transform.
 * 
 * @author smcfee
 *
 */
@SuppressWarnings("nls")
public class XtendUtils {

	private static Package zdlModel = null;
	
	private static Package topLevelPackage = null;
	
	// This list tracks the current stack of files we are processing.
	private static ArrayList<Package> idlFiles = new ArrayList<Package>();
	
	// This list tracks the history of all files we have processed.
	private static ArrayList<Package> visitedFiles = new ArrayList<Package>();
	
	private static ArrayList<ScopeFinder> scopeFinders = new ArrayList<ScopeFinder>();
	
	/**
	 * Apply the IDLFile concept to the top-level package being created.
	 * 
	 * @param p
	 */
	public static void applyIDLFileConcept(Package p)
	{
		ZDLUtil.addZDLConcept(p, CORBADomainNames.IDLFILE);
		topLevelPackage = p;
	} 
	
	public static void setTopLevelPackage(Package p) {
		topLevelPackage = p;
	}
	
	public static void setupZDLModel(Package m) {
		zdlModel = m;
		initializeTypeMap(m);
		idlFiles.clear();
		visitedFiles.clear();
		unresolvedLookups.clear(); 
		scopeFinders.clear();
		IDL2ScopeFinder.INSTANCE().init();
		scopeFinders.add(IDL2ScopeFinder.INSTANCE());
	}
	
	public static void addScope(ScopeFinder finder) {
		scopeFinders.add(finder);
	}

	/**
	 * Set what will be the name of the root IDLFile element.
	 * Takes the last segment of the URI and strips the ".idl" extension.
	 * 
	 * @param p
	 * 		The root IDLFile element.
	 * @param idlFileURI
	 * 		The URI of the IDL input file.
	 */
	public static void setPackageName(Package p, String idlFileURI) {		
		String[] chunks = idlFileURI.split("/"); 
		String filename = chunks[chunks.length - 1];
		p.setName(filename.replace(".idl", ""));
	}
	
	/**
	 * Handle #file directives in a preprocessed IDL file.
	 * 
	 * @param file
	 * @param pkg
	 */
	public static void handleFileMarker(File_Marker file, Package pkg) {
		
		String fileString = file.getFile();
		String fileName = fileString
				.substring(fileString.indexOf(":") + 1,
						fileString.lastIndexOf(":")).replace(".idl", "")
				.replace("\\", "");
		
		if( idlFiles.size() > 1 && fileName.matches(idlFiles.get(idlFiles.size() - 2).getName())) {
			// This is an end-of-file marker. Pop the stack
			idlFiles.remove(idlFiles.size() - 1);
		} else {
			
			Package includeTarget = null;
			
			for( Package visitedFile : visitedFiles ) {
				if( fileName.matches(visitedFile.getName())) {
					includeTarget = visitedFile;
				}
			}
			
			if( includeTarget == null ) {
				// create a new IDLFile
				Package newIDLFile = pkg.createNestedPackage(fileName);
				ZDLUtil.addZDLConcept(newIDLFile, CORBADomainNames.IDLFILE);
				visitedFiles.add(newIDLFile);
				idlFiles.add(newIDLFile);
			} else {
				// set the currently processed file to the previously visited IDLFile
				idlFiles.add(includeTarget);
			}
			
			if( idlFiles.size() > 2 ) {
				// This is an #include. Add the appropriate relationship between the last two IDLFiles processed.
				Dependency dep = idlFiles.get(idlFiles.size() - 2).createDependency(idlFiles.get(idlFiles.size() - 1));
				ZDLUtil.addZDLConcept(dep, CORBADomainNames.IDLIMPORT);
			}			
						
						
		}
	}
	
	/**
	 * Handle #excluded_file directives in a preprocessed IDL file.
	 * 
	 * @param file
	 * @param pkg
	 */
	public static void handleFileMarker(Excluded_File_Marker file, Package pkg) {
		String name = file.getFile().replaceAll("\"", "");
		name = name.substring(0, name.lastIndexOf(".idl"));	
	
		// Attempt to resolve the include with an IDLFile already in the model or one of its package imports.			
		List<NamedElement> foundPackages = findIDLElement(zdlModel, name, CORBADomainNames.IDLFILE);
		if( foundPackages.size() == 0 ) {
			// If the IDLFile was not in the model it may be in one of its package imports.
			for( PackageImport pi : zdlModel.getPackageImports()) {
				foundPackages = findIDLElement(pi.getImportedPackage(), name, CORBADomainNames.IDLFILE);
				if( foundPackages.size() > 0 ) break;
			}
		}
		if( foundPackages.size() > 0 ) {
			Dependency dep = idlFiles.get(idlFiles.size() - 1).createDependency(foundPackages.get(0));
			ZDLUtil.addZDLConcept(dep, CORBADomainNames.IDLIMPORT);
		}
	}
	
	public static Package getCurrentFile() {
		if( idlFiles.size() == 0 ) {
			return topLevelPackage;
		}
		
		return idlFiles.get(idlFiles.size() - 1);
	}
	
	/**
	 * Handle any and all preprocessor directives for an IDL file.
	 * Currently includes are handled and anything else is dropped on the floor.
	 * 
	 * @param p
	 * @param pkg
	 */
	public static void handlePreproc(Preproc p, Package pkg) {
		// All non-includes are currently dropped on the floor.
		if( p instanceof Preproc_Include ) {
			
			Preproc_Include include = (Preproc_Include)p;
			String name = "";
			if( include.getValue() != null) {	// e.g. #include <something>
				// Add the values of the name to a string, omitting only the final ".idl" where applicable. 
				EList<String> namelist = include.getValue().getName();
				for( int i = 0; i < namelist.size(); i++ ) {					
					if( (i + 1) < namelist.size() ||
							namelist.get(i).equals("idl") == false ) {
						if( i > 0 ) name += ".";
						name += namelist.get(i);
					}
				}				
			} else if( include.getStrValue() != null ) {	// e.g. #include "something"
				name = include.getStrValue().replace("\"", "");
				if( name.endsWith(".idl")) {
					// If the include name ends in .idl, trim it.
					name = name.substring(0, include.getStrValue().lastIndexOf(".idl") - 1);
				}
			}
			
			// Attempt to resolve the include with an IDLFile already in the model or one of its package imports.			
			List<NamedElement> foundPackages = findIDLElement(zdlModel, name, CORBADomainNames.IDLFILE);
			if( foundPackages.size() == 0 ) {
				// If the IDLFile was not in the model it may be in one of its package imports.
				for( PackageImport pi : zdlModel.getPackageImports()) {
					foundPackages = findIDLElement(pi.getImportedPackage(), name, CORBADomainNames.IDLFILE);
					if( foundPackages.size() > 0 ) break;
				}
			}						
			if( foundPackages.size() > 0 ) {
				// Should warn if the size is greater than 1.
				Dependency dep = pkg.createDependency(foundPackages.get(0));
				ZDLUtil.addZDLConcept(dep, CORBADomainNames.IDLIMPORT);
				dep.setName(name);
			} else {
				ExtIssueReporter.reportError("Failed to resolve #include of " + name);
			}			
		} 
	}
	
	/**
	 * Given a package, search its contents for an IDL element matching the name and concept.
	 * 
	 * There may be some wheel reinvention taking place in this function; it's an awful lot like a generic search.
	 * 
	 * @param root
	 * 		Package to search.
	 * @param name
	 * 		Name of the IDLFile we hope to find.
	 * @return
	 */
	private static List<NamedElement> findIDLElement(Package root, String name, String concept) {
		List<NamedElement> returnValue = new ArrayList<NamedElement>();
		
		for( TreeIterator<?> iter = EcoreUtil.getAllContents(root, true); iter.hasNext(); ) {
			Object next = iter.next();
			if( ZDLUtil.isZDLConcept((EObject)next, concept)) {
				if( ((NamedElement)next).getName().equals(name) ) {						
					returnValue.add((NamedElement)next);
				}
			}	
		}				
		
		return returnValue;
	}
	
	/**
	 * Adds generalization relationships to an imported interface.
	 *  
	 * @param zdlIntf
	 * 		The ZDL interface being created.
	 * @param idlIntf
	 * 		The IDL interface being read.
	 */
	public static void addInterfaceGeneralizations(Interface zdlIntf, Interface_decl idlIntf) {
		for( ScopedName name : idlIntf.getHeader().getSpecializes()) {
			Type type = getType(zdlIntf, name);
			if( type != null && type instanceof Interface) {
				zdlIntf.createGeneralization((Classifier)type);			
			} else {
				unresolvedLookups.put(zdlIntf, name, unresolvedLookups.LookupContext.GENERALIZATION);
			}
		}
	}
	
	/**
	 * API to set the type of a typed element. 
	 *  
	 * Attempts to resolve the lookup argument, which could be a native type or a scoped name.
	 * If it succeeds, it sets the element's type. If it fails, it adds the lookup to a list of unresolved lookups.
	 * 
	 * @param element
	 * @param typeString
	 */
	public static void setType(TypedElement element, Object typeString) {
		Type type = getType(element, typeString);
		if( type != null) {
			element.setType(type);
		} else if( typeString instanceof ScopedName ) {
			unresolvedLookups.put(element, (ScopedName)typeString, unresolvedLookups.LookupContext.TYPED_ELEMENT_TYPE);
		}
	}
	
	/**
	 * Same function as above, but works on an operation, which sadly does not inherit from TypedElement.
	 * 
	 * @param element
	 * @param typeString
	 */
	public static void setType(Operation element, Object typeString ) {
		Type type = getType(element, typeString);
		if( type != null) {
			element.setType(type);
		} else if( typeString instanceof ScopedName ) {
			unresolvedLookups.put(element, (ScopedName)typeString, unresolvedLookups.LookupContext.TYPED_ELEMENT_TYPE);
		}
	}
	
	/**
	 * Exceptions never use a fully scoped name. They are parsed in as simple identifiers, so this function converts each
	 * one to a ScopedName so that the general getType() API can be used to look up the CORBAException.
	 * 
	 * @param element
	 * @param exc
	 */
	@SuppressWarnings("unchecked")
	public static void addGetRaises(Property element, AttrRaisesExpr attrRaisesExpr) {
		
		ExceptionList exc = attrRaisesExpr.getExceptions();
		for( ScopedName scopedName : exc.getException()) {	
			Type type = getType(element, scopedName);
			if( type != null && ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAEXCEPTION) 
					&& ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBAATTRIBUTE)) {
				((List<EObject>)ZDLUtil.getValue(element, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__GETRAISES)).add(type);	
			} else {
				unresolvedLookups.put(element, scopedName, unresolvedLookups.LookupContext.ATTRIBUTE_GET_RAISES_EXCEPTION);
			}
		}
	}
	
	/**
	 * Exceptions never use a fully scoped name. They are parsed in as simple identifiers, so this function converts each
	 * one to a ScopedName so that the general getType() API can be used to look up the CORBAException.
	 * 
	 * @param element
	 * @param exc
	 */
	@SuppressWarnings("unchecked")
	public static void addSetRaises(Property element, AttrRaisesExpr attrRaisesExpr) {
		
		ExceptionList exc = attrRaisesExpr.getExceptions();
		for( ScopedName scopedName : exc.getException()) {	
			Type type = getType(element, scopedName);
			if( type != null && ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAEXCEPTION) 
					&& ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBAATTRIBUTE)) {
				((List<EObject>)ZDLUtil.getValue(element, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__SETRAISES)).add(type);	
			} else {
				unresolvedLookups.put(element, scopedName, unresolvedLookups.LookupContext.ATTRIBUTE_SET_RAISES_EXCEPTION);
			}
		}
	}
	
	/**
	 * Exceptions never use a fully scoped name. They are parsed in as simple identifiers, so this function converts each
	 * one to a ScopedName so that the general getType() API can be used to look up the CORBAException.
	 * 
	 * @param element
	 * @param exc
	 */
	public static void addRaisedExceptions(Operation element, ExceptionList exc) {
		
		for( ScopedName scopedName : exc.getException()) {	
			Type type = getType(element, scopedName);
			if( type != null && ZDLUtil.isZDLConcept(type, CORBADomainNames.CORBAEXCEPTION)) {
				element.getRaisedExceptions().add(type);			
			} else {
				unresolvedLookups.put(element, scopedName, unresolvedLookups.LookupContext.OPERATION_EXCEPTION);
			}
		}
	}
	
	
	/**
	 * Set the direction of a ZDL parameter based on the IDL ParamDcl read in.
	 * 
	 * @param param
	 * @param decl
	 */
	public static void setDirection(Parameter param, ParamDcl decl) {
		if( decl.getDirection() == ParamDirection.IN)
		{
			param.setDirection(ParameterDirectionKind.IN_LITERAL);
		}
		else if( decl.getDirection() == ParamDirection.OUT)
		{
			param.setDirection(ParameterDirectionKind.OUT_LITERAL);
		}
		else if( decl.getDirection() == ParamDirection.IN_OUT)
		{
			param.setDirection(ParameterDirectionKind.INOUT_LITERAL);
		}
		else
		{
			param.setDirection(null);
		}
	}
	
	/**
	 * Add a CORBAConstant to a CORBAModule or IDLFile
	 * 
	 * @param pkg
	 * @param constant
	 */
	public static void addConstant(Package pkg, Property constant) {
		if( ZDLUtil.isZDLConcept(constant, CORBADomainNames.CORBACONSTANT)) {
			org.eclipse.uml2.uml.Class corbaConstants = null;
			for( PackageableElement p : pkg.getPackagedElements()) {
				if( ZDLUtil.isZDLConcept(p, CORBADomainNames.CORBACONSTANTS)) {
					corbaConstants = (org.eclipse.uml2.uml.Class)p;
				}
			}
			if( corbaConstants == null ) {
				corbaConstants = UMLFactory.eINSTANCE.createClass();
				corbaConstants.setName(pkg.getName() + "_Constants");
				pkg.getPackagedElements().add(corbaConstants);
				ZDLUtil.addZDLConcept(corbaConstants, CORBADomainNames.CORBACONSTANTS);				
			}
			corbaConstants.getOwnedAttributes().add(constant);
		} else {
			throw new IllegalArgumentException("This method is only to be used to add a CORBAConstant.");
		}
	}
	
	/**
	 * Retrieve the ScopedName value of const expression
	 * 
	 * @param expression
	 * @return
	 */
	public static ScopedName getConstScopeName(ConstExp expression) {
		if (expression instanceof OrExpr) {
			Object val = ((OrExpr) expression).getLhs().getLhs().getLhs()
					.getLhs().getLhs().getLhs().getExpr();
			if (val instanceof ScopedName) {
				return (ScopedName) val;
			}
		}
		return null;
	}

	
	/**
	 * Retrieve the value of a const expression, Java version.
	 * All ConstExp should have a top-level type of OrExpr which contains the other types 
	 * within it, so we only need to check for type OrExpr in this method
	 * 
	 * @param exp
	 * @return
	 */
	public static String getConstValue(ConstExp expression) {
		// Need to configure the metamodels in order to call back into Xtend.
		// See oAW 4.3 Reference, 5.5.8
		//XtendFacade f = XtendFacade.create("template::idlimport");
		//String s = (String)f.call("getConstValue",new Object[]{exp});
		
		if (expression instanceof OrExpr){
			return getConstValue((OrExpr)expression);
		}
		else return "";
	}
	
	/**
	 * Returns the string value of an Or expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(OrExpr expression) {
		String retVal = getConstValue(expression.getLhs());
		if( expression.getRhs() != null) {
			retVal += " " + expression.getOp() + " " + getConstValue(expression.getRhs());
		}
		return retVal;
	}
	
	/**
	 * Returns the string value of an exclusive Or expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(XOrExpr expression) {
		String retVal = getConstValue(expression.getLhs());
		if( expression.getRhs() != null) {
			retVal += " " + expression.getOp() + " " + getConstValue(expression.getRhs());
		}
		return retVal;
	}
	
	/**
	 * Returns the string value of an and expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(AndExpr expression) {
		String retVal = getConstValue(expression.getLhs());
		if( expression.getRhs() != null) {
			retVal += " " + expression.getOp() + " " + getConstValue(expression.getRhs());
		}
		return retVal;
	}
	
	/**
	 * Returns the string value of an shift expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(ShiftExpr expression) {
		String retVal = getConstValue(expression.getLhs());
		if( expression.getRhs() != null) {
			retVal += " " + expression.getOp() + " " + getConstValue(expression.getRhs());
		}
		return retVal;
	}
		
	/**
	 * Returns the string value of an addition expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(AddExpr expression) {		
		String retVal = getConstValue(expression.getLhs());
		if( expression.getRhs() != null) {
			retVal += " " + expression.getOp() + " " + getConstValue(expression.getRhs());
		}
		return retVal;
	}
	
	/**
	 * Returns the string value of a multiplication expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(MultExpr expression) {
		String retVal = getConstValue(expression.getLhs());
		if( expression.getRhs() != null) {
			retVal += " " + expression.getOp() + " " + getConstValue(expression.getRhs());
		}
		return retVal;
	}
	
	/**
	 * Returns the string value of a unary expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(UnaryExpr expression) {
		String retVal = getConstValue(expression.getExpr());
		if (expression.getOp() != null) {
			retVal = expression.getOp() + "" + retVal; 
		}
		return retVal;
	}
	
	/**
	 * Returns the string value of a primary expression.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(PrimaryExpr expression) {
		if( expression instanceof Literal ) {
			return getConstValue((Literal)expression);
		} else if( expression instanceof ScopedName) {
			return getConstValue((ScopedName)expression);
		} else if ( expression instanceof ConstExp) {
			return "(" + getConstValue((ConstExp) expression) + ")";
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Returns the string value of a literal, stripping extra quotes.
	 * 
	 * @param expression
	 * @return
	 */
	public static String getConstValue(Literal expression) {
		return expression.getValue().replace("\"", "").replace("'", "");
	}
	
	/**
	 * Returns the string value of a scoped name.
	 * 
	 * @param scopedName
	 * @return
	 */
	public static String getConstValue(ScopedName scopedName) {
		String retVal = "";
		for( String s : scopedName.getName()) {
			if( retVal != "") retVal += "::";
			retVal += s;
		}
		return retVal;
	}

	/**
	 * Adds the enumeration literals to a ZDL enum from an IDL EnumType. 
	 * Needed to work around oAW's handling of enumeration literals.
	 * 
	 * @param zdlEnum
	 * @param idlEnum
	 */
	public static void addLiterals(Enumeration zdlEnum, EnumType idlEnum) {
		for( String s : idlEnum.getLiteral())
		{
			EnumerationLiteral literal = zdlEnum.createOwnedLiteral(s);
			literal.getClassifiers().add(zdlEnum);
		}
	}

	/**
	 * Return list of bounds from ArrayDeclarator
	 * 
	 * @param object
	 * @param typedecl
	 * @return
	 */
	public static List<Object> getArrayBounds(NamedElement object,
			ArrayDeclarator typedecl) {
		List<Object> result = new ArrayList<Object>();
		for (int i = 0; i < typedecl.getSize().size(); i++) {
			EObject newBound = ZDLUtil.createZDLConcept(object,
					CORBADomainNames.CORBABOUND);
			ConstExp exp = typedecl.getSize().get(i);
			ScopedName sname = getConstScopeName(exp);
			if (sname != null) {
				EObject constant = null;
				if (ZDLUtil.isZDLConcept(object, CORBADomainNames.CORBAFIELD)) {
					constant = getType((Element) object.eContainer(), sname,
							false);
				} else {
					constant = getType(object, sname, false);
				}
				if (constant != null) {
					ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
							CORBADomainNames.CORBABOUND__CONSTANT, constant);
				} else {
					String scopedNameString = getConstValue(sname);
					ExtIssueReporter.reportError("Element "
							+ object.getQualifiedName()
							+ " failed to resolve lookup for "
							+ scopedNameString);
				}
			} else {
				String bound = getConstValue(exp);
				ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
						CORBADomainNames.CORBABOUND__VALUE, bound);
			}
			result.add(newBound);
		}
		return result;
	}
	
	/**
	 * Applies the appropriate concept (Typedef, Sequence, or Array) to an incoming TypeDeclarator.
	 * Implemented in Java because it is fairly painful to do this in Xtend.
	 * The owned attribute creation may also not work if done purely in Xtend.
	 * 
	 * @param d
	 * @param typedecl
	 */
	@SuppressWarnings("unchecked")
	public static void applyTypedefConcept(DataType d, TypeDeclarator typedecl) {
		
		if( typedecl.getType() instanceof SequenceType )
		{ 
			ZDLUtil.addZDLConcept(d, CORBADomainNames.CORBASEQUENCE);
			Property newProperty = d.createOwnedAttribute("members", null);
			setType(newProperty, ((SequenceType)typedecl.getType()).getType());
			if( ((SequenceType)typedecl.getType()).getSize() != null ) {
				ConstExp constExp = ((SequenceType)typedecl.getType()).getSize().getExp();
				ScopedName sname = getConstScopeName(constExp);
				Element constant = null;
				if(sname != null) {
					constant = getType(d, sname, false);
				}
				EObject newBound = ZDLUtil.createZDLConcept(d,
						CORBADomainNames.CORBABOUND);
				if(constant != null){
					ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
							CORBADomainNames.CORBABOUND__CONSTANT, constant);
				} else {
					String bound = getConstValue(constExp);
					ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
						CORBADomainNames.CORBABOUND__VALUE, bound);
				}
				ZDLUtil.setValue(d, CORBADomainNames.CORBASEQUENCE,
						CORBADomainNames.CORBASEQUENCE__BOUNDS, newBound);
			}
		} else if( typedecl.getDeclarators().get(0) instanceof ArrayDeclarator ) {
			ZDLUtil.addZDLConcept(d, CORBADomainNames.CORBAARRAY);
			Property newProperty = d.createOwnedAttribute("members", null);
			setType(newProperty, typedecl.getType());
			List<Object> list = (List<Object>) ZDLUtil.getValue(d,
					CORBADomainNames.CORBAARRAY,
					CORBADomainNames.CORBAARRAY__BOUNDS);
			list.addAll(getArrayBounds(d, (ArrayDeclarator) typedecl
					.getDeclarators().get(0)));
		} else if( typedecl.getType() instanceof StringType && ((StringType)typedecl.getType()).getSize() != null ) {
			ZDLUtil.addZDLConcept(d, CORBADomainNames.CORBASTRING);
			StringType s = (StringType)typedecl.getType();
			EObject newBound = ZDLUtil.createZDLConcept(d,
					CORBADomainNames.CORBABOUND);
			ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
					CORBADomainNames.CORBABOUND__VALUE, getConstValue(s
							.getSize().getExp()));
			ZDLUtil.setValue(d, CORBADomainNames.CORBASTRING,
					CORBADomainNames.CORBABOUNDED__BOUNDS, newBound);
		} else if( typedecl.getType() instanceof WideStringType && ((WideStringType)typedecl.getType()).getSize() != null ) {
			ZDLUtil.addZDLConcept(d, CORBADomainNames.CORBAWSTRING);
			WideStringType s = (WideStringType) typedecl.getType();
			EObject newBound = ZDLUtil.createZDLConcept(d,
					CORBADomainNames.CORBABOUND);
			ZDLUtil.setValue(newBound, CORBADomainNames.CORBABOUND,
					CORBADomainNames.CORBABOUND__VALUE, getConstValue(s
							.getSize().getExp()));
			ZDLUtil.setValue(d, CORBADomainNames.CORBAWSTRING,
					CORBADomainNames.CORBABOUNDED__BOUNDS, newBound);
		} else {
			ZDLUtil.addZDLConcept(d, CORBADomainNames.CORBATYPE_DEF);
			Type type = getType(d, typedecl.getType());
			if( type != null) {
				ZDLUtil.setValue(d, CORBADomainNames.CORBATYPE_DEF, CORBADomainNames.CORBATYPE_DEF__TYPE, type);
			} else if( typedecl.getType() instanceof ScopedName) {
				unresolvedLookups.put(d, (ScopedName)typedecl.getType(), unresolvedLookups.LookupContext.TYPEDEF);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void addCORBAUnionAttributes(DataType zdlUnion, UnionType idlUnion) {
		if( ZDLUtil.isZDLConcept(zdlUnion, CORBADomainNames.CORBAUNION) == false) {
			throw new IllegalArgumentException("This method is only to be called for a CORBAUnion.");
		}
		
		Property switchType = zdlUnion.createOwnedAttribute("switchType", null);
		setType(switchType, idlUnion.getSwitch());
		for( Case unionCase : idlUnion.getBody().getCase()) {
			ElementSpec spec = unionCase.getSpec();
			Property unionCaseProperty = zdlUnion.createOwnedAttribute(spec.getDeclarator().getId(), null);
			setType(unionCaseProperty, spec.getType());
			ZDLUtil.addZDLConcept(unionCaseProperty, CORBADomainNames.CORBACASE);
			for( CaseLabel unionCaseLabel : unionCase.getLabel()) {				
				if( unionCaseLabel.isIsDefault()) {
					((List<String>)ZDLUtil.getValue(unionCaseProperty, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL)).add("default");
				} else {
					String labelText = getConstValue(unionCaseLabel.getConstExp());
					((List<String>)ZDLUtil.getValue(unionCaseProperty, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL)).add(labelText);	
				}				
			}
		}
		
	}
	

	
	
	
	/**
	 * Map of primitive types.
	 */
	private static HashMap<Object, Type> typeMap;
	
	/**
	 * Initialize the primitive type map to recognize IDL DSL types and return the corresponding ZDL model library element.
	 * 
	 * TypeCode is not handled because I do not know what it is.
	 */
	private static void initializeTypeMap(Package p) {
		typeMap = new HashMap<Object, Type>();
			
		Package library = null;
		
		for( PackageImport pi : p.getPackageImports()) {
			if( pi.getImportedPackage().getName().equals("CXPrimitives")) {
				library = pi.getImportedPackage();
			}
		}
		
		if( library == null ) {
			throw new IllegalArgumentException("Can only import IDL into a model that contains the CXPrimitives model library.");
		}
				
		typeMap.put(SignedShortIntImpl.class, (DataType)library.getOwnedMember("CXShort"));
		typeMap.put(AnyTypeImpl.class, (DataType)library.getOwnedMember("CXAny"));
		typeMap.put(BooleanTypeImpl.class, (DataType)library.getOwnedMember("CXBoolean"));
		typeMap.put(CharTypeImpl.class, (DataType)library.getOwnedMember("CXChar"));
		typeMap.put(DoubleTypeImpl.class, (DataType)library.getOwnedMember("CXDouble"));
		typeMap.put(FloatTypeImpl.class, (DataType)library.getOwnedMember("CXFloat"));
		typeMap.put(SignedLongIntImpl.class, (DataType)library.getOwnedMember("CXLong"));
		typeMap.put(SignedLongLongIntImpl.class, (DataType)library.getOwnedMember("CXLongLong"));
		typeMap.put(ObjectTypeImpl.class, (DataType)library.getOwnedMember("CXObjref"));
		typeMap.put(OctetTypeImpl.class, (DataType)library.getOwnedMember("CXOctet"));
		typeMap.put(StringTypeImpl.class, (DataType)library.getOwnedMember("CXString"));
		//typeMap.put(TypecodeImpl.class, (DataType)library.getOwnedMember("CXTypecode"));
		typeMap.put(UnsignedLongIntImpl.class, (DataType)library.getOwnedMember("CXULong"));
		typeMap.put(UnsignedLongLongIntImpl.class, (DataType)library.getOwnedMember("CXULongLong"));
		typeMap.put(UnsignedShortIntImpl.class, (DataType)library.getOwnedMember("CXUShort"));
		typeMap.put(WideCharTypeImpl.class, (DataType)library.getOwnedMember("CXWChar"));
		typeMap.put(WideStringTypeImpl.class, (DataType)library.getOwnedMember("CXWString"));
		typeMap.put(LongDoubleTypeImpl.class, (DataType)library.getOwnedMember("CXLongDouble"));
				
	}
		
	

	/**
	 * Private class to wrap the set of unresolved lookups. 
	 * Stored as a HashMap where the key is the element requiring the lookup and the value is a list of scoped names 
	 * that were unresolved for that element. 
	 * 
	 * @author smcfee
	 *
	 */
	public static class unresolvedLookups {

		public enum LookupContext {
			// Set the type of a typed element.
			TYPED_ELEMENT_TYPE,
			// Add a generalization (e.g. typedef, interface inheritance)
			GENERALIZATION,
			// Operation raises exception
			OPERATION_EXCEPTION,
			// Attribute setraises
			ATTRIBUTE_SET_RAISES_EXCEPTION,
			// Attribute getraises
			ATTRIBUTE_GET_RAISES_EXCEPTION,
			// Some type of dependency
			DEPENDENCY,
			// Typedef
			TYPEDEF
		}
		
		public static class Lookup {
			public LookupContext context;
			public ScopedName name;
			
			public Lookup(ScopedName name, LookupContext context) {
				this.name = name;
				this.context = context;
			}
		}
		
		/**
		 * Add a key-value pair to the internal hashmap.
		 * 
		 * @param element
		 * @param name
		 */
		public static void put(NamedElement element, ScopedName name, LookupContext context) {
			if( unresolvedLookups.get(element) == null) {
				unresolvedLookups.put(element, new ArrayList<Lookup>());
			}
			unresolvedLookups.get(element).add(new Lookup(name, context));			
		}
		
		/**
		 * Returns the list of unresolved lookups for an element.
		 * 
		 * @param element
		 * @return
		 */
		public static List<Lookup> get(NamedElement element) {
			if( unresolvedLookups.get(element) == null) {
				return new ArrayList<Lookup>();
			}
					
			return unresolvedLookups.get(element);
		}
		
		/**
		 * Returns the set of elements requiring resolution of lookups.
		 * 
		 * @return
		 */
		public static Set<NamedElement> keySet() {
			return unresolvedLookups.keySet();
		}
		
		public static void clear() {
			unresolvedLookups.clear();
		}
		
		/**
		 * Internal map.
		 */
		private static HashMap<NamedElement, List<Lookup>> unresolvedLookups = 
			new HashMap<NamedElement, List<Lookup>>();
	};
	
	/**
	 * General lookup function.
	 * 
	 * IDL uses a combination of lexical and dynamic scoping. The basic resolution of a scoped name is lexical; proceeding from the 
	 * local scope to the next one outward, and so on, as C would do. In addition IDL adds scopes from inherited interfaces, so if
	 * the current scope is defined for an interface, the next lookups to take place will be the scopes of any interfaces inherited
	 * from. In addition, a module-level scope may be shared among a number of files, so when a scope is defined for a module, the
	 * next lookups to take place will be the scopes of any modules that share the same name.
	 * 
	 * More information on how IDL handles scoping is not in the scope of this Javadoc.
	 * 
	 * @param element
	 * 		The element we need to resolve a lookup for.
	 * @param param
	 * 		The scoped name or primitive type to look up.
	 * @return
	 */
	private static Element getType(Element element, Object param, boolean restrictToType)
	{
		if( param == null) {
			return null;
		}
		if( !(param instanceof ScopedName) ) {
			// Look up the parameter's class in the basic typemap and return whatever is found.
			if( typeMap.containsKey(param.getClass()))
			{
				return typeMap.get(param.getClass());
			}
		} else {
			ScopedName typeString = (ScopedName)param;

			for( ScopeFinder finder : scopeFinders ) {
				finder.init();
			}
			
			// Build a scope list. This is done by successively traversing the owners of each scope element, and
			// inserting any scopes needed for inherited interfaces or shared module names.
			ArrayList<Element> scopes = new ArrayList<Element>();
			Element scopeIterator = element.getOwner();
			while( scopeIterator != null ) {
				scopes.add(scopeIterator);
				for( ScopeFinder finder : scopeFinders ) {
					scopes.addAll(finder.findScopes(scopeIterator, typeString));
				}
				scopeIterator = scopeIterator.getOwner();
			}
			
			
			
			// Starting with the local scope, attempt to resolve the scoped name.
			for( Element scope : scopes ) {
				boolean found = true;
				Element e = scope;

				// The scoped name can be atomic ("Properties") or qualified ("CF::Properties"). The latter case requires that
				// we can match each segment of the scoped name. 
				for( String s : typeString.getName() ) {
					boolean localfound = false;
					for( Element subElement : e.getOwnedElements() ) {
						if( subElement instanceof NamedElement
								&& !(ZDLUtil.isZDLConcept(subElement, CORBADomainNames.IDLIMPORT))
								&& ((NamedElement)subElement).getName() != null // e.g. operation return parameter
							) {
							
							if (ZDLUtil.isZDLConcept(subElement,
									CORBADomainNames.CORBACONSTANTS)) {
								for (Property attr : ((Classifier) subElement)
										.getAllAttributes()) {
									if (ZDLUtil.isZDLConcept(attr,
											CORBADomainNames.CORBACONSTANT)
											&& attr.getName().equals(s)) {
										e = attr;
										localfound = true;
										break;
									}
								}
								if (localfound) {
									break;
								}
							}
							if (((NamedElement)subElement).getName().equals(s)) {
							e = subElement;
							localfound = true;
							break;
						} 
							//check to see if one of the enclosed packages contains the element if subElement is a package
							//with no stereotypes applied
							else if (subElement instanceof Package && subElement.getAppliedStereotypes().isEmpty()){ 
								Element retVal = recurseResolveScope(subElement, s);
								if (retVal != null) {
									e = retVal;
									localfound = true;
									break;
					}
							}
						} 
					}
					if(!localfound) {
						// If any part of the scoped name is not resolved, the scoped name as a whole was not resolved.
						found = false;
						break; // failed to find in this scope
					}					
				}
				if( (found) && (restrictToType == false || e instanceof Type)) {
					return e;
				}
				// Go to the next scope.
				scope = scope.getOwner();
			}
		}
		
		return null;
	}
	
	/**
	 * Helper lookup function.
	 * 
	 * There are situations where the element we are looking for is
	 * not enclosed directly in scope preceding it - in that case, we
	 * need to examine the packages contained in the preceding scope to
	 * see if it exists in one of the packages further down.
	 * 
	 * From bug#15757, "In DDS4CCM support is added for a UML package 
	 * contained under a CORBA Module"
	 *
	 * @param element
	 * 		The element we need to resolve a lookup for.
	 * @param s
	 * 		The scoped name or primitive type to look up.
	 * @return
	 */
	private static Element recurseResolveScope(Element e, String s) {
		for( Element subElement : e.getOwnedElements() ) {
			if( subElement instanceof NamedElement
					&& !(ZDLUtil.isZDLConcept(subElement, CORBADomainNames.IDLIMPORT))
					&& ((NamedElement)subElement).getName() != null ) {
				if (((NamedElement)subElement).getName().equals(s) ) {
					return subElement;
				}
				else if (subElement instanceof Package && subElement.getAppliedStereotypes().isEmpty()){
					Element retVal = recurseResolveScope(subElement, s);
					if (retVal != null) {
						return retVal;
					}
				}
			} 
		}
		return null;
	}
	
	/**
	 * This method is used to look up a TypeSpec by scoped name relative to the element passed in.
	 * 
	 * @param element
	 * @param param
	 * @return
	 */
	public static Type getType(Element element, Object param)
	{
		return (Type)getType(element, param, true);
	}
	
	/**
	 * This method should only be used when we need to look something up by scoped name that isn't just a type (e.g. a package). 
	 * Most of the time getType() should be used instead. In certain cases, such as looking up an interface by scoped name, getType
	 * will not work.
	 * 
	 * @param element
	 * @param param
	 * @return
	 */
	public static Element getIDLElement(Element element, Object param) {
		return getType(element, param, false);
	}
	
	/**
	 * Resolve any unresolved lookups.
	 */
	@SuppressWarnings("unchecked")
	public static void resolveUnresolvedLookups() {
			
		for( NamedElement namedElement : unresolvedLookups.keySet()) {
			
			for( unresolvedLookups.Lookup lookup : unresolvedLookups.get(namedElement)) {
				// Call getType again on the element, which should generally work the second time around.
				ScopedName scopedName = lookup.name;
				Type type = getType(namedElement, scopedName);
				if( type != null ) {
					if( namedElement instanceof TypedElement 
							&& lookup.context == unresolvedLookups.LookupContext.TYPED_ELEMENT_TYPE ) {
						TypedElement te = (TypedElement)namedElement;
						te.setType(type);		
					} else if( namedElement instanceof DataType && type instanceof Classifier
							&& lookup.context == unresolvedLookups.LookupContext.GENERALIZATION) {
						DataType dt = (DataType)namedElement;
						dt.createGeneralization((Classifier)type);
					} else if( namedElement instanceof Interface 
							&& lookup.context == unresolvedLookups.LookupContext.GENERALIZATION) {
						// Interface inheritance.
						Interface intf = (Interface)namedElement;
						intf.createGeneralization((Classifier)type);
					} else if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBAOPERATION) 
							&& lookup.context == unresolvedLookups.LookupContext.TYPED_ELEMENT_TYPE) {
							((Operation)namedElement).setType(type);
					} else if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBAOPERATION)
							&& lookup.context == unresolvedLookups.LookupContext.OPERATION_EXCEPTION ) {
						((Operation)namedElement).getRaisedExceptions().add(type);
					} else if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBAATTRIBUTE) 
							&& lookup.context == unresolvedLookups.LookupContext.ATTRIBUTE_GET_RAISES_EXCEPTION ) {
						((List<EObject>)ZDLUtil.getValue(namedElement, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__GETRAISES)).add(type);
					} else if( ZDLUtil.isZDLConcept(namedElement, CORBADomainNames.CORBAATTRIBUTE) 
							&& lookup.context == unresolvedLookups.LookupContext.ATTRIBUTE_SET_RAISES_EXCEPTION ) {
						((List<EObject>)ZDLUtil.getValue(namedElement, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__SETRAISES)).add(type);
					} else if( lookup.context == unresolvedLookups.LookupContext.TYPEDEF) {
						ZDLUtil.setValue(namedElement, CORBADomainNames.CORBATYPE_DEF, CORBADomainNames.CORBATYPE_DEF__TYPE, type);
					}
				} else {
					String scopedNameString = getConstValue(scopedName);					
					ExtIssueReporter.reportError("Element " + namedElement.getQualifiedName().replace("test::", "") + " failed to resolve lookup for " + scopedNameString);
				}
			}
		}		
	}
}