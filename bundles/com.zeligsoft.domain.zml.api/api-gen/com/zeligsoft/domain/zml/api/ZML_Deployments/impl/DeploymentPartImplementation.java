package com.zeligsoft.domain.zml.api.ZML_Deployments.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentSpecification;
import com.zeligsoft.domain.zml.api.ZML_Configurations.Configuration;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DeploymentPartImplementation extends NamedElementImplementation
		implements DeploymentPart {
	protected DeploymentSpecification _specification;
	protected java.util.List<DeploymentPart> _nestedPart;
	protected NamedElement _modelElement;
	protected Configuration _configuration;

	public DeploymentPartImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DeploymentSpecification getSpecification() {
		if (_specification == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Deployments::DeploymentPart",
							"specification");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_specification = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DeploymentSpecification.class);
			}
		}
		return _specification;
	}

	@Override
	public void setSpecification(DeploymentSpecification val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Deployments::DeploymentPart",
				"specification", val.eObject());
	}

	@Override
	public java.util.List<DeploymentPart> getNestedPart() {
		if (_nestedPart == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Deployments::DeploymentPart",
							"nestedPart");
			_nestedPart = new java.util.ArrayList<DeploymentPart>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DeploymentPart nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DeploymentPart.class);
					_nestedPart.add(nextWrapper);
				}
			}
		}
		return _nestedPart;
	}

	@Override
	public void addNestedPart(DeploymentPart val) {
		// make sure the nestedPart list is created
		getNestedPart();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Deployments::DeploymentPart", "nestedPart");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_nestedPart != null) {
			_nestedPart.add(val);
		}
	}

	@Override
	public NamedElement getModelElement() {
		if (_modelElement == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Deployments::DeploymentPart",
							"modelElement");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_modelElement = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						NamedElement.class);
			}
		}
		return _modelElement;
	}

	@Override
	public void setModelElement(NamedElement val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Deployments::DeploymentPart",
				"modelElement", val.eObject());
	}

	@Override
	public Configuration getConfiguration() {
		if (_configuration == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Deployments::DeploymentPart",
							"configuration");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_configuration = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Configuration.class);
			}
		}
		return _configuration;
	}

	@Override
	public void setConfiguration(Configuration val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Deployments::DeploymentPart",
				"configuration", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
