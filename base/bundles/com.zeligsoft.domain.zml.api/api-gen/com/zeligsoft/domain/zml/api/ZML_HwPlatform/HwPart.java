package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwPart extends ZObject {
	HwComponent getDefinition();

	void setDefinition(HwComponent val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwPart
	 */
	static final TypeSelectPredicate<HwPart> type = new TypeSelectPredicate<HwPart>(
			"ZMLMM::ZML_HwPlatform::HwPart", //$NON-NLS-1$
			HwPart.class);
}
