package com.zeligsoft.domain.zml.api.ZML_Deployments.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentSpecification;

public abstract class DeploymentSpecificationImplementation extends ZObjectImpl
		implements DeploymentSpecification {
	public DeploymentSpecificationImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Classifier asClassifier() {
		return (org.eclipse.uml2.uml.Classifier) eObject();
	}
}
