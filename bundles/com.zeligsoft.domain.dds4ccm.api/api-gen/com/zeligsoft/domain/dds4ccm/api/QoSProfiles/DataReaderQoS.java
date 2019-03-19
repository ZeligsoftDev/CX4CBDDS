package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DataReaderQoS extends DataReaderWriterQoS {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DataReaderQoS
	 */
	static final TypeSelectPredicate<DataReaderQoS> type = new TypeSelectPredicate<DataReaderQoS>(
			"DDS4CCM::QoSProfiles::DataReaderQoS", //$NON-NLS-1$
			DataReaderQoS.class);
}
