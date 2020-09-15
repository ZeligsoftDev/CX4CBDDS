package com.zeligsoft.domain.omg.dds.api.Core.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.Core.Classifier;
import com.zeligsoft.domain.omg.dds.api.Core.impl.NamedEntityZImpl;

import com.zeligsoft.domain.omg.dds.api.Core.TypedEntity;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class ClassifierZImpl extends NamedEntityZImpl implements Classifier {
	protected java.util.List<TypedEntity> _property;

	public ClassifierZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<TypedEntity> getProperty() {
		if (_property == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::Core::Classifier",
					"property");
			_property = new java.util.ArrayList<TypedEntity>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					TypedEntity nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							TypedEntity.class);
					_property.add(nextWrapper);
				}
			}
		}
		return _property;
	}

	@Override
	public void addProperty(TypedEntity val) {
		// make sure the property list is created
		getProperty();

		final Object rawValue = ZDLUtil.getValue(element, "DDS::Core::Classifier", "property");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_property != null) {
			_property.add(val);
		}
	}

	@Override
	public <T extends TypedEntity> T addProperty(Class<T> typeToCreate, String concept) {
		// make sure the property list is created
		getProperty();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "DDS::Core::Classifier",
				"property", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_property != null) {
			_property.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
