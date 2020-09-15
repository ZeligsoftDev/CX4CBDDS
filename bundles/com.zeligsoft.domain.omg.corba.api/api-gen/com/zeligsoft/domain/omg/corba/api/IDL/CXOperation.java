package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.Operation;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;

public interface CXOperation extends CXNamedElement, CXTyped, Operation, WorkerFunctionIdentifiable {
	Boolean getIsOneWay();

	void setIsOneWay(Boolean val);

	java.util.List<CXException> getExceptionDef();

	void addExceptionDef(CXException val);

	java.util.List<CXParameter> getOwnedParameter();

	void addOwnedParameter(CXParameter val);

	<T extends CXParameter> T addOwnedParameter(Class<T> typeToCreate, String concept);

	CXParameter addOwnedParameter();

	CXModuleContained getOwner();

	@Override
	CXType getIdlType();

	@Override
	void setIdlType(CXType val);

	@Override
	org.eclipse.uml2.uml.Operation asOperation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXOperation
	 */
	static final TypeSelectPredicate<CXOperation> type = new TypeSelectPredicate<CXOperation>(
			"CXDomain::IDL::CXOperation", //$NON-NLS-1$
			CXOperation.class);
}
