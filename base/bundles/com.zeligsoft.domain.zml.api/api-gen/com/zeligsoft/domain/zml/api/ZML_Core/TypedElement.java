package com.zeligsoft.domain.zml.api.ZML_Core;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface TypedElement extends ZObject {
	Integer getUpperBound();

	void setUpperBound(Integer val);

	Integer getLowerBound();

	void setLowerBound(Integer val);

	Type getType();

	void setType(Type val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TypedElement
	 */
	static final TypeSelectPredicate<TypedElement> type = new TypeSelectPredicate<TypedElement>(
			"ZMLMM::ZML_Core::TypedElement", //$NON-NLS-1$
			TypedElement.class);
}
