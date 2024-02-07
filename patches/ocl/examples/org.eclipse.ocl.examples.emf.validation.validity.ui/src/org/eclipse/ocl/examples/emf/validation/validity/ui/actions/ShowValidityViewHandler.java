/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.EditorPart;

public class ShowValidityViewHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object applicationContext = event.getApplicationContext();
		Object editorPart = HandlerUtil.getVariable(applicationContext, ISources.ACTIVE_EDITOR_NAME);
		Object shell = HandlerUtil.getVariable(applicationContext, ISources.ACTIVE_SHELL_NAME);
		if (!(shell instanceof Shell) || !(editorPart instanceof EditorPart)) {
			return null;
		} 
		
		EditorPart editorPartInstance = (EditorPart) editorPart;
		IWorkbenchPartSite site = editorPartInstance.getSite();
		updateValidityView(site, true, true);
			
		return null;
	}
	
	/**
	 * Finds an opened validity view, opening a new one if it is not opened and <code>openAsNeeded</code> is
	 * <code>true</code>, then update its content according to the current site's selection and optionally
	 * re-run the validation.
	 * 
	 * @param site The workbench site which validity view should be refreshed.
	 * @param openAsNeeded If <code>true</code>, we will try and open the validity view in case in is not currently displayed.
	 * @param runValidation If <code>true</code>, we will relaunch the validation on the new content of the view.
	 */
	private void updateValidityView(IWorkbenchPartSite site, boolean openAsNeeded, boolean runValidation) {
		IViewReference[] openViews = site.getPage().getViewReferences();
		if (isValidityViewOpen(openViews) || openAsNeeded) {
			try {
				site.getPage().showView(ValidityView.ID);
			} catch (PartInitException e) {
				// Failed to show the validity view
				return;
			}
		} else {
			return;
		}
		
		IWorkbenchPart part = site.getPart();
		IViewReference validityViewReference = site.getPage().findViewReference(ValidityView.ID, null);
		IViewPart viewPart = validityViewReference.getView(true);
		if (viewPart instanceof ValidityView) {
			ValidityView validityView = (ValidityView) viewPart;
			validityView.selectionChanged(part, site.getSelectionProvider().getSelection());
			
			if (runValidation) {
				RunValidityAction runValidationAction = new RunValidityAction(validityView, null);
				runValidationAction.run();
			}
		}
		viewPart.setFocus();
	}
	
	private boolean isValidityViewOpen(IViewReference[] openViews) {
		for(IViewReference view : openViews){
			if (ValidityView.ID.equals(view.getId())){
				return true;
			}
		}
		return false;
	}
}
