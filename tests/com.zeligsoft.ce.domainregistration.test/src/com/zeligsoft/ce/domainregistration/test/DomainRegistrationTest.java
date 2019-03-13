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

/**
 * Class used to test domain registration 
 * 
 * @author sduchesneau
 *
 */
package com.zeligsoft.ce.domainregistration.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

import com.zeligsoft.ce.domainregistration.DSLibrary;
import com.zeligsoft.ce.domainregistration.DSProfile;
import com.zeligsoft.ce.domainregistration.DomainRegistry;
import com.zeligsoft.ce.domainregistration.DomainSpecialization;
import com.zeligsoft.ce.domainregistration.DomainSpecializationPart;

public class DomainRegistrationTest
		extends TestCase {

	final static String TEST_DOMAIN_PREFIX = "domain_test";

	final static String TEST_DOMAIN1 = "domain_test1";

	final static String TEST_DOMAIN1_VER = "1.3";

	final static String TEST_DOMAIN2 = "domain_test2";

	final static String TEST_DOMAIN2_VER = "1.4";

	final static String TEST_DOMAIN3 = "domain_test3";

	final static String TEST_DOMAIN3_VER = "1.0";

	final static String ROSE_PROFILES = "Rose Migration Profiles";

	final static String ROSE_PROFILE_NAME = "Rose";

	final static String UML2_LIBRARY = "UML2 Type Library";

	final static String UML2_LIBRARY_PRIMITIVE_TYPE = "UMLPrimitiveTypes";

	final static String JAVA_LIBRARY = "Java Type Library";

	final static String JAVA_LIBRARY_PRIMITIVE_TYPE = "JavaPrimitiveTypes";

	protected void setUp()
			throws Exception {
		super.setUp();
	}

	protected void tearDown()
			throws Exception {
		super.tearDown();
	}

	public void testCreateModel()
			throws Exception {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("model1");
		assertNotNull(model);
	}

	public void test_getDomainList()
			throws Exception {
		int count = 0;
		for (DomainSpecialization lib : DomainRegistry.getDomainList()) {
			if (lib.getName().contains(TEST_DOMAIN_PREFIX)) {
				count++;
			}
		}
		assertEquals(count, 3);
	}

	private DomainSpecialization[] getTestDomains() {
		DomainSpecialization[] domains = new DomainSpecialization[3];
		domains[0] = DomainRegistry.getDomain(TEST_DOMAIN1);
		domains[1] = DomainRegistry.getDomain(TEST_DOMAIN2);
		domains[2] = DomainRegistry.getDomain(TEST_DOMAIN3);
		return domains;
	}

	public void test_getDomainArray()
			throws Exception {
		int count = 0;
		for (DomainSpecialization lib : DomainRegistry.getDomainArray()) {
			if (lib.getName().contains(TEST_DOMAIN_PREFIX)) {
				count++;
			}
		}
		assertEquals(count, 3);
	}

	public void test_getDomain()
			throws Exception {
		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN1);
		assertNotNull(domain);
		assertEquals(domain.getName(), TEST_DOMAIN1);
	}

	public void test_getPartList()
			throws Exception {
		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN1);
		assertNotNull(domain);
		assertEquals(domain.getName(), TEST_DOMAIN1);

		ArrayList<DomainSpecializationPart> partList = domain.getPartList();
		assertEquals(partList.size(), 2);
	}

	public void test_findInDomain()
			throws Exception {
		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN1);
		assertNotNull(domain);

		DSLibrary lib = domain.getLibrary(UML2_LIBRARY);

		assertTrue(DomainRegistry.findInList(lib, domain.getPartList()));
	}

	public void test_applyProfiles()
			throws Exception {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("model3");
		assertNotNull(model);
		assertEquals(model.getAllAppliedProfiles().size(), 0);

		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN2);
		assertNotNull(domain);
		assertEquals(domain.getName(), TEST_DOMAIN2);

		DSProfile[] profileArray = domain.getProfiles();
		assertNotNull(profileArray);

		BasicDiagnostic report = DomainRegistry.applyProfiles(profileArray,
			model);
		assertEquals(model.getAllAppliedProfiles().size(), 1);
		assertTrue(report.getChildren().isEmpty());

		int Rose_profile_count = 0;

		for (Profile profile : model.getAllAppliedProfiles()) {
			if (profile.getName().compareTo(ROSE_PROFILE_NAME) == 0) {
				Rose_profile_count++;
			}
		}

		assertEquals(Rose_profile_count, 1);

		domain = DomainRegistry.getDomain(TEST_DOMAIN3);
		assertNotNull(domain);
		assertEquals(domain.getName(), TEST_DOMAIN3);

		profileArray = domain.getProfiles();
		assertNotNull(profileArray);

		report = DomainRegistry.applyProfiles(profileArray, model);
		assertEquals(report.getChildren().size(), 1);

	}

	public void test_importModelLibraries()
			throws Exception {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("model2");
		assertNotNull(model);
		assertEquals(model.getPackagedElements().size(), 0);

		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN2);
		assertNotNull(domain);
		assertEquals(domain.getName(), TEST_DOMAIN2);

		DSLibrary[] libArray = domain.getLibraries();
		assertNotNull(libArray);

		BasicDiagnostic report = DomainRegistry.importModelLibraries(libArray,
			model);

		assertEquals(model.getPackagedElements().size(), 2);

		assertTrue(report.getChildren().isEmpty());

		int UML2_library_count = 0;
		int Java_library_count = 0;

		for (PackageableElement pe : model.getPackagedElements()) {
			if (pe.getName().compareTo(UML2_LIBRARY_PRIMITIVE_TYPE) == 0) {
				UML2_library_count++;
			}
			if (pe.getName().compareTo(JAVA_LIBRARY_PRIMITIVE_TYPE) == 0) {
				Java_library_count++;
			}
		}

		assertEquals(UML2_library_count, 1);
		assertEquals(Java_library_count, 1);

		domain = DomainRegistry.getDomain(TEST_DOMAIN3);
		assertNotNull(domain);
		assertEquals(domain.getName(), TEST_DOMAIN3);

		libArray = domain.getLibraries();
		assertNotNull(libArray);

		report = DomainRegistry.importModelLibraries(libArray, model);
		assertEquals(report.getChildren().size(), 1);
	}

	public void test_DR_getLibraries()
			throws Exception // test the one in domain registry
	{
		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN1);

		DSLibrary[] libArray = domain.getLibraries();
		assertEquals(libArray.length, 1);
	}

	public void test_DR_getProfiles()
			throws Exception // test the one in domain registry
	{
		DomainSpecialization domain = DomainRegistry.getDomain(TEST_DOMAIN1);

		DSProfile[] profileArray = domain.getProfiles();
		assertEquals(profileArray.length, 1);
	}

	public void test_DS_getLibraries()
			throws Exception // test the one in domain specialization
	{

		DSLibrary[] libArray = DomainRegistry.getLibraries(getTestDomains());

		assertEquals(libArray.length, 3);
	}

	public void test_DS_getProfiles()
			throws Exception // test the one in domain specialization
	{

		DSProfile[] profileArray = DomainRegistry.getProfiles(getTestDomains());
		assertEquals(profileArray.length, 2);
	}

	public void testDataStructures()
			throws Exception {
		int domain_test1_count = 0;
		int domain_test2_count = 0;

		for (DomainSpecialization domain : DomainRegistry.getDomainList()) {
			if (domain.getName().compareTo(TEST_DOMAIN1) == 0) {
				ArrayList<DomainSpecializationPart> partList = domain
					.getPartList();
				assertNotNull(partList);
				assertEquals(partList.size(), 2);

				DSProfile profile = domain.getProfile(ROSE_PROFILES);
				assertNotNull(profile);
				assertEquals(profile.getType(),
					DomainSpecializationPart.TYPE_PROFILE);
				assertEquals(profile.getName(), ROSE_PROFILES);

				DSLibrary lib = domain.getLibrary(UML2_LIBRARY);
				assertNotNull(lib);
				assertEquals(lib.getType(),
					DomainSpecializationPart.TYPE_LIBRARY);
				assertEquals(lib.getName(), UML2_LIBRARY);

				domain_test1_count++;
			}

			if (domain.getName().compareTo(TEST_DOMAIN2) == 0) {
				ArrayList<DomainSpecializationPart> partList = domain
					.getPartList();
				assertNotNull(partList);
				assertEquals(partList.size(), 3);

				DSLibrary lib = domain.getLibrary(JAVA_LIBRARY);
				assertNotNull(lib);
				assertEquals(lib.getType(),
					DomainSpecializationPart.TYPE_LIBRARY);
				assertEquals(lib.getName(), JAVA_LIBRARY);

				lib = domain.getLibrary(UML2_LIBRARY);
				assertNotNull(lib);
				assertEquals(lib.getType(),
					DomainSpecializationPart.TYPE_LIBRARY);
				assertEquals(lib.getName(), UML2_LIBRARY);

				lib = domain.getLibrary("fake library");
				assertNull(lib);

				DSProfile profile = domain.getProfile(ROSE_PROFILES);
				assertNotNull(profile);
				assertEquals(profile.getType(),
					DomainSpecializationPart.TYPE_PROFILE);
				assertEquals(profile.getName(), ROSE_PROFILES);

				domain_test2_count++;
			}
		}
		//		assertEquals(DomainRegistry.getProfiles(DomainRegistry.getDomainArray()).length, 1);

		assertEquals(domain_test1_count, 1);
		assertEquals(domain_test2_count, 1);
	}
}
