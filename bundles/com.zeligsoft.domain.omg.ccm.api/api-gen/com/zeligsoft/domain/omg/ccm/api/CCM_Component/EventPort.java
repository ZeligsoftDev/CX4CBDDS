package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.zml.api.ZML_Component.ConjugatedPort;

public interface EventPort extends Port, ConjugatedPort {
	java.util.List<Event> getPublishesEvent();

	void addPublishesEvent(Event val);

	java.util.List<Event> getConsumesEvent();

	void addConsumesEvent(Event val);

	@Override
	Type getType();

	@Override
	void setType(Type val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of EventPort
	 */
	static final TypeSelectPredicate<EventPort> type = new TypeSelectPredicate<EventPort>(
			"CCM::CCM_Component::EventPort", //$NON-NLS-1$
			EventPort.class);
}
