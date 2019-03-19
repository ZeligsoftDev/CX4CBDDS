package com.zeligsoft.domain.omg.dds.api.DCPS;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ConnectorEnd extends ZObject {
	org.eclipse.uml2.uml.ConnectorEnd asConnectorEnd();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorEnd
	 */
	static final TypeSelectPredicate<ConnectorEnd> type = new TypeSelectPredicate<ConnectorEnd>(
			"DDS::DCPS::ConnectorEnd", //$NON-NLS-1$
			ConnectorEnd.class);
}
