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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zeligsoft.cx.ui.resources.EObjectPropertyStorage;
import com.zeligsoft.cx.ui.resources.EOjbectPropertyEditorInput;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * WorkerCodeEditorInput Test
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("nls")
public class EOjbectPropertyEditorInputTest {

	private EObjectPropertyStorage storage;

	private Package testPackage;

	private Operation worker;

	private static ResourceSet rset = new ResourceSetImpl();

	final private static String WORKER_NAME = "start";


	/**
	 * test getName API
	 */
	@Test
	public void test_getName() {

		assertTrue(storage.getName().equals(
			WORKER_NAME + NamedElement.SEPARATOR + storage.getProperty()));
	}

	/**
	 * test getStorage API
	 */
	@Test
	public void test_getStorage() {

		EOjbectPropertyEditorInput newInput = new EOjbectPropertyEditorInput(
			storage);
		assertSame(storage, newInput.getStorage());
	}

	/**
	 * test getToolTipText API
	 */
	@Test
	public void test_getTooTipText() {

		EOjbectPropertyEditorInput newInput = new EOjbectPropertyEditorInput(
			storage);
		assertTrue((worker.getQualifiedName() + NamedElement.SEPARATOR + storage
			.getProperty()).equals(newInput.getToolTipText()));

	}

	/**
	 * test equals method
	 */
	@Test
	public void test_equals() {

		EOjbectPropertyEditorInput input1 = new EOjbectPropertyEditorInput(
			storage);
		EOjbectPropertyEditorInput input2 = new EOjbectPropertyEditorInput(
			storage);
		assertTrue(input1.equals(input2));

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
		worker = comp1.getOwnedOperation(WORKER_NAME, null, null);
		storage = new EObjectPropertyStorage(worker,
			ZMLMMNames.WORKER_FUNCTION, ZMLMMNames.WORKER_FUNCTION__BODY);
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
