package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ParticipantEnd extends ConnectorEnd {
	DataReaderWriter getReaderWriter();

	DomainParticipant getParticipant();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ParticipantEnd
	 */
	static final TypeSelectPredicate<ParticipantEnd> type = new TypeSelectPredicate<ParticipantEnd>(
			"DDS::DCPS::ParticipantEnd", //$NON-NLS-1$
			ParticipantEnd.class);
}
