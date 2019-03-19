package com.zeligsoft.domain.omg.ccm.api.CCM_Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.Model;

public interface CCMModel extends Model, NamedElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of CCMModel
	 */
	static final TypeSelectPredicate<CCMModel> type = new TypeSelectPredicate<CCMModel>(
			"CCM::CCM_Core::CCMModel", //$NON-NLS-1$
			CCMModel.class);
}
