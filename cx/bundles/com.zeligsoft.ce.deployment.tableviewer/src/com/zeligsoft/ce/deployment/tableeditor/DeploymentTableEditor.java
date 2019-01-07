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

package com.zeligsoft.ce.deployment.tableeditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.ce.deployment.Deployment;
import com.zeligsoft.ce.deployment.DeploymentPart;
import com.zeligsoft.ce.deployment.bridge.rsm.RunnableModelReader;
import com.zeligsoft.ce.deployment.bridge.rsm.ZDLModelListener;
import com.zeligsoft.ce.deployment.provider.DeploymentItemProviderAdapterFactory;

/**
 * This is the core table editor. It uses a table and table viewer. The table viewer uses a
 * label provider and content provider. We also store a copy of the deployment and a copy of the
 * column names for the use of the helper classes.
 * 
 * @author smcfee
 *
 */
public class DeploymentTableEditor extends EditorPart {

	private AdapterFactoryEditingDomain editDomain;
	private Table table;
	private TableViewer tableViewer;
	
	
	// This is how we tell the cell modifier that we are working with the first row.
	public String MAGIC_STRING = "ZELIGSOFT_DEPLOYMENT_NAME";
	
	private String[] columnNames; // we have to keep a local copy of the table column names
	
	private Deployment deployment; // the deployment we are working with
	private CommandStack commandStack;
	
	/**
	 * Initializes the table and loads the file that was specified when invoking the editor.
	 */
	public void init(IEditorSite site, IEditorInput input) throws PartInitException 
	{
		setSite(site); 
		setInput(input);		
		
		deployment = null;
		
		// Try to load the deployment in the file. If this fails for some reason, we'll use the model reader to create and save a new deployment.
		try
		{
			ResourceSet resourceSet = UMLModeler.getEditingDomain().getResourceSet();
			URI fileURI = URI.createFileURI((((org.eclipse.ui.part.FileEditorInput)input).getFile()).getRawLocation().toString());
			Resource deploymentResource = resourceSet.getResource(fileURI, true);
			deployment = (Deployment)deploymentResource.getContents().get(0);			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		// Use the model reader to set up the deployment.
		if( deployment == null )
		{
			try 
			{
				// This code reads a UML model to set our initial deployment.
				RunnableModelReader rmr = new RunnableModelReader();
				UMLModeler.getEditingDomain().runExclusive(rmr);
				deployment = (Deployment)rmr.getResult();				
			}
			catch (InterruptedException e)
			{
				System.out.println("The operation was interrupted");
			}
		}
		
		// Set up our UML model listener.
		UMLModeler.getEditingDomain().addResourceSetListener(new ZDLModelListener(deployment));
	}

	public void createPartControl(Composite parent) 
	{
		this.addChildControls(parent);		
	}
	
	/**
	 * Create the table and table viewer and set up the providers for the viewer.
	 */
	private void addChildControls(Composite composite) {

		// Create a composite to hold the children
		GridData gridData = new GridData (GridData.HORIZONTAL_ALIGN_FILL | GridData.FILL_BOTH);		
		composite.setLayoutData (gridData);
	
		// Create the table and the table viewer.
		createTable(composite);
		createTableViewer();				

		// Use the default adapter factory content provider using our EMF.Edit adapter factory.
		DeploymentItemProviderAdapterFactory factory = new DeploymentItemProviderAdapterFactory();
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(factory));
		
		// We have to subclass from the default AdapterFactoryLabelProvider in order to change cell color.
		tableViewer.setLabelProvider(new DeploymentTableLabelProvider(factory, this));
							
		tableViewer.setInput(deployment);	
		
		commandStack = new BasicCommandStack();
		
		editDomain = new AdapterFactoryEditingDomain(factory, commandStack);
	}
	
	/**
	 * Create the table. 
	 */
	private void createTable(Composite parent) {
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
					SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = new Table(parent, style);
		
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		table.setLayoutData(gridData);		
					
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn column = new TableColumn(table, SWT.CENTER, 0);		
		column.setText("Deployment Table");
		column.setWidth(150);		
		
		List<String> columnList = createColumnList();
		
		for( int i = 0; i < columnList.size(); i++ ) {
			column = new TableColumn(table, SWT.CENTER, i + 1);
			//column.setText(columnList.get(i));
			column.setWidth(100);
		}	

	}	
			
