package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXDefault extends CXUnionField {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXDefault
	 */
	static final TypeSelectPredicate<CXDefault> type = new TypeSelectPredicate<CXDefault>("CXDomain::IDL::CXDefault", //$NON-NLS-1$
			CXDefault.class);
}
