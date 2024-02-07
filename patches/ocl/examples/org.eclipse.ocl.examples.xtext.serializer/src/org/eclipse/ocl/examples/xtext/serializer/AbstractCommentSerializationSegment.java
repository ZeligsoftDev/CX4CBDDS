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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.serializer.SerializationSegment.AbstractSerializationSegment;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;

/**
 * AbstractCommentSerializationSegment provides support for serializing and formatting typical
 * Xtext single and multi-line comments stored as hidden LeafNodes.
 */
public abstract class AbstractCommentSerializationSegment extends AbstractSerializationSegment
{
	public static abstract class Comment
	{
		protected final @NonNull HiddenLeafNode node;
		protected final @NonNull String body;

		protected Comment(@NonNull HiddenLeafNode node, @NonNull String body) {
			this.node = node;
			this.body = body;
		}

		public abstract void append(@NonNull SerializationBuilder serializationBuilder);

		public @NonNull HiddenLeafNode getNode() {
			return node;
		}

		@Override
		public String toString() {
			return "\"" + Strings.convertToJavaString(body) + "\"";
		}
	}

	public static class MultipleLineComment extends Comment
	{
		protected final @NonNull String prefix;
		protected final @NonNull String suffix;
		protected final @Nullable String midfix;

		public MultipleLineComment(@NonNull HiddenLeafNode node, @NonNull String prefix, @NonNull String body, @NonNull String suffix, @Nullable String midfix) {
			super(node, body);
			this.prefix = prefix;
			this.suffix = suffix;
			this.midfix = midfix;
		}

		@Override
		public void append(@NonNull SerializationBuilder serializationBuilder) {
			serializationBuilder.append(SerializationBuilder.HALF_NEW_LINE);
			serializationBuilder.append(prefix);
			if (midfix != null) {
				serializationBuilder.append(SerializationBuilder.PUSH_NEXT);
				serializationBuilder.append(midfix);
			}
			for (int start = 0; true; ) {
				int index = body.indexOf('\n', start);
				String line = body.substring(start, index >= 0 ? index : body.length());
				assert line != null;
				serializationBuilder.append(line);
				if (index >= 0) {
					serializationBuilder.append(SerializationBuilder.NEW_LINE);
					start = index+1;
				}
				else {
					break;
				}
			}
			if (midfix != null) {
				serializationBuilder.append(SerializationBuilder.POP);
			}
			if (body.endsWith("\n")) {
				serializationBuilder.append(" ");
			}
			serializationBuilder.append(suffix);
			serializationBuilder.append(SerializationBuilder.NEW_LINE);
		}
	}

	public static class SingleLineComment extends Comment
	{
		protected final @NonNull String prefix;

		public SingleLineComment(@NonNull HiddenLeafNode node, @NonNull String prefix, @NonNull String body) {
			super(node, body);
			this.prefix = prefix;
		}

		@Override
		public void append(@NonNull SerializationBuilder serializationBuilder) {
			serializationBuilder.append(SerializationBuilder.SOFT_SPACE);
			serializationBuilder.append(prefix);
			serializationBuilder.append(body);
			serializationBuilder.append(SerializationBuilder.SOFT_NEW_LINE);
		}
	}

	protected @NonNull Comment createMultipleLineComment(@NonNull String prefix, @NonNull String suffix, @NonNull HiddenLeafNode node, @Nullable String midfix) {
		String text = node.getText().replace("\r", "");
		String trimmedText = text.trim();
		String contentString = trimmedText.substring(2, trimmedText.length());
		StringBuilder s = new StringBuilder();
		String[] strings = contentString.split("\n");
		for (int line = 0; line < strings.length; line++) {
			String string = strings[line];
			if (line > 0) {
				s.append("\n");
			}
			if (line >= strings.length-1) {		// last line
				string = string.substring(0, string.length()-2);	// strip the */
				if (string.equals(" ")) {
					string = "";									// and aslo a residual space
				}
			}
			if ((line > 0) && string.startsWith(" *")) {							// also strip a *
				s.append(string.substring(2));
			}
			else {
				s.append(string);
			}
		}
		String netString = s.toString();
		assert netString != null;
		return new MultipleLineComment(node, prefix, netString, suffix, midfix);
	}

	protected @NonNull Comment createSingleLineComment(@NonNull String prefix, @NonNull HiddenLeafNode node) {
		assert prefix != null;
		String text = node.getText().replace("\r", "");
		String trimmedText = text.trim();
		String contentString = trimmedText.substring(prefix.length());
		assert contentString != null;
		return new SingleLineComment(node, prefix, contentString);
	}

	protected boolean endsinNewLine(@NonNull HiddenLeafNode node) {
		String text = node.getText();
		int length = text.length();
		int iFinish = length;
		while (0 < iFinish) {
			char c = text.charAt(--iFinish);
			if (c == '\n') {
				return true;
			}
			else if (Character.isWhitespace(c)) {
				// continue
			}
			else {
				return false;
			}
		}
		return false;
	}

