package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainModel extends DomainNamedElement {
	org.eclipse.uml2.uml.Model asModel();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainModel
	 */
	static final TypeSelectPredicate<DomainModel> type = new TypeSelectPredicate<DomainModel>(
			"ZDL::Constructs::DomainModel", //$NON-NLS-1$
			DomainModel.class);
}
