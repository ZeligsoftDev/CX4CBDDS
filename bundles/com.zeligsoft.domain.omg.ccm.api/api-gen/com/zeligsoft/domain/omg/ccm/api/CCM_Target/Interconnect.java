package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface Interconnect extends NamedElement {
	java.util.List<ResourceProperty> getResource();

	void addResource(ResourceProperty val);

	<T extends ResourceProperty> T addResource(Class<T> typeToCreate,
			String concept);

	ResourceProperty addResource();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Interconnect
	 */
	static final TypeSelectPredicate<Interconnect> type = new TypeSelectPredicate<Interconnect>(
			"CCM::CCM_Target::Interconnect", //$NON-NLS-1$
			Interconnect.class);
}
