/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css3.formatting2;

import java.util.List;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegions;

import com.google.common.collect.Lists;



/**
 * Workaround for Bug 493257: Override the default behavior for postProcess()
 *
 * The parent method adds whitespaces between all grammar elements, which changes the semantics in CSS
 *
 * @author Camille Letavernier
 *
 */
public abstract class AbstractCSSFormatter extends AbstractFormatter2 {

	/**
	 * @see org.eclipse.xtext.formatting2.AbstractFormatter2#postProcess(org.eclipse.xtext.formatting2.IFormattableDocument, java.util.List)
	 *
	 * @param document
	 * @param replacements
	 * @return
	 */
	@Override
	protected List<ITextReplacement> postProcess(IFormattableDocument document, List<ITextReplacement> replacements) {
		List<ITextSegment> expected = Lists.newArrayList();
		IHiddenRegion current = getTextRegionAccess().regionForRootEObject().getPreviousHiddenRegion();
		while (current != null) {
			if (current.isUndefined()) {
				expected.addAll(current.getMergedSpaces());
			}
			current = current.getNextHiddenRegion();
		}
		if (expected.isEmpty()) {
			return replacements;
		}
		List<ITextSegment> missing = TextRegions.difference(expected, replacements);
		if (missing.isEmpty()) {
			return replacements;
		}
		List<ITextReplacement> result = Lists.newArrayList(replacements);
		for (ITextSegment seg : missing) {
			IHiddenRegion h = null;
			if (seg instanceof IHiddenRegion) {
				h = (IHiddenRegion) seg;
			}
			if (seg instanceof IHiddenRegionPart) {
				h = ((IHiddenRegionPart) seg).getHiddenRegion();
			}
			if (h != null && (h.getNextSemanticRegion() == null || h.getPreviousSemanticRegion() == null)) {
				result.add(seg.replaceWith(""));
			} else {
				result.add(seg.replaceWith("")); // Bug 493257: The default method adds whitespaces everywhere. In CSS, Whitespaces are semantic grammar elements and can't be added randomly
			}
		}
		return result;
	}

}
