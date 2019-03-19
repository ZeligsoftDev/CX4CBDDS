package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAParameter;

public interface HomeOperation extends CORBANamedElement,
		WorkerFunctionIdentifiable {
	Home getOwner();

	void setOwner(Home val);

	java.util.List<CORBAException> getExceptionDef();

	void addExceptionDef(CORBAException val);

	java.util.List<CORBAParameter> getOwnedParameter();

	void addOwnedParameter(CORBAParameter val);

	<T extends CORBAParameter> T addOwnedParameter(Class<T> typeToCreate,
			String concept);

	CORBAParameter addOwnedParameter();

	org.eclipse.uml2.uml.Operation asOperation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HomeOperation
	 */
	static final TypeSelectPredicate<HomeOperation> type = new TypeSelectPredicate<HomeOperation>(
			"CCM::CCM_Component::HomeOperation", //$NON-NLS-1$
			HomeOperation.class);
}
