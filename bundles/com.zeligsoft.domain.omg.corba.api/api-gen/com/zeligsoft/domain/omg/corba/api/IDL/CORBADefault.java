package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBADefault extends CORBAUnionField {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBADefault
	 */
	static final TypeSelectPredicate<CORBADefault> type = new TypeSelectPredicate<CORBADefault>(
			"CORBADomain::IDL::CORBADefault", //$NON-NLS-1$
			CORBADefault.class);
}
