/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.xtext.base.ui.BaseUiPluginHelper;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

/**
 * customization of the default outline structure
 *
 */
public class BaseOutlineTreeProvider extends DefaultOutlineTreeProvider
{
	public static final @NonNull TracingOption CREATE = new TracingOption(
		BaseUiPluginHelper.PLUGIN_ID, "outline/create"); //$NON-NLS-1$

	@Override
	protected EObjectNode createEObjectNode(IOutlineNode parentNode, EObject modelElement, Image image, Object text, boolean isLeaf) {
		EObject asElement = modelElement;
		if (modelElement instanceof Pivotable) {
			Pivotable pivotable = (Pivotable) modelElement;
			Element pivot = pivotable.getPivot();
			if (pivot != null) {
				asElement = pivot;
			}
		}
		EObjectNode eObjectNode;
		if (asElement instanceof Element) {
			boolean isImplicit = false;
			ElementCS csElement = ElementUtil.getCsElement((Element)asElement);
			if (csElement == null) {
				csElement = getImplicitCsElement((Element)asElement);
				isImplicit = csElement != null;
			}
			eObjectNode = new BaseOutlineNode((Element)asElement, isImplicit, csElement, parentNode, image, text, isLeaf);
		}
		else {
			eObjectNode = new EObjectNode(modelElement, parentNode, image, text, isLeaf);
		}
		if ((asElement != null) /*&& isLocalElement(parentNode, asElement)*/) {
			eObjectNode.setTextRegion(locationInFileProvider.getFullTextRegion(asElement));
			eObjectNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(asElement));
		}
		if (CREATE.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append(modelElement.eClass().getName());
			s.append(" ");
			ElementUtil.appendTextRegion(s, eObjectNode.getFullTextRegion(), false);
			s.append(" ");
			ElementUtil.appendTextRegion(s, eObjectNode.getSignificantTextRegion(), true);
			s.append(" " + NameUtil.debugSimpleName(eObjectNode) + " " + String.valueOf(eObjectNode.getText()).replace("\n", "\\n"));
			CREATE.println(s.toString());
		}
		return eObjectNode;
	}

	/**
	 * The default creation of outline children is refined to create a node for an implicit
	 * element such as oclAsSet and to ignore null model elements.
	 */
	@Override
	public void createChildren(IOutlineNode parent, EObject modelElement) {
		if (modelElement != null) {
			super.createChildren(parent, modelElement);
		}
	}

	/**
	 * The default creation of outline node is refined to ignore null model elements.
	 */
	@Override
	protected void createNode(IOutlineNode parent, EObject modelElement) {
		if (modelElement != null) {
			super.createNode(parent, modelElement);
		}
	}

	protected @Nullable ElementCS getImplicitCsElement(@NonNull Element asElement) {
		return null;
	}

	/**
	 * In the absence of a declarative override, creation of the children an outline node for a CS element
	 * is redirected to its AS counterpart and if this is an implicit node the AS element is corrected to be
	 * the implicit AS element.
	 */
	protected void _createChildren(IOutlineNode parent, ModelElementCS csElement) {
		Element asElement = csElement.getPivot();
		if ((parent instanceof BaseOutlineNode) && ((BaseOutlineNode)parent).isImplicit() && (asElement instanceof CallExp)) {
			asElement = ((CallExp)asElement).getOwnedSource();
		}
		createChildren(parent, asElement);
	}

	/**
	 * In the absence of a declarative override, creation of an outline node for a CS element
	 * is redirected to its AS counterpart.
	 */
	protected void _createNode(DocumentRootNode parentNode, ModelElementCS csElement) {
		createNode(parentNode, csElement.getPivot());
	}

	/**
	 * In the absence of a declarative override, creation of an outline node for a CS element
	 * is redirected to its AS counterpart.
	 */
	protected void _createNode(IOutlineNode parent, ModelElementCS csElement) {
		createNode(parent, csElement.getPivot());
	}

	protected void _createChildren(IOutlineNode parentNode, Constraint constraint) {
		createNode(parentNode, constraint.getOwnedSpecification());
	}

	protected void _createChildren(IOutlineNode parentNode, Operation ele) {
		for (Parameter parameter : ele.getOwnedParameters()) {
			createNode(parentNode, parameter);
		}
		createNode(parentNode, ele.getBodyExpression());
	}

	// protected void _createNode(IOutlineNode parentNode, TemplateParameter
	// templateParameter) {
	// createNode(parentNode, templateParameter.getParameteredElement());
	// }

	// protected void _createNode(IOutlineNode parentNode, TemplateSignature
	// templateSignature) {
	// createChildren(parentNode, templateSignature);
	// }

//	protected boolean _isLeaf(Variable csExp) {
//		return true;
//	}
}
