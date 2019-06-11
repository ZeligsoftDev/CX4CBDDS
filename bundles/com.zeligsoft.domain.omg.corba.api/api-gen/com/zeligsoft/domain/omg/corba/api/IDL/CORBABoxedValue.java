package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBABoxedValue extends CORBAWrapper {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBABoxedValue
	 */
	static final TypeSelectPredicate<CORBABoxedValue> type = new TypeSelectPredicate<CORBABoxedValue>(
			"CORBADomain::IDL::CORBABoxedValue", //$NON-NLS-1$
			CORBABoxedValue.class);
}
