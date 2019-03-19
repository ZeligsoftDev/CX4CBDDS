package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Part;

public interface FragmentPart extends Part {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of FragmentPart
	 */
	static final TypeSelectPredicate<FragmentPart> type = new TypeSelectPredicate<FragmentPart>(
			"IDL3Plus::Connectors::FragmentPart", //$NON-NLS-1$
			FragmentPart.class);
}
