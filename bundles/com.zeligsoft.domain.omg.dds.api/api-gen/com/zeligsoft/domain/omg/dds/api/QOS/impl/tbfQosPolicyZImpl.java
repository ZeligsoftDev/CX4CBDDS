package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.tbfQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class tbfQosPolicyZImpl extends qosPolicyZImpl implements tbfQosPolicy {
	protected Duration _minimum_separation;

	public tbfQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Duration getMinimum_separation() {
		if (_minimum_separation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::tbfQosPolicy",
							"minimum_separation");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_minimum_separation = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _minimum_separation;
	}

	@Override
	public void setMinimum_separation(Duration val) {
		ZDLUtil.setValue(element, "DDS::QOS::tbfQosPolicy",
				"minimum_separation", val.eObject());
	}

	@Override
	public <T extends Duration> T createMinimum_separation(
			Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::QOS::tbfQosPolicy", "minimum_separation",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		return element;
	}

	@Override
	public Duration createMinimum_separation() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::QOS::tbfQosPolicy", "minimum_separation",
				"DDS::QOS::Duration");
		Duration element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, Duration.class);
		return element;
	}

}
