/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @since 1.14
 */
public abstract class AbstractTables
{
	public static final @NonNull Map<@NonNull String, @NonNull AbstractTables> nsURI2tables = new HashMap<>();

	public static final @Nullable AbstractTables basicGet(@NonNull String nsURI) {
		return nsURI2tables.get(nsURI);
	}

	protected AbstractTables(@NonNull String nsURI) {
		nsURI2tables.put(nsURI, this);
	}

	/**
	 * Return the EClasses for which there are known invocations of the OCL allInstances() library operation.
	 */
	public @NonNull EClass @Nullable [] basicGetAllInstancesClasses() {
		return null;
	}

	/**
	 * Return the EReferences whose implicit opposite is used in an OCL Expression.
	 */
	public @NonNull EReference @Nullable [] basicGetImplicitOpposites() {
		return null;
	}
}