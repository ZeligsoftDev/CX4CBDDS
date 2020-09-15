package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXType extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXType
	 */
	static final TypeSelectPredicate<CXType> type = new TypeSelectPredicate<CXType>("CXDomain::IDL::CXType", //$NON-NLS-1$
			CXType.class);
}
