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

package com.zeligsoft.domain.omg.corba.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.omg.corba.ui.Activator;
import com.zeligsoft.domain.omg.corba.ui.l10n.Messages;

/**
 * Abstract IDL import wizard.
 * 
 * @author yroh
 * 
 */
public abstract class AbstractIDLImportWizard extends Wizard implements
		IImportWizard {

	private static final String IDL = "idl"; //$NON-NLS-1$

	protected IWorkbench workbench;

	protected IStructuredSelection selection;

	protected IDLImportWizardPage page;

	/**
	 * Constructor
	 */
	public AbstractIDLImportWizard() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {

		boolean isFinished = page.finish();
		Control control = Display.getCurrent().getActiveShell().getChildren()[0];
		control.setEnabled(false);
		
		if( isFinished )
			doIDLImport(
				page.getSelectedFileList(),
				page.getIncludeList(),
				page.getDefineList(),
				page.getExcludeList(),
				page.getTargetModelURI() );

		return isFinished;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.workbench = workbench;
		this.selection = currentSelection;
		
		String imagePath = "icons/wizban/IDL-import-wizard.png";//$NON-NLS-1$
		Bundle pluginBundle = Platform.getBundle(Activator.PLUGIN_ID);
		try {
			ImageDescriptor imageDescriptor = ImageDescriptor
				.createFromURL(pluginBundle.getEntry(imagePath));
			setDefaultPageImageDescriptor(imageDescriptor);
		} catch (Exception e) {
			// Ignore
		}
		
		List<?> selectedResources = IDE
				.computeSelectedResources(currentSelection);
		if (!selectedResources.isEmpty()) {
			this.selection = new StructuredSelection(selectedResources);
		}

		setWindowTitle(Messages.getString("IDLImportWizard.0")); //$NON-NLS-1$
		//  setDefaultPageImageDescriptor(IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/importdir_wiz.png"));//$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		initPage();
		IFile targetModel = BaseUIUtil.getFirstSelectedFile(selection, "emx"); //$NON-NLS-1$
		if (targetModel != null) {
			page.setTargetName(targetModel.getFullPath().toString());
		}
		IFile sourceFile = BaseUIUtil.getFirstSelectedFile(selection, "idl"); //$NON-NLS-1$
		if (sourceFile != null) {
			page.setSourceName(sourceFile.getParent().getLocationURI().getPath());
		}
		List<String> extensions = new ArrayList<String>(1);
		extensions.add(IDL);
		page.setFileExtensions(extensions);
		addPage(page);
	}

	protected void initPage() {
		page = new IDLImportWizardPage("fileSystemImportPage1", //$NON-NLS-1$
				workbench, Messages.getString("IDLImportWizard.1"), //$NON-NLS-1$
				Messages.getString("IDLImportWizard.2")); //$NON-NLS-1$		
	}

	/**
	 * Creates and runs an Eclipse Job to the specified IDL resource into the
	 * given emx model.
	 * 
	 * @param targetModel
	 * @param sourceIDL
	 */
	abstract public void doIDLImport(final List<String> sourceIDLs,
			final List<String> includeList, final List<String> defineList,
			final List<String> excludeList, final URI targetModel);

}
