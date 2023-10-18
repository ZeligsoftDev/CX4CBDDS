/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.utilities;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class BaseUIUtil
{
	public static @Nullable IXtextDocument getActiveDocument(@Nullable IWorkbenchSite site) {
		try {
			if (site == null) {
				return null;
			}
			IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if (activePage == null) {
				return null;
			}
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (!(activeEditor instanceof XtextEditor)) {
				return null;
			}
			IXtextDocument xtextDocument = ((XtextEditor)activeEditor).getDocument();
			return xtextDocument;
		}
		catch (Exception e) {
			return  null;
		}
	}

	public static @Nullable ISelection getActiveSelection(@Nullable IWorkbenchSite site) {
		try {
			if (site == null) {
				return null;
			}
			IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if (activePage == null) {
				return null;
			}
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor == null) {
				return null;
			}
			IEditorSite editorSite = activeEditor.getEditorSite();
			if (editorSite == null) {
				return null;
			}
			ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
			if (selectionProvider == null) {
				return null;
			}
			return selectionProvider.getSelection();
		}
		catch (Exception e) {
			return  null;
		}
	}

	public static @Nullable Object getSelectedObject(@Nullable ISelection sel, @Nullable IWorkbenchSite site) {
		Object selectedObject = null;
		if (sel instanceof ITextSelection) {
			selectedObject = BaseUIUtil.getXtextTextSelection((ITextSelection)sel, site);
		}
		else {
			if (sel instanceof IStructuredSelection) {
				IStructuredSelection ssel = (IStructuredSelection) sel;
				if (!ssel.isEmpty()) {
					selectedObject = ssel.getFirstElement();
				}
			}
			if (selectedObject instanceof IOutlineNode) {
				selectedObject = BaseUIUtil.getXtextOutlineSelection((IOutlineNode)selectedObject, site);
			}
		}
		return selectedObject;
	}

	public static @Nullable Object getXtextOutlineSelection(@NonNull IOutlineNode outlineNodeSelection, @Nullable IWorkbenchSite site) {
		if (outlineNodeSelection instanceof EObjectNode) {
			final EObjectNode selectedObjectNode = (EObjectNode) outlineNodeSelection;
			IXtextDocument xtextDocument = getActiveDocument(site);
			if (xtextDocument != null) {
				final URI eObjectURI = selectedObjectNode.getEObjectURI();
				if (eObjectURI != null) {
					return xtextDocument.readOnly(new IUnitOfWork<EObject, XtextResource>()
					{
						@Override
						public EObject exec(@Nullable XtextResource resource) throws Exception {
							if (resource ==  null) {
								return null;
							}
							String fragment = eObjectURI.fragment();
							if (fragment ==  null) {
								return null;
							}
							return resource.getEObject(fragment);
						}
					});
				}
			}
		}
		else if (outlineNodeSelection instanceof EStructuralFeatureNode) {
			//			return null;
		}
		return null;
	}

	public static @Nullable Object getXtextTextSelection(final @NonNull ITextSelection textSelection, @Nullable IWorkbenchSite site) {
		IXtextDocument xtextDocument = getActiveDocument(site);
		if (xtextDocument == null) {
			return null;
		}
		return xtextDocument.readOnly(new IUnitOfWork<EObject, XtextResource>()
		{
			@Override
			public EObject exec(@Nullable XtextResource resource) throws Exception {
				if (resource == null) {
					return null;
				}
				if (resource.getContents().size() <= 0) {
					return null;
				}
				EObject rootObject = resource.getContents().get(0);
				INode rootNode = NodeModelUtils.getNode(rootObject);
				if (rootNode == null) {
					return null;
				}
				ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, textSelection.getOffset());
				if (leafNode == null) {
					return null;
				}
				return leafNode.getSemanticElement();
			}
		});
	}

	public static void toggleNature(@NonNull IProjectDescription description, @NonNull String natureId) {
		String[] natures = description.getNatureIds();
		for (int i = 0; i < natures.length; ++i) {
			if (natureId.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
				description.setNatureIds(newNatures);
				return;
			}
		}
		// Add the nature
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = natureId;
		description.setNatureIds(newNatures);
	}
}
