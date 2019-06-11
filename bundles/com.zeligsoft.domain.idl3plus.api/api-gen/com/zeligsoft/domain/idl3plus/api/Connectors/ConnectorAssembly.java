package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

public interface ConnectorAssembly extends StructuralRealization {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorAssembly
	 */
	static final TypeSelectPredicate<ConnectorAssembly> type = new TypeSelectPredicate<ConnectorAssembly>(
			"IDL3Plus::Connectors::ConnectorAssembly", //$NON-NLS-1$
			ConnectorAssembly.class);
}
