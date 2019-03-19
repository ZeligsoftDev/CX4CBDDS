package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface NamedElement extends ZObject {
	String getName();

	void setName(String val);

	String getQualifiedName();

	org.eclipse.uml2.uml.NamedElement asNamedElement();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of NamedElement
	 */
	static final TypeSelectPredicate<NamedElement> type = new TypeSelectPredicate<NamedElement>(
			"ZMLMM::ZML_Core::NamedElement", //$NON-NLS-1$
			NamedElement.class);
}
