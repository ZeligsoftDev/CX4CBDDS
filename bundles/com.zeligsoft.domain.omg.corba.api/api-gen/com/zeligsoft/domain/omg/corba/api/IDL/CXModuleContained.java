package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXModuleContained extends ZObject {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXModuleContained
	 */
	static final TypeSelectPredicate<CXModuleContained> type = new TypeSelectPredicate<CXModuleContained>(
			"CXDomain::IDL::CXModuleContained", //$NON-NLS-1$
			CXModuleContained.class);
}
