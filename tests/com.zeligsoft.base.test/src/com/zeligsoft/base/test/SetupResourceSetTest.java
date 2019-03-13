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

import static org.junit.Assert.*;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.junit.Test;

import com.zeligsoft.base.workflow.AbstractEMFComponentWithResourceSet;
import com.zeligsoft.base.workflow.SetupResourceSet;


/**
 * Tests the {@link SetupResourceSet} workflow component.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class SetupResourceSetTest
		extends AbstractWorkflowComponentTest<SetupResourceSet> {

	private static final String SLOT_NAME = "rset";
	
	private static final String TEST_PATHMAP_URI = "pathmap://SETUP_RSET_TEST";
	
	private static final String TEST_RESOLVED_URI = "platform:/plugin/com.zeligsoft.base.test/models";
	
	/**
	 * @param name
	 */
	public SetupResourceSetTest() {
		// Default constructor
	}


	/**
	 * Tests the basic resource-set setup functionality.
	 */
	@Test
	public void test_basicSetup() {
		setProperty(AbstractEMFComponentWithResourceSet.RESOURCE_SET_SLOT, SLOT_NAME);
		
		invokeFixture();
		
		ResourceSet rset = getSlot(SLOT_NAME);
		assertNotNull("No resource set created", rset);
		
		URIConverter conv = rset.getURIConverter();
		
		// GMF reduces theURI to file: or jar: scheme
		URI expected = URI.createURI(TEST_RESOLVED_URI + "/test.xmi");
		expected = CommonPlugin.asLocalURI(expected);
		URI actual = conv.normalize(URI.createURI(TEST_PATHMAP_URI + "/test.xmi"));
		
		assertEquals("Pathmap adapter not attached", expected, actual);
	}
	
	//
	// Test framework methods
	//
	
	@Override
	protected SetupResourceSet createFixture() {
		return new SetupResourceSet();
	}

}
