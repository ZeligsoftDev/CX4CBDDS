package com.zeligsoft.domain.omg.dds.api.Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Specification extends Classifier {
	@Override
	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Specification
	 */
	static final TypeSelectPredicate<Specification> type = new TypeSelectPredicate<Specification>(
			"DDS::Core::Specification", //$NON-NLS-1$
			Specification.class);
}
