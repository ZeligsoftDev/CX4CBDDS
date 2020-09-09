package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXPrimitive extends CXNamedElement, CXType, Contained {
	CXPrimitiveKind getType();

	void setType(CXPrimitiveKind val);

	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXPrimitive
	 */
	static final TypeSelectPredicate<CXPrimitive> type = new TypeSelectPredicate<CXPrimitive>(
			"CXDomain::IDL::CXPrimitive", //$NON-NLS-1$
			CXPrimitive.class);
}
