package com.zeligsoft.domain.zml.api.ZML_Deployments;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DeploymentSpecification extends ZObject {
	org.eclipse.uml2.uml.Classifier asClassifier();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DeploymentSpecification
	 */
	static final TypeSelectPredicate<DeploymentSpecification> type = new TypeSelectPredicate<DeploymentSpecification>(
			"ZMLMM::ZML_Deployments::DeploymentSpecification", //$NON-NLS-1$
			DeploymentSpecification.class);
}
