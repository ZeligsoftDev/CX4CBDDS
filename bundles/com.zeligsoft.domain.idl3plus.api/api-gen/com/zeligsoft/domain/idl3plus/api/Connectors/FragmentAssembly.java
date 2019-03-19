package com.zeligsoft.domain.idl3plus.api.Connectors;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

public interface FragmentAssembly extends StructuralRealization {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of FragmentAssembly
	 */
	static final TypeSelectPredicate<FragmentAssembly> type = new TypeSelectPredicate<FragmentAssembly>(
			"IDL3Plus::Connectors::FragmentAssembly", //$NON-NLS-1$
			FragmentAssembly.class);
}
