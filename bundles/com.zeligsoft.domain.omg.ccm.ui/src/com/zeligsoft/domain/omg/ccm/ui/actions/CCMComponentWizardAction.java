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
package com.zeligsoft.domain.omg.ccm.ui.actions;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.ui.wizards.CCMComponentWizard;

/**
 * CCM Component Wizard action
 * 
 * @author ysroh
 * 
 */
public class CCMComponentWizardAction extends Action implements ICXAction {

	private EObject context;

	public CCMComponentWizardAction() {
		// do nothing
	}

	/**
	 * Create me!
	 * 
	 * @param context
	 *            The object that will own the created concept
	 */
	public CCMComponentWizardAction(EObject context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.zeligsoft.domain.sca.ui.actions.ICXAction#setSelection(org.eclipse
	 * .emf.ecore.EObject)
	 */
	public void setSelection(EObject context) {
		this.context = context;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		IElementType type = ZDLElementTypeUtil.getElementType(context,
				CCMNames.CCMCOMPONENT);
		return new ElementTypeImageDescriptor(type);

	}

	/*
	 * (non-Javadoc)
	 * @see com.zeligsoft.domain.sca.ui.actions.ICXAction#run()
	 */
	@Override
	public void run() {

		CCMComponentWizard wizard = new CCMComponentWizard(context);
		String imagePath = "icons/wizban/ccm-component-wizard.png";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(pluginBundle
					.getEntry(imagePath));
			wizard.setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}
		WizardDialog wizardDialog = new WizardDialog(getShell(), wizard);
		wizardDialog.open();
	}

	/**
	 * Queries current shell
	 * 
	 * @return
	 */
	private Shell getShell() {
		return Display.getCurrent().getActiveShell();
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(context);
	}
}
