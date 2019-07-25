package com.zeligsoft.base.zdl.staticapi.Validation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ExternalDomainConstraint extends DomainConstraint {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of ExternalDomainConstraint
	 */
	static final TypeSelectPredicate<ExternalDomainConstraint> type = new TypeSelectPredicate<ExternalDomainConstraint>(
			"ZDL::Validation::ExternalDomainConstraint", //$NON-NLS-1$
			ExternalDomainConstraint.class);
}
