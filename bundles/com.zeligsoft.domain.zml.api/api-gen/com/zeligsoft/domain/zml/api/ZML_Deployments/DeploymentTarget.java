package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DeploymentTarget extends DeploymentSpecification {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DeploymentTarget
	 */
	static final TypeSelectPredicate<DeploymentTarget> type = new TypeSelectPredicate<DeploymentTarget>(
			"ZMLMM::ZML_Deployments::DeploymentTarget", //$NON-NLS-1$
			DeploymentTarget.class);
}