	/**
	 * Create the table viewer, which is where we set up the column properties and the editors.
	 */
	private void createTableViewer() {

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
				
		// Create the column list.
		List<String> columnList = createColumnList();	
		columnNames = new String[columnList.size() + 1]; // first column is always there
		columnNames[0] = MAGIC_STRING; 
		for( int i = 0; i < columnList.size(); i++ ) {
			columnNames[i+1] = columnList.get(i).toString();
		}
		tableViewer.setColumnProperties(columnNames);

		
		// Create the cell editors.
		CellEditor[] editors = new CellEditor[columnList.size() + 1];
		
		// Name cell.
		TextCellEditor textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[0] = textEditor;
		
		// Deployment cells.		
		for( int i = 0; i < columnList.size(); i++) {			
			textEditor = new TextCellEditor(table);
			((Text) textEditor.getControl()).setTextLimit(60);
			editors[i + 1] = textEditor;
			
		}

		// Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new DeploymentTableCellModifier(this));		
	}

	/**
	 * Dispose of resources when the table is closed. If we start using SWT fonts in the label provider
	 * this may have to invoke dispose there too.
	 */
	public void close() {
		Shell shell = table.getShell();

		if (shell != null && !shell.isDisposed())
			shell.dispose();
	}	

	/**
	 * Save the table by serializing the EMF resource.
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		
		try
		{			
			ResourceSet resourceSet = new ResourceSetImpl();
			URI fileURI = URI.createFileURI((((org.eclipse.ui.part.FileEditorInput)getEditorInput()).getFile()).getRawLocation().toString());
			Resource deploymentResource = resourceSet.createResource(fileURI);
			deploymentResource.getContents().add(deployment);
			deploymentResource.save(null);
		}
		catch( Exception exception )
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * If the UML model is dirty the deployment model is dirty (I guess).
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)UMLModeler.getEditingDomain().getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Returns the deployment.
	 */
	public Deployment getDeployment() {
		return deployment;
	}
	
	/**
	 * Returns the editing domain. This may be too much access but if so, we can remove later.
	 */
	public AdapterFactoryEditingDomain getEditDomain() {
		return editDomain;
	}
	
	/**
	 * Returns a list of column names for the deployment, which right now is a flat list of parts.
	 */ 
	public List<String> createColumnList() 
	{
		ArrayList<DeploymentPart> a = deployment.getDeploymentParts();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for( int i = 0; i < a.size(); i++ )
		{			
			retVal.add(((DeploymentPart)((a).get(i))).getId());
		}
		
		return retVal;
	}
	
	/**
	 * Function to regenerate the column list for the table.
	 */
	public void resetColumns()
	{
		List<String> columnList = createColumnList();

		// This code assumes that things get added to the deployment but not removed.
		for( int i = 0; i < columnList.size(); i++ ) 
		{
			boolean found = false;
			for( int j = 0; j < columnNames.length; j++ )
			{
				if( columnNames[j] == columnList.get(i))
				{
					found = true;
				}
			}
			if( !found )
			{
				TableColumn tc = new TableColumn(table, SWT.CENTER, i + 1);
				tc.setWidth(100);
			}			
		}	
		
		// Re-create the column list.			
		columnNames = new String[columnList.size() + 1]; // first column is always there
		columnNames[0] = MAGIC_STRING; 
		for( int i = 0; i < columnList.size(); i++ ) {
			columnNames[i+1] = columnList.get(i).toString();
		}
		tableViewer.setColumnProperties(columnNames);
		
		// Create the cell editors again. This could be more efficient.
		CellEditor[] editors = new CellEditor[columnList.size() + 1];
		
		// Name cell.
		TextCellEditor textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[0] = textEditor;
		
		// Deployment cells.		
		for( int i = 0; i < columnList.size(); i++) {			
			textEditor = new TextCellEditor(table);
			((Text) textEditor.getControl()).setTextLimit(60);
			editors[i + 1] = textEditor;			
		}

		// Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
	}
	
	/**
	 * Force a refresh of the table viewer.
	 */
	public void refresh()
	{
		// If I don't call this the number of columns stays the same even when parts have been 
		// added, which causes some parts to fall off the end.
		resetColumns();
		
		tableViewer.refresh(true);
	}
		
}
