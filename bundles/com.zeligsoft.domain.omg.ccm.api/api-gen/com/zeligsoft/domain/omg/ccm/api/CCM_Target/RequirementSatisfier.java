package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface RequirementSatisfier extends NamedElement {
	java.util.List<String> getResourceType();

	void addResourceType(String val);

	java.util.List<SatisfierProperty> getProperty();

	void addProperty(SatisfierProperty val);

	<T extends SatisfierProperty> T addProperty(Class<T> typeToCreate, String concept);

	SatisfierProperty addProperty();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of RequirementSatisfier
	 */
	static final TypeSelectPredicate<RequirementSatisfier> type = new TypeSelectPredicate<RequirementSatisfier>(
			"CCM::CCM_Target::RequirementSatisfier", //$NON-NLS-1$
			RequirementSatisfier.class);
}
