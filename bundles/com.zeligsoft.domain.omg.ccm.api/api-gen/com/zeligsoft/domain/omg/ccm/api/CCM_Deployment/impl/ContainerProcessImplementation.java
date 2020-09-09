package com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Deployment.ContainerProcess;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ContainerProcessImplementation extends NamedElementImplementation implements ContainerProcess {
	protected java.util.List<Property> _property;

	public ContainerProcessImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<Property> getProperty() {
		if (_property == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Deployment::ContainerProcess", "property");
			_property = new java.util.ArrayList<Property>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Property nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							Property.class);
					_property.add(nextWrapper);
				}
			}
		}
		return _property;
	}

	@Override
	public void addProperty(Property val) {
		// make sure the property list is created
		getProperty();

		final Object rawValue = ZDLUtil.getValue(element, "CCM::CCM_Deployment::ContainerProcess", "property");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_property != null) {
			_property.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Component asComponent() {
		return (org.eclipse.uml2.uml.Component) eObject();
	}
}
