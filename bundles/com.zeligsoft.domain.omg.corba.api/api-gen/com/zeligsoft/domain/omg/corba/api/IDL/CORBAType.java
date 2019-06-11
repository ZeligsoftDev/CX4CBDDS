package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAType extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAType
	 */
	static final TypeSelectPredicate<CORBAType> type = new TypeSelectPredicate<CORBAType>(
			"CORBADomain::IDL::CORBAType", //$NON-NLS-1$
			CORBAType.class);
}
