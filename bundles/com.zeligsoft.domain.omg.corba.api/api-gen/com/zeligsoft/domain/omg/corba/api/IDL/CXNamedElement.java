package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface CXNamedElement extends NamedElement {
	@Override
	org.eclipse.uml2.uml.NamedElement asNamedElement();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXNamedElement
	 */
	static final TypeSelectPredicate<CXNamedElement> type = new TypeSelectPredicate<CXNamedElement>(
			"CXDomain::IDL::CXNamedElement", //$NON-NLS-1$
			CXNamedElement.class);
}
