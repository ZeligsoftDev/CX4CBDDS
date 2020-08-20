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

import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.toolingmodel.PaletteItem;
import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * A key implementation appropriate to {@link PaletteItem}s, generally.
 * 
 * @author Christian W. Damus (cdamus)
 */
class PaletteItemKey
		extends AbstractHierarchicalKey<PaletteItemKey> {

	private String name;

	/**
	 * Initializes me with a palette item and the key of the element that it
	 * represents in the palette.
	 * 
	 * @param element
	 *            the palette item
	 */
	public PaletteItemKey(PaletteItem element) {
		super(element);

		this.name = element.getName();
	}

	@Override
	protected boolean keyEquals(PaletteItemKey other) {
		return UML2Util.safeEquals(name, other.name);
	}

	@Override
	protected int keyHash() {
		return (name == null)
			? 0
			: name.hashCode();
	}
}
