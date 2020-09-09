package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXWString extends CXBounded, CXType, CXClassifierContained {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXWString
	 */
	static final TypeSelectPredicate<CXWString> type = new TypeSelectPredicate<CXWString>("CXDomain::IDL::CXWString", //$NON-NLS-1$
			CXWString.class);
}
