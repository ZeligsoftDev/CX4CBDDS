package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainAttribute extends DomainStructuralFeature {
	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainAttribute
	 */
	static final TypeSelectPredicate<DomainAttribute> type = new TypeSelectPredicate<DomainAttribute>(
			"ZDL::Constructs::DomainAttribute", //$NON-NLS-1$
			DomainAttribute.class);
}
