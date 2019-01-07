package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ConjugatedPort extends ZObject {
	Boolean getIsConjugated();

	void setIsConjugated(Boolean val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConjugatedPort
	 */
	static final TypeSelectPredicate<ConjugatedPort> type = new TypeSelectPredicate<ConjugatedPort>(
			"ZMLMM::ZML_Component::ConjugatedPort", //$NON-NLS-1$
			ConjugatedPort.class);
}
