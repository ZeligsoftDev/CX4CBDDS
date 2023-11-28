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

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Iterables.transform;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.ofKind;
import static org.eclipse.emf.compare.utils.MatchUtil.getMatchedObject;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.PapyrusResourceIndex.getResource;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.PapyrusResourceIndex.getURI;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.PapyrusResourceIndex.index;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.PapyrusResourceIndex.opposite;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.ResourceRefactoringChange.isResourceRefactoringChange;
import static org.eclipse.papyrus.compare.uml2.internal.postprocessor.ResourceRefactoringChange.onSide;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.CompareFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.uml2.internal.postprocessor.util.UMLCompareUtil;
import org.eclipse.emf.compare.util.CompareSwitch;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Post-processor for comparisons of Papyrus models. Specialized diffs that it looks for include:
 * <ul>
 * <li>{@link ResourceRefactoringChange}s in matches of root objects of resources that are refactored (URIs
 * changed by rename or move) and which, therefore, are not actually logically moving those root objects.
 * These changes therefore replace {@link ResourceAttachmentChange}s computed by the diff engine</li>
 * </ul>
 *
 * @author Christian W. Damus
 */
public class PapyrusPostProcessor implements IPostProcessor {

	/**
	 * A predicate matching diffs that are {@link ResourceAttachmentChange}s that move a stereotype
	 * application.
	 */
	static final Predicate<Diff> IS_STEREOTYPE_APPLICATION_RESOURCE_MOVE = and(isStereotypeApplicationRAC(),
			ofKind(DifferenceKind.MOVE));

	/**
	 * Initializes me.
	 */
	public PapyrusPostProcessor() {
		super();
	}

	public void postMatch(Comparison comparison, Monitor monitor) {
		// Pass
	}

	public void postDiff(Comparison comparison, Monitor monitor) {
		// Pass
	}

	public void postRequirements(Comparison comparison, Monitor monitor) {
		// Ensure that certain diffs of stereotype applications are merged
		// only after certain other diffs of their base UML elements
		findStereotypeApplicationDependencies(comparison);
	}

	public void postEquivalences(Comparison comparison, Monitor monitor) {
		// Pass
	}

	public void postConflicts(Comparison comparison, Monitor monitor) {
		// Handle refactoring of model resources, esp. sub-units
		rematchRefactoredUMLResources(comparison, monitor);
		pruneRACsInRefactoredResources(comparison, monitor);
	}

	public void postComparison(Comparison comparison, Monitor monitor) {
		// Pass
	}

	/**
	 * Find diffs for stereotype applications moved from one resource to another and add the moves (if any) of
	 * their base elements as pre-requisites.
	 * 
	 * @param comparison
	 *            the contextual comparison
	 */
	protected void findStereotypeApplicationDependencies(Comparison comparison) {
		for (ResourceAttachmentChange rac : getStereotypeApplicationResourceMoves(comparison)) {
			// Also the diff that moves the base element, if any
			Match match = rac.getMatch();
			EObject stereotypeApplication = MatchUtil.getMatchedObject(match, rac.getSource());

			Element baseElement = UMLCompareUtil.getBaseElement(stereotypeApplication);
			if (baseElement != null) {
				Match baseMatch = comparison.getMatch(baseElement);
				Diff moveDiff = findMoveDiff(baseMatch, comparison, rac.getSource());
				if (moveDiff != null) {
					rac.getRequires().add(moveDiff);
				}
			}
		}
	}

	/**
	 * Obtain a predicate matching diffs that are {@link ResourceAttachmentChange}s pertaining to a stereotype
	 * application.
	 * 
	 * @return the is-stereotype-application-RAC predicate
	 */
	protected static Predicate<Diff> isStereotypeApplicationRAC() {
		return new Predicate<Diff>() {
			public boolean apply(Diff input) {
				if (!(input instanceof ResourceAttachmentChange)) {
					return false;
				}

				Match match = input.getMatch();
				EObject object = match.getLeft();
				if (object == null) {
					object = match.getRight();
				}

				return object != null && !(object instanceof Element)
						&& UMLCompareUtil.getBaseElement(object) != null;
			}
		};
	}

