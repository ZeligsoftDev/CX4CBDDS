package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainModelLibraryReference extends DomainElement {
	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainModelLibraryReference
	 */
	static final TypeSelectPredicate<DomainModelLibraryReference> type = new TypeSelectPredicate<DomainModelLibraryReference>(
			"ZDL::Constructs::DomainModelLibraryReference", //$NON-NLS-1$
			DomainModelLibraryReference.class);
}
