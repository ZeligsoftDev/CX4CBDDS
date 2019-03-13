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

package com.zeligsoft.domain.dds4ccm.codegen;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;
import org.osgi.framework.Bundle;

import com.zeligsoft.cx.codegen.postprocessor.CodeEditorPostProcessor;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMGenerationUtils;

/**
 * DDS4CCM Code Editor Postprocessor.
 * 
 * @author smcfee
 *
 */
public class DDS4CCMCodeEditorPostProcessor implements CodeEditorPostProcessor {

	private Set<EObject> notifiedObjects = new HashSet<EObject>();
	
	private final Object lock = new Object();
	
	@Override
	public void notifyObject(EObject notifyingObject) {
		synchronized (lock) {
			// Keep track of the monolithic implementations, not the worker operations.
			notifiedObjects.add(notifyingObject.eContainer());
		}
	}

	@Override
	public void postProcess() {
	
		WorkspaceJob transformJob = new WorkspaceJob("Regenerate component XML") { //$NON-NLS-1$
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) {

				// prevent concurrent modification of the list by notifyObject method 
				synchronized (lock) {
					// MultiStatus resultStatus = null; // new MultiStatus();
	
					// Generate XML for any monolithic implementation that changed.
					for (EObject monoImpl : notifiedObjects) {
						String path = DDS4CCMGenerationUtils.path((NamedElement)monoImpl);
						if (path.equals("") == false) { //$NON-NLS-1$
							path = File.separator + path;
						}
						try {
							CodeTagGeneratorUtil.generateXML2(monoImpl, path);
						} catch( Exception e ) {
							Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
							MultiStatus resultStatus = new MultiStatus(Activator.PLUGIN_ID, Status.ERROR, "Generation of XML failed.", e ); //$NON-NLS-1$
							resultStatus.add(createStatus(Status.ERROR, "Plug-in Vendor: " + bundle.getHeaders().get("Bundle-Version"))); //$NON-NLS-1$ //$NON-NLS-2$
						    resultStatus.add(createStatus(Status.ERROR, "Plug-in Name: " + bundle.getHeaders().get("Bundle-Name"))); //$NON-NLS-1$ //$NON-NLS-2$
						    resultStatus.add(createStatus(Status.ERROR, "Plug-in ID: " + bundle.getSymbolicName())); //$NON-NLS-1$
						    resultStatus.add(createStatus(Status.ERROR, "Version: " + bundle.getVersion())); //$NON-NLS-1$
						    resultStatus.add(createStatus(Status.ERROR, e.getMessage()));
						    return resultStatus;
						}
					}
					
					notifiedObjects.clear();
	
					// return resultStatus;
					return Status.OK_STATUS;
				}
			}

		};

		transformJob.setUser(true);
		transformJob.schedule();	
		
	}
	

	private Status createStatus(int severity, String msg) {
	    Status status = new Status(severity, Activator.PLUGIN_ID, IStatus.OK, msg, null);
	    return status;
	}	
}
