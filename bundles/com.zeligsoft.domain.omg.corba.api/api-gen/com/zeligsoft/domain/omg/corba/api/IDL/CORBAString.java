package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAString extends CORBABounded, CORBAType,
		CORBAClassifierContained {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAString
	 */
	static final TypeSelectPredicate<CORBAString> type = new TypeSelectPredicate<CORBAString>(
			"CORBADomain::IDL::CORBAString", //$NON-NLS-1$
			CORBAString.class);
}
