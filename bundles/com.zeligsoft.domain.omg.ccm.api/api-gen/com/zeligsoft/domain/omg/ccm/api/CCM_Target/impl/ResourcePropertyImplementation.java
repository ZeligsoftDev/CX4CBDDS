package com.zeligsoft.domain.omg.ccm.api.CCM_Target.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.ccm.api.CCM_Target.ResourceProperty;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.TypedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Core.Type;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ResourcePropertyImplementation extends TypedElementImplementation
		implements ResourceProperty {
	protected Resource _type;

	public ResourcePropertyImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Resource getTypeOverride() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CCM::CCM_Target::ResourceProperty",
							"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Resource.class);
			}
		}
		return _type;
	}

	@Override
	public void setTypeOverride(Resource val) {
		ZDLUtil.setValue(element, "CCM::CCM_Target::ResourceProperty", "type",
				val.eObject());
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
