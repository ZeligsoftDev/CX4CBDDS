package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXAnonymousArray extends ZObject {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXAnonymousArray
	 */
	static final TypeSelectPredicate<CXAnonymousArray> type = new TypeSelectPredicate<CXAnonymousArray>(
			"CXDomain::IDL::CXAnonymousArray", //$NON-NLS-1$
			CXAnonymousArray.class);
}
