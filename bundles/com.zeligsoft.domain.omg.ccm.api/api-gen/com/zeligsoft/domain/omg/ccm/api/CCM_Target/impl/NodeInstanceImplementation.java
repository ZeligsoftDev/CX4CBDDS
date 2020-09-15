package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.NodeInstance;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Node;
import com.zeligsoft.domain.zml.api.ZML_Core.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class NodeInstanceImplementation extends NamedElementImplementation implements NodeInstance {
	protected Node _type;

	public NodeInstanceImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getUpperBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::TypedElement",
				"upperBound");
		return (Integer) rawValue;
	}

	@Override
	public void setUpperBound(Integer val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::TypedElement", "upperBound", val);
	}

	@Override
	public Integer getLowerBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::TypedElement",
				"lowerBound");
		return (Integer) rawValue;
	}

	@Override
	public void setLowerBound(Integer val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::TypedElement", "lowerBound", val);
	}

	@Override
	public String getLabel() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CCM::CCM_Target::NodeInstance",
				"label");
		return (String) rawValue;
	}

	@Override
	public void setLabel(String val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::NodeInstance", "label", val);
	}

	@Override
	public Node getTypeOverride() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CCM::CCM_Target::NodeInstance", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, Node.class);
			}
		}
		return _type;
	}

	@Override
	public void setTypeOverride(Node val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::NodeInstance", "type", val.eObject());
	}

	@Override
	public Type getType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setType(Type val) {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
