/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.cs2as;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;

import com.google.common.collect.UnmodifiableIterator;

/**
 * An Iterator over the types of implicit source types or variables (most nested first).
 */
public abstract class AbstractImplicitSourceNamedElementIterator<T> extends UnmodifiableIterator<T>
{
	protected static final boolean CONTINUE = false;
	protected static final boolean DONE = true;

	private @Nullable ElementCS cursor;
	protected @Nullable T next;

	protected AbstractImplicitSourceNamedElementIterator(@NonNull ElementCS csElement) {
		this.cursor = csElement;
		this.next = null;
		hasNext();
	}

	/**
	 * Assess csParent invoked from csChild and invoke setNext() if csParent provides a source variable.
	 * Return true if the hierarchical assessment is complete, false to continue.
	 */
	protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
		if (csParent instanceof ContextCS) {
			ExpressionInOCL asContext = PivotUtil.getPivot(ExpressionInOCL.class, (ContextCS)csParent);
			if (asContext != null) {
				VariableDeclaration asVariable = asContext.getOwnedContext();
				if (asVariable != null) {
					setNext(asVariable);
				}
			}
			return DONE; // no more parents
		}
		else if (csParent instanceof ConstraintCS) {
			Constraint asConstraint = PivotUtil.getPivot(Constraint.class, (ConstraintCS)csParent);
			if (asConstraint != null) {
				LanguageExpression asContext = asConstraint.getOwnedSpecification();
				if (asContext instanceof ExpressionInOCL) {
					VariableDeclaration asVariable = ((ExpressionInOCL)asContext).getOwnedContext();
					if (asVariable != null) {
						setNext(asVariable);
					}
				}
			}
			return DONE; // no more parents
		}
		else if (csParent instanceof ExpSpecificationCS) {
			Element element = ((ExpSpecificationCS)csParent).getPivot();
			if (element instanceof ExpressionInOCL) {
				VariableDeclaration asVariable = ((ExpressionInOCL)element).getOwnedContext();
				if (asVariable != null) {
					setNext(asVariable);
				}
			}
		}
		else if ((csParent instanceof NameExpCS) && (((NameExpCS)csParent).getOwnedRoundBracketedClause() != null)){
			OCLExpression asCallExp = PivotUtil.getPivot(OCLExpression.class, (NameExpCS)csParent);
			if (asCallExp instanceof LoopExp) {
				List<Variable> asIterators = ((LoopExp)asCallExp).getOwnedIterators();
				if (asIterators.size() == 1) {
					Variable iterator = asIterators.get(0);
					if ((iterator != null) && iterator.isIsImplicit()) {
						setNext(iterator);
					}
				}
			}
		}
		return CONTINUE;
	}

	@Override
	public boolean hasNext() {
		ElementCS csElement = cursor;
		while ((next == null) && (csElement != null)) {
			ElementCS csParent = csElement.getParent();
			if (csParent != null) {
				if (doNext(csParent, csElement) == DONE) {
					csElement = null;
					break;
				}
			}
			csElement = csParent;
		}
		cursor = csElement;
		return next != null;
	}

	@Override
	public @NonNull T next() {
		@Nullable T next2 = next;
		if (next2 == null) {
			throw new NoSuchElementException();
		}
		else {
			next = null;
			return next2;
		}
	}

	/**
	 * Assign the iterable element when iterating at asVariable.
	 */
	protected abstract void setNext(@NonNull VariableDeclaration asVariable);
}
