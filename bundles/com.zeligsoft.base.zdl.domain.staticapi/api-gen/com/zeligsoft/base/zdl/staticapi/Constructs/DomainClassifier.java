package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainClassifier extends DomainNamedElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainClassifier
	 */
	static final TypeSelectPredicate<DomainClassifier> type = new TypeSelectPredicate<DomainClassifier>(
			"ZDL::Constructs::DomainClassifier", //$NON-NLS-1$
			DomainClassifier.class);
}
