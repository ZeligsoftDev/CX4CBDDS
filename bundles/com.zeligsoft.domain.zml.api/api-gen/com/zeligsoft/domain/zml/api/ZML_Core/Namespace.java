package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Namespace extends NamedElement {
	java.util.List<NamedElement> getMember();

	org.eclipse.uml2.uml.Namespace asNamespace();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Namespace
	 */
	static final TypeSelectPredicate<Namespace> type = new TypeSelectPredicate<Namespace>(
			"ZMLMM::ZML_Core::Namespace", //$NON-NLS-1$
			Namespace.class);
}
