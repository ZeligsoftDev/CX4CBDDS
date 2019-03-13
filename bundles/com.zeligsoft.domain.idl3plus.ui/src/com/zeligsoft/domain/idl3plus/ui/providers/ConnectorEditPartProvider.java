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
package com.zeligsoft.domain.idl3plus.ui.providers;

import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.internal.editparts.ConnectorPartEditPart;

/**
 * Connector part EditPart provider
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("rawtypes")
public class ConnectorEditPartProvider extends AbstractEditPartProvider {

	protected Class getNodeEditPartClass(final View view) {

		if (view.getElement() != null && view.getElement() instanceof Property) {
			Property part = (Property) view.getElement();
			if (ZDLUtil.isZDLConcept(part, IDL3PlusNames.DATA_SPACE)) {
				return ConnectorPartEditPart.class;
			}
		}
		return null;
	}
}