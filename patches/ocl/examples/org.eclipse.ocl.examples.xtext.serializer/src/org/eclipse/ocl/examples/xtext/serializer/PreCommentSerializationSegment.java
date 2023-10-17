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
 * PreCommentSerializationSegment provides support for serializing and formatting typical
 * Xtext single and multi-line comments stored as leading hidden LeafNodes.
 */
public class PreCommentSerializationSegment extends AbstractCommentSerializationSegment
{
	@Override
	public void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder) {
		INode node = formatter.getNode();
		Iterable<@NonNull Comment> comments = getPreComments(formatter.getSerializationMetaData(), node);
		if (comments != null) {
			for (@NonNull Comment comment : comments) {
				comment.append(serializationBuilder);
			}
		}
	}

	@Override
	public void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
		INode node = getNode(serializationStepIndex, serializer);
		if (node != null) {//&& !(node instanceof RootNode)) {
			Iterable<@NonNull Comment> comments = getPreComments(serializer.getSerializationMetaData(), node);
			if (comments != null) {
				for (@NonNull Comment comment : comments) {
					comment.append(serializationBuilder);
				}
			}
		}
	}

	@Override
	public @NonNull String toString() {
		return SerializationBuilder.PRE_COMMENT;
	}
}
