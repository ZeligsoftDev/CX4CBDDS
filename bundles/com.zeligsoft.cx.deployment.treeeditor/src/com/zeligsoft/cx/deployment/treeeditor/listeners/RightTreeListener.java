/**
 * Copyright 2018 ADLINK Technology Limited.
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

package com.zeligsoft.cx.deployment.treeeditor.listeners;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentView;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.ui.DeploymentFormPage;
import com.zeligsoft.cx.deployment.treeeditor.ui.DeploymentTreeEditor;
import com.zeligsoft.cx.deployment.ui.commands.CreateAllocationCommand;
import com.zeligsoft.cx.deployment.ui.commands.ReallocateCommand;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * This class implements the drop target listener, the drag source listener. The
 * drop target listener enables the user to drag an object from the left tree
 * into the right tree. The drag source listener enables the user to drag an
 * object from the right tree into itself. This is mostly used for redeploying.
 * 
 * @author sduchesneau
 * 
 */
public class RightTreeListener extends ViewerDropAdapter implements
		DragSourceListener {

	private DeploymentFormPage formPage;
	private DeploymentView view;
	
	/**
	 * Constructor
	 * 
	 * @param DeploymentFormPage formPage
	 * @param DeploymentView view
	 * @param Viewer treeViewer
	 */
	public RightTreeListener(DeploymentFormPage formPage, 
			DeploymentView view,
			Viewer treeViewer) {
		super(treeViewer);
		this.formPage = formPage;
		this.view = view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd
	 * .DragSourceEvent)
	 */
	@Override
	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd
	 * .DragSourceEvent)
	 */
	@Override
	public void dragSetData(DragSourceEvent event) {
		TreeItem item = formPage.getRightTree().getSelection()[0];
		formPage.dragData = item.getData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.
	 * DragSourceEvent)
	 */
	@Override
	public void dragStart(DragSourceEvent event) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean performDrop(Object data) {

		Property target = null;

		if (getCurrentTarget() != null) {
			target = (Property) getCurrentTarget();
		}

		Shell shell = Display.getCurrent().getActiveShell();
		
		List<Property> partsToDeploy = new ArrayList<Property>();
		CompositeCommand compositeCommand = new CompositeCommand(DeploymentEditorMessages.RightTreeListener_DeployCmd);
		
		for (Object eobj : (List) formPage.dragData) {

			if(!(eobj instanceof Property)){
				return false;
			}
			// check if this is a redeployment
			boolean isRedeployment = false;
			boolean isValidRedeployment = true;
			Property source = (Property) eobj;
			Property tmpPart = source;
			partsToDeploy.add(source);

			if (ZDeploymentUtil.getDeploymentTargetPart(tmpPart) == null)
				isValidRedeployment = false;

			while (tmpPart != null) {
				if (ZDeploymentUtil.getDeploymentTargetPart(tmpPart) != null) {
					isRedeployment = true;
					break;
				}

				tmpPart = ZDeploymentUtil.getParentPart(tmpPart);
			}

			if (isRedeployment == true && isValidRedeployment == false) {
				Status status = new Status(
						IStatus.ERROR,
						DeploymentTreeEditor.DEPLOYMENT_TREE_EDITOR_ID,
						0,
						DeploymentEditorMessages.RightTreeListener_InvalidRedeployErrorReason,
						null);
				ErrorDialog
						.openError(
								shell,
								DeploymentEditorMessages.RightTreeListener_InvalidRedeployErrorTitle,
								DeploymentEditorMessages.RightTreeListener_InvalidRedeployErrorMsg,
								status);
				return false;
			}

			// make sure deployment won't create a cycle
			tmpPart = target;

			boolean creatingCycle = false;
			while (tmpPart != null) {
				if (source == tmpPart) {
					creatingCycle = true;
					break;
				}
				if (ZDeploymentUtil.getDeploymentTargetPart(tmpPart) != null)
					tmpPart = ZDeploymentUtil.getDeploymentTargetPart(tmpPart);
				else
					tmpPart = ZDeploymentUtil.getParentPart(tmpPart);

			}

			if (creatingCycle) {
				Status status = new Status(
						IStatus.ERROR,
						DeploymentTreeEditor.DEPLOYMENT_TREE_EDITOR_ID,
						0,
						DeploymentEditorMessages.RightTreeListener_DeploymentCycleErrorReason,
						null);
				ErrorDialog
						.openError(
								shell,
								DeploymentEditorMessages.RightTreeListener_DeploymentCycleErrorTitle,
								DeploymentEditorMessages.RightTreeListener_DeploymentCycleErrorMsg,
								status);
				return false;
			}

			if (target != null) {
				AbstractTransactionalCommand command = null;
				Component deployment = view.getDeployment();

				if (isRedeployment)
					command = new ReallocateCommand(source, target,
							DeploymentEditorMessages.RightTreeListener_RedeployCmd);
				else
					command = new CreateAllocationCommand(deployment, source, target,
							DeploymentEditorMessages.RightTreeListener_DeployCmd);
				compositeCommand.add(command);

			}
		}
		
		final Command emfCommand = GMFtoEMFCommandWrapper.wrap(compositeCommand);

		if (emfCommand.canExecute()) {
			view.getEditingDomain().getCommandStack().execute(emfCommand);
			view.add(partsToDeploy);
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validateDrop(Object target, int operation,
			TransferData transferType) {
		
		if (formPage.dragData == null){
			return false;
		}
		if (!(formPage.dragData instanceof List)) {
			return false;
		}
		for (Object obj : (List) formPage.dragData) {

			if (!(obj instanceof Property)) {
				return false;
			}

			Collection<Property> deploymentChildren = ZDeploymentUtil
					.getDeploymentChildren((Property) obj);
			
			if (ZDLUtil.isZDLConcept((Property) obj,
					ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
				for (Property p : deploymentChildren) {
					if (ZDLUtil.isZDLConcept(p,
							ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
						return false;
					}
				}
			}
			 
			Property source = (Property) obj;
			if (source.getType() == null) {
				continue;
				// return
				// ValidationUtil.canLink(LinkConstraintContext.DEPLOYMENT,
				// source,
				// ((Property) target).getType());
			}

			if (target == null) {
				continue;
			}

			if ((!(target instanceof Property))
					|| (((Property) target).getType() == null)) {
				return false;
			}

			if (!ValidationUtil.canLink(LinkConstraintContext.DEPLOYMENT, source
					.getType(), ((Property) target).getType())) {
				return false;
			}
		}
		return true;
	}

}
