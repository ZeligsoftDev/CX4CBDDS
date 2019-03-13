package com.zeligsoft.domain.omg.dds.api.Topics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Topics.TopicField;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

public class TopicFieldZImpl extends NamedElementImplementation implements
		TopicField {
	protected CORBAType _type;

	public TopicFieldZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CORBAType getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Topics::TopicField", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAType.class);
			}
		}
		return _type;
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
