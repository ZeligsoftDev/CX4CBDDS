/**
 * 
 */
package com.zeligsoft.domain.omg.corba.idlimport.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.After;
import org.junit.Before;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * @author Zeligsoft
 * 
 */
@SuppressWarnings("nls")
public abstract class IDLImportTestCase extends TestCase{

	protected static final String TARGET_MODEL_PROPERTY_KEY = "targetModel";

	protected static String IDLIMPORT_WORKFLOW_FILE = "workflow/idlimport.oaw";
	
	protected static String BUNDLE_ID = "com.zeligsoft.domain.omg.corba.idlimport.test/";

	protected static final String DEAULT_MODEL_NAME = "IDLModel";
	
	protected static final String DEAULT_EMPTY_MODEL_NAME = "EmptyModel";

	protected static final String DEAULT_MODEL_FILE_NAME = DEAULT_MODEL_NAME + ".emx";

	protected static final String DEAULT_EMPTY_MODEL_FILE_NAME = DEAULT_EMPTY_MODEL_NAME + ".emx";

	protected static final String DEAULT_MODEL_FILE_PATH = "models/"
			+ DEAULT_MODEL_FILE_NAME;

	protected static final String DEAULT_EMPTY_MODEL_FILE_PATH = "models/"
		+ DEAULT_EMPTY_MODEL_FILE_NAME;
	
	protected static final String IMPORTED_PACKAGE_NAME = "IDL_Import_Results";

	protected static String PROFILE_URI = "pathmap://SCA_PROFILES/SCADomain.profile.uml";

	protected ResourceSet resourceSet;

	protected Resource resource;

	protected Model model;

	protected File temporaryModelFile;

	protected boolean deleteFile = false;

	protected String modelName;

	protected String modelfilePath;

