package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainStructuralFeature extends DomainNamedElement,
		DomainMultiplicityElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainStructuralFeature
	 */
	static final TypeSelectPredicate<DomainStructuralFeature> type = new TypeSelectPredicate<DomainStructuralFeature>(
			"ZDL::Constructs::DomainStructuralFeature", //$NON-NLS-1$
			DomainStructuralFeature.class);
}
