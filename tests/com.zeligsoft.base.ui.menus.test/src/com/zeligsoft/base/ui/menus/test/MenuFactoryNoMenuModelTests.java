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

import java.util.Collection;

import org.eclipse.jface.action.IContributionItem;

import com.zeligsoft.base.ui.menus.providers.ZDLProjectExplorerMenuFactory;

/**
 * @author Zeligsoft
 *
 */
public class MenuFactoryNoMenuModelTests extends AbstractMenuFactoryTestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.zeligsoft.base.ui.menus.providers.ZDLProjectExplorerMenuFactory#createMenu()}.
	 */
	public final void testCreateMenu() {
		Collection<IContributionItem> result;
		
		ZDLProjectExplorerMenuFactory factory 
			= new ZDLProjectExplorerMenuFactory(testModel);
		
		result = factory.createMenu();
		
		assertNotNull(result);
		assertTrue(String.format("Expecting %d items and got %d items.", 0, result.size()), result.size() == 0);
	}

	@Override
	protected String getTestModelURI() {
		return "platform:/plugin/com.zeligsoft.base.ui.menus.test/testModels/TestModelNoMenuModel.uml";
	}
	
	@Override
	protected String getDomainProfileURI() {
		return "pathmap://TEST_MENUS_PROFILES/TestDomainNoMenuModel.profile.uml";
	}
}
