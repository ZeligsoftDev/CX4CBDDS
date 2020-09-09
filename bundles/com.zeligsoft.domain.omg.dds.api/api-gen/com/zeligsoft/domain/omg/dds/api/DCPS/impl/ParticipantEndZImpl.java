package com.zeligsoft.domain.omg.dds.api.DCPS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.DCPS.ParticipantEnd;
import com.zeligsoft.domain.omg.dds.api.DCPS.impl.ConnectorEndZImpl;

import com.zeligsoft.domain.omg.dds.api.DCPS.DataReaderWriter;
import com.zeligsoft.domain.omg.dds.api.DCPS.DomainParticipant;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ParticipantEndZImpl extends ConnectorEndZImpl implements ParticipantEnd {
	protected DataReaderWriter _readerWriter;
	protected DomainParticipant _participant;

	public ParticipantEndZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DataReaderWriter getReaderWriter() {
		if (_readerWriter == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::ParticipantEnd",
					"readerWriter");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_readerWriter = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						DataReaderWriter.class);
			}
		}
		return _readerWriter;
	}

	@Override
	public void setReaderWriter(DataReaderWriter val) {
		ZDLUtil.setValue(element, "DDS::DCPS::ParticipantEnd", "readerWriter", val.eObject());
	}

	@Override
	public DomainParticipant getParticipant() {
		if (_participant == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::DCPS::ParticipantEnd",
					"participant");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_participant = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						DomainParticipant.class);
			}
		}
		return _participant;
	}

	@Override
	public void setParticipant(DomainParticipant val) {
		ZDLUtil.setValue(element, "DDS::DCPS::ParticipantEnd", "participant", val.eObject());
	}

}
