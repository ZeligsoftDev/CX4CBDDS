package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ComponentImplementation extends ZObject {
	StructuralRealization getStructuralRealization();

	void setStructuralRealization(StructuralRealization val);

	Implementation getImplementation();

	void setImplementation(Implementation val);

	org.eclipse.uml2.uml.Manifestation asManifestation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ComponentImplementation
	 */
	static final TypeSelectPredicate<ComponentImplementation> type = new TypeSelectPredicate<ComponentImplementation>(
			"ZMLMM::ZML_Component::ComponentImplementation", //$NON-NLS-1$
			ComponentImplementation.class);
}
