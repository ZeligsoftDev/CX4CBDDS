/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.formatting.impl.AbstractNodeModelFormatter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import com.google.inject.Inject;

/**
 * A DeclarativeFormatter uses the grammar-specific SerializationMetaData derived from the *.xtext parsing grammar and *.idioms formatting idioms
 * to drive a re-synthesis of the whitespace in an Inode range of the user document. The re-synthesis traverses the INode tree to ensure that its
 * structure is preserved. ParserRules and comments are determined by the INodes.
 */
public class DeclarativeFormatter extends AbstractNodeModelFormatter
{
	/**
	 * The UserModelAnalysis provides the SerializationMetaData that defines comment and rule formatting instructions.
	 */
	@Inject
	private @NonNull UserModelAnalysis modelAnalysis;

	/**
	 * The SerializationBuilder aggregates the formatted text..
	 */
	@Inject
	private @NonNull SerializationBuilder serializationBuilder;

	@Override
	public IFormattedRegion format(ICompositeNode root, int selectStart, int selectLength) {
		assert root != null;
		int selectEnd = selectStart+selectLength;
		//
		//	Find selected node range.
		//
/*		XtextAbstractCommentSegmentSupport xtextCommentSegmentSupport = new XtextCommentSegmentSupport();
		SerializationMetaData serializationMetaData = modelAnalysis.getSerializationMetaData();
		List<@NonNull Comment> preComments = xtextCommentSegmentSupport.getPreComments(serializationMetaData, startNode);
		List<@NonNull Comment> postComments = xtextCommentSegmentSupport.getPostComments(serializationMetaData, endNode);
		if ((preComments != null) && (preComments.size() > 0)) {
			newStart = preComments.get(0).getNode().getOffset();
		}
		if ((postComments != null) && (postComments.size() > 0)) {
			newStart = postComments.get(postComments.size()-1).getNode().getEndOffset();
		} */
		ILeafNode startNode = NodeModelUtils.findLeafNodeAtOffset(root, selectStart);
		assert startNode != null;
		ILeafNode endNode = selectLength > 0 ? NodeModelUtils.findLeafNodeAtOffset(root, selectEnd) : startNode;
		assert endNode != null;
		String oldText = root.getText();
		int oldStart = startNode.getTotalOffset();
		int oldEnd = endNode.getTotalEndOffset();
		@SuppressWarnings("unused") String oldSelectedText = oldText.substring(selectStart, selectEnd);
		@SuppressWarnings("unused") String oldNodeText = oldText.substring(oldStart, oldEnd);
		//
		//	Condition the insertion site to follow a new-line else follow all whitespace.
		//
		boolean oldFollowsNewLine = false;
		for (; oldStart < oldEnd; oldStart++) {		// Step to first non-whitespace character
			char c = oldText.charAt(oldStart);
			if (!Character.isWhitespace(c)) {
				break;
			}
		}
		for (int i = oldStart; i > 0; --i) {		// Step to first preceding new-line / non-whitespace character
			char c = oldText.charAt(i-1);
			if (c == '\n') {
				oldStart = i;
				oldFollowsNewLine = true;
			}
			else if (!Character.isWhitespace(c)) {
				break;
			}
		}
		//
		//	Condition the insertion site to precede a new-line else follow all whitespace.
		//
		boolean oldPrecedesNewLine = false;
		for (; oldStart < oldEnd; --oldEnd) {		// Step to past last non-whitespace character
			char c = oldText.charAt(oldEnd-1);
			if (!Character.isWhitespace(c)) {
				break;
			}
		}
		for (int i = oldEnd; oldStart < i; i++) {	// Step to last following new-line / non-whitespace character
			char c = oldText.charAt(i);
			if (c == '\n') {
				oldEnd = i;
				oldPrecedesNewLine = true;
			}
			else if (!Character.isWhitespace(c)) {
				break;
			}
		}
		@SuppressWarnings("unused") String oldConditionedText = oldText.substring(oldStart, oldEnd);
	//	EObject rootEObject = NodeModelUtils.findActualSemanticObjectFor(root);
	//	assert rootEObject != null;
	//	modelAnalysis.analyze(rootEObject);	-- SerializationRules not used
		//
		//	Format the selected nodes with globally consistent surrounding whitepace.
		//
		Stack<@NonNull INode> startNodeStack = new Stack<>();
		for (INode node = startNode; node != null; node = node.getParent()) {
			startNodeStack.push(node);
		}
		boolean hasEnded = formatAncestry(startNodeStack, endNode);
		assert hasEnded;
		String newText = serializationBuilder.toString();
		int newStart = 0;
		int newEnd = newText.length();
		//
		//	Condition the new text to follow a new-line else follow all whitespace.
		//
		if (!oldFollowsNewLine) {
			for (; newStart < newEnd; newStart++) {		// Step to first non-whitespace character
				char c = newText.charAt(newStart);
				if (!Character.isWhitespace(c)) {
					break;
				}
			}
		}
		//
		//	Condition the new text to precede a new-line else precede all whitespace.
		//
		if (!oldPrecedesNewLine) {
			for (; newStart < newEnd; newEnd--) {		// Step to first non-whitespace character
				char c = newText.charAt(newEnd-1);
				if (!Character.isWhitespace(c)) {
					break;
				}
			}
		}
		String newConditionedText = newText.substring(newStart, newEnd);
		return new FormattedRegion(newStart, newEnd - newStart, newConditionedText);
	}

