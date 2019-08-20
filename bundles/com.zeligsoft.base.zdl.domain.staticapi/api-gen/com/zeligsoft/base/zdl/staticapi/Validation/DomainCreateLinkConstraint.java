package com.zeligsoft.base.zdl.staticapi.Validation;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainConcept;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainCreateLinkConstraint extends DomainLinkConstraint {
	DomainConcept getCreatesConcept();

	void setCreatesConcept(DomainConcept val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainCreateLinkConstraint
	 */
	static final TypeSelectPredicate<DomainCreateLinkConstraint> type = new TypeSelectPredicate<DomainCreateLinkConstraint>(
			"ZDL::Validation::DomainCreateLinkConstraint", //$NON-NLS-1$
			DomainCreateLinkConstraint.class);
}
