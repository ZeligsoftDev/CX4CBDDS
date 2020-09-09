package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXTypeDef extends CXWrapper, CXType, CXNamedElement, CXModuleContained, CXClassifierContained {
	CXType getType();

	void setType(CXType val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXTypeDef
	 */
	static final TypeSelectPredicate<CXTypeDef> type = new TypeSelectPredicate<CXTypeDef>("CXDomain::IDL::CXTypeDef", //$NON-NLS-1$
			CXTypeDef.class);
}
