package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXModule extends CXNamedElement, Contained, CXModuleContained {
	java.util.List<CXModuleContained> getContents();

	void addContents(CXModuleContained val);

	<T extends CXModuleContained> T addContents(Class<T> typeToCreate, String concept);

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXModule
	 */
	static final TypeSelectPredicate<CXModule> type = new TypeSelectPredicate<CXModule>("CXDomain::IDL::CXModule", //$NON-NLS-1$
			CXModule.class);
}
