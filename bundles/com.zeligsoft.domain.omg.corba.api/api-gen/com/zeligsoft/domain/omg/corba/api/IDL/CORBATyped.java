package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBATyped extends ZObject {
	CORBAType getIdlType();

	void setIdlType(CORBAType val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBATyped
	 */
	static final TypeSelectPredicate<CORBATyped> type = new TypeSelectPredicate<CORBATyped>(
			"CORBADomain::IDL::CORBATyped", //$NON-NLS-1$
			CORBATyped.class);
}
