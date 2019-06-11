package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Interconnect;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.ResourceProperty;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class InterconnectImplementation extends NamedElementImplementation
		implements Interconnect {
	protected java.util.List<ResourceProperty> _resource;

	public InterconnectImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<ResourceProperty> getResource() {
		if (_resource == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CCM::CCM_Target::Interconnect",
							"resource");
			_resource = new java.util.ArrayList<ResourceProperty>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					ResourceProperty nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									ResourceProperty.class);
					_resource.add(nextWrapper);
				}
			}
		}
		return _resource;
	}

	@Override
	public void addResource(ResourceProperty val) {
		// make sure the resource list is created
		getResource();

		final Object rawValue = ZDLUtil.getValue(element,
				"CCM::CCM_Target::Interconnect", "resource");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_resource != null) {
			_resource.add(val);
		}
	}

	@Override
	public <T extends ResourceProperty> T addResource(Class<T> typeToCreate,
			String concept) {
		// make sure the resource list is created
		getResource();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CCM::CCM_Target::Interconnect", "resource", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_resource != null) {
			_resource.add(element);
		}
		return element;
	}

	@Override
	public ResourceProperty addResource() {
		// make sure the resource list is created
		getResource();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CCM::CCM_Target::Interconnect", "resource",
				"CCM::CCM_Target::ResourceProperty");
		ResourceProperty element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				ResourceProperty.class);
		if (_resource != null) {
			_resource.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
