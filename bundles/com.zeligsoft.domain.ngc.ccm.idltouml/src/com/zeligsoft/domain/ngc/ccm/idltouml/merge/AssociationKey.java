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
package com.zeligsoft.domain.ngc.ccm.idltouml.merge;

import java.util.Map;

import org.eclipse.uml2.uml.Association;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;

/**
 * A key implementation appropriate to {@link Association}s (including, of
 * course, metaclass extensions).
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class AssociationKey extends AbstractHierarchicalKey<AssociationKey> {

	private Map<String, IHierarchicalKey> classifiers;

	/**
	 * Initializes me with my association and a mapping of its member role names
	 * to the keys of the corresponding end classifiers.
	 * 
	 * @param element
	 *            the association
	 * @param classifiers
	 *            the end-classifier keys
	 */
	public AssociationKey(Association element,
			Map<String, IHierarchicalKey> classifiers) {
		super(element);

		this.classifiers = classifiers;
	}

	@Override
	protected boolean keyEquals(AssociationKey other) {
		return classifiers.equals(other.classifiers);
	}

	@Override
	protected int keyHash() {
		return classifiers.hashCode();
	}

}
