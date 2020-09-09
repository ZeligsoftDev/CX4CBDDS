package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface AssemblyImplementation extends StructuralRealization, NamedElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of AssemblyImplementation
	 */
	static final TypeSelectPredicate<AssemblyImplementation> type = new TypeSelectPredicate<AssemblyImplementation>(
			"CCM::CCM_Implementation::AssemblyImplementation", //$NON-NLS-1$
			AssemblyImplementation.class);
}
