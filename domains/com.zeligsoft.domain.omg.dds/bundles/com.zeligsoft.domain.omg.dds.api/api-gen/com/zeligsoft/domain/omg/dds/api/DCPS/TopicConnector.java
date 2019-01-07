package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface TopicConnector extends NamedEntity {
	java.util.List<ConnectorEnd> getEnd();

	org.eclipse.uml2.uml.Connector asConnector();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TopicConnector
	 */
	static final TypeSelectPredicate<TopicConnector> type = new TypeSelectPredicate<TopicConnector>(
			"DDS::DCPS::TopicConnector", //$NON-NLS-1$
			TopicConnector.class);
}
