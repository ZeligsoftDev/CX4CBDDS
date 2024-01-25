/**
 * Copyright (c) 2017, 2021 CEA LIST, Christian W. Damus, and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  Benoit Maggi - Bug 535393
 *  Christian W. Damus - bug 571881
 *
 */
package org.eclipse.papyrus.infra.architecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.architecture.commands.IModelConversionCommand;
import org.eclipse.papyrus.infra.architecture.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.architecture.commands.ModelCommandProviderRegistry;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescription;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;

/**
 * An API for manipulating architecture descriptions in a model set
 *
 * @since 1.0
 */
public class ArchitectureDescriptionUtils {

	/**
	 * The model set in context
	 */
	private ModelSet modelSet;

	/**
	 * The architecture domain manager
	 */
	private ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();

	/**
	 * Constructs an instance of this class given a model set
	 *
	 * @param modelSet
	 *            The given model set
	 */
	public ArchitectureDescriptionUtils(ModelSet modelSet) {
		this.modelSet = modelSet;
	}

	/**
	 * Gets the model set in context
	 *
	 * @return a model set
	 */
	public ModelSet getModelSet() {
		return modelSet;
	}

	/**
	 * Gets the architecture context set in the model set
	 *
	 * @return architecture context
	 */
	public MergedArchitectureContext getArchitectureContext() {
		String contextId = getArchitectureContextId();
		return manager.getArchitectureContextById(contextId);
	}

	/**
	 * Gets the architecture context id set in the model set
	 *
	 * @return architecture context id
	 */
	public String getArchitectureContextId() {
		ArchitectureDescription description = DiModelUtils.getArchitectureDescription(modelSet);
		if (description != null) {
			return description.getContextId();
		}
		return ArchitectureDomainManager.getInstance().getDefaultArchitectureContextId();
	}

	/**
	 * Gets the architecture viewpoints set in the model set
	 *
	 * @return a collection of architecture viewpoints
	 */
	public Collection<MergedArchitectureViewpoint> getArchitectureViewpoints() {
		List<MergedArchitectureViewpoint> viewpoints = new ArrayList<>();
		for (String viewpointId : getArchitectureViewpointIds()) {
			MergedArchitectureViewpoint viewpoint = manager.getArchitectureViewpointById(viewpointId);
			if (viewpoint != null) {
				viewpoints.add(viewpoint);
			}
		}
		return viewpoints;
	}

	/**
	 * Gets the architecture viewpoint ids set in the model set
	 *
	 * @return a collection of architecture viewpoint ids
	 */
	public Collection<String> getArchitectureViewpointIds() {
		ArchitectureDescriptionPreferences preferences = SashModelUtils.getArchitectureDescriptionPreferences(modelSet);
		if (preferences != null) {
			return preferences.getViewpointIds();
		}
		Collection<String> viewpointIds = new LinkedHashSet<>();
		MergedArchitectureContext context = getArchitectureContext();
		if (context != null) {
			Collection<MergedArchitectureViewpoint> viewpoints = context.getDefaultViewpoints();
			if (viewpoints.isEmpty()) {
				viewpoints = context.getViewpoints();
			}
			for (MergedArchitectureViewpoint viewpoint : viewpoints) {
				viewpointIds.add(viewpoint.getId());
			}
		}

		return viewpointIds;
	}

	/**
	 * Returns a command that applies the given contextId and viewpoint ids to the model set
	 * and creates a new model in the set based on them
	 *
	 * Model creation is based on the creation command configured with the architecture context
	 * and contribution commands registered in extensions
	 *
	 * @param contextId
	 *            the context id to apply to the model set
	 * @param viewpointIds
	 *            the viewpoint ids to apply to the model set
	 * @return a command to create a new model
	 */
	public Command createNewModel(final String contextId, final String[] viewpointIds) {
		CompoundCommand cc = new CompoundCommand("Create New Model");
		// Add a command to set the new context id to the model set. Do this first because creation of the
		// model may depend on element type bindings in this context
		cc.append(getSetContextCommand(contextId));
		// Add a command to set the new viewpoint ids to the model set
		cc.append(getSetViewpointCommand(viewpointIds));
		// Add the main command to create the model
		cc.append(getModelCreationCommand(contextId));
		// Add commands from registered providers to create the model
		cc.append(ModelCommandProviderRegistry.getInstance().getModelCreationCommand(modelSet, contextId));
		return cc;
	}

