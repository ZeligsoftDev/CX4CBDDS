package com.zeligsoft.domain.omg.dds.api.Core;

import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface TypedEntity extends NamedEntity {
	Specification getType();

	org.eclipse.uml2.uml.Property asProperty();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of TypedEntity
	 */
	static final TypeSelectPredicate<TypedEntity> type = new TypeSelectPredicate<TypedEntity>(
			"DDS::Core::TypedEntity", //$NON-NLS-1$
			TypedEntity.class);
}
