/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteEnvironment;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.TupleTypeManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.MapTypeParameters;
import org.eclipse.ocl.pivot.values.TemplateParameterSubstitutions;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public interface CompleteEnvironmentInternal extends CompleteEnvironment
{
	void addOrphanClass(org.eclipse.ocl.pivot.@NonNull Class pivotElement);
	boolean conformsTo(@NonNull Type firstType, @NonNull TemplateParameterSubstitutions firstSubstitutions,
			@NonNull Type secondType, @NonNull TemplateParameterSubstitutions secondSubstitutions);
	void dispose();
	void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass, @NonNull CompleteClassInternal completeClass);
	void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass);
	@Nullable CollectionType findCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<@NonNull Type> typeParameters);
	@Nullable MapType findMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters);
	@NonNull CollectionType getCollectionType(@NonNull CompleteClassInternal completeClass, @NonNull CollectionTypeParameters<@NonNull Type> typeParameters);
	@NonNull <T extends CollectionType> T getCollectionType(@NonNull T containerType, @NonNull Type elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper);
	@NonNull CompleteClassInternal getCompleteClass(@NonNull Type pivotType);
	@NonNull MapType getMapType(@NonNull CompleteClassInternal completeClass, @NonNull MapTypeParameters<@NonNull Type, @NonNull Type> typeParameters);
	@NonNull MapType getMapType(@NonNull MapType containerType, @NonNull Type keyType, @NonNull Type valueType);
	/**
	 * @since 1.6
	 */
	default @NonNull MapType getMapType(@NonNull MapType containerType, @NonNull Type keyType, boolean keysAreNullFree, @NonNull Type valueType, boolean valuesAreNullFree) {
		return getMapType(containerType, keyType, true, valueType, true);
	}
	@Override
	@NonNull CompleteModelInternal getOwnedCompleteModel();
	//	@NonNull MetamodelManager getMetamodelManager();
	//	@Override
	//	@NonNull PivotStandardLibrary getStandardLibrary();
	@Override
	@NonNull StandardLibraryInternal getOwnedStandardLibrary();
	@NonNull TupleTypeManager getTupleManager();
	@NonNull CompleteEnvironmentInternal init(@NonNull EnvironmentFactoryInternal environmentFactory);
	boolean isCodeGeneration();
	void setCodeGeneration(boolean isCodeGeneration);
	@NonNull EnvironmentFactoryInternal getEnvironmentFactory();
}