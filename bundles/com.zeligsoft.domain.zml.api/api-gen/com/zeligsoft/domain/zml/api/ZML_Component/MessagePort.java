package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.Type;

public interface MessagePort extends Port {
	java.util.List<Interface> getProvidedInterface();

	java.util.List<Interface> getRequiredInterface();

	@Override
	Type getType();

	@Override
	void setType(Type val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of MessagePort
	 */
	static final TypeSelectPredicate<MessagePort> type = new TypeSelectPredicate<MessagePort>(
			"ZMLMM::ZML_Component::MessagePort", //$NON-NLS-1$
			MessagePort.class);
}
