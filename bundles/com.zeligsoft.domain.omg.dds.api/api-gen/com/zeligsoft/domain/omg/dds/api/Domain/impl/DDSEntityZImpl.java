package com.zeligsoft.domain.omg.dds.api.Domain.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Domain.DDSEntity;
import com.zeligsoft.domain.omg.dds.api.Core.impl.ClassifierZImpl;

import com.zeligsoft.domain.omg.dds.api.Domain.QoSProperty;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class DDSEntityZImpl extends ClassifierZImpl implements
		DDSEntity {
	protected java.util.List<QoSProperty> _qosPolicy;

	public DDSEntityZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<QoSProperty> getQosPolicy() {
		if (_qosPolicy == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Domain::DDSEntity", "qosPolicy");
			_qosPolicy = new java.util.ArrayList<QoSProperty>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					QoSProperty nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									QoSProperty.class);
					_qosPolicy.add(nextWrapper);
				}
			}
		}
		return _qosPolicy;
	}

	@Override
	public void addQosPolicy(QoSProperty val) {
		// make sure the qosPolicy list is created
		getQosPolicy();

		final Object rawValue = ZDLUtil.getValue(element,
				"DDS::Domain::DDSEntity", "qosPolicy");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_qosPolicy != null) {
			_qosPolicy.add(val);
		}
	}

	@Override
	public <T extends QoSProperty> T addQosPolicy(Class<T> typeToCreate,
			String concept) {
		// make sure the qosPolicy list is created
		getQosPolicy();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::Domain::DDSEntity", "qosPolicy", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_qosPolicy != null) {
			_qosPolicy.add(element);
		}
		return element;
	}

	@Override
	public QoSProperty addQosPolicy() {
		// make sure the qosPolicy list is created
		getQosPolicy();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS::Domain::DDSEntity", "qosPolicy",
				"DDS::Domain::QoSProperty");
		QoSProperty element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, QoSProperty.class);
		if (_qosPolicy != null) {
			_qosPolicy.add(element);
		}
		return element;
	}

}
