/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.ui.XtextProjectHelper
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.annotation.NonNull;

/**
 */
public class OCLProjectHelper {

	public static final @NonNull String NATURE_ID = "org.eclipse.ocl.pivot.ui.oclnature"; //$NON-NLS-1$
	public static final @NonNull String BUILDER_ID = "org.eclipse.ocl.pivot.ui.oclbuilder"; //$NON-NLS-1$

	private static final Logger log = LogManager.getLogger(OCLProjectHelper.class);

	public static boolean hasNature(IProject project) {
		try {
			if (project.isAccessible()) {
				return project.hasNature(NATURE_ID);
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	public static boolean hasBuilder(IProject project) {
		if (project.isAccessible()) {
			try {
				for (ICommand command : project.getDescription().getBuildSpec()) {
					if (BUILDER_ID.equals(command.getBuilderName())) {
						return true;
					}
				}
			} catch (CoreException e) {
				log.error("Can't build due to an exception.", e);
			}
		}
		return false;
	}

}
