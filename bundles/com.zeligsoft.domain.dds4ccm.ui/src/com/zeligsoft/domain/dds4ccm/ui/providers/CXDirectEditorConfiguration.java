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
package com.zeligsoft.domain.dds4ccm.ui.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.infra.gmfdiag.extensionpoints.editors.configuration.AbstractBasicDirectEditorConfiguration;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.filters.DDS4CCMDomainFilter;

/**
 * Direct editor configuration to override xtext one. See Issue
 * https://github.com/ZeligsoftDev/CX4CBDDS/issues/309
 * 
 * @author Young-Soo Roh
 *
 */
public class CXDirectEditorConfiguration extends AbstractBasicDirectEditorConfiguration {

	@Override
	public String getTextToEdit(final Object objectToEdit) {
		String result = null;
		if (objectToEdit instanceof NamedElement
				&& ZDLUtil.isZDLProfile((NamedElement) objectToEdit, DDS4CCMDomainFilter.DDS4CCM_PROFILE_NAME)) {
			result = ((NamedElement) objectToEdit).getName();
		}

		return null != result ? result : super.getTextToEdit(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IParser createDirectEditorParser() {
		return new CXDirectEditorParser(getTextToEdit(objectToEdit));
	}
}
