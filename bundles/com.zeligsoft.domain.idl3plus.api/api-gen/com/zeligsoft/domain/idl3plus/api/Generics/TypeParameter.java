package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface TypeParameter extends ZObject {
	TypeConstraint getConstraint();

	void setConstraint(TypeConstraint val);

	org.eclipse.uml2.uml.ClassifierTemplateParameter asClassifierTemplateParameter();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TypeParameter
	 */
	static final TypeSelectPredicate<TypeParameter> type = new TypeSelectPredicate<TypeParameter>(
			"IDL3Plus::Generics::TypeParameter", //$NON-NLS-1$
			TypeParameter.class);
}
