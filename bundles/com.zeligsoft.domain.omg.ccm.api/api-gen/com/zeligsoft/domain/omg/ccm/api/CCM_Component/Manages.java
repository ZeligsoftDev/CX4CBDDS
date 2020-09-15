package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;

public interface Manages extends CXNamedElement {
	ManagesEnd getHome();

	void setHome(ManagesEnd val);

	<T extends ManagesEnd> T createHome(Class<T> typeToCreate, String concept);

	ManagesEnd getComponent();

	void setComponent(ManagesEnd val);

	<T extends ManagesEnd> T createComponent(Class<T> typeToCreate, String concept);

	org.eclipse.uml2.uml.Dependency asDependency();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Manages
	 */
	static final TypeSelectPredicate<Manages> type = new TypeSelectPredicate<Manages>("CCM::CCM_Component::Manages", //$NON-NLS-1$
			Manages.class);
}
