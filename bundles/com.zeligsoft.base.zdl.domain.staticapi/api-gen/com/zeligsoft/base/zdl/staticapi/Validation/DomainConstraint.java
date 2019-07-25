package com.zeligsoft.base.zdl.staticapi.Validation;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainConstraint extends ZObject {
	EvaluationModeKind getEvaluationMode();

	void setEvaluationMode(EvaluationModeKind val);

	SeverityKind getSeverity();

	void setSeverity(SeverityKind val);

	String getMessage();

	void setMessage(String val);

	String getId();

	void setId(String val);

	ConstraintKind getKind();

	void setKind(ConstraintKind val);

	Integer getStatusCode();

	void setStatusCode(Integer val);

	java.util.List<DomainConstraint> getRedefinedConstraint();

	void addRedefinedConstraint(DomainConstraint val);

	org.eclipse.uml2.uml.Constraint asConstraint();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainConstraint
	 */
	static final TypeSelectPredicate<DomainConstraint> type = new TypeSelectPredicate<DomainConstraint>(
			"ZDL::Validation::DomainConstraint", //$NON-NLS-1$
			DomainConstraint.class);
}
