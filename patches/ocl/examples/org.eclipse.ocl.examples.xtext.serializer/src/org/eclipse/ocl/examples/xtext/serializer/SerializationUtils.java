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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

public class SerializationUtils
{
	public static @NonNull String defaultIndentation = "    ";
	public static final @NonNull ENamedElementComparator ENAMED_ELEMENT_COMPARATOR = ENamedElementComparator.INSTANCE;

	public static final @NonNull IndexedComparator INDEXED_COMPARATOR = IndexedComparator.INSTANCE;

	public static final @NonNull NameableComparator NAMEABLE_COMPARATOR = NameableComparator.INSTANCE;

	public static final class ENamedElementComparator implements Comparator<@NonNull ENamedElement>
	{
		public static final @NonNull ENamedElementComparator INSTANCE = new ENamedElementComparator();

		@Override
		public int compare(@NonNull ENamedElement o1, @NonNull ENamedElement o2) {
			if (o1 == o2) {
				return 0;		// Short circuit containment compare / independent searches
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			int comparison = safeCompareTo(n1, n2);
			if (comparison != 0) {
				return comparison;
			}
			if ((o1 instanceof EPackage) && (o2 instanceof EPackage)) {
				n1 = ((EPackage)o1).getNsURI();
				n2 = ((EPackage)o2).getNsURI();
				comparison = safeCompareTo(n1, n2);
				if (comparison != 0) {
					return comparison;
				}
			}
			EObject p1 = o1.eContainer();
			EObject p2 = o2.eContainer();
			if ((p1 instanceof ENamedElement) && (p2 instanceof ENamedElement)) {
				return compare((ENamedElement)p1, (ENamedElement)p2);
			}
			return comparison;
		}
	}

	public static final class IndexedComparator implements Comparator<@NonNull Indexed>
	{
		public static final @NonNull IndexedComparator INSTANCE = new IndexedComparator();

		@Override
		public int compare(@NonNull Indexed o1, @NonNull Indexed o2) {
			int n1 = o1.getIndex();
			int n2 = o2.getIndex();
			return n1 - n2;
		}
	}

	public static final class NameableComparator implements Comparator<@NonNull Nameable>
	{
		public static final @NonNull NameableComparator INSTANCE = new NameableComparator();

		@Override
		public int compare(@NonNull Nameable o1, @NonNull Nameable o2) {
			String n1 = o1.getName();
			String n2 = o2.getName();
			return safeCompareTo(n1, n2);
		}
	}

	public static class ToStringComparator<T> implements Comparator<@NonNull T>
	{
		/**
		 * Provide a simple shared INSTANCE for comparison based on toString().
		 * If toString() is more expensive than a Map.get() a toString() cache can be
		 * activated by constructing a new ToStringComparator instance.
		 */
		public static final @NonNull ToStringComparator<@NonNull Object> INSTANCE = new ToStringComparator<@NonNull Object>(null);

		/*
		 * toString can be expensive so avoid repeated evaluations.
		 */
		private final Map<@NonNull T, @NonNull String> object2string;

		public ToStringComparator() {
			this(new HashMap<>());
		}

		protected ToStringComparator(@Nullable Map<@NonNull T, @NonNull String> object2string) {
			this.object2string = object2string;
		}

		@Override
		public int compare(@NonNull T o1, @NonNull T o2) {
			String s1;
			String s2;
			if (object2string == null) {
				s1 = o1.toString();
				s2 = o2.toString();
			}
			else {
				s1 = getString(o1);
				s2 = getString(o2);
			}
			return safeCompareTo(s1, s2);
		}

		protected @NonNull String getString(@NonNull T o) {
			String string = maybeNull(object2string.get(o));
			if (string == null) {
				string = o.toString();
				if (string == null) {
					string = "";
				}
				object2string.put(o, string);
			}
			return string;
		}
	}

	/**
	 * NodeIterator provides a depth first traversal of an Xtext INode tree, returning each IComposite node twice
	 * first with {@link isChildrenPending()} true for pre-order usage and later with {@link isChildrenPending()} false
	 * for post-order usage.
	 * <br/>
	 * The iterator is constructed with a particular node, which is returned  by the first call to {@link next()}.
	 */
	public static class NodeIterator implements Iterator<@NonNull INode>
	{
		private @Nullable INode node;
		private boolean hasNext;
		private boolean childrenPending;

