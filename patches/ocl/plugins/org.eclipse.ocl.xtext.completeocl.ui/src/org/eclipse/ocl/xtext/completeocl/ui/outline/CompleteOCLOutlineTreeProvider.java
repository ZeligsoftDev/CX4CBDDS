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
package org.eclipse.ocl.xtext.completeocl.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
import org.eclipse.ocl.xtext.essentialocl.ui.outline.EssentialOCLOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * customization of the default outline structure
 *
 */
public class CompleteOCLOutlineTreeProvider extends EssentialOCLOutlineTreeProvider
{
	@Override
	protected void _createChildren(DocumentRootNode parentNode, EObject modelElement) {
		createNode(parentNode, modelElement);
	}

	protected void _createChildren(DocumentRootNode parentNode, CompleteOCLDocumentCS csElement) {
		for (ElementCS csChild : csElement.getOwnedImports()) {
			createNode(parentNode, csChild);
		}
		for (ElementCS csChild : csElement.getOwnedContexts()) {
			createNode(parentNode, csChild);
		}
		for (ElementCS csChild : csElement.getOwnedPackages()) {
			createNode(parentNode, csChild);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, PackageDeclarationCS csElement) {
		for (ElementCS csChild : csElement.getOwnedInvariants()) {
			createNode(parentNode, csChild);
		}
		for (ElementCS csChild : csElement.getOwnedContexts()) {
			createNode(parentNode, csChild);
		}
	}

//	protected void _createChildren(IOutlineNode parentNode, PropertyContextDeclCS ele) {
//		createChildren(parentNode, (EObject)ele);
//	}

	protected void _createNode(IOutlineNode parentNode, ClassifierContextDeclCS ele) {
		_createNode(parentNode, (EObject)ele);
	}

	protected void _createNode(IOutlineNode parentNode, OperationContextDeclCS ele) {
		_createNode(parentNode, (EObject)ele);
	}

	protected void _createNode(IOutlineNode parentNode, PropertyContextDeclCS ele) {
		_createNode(parentNode, (EObject)ele);
	}

	protected void _createNode(DocumentRootNode parentNode, PackageDeclarationCS ele) {
		_createNode(parentNode, (EObject)ele);
	}

	protected void _createNode(IOutlineNode parentNode, PackageDeclarationCS ele) {
		_createNode(parentNode, (EObject)ele);
	}

	protected void _createNode(IOutlineNode parentNode, PathNameCS ele) {}
}
