package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainPackage extends DomainNamedElement {
	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainPackage
	 */
	static final TypeSelectPredicate<DomainPackage> type = new TypeSelectPredicate<DomainPackage>(
			"ZDL::Constructs::DomainPackage", //$NON-NLS-1$
			DomainPackage.class);
}
