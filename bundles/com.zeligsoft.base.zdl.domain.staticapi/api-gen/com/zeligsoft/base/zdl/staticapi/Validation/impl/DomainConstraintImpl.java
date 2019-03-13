package com.zeligsoft.base.zdl.staticapi.Validation.impl;

import com.zeligsoft.base.zdl.staticapi.Validation.ConstraintKind;
import com.zeligsoft.base.zdl.staticapi.Validation.DomainConstraint;
import com.zeligsoft.base.zdl.staticapi.Validation.EvaluationModeKind;
import com.zeligsoft.base.zdl.staticapi.Validation.SeverityKind;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainConstraintImpl extends ZObjectImpl implements
		DomainConstraint {
	protected SeverityKind _severity;
	protected ConstraintKind _kind;
	protected java.util.List<DomainConstraint> _redefinedConstraint;
	protected EvaluationModeKind _evaluationMode;

	public DomainConstraintImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getMessage() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainConstraint", "message");
		return (String) rawValue;
	}

	@Override
	public void setMessage(String val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainConstraint",
				"message", val);
	}

	@Override
	public String getId() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainConstraint", "id");
		return (String) rawValue;
	}

	@Override
	public void setId(String val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainConstraint", "id",
				val);
	}

	@Override
	public Integer getStatusCode() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainConstraint", "statusCode");
		return (Integer) rawValue;
	}

	@Override
	public void setStatusCode(Integer val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainConstraint",
				"statusCode", val);
	}

	@Override
	public SeverityKind getSeverity() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainConstraint", "severity");

		if (_severity == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_severity = SeverityKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _severity;
	}

	@Override
	public void setSeverity(SeverityKind val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainConstraint",
				"severity", val.eObject(element));
	}

	@Override
	public ConstraintKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainConstraint", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = ConstraintKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(ConstraintKind val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainConstraint", "kind",
				val.eObject(element));
	}

	@Override
	public java.util.List<DomainConstraint> getRedefinedConstraint() {
		if (_redefinedConstraint == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZDL::Validation::DomainConstraint",
							"redefinedConstraint");
			_redefinedConstraint = new java.util.ArrayList<DomainConstraint>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					DomainConstraint nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									DomainConstraint.class);
					_redefinedConstraint.add(nextWrapper);
				}
			}
		}
		return _redefinedConstraint;
	}

	@Override
	public void addRedefinedConstraint(DomainConstraint val) {
		// make sure the redefinedConstraint list is created
		getRedefinedConstraint();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZDL::Validation::DomainConstraint", "redefinedConstraint");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_redefinedConstraint != null) {
			_redefinedConstraint.add(val);
		}
	}

	@Override
	public EvaluationModeKind getEvaluationMode() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Validation::DomainConstraint",
				"evaluationMode");

		if (_evaluationMode == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_evaluationMode = EvaluationModeKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _evaluationMode;
	}

	@Override
	public void setEvaluationMode(EvaluationModeKind val) {
		ZDLUtil.setValue(element, "ZDL::Validation::DomainConstraint",
				"evaluationMode", val.eObject(element));
	}

	@Override
	public org.eclipse.uml2.uml.Constraint asConstraint() {
		return (org.eclipse.uml2.uml.Constraint) eObject();
	}
}
