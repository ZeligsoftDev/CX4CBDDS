package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CXException;
import com.zeligsoft.domain.omg.corba.api.IDL.CXParameter;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;

public interface HomeOperation extends CXNamedElement, WorkerFunctionIdentifiable {
	Home getOwner();

	void setOwner(Home val);

	java.util.List<CXException> getExceptionDef();

	void addExceptionDef(CXException val);

	java.util.List<CXParameter> getOwnedParameter();

	void addOwnedParameter(CXParameter val);

	<T extends CXParameter> T addOwnedParameter(Class<T> typeToCreate, String concept);

	CXParameter addOwnedParameter();

	org.eclipse.uml2.uml.Operation asOperation();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HomeOperation
	 */
	static final TypeSelectPredicate<HomeOperation> type = new TypeSelectPredicate<HomeOperation>(
			"CCM::CCM_Component::HomeOperation", //$NON-NLS-1$
			HomeOperation.class);
}
