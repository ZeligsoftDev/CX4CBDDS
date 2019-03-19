package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Resource extends RequirementSatisfier {
	@Override
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Resource
	 */
	static final TypeSelectPredicate<Resource> type = new TypeSelectPredicate<Resource>(
			"CCM::CCM_Target::Resource", //$NON-NLS-1$
			Resource.class);
}
