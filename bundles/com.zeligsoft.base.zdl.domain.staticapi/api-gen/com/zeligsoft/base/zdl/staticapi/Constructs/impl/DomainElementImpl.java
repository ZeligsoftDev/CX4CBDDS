package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainElement;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class DomainElementImpl extends ZObjectImpl implements
		DomainElement {
	protected DomainElement _owner;
	protected java.util.List<DomainElement> _ownedElement;

	public DomainElementImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DomainElement getOwner() {
		if (_owner == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZDL::Constructs::DomainElement",
							"owner");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_owner = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DomainElement.class);
			}
		}
		return _owner;
	}

	@Override
	public void setOwner(DomainElement val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainElement", "owner",
				val.eObject());
	}

	@Override
	public java.util.List<DomainElement> getOwnedElement() {
		if (_ownedElement == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZDL::Constructs::DomainElement",
							"ownedElement");
			_ownedElement = new java.util.ArrayList<DomainElement>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainElement nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DomainElement.class);
					_ownedElement.add(nextWrapper);
				}
			}
		}
		return _ownedElement;
	}

	@Override
	public void addOwnedElement(DomainElement val) {
		// make sure the ownedElement list is created
		getOwnedElement();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZDL::Constructs::DomainElement", "ownedElement");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_ownedElement != null) {
			_ownedElement.add(val);
		}
	}

	@Override
	public <T extends DomainElement> T addOwnedElement(Class<T> typeToCreate,
			String concept) {
		// make sure the ownedElement list is created
		getOwnedElement();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZDL::Constructs::DomainElement", "ownedElement",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				(org.eclipse.emf.ecore.EObject) newConcept, typeToCreate);
		if (_ownedElement != null) {
			_ownedElement.add(element);
		}
		return element;
	}

}
