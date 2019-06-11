package com.zeligsoft.domain.idl3plus.api.Generics;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface TemplateSignature extends ZObject {
	java.util.List<TypeParameter> getTypeParameter();

	void addTypeParameter(TypeParameter val);

	<T extends TypeParameter> T addTypeParameter(Class<T> typeToCreate,
			String concept);

	TypeParameter addTypeParameter();

	org.eclipse.uml2.uml.TemplateSignature asTemplateSignature();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TemplateSignature
	 */
	static final TypeSelectPredicate<TemplateSignature> type = new TypeSelectPredicate<TemplateSignature>(
			"IDL3Plus::Generics::TemplateSignature", //$NON-NLS-1$
			TemplateSignature.class);
}
