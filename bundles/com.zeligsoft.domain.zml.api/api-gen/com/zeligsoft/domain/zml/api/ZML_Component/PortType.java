package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.Type;

public interface PortType extends Type, PortTypeable {
	PortType getInverse();

	void setInverse(PortType val);

	java.util.List<InterfaceRealization> getProvidedInterfaces();

	void addProvidedInterfaces(InterfaceRealization val);

	<T extends InterfaceRealization> T addProvidedInterfaces(
			Class<T> typeToCreate, String concept);

	InterfaceRealization addProvidedInterfaces();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of PortType
	 */
	static final TypeSelectPredicate<PortType> type = new TypeSelectPredicate<PortType>(
			"ZMLMM::ZML_Component::PortType", //$NON-NLS-1$
			PortType.class);
}
