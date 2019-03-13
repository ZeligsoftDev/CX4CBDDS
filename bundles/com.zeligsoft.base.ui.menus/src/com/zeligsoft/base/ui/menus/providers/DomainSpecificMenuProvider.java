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
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Dynamic action group which consults the menu model of
 * a domain profile to create the actions.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class DomainSpecificMenuProvider extends CompoundContributionItem {
	
	@Override
	public IContributionItem[] getContributionItems() {
		Collection<IContributionItem> items = calculateContributionItems(getSelectedEObject());

		if (items != null && items.size() != 0) {
			return items.toArray(new IContributionItem[items.size()]);
		} else {
			return new IContributionItem[] {};
		}
	}

	/**
	 * get all contribution items
	 */
	@SuppressWarnings("unchecked")
	public static Collection<IContributionItem> calculateContributionItems(
			EObject eObj) {
		if (eObj != null && eObj instanceof Element) {
			ZDLProjectExplorerMenuFactory factory = new ZDLProjectExplorerMenuFactory(
					(Element) eObj);
			return factory.createMenu();
		}
		return Collections.EMPTY_LIST;
	}
	
	private EObject getSelectedEObject() {
		ISelection selection = BaseUIUtil.getSelection();
		if(selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() > 1){
			return null;
		}
		return selection == null ? null : BaseUIUtil
				.getEObjectFromSelection(selection);
	}
}