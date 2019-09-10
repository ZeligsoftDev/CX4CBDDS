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
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IContributionItem;
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

	@SuppressWarnings("unchecked")
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		EObject testObject = null;
		if (receiver instanceof List && ((List<Object>) receiver).size() > 0) {
			Object obj = ((List<Object>) receiver).get(0);
			// to do: papyrus model explorer element
//			if (obj instanceof ModelServerElement) {
//				Object element = ((ModelServerElement) obj).getElement();
//				if (element instanceof EObject) {
//					testObject = (EObject) element;
//				}
//			}
		}
		if (testObject != null) {
			if (testObject instanceof Element) {
				if (ZDLUtil.getZDLProfiles((Element) testObject).size() > 0) {
					Profile profile = ZDLUtil
							.getZDLProfiles((Element) testObject).iterator()
							.next();
					if (profile.getName().equals("ZDL")) { //$NON-NLS-1$
						// we need to show Add CX menu for DDK
						return true;
					}
				} else {
					return false;
				}
			}
			Collection<IContributionItem> menuItems = DomainSpecificMenuProvider
					.calculateContributionItems(testObject);
			if (menuItems.size() > 0) {
				return true;
			}
		}
		return false;
	}

}
