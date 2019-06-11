package com.zeligsoft.domain.omg.ccm.api.CCM_Component;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAAttribute;
import com.zeligsoft.domain.zml.api.ZML_Component.ComponentInterface;

public interface CCMComponent extends ComponentInterface, ManagesEnd,
		CORBAModuleContained, CORBANamedElement, CORBAType {
	java.util.List<CORBAAttribute> getOwnedAttribute();

	void addOwnedAttribute(CORBAAttribute val);

	<T extends CORBAAttribute> T addOwnedAttribute(Class<T> typeToCreate,
			String concept);

	CORBAAttribute addOwnedAttribute();

	java.util.List<CCMComponent> getGenerals();

	void addGenerals(CCMComponent val);

	java.util.List<Property> getOwnedProperty();

	void addOwnedProperty(Property val);

	<T extends Property> T addOwnedProperty(Class<T> typeToCreate,
			String concept);

	Property addOwnedProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of CCMComponent
	 */
	static final TypeSelectPredicate<CCMComponent> type = new TypeSelectPredicate<CCMComponent>(
			"CCM::CCM_Component::CCMComponent", //$NON-NLS-1$
			CCMComponent.class);
}
