package com.zeligsoft.domain.omg.dds.api.Topics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Topics.Topic;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.dds.api.Topics.TopicField;
import com.zeligsoft.domain.omg.dds.api.Topics.TopicKind;
import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TopicZImpl extends NamedElementImplementation implements Topic {
	protected TopicKind _kind;
	protected java.util.List<qosProperty> _qosProperty;
	protected TopicField _type;

	public TopicZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getExpression() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::Topics::Topic",
				"expression");
		return (String) rawValue;
	}

	@Override
	public void setExpression(String val) {
		ZDLUtil.setValue(element, "DDS::Topics::Topic", "expression", val);
	}

	@Override
	public TopicKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::Topics::Topic", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = TopicKind.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(TopicKind val) {
		ZDLUtil.setValue(element, "DDS::Topics::Topic", "kind", val.eObject(element));
	}

	@Override
	public java.util.List<qosProperty> getQosProperty() {
		if (_qosProperty == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::Topics::Topic",
					"qosProperty");
			_qosProperty = new java.util.ArrayList<qosProperty>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					qosProperty nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							qosProperty.class);
					_qosProperty.add(nextWrapper);
				}
			}
		}
		return _qosProperty;
	}

	@Override
	public void addQosProperty(qosProperty val) {
		// make sure the qosProperty list is created
		getQosProperty();

		final Object rawValue = ZDLUtil.getValue(element, "DDS::Topics::Topic", "qosProperty");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_qosProperty != null) {
			_qosProperty.add(val);
		}
	}

	@Override
	public <T extends qosProperty> T addQosProperty(Class<T> typeToCreate, String concept) {
		// make sure the qosProperty list is created
		getQosProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::Topics::Topic",
				"qosProperty", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_qosProperty != null) {
			_qosProperty.add(element);
		}
		return element;
	}

	@Override
	public qosProperty addQosProperty() {
		// make sure the qosProperty list is created
		getQosProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::Topics::Topic",
				"qosProperty", "DDS::QOS::qosProperty");
		qosProperty element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				qosProperty.class);
		if (_qosProperty != null) {
			_qosProperty.add(element);
		}
		return element;
	}

	@Override
	public TopicField getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::Topics::Topic",
					"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, TopicField.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(TopicField val) {
		ZDLUtil.setValue(element, "DDS::Topics::Topic", "type", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
