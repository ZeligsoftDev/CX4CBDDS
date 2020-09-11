package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.dsQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.HistoryQosPolicyKind;
import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class dsQosPolicyZImpl extends qosPolicyZImpl implements dsQosPolicy {
	protected HistoryQosPolicyKind _history_kind;
	protected Duration _service_cleanup_delay;

	public dsQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getMax_samples() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::dsQosPolicy",
				"max_samples");
		return (Integer) rawValue;
	}

	@Override
	public void setMax_samples(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::dsQosPolicy", "max_samples", val);
	}

	@Override
	public Integer getHistory_depth() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::dsQosPolicy",
				"history_depth");
		return (Integer) rawValue;
	}

	@Override
	public void setHistory_depth(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::dsQosPolicy", "history_depth", val);
	}

	@Override
	public HistoryQosPolicyKind getHistory_kind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::dsQosPolicy",
				"history_kind");

		if (_history_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_history_kind = HistoryQosPolicyKind.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _history_kind;
	}

	@Override
	public void setHistory_kind(HistoryQosPolicyKind val) {
		ZDLUtil.setValue(element, "DDS::QOS::dsQosPolicy", "history_kind", val.eObject(element));
	}

	@Override
	public Integer getMax_instances() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::dsQosPolicy",
				"max_instances");
		return (Integer) rawValue;
	}

	@Override
	public void setMax_instances(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::dsQosPolicy", "max_instances", val);
	}

	@Override
	public Duration getService_cleanup_delay() {
		if (_service_cleanup_delay == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::dsQosPolicy",
					"service_cleanup_delay");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_service_cleanup_delay = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _service_cleanup_delay;
	}

	@Override
	public void setService_cleanup_delay(Duration val) {
		ZDLUtil.setValue(element, "DDS::QOS::dsQosPolicy", "service_cleanup_delay", val.eObject());
	}

	@Override
	public <T extends Duration> T createService_cleanup_delay(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::QOS::dsQosPolicy",
				"service_cleanup_delay", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public Duration createService_cleanup_delay() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::QOS::dsQosPolicy",
				"service_cleanup_delay", "DDS::QOS::Duration");
		Duration element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				Duration.class);
		return element;
	}

	@Override
	public Integer getMax_samples_per_instance() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::dsQosPolicy",
				"max_samples_per_instance");
		return (Integer) rawValue;
	}

	@Override
	public void setMax_samples_per_instance(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::dsQosPolicy", "max_samples_per_instance", val);
	}

}
