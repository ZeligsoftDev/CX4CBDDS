/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;

public final class ExpandAllNodesAction extends Action
{
	private final @NonNull ValidityView validityView;
	private final boolean isValidatableExpandAction;
	private final boolean isConstrainingExpandAction;
	
	public ExpandAllNodesAction(@NonNull ValidityView validityView, 
			boolean isValidatableExpandAction, boolean isConstrainingExpandAction) {
		super(ValidityUIMessages.ValidityView_Action_ExpandAllNodes_Title);
		this.validityView = validityView;
		this.isValidatableExpandAction = isValidatableExpandAction;
		this.isConstrainingExpandAction = isConstrainingExpandAction;
		if (isValidatableExpandAction && isConstrainingExpandAction){
			setToolTipText(ValidityUIMessages.ValidityView_Action_ExpandAllNodes_ToolTipText);
		} else if (isValidatableExpandAction){
			setToolTipText(ValidityUIMessages.ValidityView_Action_ExpandAllValidatableNodes_ToolTipText);
		} else if (isConstrainingExpandAction) {
			setToolTipText(ValidityUIMessages.ValidityView_Action_ExpandAllConstrainingNodes_ToolTipText);
		}
		
		URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_ExpandAllNodes_ImageLocation);
		setImageDescriptor(ImageDescriptor.createFromURL(image));
	}

	@Override
	public void run() {
		RootNode rootNode = validityView.getValidityManager().getRootNode();
		if (rootNode != null) {
			if (isValidatableExpandAction) {
				validityView.getValidatableNodesViewer().expandAll();
			}
			if (isConstrainingExpandAction) {
				validityView.getConstrainingNodesViewer().expandAll();
			}
		}
	}
}