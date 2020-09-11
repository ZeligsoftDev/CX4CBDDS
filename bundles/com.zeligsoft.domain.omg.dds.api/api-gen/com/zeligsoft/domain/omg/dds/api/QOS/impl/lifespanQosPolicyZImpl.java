package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.lifespanQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class lifespanQosPolicyZImpl extends qosPolicyZImpl implements lifespanQosPolicy {
	protected Duration _duration;

	public lifespanQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Duration getDuration() {
		if (_duration == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS::QOS::lifespanQosPolicy", "duration");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_duration = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _duration;
	}

	@Override
	public void setDuration(Duration val) {
		ZDLUtil.setValue(element, "DDS::QOS::lifespanQosPolicy", "duration", val.eObject());
	}

	@Override
	public <T extends Duration> T createDuration(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::QOS::lifespanQosPolicy",
				"duration", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public Duration createDuration() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::QOS::lifespanQosPolicy",
				"duration", "DDS::QOS::Duration");
		Duration element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				Duration.class);
		return element;
	}

}
