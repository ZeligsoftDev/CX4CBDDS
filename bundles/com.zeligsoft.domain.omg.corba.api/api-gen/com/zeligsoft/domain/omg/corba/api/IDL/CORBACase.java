package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBACase extends CORBAUnionField, CORBANamedElement {
	java.util.List<String> getLabel();

	void addLabel(String val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBACase
	 */
	static final TypeSelectPredicate<CORBACase> type = new TypeSelectPredicate<CORBACase>(
			"CORBADomain::IDL::CORBACase", //$NON-NLS-1$
			CORBACase.class);
}
