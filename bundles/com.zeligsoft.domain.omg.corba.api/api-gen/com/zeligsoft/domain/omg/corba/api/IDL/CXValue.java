package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface CXValue extends CXType, Contained, CXClassifier {
	Boolean getIsCustom();

	void setIsCustom(Boolean val);

	Boolean getIsTruncatable();

	void setIsTruncatable(Boolean val);

	Boolean getIsAbstract();

	void setIsAbstract(Boolean val);

	org.eclipse.uml2.uml.Interface asInterface();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXValue
	 */
	static final TypeSelectPredicate<CXValue> type = new TypeSelectPredicate<CXValue>("CXDomain::IDL::CXValue", //$NON-NLS-1$
			CXValue.class);
}
