package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.ComponentPart;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.PublisherSubscriber;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ComponentPartZImpl extends NamedEntityZImpl implements
		ComponentPart {
	protected PublisherSubscriber _type;

	public ComponentPartZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public PublisherSubscriber getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::DCPS::ComponentPart", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						PublisherSubscriber.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(PublisherSubscriber val) {
		ZDLUtil.setValue(element, "DDS::DCPS::ComponentPart", "type",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
