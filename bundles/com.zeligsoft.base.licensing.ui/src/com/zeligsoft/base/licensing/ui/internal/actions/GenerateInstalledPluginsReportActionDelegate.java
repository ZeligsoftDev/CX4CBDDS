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

package com.zeligsoft.base.licensing.ui.internal.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.licensing.ui.Activator;
import com.zeligsoft.base.licensing.ui.internal.l10n.Messages;


/**
 * Action delegate for the "Generate Installed Plugins Report" action.
 *
 * @author mtate
 */
public class GenerateInstalledPluginsReportActionDelegate
		extends ActionDelegate implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;
	
	/**
	 * Initializes me.
	 */
	public GenerateInstalledPluginsReportActionDelegate() {
		super();
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	
	@Override
	public void run(IAction action) {		
		FileDialog dlg = new FileDialog(window.getShell(), SWT.SAVE);
		dlg.setFilterExtensions(new String[] {"*"+Messages.GenerateInstalledPluginsReport_fileExtension, "*.*"}); //$NON-NLS-1$ //$NON-NLS-2$
		dlg.setText(Messages.GenerateInstalledPluginsReport_title);
		dlg.setOverwrite(true);
		
		String fileName = dlg.open();
		
		if (fileName != null && !fileName.isEmpty()) {
			if (!fileName.endsWith(Messages.GenerateInstalledPluginsReport_fileExtension)){
				fileName = fileName.concat(Messages.GenerateInstalledPluginsReport_fileExtension);
			}
			Bundle[] bundles = Activator.getContext().getBundles();
			
			File file = new File(fileName);
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				writer.write(Messages.GenerateInstalledPluginsReport_fileHeader);
				writer.newLine();
				for (Bundle bundle : bundles) {
					writer.write(bundle.getSymbolicName() + " version: " + bundle.getVersion()); //$NON-NLS-1$
					writer.newLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
