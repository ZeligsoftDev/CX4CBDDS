package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwPart extends ZObject {
	SwComponent getDefinition();

	void setDefinition(SwComponent val);

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwPart
	 */
	static final TypeSelectPredicate<SwPart> type = new TypeSelectPredicate<SwPart>(
			"ZMLMM::ZML_SwPlatform::SwPart", //$NON-NLS-1$
			SwPart.class);
}
