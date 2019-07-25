package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainBlockReference extends DomainElement {
	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainBlockReference
	 */
	static final TypeSelectPredicate<DomainBlockReference> type = new TypeSelectPredicate<DomainBlockReference>(
			"ZDL::Constructs::DomainBlockReference", //$NON-NLS-1$
			DomainBlockReference.class);
}
