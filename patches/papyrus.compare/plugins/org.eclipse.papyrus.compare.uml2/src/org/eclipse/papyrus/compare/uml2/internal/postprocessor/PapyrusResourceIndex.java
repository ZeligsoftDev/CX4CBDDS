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

import static org.eclipse.emf.compare.utils.MatchUtil.getMatchedObject;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.CompareFactory;
import org.eclipse.emf.compare.ComparePackage;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * An index of relationships between Papyrus resources on each side of a comparison.
 *
 * @author Christian W. Damus
 */
public final class PapyrusResourceIndex {
	/**
	 * Mapping by side and Papyrusesque extensionless URI of the groups of resources that each together
	 * comprise a Papyrus model.
	 */
	private final Map<SidedURI, Map<String, MatchResource>> groups = Maps.newHashMap();

	/** Cache of matches by resource. */
	private final Map<Resource, MatchResource> matches = Maps.newHashMap();

	/** Token stored in the match cache for cache misses. */
	private final MatchResource noMatch = CompareFactory.eINSTANCE.createMatchResource();

	/** Mapping of refactorings. */
	private final BiMap<MatchResource, MatchResource> refactorings;

	/** The comparison that I index. */
	private final Comparison comparison;

	/**
	 * Index the resource matches in the given {@code comparison}.
	 * 
	 * @param comparison
	 *            the comparison to index
	 */
	private PapyrusResourceIndex(Comparison comparison) {
		super();

		this.comparison = comparison;
		this.refactorings = HashBiMap.create(comparison.getMatchedResources().size());

		for (MatchResource next : comparison.getMatchedResources()) {
			if (next.getLeftURI() != null) {
				URI uri = URI.createURI(next.getLeftURI());
				SidedURI key = SidedURI.left(uri.trimFileExtension());
				getGroup(key).put(uri.fileExtension(), next);
			}
			if (next.getRightURI() != null) {
				URI uri = URI.createURI(next.getRightURI());
				SidedURI key = SidedURI.right(uri.trimFileExtension());
				getGroup(key).put(uri.fileExtension(), next);
			}
		}
	}

	/**
	 * Get all of the resource matches (including the given {@code match}) that are the resources together
	 * comprising the Papyrus model containing it.
	 * 
	 * @param match
	 *            a resource match
	 * @param side
	 *            the side of the comparison on which the {@code match} is being considered
	 * @return a mapping of file extension to match for all of the resources of the Papyrus model of which the
	 *         {@code match} is one
	 */
	public Map<String, MatchResource> getGroup(MatchResource match, DifferenceSource side) {
		URI uri = URI.createURI(getURI(match, side));
		return getGroup(SidedURI.of(uri.trimFileExtension(), side));
	}

	/**
	 * Get the group for the given URI on its side, creating the group if necessary.
	 * 
	 * @param key
	 *            a URI (without extension) on a side of the comparison
	 * @return its resource match group
	 */
	private Map<String, MatchResource> getGroup(SidedURI key) {
		Map<String, MatchResource> result = groups.get(key);
		if (result == null) {
			result = Maps.newHashMap();
			groups.put(key, result);
		}
		return result;
	}

	/**
	 * Queries the match for a given {@code resource} in the context of my comparison.
	 * 
	 * @param resource
	 *            a resource in my comparison
	 * @return its match
	 */
	public MatchResource getMatch(Resource resource) {
		MatchResource result = matches.get(resource);

		if (result == null) {
			result = noMatch;

			if (resource != null) {
				for (MatchResource next : comparison.getMatchedResources()) {
					if (next.getLeft() == resource || next.getRight() == resource
							|| next.getOrigin() == resource) {

						result = next;
						break;
					}
				}
			} // else always cache a miss for the null resource

			// Cache the result, whether a miss ('noMatch') or not
			matches.put(resource, result);
		}

		return (result == noMatch) ? null : result;
	}

