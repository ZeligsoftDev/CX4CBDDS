package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXException extends CXConstructed, Contained, CXModuleContained, CXClassifierContained, CXType {
	java.util.List<CXField> getMembers();

	void addMembers(CXField val);

	<T extends CXField> T addMembers(Class<T> typeToCreate, String concept);

	CXField addMembers();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXException
	 */
	static final TypeSelectPredicate<CXException> type = new TypeSelectPredicate<CXException>(
			"CXDomain::IDL::CXException", //$NON-NLS-1$
			CXException.class);
}
