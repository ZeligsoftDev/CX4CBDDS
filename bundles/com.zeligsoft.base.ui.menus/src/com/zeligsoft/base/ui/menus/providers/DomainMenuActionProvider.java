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
package com.zeligsoft.base.ui.menus.providers;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.menus.l10.Messages;
import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Dynamic action generator for Project explorer
 * 
 * @author ysroh
 * 
 */

public class DomainMenuActionProvider extends CommonActionProvider {

	private static final String GROUP_NEW = "group.new";

	@Override
	public void fillContextMenu(IMenuManager menu) {
		IMenuManager cxmenu;
		cxmenu = new MenuManager(
				Messages.DomainSpecificContributionItemProvider_add_cx_submenu_label);
		menu.appendToGroup(GROUP_NEW, cxmenu);
		ISelection selection = BaseUIUtil.getSelection();
		if(selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() > 1){
			return;
		}
		EObject eo = BaseUIUtil.getEObjectFromSelection(selection);
		if (eo instanceof Element) {
			ZDLProjectExplorerMenuFactory factory = new ZDLProjectExplorerMenuFactory(
					(Element) eo);
			Collection<IContributionItem> contributions = factory.createMenu();
			for (IContributionItem item : contributions) {
				cxmenu.add(item);
			}
		}
	}
}
