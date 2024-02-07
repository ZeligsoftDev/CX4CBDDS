/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

public class BaseDocumentationProvider extends MultiLineCommentDocumentationProvider
{
	@Override
	protected String findComment(EObject o) {
		if (o instanceof Element) {
			List<Comment> comments = ((Element)o).getOwnedComments();
			if (comments.size() > 0) {
				StringBuilder s = new StringBuilder();
				for (Comment comment : comments) {
					if (s.length() > 0) {
						s.append("\n");
					}
					s.append(comment.getBody());
				}
				if (s.length() > 0) {
					return s.toString();
				}
			}
		}
		return super.findComment(o);
	}
}
