package com.zeligsoft.domain.idl3plus.api.Connectors.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.idl3plus.api.Connectors.TypedConnector;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.AssemblyConnectorImplementation;

import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TypedConnectorZImpl extends AssemblyConnectorImplementation
		implements TypedConnector {
	protected ConnectorDef _connectorType;

	public TypedConnectorZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ConnectorDef getConnectorType() {
		if (_connectorType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"IDL3Plus::Connectors::TypedConnector",
							"connectorType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_connectorType = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ConnectorDef.class);
			}
		}
		return _connectorType;
	}

	@Override
	public void setConnectorType(ConnectorDef val) {
		ZDLUtil.setValue(element, "IDL3Plus::Connectors::TypedConnector",
				"connectorType", val.eObject());
	}

}
