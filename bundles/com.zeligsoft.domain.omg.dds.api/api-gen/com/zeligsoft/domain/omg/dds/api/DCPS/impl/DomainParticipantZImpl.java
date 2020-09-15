package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.DomainParticipant;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DDSComponent;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainParticipantZImpl extends NamedEntityZImpl implements DomainParticipant {
	protected DDSComponent _type;

	public DomainParticipantZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DDSComponent getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS::DCPS::DomainParticipant", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						DDSComponent.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(DDSComponent val) {
		ZDLUtil.setValue(element, "DDS::DCPS::DomainParticipant", "type", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
