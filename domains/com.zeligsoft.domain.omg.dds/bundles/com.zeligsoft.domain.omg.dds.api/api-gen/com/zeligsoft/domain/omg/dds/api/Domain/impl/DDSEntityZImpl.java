package com.zeligsoft.domain.omg.dds.api.Domain.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Domain.DDSEntity;
import com.zeligsoft.domain.omg.dds.api.Core.impl.ClassifierZImpl;

import com.zeligsoft.domain.omg.dds.api.Domain.QoSProperty;

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

}
