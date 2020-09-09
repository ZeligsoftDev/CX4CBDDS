package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXAnonymousSequence extends ZObject {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXAnonymousSequence
	 */
	static final TypeSelectPredicate<CXAnonymousSequence> type = new TypeSelectPredicate<CXAnonymousSequence>(
			"CXDomain::IDL::CXAnonymousSequence", //$NON-NLS-1$
			CXAnonymousSequence.class);
}
