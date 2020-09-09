package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Requirement;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class RequirementImplementation extends NamedElementImplementation implements Requirement {
	protected java.util.List<CXAttribute> _property;

	public RequirementImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CXAttribute> getProperty() {
		if (_property == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Target::Requirement", "property");
			_property = new java.util.ArrayList<CXAttribute>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXAttribute nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXAttribute.class);
					_property.add(nextWrapper);
				}
			}
		}
		return _property;
	}

	@Override
	public void addProperty(CXAttribute val) {
		// make sure the property list is created
		getProperty();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Target::Requirement", "property");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_property != null) {
			_property.add(val);
		}
	}

	@Override
	public <T extends CXAttribute> T addProperty(Class<T> typeToCreate, String concept) {
		// make sure the property list is created
		getProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Requirement",
				"property", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_property != null) {
			_property.add(element);
		}
		return element;
	}

	@Override
	public CXAttribute addProperty() {
		// make sure the property list is created
		getProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CCM::CCM_Target::Requirement",
				"property", "CXDomain::IDL::CXAttribute");
		CXAttribute element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				CXAttribute.class);
		if (_property != null) {
			_property.add(element);
		}
		return element;
	}

	@Override
	public String getResourceType() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::Requirement",
				"resourceType");
		return (String) rawValue;
	}

	@Override
	public void setResourceType(String val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::Requirement", "resourceType", val);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
