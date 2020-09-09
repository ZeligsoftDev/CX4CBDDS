package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXString extends CXBounded, CXType, CXClassifierContained {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXString
	 */
	static final TypeSelectPredicate<CXString> type = new TypeSelectPredicate<CXString>("CXDomain::IDL::CXString", //$NON-NLS-1$
			CXString.class);
}