	/**
	 * Format all nodes between and including startNode and endNode with surrounding whitespace as if
	 * no other outside nodes existed.
	 */
	protected boolean formatAncestry(@NonNull Stack<@NonNull INode> startNodeStack, @NonNull ILeafNode endNode) {
		ICompositeNode parentStartNode = (ICompositeNode) startNodeStack.pop();
		INode childStartNode = startNodeStack.peek();
		EObject semanticElement = parentStartNode.getSemanticElement();
		assert semanticElement != null;
		AbstractElement compoundedGrammarElement = getCompoundedGrammarElement(parentStartNode);
		UserElementFormatter elementFormatter = modelAnalysis.createUserElementFormatter(parentStartNode, compoundedGrammarElement, semanticElement);
		//
		//	Format the preceding whitespace for the excluded ancestry.
		//
		for (@NonNull SerializationSegment formattingSegment : elementFormatter.getInnerFormattingSegments()) {
			if (formattingSegment.isValue()) {
				break;
			}
			if (formattingSegment.isControl()) {
				formattingSegment.format(elementFormatter, serializationBuilder);
			}
		}
		//
		//	Format the included node range.
		//
		boolean hasStarted = false;
		boolean hasEnded = false;
		for (@NonNull INode childNode : SerializationUtils.getChildren(parentStartNode)) {
			if (!hasStarted && (childNode == childStartNode)) {
				hasStarted = true;
				if (childStartNode instanceof ICompositeNode) {
					hasEnded = formatAncestry(startNodeStack, endNode);
				}
				else {
					hasEnded = formatNode(childNode, hasStarted, endNode);
				}
			}
			else {
				hasEnded = formatNode(childNode, hasStarted, endNode);
			}
			if (hasEnded) {
				break;
			}
		}
		assert hasStarted;
		//
		//	Format the trailing whitespace for the excluded ancestry.
		//
		boolean isTail = false;
		for (@NonNull SerializationSegment formattingSegment : elementFormatter.getInnerFormattingSegments()) {
			if (!isTail) {
				if (formattingSegment.isValue()) {
					isTail = true;;
				}
			}
			else {
				if (formattingSegment.isControl()) {
					formattingSegment.format(elementFormatter, serializationBuilder);
				}
			}
		}
		return hasEnded;
	}

