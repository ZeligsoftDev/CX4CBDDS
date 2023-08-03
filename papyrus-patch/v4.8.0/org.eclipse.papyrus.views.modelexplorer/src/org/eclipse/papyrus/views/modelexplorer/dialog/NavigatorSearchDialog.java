/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which accompanies this distribution, and is
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Francisco Javier Cano Muñoz (Prodevelop) - initial api contribution
 * 	Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Improve the searchText widget
 *
 *
 ******************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.dialog;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.views.modelexplorer.LinkNode;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A dialog that allows searching elements in the Model navigator by name.
 *
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Munoz</a>
 *
 * @author cedric dumoulin
 */
// @Unused
// The QuickSearch feature is disabled since the new Search feature is available (0.10)
public class NavigatorSearchDialog extends TrayDialog {

	private ITreeContentProvider contentProvider = null;

	private ILabelProvider labelProvider = null;

	private Object root = null;

	private ISelectionProvider viewer = null;

	private List<Object> matchedObjects = Collections.emptyList();

	protected int currentIndex = 0;

	private Label matchesLabel;

	private StringEditor searchText;

	private Button backButton;

	private Button nextButton;

	private Button caseButton;

	/**
	 *
	 * Constructor.
	 *
	 * @param shell
	 * @param modelNavigator
	 * @deprecated Use {@link #NavigatorSearchDialog(Shell, TreeViewer)}
	 */
	@Deprecated
	public NavigatorSearchDialog(Shell shell, CommonNavigator modelNavigator) {
		super(shell);
		IContentProvider cprovider = modelNavigator.getCommonViewer().getContentProvider();
		if (cprovider instanceof ITreeContentProvider) {
			contentProvider = (ITreeContentProvider) cprovider;
		}
		root = modelNavigator.getCommonViewer().getInput();
		viewer = modelNavigator.getCommonViewer();
		labelProvider = (ILabelProvider) modelNavigator.getCommonViewer().getLabelProvider();

	}

	/**
	 * Constructor.
	 *
	 * @param shell
	 *            Shell used to show this Dialog
	 * @param viewer
	 * @param contentProvider
	 * @param labelProvider
	 * @param root
	 */
	public NavigatorSearchDialog(Shell shell, TreeViewer viewer) {
		super(shell);
		this.viewer = viewer;
		try {
			this.labelProvider = (ILabelProvider) viewer.getLabelProvider();
			this.contentProvider = (ITreeContentProvider) viewer.getContentProvider();
		} catch (ClassCastException e) {
			// Content or label provider are not of appropriate type.
			// let them null
		}
		this.root = viewer.getInput();
	}


	/**
	 * Constructor.
	 *
	 * @param shell
	 *            Shell used to show this Dialog
	 * @param viewer
	 * @param contentProvider
	 * @param labelProvider
	 * @param root
	 */
	public NavigatorSearchDialog(Shell shell, Viewer viewer, ITreeContentProvider contentProvider, ILabelProvider labelProvider, Object root) {
		super(shell);
		this.viewer = viewer;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		this.root = root;
	}

