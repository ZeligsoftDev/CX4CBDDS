
package com.zeligsoft.ce.deployment.rsm.profile.tooling.edithelpers;

import com.ibm.xtools.common.ui.reduction.util.EditingCapabilitiesUtil;

import com.ibm.xtools.uml.type.UMLElementTypes;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.ZDLDeploymentPlugin;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.l10n.ZDLDeploymentMessages;

import com.zeligsoft.ce.deployment.rsm.profile.tooling.utils.ZDLDeploymentUtil;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.PlatformUI;

import org.eclipse.ui.activities.ITriggerPoint;
import org.eclipse.ui.activities.ITriggerPointManager;
import org.eclipse.ui.activities.WorkbenchActivityHelper;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * @generated
 */
public class ZDLDeploymentApplyProfileAdvice
        extends AbstractEditHelperAdvice {

    /**
     * @generated
     */
    protected ICommand getAfterCreateRelationshipCommand(
            final CreateRelationshipRequest request) {
        if (request.getElementType() == UMLElementTypes.PROFILE_APPLICATION) {
            return new AbstractTransactionalCommand(request.getEditingDomain(),
                    ZDLDeploymentMessages.CommandLabel_setProfileEditingCapabilities, null) {

                /**
                 * @generated
                 */
                protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
                        IAdaptable info) throws ExecutionException {
                    ProfileApplication profileApplication = (ProfileApplication)request.getNewElement();
                    if (profileApplication.getAppliedProfile().equals(ZDLDeploymentUtil.getProfile())) {
                        Model model = profileApplication.getApplyingPackage().getModel();
                        boolean hasEnabledEditingCapabilities = EditingCapabilitiesUtil.hasEnabledEditingCapabilities(model);
                        if (hasEnabledEditingCapabilities ||
                                EditingCapabilitiesUtil.hasDisabledEditingCapabilities(model)) {
                            Set requiredActivityIds = new HashSet();
                            Set modelRequiredActivityIds = EditingCapabilitiesUtil.getRequiredActivityIds(model);
                            if (modelRequiredActivityIds != null) {
                                requiredActivityIds.addAll(modelRequiredActivityIds);
                            }
                            requiredActivityIds.add(ZDLDeploymentUtil.ZDLDEPLOYMENT_TOOLING_ACTIVITY_ID);
                            EditingCapabilitiesUtil.setRequiredActivityIds(model, requiredActivityIds);
                        }
                        
                        if (hasEnabledEditingCapabilities) {
                            EditingCapabilitiesUtil.reenableActivities();
                        } else {
                            ITriggerPoint point = PlatformUI.getWorkbench()
                                    .getActivitySupport().getTriggerPointManager()
                                    .getTriggerPoint(ITriggerPointManager.UNKNOWN_TRIGGER_POINT_ID);
                            IPluginContribution contribution = new IPluginContribution() {
                                
                                public String getLocalId() {
                                    return ZDLDeploymentUtil.ZDLDEPLOYMENT_TOOLING_ACTIVITY_ID;
                                }
                                
                                public String getPluginId() {
                                    return ZDLDeploymentPlugin.ID;
                                }
                            };
                            WorkbenchActivityHelper.allowUseOf(point, contribution);
                        }
                    }
                    return CommandResult.newOKCommandResult();
                }
            };
        }
        return super.getAfterCreateRelationshipCommand(request);
    }
    
    /**
     * @generated
     */
    protected ICommand getBeforeDestroyElementCommand(
            final DestroyElementRequest request) {
        if (request.getElementToDestroy() instanceof ProfileApplication) {
            return new AbstractTransactionalCommand(request.getEditingDomain(),
                    ZDLDeploymentMessages.CommandLabel_unsetProfileEditingCapabilities, null) {

                /**
                 * @generated
                 */
                protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
                        IAdaptable info) throws ExecutionException {
                    ProfileApplication profileApplication = (ProfileApplication)request.getElementToDestroy();
                    if (profileApplication.getAppliedProfile().equals(ZDLDeploymentUtil.getProfile())) {
                        Model model = profileApplication.getApplyingPackage().getModel();
                        if (EditingCapabilitiesUtil.hasEnabledEditingCapabilities(model) ||
                                EditingCapabilitiesUtil.hasDisabledEditingCapabilities(model)) {
                            Set requiredActivityIds = new HashSet(EditingCapabilitiesUtil.getRequiredActivityIds(model));
                            requiredActivityIds.remove(ZDLDeploymentUtil.ZDLDEPLOYMENT_TOOLING_ACTIVITY_ID);
                            EditingCapabilitiesUtil.setRequiredActivityIds(model, requiredActivityIds);
                            EditingCapabilitiesUtil.reenableActivities();
                        }
                    }
                    return CommandResult.newOKCommandResult();
                }
            };
        }
        return super.getAfterDestroyElementCommand(request);
    }
}