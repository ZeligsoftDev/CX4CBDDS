/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.profile.ui.dialogs.AlphabeticalViewerSorter;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ChooseSetAssistedDialog;
import org.eclipse.papyrus.uml.profile.ui.dialogs.IChooseDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.uml2.uml.Stereotype;



/**
 * Dialog that allows user to add/remove stereotypes to an element.
 *
 * @author Patrick Tessier, Remi Schnekenburger
 */
public class ChooseSetStereotypeDialog extends ChooseSetAssistedDialog implements IChooseDialog {

	/**
	 * LabelProvider for stereotype completion proposal provider with qualified names.
	 */
	final private StereotypeQualifiedLabelProvider qualifiedLabelProvider = new StereotypeQualifiedLabelProvider();

	/**
	 * Default Constructor.
	 *
	 * @param parentShell
	 *            the parent shell
	 * @param theElement
	 *            the UML element to be modified
	 */
	public ChooseSetStereotypeDialog(Shell parentShell, org.eclipse.uml2.uml.Element theElement) {
		super(parentShell,
				"Applicable Stereotypes: ",
				"Applied Stereotypes: ");
		labelProvider = new StereotypeLabelProvider();
		decoratedContentProposalProvider = new StereotypeContentProposalProvider();

		Iterator<Stereotype> stereotypes = theElement.getAppliedStereotypes().iterator();
		while (stereotypes.hasNext()) {
			selectedElementList.addElement(stereotypes.next());
		}

		stereotypes = theElement.getApplicableStereotypes().iterator();
		while (stereotypes.hasNext()) {
			Stereotype current = stereotypes.next();
			if (!selectedElementList.contains(current)) {
				possibleElementList.addElement(current);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * Creates the dialog area.
	 *
	 * @param parent
	 *            the parent
	 *
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control composite = super.createDialogArea(parent);

		// Add 2 columns to the table area
		// possibleElementsTable.setLinesVisible(true);
		possibleElementsTable.setHeaderVisible(true);

		// 1st column with image/checkboxes - NOTE: The SWT.CENTER has no effect!!
		TableColumn column = new TableColumn(possibleElementsTable, SWT.CENTER, 0);
		column.setText("Stereotype");
		column.setWidth(150);
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));
			}
		});

		// 2nd column with task Description
		column = new TableColumn(possibleElementsTable, SWT.LEFT, 1);
		column.setText("Information");
		column.setWidth(165);
		// Add listener to column so tasks are sorted by description when clicked
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(1));
			}
		});

		// set sorter to the possible element table viewer
		possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));

		return composite;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog#runAddElement(java.lang.String)
	 */
	/**
	 * Run add element.
	 *
	 * @param name
	 *            the name
	 */
	@Override
	protected void runAddElement(String name) {
		// find the stereotype in the list
		Stereotype stereotype = null;
		Iterator<Stereotype> it = possibleElementList.getElements().iterator();
		while (it.hasNext()) {
			Stereotype element = it.next();
			if (name.equalsIgnoreCase(UMLLabelInternationalization.getInstance().getKeyword(element)) || name.equalsIgnoreCase(element.getQualifiedName())) {
				stereotype = element;
			}
		}
		if (stereotype != null) {
			runActionAdd(stereotype);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog#isSelectableElement(java.lang.String)
	 */
	/**
	 * Checks if is selectable element.
	 *
	 * @param text
	 *            the text
	 *
	 * @return true, if is selectable element
	 */
	@Override
	protected boolean isSelectableElement(String text) {
		// iterate through all possibilities and return true if text corresponds
		Iterator<Stereotype> it = possibleElementList.getElements().iterator();
		while (it.hasNext()) {
			Stereotype element = it.next();
			if (text.equalsIgnoreCase(UMLLabelInternationalization.getInstance().getKeyword(element)) || text.equalsIgnoreCase(element.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Content Proposal provider for stereotypes dialog. Propose the simple
	 * name of the stereotype and its qualified name.
	 *
	 * @author Remi Schnekenburger
	 */
	public class StereotypeContentProposalProvider extends DecoratedContentProposalProvider {

		/*
		 * (non-Javadoc)
		 *
		 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog.DecoratedContentProposalProvider#getProposals(java.lang.String, int)
		 */
		/**
		 * Gets the proposals.
		 *
		 * @param contents
		 *            the contents
		 * @param position
		 *            the position
		 *
		 * @return the proposals
		 */
		@Override
		public DecoratedContentProposal[] getProposals(String contents, int position) {
			ArrayList<DecoratedContentProposal> proposals = new ArrayList<DecoratedContentProposal>();

			if (possibleElementList != null) {
				Iterator it = possibleElementList.getElements().iterator();
				while (it.hasNext()) {
					final Stereotype stereotype = (Stereotype) it.next();
					final String simpleName = UMLLabelInternationalization.getInstance().getKeyword(stereotype);
					final String qualifiedName = stereotype.getQualifiedName();

					if (position < simpleName.length() && contents.substring(0, position).equalsIgnoreCase(simpleName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(stereotype, labelProvider));
					}

					if (position < qualifiedName.length() && contents.substring(0, position).equalsIgnoreCase(qualifiedName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(stereotype, qualifiedLabelProvider));
					}
				}
			}

			Collections.sort(proposals);
			return proposals.toArray(new DecoratedContentProposal[proposals.size()]);
		}
	}
}
