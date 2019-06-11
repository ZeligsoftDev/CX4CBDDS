package com.zeligsoft.domain.zml.api.ZML_Deployments.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Deployments.Deployment;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Deployments.Allocation;
import com.zeligsoft.domain.zml.api.ZML_Deployments.DeploymentPart;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DeploymentImplementation extends NamedElementImplementation
		implements Deployment {
	protected java.util.List<Allocation> _allocation;
	protected java.util.List<DeploymentPart> _part;

	public DeploymentImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<Allocation> getAllocation() {
		if (_allocation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Deployments::Deployment",
							"allocation");
			_allocation = new java.util.ArrayList<Allocation>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Allocation nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									Allocation.class);
					_allocation.add(nextWrapper);
				}
			}
		}
		return _allocation;
	}

	@Override
	public void addAllocation(Allocation val) {
		// make sure the allocation list is created
		getAllocation();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Deployments::Deployment", "allocation");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_allocation != null) {
			_allocation.add(val);
		}
	}

	@Override
	public <T extends Allocation> T addAllocation(Class<T> typeToCreate,
			String concept) {
		// make sure the allocation list is created
		getAllocation();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Deployments::Deployment", "allocation",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_allocation != null) {
			_allocation.add(element);
		}
		return element;
	}

	@Override
	public Allocation addAllocation() {
		// make sure the allocation list is created
		getAllocation();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Deployments::Deployment", "allocation",
				"ZMLMM::ZML_Deployments::Allocation");
		Allocation element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, Allocation.class);
		if (_allocation != null) {
			_allocation.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<DeploymentPart> getPart() {
		if (_part == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Deployments::Deployment",
							"part");
			_part = new java.util.ArrayList<DeploymentPart>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DeploymentPart nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DeploymentPart.class);
					_part.add(nextWrapper);
				}
			}
		}
		return _part;
	}

	@Override
	public void addPart(DeploymentPart val) {
		// make sure the part list is created
		getPart();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Deployments::Deployment", "part");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_part != null) {
			_part.add(val);
		}
	}

	@Override
	public <T extends DeploymentPart> T addPart(Class<T> typeToCreate,
			String concept) {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Deployments::Deployment", "part", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public DeploymentPart addPart() {
		// make sure the part list is created
		getPart();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Deployments::Deployment", "part",
				"ZMLMM::ZML_Deployments::DeploymentPart");
		DeploymentPart element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				DeploymentPart.class);
		if (_part != null) {
			_part.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
