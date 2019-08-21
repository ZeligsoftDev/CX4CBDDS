package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainSpecialization extends DomainNamedElement {
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainSpecialization
	 */
	static final TypeSelectPredicate<DomainSpecialization> type = new TypeSelectPredicate<DomainSpecialization>(
			"ZDL::Constructs::DomainSpecialization", //$NON-NLS-1$
			DomainSpecialization.class);
}
