package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface CCMPart extends Part, NamedElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CCMPart
	 */
	static final TypeSelectPredicate<CCMPart> type = new TypeSelectPredicate<CCMPart>(
			"CCM::CCM_Implementation::CCMPart", //$NON-NLS-1$
			CCMPart.class);
}
