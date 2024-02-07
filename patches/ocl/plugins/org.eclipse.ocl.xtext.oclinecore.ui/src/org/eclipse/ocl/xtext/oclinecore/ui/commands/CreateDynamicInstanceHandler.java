/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.DynamicModelWizard;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Create a dynamic instance of an {@link EClass}.
 */
public class CreateDynamicInstanceHandler extends AbstractHandler
// Based on org.eclipse.emf.ecore.action.CreateDynamicInstanceAction
{
	private org.eclipse.ocl.pivot.Class selectedClass = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (selectedClass != null) {
			EObject eTarget = selectedClass.getESObject();
			EClass selectedEClass = null;
			if (eTarget instanceof EClass) {
				selectedEClass = (EClass) eTarget;
			}
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			if (selectedEClass != null) {
				IStructuredSelection selection = StructuredSelection.EMPTY;
				URI uri = selectedEClass.eResource().getURI();
				if (uri != null) {
					IFile file = URIUtil.getResolvedFile(uri);
					if ((file != null) && file.exists()) {
						selection = new StructuredSelection(file);
					}
				}
				DynamicModelWizard dynamicModelWizard = new DynamicModelWizard(selectedEClass);
				dynamicModelWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog wizardDialog = new WizardDialog(shell, dynamicModelWizard);
				wizardDialog.open();
			}
			else {
				MessageDialog.openError(shell, "Create Dynamic Instance",
					"No Ecore prototype found for '" + selectedClass.getName() +
						"'\nPlease Save as Ecore and Re-open.");
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return (selectedClass != null) && super.isEnabled();
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		selectedClass = null;
		@Nullable Object o = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_EDITOR_NAME);
		if (!(o instanceof IEditorPart)) {
			return;
		}
		o = ((IEditorPart)o).getAdapter(XtextEditor.class);
		if (!(o instanceof XtextEditor)) {
			return;
		}
		XtextEditor xtextEditor = (XtextEditor)o;
		final ITextSelection selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();	// FIXME this is the 'double-clicked' selection
		IXtextDocument document = xtextEditor.getDocument();
		selectedClass = document.readOnly(new IUnitOfWork<org.eclipse.ocl.pivot.Class, XtextResource>() {
			@Override
			public org.eclipse.ocl.pivot.Class exec(@Nullable XtextResource xtextResource) {
				if (xtextResource == null) {
					return null;
				}
				IParseResult parseResult = xtextResource.getParseResult();
				if (parseResult == null)
					throw new NullPointerException("parseResult is null");
				ICompositeNode rootNode = parseResult.getRootNode();
				//				INode lastVisibleNode = NodeModelUtils.getLastCompleteNodeByOffset(rootNode, selection.getOffset());
				//				EObject currentModel = NodeModelUtils.getNearestSemanticObject(lastVisibleNode);
				INode lastVisibleNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, selection.getOffset());
				if (lastVisibleNode == null) {
					return null;
				}
				EObject currentModel = NodeModelUtils.findActualSemanticObjectFor(lastVisibleNode);
				if (!(currentModel instanceof StructuredClassCS)) {
					return null;
				}
				StructuredClassCS oclInEcoreClass = (StructuredClassCS) currentModel;
				return PivotUtil.getPivot(org.eclipse.ocl.pivot.Class.class, oclInEcoreClass);
			}
		});
	}
}
