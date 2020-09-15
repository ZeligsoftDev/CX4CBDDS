package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXStruct extends CXConstructed, CXType, Contained, CXModuleContained, CXClassifierContained {
	java.util.List<CXField> getMembers();

	void addMembers(CXField val);

	<T extends CXField> T addMembers(Class<T> typeToCreate, String concept);

	CXField addMembers();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXStruct
	 */
	static final TypeSelectPredicate<CXStruct> type = new TypeSelectPredicate<CXStruct>("CXDomain::IDL::CXStruct", //$NON-NLS-1$
			CXStruct.class);
}
