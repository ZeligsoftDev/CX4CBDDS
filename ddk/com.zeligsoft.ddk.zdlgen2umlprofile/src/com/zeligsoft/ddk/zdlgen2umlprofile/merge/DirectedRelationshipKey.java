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

import java.util.Set;

import org.eclipse.uml2.uml.DirectedRelationship;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;

/**
 * A key implementation apprpriate to {@link DirectedRelationship}s, generally.
 * 
 * @author Christian W. Damus (cdamus)
 */
class DirectedRelationshipKey
		extends AbstractHierarchicalKey<DirectedRelationshipKey> {

	private Set<IHierarchicalKey> sources;

	private Set<IHierarchicalKey> targets;

	/**
	 * Initializes me wih a directed relationship and the keys of its related
	 * elements.
	 * 
	 * @param element
	 *            the relationship
	 * @param sources
	 *            the keys of its sources
	 * @param targets
	 *            the keys of its targets
	 */
	public DirectedRelationshipKey(DirectedRelationship element,
			Set<IHierarchicalKey> sources, Set<IHierarchicalKey> targets) {
		super(element);

		this.sources = sources;
		this.targets = targets;
	}

	@Override
	protected boolean keyEquals(DirectedRelationshipKey other) {
		return sources.equals(other.sources) && targets.equals(other.targets);
	}

	@Override
	protected int keyHash() {
		return sources.hashCode() * 37 + targets.hashCode();
	}
}
