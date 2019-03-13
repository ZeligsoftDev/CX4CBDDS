package com.zeligsoft.domain.idl3plus.api.Deployment;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;

public interface PerPortConnectorTypeDeploymentPart extends DeploymentPart {
/**
 * A predicate which returns true if the Object is an
 * instance of PerPortConnectorTypeDeploymentPart
 */
static final TypeSelectPredicate<PerPortConnectorTypeDeploymentPart> type = 
    new TypeSelectPredicate<PerPortConnectorTypeDeploymentPart>(
        "IDL3Plus::Deployment::PerPortConnectorTypeDeploymentPart", //$NON-NLS-1$
        PerPortConnectorTypeDeploymentPart.class); 
}
