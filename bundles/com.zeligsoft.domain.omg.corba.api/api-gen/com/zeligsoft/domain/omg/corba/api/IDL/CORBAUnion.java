package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAUnion extends CORBAConstructed, CORBAType, Contained,
		CORBAModuleContained, CORBAClassifierContained {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAUnion
	 */
	static final TypeSelectPredicate<CORBAUnion> type = new TypeSelectPredicate<CORBAUnion>(
			"CORBADomain::IDL::CORBAUnion", //$NON-NLS-1$
			CORBAUnion.class);
}
