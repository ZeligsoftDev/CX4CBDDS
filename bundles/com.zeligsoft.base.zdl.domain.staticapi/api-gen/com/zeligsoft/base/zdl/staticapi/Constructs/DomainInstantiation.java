package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainInstantiation extends DomainElement {
	org.eclipse.uml2.uml.Abstraction asAbstraction();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainInstantiation
	 */
	static final TypeSelectPredicate<DomainInstantiation> type = new TypeSelectPredicate<DomainInstantiation>(
			"ZDL::Constructs::DomainInstantiation", //$NON-NLS-1$
			DomainInstantiation.class);
}
