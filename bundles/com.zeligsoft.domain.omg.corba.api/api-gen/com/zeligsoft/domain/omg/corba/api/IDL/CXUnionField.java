package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXUnionField extends CXNamedElement, CXTyped {
	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXUnionField
	 */
	static final TypeSelectPredicate<CXUnionField> type = new TypeSelectPredicate<CXUnionField>(
			"CXDomain::IDL::CXUnionField", //$NON-NLS-1$
			CXUnionField.class);
}
