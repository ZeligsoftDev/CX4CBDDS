package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public interface DDSComponent extends NamedEntity {
	ComponentPart getParticipants();

	void setParticipants(ComponentPart val);

	java.util.List<TopicConnector> getTopicConnector();

	void addTopicConnector(TopicConnector val);

	<T extends TopicConnector> T addTopicConnector(Class<T> typeToCreate, String concept);

	TopicConnector addTopicConnector();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DDSComponent
	 */
	static final TypeSelectPredicate<DDSComponent> type = new TypeSelectPredicate<DDSComponent>(
			"DDS::DCPS::DDSComponent", //$NON-NLS-1$
			DDSComponent.class);
}
