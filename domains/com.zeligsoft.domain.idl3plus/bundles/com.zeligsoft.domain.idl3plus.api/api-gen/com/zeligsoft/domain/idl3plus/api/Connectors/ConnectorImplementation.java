package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

public interface ConnectorImplementation extends StructuralRealization {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorImplementation
	 */
	static final TypeSelectPredicate<ConnectorImplementation> type = new TypeSelectPredicate<ConnectorImplementation>(
			"IDL3Plus::Connectors::ConnectorImplementation", //$NON-NLS-1$
			ConnectorImplementation.class);
}
