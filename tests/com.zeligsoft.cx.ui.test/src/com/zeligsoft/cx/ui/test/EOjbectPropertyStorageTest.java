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
package com.zeligsoft.cx.ui.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.resources.EObjectPropertyStorage;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * WorkerCodeStorage Test
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("nls")
public class EOjbectPropertyStorageTest {

	private Operation context;

	private Package testPackage;

	private EObjectPropertyStorage storage;

	private static ResourceSet rset = new ResourceSetImpl();

	final private static String WORKER_NAME = "start";

	final private static String BODY_TEXT = "Hello\r\nHelloggh\r\nHello\r\nfdsdfs dfgfsdfsdgf\r\n";
	
	public EOjbectPropertyStorageTest() {
		//super(name);
	}

	/**
	 * test getName API
	 */
	@Test
	public void test_getName() {

		assertTrue(storage.getName().equals(
			WORKER_NAME + NamedElement.SEPARATOR + storage.getProperty()));
	}

	/**
	 * Test getContents API
	 */
	@Test
	public void test_getContents() {
		BufferedReader buffReader;
		try {
			buffReader = new BufferedReader(new InputStreamReader(storage
				.getContents(), ((XMLResource) context.eResource())
				.getEncoding()));
			StringBuilder finalString = new StringBuilder();
			String tempString, newLiner;
			newLiner = System.getProperty("line.separator"); //$NON-NLS-1$
			
			String os = System.getProperty("os.name").toLowerCase();
			if(os.indexOf("nux") >= 0) {
				newLiner = "\r\n";
			}
			while (true) {
				tempString = buffReader.readLine();
				if (tempString == null)
					break;
				finalString.append(tempString).append(newLiner);

			}
			assertTrue(finalString.toString().equals(BODY_TEXT));

		} catch (Exception e) {
			fail();
		}

	}

	/**
	 * test getUri API
	 */
	@Test
	public void test_Uri() {
		assertTrue(storage.getUri().equals(EcoreUtil.getURI(context)));

	}

	/**
	 * test equals method
	 */
	@Test
	public void test_equals() {
		EObjectPropertyStorage storage2 = new EObjectPropertyStorage(context,
			ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__BODY);
		assertTrue(storage.equals(storage2));
	}

	@Before
	public void setUp()
			throws Exception {

		Resource modelRes = rset.getResource(URI.createPlatformPluginURI(
			"com.zeligsoft.cx.ui.test/models/Model1.emx", true), true);

		assertNotNull("Test model resource not available", modelRes);
		assertTrue("Test model resource not loaded", modelRes.isLoaded());

		testPackage = (Package) EcoreUtil.getObjectByType(modelRes
			.getContents(), UMLPackage.Literals.PACKAGE);

		Component comp1 = (Component) testPackage.getOwnedType("Component1");
		context = comp1.getOwnedOperation(WORKER_NAME, null, null);
		
		storage = new EObjectPropertyStorage(context, ZDLUtil
			.getZDLConcept(context), ZMLMMNames.WORKER_FUNCTION__BODY);
	}

	@After
	public void tearDown()
			throws Exception {

		Resource res = testPackage.eResource();

		res.unload();
		res.eAdapters().clear();
		rset.getResources().remove(res);

	}

}
