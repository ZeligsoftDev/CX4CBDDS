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
package com.zeligsoft.base.zdl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.WorkflowRunner;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Port;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Tests the <tt>ZDLMetamodel</tt> when used in a workflow.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ZDLMetamodelInWorkflowTests {

	private static final String NEWLINE = System.getProperty("line.separator");

	private static final String PLUGIN_ID = "com.zeligsoft.base.zdl.test";

	private static final String BASE_URI = "platform:/plugin/" + PLUGIN_ID
		+ "/";

	private String srcGenLocation;

	/**
	 * Tests running a workflow that generates a simple textual listing of
	 * MyDomain Applications with a port summary, from the stock test model.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test_simpleXpand() {
		WorkflowRunner runner = new WorkflowRunner();

		Map<String, String> params = new java.util.HashMap<String, String>();
		params.put("modelURI", BASE_URI + "models/my_model.emx");
		params.put("src-gen", getSrcGenLocation());

		Map<String, Object> slots = new java.util.HashMap<String, Object>();
		slots.put("rset", new ResourceSetImpl());

		runner.run("templates/generate.oaw", new NullProgressMonitor(), params,
			slots);

		assertGeneration("FourBitAdder.txt");
	}

	/**
	 * Tests running a simple Xtend transformation that generates a MyDomain
	 * application model.
	 */
	@Test
	public void test_simpleXtend() {
		WorkflowEngine runner = new WorkflowEngine();

		Map<String, String> params = new java.util.HashMap<String, String>();
		params.put("modelURI", BASE_URI + "models/uml_model.emx");
		params.put("profileURI", BASE_URI + "models/MyDomain.profile.uml");

		Map<String, Object> slots = new java.util.HashMap<String, Object>();
		slots.put("rset", new ResourceSetImpl());

		runner.run("templates/transform.oaw", new NullProgressMonitor(),
			params, slots);

		// verify the structure of the resulting model
		
		Model result = (Model) runner.getContext().get("appModel");
		assertNotNull("Application not generated", result);

		assertEquals("uml_model", result.getName());
		Component app = (Component) result.getOwnedType("Component1");
		assertNotNull(app);
		assertTrue(ZDLUtil.isZDLConcept(app, "MyDomain::MyBlock::Application"));

		Class bob = (Class) result.getOwnedType("Bob");
		assertNotNull(bob);
		assertTrue(ZDLUtil.isZDLConcept(bob, ZMLMMNames.PORT_TYPE));

		Class fred = (Class) result.getOwnedType("Fred");
		assertNotNull(fred);
		assertTrue(ZDLUtil.isZDLConcept(fred, ZMLMMNames.PORT_TYPE));

		Port bobPort = app.getOwnedPort("bob", bob);
		assertNotNull(bobPort);
		assertTrue(ZDLUtil.isZDLConcept(bobPort, "MyDomain::MyBlock::MyPort"));
		assertSame(ZDLUtil.getZDLEnumLiteral(bobPort,
			"ZMLMM::ZML_Component::WiringKind", "spp"), ZDLUtil.getValue(
			bobPort, ZMLMMNames.PORT, ZMLMMNames.PORT__WIRING));
		assertTrue(((Collection<?>) ZDLUtil.getValue(bobPort,
			"MyDomain::MyBlock::MyPort", "kind")).contains(ZDLUtil
			.getZDLEnumLiteral(bobPort, "MyDomain::MyBlock::PortKind", "data")));

		Port fredPort = app.getOwnedPort("fred", fred);
		assertNotNull(fredPort);
		assertTrue(ZDLUtil.isZDLConcept(fredPort, "MyDomain::MyBlock::MyPort"));
		assertSame(ZDLUtil.getZDLEnumLiteral(fredPort,
			"ZMLMM::ZML_Component::WiringKind", "spp"), ZDLUtil.getValue(
				fredPort, ZMLMMNames.PORT, ZMLMMNames.PORT__WIRING));
		assertTrue(((Collection<?>) ZDLUtil.getValue(fredPort,
			"MyDomain::MyBlock::MyPort", "kind")).contains(ZDLUtil
			.getZDLEnumLiteral(fredPort, "MyDomain::MyBlock::PortKind", "responses")));
	}

	//
	// Test framework methods
	//

	@Before
	public void setUp() throws Exception {

		// delete the contents of the src-gen folder as a precaution
		cleanOutputFolder();
	}

	@After
	public void tearDown()
			throws Exception {

		cleanOutputFolder();

	}

	/**
	 * Cleans the output folder.
	 */
	protected void cleanOutputFolder()
			throws IOException {
		File srcGen = new File(getSrcGenLocation());

		if (srcGen.exists()) {
			for (File next : srcGen.listFiles()) {
				deleteContents(next);
			}
		}
	}

	private void deleteContents(File fileOrDir)
			throws IOException {

		if (fileOrDir.isDirectory()) {
			for (File next : fileOrDir.listFiles()) {
				deleteContents(next);
			}
		}

		fileOrDir.delete();
	}

	/**
	 * Asserts correct generation of the file at the specified path in the
	 * output directory, by comparison with the pristine copy of the same.
	 * 
	 * @param path
	 *            the path relative to the output folder
	 */
	protected void assertGeneration(String path) {
		assertEquals("Generated output differs for " + path,
			loadPristineCopy(path), loadGeneratedCopy(path));
	}

	protected String loadPristineCopy(String path) {
		try {
			URL url = new URL(BASE_URI + "pristine/" + path);

			return squishBlankLines(url.openStream());
		} catch (IOException e) {
			fail("Failed to load pristine copy of " + path + ": "
				+ e.getLocalizedMessage());
			return null;
		}
	}

	protected String loadGeneratedCopy(String path) {
		try {
			File srcGenFolder = new File(getSrcGenLocation());
			File target = new File(srcGenFolder, path);

			assertTrue("Output file not generated", target.exists());

			return squishBlankLines(new FileInputStream(target));
		} catch (IOException e) {
			fail("Failed to load generated copy of " + path + ": "
				+ e.getLocalizedMessage());
			return null;
		}
	}

	/**
	 * Loads the text file on the specified input stream, squishing out blank
	 * lines along the way.
	 * 
	 * @param input
	 *            the input stream. It is closed by this operation
	 * @return the stream's contents, with blank lines squished out
	 * 
	 * @throws IOException
	 *             on any problem in reading
	 */
	protected String squishBlankLines(InputStream input)
			throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		StringBuilder result = new StringBuilder(4096);
		for (String line = reader.readLine(); line != null; line = reader
			.readLine()) {
			line = line.trim();
			if (line.length() > 0) {
				result.append(line);
				result.append(NEWLINE);
			}
		}

		reader.close();

		return result.toString().trim();
	}

	protected String getSrcGenLocation() {
		if (srcGenLocation == null) {
			Bundle bundle = Platform.getBundle(PLUGIN_ID);
			URL url = bundle.getEntry("/");

			try {
				URI uri = URI.createURI(FileLocator.resolve(url).toString());
				uri = uri.appendSegment("src-gen");
				srcGenLocation = uri.toFileString();
			} catch (IOException e) {
				fail("Could not resolve the src-gen/ folder location: "
					+ e.getLocalizedMessage());
			}
		}

		return srcGenLocation;
	}
}
