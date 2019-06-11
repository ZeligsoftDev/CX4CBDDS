package com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwPart;

import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwComponent;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class SwPartImplementation extends ZObjectImpl implements SwPart {
	protected SwComponent _definition;

	public SwPartImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public SwComponent getDefinition() {
		if (_definition == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_SwPlatform::SwPart",
							"definition");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_definition = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						SwComponent.class);
			}
		}
		return _definition;
	}

	@Override
	public void setDefinition(SwComponent val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_SwPlatform::SwPart",
				"definition", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
