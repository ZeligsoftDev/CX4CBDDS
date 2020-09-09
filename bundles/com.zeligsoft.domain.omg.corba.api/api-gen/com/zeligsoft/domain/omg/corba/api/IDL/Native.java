package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Native extends CXModuleContained, CXType, CXNamedElement, CXClassifierContained {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Native
	 */
	static final TypeSelectPredicate<Native> type = new TypeSelectPredicate<Native>("CXDomain::IDL::Native", //$NON-NLS-1$
			Native.class);
}