	/**
	 * Sets a new selection for the associated {@link ISelectionProvider} and optionally makes it visible.
	 * <p>
	 * Subclasses must implement this method.
	 * </p>
	 *
	 * @param selection
	 *            the new selection
	 * @param reveal
	 *            <code>true</code> if the selection is to be made
	 *            visible, and <code>false</code> otherwise
	 */
	private void fireSetSelection(ISelection selection, boolean reveal) {
		// Note : if we want to force reveal, it is possible to check if
		// selectionProvider instanceof Viewer, and then call selectionProvider.setSelection(selection, true).
		// By default a TreeViewer reveal the selection.
		if (viewer instanceof CommonViewer) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structured = (IStructuredSelection) selection;
				ModelExplorerView.reveal(Iterables.transform(Lists.newArrayList(structured.iterator()), new Function<Object, EObject>() {

					public EObject apply(Object arg0) {
						return EMFHelper.getEObject(arg0);
					}
				}), (CommonViewer) viewer);
			}
		} else if (viewer instanceof Viewer) {
			Viewer view = (Viewer) viewer;
			view.setSelection(selection, true);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite background = new Composite(parent, SWT.None);
		GridData bgData = new GridData(GridData.FILL_BOTH);
		bgData.minimumWidth = 300;
		background.setLayoutData(bgData);
		GridLayout bgLayout = new GridLayout();
		bgLayout.numColumns = 2;
		background.setLayout(bgLayout);

		createSearchTextComposite(background);

		getShell().setText("Search");
		return background;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

		backButton = createButton(parent, IDialogConstants.BACK_ID, IDialogConstants.BACK_LABEL, false);
		nextButton = createButton(parent, IDialogConstants.NEXT_ID, IDialogConstants.NEXT_LABEL, false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);

		backButton.setEnabled(false);
		nextButton.setEnabled(false);

		nextButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				if (currentIndex >= matchedObjects.size() - 1) {
					currentIndex = 0;
				} else {
					currentIndex++;
				}
				fireSetSelection(new StructuredSelection(matchedObjects.get(currentIndex)), true);
			}

		});

		backButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				if (currentIndex <= 0) {
					currentIndex = matchedObjects.size() - 1;
				} else {
					currentIndex--;
				}
				fireSetSelection(new StructuredSelection(matchedObjects.get(currentIndex)), true);
			}

		});
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void createSearchTextComposite(Composite background) {
		Label searchLabel = new Label(background, SWT.None);
		searchLabel.setText("Search:");
		searchLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		searchText = new StringEditor(background, SWT.SEARCH);
		searchText.setFocus();
		searchText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		searchText.addCommitListener(getCommitListener());
		searchText.setValidateOnDelay(true);

		caseButton = new Button(background, SWT.CHECK);
		caseButton.setText("Case sensitive?");
		GridData caseButtonData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		caseButtonData.horizontalSpan = 2;
		caseButton.setSelection(false);
		caseButton.setLayoutData(caseButtonData);
		caseButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateMatches();
			}

		});

		Label resultsLabel = new Label(background, SWT.None);
		resultsLabel.setText("Results:");
		resultsLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		matchesLabel = new Label(background, SWT.None);
		matchesLabel.setText("No matchings.");
		matchesLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL));

	}

	protected void clearMatches() {
		matchedObjects = Collections.emptyList();
		currentIndex = 0;
		backButton.setEnabled(false);
		nextButton.setEnabled(false);
		matchesLabel.setText("");
	}

	private void updateMatches() {
		if (contentProvider == null && labelProvider == null) {
			return;
		}

		String pattern = (String) searchText.getValue();
		if (pattern.length() == 0) {
			clearMatches();
			return;
		}

		if (!caseButton.getSelection()) {
			pattern = pattern.toUpperCase();
		}

		launchSearch(pattern, contentProvider.getElements(root));

		// Update matches label
		matchesLabel.setText(matchedObjects.size() + " matches found");

		// Select first match and update buttons
		if (!matchedObjects.isEmpty()) {
			fireSetSelection(new StructuredSelection(matchedObjects.get(0)), true);
			nextButton.setEnabled(true);
			backButton.setEnabled(true);
		} else {
			nextButton.setEnabled(false);
			backButton.setEnabled(false);
		}

	}

	protected void launchSearch(final String pattern, final Object[] root) {
		final boolean caseSensitive = caseButton.getSelection();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(null);
		try {
			dialog.run(true, true, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					matchedObjects = searchPattern(pattern, caseSensitive, Arrays.asList(root), monitor);
					currentIndex = 0;
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private List<Object> searchPattern(String pattern, boolean caseSensitive, List<Object> objects, IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			return Collections.emptyList();
		}

		List<Object> matches = new ArrayList<Object>();

		List<Object> children = new ArrayList<Object>();
		String objectLabel;

		for (Object o : objects) {
			// Search matches in this level
			if (!(o instanceof Diagram)) {
				objectLabel = caseSensitive ? labelProvider.getText(o) : labelProvider.getText(o).toUpperCase();

				if (objectLabel.contains(pattern)) {
					matches.add(o);
				}
				EObject parentEObj = getAdapter(o, EObject.class);

				for (int i = 0; i < contentProvider.getChildren(o).length; i++) {
					Object child = contentProvider.getChildren(o)[i];
					// If child can be adapted into a LinkNode, find its referenced EObjects
					if (getAdapter(child, LinkNode.class) != null) {
						for (Object referencedObject : contentProvider.getChildren(child)) {
							EObject referencedEObject = EMFHelper.getEObject(referencedObject);
							if (referencedEObject != null && (parentEObj == null || parentEObj.equals(referencedEObject.eContainer()))) {
								children.add(referencedObject);
							}
						}
					}
					// If it is an EObject, add it to the list
					else {
						EObject eObject = EMFHelper.getEObject(child);
						if (eObject != null && eObject.eContainer() != null && (parentEObj == null || eObject.eContainer().equals(parentEObj))) {
							children.add(child);
						}
					}
				}
			}
		}
		if (!children.isEmpty()) {
			matches.addAll(searchPattern(pattern, caseSensitive, children, monitor));
		}

		return matches;
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Object object, Class<? extends T> toAdapt) {
		T result = null;
		if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			result = adaptable.getAdapter(toAdapt);
		}
		if (result == null) {
			result = Platform.getAdapterManager().getAdapter(object, toAdapt);
		}
		return result;
	}

	protected ICommitListener getCommitListener() {
		return new ICommitListener() {

			private String lastValue = "";

			public void commit(AbstractEditor editor) {
				String newValue = (String) searchText.getValue();
				if (!lastValue.equals(newValue)) {
					lastValue = newValue;
					updateMatches();
				}
			}
		};
	}

}
