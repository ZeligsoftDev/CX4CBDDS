/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 415697
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.OCLCommon;
import org.eclipse.ocl.common.preferences.PreferenceableOption;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.Customizable;
import org.eclipse.ocl.pivot.utilities.Option;

/**
 * Implementation of the {@link EnvironmentFactoryInternal} for parsing OCL expressions
 * on Ecore models.
 */
public class PivotEnvironmentFactory extends AbstractEnvironmentFactory
{
	private @Nullable IProject project = null;		// Eclipse project for project-specific preferences
	private /*@NonNull*/ IScopeContext @Nullable [] scopeContexts = null;		// FIXME BUG 485092

	/**
	 * Initializes me with an optional <code>StandaloneProjectMap</code> of accessible resources and
	 * an optional <code>ModelManager</code> for loaded instances.
	 */
	@Deprecated /* @deprecated supply null asResourceSet argument */
	public PivotEnvironmentFactory(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {
		this(projectManager, externalResourceSet, null);
	}

	/**
	 * @since 1.10
	 */
	public PivotEnvironmentFactory(@NonNull ProjectManager projectManager, @Nullable ResourceSet csResourceSet, @Nullable ResourceSet asResourceSet) {
		super(projectManager, csResourceSet, asResourceSet);
	}

	@Override
	public <@Nullable T> T getValue(@NonNull Option<T> option) {
		@SuppressWarnings("unchecked") T result = (T) getOptions().get(option);
		if (result != null) {
			return result;
		}
		Customizable parent2 = getParent();
		if (parent2 != null) {
			return parent2.getValue(option);
		}
		if (option instanceof PreferenceableOption<?>) {
			if (project != null) {
				@SuppressWarnings("null")@NonNull IScopeContext instance = ConfigurationScope.INSTANCE;
				scopeContexts = new @NonNull IScopeContext @NonNull []{ new ProjectScope(project), instance};
			}
			else {
				scopeContexts = null;
			}
			@SuppressWarnings("unchecked") PreferenceableOption<T> preferenceableOption = (PreferenceableOption<T>)option;
			result = OCLCommon.getPreference(preferenceableOption, scopeContexts);
			if (result != null) {
				return result;
			}
		}
		return option.getDefaultValue();
	}

	@Override
	public void setProject(@Nullable IProject project) {
		this.project = project;
	}
}
