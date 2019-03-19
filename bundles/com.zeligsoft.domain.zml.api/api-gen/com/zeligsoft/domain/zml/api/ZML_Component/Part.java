package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Part extends ZObject {
	ComponentInterface getDefinition();

	void setDefinition(ComponentInterface val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Part
	 */
	static final TypeSelectPredicate<Part> type = new TypeSelectPredicate<Part>(
			"ZMLMM::ZML_Component::Part", //$NON-NLS-1$
			Part.class);
}
