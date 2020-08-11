/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdlgen2umlprofile.merge;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;

/**
 * A key implementation appropriate to stereotype applications.
 * 
 * @author Christian W. Damus (cdamus)
 */
class StereotypeApplicationKey
		extends AbstractHierarchicalKey<StereotypeApplicationKey> {

	private IHierarchicalKey baseElement;

	private String stereotype;

	/**
	 * Initializes me with the base element, its key, and the aplied stereotype.
	 * 
	 * @param element the base element
	 * @param baseElement its key
	 * @param stereotype the stereotype aplied to it
	 */
	public StereotypeApplicationKey(Element element, IHierarchicalKey baseElement,
			Stereotype stereotype) {
		super(element);

		this.baseElement = baseElement;
		this.stereotype = stereotype.getQualifiedName();
	}

	@Override
	protected boolean keyEquals(StereotypeApplicationKey other) {
		return stereotype.equals(other.stereotype)
			&& baseElement.equals(other.baseElement);
	}

	@Override
	protected int keyHash() {
		return (stereotype.hashCode() * 17) + baseElement.hashCode();
	}
}
