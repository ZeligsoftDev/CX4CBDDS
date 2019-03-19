package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface Deployment extends NamedElement {
	java.util.List<DeploymentPart> getPart();

	void addPart(DeploymentPart val);

	<T extends DeploymentPart> T addPart(Class<T> typeToCreate, String concept);

	DeploymentPart addPart();

	java.util.List<Allocation> getAllocation();

	void addAllocation(Allocation val);

	<T extends Allocation> T addAllocation(Class<T> typeToCreate, String concept);

	Allocation addAllocation();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Deployment
	 */
	static final TypeSelectPredicate<Deployment> type = new TypeSelectPredicate<Deployment>(
			"ZMLMM::ZML_Deployments::Deployment", //$NON-NLS-1$
			Deployment.class);
}
