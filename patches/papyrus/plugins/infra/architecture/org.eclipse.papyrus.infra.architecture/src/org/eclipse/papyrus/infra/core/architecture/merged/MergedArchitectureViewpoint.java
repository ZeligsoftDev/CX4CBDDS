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

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureViewpoint}s. This allows the definition of architecture
 * viewpoints to be split across several architectural models (*.architecture).
 *
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedADElement}s
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint
 * @since 1.0
 */
public class MergedArchitectureViewpoint extends MergedADElement {

	/**
	 * Create a new '<em><b>Merged Architecture Viewpoint</b></em>'.
	 *
	 * @param context
	 *            the merged parent context of this viewpoint
	 * @deprecated Since version 3.1 of the bundle, the merge model requires a backing model.
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public MergedArchitectureViewpoint(MergedArchitectureContext context) {
		super(context);
	}

	/**
	 * @since 3.1
	 */
	public MergedArchitectureViewpoint(MergedArchitectureContext context, ArchitectureViewpoint viewpoint) {
		super(context, viewpoint);

		context.addViewpoint(this);
	}

	/**
	 * @since 3.1
	 */
	@Override
	protected ArchitectureViewpoint getModel() {
		return (ArchitectureViewpoint) element;
	}

	/**
	 * Gets the viewpoint's parent context
	 *
	 * @return an architecture context
	 */
	public MergedArchitectureContext getContext() {
		return (MergedArchitectureContext) getParent();
	}

	/**
	 * Gets the viewpoint's merged concerns
	 *
	 * @return a merged collection of concerns
	 */
	public Collection<Concern> getConcerns() {
		return ECollections.unmodifiableEList(getModel().getConcerns());
	}

	/**
	 * Gets the viewpoint's merged representation kinds
	 *
	 * @return a merged collection of representation kinds
	 */
	public Collection<RepresentationKind> getRepresentationKinds() {
		return ECollections.unmodifiableEList(getModel().getRepresentationKinds());
	}

}