		public NodeIterator(@NonNull INode node) {
			this.node = node;
			this.hasNext = true;
			this.childrenPending = node instanceof ICompositeNode;
		}

		public NodeIterator(@NonNull NodeIterator nodeIterator) {
			this.node = nodeIterator.node;
			this.hasNext = nodeIterator.hasNext;
			this.childrenPending = nodeIterator.childrenPending;
		}

		@Override
		public boolean hasNext() {
			if (hasNext) {
				return true;
			}
			INode thisNode = node;
			if (thisNode == null) {
				return false;
			}
		//	String thisText =  thisNode.getText();
			INode nextNode = null;
		//	String nextText;
			if (childrenPending) {
				nextNode = ((ICompositeNode)thisNode).getFirstChild();
		//		nextText = nextNode != null ? nextNode.getText() : null;
				this.childrenPending = nextNode instanceof ICompositeNode;
			}
			if (nextNode == null) {
				nextNode = thisNode.getNextSibling();
				if (nextNode == null) {
					nextNode = thisNode.getParent();
		//			nextText = nextNode != null ? nextNode.getText() : null;
					this.childrenPending = false;
				}
				else {
		//			nextText = nextNode.getText();
					this.childrenPending = nextNode instanceof ICompositeNode;
				}
			}
			this.node = nextNode;
			this.hasNext = nextNode != null;
			return hasNext;
		}

		/**
		 * Return true if current node is an ICompositeNode in pre-order, else false if in post-order.
		 */
		public boolean isChildrenPending() {
			assert node instanceof ICompositeNode;
			return childrenPending;
		}

		@Override
		public @NonNull INode next() {
			this.hasNext = false;
			if (node != null) {
				return node;
			}
			throw new NoSuchElementException();
		}
	}

	public static void appendIndentation(@NonNull StringBuilder s, int depth) {
		appendIndentation(s, depth, defaultIndentation);
	}
	public static void appendIndentation(@NonNull StringBuilder s, int depth, @NonNull String string) {
		if (depth >= 0) {
			s.append("\n");
		}
		for (int i = 0; i < depth; i++) {
			s.append(string);
		}
	}

	public static @NonNull EClass eClass(@NonNull EObject eObject) {
		return nonNullState(eObject.eClass());
	}

	public static @NonNull EStructuralFeature eContainingFeature(@NonNull EObject eObject) {
		return nonNullState(eObject.eContainingFeature());
	}

	public static @NonNull EReference eContainmentFeature(@NonNull EObject eObject) {
		return nonNullState(eObject.eContainmentFeature());
	}

	public static @NonNull EObject eContainer(@NonNull EObject eObject) {
		return nonNullState(eObject.eContainer());
	}

