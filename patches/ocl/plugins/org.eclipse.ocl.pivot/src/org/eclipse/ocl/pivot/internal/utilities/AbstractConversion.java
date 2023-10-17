/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.complete.CompleteEnvironmentInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;

public abstract class AbstractConversion
{
	public static interface Predicate<T extends EObject>
	{
		boolean filter(@NonNull T element);
	}	

	protected static <T> @Nullable T basicGet(@NonNull EObject eObject, @NonNull EAttribute eFeature, @NonNull Class<T> resultClass) {
		if (!eObject.eIsSet(eFeature)) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T result = (T) eObject.eGet(eFeature);
		return result;
	}

	public static @Nullable EPackage getEPackage(@Nullable EObject eObject) {
		for (; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof EPackage) {
				return (EPackage)eObject;
			}
		}
		return null;
	}

	public static boolean isId(@NonNull String name) {
		int n = name.length();
		if (n == 0)
			return false;
		if (!Character.isJavaIdentifierStart(name.charAt(0)))
			return false;
		for (int i = 1; i < n; i++)
			if (!Character.isJavaIdentifierPart(name.charAt(i)))
				return false;
		return true;
	}
	
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull PivotMetamodelManager metamodelManager;
	protected final @NonNull CompleteEnvironmentInternal completeEnvironment;
	protected final @NonNull StandardLibraryInternal standardLibrary;

	protected AbstractConversion(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
		this.metamodelManager = environmentFactory.getMetamodelManager();
		this.completeEnvironment = environmentFactory.getCompleteEnvironment();
		this.standardLibrary = completeEnvironment.getOwnedStandardLibrary();
	}
	
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}
	
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return metamodelManager;
	}

	public @NonNull StandardLibraryInternal getStandardLibrary() {
		return standardLibrary;
	}

	public <T extends EObject> void refreshList(@Nullable List<? super T> oldElements, @Nullable List<? extends T> newElements) {
		PivotUtilInternal.refreshList(oldElements, newElements);
	}

	protected <T extends EObject> void refreshSet(@Nullable List<? super T> oldElements, @Nullable Collection<? extends T> newElements) {
		PivotUtilInternal.refreshSet(oldElements, newElements);
	}
}