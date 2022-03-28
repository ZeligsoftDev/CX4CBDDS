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

package com.zeligsoft.domain.omg.ccm.ui.editparts;

import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.swt.graphics.Image;

public class CCMPartWrappingLabel extends PapyrusWrappingLabel {

	private Image icon = null;

	@Override
	public void setIcon(Image image, int index) {
		if(image == null) {
			super.setIcon(image, index);
			return;
		}
		// force to use the CCMComponent icon for CCMPart
		if (icon == null) {
			IElementType result = ElementTypeRegistry.getInstance()
					.getType("com.zeligsoft.zdl.cxDDS4CCM.CCM__CCM_Component__CCMComponent");
			icon = IconService.getInstance().getIcon(result);
		}
		super.setIcon(icon, index);
	}
}
