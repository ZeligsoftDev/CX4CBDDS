package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBATemplate extends CORBANamedElement {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBATemplate
	 */
	static final TypeSelectPredicate<CORBATemplate> type = new TypeSelectPredicate<CORBATemplate>(
			"CORBADomain::IDL::CORBATemplate", //$NON-NLS-1$
			CORBATemplate.class);
}
