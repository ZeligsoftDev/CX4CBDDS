package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAParameter extends CORBATyped, CORBANamedElement {
	org.eclipse.uml2.uml.ParameterDirectionKind getDirection();

	void setDirection(org.eclipse.uml2.uml.ParameterDirectionKind val);

	org.eclipse.uml2.uml.Parameter asParameter();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAParameter
	 */
	static final TypeSelectPredicate<CORBAParameter> type = new TypeSelectPredicate<CORBAParameter>(
			"CORBADomain::IDL::CORBAParameter", //$NON-NLS-1$
			CORBAParameter.class);
}
