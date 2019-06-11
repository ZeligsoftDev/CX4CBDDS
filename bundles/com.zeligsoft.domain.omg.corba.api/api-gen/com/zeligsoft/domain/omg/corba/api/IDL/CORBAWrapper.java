package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAWrapper extends CORBANamedElement {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAWrapper
	 */
	static final TypeSelectPredicate<CORBAWrapper> type = new TypeSelectPredicate<CORBAWrapper>(
			"CORBADomain::IDL::CORBAWrapper", //$NON-NLS-1$
			CORBAWrapper.class);
}