	/**
	 * Register a resource refactoring inferred from the given root object match.
	 * 
	 * @param rootMatch
	 *            a matched resource root apparently "moved" from one resource to another
	 */
	public void addResourceRefactoring(Match rootMatch) {
		EObject leftRoot = rootMatch.getLeft();
		EObject rightRoot = rootMatch.getRight();
		Resource leftRes = leftRoot.eResource();
		Resource rightRes = rightRoot.eResource();
		MatchResource leftMatch = getMatch(leftRes);
		MatchResource rightMatch = getMatch(rightRes);
		refactorings.put(leftMatch, rightMatch);

		// And do all of the group
		for (Map.Entry<String, MatchResource> next : getGroup(leftMatch, DifferenceSource.LEFT).entrySet()) {
			MatchResource nextLeft = next.getValue();
			if (nextLeft != leftMatch) {
				MatchResource nextRight = getGroup(rightMatch, DifferenceSource.RIGHT).get(next.getKey());
				if (nextRight != null) {
					refactorings.put(nextLeft, nextRight);
				}
			}
		}
	}

	/**
	 * Queries whether the comparison involves any resource refactoring.
	 * 
	 * @return whether any resource is refactored in my comparison
	 */
	public boolean hasResourceRefactorings() {
		return !refactorings.isEmpty();
	}

	/**
	 * Obtains the other resource match, if any, in a refactoring pair.
	 * 
	 * @param match
	 *            a resource match
	 * @return the other participant in the refactoring, or {@code null} if the {@code match} is not involved
	 *         in a refactoring
	 */
	public MatchResource getResourceRefactoring(MatchResource match) {
		MatchResource result = refactorings.get(match);
		if (result == null) {
			result = refactorings.inverse().get(match);
		}
		return result;
	}

	/**
	 * Queries whether a resource attachment change is a {@linkplain DifferenceKind#MOVE move} RAC that is
	 * only really a pseudo-RAC because, in fact, the source and destination resources are the same resource
	 * just refactored.
	 * 
	 * @param diff
	 *            a resource attachment change
	 * @return the other participant in the refactoring, or {@code null} if the {@code match} is not involved
	 *         in a refactoring
	 */
	public boolean isInResourceRefactoring(ResourceAttachmentChange diff) {
		if (diff.getKind() != DifferenceKind.MOVE) {
			// Something that's not a move doesn't indicate refactoring of the resource
			return false;
		}

		Match match = diff.getMatch();
		EObject moved = getMatchedObject(match, diff.getSource());
		Resource resource = moved.eResource();
		MatchResource resourceMatch = getMatch(resource);
		MatchResource otherMatch = getResourceRefactoring(resourceMatch);
		if (otherMatch == null) {
			return false;
		}

		Resource otherSide = getResource(otherMatch, opposite(diff.getSource()));

		// If it is not being moved from the old resource of the refactoring,
		// then it's a real move
		return otherSide != null && (match.getOrigin() == null
				|| match.getOrigin().eResource().getURI().equals(otherSide.getURI()));
	}

	/**
	 * Obtains the unique (lazily computed) index of Papyrus resources in the context of a {@code comparison}.
	 * 
	 * @param comparison
	 *            a comparison
	 * @return its resource index
	 */
	public static PapyrusResourceIndex index(Comparison comparison) {
		Attachment attachment = (Attachment)EcoreUtil.getExistingAdapter(comparison, Attachment.class);
		if (attachment == null) {
			attachment = new PapyrusResourceIndex(comparison).new Attachment(comparison);
		}
		return attachment.getIndex();
	}

	/**
	 * Obtains the unique (lazily computed) index of Papyrus resources in the context of the comparison
	 * containing a {@code match}.
	 * 
	 * @param match
	 *            a match in some comparison
	 * @return its resource index
	 */
	public static PapyrusResourceIndex index(Match match) {
		return index(match.getComparison());
	}

