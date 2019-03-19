package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Operation;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;

public interface CORBAOperation extends CORBANamedElement, CORBATyped,
		Operation, WorkerFunctionIdentifiable {
	Boolean getIsOneWay();

	void setIsOneWay(Boolean val);

	java.util.List<CORBAException> getExceptionDef();

	void addExceptionDef(CORBAException val);

	java.util.List<CORBAParameter> getOwnedParameter();

	void addOwnedParameter(CORBAParameter val);

	<T extends CORBAParameter> T addOwnedParameter(Class<T> typeToCreate,
			String concept);

	CORBAParameter addOwnedParameter();

	CORBAModuleContained getOwner();

	@Override
	CORBAType getIdlType();

	@Override
	void setIdlType(CORBAType val);

	@Override
	org.eclipse.uml2.uml.Operation asOperation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAOperation
	 */
	static final TypeSelectPredicate<CORBAOperation> type = new TypeSelectPredicate<CORBAOperation>(
			"CORBADomain::IDL::CORBAOperation", //$NON-NLS-1$
			CORBAOperation.class);
}
