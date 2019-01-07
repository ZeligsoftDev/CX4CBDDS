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
package com.zeligsoft.base.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.base.workflow.RSMWriter;
import com.zeligsoft.base.workflow.SetupResourceSet;

/**
 * Tests for the RSMWriter workflow component.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class RSMWriterTests
		extends AbstractWorkflowComponentTest<RSMWriter> {

	private static final Pattern SIGNATURE_PATTERN = Pattern.compile(
		"<\\?com\\.ibm\\.xtools\\.emf\\.core\\.signature <signature id=\"([^\"]+)\".*");
	
	private static final Pattern ROOT_ELEMENT_PATTERN = Pattern.compile(
		".*xmi:version=.*");

	private static final String MODEL_SIGNATURE = "com.ibm.xtools.uml.msl.model";
	private static final String PROFILE_SIGNATURE = "com.ibm.xtools.uml.msl.profile";
	
	private static final String BASE_PROFILE = "pathmap://UML2_MSL_PROFILES/ProfileBase.epx";
	
	private File tempFile;

	protected ResourceSet rset;

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public RSMWriterTests() {
		// Default constructor
	}

	/**
	 * Tests the writing of an EMF file with stereotype applications and such.
	 */
	@Test
	public void test_writeEMXFile() {
		createTemporaryFile("emx");

		Profile ecore = getProfile(UMLResource.ECORE_PROFILE_URI);
		Stereotype epackage = getStereotype(ecore, "EPackage");
		Stereotype eclass = getStereotype(ecore, "EClass");
		
		Model root = UMLFactory.eINSTANCE.createModel();
		
		root.applyProfile(ecore);
		root.applyStereotype(epackage);

		Package pkg = root.createNestedPackage("foo");
		Class clazz = pkg.createOwnedClass("Foo", false);
		clazz.applyStereotype(eclass);

		configureFixture(root);
		invokeFixture();
		
		root = load();
		
		pkg = root.getNestedPackage("foo");
		assertNotNull("Couldn't find the package", pkg);
		clazz = (Class) pkg.getOwnedType("Foo");
		assertNotNull("Couldn't find the class", clazz);
		
		assertTrue("<<ePackage>> not applied", root.isStereotypeApplied(epackage));
		assertTrue("<<eClass>> not applied", clazz.isStereotypeApplied(eclass));
		
		assertSignature(MODEL_SIGNATURE);
	}

	/**
	 * Tests the writing of an EPX file with stereotype applications and such.
	 */
	@Test
	public void test_writeEPXFile() {
		createTemporaryFile("epx");

		Profile base = getProfile(BASE_PROFILE);
		Stereotype profCons = getStereotype(base, "ProfileConstraint");
		
		Profile root = UMLFactory.eINSTANCE.createProfile();
		
		root.applyProfile(base);

		Stereotype stereo = root.createOwnedStereotype("Foo", false);
		Constraint constraint = stereo.createOwnedRule("rule");
		// the <<profileConstraint>> stereotype is required, so don't apply it

		configureFixture(root);
		invokeFixture();
		
		root = load();
		
		assertNotNull("Profile is not defined", root.getDefinition());
		
		stereo = root.getOwnedStereotype("Foo");
		assertNotNull("Couldn't find the stereotype", stereo);
		constraint = stereo.getOwnedRule("rule");
		assertNotNull("Couldn't find the constraint", constraint);
		
		assertTrue("<<profileConstraint>> not applied", constraint.isStereotypeApplied(profCons));
		
		assertSignature(PROFILE_SIGNATURE);
	}

	//
	// Test framework methods
	//

	@Override
	@Before
	public void setUp()
			throws Exception {

		super.setUp();

		rset = new ResourceSetImpl();
		SetupResourceSet.enablePathmaps(rset);
	}

	@After
	public void tearDown()
			throws Exception {

		if ((tempFile != null) && tempFile.exists()) {
			tempFile.delete();
		}
	}

	@Override
	protected RSMWriter createFixture() {
		return new RSMWriter();
	}

	/**
	 * Loads the test resource, returning the root package. Asserts that this
	 * root package exists.
	 * 
	 * @param <T>
	 *            the expected root package type
	 * @return the root package
	 */
	protected <T extends Package> T load() {
		Resource resource = rset.getResource(URI.createURI(getTempFileURI()),
			true);

		try {
			resource.load(Collections.EMPTY_MAP);
		} catch (Exception e) {
			fail("Failed to re-load the resource: " + e.getLocalizedMessage());
		}

		@SuppressWarnings("unchecked")
		T result = (T) EcoreUtil.getObjectByType(resource.getContents(),
			UMLPackage.Literals.PACKAGE);

		assertNotNull("No package found in re-loaded resource", result);

		return result;
	}

	/**
	 * Sets the inputs required by the RSMWriter.
	 * 
	 * @param model
	 *            the model object to save
	 */
	protected void configureFixture(Package model) {
		setProperty(RSMWriter.URI_PROPERTY, getTempFileURI());
		setProperty("modelSlot", "testModel");
		setSlot("testModel", model);
		setProperty("resourceSetSlot", "rset");
		setSlot("rset", rset);
	}

	protected void createTemporaryFile(String extension) {
		try {
			tempFile = File.createTempFile("rsmwriter_test", "." + extension);
			tempFile.deleteOnExit(); // just in case
		} catch (Exception e) {
			fail("Failed to create temporary file: " + e.getLocalizedMessage());
		}
	}

	protected String getTempFileURI() {
		return URI.createFileURI(tempFile.getAbsolutePath()).toString();
	}

	protected Profile getProfile(String uri) {
		Resource res = rset.getResource(URI.createURI(uri), true);

		Profile result = (Profile) EcoreUtil.getObjectByType(res.getContents(),
			UMLPackage.Literals.PROFILE);
		assertNotNull("Failed to load the profile", result);
		return result;
	}

	protected Stereotype getStereotype(Profile profile, String name) {
		Stereotype result = profile.getOwnedStereotype(name);
		
		assertNotNull("Did not find stereotype " + name, result);
		
		return result;
	}
	
	protected void assertSignature(String signatureID) {
		boolean found = false;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tempFile));
			
			Matcher sigMatcher = SIGNATURE_PATTERN.matcher("");
			Matcher rootMatcher = ROOT_ELEMENT_PATTERN.matcher("");
			
			for (String line = reader.readLine(); !found && (line != null); line = reader.readLine()) {
				rootMatcher.reset(line);
				if (rootMatcher.matches()) {
					// no more signatures
					break;
				}
				
				sigMatcher.reset(line);
				if (sigMatcher.matches()) {
					found = signatureID.equals(sigMatcher.group(1));
				}
			}
		} catch (Exception e) {
			fail("Failed to read model file: " + e.getLocalizedMessage());
		}
		assertTrue("Signature not found", found);
	}
}
