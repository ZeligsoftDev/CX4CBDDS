package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.rdlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class rdlQosPolicyZImpl extends qosPolicyZImpl implements rdlQosPolicy {
	protected Duration _autopurge_nowriter_samples_delay;
	protected Duration _autopurge_disposed_samples_delay;

	public rdlQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Duration getAutopurge_nowriter_samples_delay() {
		if (_autopurge_nowriter_samples_delay == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::rdlQosPolicy",
							"autopurge_nowriter_samples_delay");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_autopurge_nowriter_samples_delay = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) rawValue,
								Duration.class);
			}
		}
		return _autopurge_nowriter_samples_delay;
	}

	@Override
	public void setAutopurge_nowriter_samples_delay(Duration val) {
		ZDLUtil.setValue(element, "DDS::QOS::rdlQosPolicy",
				"autopurge_nowriter_samples_delay", val.eObject());
	}

	@Override
	public <T extends Duration> T createAutopurge_nowriter_samples_delay(
			Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::QOS::rdlQosPolicy",
				"autopurge_nowriter_samples_delay", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		return element;
	}

	@Override
	public Duration createAutopurge_nowriter_samples_delay() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::QOS::rdlQosPolicy",
				"autopurge_nowriter_samples_delay", "DDS::QOS::Duration");
		Duration element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, Duration.class);
		return element;
	}

	@Override
	public Duration getAutopurge_disposed_samples_delay() {
		if (_autopurge_disposed_samples_delay == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::rdlQosPolicy",
							"autopurge_disposed_samples_delay");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_autopurge_disposed_samples_delay = ZDLFactoryRegistry.INSTANCE
						.create((org.eclipse.emf.ecore.EObject) rawValue,
								Duration.class);
			}
		}
		return _autopurge_disposed_samples_delay;
	}

	@Override
	public void setAutopurge_disposed_samples_delay(Duration val) {
		ZDLUtil.setValue(element, "DDS::QOS::rdlQosPolicy",
				"autopurge_disposed_samples_delay", val.eObject());
	}

	@Override
	public <T extends Duration> T createAutopurge_disposed_samples_delay(
			Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::QOS::rdlQosPolicy",
				"autopurge_disposed_samples_delay", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		return element;
	}

	@Override
	public Duration createAutopurge_disposed_samples_delay() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::QOS::rdlQosPolicy",
				"autopurge_disposed_samples_delay", "DDS::QOS::Duration");
		Duration element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, Duration.class);
		return element;
	}

}
