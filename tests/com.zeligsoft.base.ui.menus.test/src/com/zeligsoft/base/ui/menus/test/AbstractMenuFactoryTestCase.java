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
package com.zeligsoft.base.ui.menus.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

import com.ibm.xtools.modeler.ui.UMLModeler;

import junit.framework.TestCase;

public abstract class AbstractMenuFactoryTestCase extends TestCase {

	public static final String DEFAULT_TEST_MODEL_URI = "platform:/plugin/com.zeligsoft.base.ui.menus.test/testModels/TestModel.uml";
	public static final String DEFAULT_DOMAIN_PROFILE_URI = "pathmap://TEST_MENUS_PROFILES/TestDomain.profile.uml";
	private ResourceSet rset;
	private Profile domainProfile;
	protected Package testModel;

	public AbstractMenuFactoryTestCase() {
		super();
	}

	public AbstractMenuFactoryTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		testModel = (Package) UMLModeler.openModelResource(URI.createURI(getTestModelURI()));
		assertNotNull("Problems create test model resource!", testModel);
		
		rset = UMLModeler.getEditingDomain().getResourceSet();
		
		Resource profileResource = rset.getResource(
				URI.createURI(getDomainProfileURI()), 
				true);
		
		assertNotNull("Unable to load the profileResource", profileResource);
		
		domainProfile = (Profile) profileResource.getContents().get(0);
		
		assertNotNull("Problem getting the profile out of the resource", domainProfile);
	}

	/**
	 * @return
	 */
	protected String getDomainProfileURI() {
		return DEFAULT_DOMAIN_PROFILE_URI;
	}

	/**
	 * @return
	 */
	protected String getTestModelURI() {
		return DEFAULT_TEST_MODEL_URI;
	}

	protected void tearDown() throws Exception {
		for(Resource r : rset.getResources()) {
			r.unload();
		}
		rset = null;
		super.tearDown();
	}

}