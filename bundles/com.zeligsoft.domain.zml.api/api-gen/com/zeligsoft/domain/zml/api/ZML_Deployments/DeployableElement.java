package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DeployableElement extends DeploymentSpecification {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DeployableElement
	 */
	static final TypeSelectPredicate<DeployableElement> type = new TypeSelectPredicate<DeployableElement>(
			"ZMLMM::ZML_Deployments::DeployableElement", //$NON-NLS-1$
			DeployableElement.class);
}
