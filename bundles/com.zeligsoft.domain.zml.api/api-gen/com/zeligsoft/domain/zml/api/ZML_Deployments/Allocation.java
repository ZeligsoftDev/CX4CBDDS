package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Allocation extends ZObject {
	java.util.List<DeploymentPart> getDeployed();

	void addDeployed(DeploymentPart val);

	DeploymentPart getDeployedOn();

	void setDeployedOn(DeploymentPart val);

	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Allocation
	 */
	static final TypeSelectPredicate<Allocation> type = new TypeSelectPredicate<Allocation>(
			"ZMLMM::ZML_Deployments::Allocation", //$NON-NLS-1$
			Allocation.class);
}
