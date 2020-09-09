package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

public interface HomeImplementation extends StructuralRealization, ManagesImplEnd {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HomeImplementation
	 */
	static final TypeSelectPredicate<HomeImplementation> type = new TypeSelectPredicate<HomeImplementation>(
			"CCM::CCM_Implementation::HomeImplementation", //$NON-NLS-1$
			HomeImplementation.class);
}
