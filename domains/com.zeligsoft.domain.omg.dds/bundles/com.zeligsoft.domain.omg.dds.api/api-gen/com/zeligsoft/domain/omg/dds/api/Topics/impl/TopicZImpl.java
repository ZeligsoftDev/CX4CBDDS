package com.zeligsoft.domain.omg.dds.api.Topics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Topics.Topic;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;
import com.zeligsoft.domain.omg.dds.api.Topics.TopicField;
import com.zeligsoft.domain.omg.dds.api.Topics.TopicKind;

public class TopicZImpl extends NamedElementImplementation implements Topic {
	protected TopicField _type;
	protected java.util.List<qosProperty> _qosProperty;
	protected TopicKind _kind;

	public TopicZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getExpression() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::Topics::Topic", "expression");
		return (String) rawValue;
	}

	@Override
	public TopicField getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Topics::Topic", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						TopicField.class);
			}
		}
		return _type;
	}

	@Override
	public java.util.List<qosProperty> getQosProperty() {
		if (_qosProperty == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Topics::Topic", "qosProperty");
			_qosProperty = new java.util.ArrayList<qosProperty>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					qosProperty nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									qosProperty.class);
					_qosProperty.add(nextWrapper);
				}
			}
		}
		return _qosProperty;
	}

	@Override
	public TopicKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::Topics::Topic", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = TopicKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
