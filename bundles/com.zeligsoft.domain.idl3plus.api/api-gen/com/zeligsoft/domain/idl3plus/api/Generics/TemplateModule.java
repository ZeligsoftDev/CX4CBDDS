package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

public interface TemplateModule extends CXNamedElement, CXModuleContained, CXType {
	TemplateSignature getSignature();

	void setSignature(TemplateSignature val);

	<T extends TemplateSignature> T createSignature(Class<T> typeToCreate, String concept);

	TemplateSignature createSignature();

	org.eclipse.uml2.uml.Package asPackage();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TemplateModule
	 */
	static final TypeSelectPredicate<TemplateModule> type = new TypeSelectPredicate<TemplateModule>(
			"IDL3Plus::Generics::TemplateModule", //$NON-NLS-1$
			TemplateModule.class);
}
