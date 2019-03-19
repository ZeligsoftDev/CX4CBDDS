package com.zeligsoft.domain.omg.dds.api.Core;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface NamedEntity extends ZObject {
	String getName();

	void setName(String val);

	java.util.List<NamedEntity> getOwnedEntity();

	void addOwnedEntity(NamedEntity val);

	<T extends NamedEntity> T addOwnedEntity(Class<T> typeToCreate,
			String concept);

	/**
	 * A predicate which returns true if the Object is an
	 * instance of NamedEntity
	 */
	static final TypeSelectPredicate<NamedEntity> type = new TypeSelectPredicate<NamedEntity>(
			"DDS::Core::NamedEntity", //$NON-NLS-1$
			NamedEntity.class);
}