	protected INode getNode(int serializationStepIndex, @NonNull UserElementSerializer serializer) {
		SerializationRule serializationRule = serializer.getSerializationRule();
		@NonNull SerializationStep[] serializationSteps = serializationRule.getSerializationSteps();
		SerializationStep serializationStep = serializationSteps[serializationStepIndex];
		EObject eObject = serializer.getElement();
		ICompositeNode node = NodeModelUtils.getNode(eObject);
		if (node != null) {
			if (serializationStep.matches(node, serializer)) {
				return node;
			}
			for (@NonNull INode childNode : SerializationUtils.getChildren(node)) {
				if (serializationStep.matches(childNode, serializer)) {		// FIXME repeat counts
					return childNode;
				}
			}
		}
		return null;
	}

	/**
	 * Return the non -ve prefixes/suffizes index if node is a multiple line comment, or -ve if not a comment.
	 */
	protected int isMultipleLineComment(@NonNull String @NonNull [] prefixes, @NonNull String @NonNull [] suffixes, @NonNull HiddenLeafNode node) {
		assert prefixes.length == suffixes.length;
		String text = node.getText();
		int length = text.length();
		for (int iStart1 = 0; iStart1 < length; iStart1++) {
			char c1 = text.charAt(iStart1);
			if (!Character.isWhitespace(c1)) {
				for (int index = 0; index < prefixes.length; index++) {
					String prefix = prefixes[index];
					if (text.startsWith(prefix, iStart1)) {
						int iStart2 = iStart1 + prefix.length();
						String suffix = suffixes[index];
						int suffixLength = suffix.length();
						for (int iFinish = length-1; iStart2 < iFinish; iFinish--) {
							char c2 = text.charAt(iFinish);
							if (!Character.isWhitespace(c2)) {
								if (text.startsWith(suffix, iFinish + 1 - suffixLength)) {
									return index;
								}
								break;
							}
						}
						return -1;
					}
				}
				break;
			}
		}
		return -1;
	}

	/**
	 * Return the non-null prefix if node is a single line comment
	 * or null if not a single line commemt,
	 */
	protected @Nullable String isSingleLineComment(@NonNull String @NonNull [] prefixes, @NonNull HiddenLeafNode node) {
		String text = node.getText();
		int length = text.length();
		for (int iStart = 0; iStart < length; iStart++) {
			char c = text.charAt(iStart);
			if (!Character.isWhitespace(c)) {
				for (int index = 0; index < prefixes.length; index++) {
					String prefix = prefixes[index];
					if (text.startsWith(prefix, iStart)) {
						return prefix;
					}
				}
				break;
			}
		}
		return null;
	}

	protected @Nullable List<@NonNull Comment> getPostComments(@NonNull SerializationMetaData serializationMetaData, @NonNull INode node) {
	//	showSiblings("Post", node);
		@NonNull String[] singleLineCommentPrefixes = serializationMetaData.getSingleLineCommentPrefixes();
		@SuppressWarnings("unused") String text = node.getText();
		List<@NonNull Comment> comments = null;
		SerializationUtils.NodeIterator nodeIterator = new SerializationUtils.NodeIterator(node);
		nodeIterator.next();
		while (nodeIterator.hasNext()) {
			INode nextNode = nodeIterator.next();
			if (nextNode instanceof ILeafNode) {
				if (!(nextNode instanceof HiddenLeafNode)) {
					break;
				}
				HiddenLeafNode leafNode = (HiddenLeafNode)nextNode;
				String leafText = leafNode.getText();
				Comment comment = null;
				String prefix;
				if ((singleLineCommentPrefixes != null) && ((prefix = isSingleLineComment(singleLineCommentPrefixes, leafNode)) != null)) {
					comment = createSingleLineComment(prefix, leafNode);
					if (comments == null) {
						comments = new ArrayList<>();
					}
					comments.add(comment);
					if (leafText.contains("\n")) {		// New line separates post/pre comments unless comments on outer root
						break;
					}
				}
				else if (leafText.contains("\n")) {		// New line separates post/pre comments unless comments on outer root
					if (!(node.getParent() instanceof RootNode)) {
				//		break;
					}
					SerializationUtils.NodeIterator tailIterator = new SerializationUtils.NodeIterator(nodeIterator);
					ILeafNode tailNode = null;
					while (tailIterator.hasNext()) {
						INode nextNode2 = tailIterator.next();
						if (nextNode2 instanceof ILeafNode) {
							ILeafNode leafNode2 = (ILeafNode)nextNode2;
							if (!leafNode2.isHidden()) {
								tailNode = leafNode2;
								break;
							}
						}
					}
					if (tailNode != null) {
						break;
					}
				}
			}
		}
	//	assert nodeIterator.nextLeaf() == null;
		return comments;
	}

