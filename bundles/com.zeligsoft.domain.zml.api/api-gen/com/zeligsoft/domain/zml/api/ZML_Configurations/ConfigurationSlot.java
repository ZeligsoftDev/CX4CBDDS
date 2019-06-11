package com.zeligsoft.domain.zml.api.ZML_Configurations;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface ConfigurationSlot extends ZObject {
	ConfigurationSlotKind getSlotKind();

	void setSlotKind(ConfigurationSlotKind val);

	org.eclipse.uml2.uml.Slot asSlot();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of ConfigurationSlot
	 */
	static final TypeSelectPredicate<ConfigurationSlot> type = new TypeSelectPredicate<ConfigurationSlot>(
			"ZMLMM::ZML_Configurations::ConfigurationSlot", //$NON-NLS-1$
			ConfigurationSlot.class);
}
