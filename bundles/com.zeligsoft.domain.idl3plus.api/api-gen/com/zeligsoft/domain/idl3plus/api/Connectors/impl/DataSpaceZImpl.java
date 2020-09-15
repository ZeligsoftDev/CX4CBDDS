package com.zeligsoft.domain.idl3plus.api.Connectors.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.idl3plus.api.Connectors.DataSpace;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DataSpaceZImpl extends NamedElementImplementation implements DataSpace {
	protected ConnectorDef _connectorType;
	protected ComponentInterface _definition;

	public DataSpaceZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ConnectorDef getConnectorType() {
		if (_connectorType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"IDL3Plus::Connectors::DataSpace", "connectorType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_connectorType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						ConnectorDef.class);
			}
		}
		return _connectorType;
	}

	@Override
	public void setConnectorType(ConnectorDef val) {
		ZDLUtil.setValue(element, "IDL3Plus::Connectors::DataSpace", "connectorType", val.eObject());
	}

	@Override
	public ComponentInterface getDefinition() {
		if (_definition == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"ZMLMM::ZML_Component::Part", "definition");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_definition = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						ComponentInterface.class);
			}
		}
		return _definition;
	}

	@Override
	public void setDefinition(ComponentInterface val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::Part", "definition", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
