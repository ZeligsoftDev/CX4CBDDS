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
package com.zeligsoft.cx.ui.actions;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.cx.ui.wizard.PortTypeCreationWizard;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Add SCA Build Configuration action
 * 
 * @author ysroh
 * 
 */
public class AddPortTypeAction extends Action implements ICXAction {

	protected EObject context;

	@Override
	public void setSelection(EObject context) {

		this.context = context;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		IElementType type = ZDLElementTypeUtil.getElementType(context,
				ZMLMMNames.PORT_TYPE);
		return new ElementTypeImageDescriptor(type);
	}

	@Override
	public void run() {
		Element element = (Element) context;

		if (element == null) {
			return;
		}

		PortTypeCreationWizard wizard = new PortTypeCreationWizard(element);
		wizard
				.setWindowTitle(Messages.AddZeligsoftPortTypeActionDelegate_WizardWindowTitle);
		String imagePath = "icons/wizban/porttype-wizard.png";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(ZeligsoftCXUIPlugin.PLUGIN_ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(pluginBundle
					.getEntry(imagePath));
			wizard.setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}

		WizardDialog wizardDialog = new WizardDialog(Display.getCurrent()
				.getActiveShell(), wizard);
		wizardDialog.open();
	}

}
