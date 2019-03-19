package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ConnectorEnd extends ZObject {
	Port getPort();

	void setPort(Port val);

	Part getPart();

	void setPart(Part val);

	Part getPartWithPort();

	void setPartWithPort(Part val);

	org.eclipse.uml2.uml.ConnectorEnd asConnectorEnd();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorEnd
	 */
	static final TypeSelectPredicate<ConnectorEnd> type = new TypeSelectPredicate<ConnectorEnd>(
			"ZMLMM::ZML_Component::ConnectorEnd", //$NON-NLS-1$
			ConnectorEnd.class);
}
