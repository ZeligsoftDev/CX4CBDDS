package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Subscriber extends PublisherSubscriber {
	java.util.List<DataReader> getReaders();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Subscriber
	 */
	static final TypeSelectPredicate<Subscriber> type = new TypeSelectPredicate<Subscriber>(
			"DDS::DCPS::Subscriber", //$NON-NLS-1$
			Subscriber.class);
}
