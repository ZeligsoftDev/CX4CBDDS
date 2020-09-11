package com.zeligsoft.domain.omg.dds.api.Topics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Topics.TopicField;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TopicFieldZImpl extends NamedElementImplementation implements TopicField {
	protected CXType _type;

	public TopicFieldZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXType getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::Topics::TopicField",
					"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(CXType val) {
		ZDLUtil.setValue(element, "DDS::Topics::TopicField", "type", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
