package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.Part;

import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class PartImplementation extends ZObjectImpl implements Part {
	protected ComponentInterface _definition;

	public PartImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public ComponentInterface getDefinition() {
		if (_definition == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Component::Part",
							"definition");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_definition = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ComponentInterface.class);
			}
		}
		return _definition;
	}

	@Override
	public void setDefinition(ComponentInterface val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::Part", "definition",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
