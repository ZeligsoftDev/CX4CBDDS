package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXUnion extends CXConstructed, CXType, Contained, CXModuleContained, CXClassifierContained {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXUnion
	 */
	static final TypeSelectPredicate<CXUnion> type = new TypeSelectPredicate<CXUnion>("CXDomain::IDL::CXUnion", //$NON-NLS-1$
			CXUnion.class);
}
