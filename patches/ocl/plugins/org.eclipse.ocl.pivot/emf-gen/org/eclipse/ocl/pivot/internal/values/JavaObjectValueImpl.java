/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * @generated NOT
 */
public class JavaObjectValueImpl extends ObjectValueImpl
{
	protected final @NonNull Object object;
	//	protected DomainType type = null;
	protected TypeId typeId = null;

	public JavaObjectValueImpl(@NonNull TypeId typeId, @NonNull Object object) {
		this.object = object;
		this.typeId = typeId;
	}

	@Override
	public @NonNull Object asObject() {
		return object;
	}

	@Override
	public @NonNull Object getObject() {
		return object;
	}

	/*	public @NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary) {
		DomainType type2 = type;
		if (type2 == null) {										// WIP A better type
			if (object instanceof Comparable) {
				type2 = type = standardLibrary.getOclComparableType();
			}
			else {
				type2 = type = standardLibrary.getMetaclassType();
			}
		}
		return type2;
	} */

	@Override
	public @NonNull TypeId getTypeId() {
		//		return getType(valueFactory.getStandardLibrary()).getTypeId();
		TypeId typeId2 = typeId;
		if (typeId2 == null) {
			if (object instanceof Comparable) {
				typeId = typeId2 = TypeId.OCL_COMPARABLE;
			}
			else {
				typeId = typeId2 = TypeId.OCL_ANY;// METACLASS
			}
		}
		return typeId2;
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}

	@Override
	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(object.toString());
	}
}
