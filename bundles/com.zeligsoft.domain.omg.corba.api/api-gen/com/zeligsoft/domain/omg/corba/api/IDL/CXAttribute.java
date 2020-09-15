package com.zeligsoft.domain.omg.corba.api.IDL;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;

public interface CXAttribute extends CXNamedElement, CXTyped, WorkerFunctionIdentifiable {
	java.util.List<CXException> getSetraises();

	void addSetraises(CXException val);

	java.util.List<CXException> getGetraises();

	void addGetraises(CXException val);

	Boolean getIsReadOnly();

	void setIsReadOnly(Boolean val);

	CXModuleContained getOwner();

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CXAttribute
	 */
	static final TypeSelectPredicate<CXAttribute> type = new TypeSelectPredicate<CXAttribute>(
			"CXDomain::IDL::CXAttribute", //$NON-NLS-1$
			CXAttribute.class);
}
