package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainBlockRelation extends DomainElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainBlockRelation
	 */
	static final TypeSelectPredicate<DomainBlockRelation> type = new TypeSelectPredicate<DomainBlockRelation>(
			"ZDL::Constructs::DomainBlockRelation", //$NON-NLS-1$
			DomainBlockRelation.class);
}
