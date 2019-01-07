package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;

public interface TypedConnector extends AssemblyConnector {
	ConnectorDef getConnectorType();

	void setConnectorType(ConnectorDef val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TypedConnector
	 */
	static final TypeSelectPredicate<TypedConnector> type = new TypeSelectPredicate<TypedConnector>(
			"IDL3Plus::Connectors::TypedConnector", //$NON-NLS-1$
			TypedConnector.class);
}
