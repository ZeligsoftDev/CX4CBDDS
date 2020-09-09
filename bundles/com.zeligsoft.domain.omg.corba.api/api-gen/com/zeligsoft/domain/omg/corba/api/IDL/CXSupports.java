package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXSupports extends ZObject {
	org.eclipse.uml2.uml.Generalization asGeneralization();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXSupports
	 */
	static final TypeSelectPredicate<CXSupports> type = new TypeSelectPredicate<CXSupports>("CXDomain::IDL::CXSupports", //$NON-NLS-1$
			CXSupports.class);
}
