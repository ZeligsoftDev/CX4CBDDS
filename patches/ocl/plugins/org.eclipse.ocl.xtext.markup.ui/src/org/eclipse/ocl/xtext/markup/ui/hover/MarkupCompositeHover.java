/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.ui.hover;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextHover;
import org.eclipse.xtext.ui.editor.hover.AbstractCompositeHover;
import org.eclipse.xtext.ui.editor.hover.AnnotationWithQuickFixesHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;

import com.google.inject.Inject;

/**
 * This rewrite of DefaultCompositeHover reverses the precedence so that htmlHover showing the object declarations
 * takes precedence over problems, whose text is always visible on the edge markers.
 */
public class MarkupCompositeHover extends AbstractCompositeHover
{
	@Inject
	protected AnnotationWithQuickFixesHover annotationHover;

	/**
	 * @noreference This field is not intended to be referenced by clients.
	 */
	@Inject
	protected IEObjectHover htmlHover;

	@Override
	protected List<ITextHover> createHovers() {
		List<ITextHover> list = new ArrayList<ITextHover>();
		if (htmlHover instanceof ITextHover)
			list.add((ITextHover)htmlHover);
		list.add(annotationHover);
		return list;
	}
}
