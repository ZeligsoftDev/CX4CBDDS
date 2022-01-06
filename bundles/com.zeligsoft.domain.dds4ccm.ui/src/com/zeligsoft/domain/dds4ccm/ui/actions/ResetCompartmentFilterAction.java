/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.ui.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewServiceUtil;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideCompartmentRequest;
import org.eclipse.papyrus.uml.diagram.menu.actions.ShowHideCompartmentAction;
import org.eclipse.ui.PlatformUI;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Reset Show/Hide compartment action
 * 
 * @author Young-Soo Roh
 *
 */
public class ResetCompartmentFilterAction extends ShowHideCompartmentAction {

	static final String INTERNAL_STRUCTURE = "internal structure"; //$NON-NLS-1$

	@Override
	public void run(IAction action) {
		if (!canRun()) {
			return;
		}

		initAction();
		buildInitialSelection();
		if (representations.isEmpty()) {
			return;
		}

		this.viewsToCreate = new ArrayList<EditPartRepresentation>();
		this.viewsToDestroy = new ArrayList<EditPartRepresentation>();
		EditPartRepresentation selectedElement = representations.get(0);
		List<EditPartRepresentation> children = selectedElement.getPossibleElement();
		EObject semanticElement = selectedElement.getSemanticElement();
		if (semanticElement == null) {
			return;
		}
		boolean isPart = ZDLUtil.isZDLConcept(semanticElement, CCMNames.CCMPART);
		for (EditPartRepresentation epr : children) {
			if (!isPart && INTERNAL_STRUCTURE.equals(epr.getLabel())) {
				if (!initialSelection.contains(epr)) {
					viewsToCreate.add(epr);
				}
			} else {
				if (initialSelection.contains(epr)) {
					viewsToDestroy.add(epr);
				}
			}
		}

		final Command command = getActionCommand();
		final TransactionalEditingDomain domain = this.selectedElements.get(0).getEditingDomain();
		if (command.canExecute()) {
			try {
				domain.runExclusive(new Runnable() {

					@Override
					public void run() {
						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

							// executing the command
							@Override
							public void run() {
								domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
							}
						});
					}
				});
			} catch (InterruptedException e) {
				com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(e.getMessage(), e);
			}
		}
	}

	@Override
	protected Command getActionCommand() {
		ViewServiceUtil.forceLoad();

		ShowHideCompartmentRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Destroy and Create Compartment Command"); //$NON-NLS-1$
		// the commands to hide compartment
		for (EditPartRepresentation current : this.viewsToDestroy) {
			if (current instanceof CompartmentEditPartRepresentation) {
				CompartmentEditPartRepresentation currentRepresentation = (CompartmentEditPartRepresentation) current;
				View currentView = currentRepresentation.getCompartmentView();
				EditPart currentEditPart = currentRepresentation.getRepresentedEditPart(); // should not be null,
				if (currentEditPart == null) {
					com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().warning(
							"Warning! An edit part representation wished to destroy a view, but no edit part exists currently!" //$NON-NLS-1$
									+ current);
					currentEditPart = DiagramEditPartsUtil.getEditPartFromView(currentView, selectedElements.get(0))
							.getParent();
				}

				if (currentEditPart != null) {
					req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.HIDE, currentView);
					req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
					Command tmp = currentEditPart.getCommand(req);
					if (tmp != null && tmp.canExecute()) {
						completeCmd.add(tmp);
					}
				} else {
					com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().warning("Impossible to find an edit part for the given representation: " + current); //$NON-NLS-1$
				}
			}
		}

		// the command to show compartment
		for (EditPartRepresentation current : this.viewsToCreate) {
			if (current instanceof CompartmentEditPartRepresentation) {
				CompartmentEditPartRepresentation currentRepresentation = (CompartmentEditPartRepresentation) current;
				View currentView = currentRepresentation.getCompartmentView();
				EditPartRepresentation parentRepresentation = currentRepresentation.getParentRepresentation();
				IGraphicalEditPart parentEditPart = parentRepresentation.getRepresentedEditPart();
				if (currentView != null && parentEditPart != null) {
					req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, currentView);
					req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
					Command tmp = parentEditPart.getCommand(req);
					if (tmp != null && tmp.canExecute()) {
						completeCmd.add(tmp);
					}
				}
			}
		}

		EditPartRepresentation selectedElement = representations.get(0);
		List<EditPartRepresentation> children = selectedElement.getPossibleElement();
		for (EditPartRepresentation child : children) {
			if (!(child instanceof CompartmentEditPartRepresentation)) {
				continue;
			}

			if (INTERNAL_STRUCTURE.equals(child.getLabel())) {
				continue;
			}

			// Turn off visibility which cannot be done via diagram menu
			CompartmentEditPartRepresentation currentRepresentation = (CompartmentEditPartRepresentation) child;
			final View currentView = currentRepresentation.getCompartmentView();
			IGraphicalEditPart parentEditPart = currentRepresentation.getParentRepresentation()
					.getRepresentedEditPart();
			final TransactionalEditingDomain domain = parentEditPart.getEditingDomain();
			if (currentView.isVisible()) {
				completeCmd.add(new ICommandProxy(
						new AbstractTransactionalCommand(domain, "Set Visibility", Collections.emptyList()) { //$NON-NLS-1$

							@Override
							public CommandResult doExecuteWithResult(IProgressMonitor dummy, IAdaptable info) {
								currentView.setVisible(false);
								return CommandResult.newOKCommandResult();
							}
						}));
			}
		}

		return completeCmd;
	}
}
