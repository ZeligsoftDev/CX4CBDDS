package com.zeligsoft.base.zdl.staticapi.Validation;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainConcept;
import com.zeligsoft.base.zdl.staticapi.Constructs.DomainNamedElement;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainLinkConstraint extends DomainNamedElement {
	LinkConstraintKind getKind();

	void setKind(LinkConstraintKind val);

	java.util.List<DomainLinkConstraint> getRedefinedConstraint();

	void addRedefinedConstraint(DomainLinkConstraint val);

	DomainConcept getSource();

	void setSource(DomainConcept val);

	DomainConcept getTarget();

	void setTarget(DomainConcept val);

	DomainNamedElement getContext();

	void setContext(DomainNamedElement val);

	org.eclipse.uml2.uml.Constraint asConstraint();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainLinkConstraint
	 */
	static final TypeSelectPredicate<DomainLinkConstraint> type = new TypeSelectPredicate<DomainLinkConstraint>(
			"ZDL::Validation::DomainLinkConstraint", //$NON-NLS-1$
			DomainLinkConstraint.class);
}
