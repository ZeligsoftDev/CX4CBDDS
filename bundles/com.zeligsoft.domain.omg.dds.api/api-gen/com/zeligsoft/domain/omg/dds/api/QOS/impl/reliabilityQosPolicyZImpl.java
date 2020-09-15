package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.reliabilityQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.RealiabilityQosPolicyKind;
import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class reliabilityQosPolicyZImpl extends qosPolicyZImpl implements reliabilityQosPolicy {
	protected RealiabilityQosPolicyKind _kind;
	protected Duration _max_blocking_time;

	public reliabilityQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public RealiabilityQosPolicyKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"DDS::QOS::reliabilityQosPolicy", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = RealiabilityQosPolicyKind.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(RealiabilityQosPolicyKind val) {
		ZDLUtil.setValue(element, "DDS::QOS::reliabilityQosPolicy", "kind", val.eObject(element));
	}

	@Override
	public Duration getMax_blocking_time() {
		if (_max_blocking_time == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS::QOS::reliabilityQosPolicy", "max_blocking_time");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_max_blocking_time = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _max_blocking_time;
	}

	@Override
	public void setMax_blocking_time(Duration val) {
		ZDLUtil.setValue(element, "DDS::QOS::reliabilityQosPolicy", "max_blocking_time", val.eObject());
	}

	@Override
	public <T extends Duration> T createMax_blocking_time(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::QOS::reliabilityQosPolicy",
				"max_blocking_time", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public Duration createMax_blocking_time() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::QOS::reliabilityQosPolicy",
				"max_blocking_time", "DDS::QOS::Duration");
		Duration element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				Duration.class);
		return element;
	}

}
