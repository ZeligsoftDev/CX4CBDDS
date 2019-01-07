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

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.toolingmodel.MenuModel;
import com.zeligsoft.base.ui.menus.util.CXMenuUtil;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class CXMenuUtilTests extends TestCase {

	private ResourceSet rset;
	private Profile domainProfile;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		rset = new ResourceSetImpl();
		
		Resource profileResource = rset.getResource(
				URI.createURI("pathmap://TEST_MENUS_PROFILES/TestDomain.profile.uml"), 
				true);
		
		assertNotNull("Unable to load the profileResource", profileResource);
		
		domainProfile = (Profile) profileResource.getContents().get(0);
		
		assertNotNull("Problem getting the profile out of the resource", domainProfile);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		for(Resource r : rset.getResources()) {
			r.unload();
		}
		rset = null;
		super.tearDown();
	}

	/**
	 * Test method for {@link com.zeligsoft.base.ui.menus.util.CXMenuUtil#getMenuModel(org.eclipse.uml2.uml.Profile)}.
	 */
	public final void testGetMenuModel() {
		MenuModel mm = CXMenuUtil.getMenuModel(domainProfile);
		
		assertNotNull("The menu model is null", mm);
	}

}
