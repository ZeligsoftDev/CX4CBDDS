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
package com.zeligsoft.ddk.zdl2zdlgen.ui.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionDelegate;

import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl2zdlgen.Activator;
import com.zeligsoft.ddk.zdl2zdlgen.l10n.ZDL2ZDLGenMessages;
import com.zeligsoft.ddk.zdl2zdlgen.ui.wizards.ImportZDLModelWizard;

/**
 * TODO: Doc
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ReloadZDLGenActionDelegate
		extends ActionDelegate
		implements IEditorActionDelegate {

	private Shell parentShell;

	private IEditorPart editor;

	/**
	 * Initializes me.
	 */
	public ReloadZDLGenActionDelegate() {
		super();
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editor = targetEditor;
		parentShell = (editor == null)
			? null
			: targetEditor.getSite().getShell();

		action.setEnabled(editor != null);
	}

	@Override
	public void run(IAction action) {
		URI uri = EditUIUtil.getURI(editor.getEditorInput());
		EditingDomain domain = ((IEditingDomainProvider) editor
			.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
		final Resource res = domain.getResourceSet().getResource(uri, false);
		
		if (res != null) {
			if (editor.isDirty() && !promptToSave(editor)) {
				return;
			}
			
			reload(res);
		}
	}

	private void reload(Resource res) {
		GenModel model = (GenModel) EcoreUtil.getObjectByType(
			res.getContents(), ZDLGenPackage.Literals.GEN_MODEL);
		
		ImportZDLModelWizard wizard = new ImportZDLModelWizard();
		wizard.setReloadModel(model);  // force reloading the same model
		wizard.init(editor.getSite().getWorkbenchWindow().getWorkbench(),
			StructuredSelection.EMPTY);
		
		WizardDialog dlg = new WizardDialog(parentShell, wizard);
		dlg.setBlockOnOpen(true);
		if ((dlg.open() == Window.OK)
			&& (wizard.getStatus().getSeverity() < IStatus.ERROR)) {
			
			// re-load the editor input
			res.unload();
			try {
				res.load(Collections.EMPTY_MAP);
			} catch (IOException e) {
				Log.error(Activator.getDefault(), 0, 
						"Error reloading ZDL.", e); //$NON-NLS-1$
			}
		}
	}

	private boolean promptToSave(IEditorPart editor) {
		boolean result = MessageDialog
			.openConfirm(
				parentShell,
				ZDL2ZDLGenMessages.ReloadZDLGenActionDelegate_confirm,
				NLS
					.bind(
						ZDL2ZDLGenMessages.ReloadZDLGenActionDelegate_dirtyEditor,
						editor.getTitle()));
		
		if (result) {
			editor.doSave(new NullProgressMonitor());
		}
		
		return result;
	}
}
