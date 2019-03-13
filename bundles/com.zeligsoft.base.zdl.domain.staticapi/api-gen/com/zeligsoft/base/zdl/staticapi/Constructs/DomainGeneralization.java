package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainGeneralization extends DomainElement {
	org.eclipse.uml2.uml.Generalization asGeneralization();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainGeneralization
	 */
	static final TypeSelectPredicate<DomainGeneralization> type = new TypeSelectPredicate<DomainGeneralization>(
			"ZDL::Constructs::DomainGeneralization", //$NON-NLS-1$
			DomainGeneralization.class);
}
