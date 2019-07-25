package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainMultiplicityElement extends ZObject {
	Boolean getOrdered();

	void setOrdered(Boolean val);

	Boolean getUnique();

	void setUnique(Boolean val);

	Integer getLower();

	void setLower(Integer val);

	Integer getUpper();

	void setUpper(Integer val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainMultiplicityElement
	 */
	static final TypeSelectPredicate<DomainMultiplicityElement> type = new TypeSelectPredicate<DomainMultiplicityElement>(
			"ZDL::Constructs::DomainMultiplicityElement", //$NON-NLS-1$
			DomainMultiplicityElement.class);
}
