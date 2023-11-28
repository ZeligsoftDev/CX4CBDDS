/*******************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Christian W. Damus - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.edit.internal.decorator;

import static com.google.common.base.Preconditions.checkArgument;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.provider.utils.ComposedStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString.IComposedStyledString;
import org.eclipse.emf.compare.provider.utils.IStyledString.Style;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.papyrus.compare.uml2.internal.postprocessor.ResourceRefactoringChange;

/**
 * An item-provider decorator for {@link ResourceAttachmentChange}s that represent resource refactorings. The
 * diff is presented as the inverse change from the opposite side so that it may make sense that it is
 * rejected by implication of certain changes from that opposite side. Because, from the perspective of the
 * left side, that is what accepting this change would do.
 *
 * @author Christian W. Damus
 */
public class ResourceRefactoringChangeItemProviderDecorator extends ForwardingItemProviderDecorator {

	public ResourceRefactoringChangeItemProviderDecorator(ComposeableAdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Coerce a {@code diff} as a {@link ResourceRefactoringChange}.
	 * 
	 * @param diff
	 *            a resource refactoring diff
	 * @return the {@code diff} as its proper type
	 * @precondition {@code diff is-a} {@link ResourceRefactoringChange}
	 */
	protected ResourceRefactoringChange asResourceRefactoringChange(Object diff) {
		checkArgument(diff instanceof ResourceAttachmentChange, "%s is not a ResourceAttachmentChange", diff); //$NON-NLS-1$
		return ResourceRefactoringChange.get((Diff)diff);
	}

	/**
	 * Obtains the resource that was refactored in the given {@code diff}.
	 * 
	 * @param diff
	 *            a resource refactoring diff
	 * @return the refactored resource
	 * @precondition {@code diff is-a} {@link ResourceRefactoringChange}
	 */
	protected Resource getRefactoredResource(Object diff) {
		return getRefactoredResource(asResourceRefactoringChange(diff));
	}

	/**
	 * Obtains the resource that was refactored in the given {@code diff}.
	 * 
	 * @param diff
	 *            a resource refactoring diff
	 * @return the refactored resource
	 * @postcondition {@code result != null}
	 */
	protected Resource getRefactoredResource(ResourceRefactoringChange diff) {

		// We wouldn't have this diff if the match didn't have both left and right sides
		DifferenceSource side;
		if (diff.getState() == DifferenceState.DISCARDED) {
			side = diff.getSource();
		} else {
			side = opposite(diff.getSource());
		}
		Resource result = MatchUtil.getMatchedObject(diff.getMatch(), side).eResource();

		if (result == null) {
			throw new IllegalStateException("diff has no resource on its source side"); //$NON-NLS-1$
		}

		return result;
	}

	@Override
	public Object getImage(Object object) {
		ResourceRefactoringChange diff = asResourceRefactoringChange(object);
		Resource resource = getRefactoredResource(diff);

		Object result = getItemDelegator().getImage(resource);
		if (result == null) {
			result = super.getImage(diff);
		}

		// Invert the presentation
		ResourceAttachmentChange realDiff = diff.toDiff();
		boolean oldDeliver = realDiff.eDeliver();
		try {
			// Flip the direction to get the opposite decoration
			realDiff.eSetDeliver(false);
			realDiff.setSource(opposite(realDiff.getSource()));
			Object overlay = getOverlayProvider().getComposedImage(realDiff, result);

			result = overlayImage(object, overlay);
		} finally {
			// Restore the direction
			realDiff.setSource(opposite(realDiff.getSource()));
			realDiff.eSetDeliver(oldDeliver);
		}

		return result;
	}

	@Override
	public String getText(Object object) {
		return getStyledText(object).getString();
	}

	@Override
	public IComposedStyledString getStyledText(Object object) {
		final ResourceRefactoringChange diff = asResourceRefactoringChange(object);

		String value = getString("_UI_ResourceRefactoringChange_label", //$NON-NLS-1$
				new Object[] {getSemanticObjectLabel(diff.toDiff()) });

		final Style baseStyle;
		switch (diff.getState()) {
			case MERGED:
			case DISCARDED:
				baseStyle = Style.QUALIFIER_STYLER;
				break;
			default:
				baseStyle = Style.NO_STYLE;
				break;
		}
		ComposedStyledString result = new ComposedStyledString(value, baseStyle);

		// When the diff is rejected, we show the new URI, so present the decoration
		// with the old URI
		DifferenceSource decorationDirection = diff.getState() != DifferenceState.DISCARDED //
				? DifferenceSource.RIGHT
				: DifferenceSource.LEFT;
		switch (diff.getKind()) {
			case MOVE:
				switch (decorationDirection) {
					case RIGHT: // Invert the presentation
						result.append(getString("_UI_ResourceRefactoringChange_detailLeft", //$NON-NLS-1$
								new Object[] {diff.getNewURI() }), Style.DECORATIONS_STYLER);
						break;
					case LEFT: // Invert the presentation
						result.append(getString("_UI_ResourceRefactoringChange_detailRight", //$NON-NLS-1$
								new Object[] {diff.getOldURI() }), Style.DECORATIONS_STYLER);
						break;
					default:
						throw new IllegalArgumentException("diff side " + diff.getSource()); //$NON-NLS-1$
				}
				break;
			default:
				result.append(getString("_UI_ResourceRefactoringChange_detail", //$NON-NLS-1$
						new Object[] {diff.getNewURI() }), Style.DECORATIONS_STYLER);
				break;
		}

		return result;
	}

	@Override
	public String getSemanticObjectLabel(Object object) {
		return getItemDelegator().getText(getRefactoredResource(object));
	}

	@Override
	public String getDescription(Object object) {
		final ResourceRefactoringChange diff = asResourceRefactoringChange(object);
		String subject = getSemanticObjectLabel(diff);

		String action;
		switch (diff.getSource()) {
			case RIGHT: // Invert the presentation
				action = getString("_UI_ResourceRefactoringChange_desc_actionLeft"); //$NON-NLS-1$
				break;
			case LEFT: // Invert the presentation
				action = getString("_UI_ResourceRefactoringChange_desc_actionRight"); //$NON-NLS-1$
				break;
			default:
				throw new IllegalArgumentException("diff side " + diff.getSource()); //$NON-NLS-1$
		}

		// Invert the presentation
		return getString("_UI_ResourceRefactoringChange_desc", //$NON-NLS-1$
				new Object[] {subject, action, diff.getOldURI(), diff.getNewURI() });
	}

	static DifferenceSource opposite(DifferenceSource side) {
		return DifferenceSource.VALUES.get(1 - side.ordinal());
	}
}