	protected boolean formatCompositeNode(@NonNull ICompositeNode compositeNode, boolean hasStarted, @NonNull ILeafNode endNode) {
		String text = compositeNode.getText();
		assert text != null;
		EObject semanticElement = compositeNode.getSemanticElement();
		assert semanticElement != null;
		AbstractElement compoundedGrammarElement = getCompoundedGrammarElement(compositeNode);
		EList<?> assignedCollection = getAssignedCollection(compositeNode, compoundedGrammarElement);
		UserElementFormatter elementFormatter = modelAnalysis.createUserElementFormatter(compositeNode, compoundedGrammarElement, semanticElement);
		//
		//	Different previous assigned collection requires outer head formatting.
		//
		EList<?> prevAssignedCollection = null;
		if (assignedCollection != null) {
			INode prevSibling = compositeNode.getPreviousSibling();
			if (prevSibling instanceof ICompositeNode) {
				prevAssignedCollection = getAssignedCollection((ICompositeNode)prevSibling, getCompoundedGrammarElement(prevSibling));
			}
		}
		if ((assignedCollection == null) || (assignedCollection != prevAssignedCollection)) {
			@NonNull SerializationSegment [] outerFormattingSegments = elementFormatter.getOuterFormattingSegments();
			for (@NonNull SerializationSegment formattingSegment : outerFormattingSegments) {
				if (formattingSegment.isValue()) {
					break;
				}
				formattingSegment.format(elementFormatter, serializationBuilder);
			}
		}
		//
		//	Inner formatting of the specific node.
		//
		boolean hasEnded = false;
		@NonNull SerializationSegment[] innerFormattingSegments = elementFormatter.getInnerFormattingSegments();
		for (@NonNull SerializationSegment formattingSegment : innerFormattingSegments) {
			if (formattingSegment.isValue()) {
				for (@NonNull INode childNode : SerializationUtils.getChildren(compositeNode)) {
					if (formatNode(childNode, hasStarted, endNode)) {
						hasEnded = true;
						break;
					}
				}
			}
			else if (hasStarted) {
				formattingSegment.format(elementFormatter, serializationBuilder);
			}
		}
		//
		//	Different next assigned collection requires outer tail formatting.
		//
		EList<?> nextAssignedCollection = null;
		if (assignedCollection != null) {
			INode nextSibling = compositeNode.getNextSibling();
			if (nextSibling instanceof ICompositeNode) {
				nextAssignedCollection = getAssignedCollection((ICompositeNode)nextSibling, getCompoundedGrammarElement(nextSibling));
			}
		}
		if ((assignedCollection == null) || (assignedCollection != nextAssignedCollection)) {
			boolean isTail = false;
			@NonNull SerializationSegment [] outerFormattingSegments = elementFormatter.getOuterFormattingSegments();
			for (@NonNull SerializationSegment formattingSegment : outerFormattingSegments) {
				if (!isTail) {
					if (formattingSegment.isValue()) {
						isTail = true;;
					}
				}
				else {
					formattingSegment.format(elementFormatter, serializationBuilder);
				}
			}
		}
		return hasEnded;
	}

