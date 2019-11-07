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
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.validation.util.ValidationUtil;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.cx.deployment.treeeditor.DeploymentView;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.providers.StructuralRealizationSelectionLabelProvider;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;
import com.zeligsoft.cx.deployment.treeeditor.ui.DeploymentFormPage;
import com.zeligsoft.cx.deployment.ui.commands.AddModelElementCommand;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * This class implements the drag source listener and drop target listener. The
 * drop target listener is implemented to allow the user to drag a
 * component/object from the package explorer into the left tree. The drag
 * source listener is implemented for enabling the user to drag something from
 * the left tree to the right tree.
 *
 * @author sduchesneau
 *
 */
public class LeftTreeListener
        extends ViewerDropAdapter implements DragSourceListener{

    private DeploymentFormPage formPage;
    private DeploymentView view;
   
    /**
     * Constructor
     * 
     * @param DeploymentFormPage formPage
     * @param DeploymentView view
     * @param Viewer treeViewer
     */
    public LeftTreeListener(DeploymentFormPage formPage, DeploymentView view, Viewer treeViewer) {
        super(treeViewer);
        this.formPage = formPage;
        this.view = view;

    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
     */
    @Override
	public void dragFinished(DragSourceEvent event) {
    	formPage.dragData = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
     */
    @Override
	public void dragSetData(DragSourceEvent event) {
		formPage.dragData = getDragData();
	}

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
     */
    @Override
	public void dragStart(DragSourceEvent event) {
		formPage.dragData = getDragData();
    }
    
    /**
	 * Queries the drag data
	 * 
	 * @return
	 */
	private List<EObject> getDragData() {
		List<EObject> data = new ArrayList<EObject>();
		for (TreeItem item : formPage.getLeftTree().getSelection()) {

			if (item.getData() instanceof EObject) {
				data.add((EObject) item.getData());
			}
		}
		return data;
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public boolean performDrop(Object data) {

		Shell shell = formPage.getLeftTree().getShell();
		if (!(data instanceof ISelection)){
			return true;
		}

		final CompositeCommand compositeCommand = new CompositeCommand(
				DeploymentEditorMessages.LeftTreeListener_AddComponentCmd);
		for (EObject selObject : BaseUIUtil.getEObjectsFromSelection((ISelection) data)) {

			final Component selComponent = (Component) selObject;
			Component deployment = view.getDeployment();

			TransactionalEditingDomain domain = TransactionUtil
					.getEditingDomain(deployment);
			RunnableWithResult runnable = new RunnableWithResult.Impl() {

				@Override
				public void run() {
					setResult(ZDeploymentUtil.getStructuralRealizations(selComponent));
				}

			};

			ArrayList<Component> srList = null;
			try {
				srList = (ArrayList<Component>) domain.runExclusive(runnable);
			} catch (Exception e) {
				Activator.getDefault().error(
						DeploymentEditorMessages.LeftTreeListener_AddingPartErrorMsg, e);
			}

			Component structuralRealization = null;

			if (srList.size() == 1) {
				structuralRealization = srList.get(0);
			} else if (srList.size() > 1) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell,
						new StructuralRealizationSelectionLabelProvider());
				dialog.setElements(srList.toArray());
				dialog
						.setTitle(DeploymentEditorMessages.LeftTreeListener_SelectStructuralRealizationDlg);
				dialog.setMultipleSelection(false);
				dialog.open();
				structuralRealization = (Component) dialog.getFirstResult();
				dialog.close();
				dialog = null;
			}

			AddModelElementCommand command = new AddModelElementCommand(deployment,
					selComponent, null, structuralRealization,
					DeploymentEditorMessages.LeftTreeListener_AddComponentCmd);
			compositeCommand.add(command);
		}
		
		final Command emfCommand = GMFtoEMFCommandWrapper.wrap(compositeCommand);

		if (emfCommand.canExecute()) {
			Runnable runCommand = new Runnable() {

				@Override
				public void run() {
					view.getEditingDomain().getCommandStack().execute(emfCommand);
				}
			};

			BusyIndicator.showWhile(Display.getCurrent(), runCommand);
		}
		formPage.refresh();

		return true;
	}

    @Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {

		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection == null) {
			return false;
		}
		for (EObject eo : BaseUIUtil.getEObjectsFromSelection(selection)) {
			if (!ValidationUtil.canLink(LinkConstraintContext.DEPLOYMENT_PART_CONFIGURE,
					eo, view.getDeployment())) {
				return false;
			}
		}
		return true;
	}
    
}

