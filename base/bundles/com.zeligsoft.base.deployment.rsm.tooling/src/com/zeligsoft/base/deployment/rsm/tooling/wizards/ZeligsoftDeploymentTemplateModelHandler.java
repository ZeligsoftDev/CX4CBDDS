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
package com.zeligsoft.base.deployment.rsm.tooling.wizards;

import com.ibm.xtools.common.ui.wizards.config.TemplateConfiguration;

import com.ibm.xtools.common.ui.wizards.handlers.FileTemplateModelHandler;
import com.ibm.xtools.common.ui.wizards.handlers.IContentCreator;

import com.zeligsoft.base.deployment.rsm.tooling.utils.ZeligsoftDeploymentUtil;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.ui.PlatformUI;

import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;

import org.eclipse.uml2.uml.Model;

/**
 * @generated
 */
public class ZeligsoftDeploymentTemplateModelHandler
        extends FileTemplateModelHandler {

    private static final String PERSPECTIVE_ID = "com.ibm.xtools.modeler.internal.ui.perspectives.ModelingPerspective"; //$NON-NLS-1$
    
    /**
     * @generated
     */
    protected String getFinalPerspective(TemplateConfiguration config) {
        return PERSPECTIVE_ID;
    }
    
    /**
     * @generated
     */
    protected String getPreferredPerspectives(TemplateConfiguration config) {
        return PERSPECTIVE_ID;
    }
    
    /**
     * @generated
     */
    protected boolean preFileCreation(IProgressMonitor monitor, TemplateConfiguration config) {
        config.addContentCreator("com.zeligsoft.base.deployment.rsm.tooling.contentCreator", new IContentCreator() { //$NON-NLS-1$

            public IStatus createContent(IProgressMonitor progressMonitor,
                    TemplateConfiguration templateConfiguration,
                    Resource[] resources) {
                if (resources.length > 0) {
                    // Rename the root UML Model element to the same name as the file
                    // and apply the profile.
                    Model model = (Model)resources[0].getContents().get(0);
                    if (model != null) {
                        model.setName(templateConfiguration.getFileName());
                        model.applyProfile(ZeligsoftDeploymentUtil.getProfile());
                    }
                }
                return Status.OK_STATUS;
            }
            
        });
        
        return super.preFileCreation(monitor, config);
    }
    
    /**
     * @generated
     */
    protected boolean postFileCreation(IProgressMonitor progressMonitor, IFile[] files) {
        // enable the core capability if it is not already enabled
        IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
        IActivityManager activityManager = activitySupport.getActivityManager();
        Set enabledIds = activityManager.getEnabledActivityIds();
        if (!enabledIds.contains(ZeligsoftDeploymentUtil.ZELIGSOFTDEPLOYMENT_CORE_ACTIVITY_ID)) {
            enabledIds = new HashSet(enabledIds);
            enabledIds.add(ZeligsoftDeploymentUtil.ZELIGSOFTDEPLOYMENT_CORE_ACTIVITY_ID);
            activitySupport.setEnabledActivityIds(enabledIds);
        }
        return super.postFileCreation(progressMonitor, files);
    }
}