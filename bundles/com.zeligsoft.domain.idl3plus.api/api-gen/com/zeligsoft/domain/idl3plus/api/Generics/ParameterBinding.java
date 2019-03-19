package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

public interface ParameterBinding extends ZObject {
	TypeParameter getTypeParameter();

	void setTypeParameter(TypeParameter val);

	CORBAType getType();

	void setType(CORBAType val);

	org.eclipse.uml2.uml.TemplateParameterSubstitution asTemplateParameterSubstitution();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ParameterBinding
	 */
	static final TypeSelectPredicate<ParameterBinding> type = new TypeSelectPredicate<ParameterBinding>(
			"IDL3Plus::Generics::ParameterBinding", //$NON-NLS-1$
			ParameterBinding.class);
}
