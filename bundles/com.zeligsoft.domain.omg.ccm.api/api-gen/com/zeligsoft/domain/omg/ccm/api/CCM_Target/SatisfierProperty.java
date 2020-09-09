package com.zeligsoft.domain.omg.ccm.api.CCM_Target;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;
import com.zeligsoft.domain.zml.api.ZML_Core.TypedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public interface SatisfierProperty extends NamedElement, TypedElement {
	Boolean getDynamic();

	void setDynamic(Boolean val);

	SatisfierPropertyKind getKind();

	void setKind(SatisfierPropertyKind val);

	String getValue();

	void setValue(String val);

	CXType getTypeOverride();

	void setTypeOverride(CXType val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of SatisfierProperty
	 */
	static final TypeSelectPredicate<SatisfierProperty> type = new TypeSelectPredicate<SatisfierProperty>(
			"CCM::CCM_Target::SatisfierProperty", //$NON-NLS-1$
			SatisfierProperty.class);
}
