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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.util.ModelMerger.AbstractHierarchicalKey;

/**
 * A key implementation appropriate to {@link ValueSpecification}s, generally.
 * 
 * @author Toby McClean (tmcclean)
 */
class ValueSpecificationKey extends
		AbstractHierarchicalKey<ValueSpecificationKey> {

	private EReference containment;

	private String value;

	public ValueSpecificationKey(ValueSpecification element) {
		super(element);

		this.containment = element.eContainmentFeature();
		this.value = element.stringValue();
	}

	@Override
	protected boolean keyEquals(ValueSpecificationKey other) {
		return (containment == other.containment)
				&& UML2Util.safeEquals(value, other.value);
	}

	@Override
	protected int keyHash() {
		int valueHash = (value == null) ? 0 : value.hashCode();

		return (containment.hashCode() * 17) + valueHash;
	}

}
