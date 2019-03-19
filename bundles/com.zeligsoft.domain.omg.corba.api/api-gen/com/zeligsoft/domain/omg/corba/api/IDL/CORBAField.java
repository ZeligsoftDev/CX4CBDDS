package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CORBAField extends CORBANamedElement, CORBATyped {
	String getBound();

	void setBound(String val);

	java.util.List<CORBABound> getBounds();

	void addBounds(CORBABound val);

	<T extends CORBABound> T addBounds(Class<T> typeToCreate, String concept);

	CORBABound addBounds();

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAField
	 */
	static final TypeSelectPredicate<CORBAField> type = new TypeSelectPredicate<CORBAField>(
			"CORBADomain::IDL::CORBAField", //$NON-NLS-1$
			CORBAField.class);
}