	protected void formatLeafNode(@NonNull ILeafNode leafNode, boolean hasStarted) {
		String text = leafNode.getText();
		assert text != null;
		if (!leafNode.isHidden()) {
			EObject semanticElement = leafNode.getSemanticElement();
			assert semanticElement != null;
			AbstractElement compoundedGrammarElement = getCompoundedGrammarElement(leafNode);
			UserElementFormatter elementFormatter = modelAnalysis.createUserElementFormatter(leafNode, compoundedGrammarElement, semanticElement);
			//
			//	Different previous grammar element requires outer head formatting.
			//
			for (INode prevSibling = leafNode.getPreviousSibling(); (prevSibling == null) || (prevSibling instanceof ILeafNode); prevSibling = prevSibling.getPreviousSibling()) {
				if ((prevSibling == null) || !((ILeafNode)prevSibling).isHidden()) {
					AbstractElement prevCompoundedGrammarElement = prevSibling != null ? getCompoundedGrammarElement(prevSibling) : null;
					if (compoundedGrammarElement != prevCompoundedGrammarElement) {
						@NonNull SerializationSegment [] outerFormattingSegments = elementFormatter.getOuterFormattingSegments();
						for (@NonNull SerializationSegment formattingSegment : outerFormattingSegments) {
							if (formattingSegment.isValue()) {
								break;
							}
							formattingSegment.format(elementFormatter, serializationBuilder);
						}
					}
					break;
				}
			}
			//
			//	Inner formatting of the specific node.
			//
			@NonNull
			SerializationSegment[] innerFormattingSegments = elementFormatter.getInnerFormattingSegments();
			for (@NonNull SerializationSegment formattingSegment : innerFormattingSegments) {
				if (hasStarted || formattingSegment.isControl()) {
					formattingSegment.format(elementFormatter, serializationBuilder);
				}
			}
			//
			//	Different next grammar element requires outer tail formatting.
			//
			for (INode nextSibling = leafNode.getNextSibling(); (nextSibling == null) || (nextSibling instanceof ILeafNode); nextSibling = nextSibling.getNextSibling()) {
				if ((nextSibling == null) || !((ILeafNode)nextSibling).isHidden()) {
					AbstractElement nextCompoundedGrammarElement = nextSibling != null ? getCompoundedGrammarElement(nextSibling) : null;
					if (compoundedGrammarElement != nextCompoundedGrammarElement) {
						boolean isTail = false;
						@NonNull SerializationSegment [] outerFormattingSegments = elementFormatter.getOuterFormattingSegments();
						for (@NonNull SerializationSegment formattingSegment : outerFormattingSegments) {
							if (!isTail) {
								if (formattingSegment.isValue()) {
									isTail = true;;
								}
							}
							else {
								formattingSegment.format(elementFormatter, serializationBuilder);
							}
						}
					}
					break;
				}
			}
		}
	}

	protected boolean formatNode(@NonNull INode childNode, boolean hasStarted, @NonNull ILeafNode endNode) {
		if (childNode instanceof ICompositeNode) {
			if (formatCompositeNode((ICompositeNode)childNode, hasStarted, endNode)) {
				return true;
			}
		}
		else {
			if (!((ILeafNode) childNode).isHidden()) {
				formatLeafNode((ILeafNode)childNode, hasStarted);
			}
			if (childNode == endNode) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the EList to which compositeNode assigns if compoundedGrammarElement is an is-many feature assignment. Else null.
	 */
	protected @Nullable EList<?> getAssignedCollection(@NonNull ICompositeNode compositeNode, @NonNull AbstractElement compoundedGrammarElement) {
		if (!(compoundedGrammarElement instanceof Assignment)) {
			return null;
		}
		EStructuralFeature eStructuralFeature = SerializationUtils.getEStructuralFeature((Assignment)compoundedGrammarElement);
		if (!eStructuralFeature.isMany()) {
			return null;
		}
		ICompositeNode parentNode = compositeNode.getParent();
		EObject parentSemanticElement = parentNode.getSemanticElement();
		return (EList<?>)parentSemanticElement.eGet(eStructuralFeature);
	}

	/**
	 * Return the grammar element for node whose container is a CompoundElement; i.e. ascend the terminals of an assignment to return thr assignment.
	 */
	protected @NonNull AbstractElement getCompoundedGrammarElement(@NonNull INode node) {
		EObject grammarElement = node.getGrammarElement();
		for (EObject eContainer = grammarElement.eContainer(); (eContainer instanceof AbstractElement) && !(eContainer instanceof CompoundElement); eContainer = grammarElement.eContainer()) {
			grammarElement = eContainer;
		}
		return grammarElement instanceof AbstractElement ? (AbstractElement)grammarElement : SerializationUtils.getAlternatives(((AbstractRule)grammarElement));
	}
}
