package com.zeligsoft.domain.zml.api.ZML_SwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface SwComponent extends ZObject {
	java.util.List<SwPart> getPart();

	void addPart(SwPart val);

	<T extends SwPart> T addPart(Class<T> typeToCreate, String concept);

	SwPart addPart();

	java.util.List<SwPort> getPort();

	void addPort(SwPort val);

	<T extends SwPort> T addPort(Class<T> typeToCreate, String concept);

	SwPort addPort();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of SwComponent
	 */
	static final TypeSelectPredicate<SwComponent> type = new TypeSelectPredicate<SwComponent>(
			"ZMLMM::ZML_SwPlatform::SwComponent", //$NON-NLS-1$
			SwComponent.class);
}
