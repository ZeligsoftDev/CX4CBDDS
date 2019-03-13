package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Type extends NamedElement {
	org.eclipse.uml2.uml.Classifier asClassifier();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Type
	 */
	static final TypeSelectPredicate<Type> type = new TypeSelectPredicate<Type>(
			"ZMLMM::ZML_Core::Type", //$NON-NLS-1$
			Type.class);
}
