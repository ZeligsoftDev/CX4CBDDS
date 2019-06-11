package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Model extends ZObject {
	org.eclipse.uml2.uml.Model asModel();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Model
	 */
	static final TypeSelectPredicate<Model> type = new TypeSelectPredicate<Model>(
			"ZMLMM::ZML_Core::Model", //$NON-NLS-1$
			Model.class);
}
