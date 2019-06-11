package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAAnonymousSequence extends ZObject {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAAnonymousSequence
	 */
	static final TypeSelectPredicate<CORBAAnonymousSequence> type = new TypeSelectPredicate<CORBAAnonymousSequence>(
			"CORBADomain::IDL::CORBAAnonymousSequence", //$NON-NLS-1$
			CORBAAnonymousSequence.class);
}
