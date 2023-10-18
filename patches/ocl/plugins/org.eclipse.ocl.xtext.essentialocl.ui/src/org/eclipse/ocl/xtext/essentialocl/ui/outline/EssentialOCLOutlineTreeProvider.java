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
package org.eclipse.ocl.xtext.essentialocl.ui.outline;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.xtext.base.ui.outline.BaseOutlineTreeProvider;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * customization of the default outline structure
 *
 */
public class EssentialOCLOutlineTreeProvider extends BaseOutlineTreeProvider
{
	@Override
	protected @Nullable ElementCS getImplicitCsElement(@NonNull Element asElement) {
		if (asElement instanceof OperationCallExp) {	// e.g. oclAsSet
			OperationCallExp asOperationCallExp = (OperationCallExp)asElement;
			if (asOperationCallExp.isIsImplicit()) {
				OCLExpression asSource = asOperationCallExp.getOwnedSource();
				if (asSource != null) {
					ElementCS csElement = ElementUtil.getCsElement(asSource);
					if (csElement instanceof ExpCS) {
						return ((ExpCS)csElement).getParent();
					}
				}
			}
		}
		return null;
	}
	protected void _createNode(IOutlineNode parentNode, ExpressionInOCL ele) {			// Skip node
		createNode(parentNode, ele.getOwnedBody());
	}

	protected void _createChildren(IOutlineNode parentNode, ExpressionInOCL exp) {}		// Skipped node so no children

	protected void _createChildren(IOutlineNode parentNode, IfExp exp) {
		createNode(parentNode, exp.getOwnedCondition());
		createNode(parentNode, exp.getOwnedThen());
		createNode(parentNode, exp.getOwnedElse());
	}

	protected void _createChildren(IOutlineNode parentNode, IterateExp ele) {
		for (Variable iterator : ele.getOwnedIterators()) {
			createNode(parentNode, iterator);
		}
		for (Variable iterator : ele.getOwnedCoIterators()) {
			if (iterator != null) {
				createNode(parentNode, iterator);
			}
		}
		createNode(parentNode, ele.getOwnedResult());
		createNode(parentNode, ele.getOwnedSource());
		createNode(parentNode, ele.getOwnedBody());
	}

	protected void _createChildren(IOutlineNode parentNode, IteratorExp ele) {
		for (Variable iterator : ele.getOwnedIterators()) {
			createNode(parentNode, iterator);
		}
		for (Variable iterator : ele.getOwnedCoIterators()) {
			if (iterator != null) {
				createNode(parentNode, iterator);
			}
		}
		createNode(parentNode, ele.getOwnedSource());
		createNode(parentNode, ele.getOwnedBody());
	}

	protected void _createChildren(IOutlineNode parentNode, LetExp exp) {
		createNode(parentNode, exp.getOwnedVariable());
		createNode(parentNode, exp.getOwnedIn());
	}

	protected void _createChildren(IOutlineNode parentNode, OperationCallExp ele) {
		createNode(parentNode, ele.getOwnedSource());
		for (OCLExpression argument : ele.getOwnedArguments()) {
			createNode(parentNode, argument);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, OppositePropertyCallExp ele) {
		createNode(parentNode, ele.getOwnedSource());
	}

	protected void _createChildren(IOutlineNode parentNode, PropertyCallExp ele) {
		createNode(parentNode, ele.getOwnedSource());
	}

	//	protected boolean _isLeaf(OperationCallExp csExp) {
	//		boolean _isLeaf = super._isLeaf(csExp);
	//		return _isLeaf;
	//	}
}
