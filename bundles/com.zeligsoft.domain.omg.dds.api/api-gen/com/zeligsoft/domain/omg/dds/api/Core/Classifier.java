package com.zeligsoft.domain.omg.dds.api.Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface Classifier extends NamedEntity {
	java.util.List<TypedEntity> getProperty();

	void addProperty(TypedEntity val);

	<T extends TypedEntity> T addProperty(Class<T> typeToCreate, String concept);

	org.eclipse.uml2.uml.Class asClass();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of Classifier
	 */
	static final TypeSelectPredicate<Classifier> type = new TypeSelectPredicate<Classifier>("DDS::Core::Classifier", //$NON-NLS-1$
			Classifier.class);
}
