package com.zeligsoft.domain.idl3plus.api.Connectors.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDefaultValueBinding;

import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ConnectorDefaultValueBindingZImpl extends ZObjectImpl implements ConnectorDefaultValueBinding {
	protected ConnectorDef _definition;
	protected NamedElement _connectorInstance;

	public ConnectorDefaultValueBindingZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ConnectorDef getDefinition() {
		if (_definition == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"IDL3Plus::Connectors::ConnectorDefaultValueBinding", "definition");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_definition = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						ConnectorDef.class);
			}
		}
		return _definition;
	}

	@Override
	public void setDefinition(ConnectorDef val) {
		ZDLUtil.setValue(element, "IDL3Plus::Connectors::ConnectorDefaultValueBinding", "definition", val.eObject());
	}

	@Override
	public NamedElement getConnectorInstance() {
		if (_connectorInstance == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"IDL3Plus::Connectors::ConnectorDefaultValueBinding", "connectorInstance");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_connectorInstance = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						NamedElement.class);
			}
		}
		return _connectorInstance;
	}

	@Override
	public void setConnectorInstance(NamedElement val) {
		ZDLUtil.setValue(element, "IDL3Plus::Connectors::ConnectorDefaultValueBinding", "connectorInstance",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Package asPackage() {
		return (org.eclipse.uml2.uml.Package) eObject();
	}
}