	public static void formatDiagnostic(@NonNull StringBuilder s, @NonNull Diagnostic diagnostic, @NonNull String newLine) {
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			s.append(newLine);
			s.append(diagnostic.getSeverity() + " - ");
			String location = diagnostic.getSource();
			if (location != null) {
				s.append(location);
				s.append(": ");
			}
			s.append(diagnostic.getMessage());
			for (Object obj : diagnostic.getData()) {
				s.append(newLine);
				s.append("\t");
				//				if (obj instanceof Throwable) {
				//					s.append(((Throwable)obj).getMessage());
				//				}
				//				else {
				s.append(obj);
				//				}
			}
			for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
				if (childDiagnostic != null) {
					formatDiagnostic(s, childDiagnostic, newLine + "\t");
				}
			}
		}
	}

	public static String formatResourceDiagnostics(@NonNull List<Resource.Diagnostic> diagnostics, @NonNull String messagePrefix, @NonNull String newLine) {
		if (diagnostics.size() <= 0) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		s.append(messagePrefix);
		for (Resource.Diagnostic diagnostic : diagnostics) {
			if (diagnostic instanceof Diagnostic) {
				formatDiagnostic(s, (Diagnostic)diagnostic, newLine);
			}
			else {
				s.append(newLine);
				String location = diagnostic.getLocation();
				if (location != null) {
					s.append(location);
					s.append(":");
				}
				s.append(diagnostic.getLine());
				try {
					int column = diagnostic.getColumn();
					if (column > 0) {
						s.append(":");
						s.append(column);
					}
				} catch (Exception e) {}	// UnsupportedOperationException was normal for Bug 380232 fixed in Xtext 2.9
				s.append(": ");
				s.append(diagnostic.getMessage());
			}
		}
		return s.toString();
	}

	public static @NonNull AbstractElement getAlternatives(@NonNull AbstractRule abstractRule) {
		return nonNullState(abstractRule.getAlternatives());
	}

	public static @NonNull Iterable<@NonNull INode> getChildren(@NonNull ICompositeNode compositeNode) {
		return nullFree(compositeNode.getChildren());
	}

	public static @NonNull EClassifier getClassifier(TypeRef type) {
		return nonNullState(type.getClassifier());
	}

	public static @NonNull EClass getEClassScope(@NonNull AbstractElement abstractElement) {
		TypeRef type = null;
		for (EObject eObject = abstractElement, eChild = null; (type == null) && (eObject != null); eChild = eObject, eObject = eObject.eContainer()) {
			if (eObject instanceof ParserRule) {
				type = ((ParserRule)eObject).getType();
			}
			else if ((eObject instanceof Action) && (((Action)eObject).getFeature() != null))  {
				type = ((Action)eObject).getType();
				break;
			}
			else if ((eObject instanceof Group) && (eChild != null)) {
				List<@NonNull AbstractElement> elements = getElements((Group)eObject);
				int index = elements.indexOf(eChild);
				assert index >= 0;
				for (int i = index; --i >= 0; ) {
					AbstractElement element = elements.get(i);
					if (element instanceof Action) {
						type = ((Action)element).getType();
						break;
					}
				}
			}
		}
		if (type != null) {
			return (EClass)getClassifier(type);
		}
		throw new IllegalStateException();
	}

	public static @NonNull EClass getEContainingClass(@NonNull EStructuralFeature eFeature) {
		return nonNullState(eFeature.getEContainingClass());
	}

	public static @NonNull EPackage getEPackage(@NonNull EClassifier eClassifier) {
		return nonNullState(eClassifier.getEPackage());
	}

	public static @NonNull List<@NonNull AbstractElement> getElements(@NonNull CompoundElement compoundElement) {
		return nullFree(compoundElement.getElements());
	}

	public static @NonNull Grammar getEContainingGrammar(@NonNull EObject eObject) {
		for (EObject eCursor = eObject; (eCursor != null); eCursor = eCursor.eContainer()) {
			if (eCursor instanceof Grammar) {
				return (Grammar)eCursor;
			}
		}
		throw new IllegalStateException();
	}

	public static @NonNull EClass getEReferenceType(@NonNull EReference eReference) {
		return nonNullState(eReference.getEReferenceType());
	}

	public static @NonNull EStructuralFeature getEStructuralFeature(@NonNull EClass eClass, @NonNull String featureName) {
		return nonNullState(eClass.getEStructuralFeature(featureName));
	}

	public static @NonNull EStructuralFeature getEStructuralFeature(@NonNull Assignment assignment) {
		return getEStructuralFeature(getEClassScope(assignment), getFeature(assignment));
	}

	public static @NonNull EClass getSubTypeOf(@NonNull EClass thisEClass, @NonNull EClass thatEClass) {
		if (thisEClass == thatEClass) {
			return thisEClass;
		}
		else if (thisEClass.isSuperTypeOf(thatEClass)) {
			return thatEClass;
		}
		else if (thatEClass.isSuperTypeOf(thisEClass)) {
			return thisEClass;
		}
		else {
			throw new IllegalStateException("No common subtype");
		}
	}

	public static @NonNull String getFeature(@NonNull Action action) {
		return nonNullState(action.getFeature());
	}

	public static @NonNull String getFeature(@NonNull Assignment assignment) {
		return nonNullState(assignment.getFeature());
	}

	public static @NonNull Keyword getLeft(@NonNull CharacterRange characterRange) {
		return nonNullState(characterRange.getLeft());
	}

	public static @NonNull String getName(@NonNull AbstractRule abstractRule) {
		return nonNullState(abstractRule.getName());
	}

	public static @NonNull String getName(@NonNull ENamedElement eNamedElement) {
		return nonNullState(eNamedElement.getName());
	}

	public static @NonNull Resource getResource(@NonNull EObject eObject) {
		return nonNullState(eObject.eResource());
	}
	public static @NonNull Keyword getRight(@NonNull CharacterRange characterRange) {
		return nonNullState(characterRange.getRight());
	}
	public static @NonNull AbstractRule getRule(@NonNull RuleCall ruleCall) {
		return nonNullState(ruleCall.getRule());
	}
	public static @NonNull String getSafeName(@Nullable Nameable aNameable) {
		if (aNameable == null) {
			return "";
		}
		String name = aNameable.getName();
		if (name == null) {
			name = "";
		}
		return name;
	}

	public static @NonNull AbstractElement getTerminal(@NonNull Assignment assignment) {
		return nonNullState(assignment.getTerminal());
	}

	public static @NonNull AbstractElement getTerminal(@NonNull CrossReference crossReference) {
		return nonNullState(crossReference.getTerminal());
	}

	public static @NonNull AbstractElement getTerminal(@NonNull UntilToken untilToken) {
		return nonNullState(untilToken.getTerminal());
	}

	public static @NonNull TypeRef getType(@NonNull AbstractRule abstractRule) {
		return nonNullState(abstractRule.getType());
	}

	public static @NonNull TypeRef getType(@NonNull Action action) {
		return nonNullState(action.getType());
	}

	public static @NonNull Iterable<@NonNull Grammar> getUsedGrammars(@NonNull Grammar grammar) {
		return nullFree(grammar.getUsedGrammars());
	}

	public static @NonNull String getValue(@NonNull Keyword keyword) {
		return nonNullState(keyword.getValue());
	}
	/**
	 * Return aT as @Nullable to suppress the compiler's insistence that the value is non-null.
	 * This may be necessary fo methods that access final non-null fields during construction.
	 */
	public static <T> @Nullable T maybeNull(T aT) {
		return aT;
	}

	/**
	 * Check for an in appropriate program state. This should not happen, but is not impossible. For instance
	 * a Resource should be contained in a ResourceSet, but that doesn't mean it always is.
	 *<p>
	 * If the inappropriate state really cannot happen, an assertion should be used instead to avoid non-debug
	 * run-time cost.
	 * <p>
	 * Return aT, throwing an IllegalStateException if null.
	 */
	public static @NonNull <T> T nonNullState(@Nullable T aT) {
		if (aT == null) {
			throw new IllegalStateException();
		}
		return aT;
	}

	/**
	 * Cast a logically nullFreeList such as EMF collection to a declared null free list.
	 * @since 1.1
	 */
	@SuppressWarnings("null")
	public static <T> @NonNull List<@NonNull T> nullFree(@Nullable List<T> nullFreeList) {
		return nullFreeList != null ? nullFreeList : Collections.emptyList();
	}
	/**
	 * @since 1.1
	 */
	@SuppressWarnings({"null", "unchecked"})
	public static <T> @NonNull EList<@NonNull T> nullFree(@Nullable EList<T> nullFreeList) {
		return nullFreeList != null ? nullFreeList : (EList<T>) ECollections.EMPTY_ELIST;
	}
	/**
	 * @since 1.10
	 */
	@SuppressWarnings({"null", "unchecked"})
	public static <T> @NonNull Iterable<@NonNull T> nullFree(@Nullable Iterable<T> nullFreeList) {
		return nullFreeList != null ? nullFreeList : (Iterable<T>) ECollections.EMPTY_ELIST;
	}

	/**
	 * Safely determines the relative order of <code>object</code> and
	 * <code>otherObject</code>, i.e. without throwing an exception if
	 * <code>object</code> is <code>null</code>.
	 */
	public static <T extends Comparable<T>> int safeCompareTo(@Nullable T object, @Nullable T otherObject) {
		if (object == null) {
			return otherObject == null ? 0 : 1;
		}
		else {
			return otherObject == null ? -1 : object.compareTo(otherObject);
		}
	}

	/**
	 * Safely determines whether <code>object</code> equals
	 * <code>otherObject</code>, i.e. without throwing an exception if
	 * <code>object</code> is <code>null</code>.
	 *
	 * @param object
	 *            The first object to compare.
	 * @param otherObject
	 *            The second object to compare.
	 * @return <code>true</code> if <code>object</code> equals
	 *         <code>otherObject</code>; <code>false</code> otherwise.
	 */
	public static boolean safeEquals(@Nullable Object object, @Nullable Object otherObject) {
		return object == null
				? otherObject == null
				: object.equals(otherObject);
	}
}
