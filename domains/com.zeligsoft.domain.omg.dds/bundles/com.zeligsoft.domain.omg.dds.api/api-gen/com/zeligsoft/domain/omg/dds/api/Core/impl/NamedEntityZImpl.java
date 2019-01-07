package com.zeligsoft.domain.omg.dds.api.Core.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.dds.api.Core.NamedEntity;

public abstract class NamedEntityZImpl extends ZObjectImpl implements
		NamedEntity {
	protected java.util.List<NamedEntity> _ownedEntity;

	public NamedEntityZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<NamedEntity> getOwnedEntity() {
		if (_ownedEntity == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Core::NamedEntity",
							"ownedEntity");
			_ownedEntity = new java.util.ArrayList<NamedEntity>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					NamedEntity nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									NamedEntity.class);
					_ownedEntity.add(nextWrapper);
				}
			}
		}
		return _ownedEntity;
	}

	@Override
	public String getName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::Core::NamedEntity", "name");
		return (String) rawValue;
	}

}
