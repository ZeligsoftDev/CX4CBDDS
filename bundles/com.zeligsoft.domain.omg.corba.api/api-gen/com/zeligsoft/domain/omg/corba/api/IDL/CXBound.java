package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXBound extends ZObject {
	String getValue();

	void setValue(String val);

	CXConstant getConstant();

	void setConstant(CXConstant val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXBound
	 */
	static final TypeSelectPredicate<CXBound> type = new TypeSelectPredicate<CXBound>("CXDomain::IDL::CXBound", //$NON-NLS-1$
			CXBound.class);
}
