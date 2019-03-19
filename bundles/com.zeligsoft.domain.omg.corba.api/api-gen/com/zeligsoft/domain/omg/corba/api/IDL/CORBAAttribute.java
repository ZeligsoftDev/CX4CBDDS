package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;

public interface CORBAAttribute extends CORBANamedElement, CORBATyped,
		WorkerFunctionIdentifiable {
	java.util.List<CORBAException> getSetraises();

	void addSetraises(CORBAException val);

	java.util.List<CORBAException> getGetraises();

	void addGetraises(CORBAException val);

	Boolean getIsReadOnly();

	void setIsReadOnly(Boolean val);

	CORBAModuleContained getOwner();

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CORBAAttribute
	 */
	static final TypeSelectPredicate<CORBAAttribute> type = new TypeSelectPredicate<CORBAAttribute>(
			"CORBADomain::IDL::CORBAAttribute", //$NON-NLS-1$
			CORBAAttribute.class);
}
