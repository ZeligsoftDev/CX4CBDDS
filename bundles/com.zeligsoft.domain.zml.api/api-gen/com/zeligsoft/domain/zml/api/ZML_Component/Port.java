package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface Port extends TypedElement, NamedElement {
	Boolean getIsExternal();

	void setIsExternal(Boolean val);

	WiringKind getWiring();

	void setWiring(WiringKind val);

	PortTypeable getPorttype();

	void setPorttype(PortTypeable val);

	org.eclipse.uml2.uml.Port asPort();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Port
	 */
	static final TypeSelectPredicate<Port> type = new TypeSelectPredicate<Port>(
			"ZMLMM::ZML_Component::Port", //$NON-NLS-1$
			Port.class);
}
