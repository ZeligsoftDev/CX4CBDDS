package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.Parameter;

public interface WorkerFunction extends Operation {
	String getBody();

	void setBody(String val);

	Port getReceivingPort();

	void setReceivingPort(Port val);

	java.util.List<Parameter> getParameter();

	void addParameter(Parameter val);

	<T extends Parameter> T addParameter(Class<T> typeToCreate, String concept);

	Parameter addParameter();

	Operation getPortOperation();

	void setPortOperation(Operation val);

	String getUuid();

	void setUuid(String val);

	Boolean getDelegate();

	void setDelegate(Boolean val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of WorkerFunction
	 */
	static final TypeSelectPredicate<WorkerFunction> type = new TypeSelectPredicate<WorkerFunction>(
			"ZMLMM::ZML_Component::WorkerFunction", //$NON-NLS-1$
			WorkerFunction.class);
}
