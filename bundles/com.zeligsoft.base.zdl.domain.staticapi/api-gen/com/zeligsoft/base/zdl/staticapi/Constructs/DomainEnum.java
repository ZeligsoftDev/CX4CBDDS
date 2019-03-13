package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainEnum extends DomainDataType {
	org.eclipse.uml2.uml.Enumeration asEnumeration();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainEnum
	 */
	static final TypeSelectPredicate<DomainEnum> type = new TypeSelectPredicate<DomainEnum>(
			"ZDL::Constructs::DomainEnum", //$NON-NLS-1$
			DomainEnum.class);
}
