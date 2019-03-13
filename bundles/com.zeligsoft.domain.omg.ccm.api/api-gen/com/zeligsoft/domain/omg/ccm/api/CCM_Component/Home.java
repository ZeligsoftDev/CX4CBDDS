package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.zml.api.ZML_Component.WorkerFunctionIdentifiable;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

public interface Home extends ManagesEnd, CORBANamedElement,
		CORBAModuleContained, WorkerFunctionIdentifiable {
	Manages getManages();

	void setManages(Manages val);

	<T extends Manages> T createManages(Class<T> typeToCreate, String concept);

	Manages createManages();

	java.util.List<CORBANamedElement> getExport();

	void addExport(CORBANamedElement val);

	java.util.List<CORBANamedElement> getNestedClassifier();

	void addNestedClassifier(CORBANamedElement val);

	java.util.List<CORBANamedElement> getProperty();

	void addProperty(CORBANamedElement val);

	java.util.List<CORBANamedElement> getOperation();

	void addOperation(CORBANamedElement val);

	java.util.List<CORBAAttribute> getOwnedAttribute();

	void addOwnedAttribute(CORBAAttribute val);

	<T extends CORBAAttribute> T addOwnedAttribute(Class<T> typeToCreate,
			String concept);

	CORBAAttribute addOwnedAttribute();

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Home
	 */
	static final TypeSelectPredicate<Home> type = new TypeSelectPredicate<Home>(
      "CCM::CCM_Component::Home", //$NON-NLS-1$
        Home.class); 
}
