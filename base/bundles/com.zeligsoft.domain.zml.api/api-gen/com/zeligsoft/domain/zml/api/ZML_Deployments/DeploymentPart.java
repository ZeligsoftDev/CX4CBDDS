package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Configurations.Configuration;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface DeploymentPart extends NamedElement {
	java.util.List<DeploymentPart> getNestedPart();

	void addNestedPart(DeploymentPart val);

	Configuration getConfiguration();

	void setConfiguration(Configuration val);

	NamedElement getModelElement();

	void setModelElement(NamedElement val);

	DeploymentSpecification getSpecification();

	void setSpecification(DeploymentSpecification val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DeploymentPart
	 */
	static final TypeSelectPredicate<DeploymentPart> type = new TypeSelectPredicate<DeploymentPart>(
			"ZMLMM::ZML_Deployments::DeploymentPart", //$NON-NLS-1$
			DeploymentPart.class);
}
