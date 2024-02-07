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
package org.eclipse.ocl.examples.xtext.serializer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.nodemodel.INode;

/**
 * PostCommentSerializationSegment provides support for serializing and formatting typical
 * Xtext single and multi-line comments stored as trailing hidden LeafNodes.
 */
public class PostCommentSerializationSegment extends AbstractCommentSerializationSegment
{
	@Override
	public void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder) {
		INode node = formatter.getNode();
		Iterable<@NonNull Comment> comments = getPostComments(formatter.getSerializationMetaData(), node);
		if (comments != null) {
			for (@NonNull Comment comment : comments) {
				comment.append(serializationBuilder);
			}
		}
	}

	@Override
	public void serialize(int thisSerializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
		INode node = getNode(thisSerializationStepIndex, serializer);
		if (node != null) {
			Iterable<@NonNull Comment> comments = getPostComments(serializer.getSerializationMetaData(), node);
			if (comments != null) {
				for (@NonNull Comment comment : comments) {
					comment.append(serializationBuilder);
				}
			}
		}
	}

	@Override
	public @NonNull String toString() {
		return SerializationBuilder.POST_COMMENT;
	}
}
