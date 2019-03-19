package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.RequirementSatisfier;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierProperty;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class RequirementSatisfierImplementation extends
		NamedElementImplementation implements RequirementSatisfier {
	protected java.util.List<SatisfierProperty> _property;
	protected java.util.List<String> _resourceType;

	public RequirementSatisfierImplementation(
			org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<SatisfierProperty> getProperty() {
		if (_property == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"CCM::CCM_Target::RequirementSatisfier", "property");
			_property = new java.util.ArrayList<SatisfierProperty>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					SatisfierProperty nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									SatisfierProperty.class);
					_property.add(nextWrapper);
				}
			}
		}
		return _property;
	}

	@Override
	public void addProperty(SatisfierProperty val) {
		// make sure the property list is created
		getProperty();

		final Object rawValue = ZDLUtil.getValue(element,
				"CCM::CCM_Target::RequirementSatisfier", "property");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_property != null) {
			_property.add(val);
		}
	}

	@Override
	public <T extends SatisfierProperty> T addProperty(Class<T> typeToCreate,
			String concept) {
		// make sure the property list is created
		getProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CCM::CCM_Target::RequirementSatisfier", "property",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_property != null) {
			_property.add(element);
		}
		return element;
	}

	@Override
	public SatisfierProperty addProperty() {
		// make sure the property list is created
		getProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CCM::CCM_Target::RequirementSatisfier", "property",
				"CCM::CCM_Target::SatisfierProperty");
		SatisfierProperty element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				SatisfierProperty.class);
		if (_property != null) {
			_property.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<String> getResourceType() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CCM::CCM_Target::RequirementSatisfier",
				"resourceType");

		if (_resourceType == null) {
			_resourceType = new java.util.ArrayList<String>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				_resourceType.add((String) next);

			}
		}
		return _resourceType;
	}

	@Override
	public void addResourceType(String val) {
		// make sure the resourceType list is created
		getResourceType();

		final Object rawValue = ZDLUtil.getValue(element,
				"CCM::CCM_Target::RequirementSatisfier", "resourceType");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val);
		if (_resourceType != null) {
			_resourceType.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
