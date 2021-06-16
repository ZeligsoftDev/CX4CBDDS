/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import org.eclipse.papyrus.uml.diagram.common.actions.handlers.AbstractShowHideHandler;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;

/**
 * Action to reset compartment filters on a composite structure diagram
 * 
 * @author ysroh
 * 
 */
public class ResetCompartmentFilterActionHandler extends AbstractShowHideHandler {

	public ResetCompartmentFilterActionHandler() {
		super(new ResetCompartmentFilterAction(), ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY);
	}


}
