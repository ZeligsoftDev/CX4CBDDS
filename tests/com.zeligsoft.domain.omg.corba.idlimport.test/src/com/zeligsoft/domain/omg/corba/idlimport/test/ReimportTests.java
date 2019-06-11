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
package com.zeligsoft.domain.omg.corba.idlimport.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;
import com.zeligsoft.domain.zml.oaw.importutils.ZMLImportUtils;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author smcfee
 *
 * Tests for iterative IDL import. They involve continuously writing over the same IDLFile and 
 * merging model contents together.
 */
@SuppressWarnings("nls")
public class ReimportTests {

	final static String compName = "ReimportTestsModel::Comp::Comp";
	
	public ReimportTests() {
		//super();
	}
	
	private ResourceSet rset;
	
	private Resource res = null;
	
	private Package rootPackage = null;
	
	@Before
	public void setUp()
			throws Exception {

		rset = new ResourceSetImpl();
		refreshModel();
	}
	
	@After
	public void tearDown()
			throws Exception {

		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;
		res = null;
		rootPackage = null;

	}
	
	private void refreshModel() {
		
		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.eAdapters().clear();
		rset = null;
		res = null;
		rootPackage = null;
		
		rset = new ResourceSetImpl();
		res = rset.getResource(URI.createPlatformPluginURI(
				"com.zeligsoft.domain.omg.corba.idlimport.test" + "/models/ReimportTestsModel.emx", true), true);
		assertTrue("Test resource not loaded", res.isLoaded());
		
		rootPackage = (Package) EcoreUtil.getObjectByType(res.getContents(),
				UMLPackage.Literals.PACKAGE);
		assertNotNull("Could not find root package.", rootPackage);
	}
	
