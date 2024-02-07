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

import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureFramework}s. This allows the definition of architecture
 * framework to be split across several architectural models (*.architecture).
 *
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedArchitectureContext}s
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework
 * @since 1.0
 */
public class MergedArchitectureFramework extends MergedArchitectureContext {

	/**
	 * Create a new '<em><b>Merged Architecture Framework</b></em>'.
	 *
	 * @param domain
	 *            the merged parent domain of this framework
	 * @deprecated Since version 3.1 of the bundle, the merge model requires a backing model.
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public MergedArchitectureFramework(MergedArchitectureDomain domain) {
		this(domain, null);
	}

	/**
	 * @since 3.1
	 */
	public MergedArchitectureFramework(MergedArchitectureDomain domain, ArchitectureFramework framework) {
		super(domain, framework);
	}

	/**
	 * @since 3.1
	 */
	@Override
	protected ArchitectureFramework getModel() {
		return (ArchitectureFramework) super.getModel();
	}

}
