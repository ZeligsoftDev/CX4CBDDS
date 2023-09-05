/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueEditor;
import org.eclipse.papyrus.uml.properties.creation.ExpressionLanguageFactory;
import org.eclipse.swt.widgets.Composite;

/**
 * A widget for editing UML Expressions.
 * UML Expressions maintain two lists ; one for the languages, and another one
 * for the expression bodies. These lists should be coherent. This widget
 * ensures that operations on the language list will not break the coherence
 * with the bodies list. For example, when a language is deleted, the
 * associated body is deleted as well.
 *
 * @author Camille Letavernier
 */
public class ExpressionLanguageEditor extends MultipleValueEditor<LanguageSelector> {

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which this editor is created
	 * @param style
	 *            The style for this editor's list
	 */
	public ExpressionLanguageEditor(Composite parent, int style) {
		super(parent, style, new LanguageSelector(), true, true, null);
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		tree.setEnabled(true); // The list is always enabled, to keep the selection-change event
	}

	@Override
	public void setModelObservable(IObservableList modelProperty) {
		super.setModelObservable(modelProperty);
		setFactory(new ExpressionLanguageFactory(modelProperty));
	}
}
