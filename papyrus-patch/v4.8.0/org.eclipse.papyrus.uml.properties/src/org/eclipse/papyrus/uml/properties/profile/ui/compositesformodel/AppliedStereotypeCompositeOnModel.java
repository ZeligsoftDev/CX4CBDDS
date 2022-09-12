/*****************************************************************************
 * Copyright (c) 2008, 2014, 2017. 2019 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 448139
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 522564
 *  Ansgar Radermacher (CEA LIST) - bug 558645
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.preference.ProfilePreferenceConstants;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewerFilter;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.TreeObject;
import org.eclipse.papyrus.uml.profile.utils.Util;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.ChooseSetStereotypeDialog;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedStereotypePanel;
import org.eclipse.papyrus.uml.tools.commands.UnapplyStereotypeCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


/**
 * This composite is used to display applied stereotype in the model. It allows applying or desapply a stereotype
 */
public class AppliedStereotypeCompositeOnModel extends DecoratedTreeComposite implements ISelectionChangedListener {

	/**
	 * Gets the domain.
	 *
	 * @return the domain
	 */
	public TransactionalEditingDomain getEditingDomain(Element context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/** The panel that display applied stereotypes. */
	private AppliedStereotypePanel appliedStereotypePanel;

	/** The label. */
	protected CLabel label;

	/**
	 * This listener is used to refresh the Tree showing the applied stereotype and these properties values.
	 * It is easier to listen the stack than listen the edited property values recusrsively (a DataType owning a DataType owning another one, ...)
	 */
	private CommandStackListener commandStackListener;

	/**
	 * The default constructor.
	 *
	 * @param parent
	 *            the parent Composite for this panel
	 */
	public AppliedStereotypeCompositeOnModel(AppliedStereotypePanel parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);

		appliedStereotypePanel = parent;
	}

	/**
	 * create a composite applied stereotype on model.
	 *
	 * @param parent
	 *            the parent composite
	 */
	public AppliedStereotypeCompositeOnModel(Composite parent) {
		super(parent, SWT.NONE, "Applied stereotypes", true);
	}

	/**
	 * apply a stereotype on current selected element.
	 */
	protected void addAppliedStereotype() {

		// Open stereotype selection (may add or remove)
		ChooseSetStereotypeDialog dialog = new ChooseSetStereotypeDialog(this.getShell(), getElement());
		int result = dialog.open();

		if (result == Window.OK) {
			// Retrieve selected element
			Element element = getElement();

			// compare the 2 lists (present list and future list
			EList<Stereotype> oldStereotypeList = element.getAppliedStereotypes();
			ArrayList<Stereotype> newStereotypeList = dialog.getSelectedElements();

			// Keep newStereotype order (will be used at the end of the method)
			EList<Stereotype> newOrderList = new BasicEList<Stereotype>();
			newOrderList.addAll(newStereotypeList);

			// If the 2 lists differ, apply the new list of stereotypes
			if (!(newStereotypeList.equals(oldStereotypeList))) {

				// Parse old list :
				// if stereotype is in the new list : it is already applied
				// --> don't unapply it
				// --> remove it from new list
				Iterator<Stereotype> it = oldStereotypeList.iterator();
				while (it.hasNext()) {
					Stereotype currentStOld = it.next();
					if (newStereotypeList.contains(currentStOld)) {
						newStereotypeList.remove(currentStOld);
					} else {
						unapplyStereotype(element, currentStOld);
					}
				}

				// Already applied stereotype should have been removed
				// apply others
				Iterator<Stereotype> newApplyStereotypes = newStereotypeList.iterator();
				while (newApplyStereotypes.hasNext()) {
					Stereotype currentStereotype = newApplyStereotypes.next();
					applyStereotype(element, currentStereotype);
				}

				// Update Stereotype order
				// this.reorderStereotypeApplications(element, newOrderList);

				// checkSelection(null);
				selectionChanged(null);

				if (appliedStereotypePanel != null) {
					appliedStereotypePanel.refresh();
				}
			}
		}

	}

	/**
	 * Button action : open a selection dialog box that allow the user to choose stereotypes to apply (or unapply).
	 */
	@Override
	public void addButtonPressed() {
		addAppliedStereotype();
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);
		createStereotypesTree();

		removeButton.setToolTipText("Remove stereotype");
		addButton.setToolTipText("Apply stereotype");

