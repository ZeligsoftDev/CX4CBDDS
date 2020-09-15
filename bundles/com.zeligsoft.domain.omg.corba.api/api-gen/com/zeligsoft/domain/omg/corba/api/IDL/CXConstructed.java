package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXConstructed extends CXNamedElement {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXConstructed
	 */
	static final TypeSelectPredicate<CXConstructed> type = new TypeSelectPredicate<CXConstructed>(
			"CXDomain::IDL::CXConstructed", //$NON-NLS-1$
			CXConstructed.class);
}
