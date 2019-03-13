package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainEnumLiteral extends DomainNamedElement {
	org.eclipse.uml2.uml.EnumerationLiteral asEnumerationLiteral();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainEnumLiteral
	 */
	static final TypeSelectPredicate<DomainEnumLiteral> type = new TypeSelectPredicate<DomainEnumLiteral>(
			"ZDL::Constructs::DomainEnumLiteral", //$NON-NLS-1$
			DomainEnumLiteral.class);
}
