package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ComponentInterface extends ZObject {
	java.util.List<Port> getOwnedPort();

	void addOwnedPort(Port val);

	<T extends Port> T addOwnedPort(Class<T> typeToCreate, String concept);

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ComponentInterface
	 */
	static final TypeSelectPredicate<ComponentInterface> type = new TypeSelectPredicate<ComponentInterface>(
			"ZMLMM::ZML_Component::ComponentInterface", //$NON-NLS-1$
			ComponentInterface.class);
}
