package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXTyped extends ZObject {
	CXType getIdlType();

	void setIdlType(CXType val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXTyped
	 */
	static final TypeSelectPredicate<CXTyped> type = new TypeSelectPredicate<CXTyped>("CXDomain::IDL::CXTyped", //$NON-NLS-1$
			CXTyped.class);
}
