package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAConstructed extends CORBANamedElement {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAConstructed
	 */
	static final TypeSelectPredicate<CORBAConstructed> type = new TypeSelectPredicate<CORBAConstructed>(
			"CORBADomain::IDL::CORBAConstructed", //$NON-NLS-1$
			CORBAConstructed.class);
}
