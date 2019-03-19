package com.zeligsoft.domain.omg.ccm.api.CCM_Implementation;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ManagesImpl extends ZObject {
	ManagesImplEnd getComponent();

	void setComponent(ManagesImplEnd val);

	<T extends ManagesImplEnd> T createComponent(Class<T> typeToCreate,
			String concept);

	ManagesImplEnd getHome();

	void setHome(ManagesImplEnd val);

	<T extends ManagesImplEnd> T createHome(Class<T> typeToCreate,
			String concept);

	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ManagesImpl
	 */
	static final TypeSelectPredicate<ManagesImpl> type = new TypeSelectPredicate<ManagesImpl>(
			"CCM::CCM_Implementation::ManagesImpl", //$NON-NLS-1$
			ManagesImpl.class);
}
