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
package com.zeligsoft.cx.codegen.ui.transformregistry;

import java.net.URL;
import java.util.Collection;

import org.eclipse.jface.viewers.IFilter;
import org.osgi.framework.Bundle;

import com.zeligsoft.cx.codegen.editor.IValidationFactory;


/**
 * Java bean for a <code>workflow</code> entry in the Transformation Registry
 * extension point.
 * 
 * @author jcorchis
 */
public class WorkflowEntry {
	
	private URL workflowURL;

	private String displayLabel;
	
	private IValidationFactory factory;
	
	private String id;
	
	private boolean b_validationErrorCancels;
	
	private IFilter visibilityTest;
	
	private Collection<String> fileExtensions;
	
	public static class DiagnosticInfo {
		private String bundleVendor;
		private String bundleName;
		private String symbolicName;
		private String bundleVersion;
		private Bundle bundle;
		
		public DiagnosticInfo(Bundle bundle) {
			this.bundle = bundle;
			symbolicName = bundle.getSymbolicName();
			Object bundleName = bundle.getHeaders().get("Bundle-Name"); //$NON-NLS-1$
		    if( bundleName != null ) { 
		        this.bundleName = bundleName.toString();
		    }
		    Object bundleVendor = bundle.getHeaders().get("Bundle-Vendor"); //$NON-NLS-1$
		    if( bundleVendor != null ) {
		    	this.bundleVendor = bundleVendor.toString();
		    }
		    Object bundleVersion = bundle.getHeaders().get("Bundle-Version"); //$NON-NLS-1$
		    if( bundleVersion != null) {
		    	this.bundleVersion = bundleVersion.toString();
		    }
		}
		
		public String getBundleVendor() {
			return bundleVendor;
		}
		
		public String getBundleName() {
			return bundleName;
		}
		
		public String getBundleVersion() {
			return bundleVersion;
		}
		
		public String getSymbolicName() {
			return symbolicName;
		}
		
		public Bundle getBundle() {
			return bundle;
		}
	}
	
	private DiagnosticInfo info; 

	/**
	 * Creates an instance of me.
	 */
	WorkflowEntry(URL workflowURL, String displayLabel, IValidationFactory factory, boolean b_validationErrorCancels, 
			DiagnosticInfo info, String id, IFilter visibilityTest) {
		this(workflowURL, displayLabel, factory, b_validationErrorCancels, info, id, visibilityTest, null);
	}

	WorkflowEntry(URL workflowURL, String displayLabel, IValidationFactory factory, boolean b_validationErrorCancels, 
			DiagnosticInfo info, String id, IFilter visibilityTest, Collection<String> fileExtensions) {
		this.workflowURL = workflowURL;
		this.displayLabel = displayLabel;
		this.factory = factory;
		this.b_validationErrorCancels = b_validationErrorCancels;
		this.info = info;
		this.id = id;
		this.visibilityTest = visibilityTest;
		this.fileExtensions = fileExtensions;
	}

	/**
	 * Return the URL of the workflow resource.
	 * @return
	 */
	public URL getWorkflowURL() {
		return workflowURL;
	}

	/**
	 * Returns the display label for the entry.
	 * @return
	 */
	public String getDisplayLabel() {
		return displayLabel;
	}
	
	/**
	 * Returns the validation factory for the entry.
	 * 
	 * @return
	 */
	public IValidationFactory getValidationFactory() {
		return factory;
	}
	
	public boolean doesValidationErrorCancel() {
		return b_validationErrorCancels;
	}
	
	/**
	 * Returns diagnostic information for this workflow entry for status reporting or other purposes.
	 * 
	 * @return
	 */
	public DiagnosticInfo getDiagnosticInfo() {
		return info;
	}
	
	public String getId() {
		return id;
	}

	/**
	 * @return the visibilityTestClass
	 */
	public IFilter getVisibilityTest() {
		return visibilityTest;
	}
	
	public void setFileExtensions(Collection<String> fileExtensions) {
		this.fileExtensions = fileExtensions;
	}
	
	public Collection<String> getFileExtensions() {
		return fileExtensions;
	}
	
}
