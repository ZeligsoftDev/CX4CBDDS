/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen.ui.wizards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl2zdlgen.l10n.ZDL2ZDLGenMessages;

/**
 * A page in which the user must specify the generator models for any ZML models
 * that are referenced by the model being imported.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ReferencedModelsPage
		extends WizardPage {

	private ZDLImporter importer;

	private AdapterFactory providers;

	private TableViewer ownedModelsTable;

	private ArrayContentProvider ownedModelsTableContent;

	private CheckboxTreeViewer referencedModelsTree;

	private ZDLGenContentProvider referencedModelsTreeContent;

	private boolean hasBeenShown = false; // whether the user has seen the page

	private ZDLImporterListener importerListener = new ZDLImporterListener() {

		@Override
		public void inputModelLoaded(ZDLImporterEvent event) {
			zdlModelLoaded(event.getSource().getGenModel());
		}
	};

	/**
	 * Initializes me with my ZDL importer.
	 * 
	 * @param importer my model importer
	 */
	public ReferencedModelsPage(ZDLImporter importer) {
		super("ReferencedZDLGens", ZDL2ZDLGenMessages.ReferencedModelsPage_title, null); //$NON-NLS-1$
		setDescription(ZDL2ZDLGenMessages.ReferencedModelsPage_description);

		this.importer = importer;
		importer.addListener(importerListener);
	}

	@Override
	public void createControl(Composite parent) {
		SashForm sash = new SashForm(parent, SWT.VERTICAL);

		providers = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		createOwnedModelsGroup(sash);
		createReferencedModelsGroup(sash);

		setControl(sash);

		setPageComplete(false);

		// prime the UI with the current state of the import controller
		zdlModelLoaded(importer.getGenModel());
	}

	/**
	 * Helper that creates the first pane of the page, in which the user is
	 * shown the domain models whose GenDomainModel decorators will be owned
	 * by the new GenModel.
	 * 
	 * @param parent the parent composite
	 */
	private void createOwnedModelsGroup(Composite parent) {
		Composite zdls = new Composite(parent, SWT.NONE);
		zdls.setLayout(new GridLayout(1, false));

		Label label = new Label(zdls, SWT.NONE);
		label.setText(ZDL2ZDLGenMessages.ReferencedModelsPage_importLabel);
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		label.setData(data);

		ownedModelsTable = new TableViewer(zdls, SWT.BORDER);
		data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		ownedModelsTable.getControl().setLayoutData(data);

		ownedModelsTable.setLabelProvider(new AdapterFactoryLabelProvider(
			providers));
		ownedModelsTableContent = new ArrayContentProvider();
		ownedModelsTable.setContentProvider(ownedModelsTableContent);
	}

	/**
	 * Helper that creates the second pane of the page, in which the user is
	 * shown the available registered GenDomainModel decorators for referenced
	 * domain models, that can be reused by the new GenModel.
	 * 
	 * @param parent the parent composite
	 */
	private void createReferencedModelsGroup(Composite parent) {
		Composite zdlgens = new Composite(parent, SWT.NONE);
		zdlgens.setLayout(new GridLayout(1, false));

		Label label = new Label(zdlgens, SWT.None);
		label.setText(ZDL2ZDLGenMessages.ReferencedModelsPage_referenceLabel);
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		label.setData(data);

		referencedModelsTree = new CheckboxTreeViewer(zdlgens, SWT.BORDER);
		data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		referencedModelsTree.getControl().setLayoutData(data);

		referencedModelsTree.setLabelProvider(new NodeLabelProvider(
			new AdapterFactoryLabelProvider(providers)));
		referencedModelsTreeContent = new ZDLGenContentProvider();
		referencedModelsTree.setContentProvider(referencedModelsTreeContent);
		referencedModelsTree.addCheckStateListener(new ICheckStateListener() {
		
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				Node node = (Node) event.getElement();
				node.setSelected(event.getChecked());
			}});
	}

	/**
	 * Handles the (re-)loading of the wizard from the same or a different
	 * source ZDL model.
	 * 
	 * @param genModel a skeleton describing the owned and referenced 
     *    GenDomainModels
	 */
	@SuppressWarnings("deprecation")
	private void zdlModelLoaded(GenModel genModel) {
		List<Model> zdls = new java.util.ArrayList<Model>(genModel
			.getOwnedModels().size());
		for (GenDomainModel next : genModel.getOwnedModels()) {
			zdls.add(next.getDomainModel());
		}
		ownedModelsTable.setInput(zdls);

		referencedModelsTree.setInput(genModel.getReferencedModels());
		referencedModelsTree.expandAll();
		referencedModelsTree.setAllChecked(true);
		
		// user can finish if he has reviewed the selections available on
		// this page, or if there are no selections to be made bec.getExpandeause all
		// genmodels are owned (none available to reference)
		setPageComplete(hasBeenShown
			|| (!genModel.getOwnedModels().isEmpty() && genModel.getReferencedModels().isEmpty()));
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		hasBeenShown = true;
		setPageComplete(true);
	}

	/**
	 * A content-provider for the available GenDomainModels tree.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLGenContentProvider
			implements ITreeContentProvider {

		private List<ZDLNode> zdls = new java.util.ArrayList<ZDLNode>();

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((Node) parentElement).children().toArray();
		}

		@Override
		public Object getParent(Object element) {
			Node result = null;	
			if(element instanceof Node) {
				result = ((Node) element).parent();
			}
			return result;
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof ZDLNode;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return zdls.toArray();
		}

		@Override
		public void dispose() {
			// nothing to do
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			@SuppressWarnings("unchecked")
			List<GenDomainModel> models = (List<GenDomainModel>) newInput;

			zdls.clear();
			if (models != null) {
				for (GenDomainModel next : models) {
					ZDLNode node = new ZDLNode();
					node.zdl = next.getDomainModel();

					node.add(next);

					zdls.add(node);
				}
			}

			if ((viewer != null) && !viewer.getControl().isDisposed()) {
				viewer.refresh();
			}
		}
		
	}

	/**
	 * A simple node object in the tree, that knows when it is selected, serving
	 * as a wrapper for a ZDL domain model or a GenDomainModel.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private abstract class Node {

		private boolean selected = true;  // initial state is always selected
		
		/**
		 * Queries the element that I decorate, that I present in the wizard
		 * page.
		 * 
		 * @return my element
		 */
		abstract EObject element();
		
		/**
		 * Queries my parent node.
		 * 
		 * @return my parent node, or <code>null</code> if I am a root
		 */
		Node parent() {
			return null;
		}

		/**
		 * Queries my child nodes.
		 * 
		 * @return my child nodes, which will be an empty list if I am a leaf
		 */
		List<? extends Node> children() {
			return Collections.emptyList();
		}
		
		/**
		 * Queries whether I am currently selected in the tree.
		 * 
		 * @return whether I am selected
		 */
		boolean isSelected() {
			return selected;
		}
		
		/**
		 * Sets whether I am selected in the tree.  I propagate my selection
		 * state down the tree to all of my descendents.
		 * 
		 * @param selected whether I am selected
		 */
		void setSelected(boolean selected) {
			this.selected = selected;
		}
	}

	/**
	 * A concrete tree node that decorates a ZDL domain model.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLNode
			extends Node {

		private Model zdl;

		private List<ZDLGenNode> children = new java.util.ArrayList<ZDLGenNode>(1);

		@Override
		EObject element() {
			return zdl;
		}
		
		/**
		 * Adds a child node for a GenDomainModel.
		 * 
		 * @param zdlgen the model to wrap in a child node
		 */
		void add(GenDomainModel zdlgen) {
			ZDLGenNode node = new ZDLGenNode();
			node.zdlgen = zdlgen;
			node.parent = this;
			children.add(node);
		}

		@Override
		List<? extends ZDLGenNode> children() {
			return children;
		}
		
		@Override
		void setSelected(final boolean selected) {
			if (isSelected() != selected) {
				super.setSelected(selected);
				
				Set<Object> checked = new java.util.HashSet<Object>(
						Arrays.asList(referencedModelsTree.getCheckedElements()));
				
				if (!children().isEmpty()) {
					// propagate selection down the tree
					for (Node next : children()) {
						next.setSelected(selected);
					}
					
					if (selected) {
						checked.add(this);
						checked.addAll(children());
					} else {
						checked.remove(this);
						checked.removeAll(children());
					}
				}
				
				// set the new selection into the tree
				referencedModelsTree.setCheckedElements(checked.toArray());
			}
		}
	}

	/**
	 * A concrete tree node to decorate a GenDomainModel that is available to
	 * re-use for a reference ZDL model (which is the parent node).
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLGenNode
			extends Node {

		private ZDLNode parent;

		private GenDomainModel zdlgen;

		@Override
		EObject element() {
			return zdlgen;
		}

		@Override
		ZDLNode parent() {
			return parent;
		}
		
		@Override
		void setSelected(boolean selected) {
			if (isSelected() != selected) {
				super.setSelected(selected);
				
				Set<Object> checked = new java.util.HashSet<Object>(
						Arrays.asList(referencedModelsTree.getCheckedElements()));
				
				if (parent() != null) {
					// propagate selection up the tree
					boolean shouldUpdateParent = true;
					
					for (Node sibling : parent().children()) {
						if (sibling.isSelected() != selected) {
							// different check states?  Don't change parent
							shouldUpdateParent = false;
							break;
						}
					}
					
					if (shouldUpdateParent) {
						parent().setSelected(selected);
						
						if (selected) {
							checked.add(parent());
						} else {
							checked.remove(parent());
						}
					}
				}
				
				// set the new selection into the tree
				referencedModelsTree.setCheckedElements(checked.toArray());
				
				// update the gen-model skeleton and the table
				importer.setReferenced(zdlgen, selected);
				
				GenModel genModel = importer.getGenModel();
				List<Model> zdls = new java.util.ArrayList<Model>(genModel
						.getOwnedModels().size());
				for (GenDomainModel next : genModel.getOwnedModels()) {
					zdls.add(next.getDomainModel());
				}
				ownedModelsTable.setInput(zdls);
			}
		}
	}
	
	/**
	 * Custom label provider for the tree that shows labels of the decorated
	 * elements.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class NodeLabelProvider implements ILabelProvider {
		private final ILabelProvider delegate;
		
		/**
		 * Initializes me with a label provider that knows how to get labels
		 * from the decorated elements of tree nodes.
		 * 
		 * @param delegate my delegate provider
		 */
		NodeLabelProvider(ILabelProvider delegate) {
			this.delegate = delegate;
		}

		@Override
		public Image getImage(Object element) {
			return delegate.getImage(((Node) element).element());
		}

		@Override
		public String getText(Object element) {
			return delegate.getText(((Node) element).element());
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return delegate.isLabelProperty(((Node) element).element(), property);
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
			delegate.addListener(listener);
		}

		@Override
		public void dispose() {
			delegate.dispose();
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			delegate.removeListener(listener);
		}
	}
}
