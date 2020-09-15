package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.Home;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface HomeInstance extends Part, NamedElement {
	Home getDefinitionOverride();

	void setDefinitionOverride(Home val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HomeInstance
	 */
	static final TypeSelectPredicate<HomeInstance> type = new TypeSelectPredicate<HomeInstance>(
			"CCM::CCM_Implementation::HomeInstance", //$NON-NLS-1$
			HomeInstance.class);
}
