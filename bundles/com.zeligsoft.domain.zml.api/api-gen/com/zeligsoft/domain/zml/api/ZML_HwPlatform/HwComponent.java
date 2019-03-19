package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwComponent extends ZObject {
	java.util.List<HwPort> getPort();

	void addPort(HwPort val);

	<T extends HwPort> T addPort(Class<T> typeToCreate, String concept);

	HwPort addPort();

	java.util.List<HwPart> getPart();

	void addPart(HwPart val);

	<T extends HwPart> T addPart(Class<T> typeToCreate, String concept);

	HwPart addPart();

	java.util.List<HwConnector> getConnector();

	void addConnector(HwConnector val);

	<T extends HwConnector> T addConnector(Class<T> typeToCreate, String concept);

	HwConnector addConnector();

	org.eclipse.uml2.uml.Component asComponent();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwComponent
	 */
	static final TypeSelectPredicate<HwComponent> type = new TypeSelectPredicate<HwComponent>(
			"ZMLMM::ZML_HwPlatform::HwComponent", //$NON-NLS-1$
			HwComponent.class);
}