	/**
	 * Returns a command that switches the contextId of the model set to the given id and
	 * converts the semantic model as a result
	 *
	 * Model conversion is based on the conversion command configured with the architecture context
	 * and contribution commands registered in extensions
	 *
	 * @param contextId
	 *            the context id to apply to the model set
	 * @return a command that switches the model set to the given context id
	 */
	public Command switchArchitectureContextId(final String contextId) {
		CompoundCommand cc = new CompoundCommand("Switch Architecture Context");
		// Add the main command to convert the model
		cc.append(getModelConversionCommand(contextId));
		// Add commands from registered providers to convert the model
		cc.append(ModelCommandProviderRegistry.getInstance().getModelConversionCommand(modelSet, contextId));
		// Add a command to set the new context id
		cc.append(getSetContextCommand(contextId));
		return cc;
	}

	/**
	 * Returns a command that switches the viewpoints of the model set to the given id
	 *
	 * @param viewpointIds
	 *            the new viewpoint ids to apply to the model set
	 * @return a command that switches the model set to the given viewpoint ids
	 */
	public Command switchArchitectureViewpointIds(final String[] viewpointIds) {
		CompoundCommand cc = new CompoundCommand("Switch Architecture Viewpoints");
		// Add a command to convert the model
		cc.append(getSetViewpointCommand(viewpointIds));
		return cc;
	}

	/**
	 * Returns a command to set the context id in the model set
	 *
	 * @param contextId
	 *            the new context id
	 * @return a command that sets the context id in the model set
	 */
	protected Command getSetContextCommand(String contextId) {
		return new RecordingCommand(modelSet.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				ArchitectureDescription description = DiModelUtils.getOrAddArchitectureDescription(modelSet);
				description.setContextId(contextId);
			}
		};
	}

	/**
	 * Returns a command to create a new model in the model set based on the given context id
	 *
	 * @param contextId
	 *            the context id
	 * @return a command that creates a new model
	 */
	protected Command getModelCreationCommand(String contextId) {
		final MergedArchitectureContext context = manager.getArchitectureContextById(contextId);
		if (context.getCreationCommandClassName() == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new RecordingCommand(modelSet.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				try {
					IModelCreationCommand creationCommand = context.getCreationCommandClass().getConstructor().newInstance();
					creationCommand.createModel(modelSet);
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}
		};
	}

	/**
	 * Returns a command to converts a new model in the model set based on the given new context id
	 *
	 * @param contextId
	 *            the new context id
	 * @return a command that converts a model
	 */
	protected Command getModelConversionCommand(String contextId) {
		MergedArchitectureContext context = manager.getArchitectureContextById(contextId);
		if (context.getConversionCommandClassName() == null) {
			return null;
		}
		return new RecordingCommand(modelSet.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				try {
					IModelConversionCommand conversionCommand = context.getConversionCommandClass().getConstructor().newInstance();
					conversionCommand.convertModel(modelSet);
				} catch (Exception e) {
					Activator.log.error(e);
				}
			}
		};
	}

	/**
	 * Returns a command that sets the given viewpoint ids to the model set
	 *
	 * @param viewpointIds
	 *            The new viewpoint ids
	 * @return a command to set the viewpoint ids
	 */
	protected Command getSetViewpointCommand(String[] viewpointIds) {
		return new RecordingCommand(modelSet.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				ArchitectureDescriptionPreferences preferences = SashModelUtils.getOrAddArchitectureDescriptionPreferences(modelSet);
				Arrays.sort(viewpointIds);
				preferences.eSet(ArchitecturePackage.eINSTANCE.getArchitectureDescriptionPreferences_ViewpointIds(), Arrays.asList(viewpointIds));
			}
		};
	}

}
