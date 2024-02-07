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

import java.util.LinkedList;

import org.eclipse.papyrus.infra.properties.ui.widgets.layout.GridData;
import org.eclipse.papyrus.infra.properties.ui.widgets.layout.PropertiesLayout;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.selectors.StringSelector;
import org.eclipse.papyrus.uml.properties.expression.ExpressionList.Expression;
import org.eclipse.papyrus.uml.properties.preferences.LanguageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

/**
 * An IElementSelector for UML Expressions' languages.
 * This selectors allows the user to select a language from a list of
 * registered languages, or to type directly the name of a language
 * (Which may have been registered or not).
 *
 * @author Camille Letavernier
 */
public class LanguageSelector extends StringSelector {

	private Text text;

	private List list;

	/**
	 * Returns a single-element array containing the current text
	 *
	 * {@link IElementSelector#getSelectedElements()}
	 */
	@Override
	public Object[] getSelectedElements() {
		java.util.List<String> languageNames = new LinkedList<String>();

		if (text.getText() != null && !text.getText().trim().equals("")) { //$NON-NLS-1$
			languageNames.add(text.getText());
		} else {
			String[] selection = list.getSelection();
			if (selection.length > 0) {
				for (String languageName : selection) {
					languageNames.add(languageName);
				}
			}
			list.setSelection(-1);
		}

		java.util.List<Expression> result = new LinkedList<Expression>();

		for (String languageName : languageNames) {
			Expression expression = new Expression();
			expression.setLanguage(languageName);
			result.add(expression);
		}

		text.setText(""); //$NON-NLS-1$
		return result.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new PropertiesLayout());

		text = new Text(container, SWT.NONE | SWT.BORDER);
		list = new List(container, SWT.MULTI | SWT.BORDER);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		for (String language : LanguageRegistry.instance.getLanguages()) {
			list.add(language);
		}

		list.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				// Nothing
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				if (!elementSelectionListeners.isEmpty()) {
					Object[] value = getSelectedElements();
					for (IElementSelectionListener listener : elementSelectionListeners) {
						listener.addElements(value);
					}
				}
			}

		});
	}

	/**
	 * Returns all the known languages
	 *
	 * @see org.eclipse.papyrus.infra.widgets.editors.IElementSelector#getAllElements()
	 */
	@Override
	public Object[] getAllElements() {
		java.util.List<Expression> result = new LinkedList<Expression>();
		for (String language : list.getItems()) {
			Expression expression = new Expression();
			expression.setLanguage(language);
			result.add(expression);
		}

		list.setSelection(-1);

		return result.toArray();
	}
}
