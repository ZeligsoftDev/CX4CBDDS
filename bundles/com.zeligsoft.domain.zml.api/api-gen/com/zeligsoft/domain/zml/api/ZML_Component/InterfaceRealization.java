package com.zeligsoft.domain.zml.api.ZML_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface InterfaceRealization extends NamedElement {
	Interface getTarget();

	void setTarget(Interface val);

	org.eclipse.uml2.uml.InterfaceRealization asInterfaceRealization();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of InterfaceRealization
	 */
	static final TypeSelectPredicate<InterfaceRealization> type = new TypeSelectPredicate<InterfaceRealization>(
			"ZMLMM::ZML_Component::InterfaceRealization", //$NON-NLS-1$
			InterfaceRealization.class);
}
