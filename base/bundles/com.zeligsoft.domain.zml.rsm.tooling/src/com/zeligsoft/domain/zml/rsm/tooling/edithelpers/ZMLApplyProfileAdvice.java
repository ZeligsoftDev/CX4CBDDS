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
package com.zeligsoft.domain.zml.rsm.tooling.edithelpers;

import com.ibm.xtools.common.ui.reduction.util.EditingCapabilitiesUtil;

import com.ibm.xtools.uml.type.UMLElementTypes;

import com.zeligsoft.domain.zml.rsm.tooling.ZMLPlugin;

import com.zeligsoft.domain.zml.rsm.tooling.l10n.ZMLMessages;

import com.zeligsoft.domain.zml.rsm.tooling.utils.ZMLUtil;

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
public class ZMLApplyProfileAdvice
        extends AbstractEditHelperAdvice {

    /**
     * @generated
     */
    protected ICommand getAfterCreateRelationshipCommand(
            final CreateRelationshipRequest request) {
        if (request.getElementType() == UMLElementTypes.PROFILE_APPLICATION) {
            return new AbstractTransactionalCommand(request.getEditingDomain(),
                    ZMLMessages.CommandLabel_setProfileEditingCapabilities, null) {

                /**
                 * @generated
                 */
                protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
                        IAdaptable info) throws ExecutionException {
                    ProfileApplication profileApplication = (ProfileApplication)request.getNewElement();
                    if (profileApplication.getAppliedProfile().equals(ZMLUtil.getProfile())) {
                        Model model = profileApplication.getApplyingPackage().getModel();
                        boolean hasEnabledEditingCapabilities = EditingCapabilitiesUtil.hasEnabledEditingCapabilities(model);
                        if (hasEnabledEditingCapabilities ||
                                EditingCapabilitiesUtil.hasDisabledEditingCapabilities(model)) {
                            Set requiredActivityIds = new HashSet();
                            Set modelRequiredActivityIds = EditingCapabilitiesUtil.getRequiredActivityIds(model);
                            if (modelRequiredActivityIds != null) {
                                requiredActivityIds.addAll(modelRequiredActivityIds);
                            }
                            requiredActivityIds.add(ZMLUtil.ZML_TOOLING_ACTIVITY_ID);
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
                                    return ZMLUtil.ZML_TOOLING_ACTIVITY_ID;
                                }
                                
                                public String getPluginId() {
                                    return ZMLPlugin.ID;
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
                    ZMLMessages.CommandLabel_unsetProfileEditingCapabilities, null) {

                /**
                 * @generated
                 */
                protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
                        IAdaptable info) throws ExecutionException {
                    ProfileApplication profileApplication = (ProfileApplication)request.getElementToDestroy();
                    if (profileApplication.getAppliedProfile().equals(ZMLUtil.getProfile())) {
                        Model model = profileApplication.getApplyingPackage().getModel();
                        if (EditingCapabilitiesUtil.hasEnabledEditingCapabilities(model) ||
                                EditingCapabilitiesUtil.hasDisabledEditingCapabilities(model)) {
                            Set requiredActivityIds = new HashSet(EditingCapabilitiesUtil.getRequiredActivityIds(model));
                            requiredActivityIds.remove(ZMLUtil.ZML_TOOLING_ACTIVITY_ID);
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