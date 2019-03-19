package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAStruct extends CORBAConstructed, CORBAType, Contained,
		CORBAModuleContained, CORBAClassifierContained {
	java.util.List<CORBAField> getMembers();

	void addMembers(CORBAField val);

	<T extends CORBAField> T addMembers(Class<T> typeToCreate, String concept);

	CORBAField addMembers();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAStruct
	 */
	static final TypeSelectPredicate<CORBAStruct> type = new TypeSelectPredicate<CORBAStruct>(
			"CORBADomain::IDL::CORBAStruct", //$NON-NLS-1$
			CORBAStruct.class);
}
