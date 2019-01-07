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
package com.zeligsoft.domain.sca.agilent.importer.ui.wizards;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.domain.sca.agilent.importer.ui.l10.AgilentImporterMessages;
import com.zeligsoft.domain.sca.agilent.importer.ui.pages.AgilentImportPage;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class AgilentXmlImportWizard extends Wizard implements IImportWizard {

	private static final String XML = "xml"; //$NON-NLS-1$
	
	private IWorkbench workbench;
	private IStructuredSelection selection;
	private AgilentImportPage page;
	
	/**
	 * 
	 */
	public AgilentXmlImportWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		boolean isFinished = page.finish();
		if(isFinished) {
			this.importAgilentXmlResources();
		}
		
		return isFinished;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		List<?> selectedResources = IDE.computeSelectedResources(this.selection);
		if(!selectedResources.isEmpty()) {
			this.selection = new StructuredSelection(selectedResources);
		}
		
		setWindowTitle(AgilentImporterMessages.AgilentXmlImportWizard_title);
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public void addPages() {
		super.addPages();
		page = new AgilentImportPage("fileSystemImportPage1", 
				workbench, 
				selection,
				AgilentImporterMessages.AgilentXmlImportWizard_import_page_title, 
				AgilentImporterMessages.AgilentXmlImportWizard_import_page_description);
		
		List<String> extensions = Collections.singletonList(XML);
		page.setFileExtensions(extensions);
		
		
		addPage(page);
	}

	private void importAgilentXmlResources() {
		//final ArrayList<String> uriList = new ArrayList<String>();
		final String targetModelPath = page.getTarget();
		final String sourceXmlPath = page.getSource();
		//final List<Object> fileSystemObjects = page.getFileSystemObjects();
		
		/*if(fileSystemObjects.size() <= 0) {
			return;
		}*/
		
		/*for(Object fileObject : fileSystemObjects) {
			File file = (File) fileObject;
			URI uri = URI.createPlatformResourceURI(file.getAbsolutePath(), false);
			String uriString = uri.toPlatformString(false);
			uriList.add(uriString);
		}*/
		
		Job importJob = new Job(AgilentImporterMessages.AgilentXmlImportWizard_import_job_name) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Bundle bundle = Platform.getBundle("com.zeligsoft.domain.sca.agilent.importer"); //$NON-NLS-1$
				URL url = bundle.getEntry("workflow/systemvueImport.oaw"); //$NON-NLS-1$
				
				Map<String, Object> slots = new HashMap<String, Object>();
				
				
				Map<String, String> properties = new HashMap<String, String>();
				properties.put("modelFile", sourceXmlPath);
				properties.put("sourceModel", targetModelPath); //$NON-NLS-1$
				
				return WorkflowUtil.executeWorkflow(url, monitor, properties, slots);
			}
		};
		
		importJob.setUser(true);
		importJob.schedule();
		
	}
}
