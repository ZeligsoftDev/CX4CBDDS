package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

public interface ModuleInstantiation extends CORBANamedElement,
		CORBAModuleContained {
	ModuleBinding getModuleBinding();

	void setModuleBinding(ModuleBinding val);

	<T extends ModuleBinding> T createModuleBinding(Class<T> typeToCreate,
			String concept);

	ModuleBinding createModuleBinding();

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ModuleInstantiation
	 */
	static final TypeSelectPredicate<ModuleInstantiation> type = new TypeSelectPredicate<ModuleInstantiation>(
			"IDL3Plus::Generics::ModuleInstantiation", //$NON-NLS-1$
			ModuleInstantiation.class);
}
