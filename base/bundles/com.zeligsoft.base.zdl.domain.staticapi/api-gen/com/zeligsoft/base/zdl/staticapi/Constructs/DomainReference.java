package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainReference extends DomainStructuralFeature {
	String getIconURI();

	void setIconURI(String val);

	org.eclipse.uml2.uml.Association asAssociation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainReference
	 */
	static final TypeSelectPredicate<DomainReference> type = new TypeSelectPredicate<DomainReference>(
			"ZDL::Constructs::DomainReference", //$NON-NLS-1$
			DomainReference.class);
}
