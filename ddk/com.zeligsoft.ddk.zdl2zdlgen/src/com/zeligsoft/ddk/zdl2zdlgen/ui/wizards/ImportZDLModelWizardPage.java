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
package com.zeligsoft.ddk.zdl2zdlgen.ui.wizards;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import com.zeligsoft.ddk.zdl.zdlgen.util.ZDLGenResource;
import com.zeligsoft.ddk.zdl2zdlgen.Activator;
import com.zeligsoft.ddk.zdl2zdlgen.l10n.ZDL2ZDLGenMessages;


/**
 * The first (and optional) page in the ZDL importer wizard, for the specification
 * of the ZDLGen resource to create.  It is not used when re-loading an existing
 * ZDLGen model (in the editor).
 *
 * @author Christian W. Damus (cdamus)
 */
class ImportZDLModelWizardPage
		extends WizardNewFileCreationPage {

	/**
	 * Initializes me with the current workbench selection.
	 * 
	 * @param selection the workbench selection
	 */
	public ImportZDLModelWizardPage(IStructuredSelection selection) {
		super("ImportZDLModel", selection); //$NON-NLS-1$
	}

	@Override
	protected boolean validatePage() {
		boolean result = super.validatePage();
		
		if (result) {
			String extension = new Path(getFileName()).getFileExtension();
			
			if (!ZDLGenResource.FILE_EXTENSION.equals(extension)) {
				setErrorMessage(NLS.bind(ZDL2ZDLGenMessages.ImportZDLModelWizardPage_badExtension, ZDLGenResource.FILE_EXTENSION));
				result = false;
			}
		}
		
		return result;
	}
	
	@Override
	protected InputStream getInitialContents() {
		try {
			return Activator.getDefault().getBundle().getEntry("/templates/blank.zdlgen").openStream(); //$NON-NLS-1$
		} catch (IOException e) {
			Log.error(Activator.getDefault(), 0, 
					"Exception in ImportZDLModelWizardPage#getInitialContents",  //$NON-NLS-1$
					e);
			return null;
		}
	}
}
