package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAEnum extends CORBANamedElement, CORBAType, Contained,
		CORBAModuleContained, CORBAClassifierContained {
	org.eclipse.uml2.uml.Enumeration asEnumeration();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAEnum
	 */
	static final TypeSelectPredicate<CORBAEnum> type = new TypeSelectPredicate<CORBAEnum>(
			"CORBADomain::IDL::CORBAEnum", //$NON-NLS-1$
			CORBAEnum.class);
}
