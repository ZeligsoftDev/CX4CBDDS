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
 *  Christian W. Damus - bug 570486
 *
 *
 */
package org.eclipse.papyrus.infra.core.architecture.merged;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.architecture.commands.IModelConversionCommand;
import org.eclipse.papyrus.infra.architecture.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureContext}s. This allows the definition of architecture contexts
 * to be split across several architectural models (*.architecture).
 *
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedADElement}s
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext
 * @since 1.0
 */
public abstract class MergedArchitectureContext extends MergedADElement {

	private final EList<MergedArchitectureViewpoint> viewpoints = new UniqueEList<>();
	private EList<MergedArchitectureViewpoint> defaultViewpoints;

	/**
	 * Create a new '<em><b>Merged Architecture Context</b></em>'.
	 *
	 * @param domain
	 *            the merged parent domain of this context
	 * @deprecated Since version 3.1 of the bundle, the merge model requires a backing model.
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public MergedArchitectureContext(MergedArchitectureDomain domain) {
		this(domain, null);
	}

	/**
	 * @since 3.1
	 */
	public MergedArchitectureContext(MergedArchitectureDomain domain, ArchitectureContext context) {
		super(domain, context);

		domain.addContext(this);
	}

	/**
	 * @since 3.1
	 */
	@Override
	protected ArchitectureContext getModel() {
		return (ArchitectureContext) super.getModel();
	}

	/**
	 * Gets the context's extension prefix
	 *
	 * @return an extension prefix
	 */
	public String getExtensionPrefix() {
		return getModel().getExtensionPrefix();
	}

	/**
	 * Gets the context's creation command class
	 *
	 * @return a creation command class
	 */
	public Class<? extends IModelCreationCommand> getCreationCommandClass() throws ClassNotFoundException {
		String className = getCreationCommandClassName();

		return className == null ? null
				: ClassLoaderHelper.loadClass(className, IModelCreationCommand.class,
						EcoreUtil.getURI(MergeTraceAdapter.getSource(getModel(), ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS)));
	}

	/**
	 * Gets the context's conversion command class
	 *
	 * @return a conversion command class
	 */
	public Class<? extends IModelConversionCommand> getConversionCommandClass() throws ClassNotFoundException {
		String className = getConversionCommandClassName();
		return className == null ? null
				: ClassLoaderHelper.loadClass(className, IModelConversionCommand.class,
						EcoreUtil.getURI(MergeTraceAdapter.getSource(getModel(), ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS)));
	}

	/**
	 * Gets the context's creation command class name
	 *
	 * @return a creation command class name
	 * @since 2.0
	 */
	public String getCreationCommandClassName() {
		return getModel().getCreationCommandClass();
	}

	/**
	 * Gets the context's conversion command class name
	 *
	 * @return a conversion command class name
	 * @since 2.0
	 */
	public String getConversionCommandClassName() {
		return getModel().getConversionCommandClass();
	}

	/**
	 * Gets the context's parent domain
	 *
	 * @return the parent domain
	 */
	public MergedArchitectureDomain getDomain() {
		return (MergedArchitectureDomain) getParent();
	}

	/**
	 * Gets the context's element type set configurations
	 *
	 * @return a merged collection of element type set configurations
	 */
	public Collection<ElementTypeSetConfiguration> getElementTypes() {
		return ECollections.unmodifiableEList(getModel().getElementTypes());

	}

	/**
	 * Gets the context's viewpoints
	 *
	 * @return a merged collection of viewpoints
	 */
	public Collection<MergedArchitectureViewpoint> getViewpoints() {
		return ECollections.unmodifiableEList(viewpoints);

	}

	final void addViewpoint(MergedArchitectureViewpoint viewpoint) {
		viewpoints.add(viewpoint);

		// Recalculate the default viewpoints
		defaultViewpoints = null;
	}

	/**
	 * Gets the context's default viewpoints
	 *
	 * @return a merged collection of viewpoints
	 */
	public Collection<MergedArchitectureViewpoint> getDefaultViewpoints() {
		if (defaultViewpoints == null) {
			Map<ArchitectureViewpoint, MergedArchitectureViewpoint> map = getViewpoints().stream()
					.collect(Collectors.toMap(MergedArchitectureViewpoint::getModel, Function.identity()));
			defaultViewpoints = getModel().getDefaultViewpoints().stream()
					.map(map::get)
					.filter(Objects::nonNull)
					.collect(Collectors.toCollection(UniqueEList::new));
		}

		return ECollections.unmodifiableEList(defaultViewpoints);

	}

	final void addDefaultViewpoint(MergedArchitectureViewpoint viewpoint) {
		defaultViewpoints.add(viewpoint);
	}

}