	protected @Nullable List<@NonNull Comment> getPreComments(@NonNull SerializationMetaData serializationMetaData, @NonNull INode node) {
//		showSiblings("Pre", node);
		@NonNull String[] singleLineCommentPrefixes = serializationMetaData.getSingleLineCommentPrefixes();
		@Nullable String[] multipleLineCommentMidfixes = serializationMetaData.getMultipleLineCommentMidfixes();
		@NonNull String[] multipleLineCommentPrefixes = serializationMetaData.getMultipleLineCommentPrefixes();
		@NonNull String[] multipleLineCommentSuffixes = serializationMetaData.getMultipleLineCommentSuffixes();
		@SuppressWarnings("unused") String text = node.getText();
		List<@NonNull Comment> comments = null;
		for (INode prevNode = node; (prevNode = prevNode.getPreviousSibling()) instanceof HiddenLeafNode; ) {
			HiddenLeafNode leafNode = (HiddenLeafNode) prevNode;
			@SuppressWarnings("unused") String leafText = leafNode.getText();
			Comment comment = null;
			int index;
			String prefix;
			if ((multipleLineCommentPrefixes != null) && (multipleLineCommentSuffixes != null) && (multipleLineCommentMidfixes != null)
					&& ((index = isMultipleLineComment(multipleLineCommentPrefixes, multipleLineCommentSuffixes, leafNode)) >= 0)) {
				comment = createMultipleLineComment(multipleLineCommentPrefixes[index], multipleLineCommentSuffixes[index], leafNode, multipleLineCommentMidfixes[index]);
			}
			else if ((singleLineCommentPrefixes != null) && ((prefix = isSingleLineComment(singleLineCommentPrefixes, leafNode)) != null)) {
				if (leafNode.getOffset() <= 0)  {
					comment = createSingleLineComment(prefix, leafNode);
				}
				else {
					for (INode prevPrevNode = prevNode; (prevPrevNode = prevPrevNode.getPreviousSibling()) instanceof HiddenLeafNode; ) {
						@SuppressWarnings("unused") String prevText = prevPrevNode.getText();
						HiddenLeafNode prevLeafNode = (HiddenLeafNode) prevPrevNode;
						if ((multipleLineCommentPrefixes != null) && (multipleLineCommentSuffixes != null)
								&& ((index = isMultipleLineComment(multipleLineCommentPrefixes, multipleLineCommentSuffixes, prevLeafNode)) >= 0)) {
							break;
						}
						if (endsinNewLine(prevLeafNode)) {
							comment = createSingleLineComment(prefix, leafNode);
							break;
						}
					}
				}
			}
			if (comment != null) {
				if (comments == null) {
					comments = new ArrayList<>();
				}
				comments.add(0, comment);
			}
		}
		return comments;
	}

	protected void showSiblings(String string, @NonNull ICompositeNode node) {
		StringBuilder s = new StringBuilder();
		s.append(string);
		s.append(" - ");
/*		s.append(node.getClass().getSimpleName());
		s.append("@");
		s.append(Integer.toHexString(System.identityHashCode(node)));
		s.append(" - \"");
		s.append(Strings.convertToJavaString(node.getText()));
		s.append("\"");
*/		ICompositeNode parent = node.getParent();
		s.append("parent\t");
		if (parent != null) {
			s.append(parent.getClass().getSimpleName());
			s.append("@");
			s.append(Integer.toHexString(System.identityHashCode(parent)));
			s.append(" - \"");
			s.append(Strings.convertToJavaString(parent.getText()));
			s.append("\"");
		}
		INode previousSibling = node.getPreviousSibling();
		if (previousSibling != null) {
			showPreSiblings(s, previousSibling);
		}
		s.append("\n\there\t");
		s.append(node.getClass().getSimpleName());
		s.append("@");
		s.append(Integer.toHexString(System.identityHashCode(node)));
		s.append(" - \"");
		s.append(Strings.convertToJavaString(node.getText()));
		s.append("\"");
		for (INode siblingNode = node; (siblingNode = siblingNode.getNextSibling()) != null; ) {
			if (siblingNode instanceof ILeafNode) {
				s.append("\n\tnext\t");
				s.append(siblingNode.getClass().getSimpleName());
				s.append("@");
				s.append(Integer.toHexString(System.identityHashCode(siblingNode)));
				s.append(" - \"");
				s.append(Strings.convertToJavaString(siblingNode.getText()));
				s.append("\"");
			}
		}
		System.out.println(s.toString());
	}

	protected void showPreSiblings(StringBuilder s, INode node) {
		INode siblingNode = node.getPreviousSibling();
		if (siblingNode != null) {
			showPreSiblings(s, siblingNode);
		}
		s.append("\n\tprev\t");
		s.append(node.getClass().getSimpleName());
		s.append("@");
		s.append(Integer.toHexString(System.identityHashCode(node)));
		s.append(" - \"");
		s.append(Strings.convertToJavaString(node.getText()));
		s.append("\"");
	}
}
