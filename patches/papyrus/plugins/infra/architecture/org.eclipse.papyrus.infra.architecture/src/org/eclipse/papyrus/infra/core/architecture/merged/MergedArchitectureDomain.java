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
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;
import org.eclipse.papyrus.infra.core.internal.architecture.merger.InternalArchitectureDomainMerger;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureDomain}s. This allows the definition of architecture
 * domains to be split across several architectural models (*.architecture).
 *
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedADElement}s
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
 * @since 1.0
 */
public class MergedArchitectureDomain extends MergedADElement {

	private final EList<MergedArchitectureContext> contexts = new UniqueEList<>() {
		private static final long serialVersionUID = 1L;

		@Override
		protected void didAdd(int index, MergedArchitectureContext newObject) {
			newObject.setParent(MergedArchitectureDomain.this);
		}
	};

	// For backward API compatibility, maintain a list of source models to merge
	// on-the-fly incrementally
	private final EList<ArchitectureDomain> mergedDomains = new UniqueEList<>();

	private boolean needsMerge;

	/**
	 * Create a new '<em><b>Merged Architecture Domain</b></em>'.
	 *
	 * @deprecated Since version 3.1 of the bundle, the merge model requires a backing model.
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public MergedArchitectureDomain() {
		super(null);
	}

	/**
	 * @since 3.1
	 */
	public MergedArchitectureDomain(ArchitectureDomain domain) {
		super(null, domain);
	}

	/**
	 * @since 3.1
	 */
	@Override
	protected ArchitectureDomain getModel() {
		checkMerge();
		return (ArchitectureDomain) super.getModel();
	}

	/**
	 * Get a merged collection of the domain's stakeholders
	 *
	 * @return a collection of stakeholders
	 */
	public Collection<Stakeholder> getStakeholders() {
		checkMerge();
		return ECollections.unmodifiableEList(getModel().getStakeholders());
	}

	/**
	 * Get a merged collection of the domain's concerns
	 *
	 * @return a collection of concerns
	 */
	public Collection<Concern> getConcerns() {
		checkMerge();
		return ECollections.unmodifiableEList(getModel().getConcerns());
	}

	/**
	 * Get a merged collection of the domain's contexts
	 *
	 * @return a collection of contexts
	 */
	public Collection<MergedArchitectureContext> getContexts() {
		checkMerge();
		return ECollections.unmodifiableEList(contexts);
	}

	final void addContext(MergedArchitectureContext context) {
		contexts.add(context);
	}

	/**
	 * Merges the given domain element with the other merge increments
	 *
	 * @param domain
	 *            a given domain to merge
	 * @deprecated Since version 3.1 of the bundle, the {@linkplain InternalArchitectureDomainMerger new architecture model merger}
	 *             is provided to merge all required domains in a single operation, creating this and related façade objects as a result
	 *
	 * @see InternalArchitectureDomainMerger
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public void merge(ArchitectureDomain domain) {
		needsMerge = mergedDomains.add(domain);
	}

	private void checkMerge() {
		if (needsMerge) {
			needsMerge = false;

			// I represent the first merged domain
			this.element = mergedDomains.get(0);

			InternalArchitectureDomainMerger merger = InternalArchitectureDomainMerger.newInstance();
			List<MergedArchitectureDomain> mergeResult = merger.mergeDomains(mergedDomains);

			// Find my Doppelgänger. As the old algorithm merged by name, we search by name here
			mergeResult.stream().filter(other -> Objects.equals(getName(), other.getName())).findFirst().ifPresent(self -> {
				// Get its underlying model
				this.element = self.getModel();

				// Adopt its contexts
				self.getContexts().forEach(this::addContext);
			});
		}
	}

	@Override
	public boolean isMerged() {
		checkMerge();
		return super.isMerged() || getContexts().stream().anyMatch(MergedADElement::isMerged);
	}

	//
	// Base element API
	//

	@Override
	public String getName() {
		checkMerge();
		return super.getName();
	}

	@Override
	public String getId() {
		checkMerge();
		return super.getId();
	}

	@Override
	public String getIcon() {
		checkMerge();
		return super.getIcon();
	}

	@Override
	public String getQualifiedName() {
		checkMerge();
		return super.getQualifiedName();
	}

	/**
	 * @deprecated Since version 3.1 of the bundle, the merged model façade API is supported by an EMF.Edit item provider
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Override
	@Deprecated(since = "3.1", forRemoval = true)
	public ADElement getImageObject() {
		checkMerge();
		return super.getImageObject();
	}

}
