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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * A key implementation appropriate to {@link EPackage}s that are dynamic
 * profile definitions.
 * 
 * @author Christian W. Damus (cdamus)
 */
class ProfileDefinitionKey
		extends AbstractHierarchicalKey<ProfileDefinitionKey> {

	@SuppressWarnings("unused")
	private String name;
	private String nsURI;

	@SuppressWarnings("unused")
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
		this.nsURI = element.getNsURI();
		this.name = element.getName();
		this.version = version;
	}

	@Override
	protected boolean keyEquals(ProfileDefinitionKey other) {
		return UML2Util.safeEquals(nsURI, other.nsURI);
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyHash()
	 */
	@Override
	protected int keyHash() {
		int result = (nsURI == null)
			? 0
			: nsURI.hashCode();

		result = (result * 17);
		
		return result;
	}
}
