/*****************************************************************************
 * Copyright (c) 2008, 2021 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus (CEA) - bugs 323802, 448139
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 522564
 *  Ansgar Radermacher (CEA LIST) - bug 558645
 *  Christian W. Damus - bug 571629
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.gmf.command.ICommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.preference.ProfilePreferenceConstants;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementContentProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewerFilter;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.AppliedStereotypeTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.profile.tree.objects.TreeObject;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.ChooseSetStereotypeDialog;
import org.eclipse.papyrus.uml.properties.profile.ui.panels.AppliedStereotypePanel;
import org.eclipse.papyrus.uml.tools.commands.ReorderStereotypeApplicationsCommand;
import org.eclipse.papyrus.uml.types.core.requests.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.types.core.requests.UnapplyStereotypeRequest;
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
	 * An adapter that detects changes to the stereotype applications, triggering refresh.
	 */
	private final Adapter stereotypeApplicationAdapter = new StereotypeApplicationAdapter();

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
			@SuppressWarnings("unchecked")
			List<Stereotype> newStereotypeList = dialog.getSelectedElements();

			// If the 2 lists differ, apply the new list of stereotypes
			if (!(newStereotypeList.equals(oldStereotypeList))) {
				try {
					final TransactionalEditingDomain domain = getEditingDomain(element);
					domain.runExclusive(() -> {
						CompoundCommand command = new CompoundCommand();

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
								command.append(getUnapplyStereotypeCommand(element, currentStOld, domain));
							}
						}

						// Already applied stereotype should have been removed
						// apply others
						Iterator<Stereotype> newApplyStereotypes = newStereotypeList.iterator();
						while (newApplyStereotypes.hasNext()) {
							Stereotype currentStereotype = newApplyStereotypes.next();
							command.append(getApplyStereotypeCommand(element, currentStereotype, domain));
						}

						if (command.canExecute()) {
							// checkSelection(null);
							selectionChanged(null);
							Display.getCurrent().asyncExec(() -> domain.getCommandStack().execute(command));
						} else {
							command.dispose();
						}
					});

				} catch (Exception e) {
					Activator.log.error(e);
				}

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

	@Override
	protected boolean canMoveDown() {
		// We can only reorder stereotype applications if they are all in the same resource
		boolean result = super.canMoveDown() && stereotypeApplicationsCollocated();

		if (result) {

			// Order of selection is unspecified. So compute the reverse since
			// we have to sort, anyways
			TreeItem[] selection = getSortedSelection(true);
			int indexOfLastSelected = getTree().indexOf(selection[0]);

			// Cannot move down if the last selected stereotype is the last in the tree
			result = indexOfLastSelected < (getTree().getItemCount() - 1);
		}

		return result;
	}

	/**
	 * Query whether all stereotype applications are in the same resource.
	 *
	 * @return whether all stereotype applications are in the same resource
	 */
	protected final boolean stereotypeApplicationsCollocated() {
		return element != null && element.getStereotypeApplications().stream()
				.map(EObject::eResource)
				.distinct()
				.count() == 1;
	}

	/**
	 * Button action : modify display order of stereotypes (selected elements are pushed down in the list).
	 */
	@Override
	public void downButtonPressed() {
		if (!canMoveDown()) {
			return;
		}

		EList<Stereotype> stereotypes = new BasicEList.FastCompare<>(element.getAppliedStereotypes());

		for (TreeItem item : getSortedSelection(true)) {
			if (item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject) item.getData();

				int index = stereotypes.indexOf(sTO.getStereotype());
				if ((index == -1) || (index >= stereotypes.size() - 1)) {
					// Not found or already on bottom...
					return;
				}

				stereotypes.move(index + 1, sTO.getStereotype());
			}
		}

		this.reorderStereotypeApplications(element, stereotypes);
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
				removeButton.setEnabled(isEditable && canRemove());
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
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		updateEnablement();

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

		final TransactionalEditingDomain domain = getEditingDomain(element);
		try {
			domain.runExclusive(() -> {
				CompoundCommand command = new CompoundCommand();
				List<AppliedStereotypeTreeObject> stosToRemove = new ArrayList<>(nbrOfSelection);
				for (int i = 0; i < nbrOfSelection; i++) {
					TreeItem item = getTree().getSelection()[i];
					if (item.getData() instanceof AppliedStereotypeTreeObject) {
						AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject) item.getData();
						stosToRemove.add(sTO);
						command.append(getUnapplyStereotypeCommand(element, sTO.getStereotype(), domain));
					}
				}

				if (command.canExecute()) {
					stosToRemove.forEach(AppliedStereotypeTreeObject::removeMe);
					Display.getCurrent().asyncExec(() -> domain.getCommandStack().execute(command.unwrap()));
				} else {
					command.dispose();
				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}

		if (appliedStereotypePanel != null) {
			appliedStereotypePanel.refresh();
		}
	}

	@Override
	protected boolean canRemove() {
		return canUnapplyStereotype();
	}

	protected boolean canUnapplyStereotype() {
		boolean result = false;

		TreeItem[] selection = getTree().getSelection();
		if (selection.length > 0) {
			// Assume unapplicable until we determine otherwise
			result = true;

			for (int i = 0; result && i < selection.length; i++) {
				TreeItem next = selection[i];
				if (next.getData() instanceof AppliedStereotypeTreeObject) {
					AppliedStereotypeTreeObject s = (AppliedStereotypeTreeObject) next.getData();
					result = canUnapplyStereotype(element, s.getStereotype());
				}
			}
		}

		return result;
	}

	@Override
	protected boolean canMoveUp() {
		// We can only reorder stereotype applications if they are all in the same resource
		boolean result = super.canMoveUp() && stereotypeApplicationsCollocated();

		if (result) {
			TreeItem[] selection = getSortedSelection(false);

			// Cannot move up if the first selected stereotype is the first in the list
			result = getTree().indexOf(selection[0]) > 0;
		}

		return result;
	}

	/**
	 * As the order of tree items reported in the selection is unspecified by API contract,
	 * we need to sort the selection in order to properly process moves up/down.
	 *
	 * @param reversed
	 *            whether to reverse the sort (e.g., for move down)
	 * @return the sorted selection
	 */
	protected TreeItem[] getSortedSelection(boolean reversed) {
		// Order of selection is unspecified
		TreeItem[] result = getTree().getSelection();

		if (result.length > 1) {
			Comparator<TreeItem> order = Comparator.comparing(getTree()::indexOf);
			if (reversed) {
				order = order.reversed();
			}
			Arrays.sort(result, order);
		}

		return result;
	}

	/**
	 * Button action : modify display order of stereotypes (selected elements are pushed up in the list).
	 */
	@Override
	public void upButtonPressed() {
		if (!canMoveUp()) {
			return;
		}

		EList<Stereotype> stereotypes = new BasicEList.FastCompare<>(element.getAppliedStereotypes());
		for (TreeItem item : getSortedSelection(false)) {
			if (item.getData() instanceof AppliedStereotypeTreeObject) {
				AppliedStereotypeTreeObject sTO = (AppliedStereotypeTreeObject) item.getData();

				int index = stereotypes.indexOf(sTO.getStereotype());
				if (index < 1) {
					return;
				}

				stereotypes.move(index - 1, sTO.getStereotype());
			}
		}

		this.reorderStereotypeApplications(element, stereotypes);

		if (appliedStereotypePanel != null) {
			appliedStereotypePanel.refresh();
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
	 *
	 * @deprecated Since version 4.1 of the bundle as this does not support multiple selection.
	 *             Use the {@link #getApplyStereotypeCommand(Element, Stereotype, TransactionalEditingDomain)} API, instead
	 * @see <a href="https://eclip.se/573167">bug 573167</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "4.1", forRemoval = true)
	public void applyStereotype(final Element elt, final Stereotype st) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(elt);
			domain.runExclusive(new Runnable() {

				@Override
				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						@Override
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
	 *
	 * @deprecated Since version 4.1 of the bundle as this does not support multiple selection.
	 *             Use the {@link #getUnapplyStereotypeCommand(Element, Stereotype, TransactionalEditingDomain)} API, instead
	 * @see <a href="https://eclip.se/573167">bug 573167</a> to follow removal of this API in a future release
	 */
	@Deprecated(since = "4.1", forRemoval = true)
	protected void unapplyStereotype(final Element elt, final Stereotype st) {
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		try {
			final TransactionalEditingDomain domain = getEditingDomain(elt);
			domain.runExclusive(new Runnable() {

				@Override
				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						@Override
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

	protected boolean canUnapplyStereotype(final Element element, final Stereotype stereotype) {
		boolean result = false;

		try {
			// Cannot unapplied a stereotype that isn't applied, no matter what
			// the edit helpers may say
			if (element.isStereotypeApplied(stereotype)) {
				final TransactionalEditingDomain domain = getEditingDomain(element);
				Command unapply = getUnapplyStereotypeCommand(element, stereotype, domain);
				result = unapply != null && unapply.canExecute();
			}
		} catch (Exception e) {
			Activator.log.error("Failed to determine whether stereotype can be unapplied.", e); //$NON-NLS-1$
		}

		return result;
	}

	/**
	 * change the order of applied stereotype
	 *
	 * @param element
	 *            the UML element where stereotypes are applied
	 * @param stereotypes
	 *            the lis of applied stereotypes with the wanted order
	 */
	public void reorderStereotypeApplications(final Element element, final EList<Stereotype> stereotypes) {
		try {
			final TransactionalEditingDomain domain = getEditingDomain(element);
			domain.runExclusive(new Runnable() {

				@Override
				public void run() {
					Command command = new ReorderStereotypeApplicationsCommand(element, stereotypes);

					Display.getCurrent().asyncExec(new Runnable() {

						@Override
						public void run() {
							domain.getCommandStack().execute(command);
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

		@Override
		public void run() {
			Object[] vSelectedElements = extractSelectedElements(selection);
			Object[] vCorrespondingElements = getCorrespondingElements(vSelectedElements);
			ISelection vSelection = new StructuredSelection(vCorrespondingElements);
			treeViewer.setSelection(vSelection);

		}





		private Object[] getCorrespondingElements(Object[] vSelectedElements) {
			StereotypedElementTreeObject vStereotypesTree = (StereotypedElementTreeObject) treeViewer.getInput();
			List<Object> vReturn = new ArrayList<>();
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
			List<Object> vObjectsList = new ArrayList<>();
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
		Command result = UnexecutableCommand.INSTANCE;

		IElementEditService edit = ElementEditServiceUtils.getCommandProvider(elt);
		if (edit != null) {
			ApplyStereotypeRequest request = new ApplyStereotypeRequest(elt, st, domain);
			ICommand editCommand = edit.getEditCommand(request);
			if (editCommand != null && editCommand.canExecute()) {
				result = ICommandWrapper.wrap(editCommand, Command.class);
			}
		}

		return result;
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
		Command result = UnexecutableCommand.INSTANCE;

		IElementEditService edit = ElementEditServiceUtils.getCommandProvider(elt);
		if (edit != null) {
			UnapplyStereotypeRequest request = new UnapplyStereotypeRequest(elt, st, domain);
			ICommand editCommand = edit.getEditCommand(request);
			if (editCommand != null && editCommand.canExecute()) {
				result = ICommandWrapper.wrap(editCommand, Command.class);
			}
		}

		return result;
	}

	/**
	 * @see org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel.DecoratedTreeComposite#setElement(org.eclipse.uml2.uml.Element)
	 *
	 * @param element
	 */
	@Override
	public void setElement(Element element) {
		Element oldElement = getElement();

		// if the new element is null, we remove the command stack listener
		if (null == element && null != oldElement) {
			getEditingDomain(oldElement).getCommandStack().removeCommandStackListener(this.commandStackListener);
		}
		if (null != element && null == this.commandStackListener) {
			// if the command stack listener has not yet been created, we create it
			getEditingDomain(element).getCommandStack().addCommandStackListener(this.commandStackListener = new LocalCommandStackListener());
		}

		if (oldElement != null) {
			oldElement.eAdapters().remove(stereotypeApplicationAdapter);
		}
		if (element != null) {
			element.eAdapters().add(stereotypeApplicationAdapter);
		}

		super.setElement(element);
	}

	@Override
	public void dispose() {
		Element oldElement = getElement();

		if (null != this.commandStackListener && null != oldElement) {
			getEditingDomain(getElement()).getCommandStack().removeCommandStackListener(this.commandStackListener);
			this.commandStackListener = null;
		}
		if (oldElement != null) {
			oldElement.eAdapters().remove(stereotypeApplicationAdapter);
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

	private class StereotypeApplicationAdapter extends AdapterImpl {
		private final Set<Notifier> additionalTargets = new HashSet<>();

		@Override
		public void setTarget(Notifier newTarget) {
			if (newTarget instanceof Element) {
				super.setTarget(newTarget);
				scope((Element) newTarget).forEach(this::addAdapter);
			}
		}

		private void addAdapter(Notifier target) {
			if (target.eAdapters().add(this)) {
				additionalTargets.add(target);
			}
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			if (oldTarget instanceof Element) {
				scope((Element) oldTarget).forEach(this::removeAdapter);
				super.unsetTarget(oldTarget);
			}
		}

		private void removeAdapter(Notifier target) {
			if (target.eAdapters().remove(this)) {
				additionalTargets.remove(target);
			}
		}

		private Stream<Resource> scope(Element element) {
			return Stream.concat(Stream.of(element.eResource()),
					element.getStereotypeApplications().stream().map(EObject::eResource))
					.filter(Objects::nonNull).distinct();
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (!msg.isTouch() && msg.getFeatureID(Resource.class) == Resource.RESOURCE__CONTENTS && additionalTargets.contains(msg.getNotifier())) {
				asyncRefresh();
			}
		}

	}

}
