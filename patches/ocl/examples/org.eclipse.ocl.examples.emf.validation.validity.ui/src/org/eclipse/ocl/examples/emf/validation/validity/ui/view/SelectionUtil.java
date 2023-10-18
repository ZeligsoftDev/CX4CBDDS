/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class SelectionUtil
{
	public static @Nullable Notifier getNotifierSelection(@Nullable ISelection selection, @Nullable IWorkbenchPart part) {
		Notifier input = null;
		if (selection instanceof ITreeSelection) {
			input = getTreeSelection((ITreeSelection) selection, part);
		} else if (selection instanceof IStructuredSelection) {
			input = getStructureSelection((IStructuredSelection) selection, part);
		}
		else if (selection instanceof ITextSelection) {
			input = getTextSelection((ITextSelection) selection, part);
		}
		return input;
	}
	
	public static @Nullable Notifier getTreeSelection(@NonNull ITreeSelection selection, @Nullable IWorkbenchPart part) {
		if (selection.size() == 1) {
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof Notifier)
				return (Notifier) firstElement;
			if (firstElement instanceof IAdaptable) {
				Object adaptedElement = ((IAdaptable)firstElement).getAdapter(EObject.class);			// EMF Facet
				if (adaptedElement instanceof Notifier)
					return (Notifier) adaptedElement;
			}
			if (firstElement instanceof EObjectNode) {
				return getXtextOutlineSelection((EObjectNode) firstElement, part);
			}
		}
		return null;
	}

	public static @Nullable Notifier getStructureSelection(@NonNull IStructuredSelection selection, @Nullable IWorkbenchPart part) {
		if (selection.size() == 1) {
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof Notifier)
				return (Notifier) firstElement;
			if (firstElement instanceof IAdaptable) {
				Object adaptedElement = ((IAdaptable)firstElement).getAdapter(EObject.class);			// EMF Facet
				if (adaptedElement instanceof Notifier)
					return (Notifier) adaptedElement;
			}
			if (firstElement instanceof EObjectNode) {
				return getXtextOutlineSelection((EObjectNode) firstElement, part);
			}
		}
		return null;
	}

	public static @Nullable Notifier getTextSelection(final @NonNull ITextSelection selection, @Nullable IWorkbenchPart part) {
		if (selection.getStartLine() < 0 || selection.getEndLine() < 0) {
			return null;
		}
		if (!(part instanceof XtextEditor)) {
			return null;
		}
		IXtextDocument document = ((XtextEditor)part).getDocument();
		Notifier selectedObject = document.readOnly(new IUnitOfWork<Notifier, XtextResource>() {
			public Notifier exec(@Nullable XtextResource xtextResource) {
				if (xtextResource == null) {
					return null;
				}
				IParseResult parseResult = xtextResource.getParseResult();
				if (parseResult == null)
					throw new NullPointerException("parseResult is null");
				ICompositeNode rootNode = parseResult.getRootNode();
				INode lastVisibleNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, selection.getOffset());
				if (lastVisibleNode == null) {
					return null; 
				}		
				EObject currentModel = NodeModelUtils.findActualSemanticObjectFor(lastVisibleNode);	
//				if (currentModel instanceof Pivotable) {
//					return ((Pivotable)currentModel).getPivot();
//				}
//				else {
					return currentModel;
//				}
			}					
		});
		return selectedObject;
	}

	public static @Nullable Notifier getXtextOutlineSelection(@NonNull EObjectNode selection, @Nullable IWorkbenchPart part) {
		if (!(part instanceof XtextEditor)) { // it's a ContentOutline
			return null;
		}
		// Find matching editor
		final URI selectedURI = selection.getEObjectURI();
		IXtextDocument document = ((XtextEditor)part).getDocument();
		Notifier selectedObject = document.readOnly(new IUnitOfWork<Notifier, XtextResource>() {
			public Notifier exec(@Nullable XtextResource xtextResource) {
				if (xtextResource == null) {
					return null;
				}
				EObject eObject = xtextResource.getEObject(selectedURI.fragment());
				return eObject;
			}					
		});
		return selectedObject;
	}
}