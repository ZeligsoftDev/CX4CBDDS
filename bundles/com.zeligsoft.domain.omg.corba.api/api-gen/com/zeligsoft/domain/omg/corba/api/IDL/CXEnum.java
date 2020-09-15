package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXEnum extends CXNamedElement, CXType, Contained, CXModuleContained, CXClassifierContained {
	org.eclipse.uml2.uml.Enumeration asEnumeration();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXEnum
	 */
	static final TypeSelectPredicate<CXEnum> type = new TypeSelectPredicate<CXEnum>("CXDomain::IDL::CXEnum", //$NON-NLS-1$
			CXEnum.class);
}
