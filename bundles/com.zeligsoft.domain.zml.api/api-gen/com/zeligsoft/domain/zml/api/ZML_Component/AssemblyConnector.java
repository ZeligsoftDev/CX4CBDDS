package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface AssemblyConnector extends ZObject {
	java.util.List<Port> getPortEnd();

	void addPortEnd(Port val);

	java.util.List<ConnectorEnd> getEnd();

	void addEnd(ConnectorEnd val);

	<T extends ConnectorEnd> T addEnd(Class<T> typeToCreate, String concept);

	ConnectorEnd addEnd();

	org.eclipse.uml2.uml.Connector asConnector();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of AssemblyConnector
	 */
	static final TypeSelectPredicate<AssemblyConnector> type = new TypeSelectPredicate<AssemblyConnector>(
			"ZMLMM::ZML_Component::AssemblyConnector", //$NON-NLS-1$
			AssemblyConnector.class);
}
