package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAArray extends CORBATemplate, CORBAType, Contained,
		CORBAModuleContained, CORBAClassifierContained {
	String getIndex();

	void setIndex(String val);

	java.util.List<CORBABound> getBounds();

	void addBounds(CORBABound val);

	<T extends CORBABound> T addBounds(Class<T> typeToCreate, String concept);

	CORBABound addBounds();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAArray
	 */
	static final TypeSelectPredicate<CORBAArray> type = new TypeSelectPredicate<CORBAArray>(
			"CORBADomain::IDL::CORBAArray", //$NON-NLS-1$
			CORBAArray.class);
}