		return this;
	}

	/**
	 * Creates the stereotypes tree.
	 *
	 * @return the tree of applied stereotypes and properties
	 */
	private void createStereotypesTree() {
		// Tree viewer shows applied stereotypes
		treeViewer.setContentProvider(new ProfileElementContentProvider());
		treeViewer.setLabelProvider(new ProfileElementLabelProvider());
		// 1. we need to replace the filter defined by default
		final List<ViewerFilter> filterToRemove = new ArrayList<>();
		for (ViewerFilter currentFilter : treeViewer.getFilters()) {
			if (currentFilter instanceof ProfileElementTreeViewerFilter) {
				filterToRemove.add(currentFilter);
			}
		}
		for (final ViewerFilter filter : filterToRemove) {
			treeViewer.removeFilter(filter);
		}
		// 2. we add your own filter extending the previous one
		treeViewer.addFilter(new ProfileElementTreeViewerFilterWithPreference());
		treeViewer.addSelectionChangedListener(this);
	}

	/**
	 * Button action : modify display order of stereotypes (selected elements are pushed down in the list).
	 */
	@Override
	public void downButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexLast = getTree().indexOf(items[items.length - 1]);
		if (indexLast + 1 >= getElement().getAppliedStereotypes().size()) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			TreeItem item = items[nbrOfSelection - 1 - i];
			if (item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject) item.getData();
				EList stereotypes = new BasicEList();
				stereotypes.addAll(element.getAppliedStereotypes());

				int index = stereotypes.indexOf(sTO.getStereotype());
				if ((index == -1) || (index >= stereotypes.size() - 1)) {
					// Not found of already on top...
					return;
				}

				stereotypes.move(index + 1, sTO.getStereotype());
				this.reorderStereotypeApplications(element, stereotypes);
			}
		}
	}

	/**
	 * Edits the item.
	 *
	 * @param item
	 *            the item
	 */
	@Override
	public void editItem(TreeItem item) {
		// do nothing
	}

	/**
	 * Gets the selected.
	 *
	 * @return Returns the selected element.
	 */
	public Element getSelected() {
		return appliedStereotypePanel.getSelected();
	}

	/**
	 * Gets the tree.
	 *
	 * @return the tree
	 */
	public Tree getTree() {
		return treeViewer.getTree();
	}

	/**
	 * Checks if is in stereotype display.
	 *
	 * @param st
	 *            the stereotype
	 *
	 * @return true, if checks if is in stereotype display
	 */
	protected Boolean isInStereotypeDisplay(Stereotype st) {
		return false;
	}

	/**
	 * Redraw the treeViewer while preserving selections and non-collapsed tree elements
	 * It is not sufficient to redraw only selected elements as an optimization, since
	 * derived stereotype attributes (that are not selected) might change in response to
	 * changing other attributes.
	 *
	 * @param propertyView
	 */
	public void refreshTreeViewer() {
		treeViewer.refresh();
	}

	/**
	 * Refresh the content of applied the applied stereotype tree.
	 */
	@Override
	public void refresh() {
		super.refresh();

		if (treeViewer.getTree() != null && !(treeViewer.getTree().isDisposed())) {
			if (element != null) {
				// Preserve selection
				final ISelection selection = treeViewer.getSelection();
				try {
					treeViewer.setInput(new StereotypedElementTreeObject(element));
				} finally {
					treeViewer.setSelection(selection);
				}
			} else {
				treeViewer.setInput(null);
			}
			StereotypedElementTreeObject rTO = (StereotypedElementTreeObject) treeViewer.getInput();
			if (rTO == null) {
				return;
			}

			boolean isEditable = isEditable();

			// If the property is Multivalued show Up - Down
			if ((rTO.getChildren() != null) && (rTO.getChildren().length > 1)) {
				upButton.setEnabled(isEditable);
				downButton.setEnabled(isEditable);
			} else {
				upButton.setEnabled(false);
				downButton.setEnabled(false);
			}

			if ((rTO.getChildren() != null) && (rTO.getChildren().length == 0)) {
				removeButton.setEnabled(false);
			} else {
				removeButton.setEnabled(isEditable);
			}
		}
	}

	/**
	 * Button action : unapply the stereotypes selected by the user in the stereotype tree.
	 */
	@Override
	public void removeButtonPressed() {
		unapplyStereotype();
	}

	/**
	 * Selection changed.
	 *
	 * @param event
	 *            the event
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		if (appliedStereotypePanel != null) {
			if (event == null) {
				appliedStereotypePanel.setSelectedProperty(null);
				return;
			}

			IStructuredSelection structSelection = (IStructuredSelection) event.getSelection();
			Object selection = structSelection.getFirstElement();
			if (selection instanceof AppliedStereotypePropertyTreeObject) {
				appliedStereotypePanel.setSelectedProperty((AppliedStereotypePropertyTreeObject) selection);
			} else {
				appliedStereotypePanel.setSelectedProperty(null);
			}

		}
	}

	/**
	 * Sets the input.
	 *
	 * @param element
	 *            the element
	 */
	public void setInput(StereotypedElementTreeObject element) {
		// Preserve selection
		final ISelection selection = treeViewer.getSelection();
		try {
			treeViewer.setInput(element);
		} finally {
			treeViewer.setSelection(selection);
		}
		if (Activator.getDefault().getPreferenceStore().getBoolean(ProfilePreferenceConstants.EXPAND_STEREOTYPES_TREE)) {
			treeViewer.expandAll();
		}
	}

	/**
	 * unapply stereotype on current selected element.
	 */
	protected void unapplyStereotype() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection == 0) {
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			TreeItem item = getTree().getSelection()[i];
			if (item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject) item.getData();
				unapplyStereotype(element, sTO.getStereotype());
				sTO.removeMe();
			}
		}
		if (appliedStereotypePanel != null) {
			appliedStereotypePanel.refresh();
		} else {
			refresh();
		}
	}

	/**
	 * Button action : modify display order of stereotypes (selected elements are pushed up in the list).
	 */
	@Override
	public void upButtonPressed() {
		int nbrOfSelection = getTree().getSelectionCount();
		if (nbrOfSelection < 1) {
			return;
		}

		TreeItem[] items = getTree().getSelection();
		int indexFirst = getTree().indexOf(items[0]);
		if (indexFirst == 0) {
			// do nothing
			return;
		}

		for (int i = 0; i < nbrOfSelection; i++) {
			TreeItem item = items[i];
			if (item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject) item.getData();
				EList stereotypes = new BasicEList();
				stereotypes.addAll(element.getAppliedStereotypes());

				int index = stereotypes.indexOf(sTO.getStereotype());
				if (index < 1) {
					return;
				}

				stereotypes.move(index - 1, sTO.getStereotype());
				this.reorderStereotypeApplications(element, stereotypes);
			}
		}
		if (appliedStereotypePanel != null) {
			appliedStereotypePanel.refresh();
		} else {
			refresh();
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.DecoratedTreeComposite#keepSelection(org.eclipse.jface.viewers.ISelection)
	 *
	 * @param pSelection
	 */
	@Override
	public void keepSelection(ISelection pSelection) {
		getDisplay().asyncExec(new SelectionKeeper(pSelection));
	}

	/**
	 * Apply stereotype.
	 *
	 * @param elt
	 *            the elt
	 * @param st
	 *            the st
	 */
	public void applyStereotype(final Element elt, final Stereotype st) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(elt);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							domain.getCommandStack().execute(getApplyStereotypeCommand(elt, st, domain));
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 * Unapply stereotype.
	 *
	 * @param elt
	 *            the uml element
	 * @param st
	 *            the stereotype to unapply
	 */
	protected void unapplyStereotype(final Element elt, final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		try {
			final TransactionalEditingDomain domain = getEditingDomain(elt);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							domain.getCommandStack().execute(getUnapplyStereotypeCommand(elt, st, domain));
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 * change the order of applied stereotype
	 *
	 * @param element
	 *            the UML element where stereotypes are applied
	 * @param stereotypes
	 *            the lis of applied stereotypes with the wanted order
	 */
	public void reorderStereotypeApplications(final Element element, final EList stereotypes) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(element);
			domain.runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							domain.getCommandStack().execute(new RecordingCommand(domain) {

								@Override
								protected void doExecute() {
									Util.reorderStereotypeApplications(element, stereotypes);
									refresh();
								}
							});
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 *
	 * @author gpascual
	 *
	 */
	private class SelectionKeeper implements Runnable {

		/** Selection to keep. */
		ISelection selection = null;

		/**
		 *
		 * Constructor.
		 *
		 */
		public SelectionKeeper(ISelection selection) {
			this.selection = selection;
		}

		public void run() {
			Object[] vSelectedElements = extractSelectedElements(selection);
			Object[] vCorrespondingElements = getCorrespondingElements(vSelectedElements);
			ISelection vSelection = new StructuredSelection(vCorrespondingElements);
			treeViewer.setSelection(vSelection);

		}





		private Object[] getCorrespondingElements(Object[] vSelectedElements) {
			StereotypedElementTreeObject vStereotypesTree = (StereotypedElementTreeObject) treeViewer.getInput();
			List<Object> vReturn = new ArrayList<Object>();
			for (Object vStereotype : vSelectedElements) {
				if (vStereotype instanceof AppliedStereotypeTreeObject) {
					AppliedStereotypeTreeObject vTreeObject = findAppliedStereotypeInTree(((AppliedStereotypeTreeObject) vStereotype).getStereotype(), vStereotypesTree);
					vReturn.add(vTreeObject);
				}
			}

			return vReturn.toArray();
		}

		private AppliedStereotypeTreeObject findAppliedStereotypeInTree(Stereotype stereotype, StereotypedElementTreeObject vStereotypesTree) {
			AppliedStereotypeTreeObject vAppliedStereotypeObject = null;

			for (TreeObject vChild : vStereotypesTree.getChildren()) {
				if (vChild instanceof AppliedStereotypeTreeObject) {
					if (stereotype.equals(((AppliedStereotypeTreeObject) vChild).getStereotype())) {
						vAppliedStereotypeObject = (AppliedStereotypeTreeObject) vChild;
					}
				}
			}

			return vAppliedStereotypeObject;

		}

		private Object[] extractSelectedElements(ISelection pSelection) {
			List<Object> vObjectsList = new ArrayList<Object>();
			if (pSelection instanceof IStructuredSelection) {
				vObjectsList.addAll(Arrays.asList(((IStructuredSelection) pSelection).toArray()));
			}
			return vObjectsList.toArray();
		}
	}

	/**
	 * Create command to execute during apply stereotype action.
	 *
	 * @param elt
	 *            Element where stereotype was applied
	 * @param st
	 *            Stereotype to apply on element
	 *
	 * @param domain
	 *            Transaction domain to execute command
	 * @return Command to execute to apply stereotype on element
	 */
	protected Command getApplyStereotypeCommand(final Element elt, final Stereotype st, final TransactionalEditingDomain domain) {
		return new RecordingCommand(domain) {

			/**
			 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
			 */
			@Override
			protected void doExecute() {
				elt.applyStereotype(st);
				refresh();
			}
		};
	}

	/**
	 * Create command execute during unapply stereotype action.
	 *
	 * @param elt
	 *            element where stereotype was unapplied
	 * @param st
	 *            Stereotype to unapply on element
	 * @param domain
	 *            Transaction domain to execute command
	 * @return Command to execute to unapply stereotype on element
	 */
	protected Command getUnapplyStereotypeCommand(final Element elt, final Stereotype st, final TransactionalEditingDomain domain) {
		return new UnapplyStereotypeCommand(elt, st, domain);
	}

	/**
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.DecoratedTreeComposite#setElement(org.eclipse.uml2.uml.Element)
	 *
	 * @param element
	 */
	@Override
	public void setElement(Element element) {
		// if the new element is null, we remove the command stack listener
		if (null == element && null != getElement()) {
			getEditingDomain(getElement()).getCommandStack().removeCommandStackListener(this.commandStackListener);
		}
		if (null != element && null == this.commandStackListener) {
			// if the command stack listener has not yet been created, we create it
			getEditingDomain(element).getCommandStack().addCommandStackListener(this.commandStackListener = new LocalCommandStackListener());
		}
		super.setElement(element);
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 *
	 */
	@Override
	public void dispose() {
		if (null != this.commandStackListener && null != getElement()) {
			getEditingDomain(getElement()).getCommandStack().removeCommandStackListener(this.commandStackListener);
			this.commandStackListener = null;
		}
		super.dispose();
	}

	/**
	 * CommandStackListener used to refresh the TreeView when a stereotype property changed
	 *
	 */
	private class LocalCommandStackListener implements CommandStackListener {

		/**
		 * @see org.eclipse.emf.common.command.CommandStackListener#commandStackChanged(java.util.EventObject)
		 *
		 * @param event
		 */
		@Override
		public void commandStackChanged(EventObject event) {
			Runnable runRefresh = new Runnable() {

				@Override
				public void run() {
					// isDiposed must be called by UI thread
					if (!treeViewer.getTree().isDisposed()) {
						final ISelection selection = treeViewer.getSelection();
						if (selection instanceof IStructuredSelection) {
							final Object first = ((IStructuredSelection) selection).getFirstElement();
							if (first instanceof AppliedStereotypePropertyTreeObject) {
								// we refresh the whole tree viewer and not only the leaf to be OK in case of derived properties
								refreshTreeViewer();
							}
						}
					}
				};
			};
			treeViewer.getControl().getDisplay().asyncExec(runRefresh);
		}
	}

}
