package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAUnionField extends CORBANamedElement, CORBATyped {
	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAUnionField
	 */
	static final TypeSelectPredicate<CORBAUnionField> type = new TypeSelectPredicate<CORBAUnionField>(
			"CORBADomain::IDL::CORBAUnionField", //$NON-NLS-1$
			CORBAUnionField.class);
}
