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
package com.zeligsoft.base.ui.providers;

import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

/**
 * ZDL-based generic edit part provider.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("rawtypes") // GMF is not J2SE 5.0
public class ZDLEditPartProvider
		extends AbstractEditPartProvider {

	@Override
	protected Class getNodeEditPartClass(View view) {
		String type = view.getType();
		
		// look for the label hints defined by us for generic ZDL references
		if ((type != null) && (type.length() > 0)
			&& type.startsWith(ZDLViewProvider.HINT_PREFIX)
			&& type.endsWith(ZDLViewProvider.HINT_LABEL_EP_SUFFIX)) {
			return ZDLReferenceLabelEditPart.class;
		} else if ((type != null) && (type.length() > 0)
			&& type.startsWith(ZDLViewProvider.HINT_PREFIX)
			&& type.endsWith(ZDLViewProvider.HINT_TEXT_EP_SUFFIX)) {
			return ZDLReferenceTextEditPart.class;
		}

		return null;
	}

	@Override
	protected Class getEdgeEditPartClass(View view) {
		String type = view.getType();
		
		// look for the edge hints defined by us for generic ZDL references
		if ((type != null) && (type.length() > 0)
			&& type.startsWith(ZDLViewProvider.HINT_PREFIX)
			&& type.endsWith(ZDLViewProvider.HINT_EP_SUFFIX)) {
			return ZDLReferenceEditPart.class;
		}

		return null;
	}
}