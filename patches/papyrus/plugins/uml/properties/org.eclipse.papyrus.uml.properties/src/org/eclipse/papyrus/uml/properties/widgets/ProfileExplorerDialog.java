/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A dialog to explore all available Profiles.
 * @since 3.0
 */
public class ProfileExplorerDialog extends StereotypeExplorerDialog {

	/**
	 * Constructor.
	 */
	public ProfileExplorerDialog(final Shell parentShell, final boolean allowMultiple, final String initialQualifyName) {
		super(parentShell, allowMultiple, initialQualifyName);
		setTitle(Messages.ProfileExplorerDialog_Title);
		setMessage(Messages.ProfileExplorerDialog_Message);
	}

	/**
	 * Constructor.
	 */
	public ProfileExplorerDialog(final Shell parentShell, final String initialValue) {
		this(parentShell, false, initialValue);
	}

	/**
	 * Constructor.
	 */
	public ProfileExplorerDialog(final Shell parentShell) {
		this(parentShell, false, "");//$NON-NLS-1$
	}

	/**
	 * All profile are visible.
	 * 
	 * @see org.eclipse.papyrus.uml.properties.widgets.StereotypeExplorerDialog#isVisible(java.lang.Object)
	 */
	@Override
	protected boolean isVisible(final Object element) {
		return true;
	}

	/**
	 * Don't visualize stereotype so return void list.
	 * 
	 * @see org.eclipse.papyrus.uml.properties.widgets.StereotypeExplorerDialog#getAllStereotypes(org.eclipse.uml2.uml.Profile)
	 */
	@Override
	protected List<Stereotype> getAllStereotypes(final Profile profile) {
		return new ArrayList<>();
	}

	/**
	 * Return the selected {@link Stereotype}.
	 * {@inheritDoc}
	 */
	@Override
	protected void computeResult() {
		Object selectedElements = getSelectedElements();
		if (selectedElements instanceof Profile | selectedElements instanceof IRegisteredProfile) {
			setResult(Arrays.asList(selectedElements));
		}
	}

	/**
	 * Refresh the Ok button according to the selection.
	 */
	protected void refreshOkButton() {
		Object selectedElements = getSelectedElements();
		if (selectedElements instanceof Profile | selectedElements instanceof IRegisteredProfile) {
			updateStatus(new Status(IStatus.OK, Activator.ID, ""));//$NON-NLS-1$
		} else {
			updateStatus(new Status(IStatus.ERROR, Activator.ID, ""));//$NON-NLS-1$
		}
	}

	/**
	 * Selected the initial value in treeViewer.
	 */
	protected void selectInitialValue() {
		// //Select initialValue Stereotype
		if (!initialValue.isEmpty()) {
			ITreeContentProvider contentProvider = (ITreeContentProvider) stereotypeTreeViewer.getContentProvider();
			Object[] roots = contentProvider.getElements(null);

			for (Object root : roots) {
				Object[] profiles = contentProvider.getChildren(root);
				for (Object profile : profiles) {
					stereotypeTreeViewer.setSelection(new StructuredSelection(profile), true);
					break;
				}
			}
		}
	}

}
