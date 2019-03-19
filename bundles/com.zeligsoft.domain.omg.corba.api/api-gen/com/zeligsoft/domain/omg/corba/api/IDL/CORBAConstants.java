package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAConstants extends CORBANamedElement,
		CORBAModuleContained, CORBAClassifierContained {
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAConstants
	 */
	static final TypeSelectPredicate<CORBAConstants> type = new TypeSelectPredicate<CORBAConstants>(
			"CORBADomain::IDL::CORBAConstants", //$NON-NLS-1$
			CORBAConstants.class);
}
