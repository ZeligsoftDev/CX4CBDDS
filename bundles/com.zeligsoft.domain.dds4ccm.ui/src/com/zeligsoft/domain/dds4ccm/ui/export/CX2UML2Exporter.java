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

package com.zeligsoft.domain.dds4ccm.ui.export;

import com.ibm.xtools.rmp.core.IConverterHandler;
import com.ibm.xtools.rmp.core.internal.convert.IConverter;
import com.ibm.xtools.uml.core.internal.convert.UML2Exporter;

/**
 * UML2 exporter class
 * 
 * @author Young-Soo Roh
 *
 */
public class CX2UML2Exporter extends UML2Exporter {

	public CX2UML2Exporter(boolean exportAppliedProfiles, boolean recreateIDs,
			IConverterHandler theConverterHandler) {
		super(exportAppliedProfiles, recreateIDs, theConverterHandler);
	}

	@Override
	protected IConverter getConverter() {
		return new CX2UML2(!isExportAppliedProfiles(), isRecreateIDs());
	}

}
