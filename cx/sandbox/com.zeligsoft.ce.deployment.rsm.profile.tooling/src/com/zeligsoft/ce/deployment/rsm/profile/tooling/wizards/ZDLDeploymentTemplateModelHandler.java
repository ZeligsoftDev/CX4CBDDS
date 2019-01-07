
package com.zeligsoft.ce.deployment.rsm.profile.tooling.wizards;

import com.ibm.xtools.common.ui.wizards.config.TemplateConfiguration;

import com.ibm.xtools.common.ui.wizards.handlers.FileTemplateModelHandler;
import com.ibm.xtools.common.ui.wizards.handlers.IContentCreator;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentUtil;

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
public class ZDLDeploymentTemplateModelHandler
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
        config.addContentCreator("com.zeligsoft.ce.deployment.rsm.profile.tooling.contentCreator", new IContentCreator() { //$NON-NLS-1$

            public IStatus createContent(IProgressMonitor progressMonitor,
                    TemplateConfiguration templateConfiguration,
                    Resource[] resources) {
                if (resources.length > 0) {
                    // Rename the root UML Model element to the same name as the file
                    // and apply the profile.
                    Model model = (Model)resources[0].getContents().get(0);
                    if (model != null) {
                        model.setName(templateConfiguration.getFileName());
                        model.applyProfile(ZDLDeploymentUtil.getProfile());
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
        if (!enabledIds.contains(ZDLDeploymentUtil.ZDLDEPLOYMENT_CORE_ACTIVITY_ID)) {
            enabledIds = new HashSet(enabledIds);
            enabledIds.add(ZDLDeploymentUtil.ZDLDEPLOYMENT_CORE_ACTIVITY_ID);
            activitySupport.setEnabledActivityIds(enabledIds);
        }
        return super.postFileCreation(progressMonitor, files);
    }
}