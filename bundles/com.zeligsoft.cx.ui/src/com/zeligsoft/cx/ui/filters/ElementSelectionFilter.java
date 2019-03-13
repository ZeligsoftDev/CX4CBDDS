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
package com.zeligsoft.cx.ui.filters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Filter for element selection composite.
 * 
 * @author ysroh
 * 
 */
public class ElementSelectionFilter
		implements IFilter {

	private String concept;

	private String property;

	private List<String> concepts = new ArrayList<String>();

	/**
	 * Constructor
	 * 
	 * @param concept
	 *            domain concept
	 * @param property
	 *            stereotype property where selected item will be saved on
	 */
	public ElementSelectionFilter(String concept, String property) {
		this.concept = concept;
		this.property = property;
	}

	/**
	 * Add additional concepts to filter for the selection list
	 * 
	 * @param concepts
	 */
	public void addConceptsToFilter(List<String> concepts) {
		this.concepts.addAll(concepts);
	}

	/**
	 * Add additional concept to filter out for the selection list
	 * 
	 * @param concept
	 */
	public void addConceptToFilter(String concept) {
		concepts.add(concept);
	}

	@Override
	public boolean select(Object toTest) {

		EObject eo = null;

		if (toTest instanceof EObject) {
			eo = (EObject) toTest;
		} else if (toTest instanceof IAdaptable) {
			eo = (EObject) ((IAdaptable) toTest).getAdapter(EObject.class);
		} else if (toTest instanceof IStructuredSelection) {
			eo = BaseUIUtil
				.getEObjectFromSelection((IStructuredSelection) toTest);
		}

		if (!concepts.isEmpty()) {
			boolean conceptFound = false;
			for (String aConcept : concepts) {
				if (ZDLUtil.isZDLConcept(eo, aConcept)) {
					conceptFound = true;
					break;
				}
			}
			if (!conceptFound) {
				return false;
			}
		}

		if (eo != null && property != null) {
			if (ZDLUtil.isZDLTypeOf(eo, concept, property)) {
				return true;
			}
			return false;
		}

		return true;
	}
}
