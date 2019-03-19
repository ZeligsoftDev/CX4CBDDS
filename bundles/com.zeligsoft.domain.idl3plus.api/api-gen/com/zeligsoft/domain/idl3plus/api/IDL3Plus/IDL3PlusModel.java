package com.zeligsoft.domain.idl3plus.api.IDL3Plus;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.ccm.api.CCM_Core.CCMModel;

public interface IDL3PlusModel extends CCMModel {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of IDL3PlusModel
	 */
	static final TypeSelectPredicate<IDL3PlusModel> type = new TypeSelectPredicate<IDL3PlusModel>(
			"IDL3Plus::IDL3Plus::IDL3PlusModel", //$NON-NLS-1$
			IDL3PlusModel.class);
}
