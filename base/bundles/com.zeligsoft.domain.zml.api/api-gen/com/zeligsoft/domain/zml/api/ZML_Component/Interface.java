package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Interface extends PortTypeable {
	java.util.List<Operation> getOperation();

	void addOperation(Operation val);

	<T extends Operation> T addOperation(Class<T> typeToCreate, String concept);

	Operation addOperation();

	org.eclipse.uml2.uml.Interface asInterface();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Interface
	 */
	static final TypeSelectPredicate<Interface> type = new TypeSelectPredicate<Interface>(
			"ZMLMM::ZML_Component::Interface", //$NON-NLS-1$
			Interface.class);
}
