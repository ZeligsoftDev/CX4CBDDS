package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXParameter extends CXTyped, CXNamedElement {
	org.eclipse.uml2.uml.ParameterDirectionKind getDirection();

	void setDirection(org.eclipse.uml2.uml.ParameterDirectionKind val);

	org.eclipse.uml2.uml.Parameter asParameter();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXParameter
	 */
	static final TypeSelectPredicate<CXParameter> type = new TypeSelectPredicate<CXParameter>(
			"CXDomain::IDL::CXParameter", //$NON-NLS-1$
			CXParameter.class);
}
