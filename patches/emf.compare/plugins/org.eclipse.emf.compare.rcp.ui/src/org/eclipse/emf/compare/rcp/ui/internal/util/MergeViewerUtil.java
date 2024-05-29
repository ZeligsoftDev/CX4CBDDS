/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.util;

import static com.google.common.collect.Iterables.any;
import static org.eclipse.emf.compare.merge.AbstractMerger.isInTerminalState;

import com.google.common.base.Predicate;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.FeatureMapChange;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.internal.merge.IMergeData;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.internal.merge.MergeOperation;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IEMFCompareConfiguration;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.tree.TreeNode;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public final class MergeViewerUtil {

	private MergeViewerUtil() {
	}

	public static List<?> getValues(Diff diff, MergeViewerSide side) {
		Match ownerMatch = diff.getMatch();
		EObject eObject = getEObject(ownerMatch, side);
		EStructuralFeature affectedFeature = getAffectedFeature(diff);
		return ReferenceUtil.getAsList(eObject, affectedFeature);
	}

	public static List<?> getFeatureValues(Match match, EStructuralFeature feature, MergeViewerSide side) {
		final EObject eObject = getEObject(match, side);
		return ReferenceUtil.getAsList(eObject, feature);
	}

	public static EObject getEObject(Match match, MergeViewerSide side) {
		final EObject eObject;
		switch (side) {
			case ANCESTOR:
				eObject = match.getOrigin();
				break;
			case LEFT:
				eObject = match.getLeft();
				break;
			case RIGHT:
				eObject = match.getRight();
				break;
			default:
				throw new IllegalStateException();
		}
		return eObject;
	}

	public static EObject getBestSideEObject(Match match, MergeViewerSide side) {
		final MergeViewerSide[] sideLookupOrder;
		if (side == MergeViewerSide.ANCESTOR) {
			sideLookupOrder = new MergeViewerSide[] {MergeViewerSide.ANCESTOR, MergeViewerSide.LEFT,
					MergeViewerSide.RIGHT, };
		} else {
			sideLookupOrder = new MergeViewerSide[] {side, side.opposite(), MergeViewerSide.ANCESTOR, };
		}

		EObject objectOnSide = null;
		for (int i = 0; i < sideLookupOrder.length && objectOnSide == null; i++) {
			objectOnSide = MergeViewerUtil.getEObject(match, sideLookupOrder[i]);
		}
		return objectOnSide;
	}

	public static EStructuralFeature getAffectedFeature(Diff diff) {
		final EStructuralFeature feature;
		if (diff instanceof ReferenceChange) {
			feature = ((ReferenceChange)diff).getReference();
		} else if (diff instanceof AttributeChange) {
			feature = ((AttributeChange)diff).getAttribute();
		} else if (diff instanceof FeatureMapChange) {
			feature = ((FeatureMapChange)diff).getAttribute();
		} else {
			feature = null;
		}
		return feature;
	}

	/**
	 * Returns either {@link ReferenceChange#getValue()}, {@link AttributeChange#getValue()} or a
	 * {@link FeatureMapChange#getValue()} depending on the runtime type of the give {@code diff} or null
	 * otherwise.
	 * 
	 * @param diff
	 * @return
	 */
	public static Object getDiffValue(Diff diff) {
		final Object ret;
		if (diff instanceof ReferenceChange) {
			ret = ((ReferenceChange)diff).getValue();
		} else if (diff instanceof AttributeChange) {
			ret = ((AttributeChange)diff).getValue();
		} else if (diff instanceof FeatureMapChange) {
			Object entry = ((FeatureMapChange)diff).getValue();
			if (entry instanceof FeatureMap.Entry) {
				ret = ((FeatureMap.Entry)entry).getValue();
			} else {
				ret = null;
			}
		} else {
			ret = null;
		}
		return ret;
	}

	public static Object getValueFromDiff(final Diff diff, MergeViewerSide side) {
		Object diffValue = getDiffValue(diff);
		EStructuralFeature feature = getAffectedFeature(diff);
		Match ownerMatch = diff.getMatch();
		Object ret = matchingValue(diffValue, ownerMatch, feature, side, ownerMatch.getComparison());
		return ret;
	}

	private static Object matchingValue(Object object, Match ownerMatch, EStructuralFeature feature,
			MergeViewerSide side, Comparison comparison) {
		final Object ret;
		if (object instanceof EObject) {
			final Match matchOfValue = comparison.getMatch((EObject)object);
			if (matchOfValue != null) {
				ret = getEObject(matchOfValue, side);
			} else {
				ret = matchingValue(object, getFeatureValues(ownerMatch, feature, side), comparison);
			}
		} else {
			ret = matchingValue(object, getFeatureValues(ownerMatch, feature, side), comparison);
		}
		return ret;
	}

	private static Object matchingValue(Object value, List<?> in, Comparison comparison) {
		Object ret = null;
		IEqualityHelper equalityHelper = comparison.getEqualityHelper();
		Iterator<?> valuesIterator = in.iterator();
		while (valuesIterator.hasNext() && ret == null) {
			Object object = valuesIterator.next();
			if (equalityHelper.matchingValues(object, value)) {
				ret = object;
			}
		}
		return ret;
	}

	/**
	 * Returns the current resource on the given side of the given comparison.
	 * 
	 * @param comparison
	 *            The given comparison.
	 * @param side
	 *            The given side.
	 * @param diff
	 *            The given diff (a {@link ResourceAttachmentChange}.
	 * @return The current resource on the given side of the given comparison.
	 */
	public static Resource getResource(Comparison comparison, MergeViewerSide side, Diff diff) {
		if (!(diff instanceof ResourceAttachmentChange)) {
			return null;
		}
		Resource resource = getResourceViaMatch(side, (ResourceAttachmentChange)diff);

		if (resource == null) {
			resource = getResourceViaMatchResource(comparison, side, (ResourceAttachmentChange)diff);
		}

		return resource;
	}

	/**
	 * Returns the current resource on the given side of the given {@link ResourceAttachmentChange}. The
	 * resource is obtained via the match of the given {@link ResourceAttachmentChange}.
	 * 
	 * @param side
	 *            The given side.
	 * @param diff
	 *            The given {@link ResourceAttachmentChange}.
	 * @return The current resource on the given side of the given comparison.
	 */
	private static Resource getResourceViaMatch(MergeViewerSide side, ResourceAttachmentChange diff) {
		Resource resource = null;
		final Match match = diff.getMatch();
		switch (side) {
			case ANCESTOR:
				EObject origin = match.getOrigin();
				if (origin == null) {
					return null;
				}
				resource = ((InternalEObject)origin).eDirectResource();
				break;
			case LEFT:
				EObject left = match.getLeft();
				if (left == null) {
					return null;
				}
				resource = ((InternalEObject)left).eDirectResource();
				break;
			case RIGHT:
				EObject right = match.getRight();
				if (right == null) {
					return null;
				}
				resource = ((InternalEObject)right).eDirectResource();
				break;
			default:
				throw new IllegalStateException();
		}

		return resource;
	}

	/**
	 * Returns the current resource on the given side of the given {@link ResourceAttachmentChange}. The
	 * resource is obtained via the {@link MatchResource} that corresponds to the URI of the given
	 * {@link ResourceAttachmentChange}.
	 * 
	 * @param comparison
	 *            The given comparison.
	 * @param side
	 *            The given side.
	 * @param diff
	 *            The given {@link ResourceAttachmentChange}.
	 * @return The current resource on the given side of the given comparison.
	 */
	private static Resource getResourceViaMatchResource(Comparison comparison, MergeViewerSide side,
			ResourceAttachmentChange diff) {
		Resource resource = null;
		Collection<MatchResource> matchResources = comparison.getMatchedResources();
		String diffResourceURI = diff.getResourceURI();

		for (MatchResource matchResource : matchResources) {
			switch (side) {
				case ANCESTOR:
					resource = matchResource.getOrigin();
					break;
				case LEFT:
					resource = matchResource.getLeft();
					break;
				case RIGHT:
					resource = matchResource.getRight();
					break;
				default:
					throw new IllegalStateException();
			}
			if (resource != null && diffResourceURI != null) {
				URI resourceURI = resource.getURI();
				if (diffResourceURI.equals(resourceURI.toString())) {
					return resource;
				} else if (side == MergeViewerSide.RIGHT
						&& (diffResourceURI.equals(matchResource.getLeftURI())
								|| diffResourceURI.equals(matchResource.getOriginURI()))) {
					return resource;
				} else if (side == MergeViewerSide.LEFT
						&& (diffResourceURI.equals(matchResource.getRightURI())
								|| diffResourceURI.equals(matchResource.getOriginURI()))) {
					return resource;
				} else if (side == MergeViewerSide.ANCESTOR
						&& (diffResourceURI.equals(matchResource.getLeftURI())
								|| diffResourceURI.equals(matchResource.getRightURI()))) {
					return resource;
				}
			}
		}
		return resource;
	}

	/**
	 * Returns the contents of the current resource on the given side of the given comparison.
	 * 
	 * @param comparison
	 *            The given comparison.
	 * @param side
	 *            The given side.
	 * @return The contents of the current resource on the given side of the given comparison.
	 */
	public static List<EObject> getResourceContents(Comparison comparison, MergeViewerSide side, Diff diff) {
		Resource resource = getResource(comparison, side, diff);
		if (resource != null) {
			return resource.getContents();
		}
		return Collections.emptyList();

	}

	/**
	 * @param diff
	 * @param side
	 * @return
	 */
	public static Object getResourceAttachmentChangeValue(ResourceAttachmentChange diff,
			MergeViewerSide side) {
		final Object ret;
		Match match = diff.getMatch();
		switch (side) {
			case ANCESTOR:
				ret = match.getOrigin();
				break;
			case LEFT:
				ret = match.getLeft();
				break;
			case RIGHT:
				ret = match.getRight();
				break;
			default:
				throw new IllegalStateException();
		}
		return ret;
	}

	public static Object getValueFromResourceAttachmentChange(final ResourceAttachmentChange diff,
			Comparison comparison, MergeViewerSide side) {
		Object diffValue = getResourceAttachmentChangeValue(diff, side);
		Object ret = matchingValue(diffValue, comparison, side);
		return ret;
	}

	public static Object matchingValue(Object object, Comparison comparison, MergeViewerSide side) {
		final Object ret;
		if (object instanceof EObject) {
			final Match matchOfValue = comparison.getMatch((EObject)object);
			if (matchOfValue != null) {
				switch (side) {
					case ANCESTOR:
						ret = matchOfValue.getOrigin();
						break;
					case LEFT:
						ret = matchOfValue.getLeft();
						break;
					case RIGHT:
						ret = matchOfValue.getRight();
						break;
					default:
						throw new IllegalStateException();
				}
			} else {
				ret = matchingValue(object, comparison,
						getResourceContents(comparison, side, (ResourceAttachmentChange)object));
			}
		} else {
			ret = matchingValue(object, comparison, getResourceContents(comparison, side, null));
		}
		return ret;
	}

	public static Object matchingValue(Object value, Comparison comparison, List<?> in) {
		Object ret = null;
		IEqualityHelper equalityHelper = comparison.getEqualityHelper();
		Iterator<?> valuesIterator = in.iterator();
		while (valuesIterator.hasNext() && ret == null) {
			Object object = valuesIterator.next();
			if (equalityHelper.matchingValues(object, value)) {
				ret = object;
			}
		}
		return ret;
	}

	/**
	 * Returns true if the given diff is displayed in an group as provided by the {@code groupProvider} and
	 * not filtered by the given filter {@code predicate}.
	 * 
	 * @param diff
	 *            the {@link Diff} to check.
	 * @param groupProvider
	 *            the {@link IDifferenceGroupProvider}.
	 * @param predicate
	 *            the filter {@link Predicate}.
	 * @return {@code true} if the given {@code diff} is visible in the given {@code groupProvider},
	 *         {@code false} otherwise.
	 */
	public static boolean isVisibleInMergeViewer(Diff diff, IDifferenceGroupProvider groupProvider,
			Predicate<? super EObject> predicate) {
		Iterable<TreeNode> nodes = groupProvider.getTreeNodes(diff);
		return any(nodes, predicate);
	}

	/**
	 * Checks if the given diff is considered as a mark as merged diff.
	 * 
	 * @see MergeOperation
	 * @param diff
	 *            the given Diff.
	 * @param item
	 *            the given IMergeViewerItem associated with the diff.
	 * @param compareConfiguration
	 *            the compare configuration object to use with this viewer.
	 * @return true, if the given diff is considered as a mark as merged diff, false otherwise.
	 */
	public static boolean isMarkAsMerged(Diff diff, IMergeViewerItem item,
			IEMFCompareConfiguration compareConfiguration) {
		final boolean markAsMerged;
		if (isInTerminalState(diff)) {
			IMergeData mergeData = (IMergeData)EcoreUtil.getExistingAdapter(diff, IMergeData.class);
			if (mergeData != null) {
				boolean leftEditable = compareConfiguration.isLeftEditable();
				boolean rightEditable = compareConfiguration.isRightEditable();
				MergeMode mergeMode = MergeMode.getMergeMode(diff, leftEditable, rightEditable);
				MergeOperation mergeAction = mergeMode.getMergeAction(diff, leftEditable, rightEditable);
				if (mergeAction == MergeOperation.MARK_AS_MERGE) {
					markAsMerged = true;
				} else {
					markAsMerged = false;
				}
			} else {
				markAsMerged = false;
			}
		} else {
			markAsMerged = false;
		}
		return markAsMerged;
	}
}
