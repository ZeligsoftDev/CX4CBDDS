package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Implementation extends ZObject {
	java.util.List<WorkerFunction> getWorker();

	void addWorker(WorkerFunction val);

	<T extends WorkerFunction> T addWorker(Class<T> typeToCreate, String concept);

	WorkerFunction addWorker();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Implementation
	 */
	static final TypeSelectPredicate<Implementation> type = new TypeSelectPredicate<Implementation>(
			"ZMLMM::ZML_Component::Implementation", //$NON-NLS-1$
			Implementation.class);
}
