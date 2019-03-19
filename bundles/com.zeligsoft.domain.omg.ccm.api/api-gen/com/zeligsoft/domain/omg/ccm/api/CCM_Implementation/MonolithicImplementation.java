package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;
import com.zeligsoft.domain.zml.api.ZML_Component.Implementation;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;
import com.zeligsoft.domain.zml.api.ZML_Component.StructuralRealization;

public interface MonolithicImplementation extends StructuralRealization,
		ManagesImplEnd, NamedElement, Implementation,
		WorkerFunctionIdentifiable {
	ComponentCategory getCategory();

	void setCategory(ComponentCategory val);

	@Override
	String getName();

	@Override
	void setName(String val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of MonolithicImplementation
	 */
	static final TypeSelectPredicate<MonolithicImplementation> type = new TypeSelectPredicate<MonolithicImplementation>(
			"CCM::CCM_Implementation::MonolithicImplementation", //$NON-NLS-1$
			MonolithicImplementation.class);
}
