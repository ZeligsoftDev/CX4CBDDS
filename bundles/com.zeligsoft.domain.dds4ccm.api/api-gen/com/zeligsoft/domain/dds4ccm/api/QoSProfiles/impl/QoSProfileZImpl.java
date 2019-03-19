package com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSProfile;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSForEntity;
import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSEntity;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class QoSProfileZImpl extends NamedElementImplementation implements
		QoSProfile {
	protected java.util.List<QoSForEntity> _qosForEntity;
	protected java.util.List<QoSEntity> _qosEntity;

	public QoSProfileZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<QoSForEntity> getQosForEntity() {
		if (_qosForEntity == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS4CCM::QoSProfiles::QoSProfile",
							"qosForEntity");
			_qosForEntity = new java.util.ArrayList<QoSForEntity>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					QoSForEntity nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									QoSForEntity.class);
					_qosForEntity.add(nextWrapper);
				}
			}
		}
		return _qosForEntity;
	}

	@Override
	public void addQosForEntity(QoSForEntity val) {
		// make sure the qosForEntity list is created
		getQosForEntity();

		final Object rawValue = ZDLUtil.getValue(element,
				"DDS4CCM::QoSProfiles::QoSProfile", "qosForEntity");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_qosForEntity != null) {
			_qosForEntity.add(val);
		}
	}

	@Override
	public <T extends QoSForEntity> T addQosForEntity(Class<T> typeToCreate,
			String concept) {
		// make sure the qosForEntity list is created
		getQosForEntity();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS4CCM::QoSProfiles::QoSProfile", "qosForEntity",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_qosForEntity != null) {
			_qosForEntity.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<QoSEntity> getQosEntity() {
		if (_qosEntity == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS4CCM::QoSProfiles::QoSProfile",
							"qosEntity");
			_qosEntity = new java.util.ArrayList<QoSEntity>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					QoSEntity nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next,
							QoSEntity.class);
					_qosEntity.add(nextWrapper);
				}
			}
		}
		return _qosEntity;
	}

	@Override
	public void addQosEntity(QoSEntity val) {
		// make sure the qosEntity list is created
		getQosEntity();

		final Object rawValue = ZDLUtil.getValue(element,
				"DDS4CCM::QoSProfiles::QoSProfile", "qosEntity");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_qosEntity != null) {
			_qosEntity.add(val);
		}
	}

	@Override
	public <T extends QoSEntity> T addQosEntity(Class<T> typeToCreate,
			String concept) {
		// make sure the qosEntity list is created
		getQosEntity();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS4CCM::QoSProfiles::QoSProfile", "qosEntity",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_qosEntity != null) {
			_qosEntity.add(element);
		}
		return element;
	}

	@Override
	public QoSEntity addQosEntity() {
		// make sure the qosEntity list is created
		getQosEntity();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "DDS4CCM::QoSProfiles::QoSProfile", "qosEntity",
				"DDS4CCM::QoSProfiles::QoSEntity");
		QoSEntity element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, QoSEntity.class);
		if (_qosEntity != null) {
			_qosEntity.add(element);
		}
		return element;
	}

	@Override
	public String getFilename() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS4CCM::QoSProfiles::QoSProfile", "filename");
		return (String) rawValue;
	}

	@Override
	public void setFilename(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::QoSProfiles::QoSProfile",
				"filename", val);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
