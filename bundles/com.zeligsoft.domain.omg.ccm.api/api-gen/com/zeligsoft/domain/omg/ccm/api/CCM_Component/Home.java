package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;
import com.zeligsoft.domain.omg.corba.api.IDL.CXAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;

public interface Home extends ManagesEnd, CXNamedElement, CXModuleContained, WorkerFunctionIdentifiable {
	Manages getManages();

	void setManages(Manages val);

	<T extends Manages> T createManages(Class<T> typeToCreate, String concept);

	Manages createManages();

	java.util.List<CXNamedElement> getExport();

	void addExport(CXNamedElement val);

	java.util.List<CXNamedElement> getNestedClassifier();

	void addNestedClassifier(CXNamedElement val);

	java.util.List<CXNamedElement> getProperty();

	void addProperty(CXNamedElement val);

	java.util.List<CXNamedElement> getOperation();

	void addOperation(CXNamedElement val);

	java.util.List<CXAttribute> getOwnedAttribute();

	void addOwnedAttribute(CXAttribute val);

	<T extends CXAttribute> T addOwnedAttribute(Class<T> typeToCreate, String concept);

	CXAttribute addOwnedAttribute();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Home
	 */
	static final TypeSelectPredicate<Home> type = new TypeSelectPredicate<Home>("CCM::CCM_Component::Home", //$NON-NLS-1$
			Home.class);
}
