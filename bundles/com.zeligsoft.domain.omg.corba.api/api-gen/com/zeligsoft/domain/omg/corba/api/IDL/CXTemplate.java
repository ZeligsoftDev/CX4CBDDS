package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXTemplate extends CXNamedElement {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXTemplate
	 */
	static final TypeSelectPredicate<CXTemplate> type = new TypeSelectPredicate<CXTemplate>("CXDomain::IDL::CXTemplate", //$NON-NLS-1$
			CXTemplate.class);
}
