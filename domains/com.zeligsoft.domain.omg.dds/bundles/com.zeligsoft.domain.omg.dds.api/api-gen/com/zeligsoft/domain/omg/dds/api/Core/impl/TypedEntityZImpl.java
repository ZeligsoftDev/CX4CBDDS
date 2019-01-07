package com.zeligsoft.domain.omg.dds.api.Core.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Core.TypedEntity;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.Core.Specification;

public abstract class TypedEntityZImpl extends NamedEntityZImpl implements
		TypedEntity {
	protected Specification _type;

	public TypedEntityZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Specification getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Core::TypedEntity", "type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Specification.class);
			}
		}
		return _type;
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
