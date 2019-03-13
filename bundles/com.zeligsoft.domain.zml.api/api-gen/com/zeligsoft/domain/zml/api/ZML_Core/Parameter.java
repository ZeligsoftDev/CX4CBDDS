package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Parameter extends TypedElement {
	org.eclipse.uml2.uml.Parameter asParameter();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Parameter
	 */
	static final TypeSelectPredicate<Parameter> type = new TypeSelectPredicate<Parameter>(
			"ZMLMM::ZML_Core::Parameter", //$NON-NLS-1$
			Parameter.class);
}
