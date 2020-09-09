package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXValueFactory extends ZObject {
	org.eclipse.uml2.uml.Operation asOperation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXValueFactory
	 */
	static final TypeSelectPredicate<CXValueFactory> type = new TypeSelectPredicate<CXValueFactory>(
			"CXDomain::IDL::CXValueFactory", //$NON-NLS-1$
			CXValueFactory.class);
}
