package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAModule extends CORBANamedElement, Contained,
		CORBAModuleContained {
	java.util.List<CORBAModuleContained> getContents();

	void addContents(CORBAModuleContained val);

	<T extends CORBAModuleContained> T addContents(Class<T> typeToCreate,
			String concept);

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAModule
	 */
	static final TypeSelectPredicate<CORBAModule> type = new TypeSelectPredicate<CORBAModule>(
			"CORBADomain::IDL::CORBAModule", //$NON-NLS-1$
			CORBAModule.class);
}
