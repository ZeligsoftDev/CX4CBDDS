package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Publisher extends PublisherSubscriber {
	java.util.List<DataWriter> getWriters();

	void addWriters(DataWriter val);

	<T extends DataWriter> T addWriters(Class<T> typeToCreate, String concept);

	DataWriter addWriters();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Publisher
	 */
	static final TypeSelectPredicate<Publisher> type = new TypeSelectPredicate<Publisher>(
			"DDS::DCPS::Publisher", //$NON-NLS-1$
			Publisher.class);
}