	/**
	 * Obtains the unique (lazily computed) index of Papyrus resources in the context of the comparison
	 * containing a {@code diff}.
	 * 
	 * @param diff
	 *            a difference in some comparison
	 * @return its resource index
	 */
	public static PapyrusResourceIndex index(Diff diff) {
		return index(diff.getMatch());
	}

	/**
	 * Compute the side opposite a given {@code side}.
	 * 
	 * @param side
	 *            a side of the comparison
	 * @return the other side
	 */
	protected static DifferenceSource opposite(DifferenceSource side) {
		return DifferenceSource.get(1 - side.ordinal());
	}

	/**
	 * Obtains the resource on the given {@code side} of a {@code match}.
	 * 
	 * @param match
	 *            a resource match
	 * @param side
	 *            a side
	 * @return the resource on that {@code side} of the {@code match}
	 */
	protected static Resource getResource(MatchResource match, DifferenceSource side) {
		switch (side) {
			case LEFT:
				return match.getLeft();
			case RIGHT:
				return match.getRight();
			default:
				throw new IllegalArgumentException("side"); //$NON-NLS-1$
		}
	}

	/**
	 * Obtains the resource URI on the given {@code side} of a {@code match}.
	 * 
	 * @param match
	 *            a resource match
	 * @param side
	 *            a side
	 * @return the URI on that {@code side} of the {@code match}
	 */
	protected static String getURI(MatchResource match, DifferenceSource side) {
		switch (side) {
			case LEFT:
				return match.getLeftURI();
			case RIGHT:
				return match.getRightURI();
			default:
				throw new IllegalArgumentException("side"); //$NON-NLS-1$
		}
	}

	/**
	 * Assigns the {@code resource} on the given {@code side} of a {@code match}.
	 * 
	 * @param match
	 *            a resource match
	 * @param side
	 *            a side
	 * @param resource
	 *            the resource to assign on that {@code side} of the {@code match}
	 */
	protected static void setResource(MatchResource match, DifferenceSource side, Resource resource) {
		switch (side) {
			case LEFT:
				match.setLeft(resource);
				break;
			case RIGHT:
				match.setRight(resource);
				break;
			default:
				throw new IllegalArgumentException("side"); //$NON-NLS-1$
		}
	}

	/**
	 * Assigns the resource {@code URI} on the given {@code side} of a {@code match}.
	 * 
	 * @param match
	 *            a resource match
	 * @param side
	 *            a side
	 * @param URI
	 *            the URI to assign on that {@code side} of the {@code match}
	 */
	protected static void setURI(MatchResource match, DifferenceSource side, String uri) {
		switch (side) {
			case LEFT:
				match.setLeftURI(uri);
				break;
			case RIGHT:
				match.setRightURI(uri);
				break;
			default:
				throw new IllegalArgumentException("side"); //$NON-NLS-1$
		}
	}

	//
	// Nested types
	//

	/**
	 * An adapter that attaches the unique instance of the index to a {@link Comparison} for subsequent
	 * retrieval.
	 */
	private final class Attachment extends AdapterImpl {
		/**
		 * Initializes me with my target {@code comparison}.
		 * 
		 * @param comparison
		 *            the comparison to which I attach
		 */
		Attachment(Comparison comparison) {
			super();

			comparison.eAdapters().add(this);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == PapyrusResourceIndex.class || type == Attachment.class;
		}

		/**
		 * Obtains the index that I attach to the comparison.
		 * 
		 * @return my index
		 */
		PapyrusResourceIndex getIndex() {
			return PapyrusResourceIndex.this;
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch() || msg.getNotifier() != comparison) {
				return;
			}

			switch (msg.getFeatureID(Comparison.class)) {
				case ComparePackage.COMPARISON__MATCHED_RESOURCES:
					// Purge cache of resource matches
					matches.clear();
					break;
				default:
					// Pass
					break;
			}
		}
	}
}
