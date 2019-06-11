package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

public interface TemplateParameterType extends CORBAType {
	org.eclipse.uml2.uml.Class asClass();

	org.eclipse.uml2.uml.DataType asDataType();

	org.eclipse.uml2.uml.Interface asInterface();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TemplateParameterType
	 */
	static final TypeSelectPredicate<TemplateParameterType> type = new TypeSelectPredicate<TemplateParameterType>(
			"IDL3Plus::Generics::TemplateParameterType", //$NON-NLS-1$
			TemplateParameterType.class);
}
