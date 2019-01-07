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

import java.util.Set;

import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Usage;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;
import com.zeligsoft.base.util.ModelMerger.IHierarchicalKey;
import com.zeligsoft.domain.idl3plus.l10n.Messages;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class UsageKey
	extends AbstractHierarchicalKey<UsageKey>{

	private Set<IHierarchicalKey> sources;
	protected String relName;
	
	/**
	 * @param element
	 */
	public UsageKey(Usage element, Set<IHierarchicalKey> sources) {
		super(element);
		
		if(element == null) {
			throw new IllegalArgumentException(Messages.InterfaceRealizationKey_ImplementingClassifierNotNull);
		}
		
		this.sources = sources;
		relName = element.getName();
		
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyEquals(com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey)
	 */
	@Override
	protected boolean keyEquals(UsageKey other) {
		return sources.equals(other.sources) && 
			UML2Util.safeEquals(relName, other.relName);
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey#keyHash()
	 */
	@Override
	protected int keyHash() {
		int keyHash = (relName == null) ? 0 : relName.hashCode() * 31;
		keyHash += sources.hashCode();
		return keyHash;
	}
}
