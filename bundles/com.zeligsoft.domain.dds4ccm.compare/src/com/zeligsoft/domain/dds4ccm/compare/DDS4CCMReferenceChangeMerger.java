package com.zeligsoft.domain.dds4ccm.compare;

import static com.google.common.collect.Iterators.filter;
import static org.eclipse.emf.compare.utils.ReferenceUtil.safeEGet;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.internal.utils.DiffUtil;
import org.eclipse.emf.compare.uml2.internal.merge.UMLReferenceChangeMerger;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Iterators;

public class DDS4CCMReferenceChangeMerger extends UMLReferenceChangeMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @implNote This is identical to the implementation on {@link ReferenceChangeMerger} but
	 * we need it because we have to override the private method {@link #internalCheckOrdering(ReferenceChange, boolean)}
	 */
	@Override
	protected void checkImpliedDiffsOrdering(ReferenceChange diff, boolean rightToLeft) {
		final EReference reference = diff.getReference();
		final List<Diff> mergedImplications;
		if (isAccepting(diff, rightToLeft)) {
			mergedImplications = diff.getImplies();
		} else {
			mergedImplications = diff.getImpliedBy();
		}

		Iterator<Diff> impliedDiffs = mergedImplications.iterator();
		if (reference.isMany() && diff.getEquivalence() != null) {
			impliedDiffs = Iterators.concat(impliedDiffs, diff.getEquivalence().getDifferences().iterator());
		}
		final Iterator<ReferenceChange> impliedReferenceChanges = filter(impliedDiffs, ReferenceChange.class);

		while (impliedReferenceChanges.hasNext()) {
			final ReferenceChange implied = impliedReferenceChanges.next();
			if (implied != diff && isInTerminalState(implied)) {
				if (implied.getReference().isMany() && isAdd(implied, rightToLeft)) {
					internalCheckOrdering(implied, rightToLeft);
					checkImpliedDiffsOrdering(implied, rightToLeft);
				}
			}
		}
	}

	/**
	 * Checks a particular difference for the ordering of its target values. This will be used to double-check
	 * that equivalent differences haven't been "broken" by EMF by not preserving their value order.
	 * <p>
	 * Should only be used on <u>merged</u> differences which target <u>many-valued</u> references.
	 * </p>
	 * 
	 * @param diff
	 *            The diff that is to be checked.
	 * @param rightToLeft
	 *            Direction of the merge that took place.
	 */
	private void internalCheckOrdering(ReferenceChange diff, boolean rightToLeft) {
		final EStructuralFeature feature = diff.getReference();
		final EObject value = diff.getValue();
		final Match match = diff.getMatch();
		final Comparison comparison = match.getComparison();
		final Match valueMatch = comparison.getMatch(value); // It will be null for proxy objects!

		final EObject sourceContainer;
		final EObject targetContainer;
		final EObject newValue;
		if (rightToLeft) {
			sourceContainer = match.getRight();
			targetContainer = match.getLeft();
			newValue = valueMatch != null ? valueMatch.getLeft() : null;
		} else {
			sourceContainer = match.getLeft();
			targetContainer = match.getRight();
			newValue = valueMatch != null ? valueMatch.getRight() : null;
		}

		final List<Object> sourceList = ReferenceUtil.getAsList(sourceContainer, feature);
		final List<Object> targetList = ReferenceUtil.getAsList(targetContainer, feature);

		if (valueMatch != null) {
			final List<Object> lcs = DiffUtil.longestCommonSubsequence(comparison, sourceList, targetList);
			if (lcs.contains(valueMatch.getLeft()) || lcs.contains(valueMatch.getRight())) {
				// Ordering is correct on this one
				return;
			}
		}

		int insertionIndex = DiffUtil.findInsertionIndex(comparison, sourceList, targetList, value);
		if (insertionIndex >= 0) {
			/*
			 * We've used unresolving views of the eobject lists since we didn't know whether there was
			 * actually any work to do. Use the real list now.
			 */
			@SuppressWarnings("unchecked")
			final List<EObject> changedList = (List<EObject>)safeEGet(targetContainer, feature);
			if (changedList.size() > 1) {
				if (changedList instanceof EList<?>) {
					if (insertionIndex > changedList.size()) {
						((EList<EObject>)changedList).move(changedList.size() - 1, newValue);
					} else {
						((EList<EObject>)changedList).move(insertionIndex, newValue);
					}
				} else {
					changedList.remove(newValue);
					if (insertionIndex > changedList.size()) {
						changedList.add(newValue);
					} else {
						changedList.add(insertionIndex, newValue);
					}
				}
			}
		}
	}

}
