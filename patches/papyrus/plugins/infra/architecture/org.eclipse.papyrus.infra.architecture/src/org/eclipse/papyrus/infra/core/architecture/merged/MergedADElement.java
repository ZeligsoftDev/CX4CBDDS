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
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 550359
 *  Christian W. Damus - bugs 569357, 570486
 *
 */
package org.eclipse.papyrus.infra.core.architecture.merged;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.impl.NotifierImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;

import com.google.common.base.Objects;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ADElement}s that are instances of the same EClass. This allows the definition
 * of architecture elements to be split across several architectural models (*.architecture).
 *
 * All merged elements is assumed to have the same name and qualified name values. However, only
 * one of those elements (the main merge increment) has values for the single-valued properties.
 * On the other hand, all multi-valued properties of the elements are merged.
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ADElement
 * @since 1.0
 */
public class MergedADElement extends NotifierImpl implements IAdaptable {

	/**
	 * The merged parent of this element
	 */
	protected MergedADElement parent;

	/**
	 * the architecture elements that represent merge increments of this element
	 */
	protected ADElement element;

	/**
	 * Create a new '<em><b>Merged AD Element</b></em>'.
	 *
	 * @param parent
	 *            the merged parent of this element
	 * @deprecated Since version 3.1 of the bundle, the merge model requires a backing model.
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public MergedADElement(MergedADElement parent) {
		this(parent, null);
	}

	/**
	 * Create a new '<em><b>Merged AD Element</b></em>'.
	 *
	 * @param parent
	 *            the merged parent of this element
	 * @param element
	 *            the architecture domain model element underlying this façade, to which it delegates for details
	 *            of its attributes and relationships
	 * @since 3.1
	 */
	public MergedADElement(MergedADElement parent, ADElement element) {
		this.parent = parent;
		this.element = element;
	}

	/**
	 * @since 3.1
	 */
	protected ADElement getModel() {
		return element;
	}

	/**
	 * Get the element's parent
	 *
	 * @return the parent element
	 */
	public MergedADElement getParent() {
		return parent;
	}

	/**
	 * Update my parent.
	 *
	 * @param domain
	 *            my new parent
	 */
	void setParent(MergedArchitectureDomain domain) {
		this.parent = domain;
	}

	/**
	 * Gets the context's id
	 *
	 * @return an id
	 */
	public String getId() {
		return element.getId();
	}

	/**
	 * Get the element's name
	 *
	 * @return a name
	 */
	public String getName() {
		return element.getName();
	}

	/**
	 * Get the element's qualified name
	 *
	 * @return a qualified name
	 */
	public String getQualifiedName() {
		return element.getQualifiedName();
	}

	/**
	 * Get the element's description
	 *
	 * @return a description
	 */
	public String getDescription() {
		return element.getDescription();
	}

	/**
	 * Gets the context's icon path
	 *
	 * @return an icon path
	 */
	public String getIcon() {
		return element.getIcon();
	}

	/**
	 * Get a merge increment whose image represents that of the merged element
	 *
	 * By default, any one of the merge increments will be returned. Subclasses may override.
	 *
	 * @return a merge increment
	 * @since 2.0
	 * @deprecated Since version 3.1 of the bundle, the merged model façade API is supported by an EMF.Edit item provider
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public ADElement getImageObject() {
		return element;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(element);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MergedADElement)) {
			return false;
		}
		MergedADElement other = (MergedADElement) obj;
		if (other.parent != this.parent) {
			return false;
		}
		return Objects.equal(other.element, element);
	}

	@Override
	public String toString() {
		return element != null ? element.toString() : super.toString();
	}

	/**
	 * Get the merged elements number.
	 *
	 * @return The number of merged elements.
	 * @since 2.1
	 *
	 * @deprecated Since version 3.1 of the bundle, the merge model is backed one-for-one by merged model elements
	 * @see <a href="https://eclip.se/573168">bug 573168</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "3.1", forRemoval = true)
	public int getElementsNumber() {
		return element != null ? 1 : 0;
	}

	/**
	 * Query whether I actually a merge of multiple elements in the registered architecture models.
	 *
	 * @return whether I am a merge of multiple elements
	 * @since 3.1
	 */
	public boolean isMerged() {
		MergeTraceAdapter trace = MergeTraceAdapter.getMergeTraces(getModel());

		// If the adapter isn't attached, then of course I wasn't merged
		return trace != null && trace.trace(getModel()).size() > 1;
	}

	//
	// IAdaptable protocol
	//

	/**
	 * {@inheritDoc}
	 *
	 * @since 3.1
	 */
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		T result;

		if (getModel() == null) {
			result = Platform.getAdapterManager().getAdapter(this, adapter);
		} else {
			if (adapter == EObject.class || adapter.isInstance(getModel())) {
				result = adapter.cast(getModel());
			} else if (adapter == Resource.class) {
				result = adapter.cast(getModel().eResource());
			} else if (adapter == ResourceSet.class) {
				result = adapter.cast(getModel().eResource().getResourceSet());
			} else {
				result = Platform.getAdapterManager().getAdapter(this, adapter);
			}
		}

		return result;
	}

}
