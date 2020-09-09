package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXConstants extends CXNamedElement, CXModuleContained, CXClassifierContained {
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXConstants
	 */
	static final TypeSelectPredicate<CXConstants> type = new TypeSelectPredicate<CXConstants>(
			"CXDomain::IDL::CXConstants", //$NON-NLS-1$
			CXConstants.class);
}