	/**
	 * @param name
	 */
	protected IDLImportTestCase() {
		//super();
		modelName = DEAULT_MODEL_NAME;
		modelfilePath = DEAULT_MODEL_FILE_PATH;
	}

	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	
	@Before
	public void setUp() throws Exception {
	
		resourceSet = new ResourceSetImpl();
		refreshModel();
		
		while(true){
		EObject pkg = lookup(modelName + "::" + IMPORTED_PACKAGE_NAME);
		if (pkg != null) {
			EcoreUtil.remove(pkg);
				pkg.eAdapters().clear();
			} else {
				break;
			}
		}
		refreshModel();

	}

	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	
	@After
	public void tearDown() throws Exception {

		for (Resource next : resourceSet.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		resourceSet.eAdapters().clear();
		resourceSet = null;
		resource = null;
		model = null;

	}

	protected void refreshModel() {

		for (Resource next : resourceSet.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		resourceSet.eAdapters().clear();
		resourceSet = null;
		resource = null;
		model = null;

		resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(URI.createPlatformPluginURI(
				BUNDLE_ID + modelfilePath, true),
				true);
		assertTrue("Test resource not loaded", resource.isLoaded());

		model = (Model) EcoreUtil.getObjectByType(resource.getContents(),
				UMLPackage.Literals.PACKAGE);
	}

	protected boolean importIDL(List<String> idlFiles, final List<String> includeList,
			final List<String> defineList) {
		return importIDL(idlFiles, includeList, defineList, new ArrayList<String>());
	}
	
	protected boolean importIDL(List<String> idlFiles, final List<String> includeList,
			final List<String> defineList, final List<String> excludeList) {
		Issues issues = new IssuesImpl();

		Map<String, String> properties = new HashMap<String, String>();
		Map<String, Object> slots = new HashMap<String, Object>();

		String defaultWorkflow = IDLIMPORT_WORKFLOW_FILE;

		properties.put(TARGET_MODEL_PROPERTY_KEY, modelfilePath);

		// Because there is no IDL profile, we have to use the profile for a
		// domain that imports CORBADomain.
		properties.put("profileToApply", PROFILE_URI);
		WorkflowEngine workflow;
		List<String> sourceFileList = new ArrayList<String>();

		for (String idlFile : idlFiles) {

			File tempFile = new File(URI.createFileURI(idlFile).devicePath());
			assertTrue(idlFile + " does not exist.", tempFile.exists());
			sourceFileList.add(tempFile.getAbsolutePath());

		}
		slots.put("sourceFileList", sourceFileList); //$NON-NLS-1$
		slots.put("includeList", includeList); //$NON-NLS-1$
		slots.put("defineList", defineList); //$NON-NLS-1$
		slots.put("excludeList", excludeList); //$NON-NLS-1$
		slots.put("rset", resourceSet); //$NON-NLS-1$
	
		
		workflow = new WorkflowEngine();
		final boolean configOK = workflow.prepare(defaultWorkflow,
				new NullProgressMonitor(), properties);
		assertTrue("Failed preparing the workflow to import idlFile: " + sourceFileList,
				configOK);
		final boolean executeOK = workflow.executeWorkflow(slots, issues);

		if (!executeOK || issues.getErrors().length > 0)
			return executeOK;
	
		// update model after IDL import
		resource = resourceSet.getResource(URI.createURI(
				modelfilePath, true), true);
		
		model = (Model) EcoreUtil.getObjectByType(resource.getContents(),
				UMLPackage.Literals.PACKAGE);
		
		return true;
	}

	protected boolean importIDL(String idlFile) {
		List<String> idlFiles = new ArrayList<String>();
		idlFiles.add(idlFile);
		return importIDL(idlFiles, new ArrayList<String>(), new ArrayList<String>());
	}

	protected boolean importIDL(List<String> idlFiles) {
		return importIDL(idlFiles, new ArrayList<String>(), new ArrayList<String>());
	}

	protected void unloadModel() {
		assertNotNull(resource);
		model = null;
		resource.unload();
	}

	protected EObject lookup(String qualifiedName) {
		return lookup(qualifiedName, EObject.class);
	}

	protected <T extends Object> T lookup(String qualifiedName, Class<T> expectedType) {
		return lookup(resource, qualifiedName, expectedType);
	}

	protected static <T extends Object> T lookup(Resource theModel, String qualifiedName,
			Class<T> expectedType) {
		Collection<NamedElement> result;

		result = UMLUtil.findNamedElements(theModel, qualifiedName);

		if (result.isEmpty()) {
			return null;
		}

		@SuppressWarnings("unchecked")
		T resultAsT = (T) result.toArray()[0];

		return resultAsT;
	}

	protected Element getChild(Element parent, final String name) {
		class GetChildSwitch extends UMLSwitch<Element> {

			@Override
			public Element caseNamespace(Namespace object) {
				return object.getOwnedMember(name);
			}

			@Override
			public Element defaultCase(EObject object) {
				return null;
			}

		}

		return new GetChildSwitch().doSwitch(parent);
	}

	static public void assertIDLFile(EObject object) {
		assertNotNull(object);
		assertTrue(ZDLUtil.isZDLConcept(object, CORBADomainNames.IDLFILE));
	}

	static public void assertIDLFileMemberCount(EObject module, int count) {
		assertTrue(module instanceof org.eclipse.uml2.uml.Package);

		assertTrue(((org.eclipse.uml2.uml.Package) module).getOwnedMembers().size() == count);
	}

	static public void assertModule(EObject object) {
		assertNotNull(object);
		assertTrue(ZDLUtil.isZDLConcept(object, CORBADomainNames.CORBAMODULE));
	}

	static public void assertModuleMemberCount(EObject module, int count) {
		assertTrue(module instanceof org.eclipse.uml2.uml.Package);

		assertTrue(((org.eclipse.uml2.uml.Package) module).getOwnedMembers().size() == count);
	}

	static public void assertInterface(EObject object) {
		assertNotNull(object);
		assertTrue(ZDLUtil.isZDLConcept(object, CORBADomainNames.CORBAINTERFACE));
	}

	static public void assertInterfaceAttributeCount(EObject object, int count) {
		assertTrue(object instanceof org.eclipse.uml2.uml.Interface);
		assertTrue(((org.eclipse.uml2.uml.Interface) object).getOwnedAttributes().size() == count);
	}

	static public void assertInterfaceOperationCount(EObject object, int count) {
		assertTrue(object instanceof org.eclipse.uml2.uml.Interface);
		assertTrue(((org.eclipse.uml2.uml.Interface) object).getOwnedOperations().size() == count);
	}

	static public void assertInterfaceMemberCount(EObject object, int count) {
		assertTrue(object instanceof org.eclipse.uml2.uml.Interface);
		assertTrue(((org.eclipse.uml2.uml.Interface) object).getOwnedMembers().size() == count);
	}

	static public void assertAssociationCount(EObject object, int count) {
		assertTrue(object instanceof Classifier);
		assert (((Classifier) object).getAssociations().size() == count);
	}

	static public void assertInterfaceHasNoFeatures(EObject object) {
		assertInterfaceAttributeCount(object, 0);
		assertInterfaceOperationCount(object, 0);
		assertAssociationCount(object, 0);
	}

	static public void assertOperation(EObject op) {
		assertNotNull(op);
		assertTrue(ZDLUtil.isZDLConcept(op, CORBADomainNames.CORBAOPERATION));
	}

	static public void assertOperationParamCount(EObject op, int count) {
		assertTrue(op instanceof Operation);
		assertTrue(((Operation) op).getOwnedParameters().size() == count);
	}

	static public void assertOperationIsOneway(EObject op) {
		assertOperation(op);
		Object oneway = ZDLUtil.getValue(op, CORBADomainNames.CORBAOPERATION,
				CORBADomainNames.CORBAOPERATION__IS_ONE_WAY);
		assertTrue(oneway instanceof Boolean);
		assertTrue(((Boolean) oneway).booleanValue());
	}

	static public void assertOperationIsNotOneway(EObject op) {
		assertOperation(op);
		Object oneway = ZDLUtil.getValue(op, CORBADomainNames.CORBAOPERATION,
				CORBADomainNames.CORBAOPERATION__IS_ONE_WAY);
		assertTrue(oneway instanceof Boolean);
		assertFalse(((Boolean) oneway).booleanValue());
	}

	static public void assertOperationRaises(EObject op, EObject ex) {
		assertTrue("Was expecting the parameter op to be a CORBAOperation", ZDLUtil
				.isZDLConcept(op, CORBADomainNames.CORBAOPERATION));
		assertTrue(
				"Was expecting the operation contain an exception but it was not found.",
				((Operation) op).getRaisedExceptions().contains(ex));
	}

	static public void assertOperationRaisesCount(EObject op, int count) {
		assertTrue("Was expecting the parameter op to be a CORBAOperation", ZDLUtil
				.isZDLConcept(op, CORBADomainNames.CORBAOPERATION));
		assertTrue(String.format(
				"Was expecting the operation contain %d raised exception but it has %d.",
				count, ((Operation) op).getRaisedExceptions().size()), ((Operation) op)
				.getRaisedExceptions().size() == count);
	}

	static public void assertOperationReturnType(EObject op, EObject type) {
		assertEquals("The return type of the operation did not match the expected type",
				((Operation) op).getType(), type);
	}

	static public void assertParameter(EObject param) {
		assertNotNull(param);
		assertTrue(param instanceof Parameter);
	}

	static public void assertInParameter(EObject param) {
		assertTrue(param instanceof Parameter);
		// somehow assert that it is in which right now there is
		// no way to tell
		assertTrue(((Parameter) param).getDirection() == ParameterDirectionKind.IN_LITERAL);
	}

	static public void assertOutParameter(EObject param) {
		assertTrue(param instanceof Parameter);
		// somehow assert that it is out which right now there is
		// no way to tell
		assertTrue(((Parameter) param).getDirection() == ParameterDirectionKind.OUT_LITERAL);
	}

	static public void assertInOutParameter(EObject param) {
		assertTrue(param instanceof Parameter);
		// somehow assert that it is inout which right now there is
		// no way to tell
		assertTrue(((Parameter) param).getDirection() == ParameterDirectionKind.INOUT_LITERAL);
	}
	
	static public void assertParameterType(EObject c, EObject type) {
		EObject caseType = ((Parameter) c).getType();
		assertEquals("The type of the case was not what was expected.", caseType, type);
	}

	static public void assertGeneralization(EObject specific, EObject general) {
		assertTrue(specific instanceof Classifier);
		Classifier specificClassifier = (Classifier) specific;

		assertTrue(specificClassifier.getGenerals().contains(general));
	}

	static public void assertGeneralizationCount(EObject intf, int count) {
		assertTrue(intf instanceof Classifier);
		assertTrue(((Classifier) intf).getGenerals().size() == count);
	}

	static public void assertException(EObject ex) {
		assertNotNull("A null object is not a CORBAException", ex);
		assertTrue(String.format("The element %s is not a CORBAException.", ex.eClass()
				.getName()), ZDLUtil.isZDLConcept(ex, CORBADomainNames.CORBAEXCEPTION));
	}
	
	static public void assertExceptionMembersCount(EObject ex, int count) {
		assertNotNull("A null object is not a CORBAException", ex);
		//ZDLUtil.getValue(ex, CORBADomainNames.CORBAEXCEPTION, CORBADomainNames.CORBAEXCEPTION__MEMBERS)
		//assertTrue(ZDLUtil.get == count);
		//ZDLUtil.isZDLConcept(ex, CORBADomainNames.CORBAEXCEPTION__MEMBERS)
	} 

	static public void assertStruct(EObject struct) {
		assertNotNull("A null object is not a CORBAStruct", struct);
		assertTrue(String.format("The element %s is not a CORBAStruct.", struct.eClass()
				.getName()), ZDLUtil.isZDLConcept(struct, CORBADomainNames.CORBASTRUCT));
	}

	static public void assertStructFieldCount(EObject struct, int count) {
		assertNotNull("A null object is not a CORBAStruct", struct);
		int fieldCount = ((org.eclipse.uml2.uml.Classifier) struct).getAttributes()
				.size();
		assertTrue(String.format("Expecting %d fields in the union, but got %d fields.",
				count, fieldCount), count == fieldCount);
	}

	static public void assertField(EObject field) {
		assertNotNull("A null object is not a field.", field);
		assertTrue(String.format("The element %s is not a CORBAField", field.eClass()
				.getName()), field instanceof Property);
	}

	static public void assertFieldType(EObject field, EObject type) {
		assertNotNull("A null object is not a field.", field);
		assertEquals("The type of the field is not correct.", ((Property) field)
				.getType(), type);
	}

	static public void assertEnum(EObject e) {
		assertNotNull("A null object is not a CORBAEnum", e);
		assertTrue(String.format("The element %s is not a CORBAEnum.", e.eClass()
				.getName()), ZDLUtil.isZDLConcept(e, CORBADomainNames.CORBAENUM));
	}

	static public void assertEnumLiteralCount(EObject e, int count) {
		assertNotNull("A null object is not a CORBAEnum", e);
		int literalCount = ((Enumeration) e).getOwnedLiterals().size();
		assertTrue(String.format(
				"Expecting %d literals in the enumeration, but got %d literals.", count,
				literalCount), count == literalCount);
	}

	static public void assertUnion(EObject u) {
		assertNotNull("A null object is not a CORBAUnion", u);
		assertTrue(String.format("The element %s is not a CORBAUnion.", u.eClass()
				.getName()), ZDLUtil.isZDLConcept(u, CORBADomainNames.CORBAUNION));
	}

	static public void assertUnionSwitchType(EObject u, EObject type) {
		Property switchType = ((DataType) u).getAttribute("switchType", null);
		assertNotNull("Could not find the switchType property on the union.", switchType);
		assertEquals("The union's switch type is not what was expected.", switchType,
				type);
	}

	static public void assertUnionFieldCount(EObject u, int count) {
		assertNotNull("A null object is not a CORBAUnion", u);
		Collection<EObject> casesCollection = ZDLUtil.getObjectsByConcept(((DataType) u)
				.getAttributes(), CORBADomainNames.CORBACASE);
		assertTrue(String.format("Expecting %d cases in the union, but got %d cases.",
				count, casesCollection.size()), count == casesCollection.size());
	}

	static public void assertCase(EObject c) {
		assertNotNull("A null object is not a CORBACase", c);
		assertTrue("Was expective a CORBACase", ZDLUtil.isZDLConcept(c,
				CORBADomainNames.CORBACASE));
	}

	static public void assertCaseType(EObject c, EObject type) {
		EObject caseType = ((Property) c).getType();
		assertEquals("The type of the case was not what was expected.", caseType, type);
	}

	static public void assertCaseLabel(EObject c, String label) {
		assertNotNull("The case can not be null", c);
		Object caseLabel = ZDLUtil.getValue(c, CORBADomainNames.CORBACASE,
				CORBADomainNames.CORBACASE__LABEL);
		assertEquals(String.format("The expected label %s, but the label was %s", label,
				caseLabel.toString()), label, caseLabel);
	}

	static public void assertTypedef(EObject typedef) {
		assertNotNull("A null object is not a CORBATypedef", typedef);
		assertTrue(String.format("The element %s is not a CORBATypedef.", typedef
				.eClass().getName()), ZDLUtil.isZDLConcept(typedef,
				CORBADomainNames.CORBATYPE_DEF));
	}
	
	static public void assertSequence(EObject typedef) {
		assertNotNull("A null object is not a CORBASequence", typedef);
		assertTrue(String.format("The element %s is not a CORBASequence.", typedef
				.eClass().getName()), ZDLUtil.isZDLConcept(typedef,
				CORBADomainNames.CORBASEQUENCE));
	}

	protected void assertModelPackagedElementCount(int count) {
		assertTrue(String.format(
				"Was expecting the model to contain %s elements but it has %s elements.",
				count, model.getPackagedElements().size()), model.getPackagedElements()
				.size() == count);
	}

	protected void assertModelIsEmpty() {
		assertModelPackagedElementCount(0);
	}
}
