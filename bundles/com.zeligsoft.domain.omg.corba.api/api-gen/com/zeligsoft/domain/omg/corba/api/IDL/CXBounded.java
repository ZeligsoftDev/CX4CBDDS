package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXBounded extends CXNamedElement, CXModuleContained {
	String getBound();

	void setBound(String val);

	CXBound getBounds();

	void setBounds(CXBound val);

	<T extends CXBound> T createBounds(Class<T> typeToCreate, String concept);

	CXBound createBounds();

	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXBounded
	 */
	static final TypeSelectPredicate<CXBounded> type = new TypeSelectPredicate<CXBounded>("CXDomain::IDL::CXBounded", //$NON-NLS-1$
			CXBounded.class);
}
