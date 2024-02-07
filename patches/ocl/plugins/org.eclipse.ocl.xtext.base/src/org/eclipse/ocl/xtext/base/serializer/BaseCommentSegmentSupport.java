/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.serializer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.CustomSegmentSupport;
import org.eclipse.ocl.examples.xtext.serializer.SerializationBuilder;
import org.eclipse.ocl.examples.xtext.serializer.UserElementFormatter;
import org.eclipse.ocl.examples.xtext.serializer.UserElementSerializer;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.Pivotable;

public class BaseCommentSegmentSupport implements CustomSegmentSupport
{
	protected @Nullable String prologue = "/**";
	protected @Nullable String indentation = " * ";
	protected @Nullable String epilogue = " */";

	/**
	 * To preserve legacy testing functionality, empty comments use an abbreviated one line form. The following
	 * reserved string serves to distinguish the empty case from the no-comment case.
	 */
	private static final @NonNull String EMPTY_COMMENT = "/**/";

	protected void appendComment(@NonNull SerializationBuilder serializationBuilder, @NonNull String comment) {
		serializationBuilder.append(SerializationBuilder.HALF_NEW_LINE);
		if (comment == EMPTY_COMMENT) {		// NB == rather than equals() for private instance
			serializationBuilder.append(EMPTY_COMMENT);
		}
		else {
			serializationBuilder.append(prologue);
			serializationBuilder.append(SerializationBuilder.PUSH_NEXT);
			serializationBuilder.append(indentation);
			boolean hasLeadingNewLine = false;
			for (int start = 0; true; ) {
				int index = comment.indexOf('\n', start);
				if (index >= 0) {
					if (!hasLeadingNewLine) {
						hasLeadingNewLine = true;
						serializationBuilder.append(SerializationBuilder.NEW_LINE);
					}
					String line = comment.substring(start, index);
					assert line != null;
					serializationBuilder.append(line);
					serializationBuilder.append(SerializationBuilder.NEW_LINE);
					start = index+1;
				}
				else {
					if (!hasLeadingNewLine) {
						serializationBuilder.append(" ");
					}
					String line = comment.substring(start, comment.length());
					assert line != null;
					serializationBuilder.append(line);
					break;
				}
			}
			serializationBuilder.append(SerializationBuilder.POP);
			if (hasLeadingNewLine) {
				serializationBuilder.append(SerializationBuilder.NEW_LINE);
			}
			serializationBuilder.append(epilogue);
		}
		serializationBuilder.append(SerializationBuilder.NEW_LINE);
	}

	@Override
	public void format(@NonNull UserElementFormatter fomatter, @NonNull SerializationBuilder serializationBuilder) {
		EObject eObject = fomatter.getElement();
		Iterable<@NonNull String> comments = getComments(eObject);
		if (comments != null) {
			for (String comment : comments) {
				appendComment(serializationBuilder, comment);
			}
		}
	}

	public @Nullable Iterable<@NonNull String> getComments(@NonNull EObject eObject) {
		if (eObject instanceof Pivotable) {
			Element asElement = ((Pivotable)eObject).getPivot();
			if (asElement != null) {
				List<Comment> ownedComments = asElement.getOwnedComments();
				if (!ownedComments.isEmpty()) {
					List<@NonNull String> comments = new ArrayList<>();
					for (Comment asComment: ownedComments) {
						String body = asComment.getBody();
						comments.add(body != null ? body : EMPTY_COMMENT);
					}
					return comments;
				}
			}
		}
		return null;
	}

	@Override
	public void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
		EObject eObject = serializer.getElement();
		Iterable<@NonNull String> comments = getComments(eObject);
		if (comments != null) {
			for (String comment : comments) {
				appendComment(serializationBuilder, comment);
			}
		}
	}
}
