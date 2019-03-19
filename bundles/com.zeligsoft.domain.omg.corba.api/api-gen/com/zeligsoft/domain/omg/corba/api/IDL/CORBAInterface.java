package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;
import com.zeligsoft.domain.zml.api.ZML_Component.Interface;

public interface CORBAInterface extends Interface, CORBANamedElement,
		CORBAType, Contained, CORBAClassifier, WorkerFunctionIdentifiable {
	Boolean getIsLocal();

	void setIsLocal(Boolean val);

	Boolean getIsAbstract();

	void setIsAbstract(Boolean val);

	java.util.List<CORBAInterface> getGenerals();

	void addGenerals(CORBAInterface val);

	Boolean getIsAsynchronous();

	void setIsAsynchronous(Boolean val);

	@Override
	org.eclipse.uml2.uml.Interface asInterface();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAInterface
	 */
	static final TypeSelectPredicate<CORBAInterface> type = new TypeSelectPredicate<CORBAInterface>(
			"CORBADomain::IDL::CORBAInterface", //$NON-NLS-1$
			CORBAInterface.class);
}
