package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainElement extends ZObject {
	java.util.List<DomainElement> getOwnedElement();

	void addOwnedElement(DomainElement val);

	<T extends DomainElement> T addOwnedElement(Class<T> typeToCreate,
			String concept);

	DomainElement getOwner();

	void setOwner(DomainElement val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainElement
	 */
	static final TypeSelectPredicate<DomainElement> type = new TypeSelectPredicate<DomainElement>(
			"ZDL::Constructs::DomainElement", //$NON-NLS-1$
			DomainElement.class);
}
