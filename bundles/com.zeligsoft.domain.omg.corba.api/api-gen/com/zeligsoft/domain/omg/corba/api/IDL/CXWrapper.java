package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXWrapper extends CXNamedElement {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXWrapper
	 */
	static final TypeSelectPredicate<CXWrapper> type = new TypeSelectPredicate<CXWrapper>("CXDomain::IDL::CXWrapper", //$NON-NLS-1$
			CXWrapper.class);
}
