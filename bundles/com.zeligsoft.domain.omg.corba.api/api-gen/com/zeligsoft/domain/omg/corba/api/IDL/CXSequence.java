package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXSequence extends CXTemplate, CXType, Contained, CXModuleContained, CXClassifierContained {
	String getBound();

	void setBound(String val);

	CXBound getBounds();

	void setBounds(CXBound val);

	<T extends CXBound> T createBounds(Class<T> typeToCreate, String concept);

	CXBound createBounds();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXSequence
	 */
	static final TypeSelectPredicate<CXSequence> type = new TypeSelectPredicate<CXSequence>("CXDomain::IDL::CXSequence", //$NON-NLS-1$
			CXSequence.class);
}
