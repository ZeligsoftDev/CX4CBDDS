package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

public interface FragmentImplementation extends StructuralRealization {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of FragmentImplementation
	 */
	static final TypeSelectPredicate<FragmentImplementation> type = new TypeSelectPredicate<FragmentImplementation>(
			"IDL3Plus::Connectors::FragmentImplementation", //$NON-NLS-1$
			FragmentImplementation.class);
}
