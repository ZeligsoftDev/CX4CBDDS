package com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwPart;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwComponent;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class HwPartImplementation extends ZObjectImpl implements HwPart {
	protected HwComponent _definition;

	public HwPartImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public HwComponent getDefinition() {
		if (_definition == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_HwPlatform::HwPart",
							"definition");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_definition = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						HwComponent.class);
			}
		}
		return _definition;
	}

	@Override
	public void setDefinition(HwComponent val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_HwPlatform::HwPart",
				"definition", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
