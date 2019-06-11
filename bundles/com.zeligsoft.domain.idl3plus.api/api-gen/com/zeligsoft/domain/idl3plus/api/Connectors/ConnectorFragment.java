package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

public interface ConnectorFragment extends ComponentInterface {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorFragment
	 */
	static final TypeSelectPredicate<ConnectorFragment> type = new TypeSelectPredicate<ConnectorFragment>(
			"IDL3Plus::Connectors::ConnectorFragment", //$NON-NLS-1$
			ConnectorFragment.class);
}
