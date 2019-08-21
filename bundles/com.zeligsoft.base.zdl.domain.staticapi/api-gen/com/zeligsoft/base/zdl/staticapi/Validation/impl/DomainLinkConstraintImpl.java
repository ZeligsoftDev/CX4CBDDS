package com.zeligsoft.base.zdl.staticapi.Validation.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainConcept;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainNamedElement;
import com.zeligsoft.base.zdl.staticapi.Constructs.impl.DomainNamedElementImpl;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainLinkConstraint;
import com.zeligsoft.base.zdl.staticapi.Validation.LinkConstraintKind;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainLinkConstraintImpl extends DomainNamedElementImpl implements
		DomainLinkConstraint {
	protected DomainNamedElement _context;
	protected DomainConcept _target;
	protected DomainConcept _source;
	protected LinkConstraintKind _kind;
	protected java.util.List<DomainLinkConstraint> _redefinedConstraint;

	public DomainLinkConstraintImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DomainNamedElement getContext() {
		if (_context == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZDL::Validation::DomainLinkConstraint", "context");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_context = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DomainNamedElement.class);
			}
		}
		return _context;
	}

	@Override
	public void setContext(DomainNamedElement val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainLinkConstraint",
				"context", val.eObject());
	}

	@Override
	public DomainConcept getTarget() {
		if (_target == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZDL::Validation::DomainLinkConstraint", "target");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_target = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DomainConcept.class);
			}
		}
		return _target;
	}

	@Override
	public void setTarget(DomainConcept val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainLinkConstraint",
				"target", val.eObject());
	}

	@Override
	public DomainConcept getSource() {
		if (_source == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZDL::Validation::DomainLinkConstraint", "source");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_source = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						DomainConcept.class);
			}
		}
		return _source;
	}

	@Override
	public void setSource(DomainConcept val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainLinkConstraint",
				"source", val.eObject());
	}

	@Override
	public LinkConstraintKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainLinkConstraint", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = LinkConstraintKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(LinkConstraintKind val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainLinkConstraint",
				"kind", val.eObject(element));
	}

	@Override
	public java.util.List<DomainLinkConstraint> getRedefinedConstraint() {
		if (_redefinedConstraint == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZDL::Validation::DomainLinkConstraint",
							"redefinedConstraint");
			_redefinedConstraint = new java.util.ArrayList<DomainLinkConstraint>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainLinkConstraint nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DomainLinkConstraint.class);
					_redefinedConstraint.add(nextWrapper);
				}
			}
		}
		return _redefinedConstraint;
	}

	@Override
	public void addRedefinedConstraint(DomainLinkConstraint val) {
		// make sure the redefinedConstraint list is created
		getRedefinedConstraint();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZDL::Validation::DomainLinkConstraint", "redefinedConstraint");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_redefinedConstraint != null) {
			_redefinedConstraint.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Constraint asConstraint() {
		return (org.eclipse.uml2.uml.Constraint) eObject();
	}
}
