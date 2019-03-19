package com.zeligsoft.domain.omg.ccm.api.CCM_Deployment;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;

public interface ContainerProcess extends NamedElement {
	java.util.List<Property> getProperty();

	void addProperty(Property val);

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ContainerProcess
	 */
	static final TypeSelectPredicate<ContainerProcess> type = new TypeSelectPredicate<ContainerProcess>(
			"CCM::CCM_Deployment::ContainerProcess", //$NON-NLS-1$
			ContainerProcess.class);
}
