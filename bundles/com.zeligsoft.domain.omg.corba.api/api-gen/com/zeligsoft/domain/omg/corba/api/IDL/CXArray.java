package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXArray extends CXTemplate, CXType, Contained, CXModuleContained, CXClassifierContained {
	String getIndex();

	void setIndex(String val);

	java.util.List<CXBound> getBounds();

	void addBounds(CXBound val);

	<T extends CXBound> T addBounds(Class<T> typeToCreate, String concept);

	CXBound addBounds();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXArray
	 */
	static final TypeSelectPredicate<CXArray> type = new TypeSelectPredicate<CXArray>("CXDomain::IDL::CXArray", //$NON-NLS-1$
			CXArray.class);
}
