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

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.menus.providers.ZDLProjectExplorerMenuFactory;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class MenuFactoryTests extends AbstractMenuFactoryTestCase {

	/**
	 * Test method for {@link com.zeligsoft.base.ui.menus.providers.ZDLProjectExplorerMenuFactory#createMenu()}.
	 */
	public void testCreateMenu() {
		Collection<IContributionItem> result;
		
		ZDLProjectExplorerMenuFactory factory 
			= new ZDLProjectExplorerMenuFactory(testModel);
		
		result = factory.createMenu();
		
		assertNotNull(result);
		assertTrue(String.format("Expecting %d items and got %d items.", 1, result.size()), result.size() == 1);
		IContributionItem ici = result.toArray(new IContributionItem[1])[0];
		
		assertTrue(ici instanceof ActionContributionItem);
		ActionContributionItem cca = (ActionContributionItem) ici;
		assertTrue(cca.getAction().getText().equals("Component Interface"));
		
		assertTrue(testModel.getPackagedElements().size() == 2);
		cca.getAction().run();
		assertTrue(testModel.getPackagedElements().size() == 3);
		assertTrue(ZDLUtil.isZDLConcept(testModel.getPackagedElements().get(2), "TestDomain::ComponentBlock::ComponentInterface"));
	}

	public void testCreateMenu_CreateActionWithHint() {
		Collection<IContributionItem> result;
		Component testObj = (Component) testModel.getPackagedElement("MySR");
		assertNotNull(testObj);
		ZDLProjectExplorerMenuFactory factory 
			= new ZDLProjectExplorerMenuFactory(testObj);
		
		result = factory.createMenu();
		
		assertNotNull(result);
		assertTrue(String.format("Expecting %d items and got %d items.", 1, result.size()), result.size() == 1);
		IContributionItem ici = result.toArray(new IContributionItem[1])[0];
		
		assertTrue(ici instanceof ActionContributionItem);
		ActionContributionItem cca = (ActionContributionItem) ici;
		assertTrue(cca.getAction().getText().equals("Operation"));
		
		assertTrue(testObj.getOwnedOperations().size() == 0);
		cca.getAction().run();
		assertTrue(testObj.getOwnedOperations().size() == 1);
	}
	
	public void testCreateMenu_DelegateAction() {
		Collection<IContributionItem> result;
		Component testObj = (Component) testModel.getPackagedElement("MyCI");
		assertNotNull(testObj);
		ZDLProjectExplorerMenuFactory factory 
			= new ZDLProjectExplorerMenuFactory(testObj);
		
		result = factory.createMenu();
		
		assertNotNull(result);
		assertTrue(String.format("Expecting %d items and got %d items.", 1, result.size()), result.size() == 1);
		IContributionItem ici = result.toArray(new IContributionItem[1])[0];
		
		assertTrue(ici instanceof ActionContributionItem);
		ActionContributionItem cca = (ActionContributionItem) ici;
		assertTrue(testModel.getPackagedElements().size() == 2);
		cca.getAction().run();
		assertTrue(testModel.getPackagedElements().size() == 3);
	}
}
