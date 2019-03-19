package com.zeligsoft.domain.dds4ccm.api.DDSExtensions;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAField;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

public interface MessageField extends CORBAField {
	Boolean getIsKey();

	void setIsKey(Boolean val);

	@Override
	CORBAType getIdlType();

	@Override
	void setIdlType(CORBAType val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of MessageField
	 */
	static final TypeSelectPredicate<MessageField> type = new TypeSelectPredicate<MessageField>(
			"DDS4CCM::DDSExtensions::MessageField", //$NON-NLS-1$
			MessageField.class);
}
