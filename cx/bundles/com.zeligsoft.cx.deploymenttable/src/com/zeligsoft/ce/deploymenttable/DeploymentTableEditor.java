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

package com.zeligsoft.ce.deploymenttable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.ce.deployment.controller.rsm.RSMDeploymentController;
import com.zeligsoft.ce.deployment.provider.DeploymentItemProviderAdapterFactory;
import com.zeligsoft.ce.tableeditor.TableEditor;


public class DeploymentTableEditor extends EditorPart
{
	TableEditor editor;
	Component deployment;
	RSMDeploymentController controller;

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
	public void init(IEditorSite site, IEditorInput input) throws PartInitException
	{
		setSite(site);
		setInput(input);
		
		URI fileURI = URI.createFileURI((((org.eclipse.ui.part.FileEditorInput)input).getFile()).getRawLocation().toString());
		controller = new RSMDeploymentController(fileURI);		
		deployment = controller.getDeployment(); // needed as long as class is directly using deployment		
	}

	@Override
	public boolean isDirty()
	{
		return controller.isDirty();
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
		
		DeploymentItemProviderAdapterFactory factory = new DeploymentItemProviderAdapterFactory();
		AdapterFactoryContentProvider treeContentProvider = new AdapterFactoryContentProvider(factory);
		AdapterFactoryLabelProvider treeLabelProvider = new AdapterFactoryLabelProvider(factory);
		
		editor.setHorizontalTreeContentProvider(treeContentProvider);
		editor.setHorizontalTreeLabelProvider(treeLabelProvider);
		
		editor.setVerticalTreeContentProvider(treeContentProvider);
		editor.setVerticalTreeLabelProvider(treeLabelProvider);
		
		editor.setTableLabelProvider(new DeploymentTableLabelProvider(factory));
		editor.setTableModifier(new DeploymentTableCellModifier());
		
		editor.setHorizontalTreeInput(deployment);
		editor.setVerticalTreeInput(deployment);
		
		editor.setImageStream(getClass().getResourceAsStream("header.gif"));
		
		editor.setCallback(new DeploymentTableEditorCallback(editor));
		
		editor.createTableEditor();
		
		
	}

	@Override
	public void setFocus()
	{
		// TODO Auto-generated method stub

	}

	protected TableEditor getEditor()
	{
		return editor;
	}

}
