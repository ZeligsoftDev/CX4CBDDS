package com.zeligsoft.domain.dds4ccm.api.DDSExtensions;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CXField;
import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

public interface MessageField extends CXField {
	Boolean getIsKey();

	void setIsKey(Boolean val);

	@Override
	CXType getIdlType();

	@Override
	void setIdlType(CXType val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of MessageField
	 */
	static final TypeSelectPredicate<MessageField> type = new TypeSelectPredicate<MessageField>(
			"DDS4CCM::DDSExtensions::MessageField", //$NON-NLS-1$
			MessageField.class);
}
