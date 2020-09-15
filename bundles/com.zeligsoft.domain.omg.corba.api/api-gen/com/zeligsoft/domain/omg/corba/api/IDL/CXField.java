package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXField extends CXNamedElement, CXTyped {
	String getBound();

	void setBound(String val);

	java.util.List<CXBound> getBounds();

	void addBounds(CXBound val);

	<T extends CXBound> T addBounds(Class<T> typeToCreate, String concept);

	CXBound addBounds();

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXField
	 */
	static final TypeSelectPredicate<CXField> type = new TypeSelectPredicate<CXField>("CXDomain::IDL::CXField", //$NON-NLS-1$
			CXField.class);
}
