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
import org.eclipse.jface.action.IAction;
import org.eclipse.ocl.examples.emf.validation.validity.ui.filters.UnusedNodesVisibilityFilter;
import org.eclipse.ocl.examples.emf.validation.validity.ui.messages.ValidityUIMessages;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;

public final class DisableAllUnusedNodesAction extends AbstractFilterAction
{
	private @NonNull UnusedNodesVisibilityFilter filter = new UnusedNodesVisibilityFilter();
	
	public DisableAllUnusedNodesAction(@NonNull ValidityView validityView, boolean isValidatableFilterAction) {
		super(ValidityUIMessages.ValidityView_Action_ShowHideUnusedNodes_Title,
				IAction.AS_CHECK_BOX, validityView, isValidatableFilterAction);
		setChecked(true);
	}

	public void refreshChecked() {
		if (this.isChecked()){
			setToolTipText(isValidatableAction ? ValidityUIMessages.ValidityView_Action_ShowUnusedValidatableNodes_ToolTipText
													 : ValidityUIMessages.ValidityView_Action_ShowUnusedConstrainingNodes_ToolTipText);
			setImage(ValidityUIMessages.ValidityView_Action_HideUnusedNodes_ImageLocation);
			validityView.addFilter(isValidatableAction, filter);
		} else {
			setToolTipText(isValidatableAction ? ValidityUIMessages.ValidityView_Action_HideUnusedValidatableNodes_ToolTipText
													 : ValidityUIMessages.ValidityView_Action_HideUnusedConstrainingNodes_ToolTipText);
			setImage(ValidityUIMessages.ValidityView_Action_ShowUnusedNodes_ImageLocation);
			validityView.removeFilter(isValidatableAction, filter);
		}
	}

	@Override
	public void run() {
		refreshChecked();
	}

	@Override
	public void setChecked(boolean isChecked) {
		super.setChecked(isChecked);
		refreshChecked();
	}
}