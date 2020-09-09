package com.zeligsoft.domain.dds4ccm.api.DDSExtensions.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.DDSMessage;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXStructImplementation;

import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.MessageField;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DDSMessageZImpl extends CXStructImplementation implements DDSMessage {
	protected java.util.List<MessageField> _fields;

	public DDSMessageZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<MessageField> getFields() {
		if (_fields == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS4CCM::DDSExtensions::DDSMessage", "fields");
			_fields = new java.util.ArrayList<MessageField>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					MessageField nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							MessageField.class);
					_fields.add(nextWrapper);
				}
			}
		}
		return _fields;
	}

	@Override
	public void addFields(MessageField val) {
		// make sure the fields list is created
		getFields();

		final Object rawValue = ZDLUtil.getValue(element, "DDS4CCM::DDSExtensions::DDSMessage", "fields");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_fields != null) {
			_fields.add(val);
		}
	}

	@Override
	public <T extends MessageField> T addFields(Class<T> typeToCreate, String concept) {
		// make sure the fields list is created
		getFields();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element,
				"DDS4CCM::DDSExtensions::DDSMessage", "fields", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_fields != null) {
			_fields.add(element);
		}
		return element;
	}

	@Override
	public MessageField addFields() {
		// make sure the fields list is created
		getFields();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element,
				"DDS4CCM::DDSExtensions::DDSMessage", "fields", "DDS4CCM::DDSExtensions::MessageField");
		MessageField element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				MessageField.class);
		if (_fields != null) {
			_fields.add(element);
		}
		return element;
	}

}
