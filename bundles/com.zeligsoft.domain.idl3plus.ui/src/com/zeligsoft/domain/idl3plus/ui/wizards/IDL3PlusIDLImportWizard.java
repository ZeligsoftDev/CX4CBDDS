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

package com.zeligsoft.domain.idl3plus.ui.wizards;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.omg.corba.ui.wizards.AbstractIDLImportWizard;

/**
 * CCM IDL import wizard.
 * 
 * @author smcfee
 * 
 */
public class IDL3PlusIDLImportWizard extends AbstractIDLImportWizard {

	/**
	 * Creates and runs an Eclipse Job to the specified IDL resources into the
	 * given emx model.
	 * 
	 * @param targetModel
	 * @param sourceIDLs
	 */
	@Override
	public void doIDLImport(final List<String> sourceIDLs,
			final List<String> includeList, final List<String> defineList,
			final List<String> excludeList, final URI targetModel) {
		Job importJob = new Job("Importing IDL") { //$NON-NLS-1$

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				try {
					// There is race condition with the wizard dialog so we need
					// to put this thread sleep 1 second to allow wizard dialog
					// to close
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// do nothing
				}
				
				Map<String, String> properties = new HashMap<String, String>();
				properties.put(
						"targetModel", targetModel.toPlatformString(false)); //$NON-NLS-1$

				String conceptHint = "CCMComponent"; //$NON-NLS-1$
				String profileToApply = BaseUIUtil.getProfileApplyingConcept(
						targetModel, conceptHint, editingDomain);

				properties.put("profileToApply", profileToApply); //$NON-NLS-1$

				Map<String, Object> slots = new HashMap<String, Object>();
				slots.put("sourceFileList", sourceIDLs); //$NON-NLS-1$
				slots.put("includeList", includeList); //$NON-NLS-1$
				slots.put("defineList", defineList); //$NON-NLS-1$
				slots.put("excludeList", excludeList); //$NON-NLS-1$
				slots.put("rset", editingDomain.getResourceSet()); //$NON-NLS-1$

				IDLImporter importer = new IDLImporter( monitor, properties, slots );
				try {
					editingDomain.getCommandStack().execute(
							new ChangeCommand(
								editingDomain,
								importer,
								Messages.IDLImportWizard_ImportIDLOperationName ) );
				} catch( Exception e ) {
					MultiStatus ms = new MultiStatus(
							Activator.PLUGIN_ID, 0, NLS.bind(
									importer.result.getMessage(), null), null);
				    ms.add(createStatus(Status.ERROR, "Plug-in Vendor: " + importer.getBundleVendor())); //$NON-NLS-1$
				    ms.add(createStatus(Status.ERROR, "Plug-in Name: " + importer.getBundleName())); //$NON-NLS-1$
				    ms.add(createStatus(Status.ERROR, "Plug-in ID: " + importer.getSymbolicName())); //$NON-NLS-1$
				    ms.add(createStatus(Status.ERROR, "Version: " + importer.getBundleVersion())); //$NON-NLS-1$
				    ms.add(importer.result);
					return ms;
				}
				
				return importer.result;

			}

		};

		importJob.setUser(true);
		importJob.schedule();
	}
	
	protected Status createStatus(int severity, String msg) {
	    Status status = new Status(severity, Activator.PLUGIN_ID, IStatus.OK, msg, null);
	    return status;
	}

	@Override
	protected void initPage() {
		super.initPage();
		page.setRootDirectoryDialogSettingKey("IDL3PlusIDLImportRootDirectory"); //$NON-NLS-1$
		page.setTargetModelDialogSettingKey("IDL3PlusIDLImportTargetModel"); //$NON-NLS-1$
		page.setDefineDialogSettingKey("IDL3PlusIDLImportDefineInput"); //$NON-NLS-1$
		page.setIncludeDialogSettingKey("IDL3PlusIDLImportIncludeInput"); //$NON-NLS-1$
		page.setIncludeDialogSettingKey("IDL3PlusIDLImportExcludeInput"); //$NON-NLS-1$

	}

	private static class IDLImporter implements Runnable
	{
		public IStatus result;

		private final IProgressMonitor monitor;
		private final Map<String, String> properties;
		private final Map<String, Object> slots;
		
		private static Bundle bundle;
		
		static {
			bundle = Platform.getBundle("com.zeligsoft.domain.idl3plus.idlimport");//$NON-NLS-1$
		}

		public IDLImporter( IProgressMonitor monitor, Map<String, String> properties, Map<String, Object> slots )
		{
			this.monitor = monitor;
			this.properties = properties;
			this.slots = slots;
		}

		public String getBundleVersion() {
			if( bundle != null ) {
				Object bundleVersion = bundle.getHeaders().get("Bundle-Version"); //$NON-NLS-1$
				if( bundleVersion != null ) {
					return bundleVersion.toString();
				}
			}
			return null;
		}

		public String getSymbolicName() {
			if( bundle != null) {
				return bundle.getSymbolicName();
			}
			return null;
		}

		public String getBundleName() {
			if( bundle != null ) {
				Object bundleName = bundle.getHeaders().get("Bundle-Name"); //$NON-NLS-1$
				if( bundleName != null ) {
					return bundleName.toString();
				}
			}
			return null;
		}

		public String getBundleVendor() {
			if( bundle != null ) {
				Object bundleVendor = bundle.getHeaders().get("Bundle-Vendor"); //$NON-NLS-1$
				if( bundleVendor != null ) {
					return bundleVendor.toString();
				}
			}
			return null;
		}

		public void run()
		{
			if( bundle == null )
			{
				result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, Messages.IDLImportWizard_ErrorNoBundle );
				throw new IllegalArgumentException(Messages.IDLImportWizard_ErrorNoBundle);
			}

			URL url = bundle.getEntry("src/workflow/idl3Import.oaw");//$NON-NLS-1$
			if( url == null )
			{
				result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, Messages.IDLImportWizard_ErrorNoURL );
				throw new IllegalArgumentException(Messages.IDLImportWizard_ErrorNoURL);
			}

			result = WorkflowUtil.executeWorkflow( url, monitor, properties, slots );
			
			if( result.isOK() == false ) {
				throw new IllegalArgumentException(Messages.IDLImportWizard_Failure);
			}
		}
	}
}
