/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.XtextNature
 *******************************************************************************/
package org.eclipse.ocl.pivot.ui.nature;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.pivot.ui.builder.OCLBuilder;
import org.eclipse.ocl.xtext.base.ui.OCLProjectHelper;

/**
 */
public class OCLNature implements IProjectNature
{
	private IProject project;

	@Override
	public void configure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(OCLProjectHelper.BUILDER_ID)) {
				return;
			}
		}

		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 1, commands.length);
		ICommand command = desc.newCommand();
		command.setBuilderName(OCLProjectHelper.BUILDER_ID);
		Map<String, String> args = new HashMap<>();
		args.put("disabledExtensions", "*,essentialocl");
		args.put("enabledExtensions", "ecore,ocl,oclinecore,oclstdlib,uml");
		args.put("disabledPaths", "bin/**,target/**");
		args.put("enabledPaths", "**");
		command.setArguments(args);
		newCommands[0] = command;
		desc.setBuildSpec(newCommands);
		project.setDescription(desc, null);
	}

	@Override
	public void deconfigure() throws CoreException {
		IProject project2 = getProject();
		IProjectDescription description = project2.getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			ICommand oldCommands = commands[i];
			if (oldCommands.getBuilderName().equals(OCLProjectHelper.BUILDER_ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
				description.setBuildSpec(newCommands);
				project.setDescription(description, null);
				OCLBuilder.deleteMarkers(project2, oldCommands.getArguments());
				return;
			}
		}
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}
}
