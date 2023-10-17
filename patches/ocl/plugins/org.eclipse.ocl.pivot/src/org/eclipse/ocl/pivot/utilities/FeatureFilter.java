/*******************************************************************************
 * Copyright (c) 2014, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Stereotype;

public interface FeatureFilter
{
	/**
	 * @since 1.4
	 */
	public static final class NonStaticFeatureFilter implements FeatureFilter
	{
		@Override
		public boolean accept(@NonNull Feature asFeature) {
			return !asFeature.isIsStatic();
		}
	}

	/**
	 * @since 1.4
	 */
	public static final class StaticFeatureFilter implements FeatureFilter
	{
		@Override
		public boolean accept(@NonNull Feature asFeature) {
			return asFeature.isIsStatic();
		}
	}

	/**
	 * @since 1.18
	 */
	public static final class ExtensionFeatureFilter implements FeatureFilter
	{
		@Override
		public boolean accept(@NonNull Feature asFeature) {
			return (asFeature instanceof Property) && (((Property)asFeature).getType() instanceof Stereotype);
		}
	}

	boolean accept(@NonNull Feature asFeature);

	/**
	 * @since 1.18
	 */
	public static final @NonNull FeatureFilter SELECT_EXTENSION = new ExtensionFeatureFilter();
	public static final @NonNull FeatureFilter SELECT_NON_STATIC = new NonStaticFeatureFilter();
	public static final @NonNull FeatureFilter SELECT_STATIC = new StaticFeatureFilter();
}