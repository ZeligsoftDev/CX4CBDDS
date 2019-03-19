package com.zeligsoft.domain.dds4ccm.api.DDS4CCM;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.IDL3PlusModel;

public interface DDS4CCMModel extends IDL3PlusModel {
	String getLocationPrefix();

	void setLocationPrefix(String val);

	String getFixedHeader();

	void setFixedHeader(String val);

	String getFixedFooter();

	void setFixedFooter(String val);

	ModelTypeEnum getModelType();

	void setModelType(ModelTypeEnum val);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of DDS4CCMModel
	 */
	static final TypeSelectPredicate<DDS4CCMModel> type = new TypeSelectPredicate<DDS4CCMModel>(
			"DDS4CCM::DDS4CCM::DDS4CCMModel", //$NON-NLS-1$
			DDS4CCMModel.class);
}
