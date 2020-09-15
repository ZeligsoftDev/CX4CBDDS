package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXBoxedValue extends CXWrapper {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXBoxedValue
	 */
	static final TypeSelectPredicate<CXBoxedValue> type = new TypeSelectPredicate<CXBoxedValue>(
			"CXDomain::IDL::CXBoxedValue", //$NON-NLS-1$
			CXBoxedValue.class);
}
