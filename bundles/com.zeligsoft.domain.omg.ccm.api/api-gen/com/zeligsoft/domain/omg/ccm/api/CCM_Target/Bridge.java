package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface Bridge extends NamedElement {
	java.util.List<ResourceProperty> getResource();

	void addResource(ResourceProperty val);

	<T extends ResourceProperty> T addResource(Class<T> typeToCreate,
			String concept);

	ResourceProperty addResource();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Bridge
	 */
	static final TypeSelectPredicate<Bridge> type = new TypeSelectPredicate<Bridge>(
			"CCM::CCM_Target::Bridge", //$NON-NLS-1$
			Bridge.class);
}