	private void importIDL(String fileName)
	{	
		Map<String, String> properties = new HashMap<String, String>();
		WorkflowEngine workflow = new WorkflowEngine();
		Issues issues = new IssuesImpl();
		
		String defaultFlow = "workflow/idlimport.oaw";
		
		properties.put("targetModel", "models/ReimportTestsModel.emx");
		properties.put("profileToApply",
				"pathmap://SCA_PROFILES/SCADomain.profile.uml");
		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		List<String> sourceFileList = new ArrayList<String>();
		
		URI uri = URI.createFileURI(fileName);
		File tempFile = new File(uri.devicePath());
		assertTrue(fileName + " does not exist.", tempFile.exists());
		sourceFileList.add(tempFile.getAbsolutePath());
		externalSlotContents.put("sourceFileList", sourceFileList);
		externalSlotContents.put("rset", rset);			
		
		final boolean configOK = workflow.prepare(defaultFlow, new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow.", configOK); //$NON-NLS-1$
		final boolean executeOK = workflow.executeWorkflow(externalSlotContents, issues);
		assertTrue("Workflow failed due to issues: " + issues.toString(), executeOK && issues.getErrors().length == 0); //$NON-NLS-1$
		
		res = rset.getResource(URI.createURI(
				"models/ReimportTestsModel.emx", true), true);
		
		rootPackage = (Package) EcoreUtil.getObjectByType(res.getContents(),
				UMLPackage.Literals.PACKAGE);
		assertNotNull("Could not find root package.", rootPackage);
		
	}
	
	private List<EObject> findIDLElement(String repositoryId) {
		List<EObject> foundElements = new ArrayList<EObject>();
		
		for( Iterator<EObject> iter = rootPackage.eAllContents(); iter.hasNext();  ) {

			EObject eobj = iter.next();				
			
			if( ZDLUtil.isZDLConcept(eobj, CORBADomainNames.CORBANAMED_ELEMENT)) {
				NamedElement elm = (NamedElement)eobj;
				
				if( repositoryId.equals(CORBAUtil.getRepositoryId(elm))) {
					foundElements.add(eobj);
				}					
			}				
		}
		return foundElements;
	}
	
	private EObject findZMLElement(String qualifiedName) {
		
		Collection<NamedElement> elements = 
			UMLUtil.findNamedElements(res, qualifiedName);
		assertFalse(String.format("Test model does not contain an element to validate, name %s.", qualifiedName), elements.isEmpty());
		return elements.iterator().next();
	}
	
	/**
	 * Add a parameter to IDL through iterative import. Repair worker functions should add a worker function to a 
	 * component with the appropriate port type.
	 * 
	 * To test the remove case, we will reimport the original IDL.
	 */
	@Test
	public void testAddRemoveParameter() {


		List<EObject> opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		Operation op = (Operation)opList.get(0);
		int numParams = op.getOwnedParameters().size();
		
		importIDL("idl/reimport/testAddRemoveParameter/reimport.idl");
		assertEquals("Invalid number of interfaces found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
		opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		assertEquals("Duplicate operation found.",
				1,
				opList.size());
		op = (Operation)opList.get(0);
		assertEquals("Insufficient number of parameters.",
				numParams + 1,
				op.getOwnedParameters().size());
					
		importIDL("idl/reimport/reimport.idl");
		assertEquals("Duplicate interface found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
		opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		assertEquals("Duplicate operation found.",
				1,
				opList.size());
		op = (Operation)opList.get(0);
		assertEquals("Too many parameters.",
				numParams,
				op.getOwnedParameters().size());
	}
	
	/**
	 * Test the addition of each of the following to an existing interface through iterative import:
	 * 1) Operation
	 * 2) Attribute
	 * 3) [...]
	 * No new interface is created.
	 * 
	 * Test the removal of each of these things by reimporting the original IDL.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testModifyInterface() {
			
		EObject comp = findZMLElement(compName);
		// Now count delta between the fun number, 1, and the value from repair to avoid 
		// _ctor and _dtor
		//int workerFunctions = ((List<Operation>)ZDLUtil.getValue(comp, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)).size(); 
		ZMLImportUtils.repairWorkerFunctions((Component)comp);
		
		int repairValuebefore = ((List<Operation>)ZDLUtil.getValue(comp, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)).size();

		importIDL("idl/reimport/testModifyInterface/reimport.idl");	
		comp = findZMLElement(compName);
		ZMLImportUtils.repairWorkerFunctions((Component)comp);
		
		int repairValueadd = ((List<Operation>)ZDLUtil.getValue(comp, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)).size();
		
		assertEquals("Import should have added a worker function to the component.",
				1, repairValueadd - repairValuebefore);
		assertEquals("Duplicate interface found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
		
		importIDL("idl/reimport/reimport.idl");
		comp = findZMLElement(compName);
		ZMLImportUtils.repairWorkerFunctions((Component)comp);
	
		int repairValuerem = ((List<Operation>)ZDLUtil.getValue(comp, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__WORKER)).size();
		assertEquals("Import should have removed a worker function from the component.",
				0, repairValuerem - repairValuebefore);
		assertEquals("Duplicate interface found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
	}
	
	/**
	 * Change the parameter type, direction on an operation through iterative import.
	 * Change an operation to and from oneway.
	 * Change an operation's thrown exception list through iterative import.
	 */
	@Test
	public void testModifyOperation() {
		// ORIG:   long y(in long param1, out float param2) raises( TestException );		
		// IMPORT: oneway void y(out long param1, out short param2) raises( TestException );
		
		List<EObject> opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		Operation op = (Operation)opList.get(0);
		List<Type> types = new ArrayList<Type>();
		types.add(op.getType());
		for( Parameter p : op.getOwnedParameters()) {
			types.add(p.getType());
		}
		ParameterDirectionKind oldDirection = op.getOwnedParameters().get(0).getDirection();
		Object oneway = ZDLUtil.getValue(op, CORBADomainNames.CORBAOPERATION, CORBADomainNames.CORBAOPERATION__IS_ONE_WAY);
		assertEquals("Initial value of oneway is wrong.", oneway, Boolean.FALSE);
		
		importIDL("idl/reimport/testModifyOperation/reimport.idl");
		assertEquals("Duplicate interface found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
		opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		assertEquals("Duplicate operation found.",
				1,
				opList.size());
		op = (Operation)opList.get(0);
		List<Type> newtypes = new ArrayList<Type>();
		newtypes.add(op.getType());
		for( Parameter p : op.getOwnedParameters()) {
			newtypes.add(p.getType());
		}
		assertNotSame("Return type was supposed to change.", types.get(0), newtypes.get(0));
		assertNotSame("Parameter type was supposed to change", types.get(2), newtypes.get(2));
		assertNotSame("Parameter direction was supposed to change", oldDirection, op.getOwnedParameters().get(0).getDirection());
		oneway = ZDLUtil.getValue(op, CORBADomainNames.CORBAOPERATION, CORBADomainNames.CORBAOPERATION__IS_ONE_WAY);
		assertEquals("Value of oneway was supposed to change but did not.", Boolean.TRUE, oneway);
		
		importIDL("idl/reimport/reimport.idl");
	}
	
	/**
	 * Change the type of an attribute through iterative import.
	 * Change the attribute to and from readonly.
	 * Change an attribute's get/set exceptions.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testModifyAttribute() {
	
		List<EObject> attrList = findIDLElement("IDL:Reimport/TestInterface/x:1.0");
		Property attr = (Property)attrList.get(0);
		
		Type type = attr.getType();
		List<String> getraises = new ArrayList<String>(); 
		for( EObject getraise : (List<EObject>)ZDLUtil.getValue(attr, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__GETRAISES) ) {
			getraises.add(CORBAUtil.getRepositoryId((NamedElement)getraise));
		}
		List<String> setraises = new ArrayList<String>(); 
		for( EObject setraise : (List<EObject>)ZDLUtil.getValue(attr, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__SETRAISES) ) {
			setraises.add(CORBAUtil.getRepositoryId((NamedElement)setraise));
		}	
		
		List<EObject> attrListReadonly = findIDLElement("IDL:Reimport/TestInterface/testReadonly:1.0");
		Property attrReadonly = (Property)attrListReadonly.get(0);

		Boolean readonly = attrReadonly.isReadOnly();
		
		importIDL("idl/reimport/testModifyAttribute/reimport.idl");
		assertEquals("Duplicate interface found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
		attrList = findIDLElement("IDL:Reimport/TestInterface/x:1.0");
		assertEquals("Duplicate attribute found.",
				1,
				attrList.size());
		attr = (Property)attrList.get(0);
		assertTrue("Attribute type was supposed to change.", type.getName().matches(attr.getType().getName()) == false);
		
		attrListReadonly = findIDLElement("IDL:Reimport/TestInterface/testReadonly:1.0");
		attrReadonly = (Property)attrListReadonly.get(0);

		assertNotSame("Readonly was supposed to change.", readonly, attrReadonly.isReadOnly());
		for( EObject getraise : (List<EObject>)ZDLUtil.getValue(attr, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__GETRAISES) ) {
			for( String s : getraises ) {
				assertTrue( "Getraises was supposed to change.", s.matches(CORBAUtil.getRepositoryId((NamedElement)getraise)) == false);
			}
		}
		for( EObject setraise : (List<EObject>)ZDLUtil.getValue(attr, CORBADomainNames.CORBAATTRIBUTE, CORBADomainNames.CORBAATTRIBUTE__SETRAISES) ) {
			for( String s : setraises ) {
				assertTrue( "Setraises was supposed to change.", s.matches(CORBAUtil.getRepositoryId((NamedElement)setraise)) == false);
			}
		}	
		
		importIDL("idl/reimport/reimport.idl");
	}
	
	/**
	 * Test the addition of each of the following to an existing module through iterative import:
	 * 1) Interface
	 * 2) Struct
	 * 3) Exception
	 * 4) Enum
	 * 5) Union
	 * 6) Sequence
	 * 7) Typedef
	 * 8) Const
	 * 
	 * Test the removal of each of these things by reimporting the original IDL.
	 */
	@Test
	public void testModifyModule() {
		importIDL("idl/reimport/reimport.idl");
		List<EObject> modules = findIDLElement("IDL:Reimport:1.0");
		assertEquals(2, modules.size());
		Package module = (Package)modules.get(0);
		int numIntf = getPackagedConcepts(module, CORBADomainNames.CORBAINTERFACE).size();
		int numStruct = getPackagedConcepts(module, CORBADomainNames.CORBASTRUCT).size();
		int numExc = getPackagedConcepts(module, CORBADomainNames.CORBAEXCEPTION).size();
		int numEnum = getPackagedConcepts(module, CORBADomainNames.CORBAUNION).size();
		int numUnion = getPackagedConcepts(module, CORBADomainNames.CORBAUNION).size();
		int numSeq = getPackagedConcepts(module, CORBADomainNames.CORBASEQUENCE).size();
		int numTypedef = getPackagedConcepts(module, CORBADomainNames.CORBATYPE_DEF).size();
		EObject corbaConsts = getPackagedConcepts(module, CORBADomainNames.CORBACONSTANTS).get(0);
		int numConsts = ((Class)corbaConsts).getOwnedAttributes().size();
		
		importIDL("idl/reimport/testModifyModule/reimport.idl");
		modules = findIDLElement("IDL:Reimport:1.0");
		assertEquals(2, modules.size());
		module = (Package)modules.get(0);
		assertEquals("Number of interfaces did not grow.", numIntf + 1, getPackagedConcepts(module, CORBADomainNames.CORBAINTERFACE).size());
		assertEquals("Number of structs did not grow.", numStruct + 1, getPackagedConcepts(module, CORBADomainNames.CORBASTRUCT).size());
		assertEquals("Number of exceptions did not grow.", numExc + 1, getPackagedConcepts(module, CORBADomainNames.CORBAEXCEPTION).size());
		assertEquals("Number of enums did not grow.", numEnum + 1, getPackagedConcepts(module, CORBADomainNames.CORBAENUM).size());
		assertEquals("Number of unions did not grow.", numUnion + 1, getPackagedConcepts(module, CORBADomainNames.CORBAUNION).size());
		assertEquals("Number of sequences did not grow.", numSeq + 1, getPackagedConcepts(module, CORBADomainNames.CORBASEQUENCE).size());
		assertEquals("Number of typedefs did not grow.", numTypedef + 1, getPackagedConcepts(module, CORBADomainNames.CORBATYPE_DEF).size());
		corbaConsts = getPackagedConcepts(module, CORBADomainNames.CORBACONSTANTS).get(0);
		assertEquals("Number of constants did not grow.", numConsts + 1, ((Class)corbaConsts).getOwnedAttributes().size());
		
		importIDL("idl/reimport/reimport.idl");
		modules = findIDLElement("IDL:Reimport:1.0");
		assertEquals(2, modules.size());
		module = (Package)modules.get(0);
		assertEquals("Number of interfaces did not shrink.", numIntf, getPackagedConcepts(module, CORBADomainNames.CORBAINTERFACE).size());
		assertEquals("Number of structs did not shrink.", numStruct, getPackagedConcepts(module, CORBADomainNames.CORBASTRUCT).size());
		assertEquals("Number of exceptions did not shrink.", numExc, getPackagedConcepts(module, CORBADomainNames.CORBAEXCEPTION).size());
		assertEquals("Number of enums did not shrink.", numEnum, getPackagedConcepts(module, CORBADomainNames.CORBAENUM).size());
		assertEquals("Number of unions did not shrink.", numUnion, getPackagedConcepts(module, CORBADomainNames.CORBAUNION).size());
		assertEquals("Number of sequences did not shrink.", numSeq, getPackagedConcepts(module, CORBADomainNames.CORBASEQUENCE).size());
		assertEquals("Number of typedefs did not shrink.", numTypedef, getPackagedConcepts(module, CORBADomainNames.CORBATYPE_DEF).size());
		corbaConsts = getPackagedConcepts(module, CORBADomainNames.CORBACONSTANTS).get(0);
		assertEquals("Number of constants did not shrink.", numConsts, ((Class)corbaConsts).getOwnedAttributes().size());
	}
	
	private List<EObject> getPackagedConcepts(Package pkg, String conceptName) {
		List<EObject> retVal = new ArrayList<EObject>();
		
		for( PackageableElement p : pkg.getPackagedElements()) {
			if( ZDLUtil.isZDLConcept(p, conceptName)) {
				retVal.add(p);
			}
		}
		
		return retVal;
	}
	
	/**
	 * Add and remove members from a struct.
	 * Change a struct member's type.
	 */
	@Test
	public void testModifyStruct() {
		
		List<EObject> structs = findIDLElement("IDL:Reimport/TestStruct:1.0");
		assertEquals(1, structs.size());
		DataType struct = (DataType)structs.get(0);
		int numFields = struct.getOwnedAttributes().size();
		String type = struct.getOwnedAttributes().get(0).getType().getName().toString();
		
		importIDL("idl/reimport/testModifyStruct/reimport.idl");
		structs = findIDLElement("IDL:Reimport/TestStruct:1.0");
		assertEquals(1, structs.size());
		struct = (DataType)structs.get(0);
		assertEquals("Number of fields should have increased.", numFields + 1, struct.getOwnedAttributes().size());
		assertTrue("Type should have changed.", type.matches(struct.getOwnedAttributes().get(0).getType().getName().toString()) == false);
		
		importIDL("idl/reimport/reimport.idl");
		structs = findIDLElement("IDL:Reimport/TestStruct:1.0");
		assertEquals(1, structs.size());
		struct = (DataType)structs.get(0);
		assertEquals("Number of fields should have reduced.", numFields, struct.getOwnedAttributes().size());
		assertTrue("Type should have changed.", type.matches(struct.getOwnedAttributes().get(0).getType().getName().toString()));
	}
	
	/**
	 * Add and remove enum fields.
	 */
	@Test
	public void testModifyEnum() {
		
		List<EObject> enums = findIDLElement("IDL:Reimport/TestEnum:1.0");
		assertEquals(1, enums.size());
		Enumeration _enum = (Enumeration)enums.get(0);
		int numLiterals = _enum.getOwnedLiterals().size();
		
		importIDL("idl/reimport/testModifyEnum/reimport.idl");
		enums = findIDLElement("IDL:Reimport/TestEnum:1.0");
		assertEquals(1, enums.size());
		_enum = (Enumeration)enums.get(0);
		assertEquals("Number of literals should have increased by 1.", numLiterals + 1, _enum.getOwnedLiterals().size());
		
		importIDL("idl/reimport/reimport.idl");
		enums = findIDLElement("IDL:Reimport/TestEnum:1.0");
		assertEquals(1, enums.size());
		_enum = (Enumeration)enums.get(0);
		assertEquals("Number of literals should have decreased by 1.", numLiterals, _enum.getOwnedLiterals().size());
		
	}
	
	/**
	 * Add and remove members from a union.
	 * Change a union member's type.
	 * Change a union's switchType.
	 */
	@Test
	public void testModifyUnion() {
		List<EObject> unions = findIDLElement("IDL:Reimport/TestUnion:1.0");
		assertEquals(1, unions.size());
		DataType union = (DataType)unions.get(0);
		String switchTypeName = "";
		for( Property p : union.getOwnedAttributes()) {
			if( ZDLUtil.isZDLConcept(p, CORBADomainNames.CORBACASE)) {
				if( p.getName().matches("mem1")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[1]"));
					assertTrue(p.getType().getName().toString().matches("CORBAString"));
				} else if( p.getName().matches("mem2")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[2]"));
					assertTrue(p.getType().getName().toString().matches("CORBALong"));
				} else if( p.getName().matches("mem3")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[default]"));
					assertTrue(p.getType().getName().toString().matches("CORBAOctet"));
				} else {
					fail("Invalid case statement.");
				}
			} else if( p.getName().matches("switchType")) {
				switchTypeName = p.getType().getName().toString();
			} else {
				fail("Invalid property on a union.");
			}
		}
		
		importIDL("idl/reimport/testModifyUnion/reimport.idl");
		unions = findIDLElement("IDL:Reimport/TestUnion:1.0");
		assertEquals(1, unions.size());
		union = (DataType)unions.get(0);
		for( Property p : union.getOwnedAttributes()) {
			if( ZDLUtil.isZDLConcept(p, CORBADomainNames.CORBACASE)) {
				if( p.getName().matches("mem1")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[1]"));
					assertTrue(p.getType().getName().toString().matches("CORBAString"));
				} else if( p.getName().matches("mem2")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[3]"));
					assertTrue(p.getType().getName().toString().matches("CORBALong"));
				} else if( p.getName().matches("mem3")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[default]"));
					assertTrue(p.getType().getName().toString().matches("CORBAShort"));
				} else if( p.getName().matches("mem4")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[4]"));
					assertTrue(p.getType().getName().toString().matches("CORBAFloat"));
				} else {
					fail("Invalid case statement.");
				}
			} else if( p.getName().matches("switchType")) {
				assertTrue(switchTypeName.matches(p.getType().getName().toString()) == false);
			} else {
				fail("Invalid property on a union.");
			}
		}
		
		importIDL("idl/reimport/reimport.idl");
		unions = findIDLElement("IDL:Reimport/TestUnion:1.0");
		assertEquals(1, unions.size());
		union = (DataType)unions.get(0);
		for( Property p : union.getOwnedAttributes()) {
			if( ZDLUtil.isZDLConcept(p, CORBADomainNames.CORBACASE)) {
				if( p.getName().matches("mem1")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[1]"));
					assertTrue(p.getType().getName().toString().matches("CORBAString"));
				} else if( p.getName().matches("mem2")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[2]"));
					assertTrue(p.getType().getName().toString().matches("CORBALong"));
				} else if( p.getName().matches("mem3")) {
					assertTrue(ZDLUtil.getValue(p, CORBADomainNames.CORBACASE, CORBADomainNames.CORBACASE__LABEL).toString().contains("[default]"));
					assertTrue(p.getType().getName().toString().matches("CORBAOctet"));
				} else {
					fail("Invalid case statement.");
				}
			} else if( p.getName().matches("switchType")) {
				assertTrue(switchTypeName.matches(p.getType().getName().toString()));
			} else {
				fail("Invalid property on a union.");
			}
		}
	}
	
	/**
	 * Change a sequence type.
	 */
	@Test
	public void testModifySequenceTypedef() {
		importIDL("idl/reimport/reimport.idl");
		
		List<EObject> seqList = findIDLElement("IDL:Reimport/LongSequence:1.0");
		assertEquals(1, seqList.size());
		EObject sequence = seqList.get(0);
		String seqType = ((Property)((DataType)sequence).getOwnedMember("members")).getType().getName().toString();
		
		List<EObject> typeList = findIDLElement("IDL:Reimport/FooType:1.0");
		assertEquals(1, typeList.size());
		EObject typedef = typeList.get(0);			
		String typeType = ((Type) CORBAUtil.getTypeDefType((DataType)typedef)).getName();
		
		importIDL("idl/reimport/testModifySequenceTypedef/reimport.idl");
		
		seqList = findIDLElement("IDL:Reimport/LongSequence:1.0");
		assertEquals(1, seqList.size());
		sequence = seqList.get(0);
		assertTrue(seqType.matches(((Property)((DataType)sequence).getOwnedMember("members")).getType().getName().toString()) == false);
		
		typeList = findIDLElement("IDL:Reimport/FooType:1.0");
		assertEquals(1, typeList.size());
		typedef = typeList.get(0);
		assertTrue(typeType.matches(((Type) CORBAUtil.getTypeDefType((DataType)typedef)).getName()) == false);
		
		importIDL("idl/reimport/reimport.idl");
		
		seqList = findIDLElement("IDL:Reimport/LongSequence:1.0");
		assertEquals(1, seqList.size());
		sequence = seqList.get(0);
		assertTrue(seqType.matches(((Property)((DataType)sequence).getOwnedMember("members")).getType().getName().toString()) == true);
		
		typeList = findIDLElement("IDL:Reimport/FooType:1.0");
		assertEquals(1, typeList.size());
		typedef = typeList.get(0);
		assertTrue(typeType.matches(((Type) CORBAUtil.getTypeDefType((DataType)typedef)).getName()) == true);

	}
	
	/**
	 * Change the value of a constant through iterative import.
	 */
	@Test
	public void testChangeConstValue() {
		importIDL("idl/reimport/reimport.idl");
		
		List<EObject> constList = findIDLElement("IDL:Reimport/BOB:1.0");
		assertEquals(1, constList.size());
		Property _const = (Property) constList.get(0);
		assertTrue(_const.getType().getName().toString().matches("CORBALong"));
		assertTrue(_const.getDefaultValue().stringValue().matches("75"));
		
		importIDL("idl/reimport/testModifyConst/reimport.idl");
		constList = findIDLElement("IDL:Reimport/BOB:1.0");
		assertEquals(1, constList.size());
		_const = (Property) constList.get(0);
		assertTrue(_const.getType().getName().toString().matches("CORBAShort"));
		assertTrue(_const.getDefaultValue().stringValue().matches("60"));
		
	}
	
	/*
	 * Make sure that when reimporting the same operation with the same parameters, only with the
	 * order reversed, that the IDL elements come in with the correct order.
	 */
	@Test
	public void testReorderParameters() {
		
		importIDL("idl/reimport/reimport.idl");
		
		List<EObject> opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		Operation op = (Operation)opList.get(0);
		List<String> types = new ArrayList<String>();
		List<ParameterDirectionKind> directions = new ArrayList<ParameterDirectionKind>();
		List<String> names = new ArrayList<String>();
		for( Parameter p : op.getOwnedParameters()) {
			types.add(p.getType().getName().toString());
			directions.add(p.getDirection());
			names.add(p.getName());
		}
		
		importIDL("idl/reimport/testReorderParameters/reimport.idl");
		assertEquals("Duplicate interface found.",
				1,
				this.findIDLElement("IDL:Reimport/TestInterface:1.0").size());
		opList = findIDLElement("IDL:Reimport/TestInterface/y:1.0");
		assertEquals("Duplicate operation found.",
				1,
				opList.size());
		op = (Operation)opList.get(0);
		List<String> newtypes = new ArrayList<String>();
		List<ParameterDirectionKind> newdirections = new ArrayList<ParameterDirectionKind>();
		List<String> newnames = new ArrayList<String>();
		for( Parameter p : op.getOwnedParameters()) {
			newtypes.add(p.getType().getName().toString());
			newdirections.add(p.getDirection());
			newnames.add(p.getName());
		}
		assertTrue(newtypes.get(0).matches(types.get(1)));
		assertTrue(newtypes.get(1).matches(types.get(0)));
		assertEquals(newdirections.get(0), directions.get(1));
		assertEquals(newdirections.get(1), directions.get(0));
		assertTrue(newnames.get(0).matches(names.get(1)));
		assertTrue(newnames.get(1).matches(names.get(0)));
		
		importIDL("idl/reimport/reimport.idl");
	}

}


