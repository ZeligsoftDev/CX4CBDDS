/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Messages Externalization
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.ValidityUtils;

public final class RunValidityAction extends Action
{
	protected final @NonNull ValidityView validityView;
	protected final @Nullable ISelectionProvider selectionProvider;
	
	public RunValidityAction(@NonNull ValidityView validityView, @Nullable ISelectionProvider selectionProvider) {
		super(ValidityUIMessages.ValidityView_Action_RunValidity_Title);
		this.validityView = validityView;
		this.selectionProvider = selectionProvider;
		setToolTipText(ValidityUIMessages.ValidityView_Action_RunValidity_ToolTipText);
		URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_RunValidity_ImageLocation);
		setImageDescriptor(ImageDescriptor.createFromURL(image));
	}

	@Override
	public void run() {
		Set<ResultConstrainingNode> selectedNodes = null;
		ISelectionProvider selectionProvider2 = selectionProvider;
		if (selectionProvider2 != null) {
			ISelection selection = selectionProvider2.getSelection();
			if (selection instanceof StructuredSelection) {
				selectedNodes = new HashSet<ResultConstrainingNode>();
				Object selectedObject = ((StructuredSelection) selection).getFirstElement();
				if (selectedObject instanceof ConstrainingNode) {
					List<ResultConstrainingNode> enabledResultConstrainingNodes = ValidityUtils.getEnabledResultConstrainingNodes((ConstrainingNode)selectedObject);
					selectedNodes.addAll(enabledResultConstrainingNodes);
				}
				else if (selectedObject instanceof ValidatableNode) {
					List<ResultValidatableNode> enabledResultValidatableNodes = ValidityUtils.getEnabledResultValidatableNodes((ValidatableNode)selectedObject);
					for (ResultValidatableNode enabledResultValidatableNode : enabledResultValidatableNodes) {
						selectedNodes.add(enabledResultValidatableNode.getResultConstrainingNode());
					}
				}
			}
		}
		validityView.getValidityManager().runValidation(validityView, selectedNodes);
	}
}