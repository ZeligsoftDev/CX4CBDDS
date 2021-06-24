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
package com.zeligsoft.base.ui.menus.util;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.ui.menus.providers.DomainSpecificMenuProvider;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * CX menu property tester to test if the Add CX menu should be visible
 * 
 * @author ysroh
 * 
 */
public class CXMenuPropertyTester extends PropertyTester {

	// todo: need to make this work
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof IStructuredSelection)) {
			return false;
		}

		IStructuredSelection selection = (IStructuredSelection) receiver;
		if (!selection.isEmpty()) {
			EObject testObject = null;
			Iterator<?> iter = selection.iterator();
			while (iter.hasNext()) {
				testObject = EMFHelper.getEObject(iter.next());
				if (testObject instanceof Element) {
					break;
				}
			}

			if (testObject != null) {
				boolean profileFound = false;
				if (testObject instanceof Element) {
					for (Profile p : ZDLUtil.getZDLProfiles((Element) testObject)) {
						if (!p.getName().equals("ZDL")) { //$NON-NLS-1$
							profileFound = true;
							break;
						}
					}
				}
				if (profileFound) {
					Collection<IContributionItem> menuItems = DomainSpecificMenuProvider
							.calculateContributionItems(testObject);
					if (menuItems.size() > 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
