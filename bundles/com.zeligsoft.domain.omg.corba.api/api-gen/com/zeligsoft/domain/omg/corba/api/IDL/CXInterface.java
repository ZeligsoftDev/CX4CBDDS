package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Interface;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;

public interface CXInterface
		extends Interface, CXNamedElement, CXType, Contained, CXClassifier, WorkerFunctionIdentifiable {
	Boolean getIsLocal();

	void setIsLocal(Boolean val);

	Boolean getIsAbstract();

	void setIsAbstract(Boolean val);

	java.util.List<CXInterface> getGenerals();

	void addGenerals(CXInterface val);

	Boolean getIsAsynchronous();

	void setIsAsynchronous(Boolean val);

	@Override
	org.eclipse.uml2.uml.Interface asInterface();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXInterface
	 */
	static final TypeSelectPredicate<CXInterface> type = new TypeSelectPredicate<CXInterface>(
			"CXDomain::IDL::CXInterface", //$NON-NLS-1$
			CXInterface.class);
}
