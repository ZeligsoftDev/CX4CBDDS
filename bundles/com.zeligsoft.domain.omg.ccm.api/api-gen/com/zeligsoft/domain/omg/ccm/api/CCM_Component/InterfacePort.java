package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.MessagePort;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;
import com.zeligsoft.domain.zml.api.ZML_Component.ConjugatedPort;

public interface InterfacePort extends MessagePort, ConjugatedPort,
		WorkerFunctionIdentifiable {
	Boolean getIsAsynchronous();

	void setIsAsynchronous(Boolean val);

	Boolean getHasCSL();

	void setHasCSL(Boolean val);

	ComponentInterface getConnectorType();

	void setConnectorType(ComponentInterface val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of InterfacePort
	 */
	static final TypeSelectPredicate<InterfacePort> type = new TypeSelectPredicate<InterfacePort>(
			"CCM::CCM_Component::InterfacePort", //$NON-NLS-1$
			InterfacePort.class);
}
