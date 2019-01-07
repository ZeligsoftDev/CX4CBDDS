package com.zeligsoft.domain.zml.api.ZML_Deployments.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Deployments.Allocation;

import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class AllocationImplementation extends ZObjectImpl implements Allocation {
	protected DeploymentPart _deployedOn;
	protected java.util.List<DeploymentPart> _deployed;

	public AllocationImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DeploymentPart getDeployedOn() {
		if (_deployedOn == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Deployments::Allocation",
							"deployedOn");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_deployedOn = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DeploymentPart.class);
			}
		}
		return _deployedOn;
	}

	@Override
	public void setDeployedOn(DeploymentPart val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Deployments::Allocation",
				"deployedOn", val.eObject());
	}

	@Override
	public java.util.List<DeploymentPart> getDeployed() {
		if (_deployed == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Deployments::Allocation",
							"deployed");
			_deployed = new java.util.ArrayList<DeploymentPart>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DeploymentPart nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DeploymentPart.class);
					_deployed.add(nextWrapper);
				}
			}
		}
		return _deployed;
	}

	@Override
	public void addDeployed(DeploymentPart val) {
		// make sure the deployed list is created
		getDeployed();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Deployments::Allocation", "deployed");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_deployed != null) {
			_deployed.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
