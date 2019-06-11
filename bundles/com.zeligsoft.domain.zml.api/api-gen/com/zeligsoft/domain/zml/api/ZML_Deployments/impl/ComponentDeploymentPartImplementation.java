package com.zeligsoft.domain.zml.api.ZML_Deployments.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Deployments.ComponentDeploymentPart;
import com.zeligsoft.domain.zml.api.ZML_Deployments.impl.DeploymentPartImplementation;

import com.zeligsoft.domain.zml.api.ZML_Component.Implementation;
import com.zeligsoft.domain.zml.api.ZML_Configurations.Configuration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ComponentDeploymentPartImplementation extends
		DeploymentPartImplementation implements ComponentDeploymentPart {
	protected Implementation _selectedImplementation;
	protected Configuration _implementationConfiguration;

	public ComponentDeploymentPartImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Implementation getSelectedImplementation() {
		if (_selectedImplementation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Deployments::ComponentDeploymentPart",
							"selectedImplementation");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_selectedImplementation = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Implementation.class);
			}
		}
		return _selectedImplementation;
	}

	@Override
	public void setSelectedImplementation(Implementation val) {
		ZDLUtil.setValue(element,
				"ZMLMM::ZML_Deployments::ComponentDeploymentPart",
				"selectedImplementation", val.eObject());
	}

	@Override
	public Configuration getImplementationConfiguration() {
		if (_implementationConfiguration == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Deployments::ComponentDeploymentPart",
							"implementationConfiguration");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_implementationConfiguration = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) rawValue,
								Configuration.class);
			}
		}
		return _implementationConfiguration;
	}

	@Override
	public void setImplementationConfiguration(Configuration val) {
		ZDLUtil.setValue(element,
				"ZMLMM::ZML_Deployments::ComponentDeploymentPart",
				"implementationConfiguration", val.eObject());
	}

}