	/**
	 * Selects the resource attachment changes that indicate moves of stereotype applications from a resource
	 * to another.
	 * 
	 * @param comparison
	 *            the comparison from which to select the diffs
	 * @return the stereotype application moves between resources
	 */
	protected Iterable<ResourceAttachmentChange> getStereotypeApplicationResourceMoves(
			Comparison comparison) {

		return filter(filter(comparison.getDifferences(), ResourceAttachmentChange.class),
				IS_STEREOTYPE_APPLICATION_RESOURCE_MOVE);
	}

	/**
	 * Find the nearest diff to a given {@code match} that moves it (perhaps indirectly via the content tree)
	 * from a resource to another resource.
	 * 
	 * @param match
	 *            a match for which to look for a move diff
	 * @param comparison
	 *            the contextual comparison
	 * @param side
	 *            the side of the comparison on which to look for move diffs
	 * @return a diff that moves that {@code match}ed object from one resource to another, or {@code null} if
	 *         it is not moved between resources
	 */
	protected Diff findMoveDiff(Match match, Comparison comparison, DifferenceSource side) {
		Diff result = null;

		if (match != null) {
			EObject object = MatchUtil.getMatchedObject(match, side);
			if (object != null) {
				for (Diff next : comparison.getDifferences(object)) {
					if (next instanceof ReferenceChange
							&& ((ReferenceChange)next).getReference().isContainment()) {
						result = next;
						break;
					}
				}
			}

			if (result == null) {
				// Maybe the object is moved to a resource root?
				Iterator<ResourceAttachmentChange> iter = Iterators.filter(match.getDifferences().iterator(),
						ResourceAttachmentChange.class);
				if (iter.hasNext()) {
					result = iter.next();
				}
			}

			if (result == null && match.eContainer() instanceof Match) {
				// Look up the tree
				result = findMoveDiff((Match)match.eContainer(), comparison, side);
			}
		}

		return result;
	}

	/**
	 * Analyze the matching of resources to re-match any that have different URIs but that by dint of their
	 * primary UML element having moved are actually a refactoring (rename or move) of a single logical UML
	 * resource.
	 * 
	 * @param comparison
	 *            the contextual comparison
	 * @param monitor
	 *            progress monitor
	 */
	protected void rematchRefactoredUMLResources(Comparison comparison, Monitor monitor) {
		// Look for renamed resources, which are matched by their root UML elements
		Set<Resource> processed = Sets.newHashSet();
		Multimap<Match, ResourceRefactoringChange> diffs = ArrayListMultimap.create();
		PapyrusResourceIndex index = index(comparison);

		for (MatchResource mres : comparison.getMatchedResources()) {
			Match rootMatch = null;
			for (DifferenceSource side : DifferenceSource.VALUES) {
				rootMatch = rematch(comparison, mres, side, index, processed);
				if (rootMatch != null //
						&& (!diffs.containsKey(rootMatch) || !any(diffs.get(rootMatch), onSide(side)))) {

					ResourceRefactoringChange uriDiff = null;

					if (rootMatch.getOrigin() != null) {
						uriDiff = ResourceRefactoringChange.demand(rootMatch, side);
						diffs.put(rootMatch, uriDiff);
						uriDiff.setNewURI(getMatchedObject(rootMatch, side).eResource().getURI());
						// We know that the origin also has a direct resource because we filter
						// out control-control conflicts
						uriDiff.setOldURI(rootMatch.getOrigin().eResource().getURI());
					} else if (side == DifferenceSource.RIGHT) {
						// In two-way comparison, only consider incoming (right) as
						// imposing the change
						uriDiff = ResourceRefactoringChange.demand(rootMatch, side);
						diffs.put(rootMatch, uriDiff);
						DifferenceSource opposite = opposite(side);
						uriDiff.setNewURI(getMatchedObject(rootMatch, opposite).eResource().getURI());
						uriDiff.setOldURI(getResource(mres, side).getURI());
					}

					if (uriDiff != null) {
						index.addResourceRefactoring(rootMatch);
						findDependencies(comparison, uriDiff);
					}
				}
			}
		}

		// Look for conflicts in resources refactored on both sides
		for (Match objectMatch : diffs.keySet()) {
			Collection<ResourceRefactoringChange> uriDiffs = diffs.get(objectMatch);

			if (uriDiffs.size() > 1) {
				conflict(comparison, uriDiffs);
			}
		}
	}

