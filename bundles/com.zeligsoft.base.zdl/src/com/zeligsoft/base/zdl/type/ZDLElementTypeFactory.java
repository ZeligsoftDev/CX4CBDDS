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
package com.zeligsoft.base.zdl.type;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeFactory;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;

/**
 * Element-type factory for ZDL Concept and Reference types.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLElementTypeFactory
		extends AbstractElementTypeFactory {

	static final String KIND = "com.zeligsoft.zdl.concept"; //$NON-NLS-1$

	static final String PARAM_CONCEPT = "concept"; //$NON-NLS-1$

	static final String PARAM_REFERENCE = "reference"; //$NON-NLS-1$

	/**
	 * Initializes me.
	 */
	public ZDLElementTypeFactory() {
		super();
	}

	@Override
	public IMetamodelType createMetamodelType(
			IMetamodelTypeDescriptor descriptor) {
		// TODO Support for profile classes
		return super.createMetamodelType(descriptor);
	}

	@Override
	public ISpecializationType createSpecializationType(
			ISpecializationTypeDescriptor descriptor) {

		String concept = descriptor.getParamValue(PARAM_CONCEPT);
		String reference = descriptor.getParamValue(PARAM_REFERENCE);

		if (reference == null) {
			ZDLElementMatcher matcher = new ZDLElementMatcher(concept);

			return new ZDLElementType(concept, descriptor.getId(), descriptor
				.getIconURL(), descriptor.getName(), descriptor
				.getSpecializedTypes(), matcher, descriptor
				.getContainerDescriptor(), descriptor.getEditHelperAdvice());
		}
		ZDLReferenceMatcher matcher = new ZDLReferenceMatcher(concept,
			reference);

		return new ZDLElementType(concept, reference, descriptor.getId(),
			descriptor.getIconURL(), descriptor.getName(), descriptor
				.getSpecializedTypes(), matcher, descriptor
				.getContainerDescriptor(), descriptor.getEditHelperAdvice());

	}

}
