package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HideableElement extends NamedElement {
	/**
	 * A predicate which returns true if the Object is an
	 * instance of HideableElement
	 */
	static final TypeSelectPredicate<HideableElement> type = new TypeSelectPredicate<HideableElement>(
			"ZMLMM::ZML_Core::HideableElement", //$NON-NLS-1$
			HideableElement.class);
}