	/**
	 * Attempt to re-match a UML resource that appears to be unmatched with a UML resource on the other side,
	 * also unmatched, that contains the same root {@link Element}, on the assumption that such element
	 * constitutes logical content of the resource.
	 * 
	 * @param comparison
	 *            the contextual comparison
	 * @param mres
	 *            a resource to re-match
	 * @param side
	 *            the side from which to try to find a new match on the other side
	 * @param index
	 *            an index of relationships between resources in the context of the the {@code comparison}
	 * @param processed
	 *            collects the resources that we've searched for
	 * @return the match for a {@link ResourceAttachmentChange} that indicates the resource refactoring, or
	 *         {@code null} if none
	 */
	protected Match rematch(Comparison comparison, MatchResource mres, DifferenceSource side,
			PapyrusResourceIndex index, Set<Resource> processed) {

		Match result = null;

		final DifferenceSource opposite = opposite(side);
		final Resource oneSide = getResource(mres, side);
		final Resource otherSide = getResource(mres, opposite);

		// Did this side actually change the resource URI?
		out: if (oneSide != null && otherSide == null
				&& (mres.getOriginURI() == null || !mres.getOriginURI().equals(getURI(mres, side)))) {

			// Don't process a resource match that we've already seen
			if (processed.add(oneSide) && !oneSide.getContents().isEmpty()) {
				EObject root = (Element)EcoreUtil.getObjectByType(oneSide.getContents(),
						UMLPackage.Literals.ELEMENT);

				if (root == null) {
					// Only need this for UML resources that reliably contain
					// only one real element, to handle stereotype applications
					// that are additional non-UML roots
					break out;
				}

				Match rootMatch = comparison.getMatch(root);
				if (rootMatch != null) {
					EObject otherRoot = MatchUtil.getMatchedObject(rootMatch, opposite);
					if (otherRoot != null) {
						Resource other = ((InternalEObject)otherRoot).eDirectResource();

						// If this is three-way and the origin exists and is uncontrolled,
						// then this is a control-control conflict, not a refactoring of
						// a controlled unit
						if (other != null && !isControlControlConflict(rootMatch)) {
							result = rootMatch;
						}
					}
				}
			}
		}

		return result;
	}

	private boolean isControlControlConflict(Match rootMatch) {
		EObject origin = rootMatch.getOrigin();
		return origin instanceof InternalEObject && ((InternalEObject)origin).eDirectResource() == null;
	}

	/**
	 * Find the dependencies of a resource refactoring change and add them to its {@link Diff#getRequiredBy()
	 * requiredBy} list.
	 * 
	 * @param comparison
	 *            the contextual comparison
	 * @param rrc
	 *            a resource refactoring change
	 */
	protected void findDependencies(final Comparison comparison, final ResourceRefactoringChange rrc) {
		// This change is required by any change that moves objects into or out
		// of the new resource (on the the same side) or into or out of the old
		// resource (on the opposide side)
		class DependencySwitch extends CompareSwitch<URI> {
			@Override
			public URI caseResourceAttachmentChange(ResourceAttachmentChange object) {
				return URI.createURI(object.getResourceURI());
			}

			@Override
			public URI caseReferenceChange(ReferenceChange object) {
				if (object.getReference().isContainment()) {
					return object.getValue().eResource().getURI();
				}
				return null;
			}
		}

		DependencySwitch dep = new DependencySwitch();

		for (Diff next : comparison.getDifferences()) {
			URI nextURI = dep.doSwitch(next);
			if (nextURI != null) {
				if (next.getSource() == rrc.getSource()) {
					if (rrc.getNewURI().equals(nextURI)) {
						rrc.getRequiredBy().add(next);
					}
				} else if (rrc.getOldURI().equals(nextURI)) {
					rrc.getRequiredBy().add(next);
				}
			}
		}

	}

