package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXCase extends CXUnionField, CXNamedElement {
	java.util.List<String> getLabel();

	void addLabel(String val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXCase
	 */
	static final TypeSelectPredicate<CXCase> type = new TypeSelectPredicate<CXCase>("CXDomain::IDL::CXCase", //$NON-NLS-1$
			CXCase.class);
}
