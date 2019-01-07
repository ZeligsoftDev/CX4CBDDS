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
package com.zeligsoft.cx.ui.dialogs;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.elementselection.AbstractElementSelectionInput;
import org.eclipse.gmf.runtime.common.ui.services.elementselection.ElementSelectionComposite;
import org.eclipse.gmf.runtime.common.ui.services.elementselection.ElementSelectionScope;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Element selection dialog which initiate the search dialog. Elements are
 * filtered by the element selection filter.
 * 
 * @author ysroh
 * 
 */
public class ElementSelectionDialog
		extends TrayDialog {

	private ElementSelectionComposite selectionComposite = null;

	private EObject selectedElement;

	private IFilter filter;

	private IAdaptable context;

	/**
	 * Constructor
	 * 
	 * @param shell
	 */
	public ElementSelectionDialog(Shell shell, IFilter filter,
			IAdaptable context) {
		super(shell);
		this.filter = filter;
		this.context = context;
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(Messages.ElementSelectionDialog_DialogTitle);
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group group = new Group(composite, SWT.NULL);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setText(Messages.ElementSelectionDialog_SearchLabel);

		AbstractElementSelectionInput input = new AbstractElementSelectionInput(
			filter, context, ElementSelectionScope.VISIBLE, ""); //$NON-NLS-1$

		selectionComposite = new ElementSelectionComposite(
			Messages.ElementSelectionDialog_SearchHelpLabel, input) {

			@SuppressWarnings("rawtypes")
			@Override
			protected boolean isValidSelection(List currentSelectedElements) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected void handleSelection(boolean isValid) {
				List<Object> list = getSelectedElements();
				if (list.isEmpty()) {
					return;
				}
				Object o = list.get(0);
				if (o instanceof EObject) {
					selectedElement = (EObject) o;
				}
				getButton(IDialogConstants.OK_ID).setEnabled(true);
			}

		};

		Composite result = selectionComposite.createComposite(group);

		Control children[] = result.getChildren();
		boolean textFound = false;
		for (int i = 0; i < children.length; i++) {
			if (children[i] instanceof Text && !textFound) {
				// Set initial search text to *
				((Text) children[i]).setText("*"); //$NON-NLS-1$
				textFound = true;
			}else if (children[i] instanceof Table) {
				((Table) children[i]).addMouseListener(new MouseListener() {

					@Override
					public void mouseDoubleClick(MouseEvent e) {
						close();

					}

					@Override
					public void mouseDown(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseUp(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});
				break;

			}
		}

		createButtonArea(composite);

		return composite;
	}

	/**
	 * Creates button area
	 * 
	 * @param composite
	 */
	private void createButtonArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));

		Control helpControl = createHelpControl(composite);
		helpControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));
		createButtonsForButtonBar(composite);

		GridData buttonData = (GridData) getButton(IDialogConstants.OK_ID)
			.getLayoutData();
		buttonData.widthHint = 70;
		buttonData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		getButton(IDialogConstants.CANCEL_ID).setLayoutData(buttonData);
	}

	@Override
	protected void okPressed() {

		close();
	}

	/**
	 * Set ElementSelectionComposite
	 * 
	 * @param composite
	 */
	public void setElementSelectionComposite(ElementSelectionComposite composite) {
		selectionComposite = composite;
	}

	/**
	 * Queries the selected element
	 * 
	 * @return
	 */
	public EObject getSelectedObject() {
		return selectedElement;
	}
}
