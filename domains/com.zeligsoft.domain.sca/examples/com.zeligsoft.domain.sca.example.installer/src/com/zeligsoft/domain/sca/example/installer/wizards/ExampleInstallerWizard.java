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
package com.zeligsoft.domain.sca.example.installer.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;

import com.zeligsoft.domain.sca.example.installer.ExampleInstallerPlugin;

/**
 * A default realization of the AbstractExampleInstallerWizard which uses
 * the id attribute of the wizard to find the associated example extension
 * and load the project descriptors.
 * 
 * Wizard also loads the title, description and image of the main page from
 * the examples extension.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
@SuppressWarnings("nls")
public class ExampleInstallerWizard extends AbstractExampleInstallerWizard
		implements IExecutableExtension {
	
	/**
	 * CONSTANTS FOR THE EXAMPLES EXTENSION POINT
	 */
	private static final String PAGE_IMAGE__ATTRIBUTE = "pageImage";
	private static final String PAGE_DESCRIPTION__ATTRIBUTE = "pageDescription";
	private static final String PAGE_TITLE__ATTRIBUTE = "pageTitle";
	private static final String EDITOR_ID__ATTRIBUTE = "editorID";
	private static final String LOCATION__ATTRIBUTE = "location";
	private static final String FILE_TO_OPEN__ELEMENT = "fileToOpen";
	private static final String DESCRIPTION__ATTRIBUTE = "description";
	private static final String CONTENT_URI__ATTRIBUTE = "contentURI";
	private static final String NAME__ATTRIBUTE = "name";
	private static final String PROJECT_DESCRIPTOR__ELEMENT = "projectDescriptor";
	private static final String WIZARD_ID__ATTRIBUTE = "wizardID";
	private static final String EXAMPLE__ELEMENT = "example";
	private static final String EXAMPLES_EXTENSION_POINT = "examples";
	private static final String ID__ATTRIBUTE = "id";
	
	
	protected IConfigurationElement wizardConfigurationElement;
	protected List<ProjectDescriptor> projectDescriptors;
	protected List<FileToOpen> filesToOpen;
	protected String pageTitle;
	protected String pageDescription;
	
	@Override
	protected String getPageTitle() {
		if(null == pageTitle) {
			loadFromExtensionPoints();
		}
		
		if(null == pageTitle) {
			return super.getPageTitle();
		} else {
			return pageTitle;
		}
	}
	
	@Override
	protected String getPageDescription() {
		if(null == pageDescription) {
			loadFromExtensionPoints();
		}
		
		if(null == pageDescription) {
			return super.getPageTitle();
		} else {
			return pageDescription;
		}
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.domain.sca.example.installer.wizards.AbstractExampleInstallerWizard#getFilesToOpen()
	 */
	@Override
	protected List<FileToOpen> getFilesToOpen() {
		if(null == filesToOpen) {
			loadFromExtensionPoints();
		}
		
		return filesToOpen;
	}

	/* (non-Javadoc)
	 * @see com.zeligsoft.domain.sca.example.installer.wizards.AbstractExampleInstallerWizard#getProjectDescriptors()
	 */
	@Override
	protected List<ProjectDescriptor> getProjectDescriptors() {
		if(null == projectDescriptors) {
			loadFromExtensionPoints();
		}
		
		return projectDescriptors;
	}

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		wizardConfigurationElement = config;
	}

	/**
	 * Load the project descriptor from the examples extension point for the
	 * example associated with this instance of the wizard.
	 */
	protected void loadFromExtensionPoints()
	  {
	    projectDescriptors = new ArrayList<ProjectDescriptor>();
	    filesToOpen = new ArrayList<FileToOpen>();
	    
	    String wizardID = wizardConfigurationElement.getAttribute(ID__ATTRIBUTE);
	    
	    IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(ExampleInstallerPlugin.PLUGIN_ID, EXAMPLES_EXTENSION_POINT);
	    IConfigurationElement[] exampleElements = extensionPoint.getConfigurationElements();
	    for (int i = 0; i < exampleElements.length; i++)
	    {
	      IConfigurationElement exampleElement = exampleElements[i];
	      if (EXAMPLE__ELEMENT.equals(exampleElement.getName()) && wizardID.equals(exampleElement.getAttribute(WIZARD_ID__ATTRIBUTE)))
	      {
	        IConfigurationElement[] projectDescriptorElements = exampleElement.getChildren(PROJECT_DESCRIPTOR__ELEMENT);
	        for (int j = 0; j < projectDescriptorElements.length; j++)
	        {
	          IConfigurationElement projectDescriptorElement = projectDescriptorElements[j];
	          String projectName = projectDescriptorElement.getAttribute(NAME__ATTRIBUTE);
	          if (projectName != null)
	          {
	            String contentURI = projectDescriptorElement.getAttribute(CONTENT_URI__ATTRIBUTE);
	            if (contentURI != null)
	            {
	              AbstractExampleInstallerWizard.ProjectDescriptor projectDescriptor = new AbstractExampleInstallerWizard.ProjectDescriptor();
	              projectDescriptor.setName(projectName);
	              
	              URI uri = URI.createURI(contentURI);
	              if (uri.isRelative())
	              {
	                uri = URI.createPlatformPluginURI(projectDescriptorElement.getContributor().getName() + "/" + contentURI, true); //$NON-NLS-1$
	              }
	              projectDescriptor.setContentURI(uri);
	              
	              projectDescriptor.setDescription(projectDescriptorElement.getAttribute(DESCRIPTION__ATTRIBUTE));
	              
	              projectDescriptors.add(projectDescriptor);
	            }
	          }
	        }
	        
	        if (!projectDescriptors.isEmpty())
	        {
	          IConfigurationElement[] openElements = exampleElement.getChildren(FILE_TO_OPEN__ELEMENT);
	          for (int j = 0; j < openElements.length; j++)
	          {
	            IConfigurationElement openElement = openElements[j];
	            String location = openElement.getAttribute(LOCATION__ATTRIBUTE);
	            if (location != null)
	            {
	              AbstractExampleInstallerWizard.FileToOpen fileToOpen = new AbstractExampleInstallerWizard.FileToOpen();
	              fileToOpen.setLocation(location);                
	              fileToOpen.setEditorID(openElement.getAttribute(EDITOR_ID__ATTRIBUTE));
	              filesToOpen.add(fileToOpen);
	            }
	          }
	          
	          pageTitle = exampleElement.getAttribute(PAGE_TITLE__ATTRIBUTE);
	          pageDescription = exampleElement.getAttribute(PAGE_DESCRIPTION__ATTRIBUTE);
	          
	          String imagePath = exampleElement.getAttribute(PAGE_IMAGE__ATTRIBUTE);
	          if (imagePath != null)
	          {
	            imagePath = imagePath.replace('\\', '/');
	            if (!imagePath.startsWith("/")) //$NON-NLS-1$
	            {
	              imagePath = "/" + imagePath; //$NON-NLS-1$
	            }

	            Bundle pluginBundle = Platform.getBundle(exampleElement.getDeclaringExtension().getContributor().getName());
	            try
	            {
	              ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(pluginBundle.getEntry(imagePath));
	              setDefaultPageImageDescriptor(imageDescriptor);
	            }
	            catch (Exception e)
	            {
	              // Ignore
	            }
	          }
          
	          //Only one example per wizard
	          break;
	        }
	      }
	    }
	  }
}
