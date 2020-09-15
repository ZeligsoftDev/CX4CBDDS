package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface DataSpace extends NamedElement, Part {
	ConnectorDef getConnectorType();

	void setConnectorType(ConnectorDef val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DataSpace
	 */
	static final TypeSelectPredicate<DataSpace> type = new TypeSelectPredicate<DataSpace>(
			"IDL3Plus::Connectors::DataSpace", //$NON-NLS-1$
			DataSpace.class);
}
