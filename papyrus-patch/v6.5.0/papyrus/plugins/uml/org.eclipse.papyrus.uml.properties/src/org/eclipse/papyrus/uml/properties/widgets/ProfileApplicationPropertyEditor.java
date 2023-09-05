/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 399859
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * A Property editor for Profile Application
 *
 * @author Camille Letavernier
 *
 */
public class ProfileApplicationPropertyEditor extends AbstractPropertyEditor {

	private ProfileApplicationEditor editor;

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 * @param style
	 */
	public ProfileApplicationPropertyEditor(Composite parent, int style) {
		editor = createProfileApplicationEditor(parent, style);
		super.setEditor(editor);
	}

	protected ProfileApplicationEditor createProfileApplicationEditor(Composite parent, int style) {
		return new ProfileApplicationEditor(parent, style);
	}

	@Override
	public void doBinding() {

		Object firstSelection = input.getSelection().getFirstElement();
		Element umlElement = UMLUtil.resolveUMLElement(firstSelection);
		if (umlElement == null || !(umlElement instanceof Package)) {
			Activator.log.warn("This editor can only be used with UML Packages"); //$NON-NLS-1$
			return;
		}

		editor.setLabelProvider(input.getLabelProvider(propertyPath));
		editor.setPackage((Package) umlElement);

		if (getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener) getInputObservableList());
		}

		super.doBinding();
	}
}
