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
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.IDEValidityManager;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;

public class ForceValidityViewRefreshAction extends Action
{
	protected final @NonNull IDEValidityManager validityManager;

	protected final @NonNull ValidityView validityView;
	
	public ForceValidityViewRefreshAction(@NonNull IDEValidityManager validityManager, @NonNull ValidityView validityView) {
		super(ValidityUIMessages.ValidityView_Action_ForceRefresh_Title);
		this.validityManager = validityManager;
		this.validityView = validityView;
		setToolTipText(ValidityUIMessages.ValidityView_Action_ForceRefresh_ToolTipText);
		URL image = (URL) ValidityUIPlugin.INSTANCE.getImage(ValidityUIMessages.ValidityView_Action_ForceRefresh_ImageLocation);
		setImageDescriptor(ImageDescriptor.createFromURL(image));
	}

	@Override
	public void run() {
		validityManager.forceRefresh();
//		validityView.getConstrainingNodesViewer().refresh();
//		validityView.getValidatableNodesViewer().refresh();
	}
}
