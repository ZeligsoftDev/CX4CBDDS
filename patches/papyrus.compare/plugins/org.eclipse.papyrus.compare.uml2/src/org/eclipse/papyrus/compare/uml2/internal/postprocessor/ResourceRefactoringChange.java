/*******************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.postprocessor;

import static com.google.common.collect.Iterables.filter;
import static org.eclipse.emf.compare.DifferenceSource.LEFT;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.fromSide;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * An adapter for a {@link ResourceAttachmentChange} that represents a resource refactoring. It provides
 * details of the resource's old and new {@link URI}s.
 *
 * @author Christian W. Damus
 */
public final class ResourceRefactoringChange implements Adapter {
	private static final Object TYPE = new Object();

	private final ResourceAttachmentChange rac;

	private URI oldURI;

	private URI newURI;

	/**
	 * Initializes me with the RAC that I wrap.
	 * 
	 * @param rac
	 *            my wrapped diff
	 */
	private ResourceRefactoringChange(ResourceAttachmentChange rac) {
		super();

		this.rac = rac;
		rac.eAdapters().add(this);
	}

	public static boolean isResourceRefactoringChange(Diff diff) {
		return diff instanceof ResourceAttachmentChange && get(diff) != null;
	}

	public static Predicate<Diff> isResourceRefactoringChange() {
		return new Predicate<Diff>() {
			public boolean apply(Diff input) {
				return isResourceRefactoringChange(input);
			}
		};
	}

	public static ResourceRefactoringChange get(Diff diff) {
		if (diff instanceof ResourceAttachmentChange) {
			return (ResourceRefactoringChange)EcoreUtil.getExistingAdapter(diff, TYPE);
		}
		return null;
	}

	public static Function<Diff, ResourceRefactoringChange> get() {
		return new Function<Diff, ResourceRefactoringChange>() {
			public ResourceRefactoringChange apply(Diff input) {
				return get(input);
			}
		};
	}

	public static ResourceRefactoringChange demand(ResourceAttachmentChange rac) {
		ResourceRefactoringChange result = get(rac);
		if (result == null) {
			result = new ResourceRefactoringChange(rac);
		}
		return result;
	}

	public static ResourceRefactoringChange demand(Match match, DifferenceSource side) {
		return demand(getRAC(match, side));
	}

	private static ResourceAttachmentChange getRAC(Match match, DifferenceSource side) {
		Iterable<ResourceAttachmentChange> racs = filter(match.getDifferences(),
				ResourceAttachmentChange.class);
		return Iterables.find(racs, fromSide(side));
	}

	public static Predicate<ResourceRefactoringChange> onSide(final DifferenceSource side) {
		return new Predicate<ResourceRefactoringChange>() {
			public boolean apply(ResourceRefactoringChange input) {
				return (input != null) && input.getSource() == side;
			}
		};
	}

	public ResourceAttachmentChange toDiff() {
		return rac;
	}

	/**
	 * @return the oldURI
	 */
	public URI getOldURI() {
		return oldURI;
	}

	/**
	 * @param oldURI
	 *            the oldURI to set
	 */
	public void setOldURI(URI oldURI) {
		this.oldURI = oldURI;
	}

	/**
	 * @return the newURI
	 */
	public URI getNewURI() {
		return newURI;
	}

	/**
	 * @param newURI
	 *            the newURI to set
	 */
	public void setNewURI(URI newURI) {
		this.newURI = newURI;
	}

	public Resource getNewResource() {
		// Get the resource of the new URI on the left side
		return demandResource(getNewURI(), LEFT, true);
	}

	public Resource getOldResource() {
		// Get the resource of the old URI on the left side
		return demandResource(getOldURI(), LEFT, false);
	}

	/**
	 * Obtains the specified resource on the given {@code side} of the match.
	 * 
	 * @param uri
	 *            the resource URI to get
	 * @param side
	 *            the side of the comparison in which to get the refactored resource
	 * @param create
	 *            whether to create the resource if it doesn't exist (e.g., for merging into it)
	 * @return the resource, or {@code null} if it doesn't exist and is not {@code create}d
	 */
	protected Resource demandResource(URI uri, DifferenceSource side, boolean create) {
		EObject context = MatchUtil.getMatchedObject(getMatch(), side);
		ResourceSet rset = context.eResource().getResourceSet();

		Resource result = rset.getResource(uri, false);
		if (result == null) {
			if (rset.getURIConverter().exists(uri, null)) {
				result = rset.getResource(uri, true);
			} else if (create) {
				result = rset.createResource(uri);
			}
		}

		return result;
	}

	//
	// Diff protocol delegation
	//

	public DifferenceSource getSource() {
		return rac.getSource();
	}

	public DifferenceKind getKind() {
		return rac.getKind();
	}

	public DifferenceState getState() {
		return rac.getState();
	}

	public Match getMatch() {
		return rac.getMatch();
	}

	public EList<Diff> getRequiredBy() {
		return rac.getRequiredBy();
	}

	//
	// Adapter protocol
	//

	public Notifier getTarget() {
		return rac;
	}

	public void setTarget(Notifier newTarget) {
		if (newTarget != null && newTarget != rac) {
			throw new IllegalArgumentException("attempt to attach to another object"); //$NON-NLS-1$
		}
	}

	public boolean isAdapterForType(Object type) {
		return type == TYPE;
	}

	public void notifyChanged(Notification notification) {
		// Pass
	}
}
