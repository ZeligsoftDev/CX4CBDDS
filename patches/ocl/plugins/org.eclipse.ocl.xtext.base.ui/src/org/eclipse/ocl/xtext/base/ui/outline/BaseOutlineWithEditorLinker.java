/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.outline;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker;
import org.eclipse.xtext.util.ITextRegion;

/**
 * BaseOutlineWithEditorLinker is they key class for mapping a text location to an outline node and
 * so to an AS/CS element.
 * <p>
 * The reverse CS/AS element to text location mapping is in BaseLocationInFileProvider.
 */
public class BaseOutlineWithEditorLinker extends OutlineWithEditorLinker
{
	public static final @NonNull TracingOption LOCATE = new TracingOption(
		BaseUiPluginHelper.PLUGIN_ID, "outline/locate"); //$NON-NLS-1$

	private static final Logger logger = LogManager.getLogger(BaseOutlineWithEditorLinker.class);

	private int depth = 0;

	@Override
	protected IOutlineNode findBestNode(IOutlineNode input, ITextRegion selectedTextRegion) {
		int savedDepth = depth++;
		try {
			if (depth > 100) {
				StringBuilder s = new StringBuilder();
				s.append("FindBest limit at ");
				ElementUtil.appendTextRegion(s, selectedTextRegion, true);
				s.append(" " + NameUtil.debugSimpleName(input));
				logger.error(s.toString());
				return null;
			}
			if (LOCATE.isActive()) {
				StringBuilder s = new StringBuilder();
				s.append("FindBest " + depth + " at "); // + ClassUtil.debugSimpleName(input));
				ElementUtil.appendTextRegion(s, selectedTextRegion, true);
				s.append(" for ");
				ElementUtil.appendTextRegion(s, input.getFullTextRegion(), false);
				s.append(" ");
				ElementUtil.appendTextRegion(s, input.getSignificantTextRegion(), true);
				s.append(" ");
				s.append(input);
				LOCATE.println(s.toString());
			}
			return super.findBestNode(input, selectedTextRegion);
		}
		finally {
			depth = savedDepth;
		}
	}
}
