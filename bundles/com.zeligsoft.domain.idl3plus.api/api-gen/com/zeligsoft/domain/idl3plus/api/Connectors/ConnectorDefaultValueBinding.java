package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface ConnectorDefaultValueBinding extends ZObject {
	ConnectorDef getDefinition();

	void setDefinition(ConnectorDef val);

	NamedElement getConnectorInstance();

	void setConnectorInstance(NamedElement val);

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConnectorDefaultValueBinding
	 */
	static final TypeSelectPredicate<ConnectorDefaultValueBinding> type = new TypeSelectPredicate<ConnectorDefaultValueBinding>(
			"IDL3Plus::Connectors::ConnectorDefaultValueBinding", //$NON-NLS-1$
			ConnectorDefaultValueBinding.class);
}
