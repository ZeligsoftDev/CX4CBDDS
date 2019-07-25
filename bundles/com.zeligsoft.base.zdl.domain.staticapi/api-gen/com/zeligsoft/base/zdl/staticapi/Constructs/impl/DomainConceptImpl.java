package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainConcept;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainConstraint;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainConceptImpl extends DomainClassifierImpl implements
		DomainConcept {
	protected java.util.List<DomainConstraint> _constraint;

	public DomainConceptImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getIconURI() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainConcept", "iconURI");
		return (String) rawValue;
	}

	@Override
	public void setIconURI(String val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainConcept", "iconURI",
				val);
	}

	@Override
	public java.util.List<DomainConstraint> getConstraint() {
		if (_constraint == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZDL::Constructs::DomainConcept",
							"constraint");
			_constraint = new java.util.ArrayList<DomainConstraint>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainConstraint nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DomainConstraint.class);
					_constraint.add(nextWrapper);
				}
			}
		}
		return _constraint;
	}

	@Override
	public void addConstraint(DomainConstraint val) {
		// make sure the constraint list is created
		getConstraint();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZDL::Constructs::DomainConcept", "constraint");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_constraint != null) {
			_constraint.add(val);
		}
	}

	@Override
	public <T extends DomainConstraint> T addConstraint(Class<T> typeToCreate,
			String concept) {
		// make sure the constraint list is created
		getConstraint();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZDL::Constructs::DomainConcept", "constraint",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				(org.eclipse.emf.ecore.EObject) newConcept, typeToCreate);
		if (_constraint != null) {
			_constraint.add(element);
		}
		return element;
	}

	@Override
	public DomainConstraint addConstraint() {
		// make sure the constraint list is created
		getConstraint();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZDL::Constructs::DomainConcept", "constraint",
				"ZDL::Validation::DomainConstraint");
		DomainConstraint element = ZDLFactoryRegistry.INSTANCE.create(
				(org.eclipse.emf.ecore.EObject) newConcept,
				DomainConstraint.class);
		if (_constraint != null) {
			_constraint.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
