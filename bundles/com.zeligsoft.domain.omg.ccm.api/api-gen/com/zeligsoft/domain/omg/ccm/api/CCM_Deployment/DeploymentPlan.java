package com.zeligsoft.domain.omg.ccm.api.CCM_Deployment;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Deployments.Deployment;

public interface DeploymentPlan extends Deployment {
	String getId();

	void setId(String val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DeploymentPlan
	 */
	static final TypeSelectPredicate<DeploymentPlan> type = new TypeSelectPredicate<DeploymentPlan>(
			"CCM::CCM_Deployment::DeploymentPlan", //$NON-NLS-1$
			DeploymentPlan.class);
}
