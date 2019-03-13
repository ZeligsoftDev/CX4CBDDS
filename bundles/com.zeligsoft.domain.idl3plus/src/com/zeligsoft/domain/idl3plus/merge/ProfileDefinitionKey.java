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
package com.zeligsoft.domain.idl3plus.merge;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * A key implementation appropriate to {@link EPackage}s that are dynamic
 * profile definitions.
 * 
 * @author Toby McClean (tmcclean)
 */
class ProfileDefinitionKey extends
		AbstractHierarchicalKey<ProfileDefinitionKey> {

	/**
	 * 
	 */
	private static final int HASH_CONSTANT = 17;

	private String name;

	private int version;

	/**
	 * Initializes me with a profile definition and its version index.
	 * 
	 * @param element
	 *            a profile definition
	 * @param version
	 *            its index in the annotation contents list
	 */
	public ProfileDefinitionKey(EPackage element, int version) {
		super(element);

		this.name = element.getName();
		this.version = version;
	}

	@Override
	protected boolean keyEquals(ProfileDefinitionKey other) {
		return (version == other.version)
				&& UML2Util.safeEquals(name, other.name);
	}

	@Override
	protected int keyHash() {
		int result = (name == null) ? 0 : name.hashCode();

		result = (result * HASH_CONSTANT) + version;

		return version;
	}

}
