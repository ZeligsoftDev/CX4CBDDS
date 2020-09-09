package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface NodeInstance extends NamedElement, TypedElement {
	String getLabel();

	void setLabel(String val);

	Node getTypeOverride();

	void setTypeOverride(Node val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of NodeInstance
	 */
	static final TypeSelectPredicate<NodeInstance> type = new TypeSelectPredicate<NodeInstance>(
			"CCM::CCM_Target::NodeInstance", //$NON-NLS-1$
			NodeInstance.class);
}
