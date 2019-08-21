package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainModelLibrary extends DomainNamedElement {
	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainModelLibrary
	 */
	static final TypeSelectPredicate<DomainModelLibrary> type = new TypeSelectPredicate<DomainModelLibrary>(
			"ZDL::Constructs::DomainModelLibrary", //$NON-NLS-1$
			DomainModelLibrary.class);
}
