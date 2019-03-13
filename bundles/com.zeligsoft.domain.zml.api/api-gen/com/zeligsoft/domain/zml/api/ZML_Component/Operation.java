package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface Operation extends NamedElement {
	org.eclipse.uml2.uml.Operation asOperation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Operation
	 */
	static final TypeSelectPredicate<Operation> type = new TypeSelectPredicate<Operation>(
			"ZMLMM::ZML_Component::Operation", //$NON-NLS-1$
			Operation.class);
}
