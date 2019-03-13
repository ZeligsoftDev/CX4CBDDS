package com.zeligsoft.domain.omg.dds.api.Core.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Core.Classifier;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.Core.TypedEntity;

public abstract class ClassifierZImpl extends NamedEntityZImpl implements
		Classifier {
	protected java.util.List<TypedEntity> _property;

	public ClassifierZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<TypedEntity> getProperty() {
		if (_property == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::Core::Classifier", "property");
			_property = new java.util.ArrayList<TypedEntity>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					TypedEntity nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									TypedEntity.class);
					_property.add(nextWrapper);
				}
			}
		}
		return _property;
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
