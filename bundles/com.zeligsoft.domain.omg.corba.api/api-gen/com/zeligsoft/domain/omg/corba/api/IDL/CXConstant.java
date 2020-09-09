package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXConstant extends CXNamedElement, CXTyped {
	String getDefault();

	void setDefault(String val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXConstant
	 */
	static final TypeSelectPredicate<CXConstant> type = new TypeSelectPredicate<CXConstant>("CXDomain::IDL::CXConstant", //$NON-NLS-1$
			CXConstant.class);
}
