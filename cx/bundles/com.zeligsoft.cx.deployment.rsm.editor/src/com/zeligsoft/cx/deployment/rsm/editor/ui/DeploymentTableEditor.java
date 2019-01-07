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

package com.zeligsoft.cx.deployment.rsm.editor.ui;


import java.util.Iterator;

import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;

import com.ibm.xtools.uml.navigator.ModelServerElement;
import com.zeligsoft.ce.tableeditor.TableEditor;
import com.zeligsoft.cx.deployment.rsm.editor.DeploymentEditorInput;
import com.zeligsoft.cx.deployment.rsm.editor.providers.DeploymentTableEditorCallback;
import com.zeligsoft.cx.deployment.rsm.editor.providers.TreeContentProvider;
import com.zeligsoft.cx.deployment.rsm.editor.providers.TreeLabelProvider;
import com.zeligsoft.deployment.rsm.tooling.ext.commands.AddModelElementCommand;
import com.zeligsoft.deployment.rsm.tooling.ext.listeners.RSMDeploymentController;
import com.zeligsoft.deployment.rsm.tooling.ext.utils.ZDeploymentUtil;

/**
 * This is the main class for the deployment table editor.  It activates the table, sets it with the correct input, sets
 * the callbacks and listeners for the table editor.
 * 
 *  @author sduchesneau
 */
public class DeploymentTableEditor extends EditorPart
{
	private TableEditor editor;
	private Component deployment;
	private RSMDeploymentController controller;
	private ResourceSetListenerImpl listener;
	private TransactionalEditingDomain domain;	

	@Override
	public void doSave(IProgressMonitor monitor)
	{
		controller.save();
	}

	@Override
	public void doSaveAs()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose(){
		
		if (listener != null)
			domain.removeResourceSetListener(listener);
		super.dispose();
		
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException
	{
		setSite(site);
		setInput(input);
		
		if (input instanceof DeploymentEditorInput)
		{
			deployment = ((DeploymentEditorInput) input).getDeployment();
			controller = new RSMDeploymentController(deployment);
		}
		
		final DeploymentTableEditor thisEditor = this;
		final IWorkbenchPage page = site.getWorkbenchWindow().getActivePage();

		listener = new ResourceSetListenerImpl() {

			@SuppressWarnings("unchecked")
			public void resourceSetChanged(ResourceSetChangeEvent event) {

				for (Iterator iter = event.getNotifications().iterator(); iter
						.hasNext();) {
					Notification notification = (Notification) iter.next();

					if (notification.getOldValue() != null
							&& notification.getOldValue() instanceof Component) {
						Component component = (Component) notification
								.getOldValue();

						// Close editor when either deployment is deleted or the
						// stereotype has been removed
						if (component.equals(deployment)
								&& notification.getNewValue() == null) {
							if (deployment.eResource() == null
									|| component
											.getAppliedStereotype(ZDeploymentUtil.QUALIFIED_DEPLOYMENT_STEREOTYPE_NAME) == null) {
								page.closeEditor(thisEditor, false);
							}
						}
					}
				}
			}
		};
		domain = TransactionUtil.getEditingDomain(deployment);
		domain.addResourceSetListener(listener);
		
	}

	@Override
	public boolean isDirty()
	{
		return controller.isDirty();
		//return false;
	}

	@Override
	public boolean isSaveAsAllowed()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent)
	{
		editor = new TableEditor(parent, 0); // style = 0
		
		editor.setHorizontalTreeContentProvider(new TreeContentProvider());
		editor.setHorizontalTreeLabelProvider(new TreeLabelProvider());
		
		editor.setVerticalTreeContentProvider(new TreeContentProvider());
		editor.setVerticalTreeLabelProvider(new TreeLabelProvider());
		
		editor.setHorizontalTreeInput(deployment);
		editor.setVerticalTreeInput(deployment);
		
		editor.setImageStream(getClass().getResourceAsStream("header.gif"));
		
		editor.setCallback(new DeploymentTableEditorCallback(editor, deployment));		
		
		editor.setVerticalTreeDropListener(createVerticalTreeDropListener());
		editor.setHorizontalTreeTableDropListener(createHorizontalTreeTableDropListener());
		
		editor.createTableEditor();	
		
	}
	
	/**
	 * This creates the drop listener for the vertical tree.  This drop listener takes the dragged object
	 * from the project explorer (usually a component) and adds it to the current deployment.
	 */
	public DropTargetListener createVerticalTreeDropListener()
	{
		DropTargetListener dropTargetListener = new DropTargetListener() 
		{
			public void dragEnter(DropTargetEvent event)
			{
				
			}

			public void dragLeave(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}

			public void dragOperationChanged(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}

			public void dragOver(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}

			public void drop(DropTargetEvent event)
			{
				
				if (!(event.data instanceof TreeSelection))
					return;
				
				TreeSelection treeSelection = (TreeSelection) event.data;				
				
				if (!(treeSelection.getFirstElement() instanceof ModelServerElement))
					return;
				
				ModelServerElement serverElement = (ModelServerElement) treeSelection.getFirstElement();
					
				if (!(serverElement.getElement() instanceof NamedElement))
					return;

				NamedElement newElement = (NamedElement) serverElement.getElement();
				AddModelElementCommand command = new AddModelElementCommand(deployment, newElement, null, "Add Component");
					
				try
				{
					OperationHistoryFactory.getOperationHistory().execute(command, null, null);
				}
				catch (Exception ex)
				{
					// whateva
				}
				
				//editor.setVerticalTreeInput(deployment);
				
				// TODO remove this when we use separate inputs or when listening works correctly with horizontal tree table
				editor.setHorizontalTreeInput(deployment);
				editor.refresh();
			}

			public void dropAccept(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}		
		};
		
		return dropTargetListener;		
	}
	
	/**
	 * This creates the drop listener for the horizontal tree table.  This drop listener takes the dragged object
	 * from the project explorer (usually a component) and adds it to the current deployment.
	 */
	public DropTargetListener createHorizontalTreeTableDropListener()
	{
		DropTargetListener dropTargetListener = new DropTargetListener() 
		{
			public void dragEnter(DropTargetEvent event)
			{
				
			}

			public void dragLeave(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}

			public void dragOperationChanged(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}

			public void dragOver(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}

			public void drop(DropTargetEvent event)
			{
				
				if (!(event.data instanceof TreeSelection))
					return;
				
				TreeSelection treeSelection = (TreeSelection) event.data;				
				
				if (!(treeSelection.getFirstElement() instanceof ModelServerElement))
					return;
				
				ModelServerElement serverElement = (ModelServerElement) treeSelection.getFirstElement();
					
				if (!(serverElement.getElement() instanceof NamedElement))
					return;

				NamedElement newElement = (NamedElement) serverElement.getElement();
				AddModelElementCommand command = new AddModelElementCommand(deployment, newElement, null, "Add Component");
					
				try
				{
					OperationHistoryFactory.getOperationHistory().execute(command, null, null);
				}
				catch (Exception ex)
				{
					// whateva
				}
				// TODO remove this when listening works correctly with horizontal tree table
				editor.setHorizontalTreeInput(deployment);
				editor.refresh();
			}

			public void dropAccept(DropTargetEvent event)
			{
				// TODO Auto-generated method stub
				
			}		
		};
		
		return dropTargetListener;		
	}

	@Override
	public void setFocus()
	{
		// TODO Auto-generated method stub

	}

}
