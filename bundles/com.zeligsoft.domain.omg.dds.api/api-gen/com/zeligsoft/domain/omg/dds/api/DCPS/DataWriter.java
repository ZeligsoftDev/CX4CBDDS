package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Topics.Topic;

public interface DataWriter extends DataReaderWriter {
	Topic getTopic();

	void setTopic(Topic val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DataWriter
	 */
	static final TypeSelectPredicate<DataWriter> type = new TypeSelectPredicate<DataWriter>("DDS::DCPS::DataWriter", //$NON-NLS-1$
			DataWriter.class);
}
