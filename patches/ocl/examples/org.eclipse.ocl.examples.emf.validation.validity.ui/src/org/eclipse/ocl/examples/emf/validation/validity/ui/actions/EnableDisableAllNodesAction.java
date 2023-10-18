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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public final class EnableDisableAllNodesAction extends AbstractFilterAction
{
	private final boolean enableAll;

	public EnableDisableAllNodesAction(@NonNull ValidityView validityView, boolean enableAll, boolean isValidatableFilterAction) {
		super(enableAll ? ValidityUIMessages.ValidityView_Action_SelectAllNodes_Title
				: ValidityUIMessages.ValidityView_Action_DeselectAllNodes_Title,
				0, validityView, isValidatableFilterAction);
		this.enableAll = enableAll;
		setToolTipText(isValidatableFilterAction
				? enableAll ? ValidityUIMessages.ValidityView_Action_SelectAllValidatableNodes_ToolTipText
						: ValidityUIMessages.ValidityView_Action_DeselectAllValidatableNodes_ToolTipText
						: enableAll ? ValidityUIMessages.ValidityView_Action_SelectAllConstrainingNodes_ToolTipText
								: ValidityUIMessages.ValidityView_Action_DeselectAllConstrainingNodes_ToolTipText);
		setImage(enableAll ? ValidityUIMessages.ValidityView_Action_SelectAllNodes_ImageLocation
				: ValidityUIMessages.ValidityView_Action_DeselectAllNodes_ImageLocation);
	}

	@Override
	public void run() {
		if (this.isEnabled()) {
			RootNode rootNode = validityView.getValidityManager().getRootNode();
			if (rootNode != null) {
				updateAll(isValidatableAction ? ClassUtil.nullFree(rootNode.getValidatableNodes()) : ClassUtil.nullFree(rootNode.getConstrainingNodes()));
				validityView.redraw();
			}
		}
	}

	protected void updateAll(@NonNull Iterable<@NonNull ? extends AbstractNode> nodes) {
		for (@NonNull AbstractNode node : nodes) {
			node.setEnabled(enableAll);
			updateAll(ClassUtil.nullFree(node.getChildren()));
		}
	}
}