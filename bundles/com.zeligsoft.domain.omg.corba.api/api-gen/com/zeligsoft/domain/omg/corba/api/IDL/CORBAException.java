package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAException extends CORBAConstructed, Contained,
		CORBAModuleContained, CORBAClassifierContained, CORBAType {
	java.util.List<CORBAField> getMembers();

	void addMembers(CORBAField val);

	<T extends CORBAField> T addMembers(Class<T> typeToCreate, String concept);

	CORBAField addMembers();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAException
	 */
	static final TypeSelectPredicate<CORBAException> type = new TypeSelectPredicate<CORBAException>(
			"CORBADomain::IDL::CORBAException", //$NON-NLS-1$
			CORBAException.class);
}
