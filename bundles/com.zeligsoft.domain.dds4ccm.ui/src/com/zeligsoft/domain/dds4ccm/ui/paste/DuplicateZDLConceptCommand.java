/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.paste;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.util.FilteringList;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Copy DDS4CCM concept references
 * 
 * @author Young-Soo Roh
 *
 */
public class DuplicateZDLConceptCommand extends RecordingCommand {

	private Element element;

	private org.eclipse.uml2.uml.Class concept;

	private Map<Property, Object> featureValueMap = new HashMap<Property, Object>();

	public DuplicateZDLConceptCommand(TransactionalEditingDomain domain, Element element,
			org.eclipse.uml2.uml.Class concept, Map<Property, Object> valueMap) {
		super(domain);
		this.element = element;
		this.concept = concept;
		this.featureValueMap.putAll(valueMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doExecute() {
		for (Entry<Property, Object> entry : featureValueMap.entrySet()) {
			Property feature = entry.getKey();
			Object value = entry.getValue();
			if (feature.isMultivalued()) {
				List<Object> target = (List<Object>) ZDLUtil.getValue(element, concept, feature.getName());
				if (feature.isComposite() && !target.isEmpty()) {
					// If the containment value is already copied then ignore.
					// Work-around for the Cut & Paste Papyrus issue
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=561667
					continue;
				}
				copyListReferences((List<Object>) value, target, feature.isComposite());
			} else {
				if (feature.isComposite()) {
					Object existing = ZDLUtil.getValue(element, concept, feature.getName());
					// If this is handled properly by Papyrus then the value shouldn't be empty.
					// In that case, we can ignore safely
					if (existing == null) {
						ZDLUtil.setValue(element, concept, entry.getKey().getName(),
								EcoreUtil.copy((EObject) entry.getValue()));
					}
				} else {
					ZDLUtil.setValue(element, concept, entry.getKey().getName(), entry.getValue());
				}
			}
		}
	}

	/**
	 * A helper method to copy the elements from a source list to a target list.
	 * 
	 * @param source The list of elements to copy
	 * @param target The list to copy the elements to
	 */
	protected void copyListReferences(List<Object> source, List<Object> target, boolean containment) {
		target.clear();
		int index = 0;
		for (Object referencedObject : source) {
			if (containment) {
				addUniqueHelper(target, index, EcoreUtil.copy((EObject) referencedObject));
			} else {
				addUniqueHelper(target, index, referencedObject);
			}
			++index;
		}
	}

	/**
	 * A utility function to copy to a unique list.
	 * 
	 * @param target The list to copy into
	 * @param index  The index to store it in
	 * @param object The object to copy to
	 */
	protected static void addUniqueHelper(List<Object> target, int index, Object object) {
		if (target.contains(object)) {
			return;
		}

		if (target instanceof FilteringList) {
			((FilteringList<Object>) target).addUnique(index, object);
		} else if (target instanceof InternalEList) {
			((InternalEList<Object>) target).addUnique(index, object);
		} else {
			if (!target.contains(object)) {
				target.add(index, object);
			}
		}
	}
}