	/**
	 * Create a new conflict on a bunch of {@code diffs}.
	 * 
	 * @param comparison
	 *            the comparison in which to create the conflict
	 * @param diffs
	 *            the conflicting diffs
	 * @return the conflict
	 * @throws IllegalArgumentException
	 *             if there aren't at least two {@code diffs}
	 */
	protected Conflict conflict(Comparison comparison, Iterable<ResourceRefactoringChange> diffs) {
		if (Iterables.size(diffs) < 2) {
			throw new IllegalArgumentException("diffs.size() < 2"); //$NON-NLS-1$
		}

		Conflict result = CompareFactory.eINSTANCE.createConflict();
		EList<Diff> conflict = result.getDifferences();
		for (ResourceRefactoringChange next : diffs) {
			conflict.add(next.toDiff());
		}
		comparison.getConflicts().add(result);
		return result;
	}

	/**
	 * Prune out {@link ResourceAttachmentChange}s that aren't really RACs at all because they actually are
	 * staying within a refactored (moved/renamed) resource.
	 * 
	 * @param comparison
	 *            the contextual comparison
	 * @param monitor
	 *            a progress monitor
	 */
	protected void pruneRACsInRefactoredResources(Comparison comparison, Monitor monitor) {
		PapyrusResourceIndex index = PapyrusResourceIndex.index(comparison);

		Iterable<ResourceAttachmentChange> racs = filter(
				filter(comparison.getDifferences(), ResourceAttachmentChange.class),
				not(isResourceRefactoringChange())); // Don't prune out the RRCs, themselves!
		List<ResourceAttachmentChange> toPrune = Lists.newArrayList();

		for (ResourceAttachmentChange next : racs) {
			if (index.isInResourceRefactoring(next) && !isResourceRefactoringChange(next)) {
				toPrune.add(next);
			}
		}

		for (ResourceAttachmentChange next : toPrune) {
			// Infer conflicts for the ResourceRefactoringChange
			Conflict conflict = next.getConflict();
			if (conflict != null) {
				ResourceRefactoringChange rrc = getFirst(
						transform(filter(next.getMatch().getDifferences(), isResourceRefactoringChange()),
								ResourceRefactoringChange.get()),
						null);
				if (rrc != null) {
					Collections.replaceAll(conflict.getDifferences(), next, rrc.toDiff());
				}
			}

			delete(next);
		}
	}

	/**
	 * Delete an {@code object} from the comparison, taking advantage of the cross-referencers employed by the
	 * comparison for efficient removal of incoming references to the {@code object}.
	 * 
	 * @param object
	 *            the object to delete from the comparison
	 */
	static void delete(EObject object) {
		if (object instanceof Diff) {
			// First, delete any conflict and equivalence that depend on the diff
			Diff diff = (Diff)object;
			if (diff.getConflict() != null) {
				delete(diff.getConflict());
			}
			if (diff.getEquivalence() != null) {
				delete(diff.getEquivalence());
			}
		}

		// We always have the DiffCrossReferencer and/or the MatchCrossReferencer
		ECrossReferenceAdapter xrefs = ECrossReferenceAdapter.getCrossReferenceAdapter(object);
		if (xrefs != null) {
			// Do it the efficient way
			for (EStructuralFeature.Setting setting : xrefs.getInverseReferences(object)) {
				EcoreUtil.remove(setting, object);
			}
			EcoreUtil.remove(object);
		} else {
			// The expensive way
			EcoreUtil.delete(object);
		}
	}
}
