package com.zeligsoft.domain.dds4ccm.api.QoSProfiles.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSEntity;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.dds4ccm.api.QoSProfiles.QoSForEntity;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class QoSEntityZImpl extends NamedElementImplementation implements
		QoSEntity {
	protected QoSForEntity _type;

	public QoSEntityZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public QoSForEntity getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS4CCM::QoSProfiles::QoSEntity",
							"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						QoSForEntity.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(QoSForEntity val) {
		ZDLUtil.setValue(element, "DDS4CCM::QoSProfiles::QoSEntity", "type",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
