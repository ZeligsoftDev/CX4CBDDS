package com.zeligsoft.domain.dds4ccm.api.QoSProfiles;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DataReaderWriterQoS extends QoSForEntity {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DataReaderWriterQoS
	 */
	static final TypeSelectPredicate<DataReaderWriterQoS> type = new TypeSelectPredicate<DataReaderWriterQoS>(
			"DDS4CCM::QoSProfiles::DataReaderWriterQoS", //$NON-NLS-1$
			DataReaderWriterQoS.class);
}
