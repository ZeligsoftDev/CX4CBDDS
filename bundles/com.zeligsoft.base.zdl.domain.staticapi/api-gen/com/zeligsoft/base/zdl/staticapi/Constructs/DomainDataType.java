package com.zeligsoft.base.zdl.staticapi.Constructs;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface DomainDataType extends DomainClassifier {
	org.eclipse.uml2.uml.DataType asDataType();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DomainDataType
	 */
	static final TypeSelectPredicate<DomainDataType> type = new TypeSelectPredicate<DomainDataType>(
			"ZDL::Constructs::DomainDataType", //$NON-NLS-1$
			DomainDataType.class);
}
