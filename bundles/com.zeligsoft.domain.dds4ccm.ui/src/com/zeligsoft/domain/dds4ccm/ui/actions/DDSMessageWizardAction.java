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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.domain.dds4ccm.ui.wizards.DDSConnectorInstanceWizard;

/**
 * @author ysroh
 * 
 */
public class DDSMessageWizardAction extends Action implements ICXAction {

	private EObject context;

	public DDSMessageWizardAction() {
		// do nothing
	}

	/**
	 * Create me!
	 * 
	 * @param context
	 *            The object that will own the created concept
	 */
	public DDSMessageWizardAction(EObject context) {
		this.context = context;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		Bundle pluginBundle = Platform.getBundle("org.eclipse.ui"); //$NON-NLS-1$
		return ImageDescriptor.createFromURL(pluginBundle
				.getEntry("icons/full/etool16/new_wiz.gif")); //$NON-NLS-1$
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

	/*
	 * (non-Javadoc)
	 * @see com.zeligsoft.domain.sca.ui.actions.ICXAction#run()
	 */
	@Override
	public void run() {

		DDSConnectorInstanceWizard wizard = new DDSConnectorInstanceWizard(context);
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
