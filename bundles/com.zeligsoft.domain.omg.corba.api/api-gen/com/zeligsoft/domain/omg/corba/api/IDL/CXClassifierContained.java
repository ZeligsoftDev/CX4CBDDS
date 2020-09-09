package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXClassifierContained extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXClassifierContained
	 */
	static final TypeSelectPredicate<CXClassifierContained> type = new TypeSelectPredicate<CXClassifierContained>(
			"CXDomain::IDL::CXClassifierContained", //$NON-NLS-1$
			CXClassifierContained.class);
}
