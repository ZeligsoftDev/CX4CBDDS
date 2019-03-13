package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface WorkerFunctionImpl extends NamedElement {
	java.util.List<String> getLanguage();

	void addLanguage(String val);

	java.util.List<String> getBody();

	void addBody(String val);

	WorkerFunction getWorkerFunction();

	void setWorkerFunction(WorkerFunction val);

	org.eclipse.uml2.uml.OpaqueBehavior asOpaqueBehavior();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of WorkerFunctionImpl
	 */
	static final TypeSelectPredicate<WorkerFunctionImpl> type = new TypeSelectPredicate<WorkerFunctionImpl>(
			"ZMLMM::ZML_Component::WorkerFunctionImpl", //$NON-NLS-1$
			WorkerFunctionImpl.class);
}
