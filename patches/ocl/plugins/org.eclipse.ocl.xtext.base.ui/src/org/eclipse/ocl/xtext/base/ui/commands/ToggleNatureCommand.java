/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.ToggleXtextNatureCommand
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.commands;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.annotation.NonNull;

import com.google.inject.ImplementedBy;

/**
 * ToggleNatureCommand provides an interface whose default ToggleOCLNatureCommand implementation provides the OCL
 * nature UI functionality, but which may be replaced by an alternative for an extended OCL language.
 */
@ImplementedBy(ToggleOCLNatureCommand.class)
public interface ToggleNatureCommand
{
	String getAddNatureDialogText(String projectName);
	String getAddNatureDialogTitle();
	@NonNull String getAddNatureKey();
	boolean hasNature(@NonNull IProject project);
	void toggleNature(@NonNull IProject project);
}
