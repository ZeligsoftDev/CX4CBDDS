package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainNamedElement extends DomainElement {
	String getName();

	void setName(String val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainNamedElement
	 */
	static final TypeSelectPredicate<DomainNamedElement> type = new TypeSelectPredicate<DomainNamedElement>(
			"ZDL::Constructs::DomainNamedElement", //$NON-NLS-1$
			DomainNamedElement.class);
}
