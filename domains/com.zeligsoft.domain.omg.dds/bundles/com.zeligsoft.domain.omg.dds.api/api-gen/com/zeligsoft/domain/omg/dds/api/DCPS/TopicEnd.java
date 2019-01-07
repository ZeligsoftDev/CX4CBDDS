package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface TopicEnd extends ConnectorEnd {
	DomainTopic getTopic();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TopicEnd
	 */
	static final TypeSelectPredicate<TopicEnd> type = new TypeSelectPredicate<TopicEnd>(
			"DDS::DCPS::TopicEnd", //$NON-NLS-1$
			TopicEnd.class);
}
