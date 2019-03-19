package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Implementation;
import com.zeligsoft.domain.zml.api.ZML_Configurations.Configuration;

public interface ComponentDeploymentPart extends DeploymentPart {
	Implementation getSelectedImplementation();

	void setSelectedImplementation(Implementation val);

	Configuration getImplementationConfiguration();

	void setImplementationConfiguration(Configuration val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ComponentDeploymentPart
	 */
	static final TypeSelectPredicate<ComponentDeploymentPart> type = new TypeSelectPredicate<ComponentDeploymentPart>(
			"ZMLMM::ZML_Deployments::ComponentDeploymentPart", //$NON-NLS-1$
			ComponentDeploymentPart.class);
}
