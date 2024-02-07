/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.expression;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.AbstractObservable;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.papyrus.infra.tools.util.StringHelper;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;

/**
 * An IObservableList for handling Expressions
 *
 * An Expression has a Language and a Body
 *
 * The UML low-level implementation maintains two lists of Strings (One for the
 * languages, and another one for the bodies), which should be synchronized
 * (1-1 mapping, with a few specific cases when the mapping is not strict)
 *
 * This class simplifies this mapping by maintaining a single list of
 * Expressions, each of which containing a Body and a Language.
 *
 * @author Camille Letavernier
 */
public class ExpressionList extends WritableList implements IChangeListener, ICommitListener, IObserving {

	private List<Expression> expressions;

	private IObservableList languages;

	private IObservableList bodies;

	private boolean ignoreChanges = false;

	private IChangeListener nestedChangeListener;

	/**
	 *
	 * Constructor.
	 *
	 * @param languages
	 *            The IObservableList containing Languages
	 * @param bodies
	 *            The IObservableList containing Bodies
	 * @param nestedChangeListener
	 *            Execute listener.
	 */
	public ExpressionList(IObservableList languages, IObservableList bodies, IChangeListener nestedChangeListener) {
		super(new LinkedList<Expression>(), Expression.class);
		expressions = wrappedList;

		this.languages = languages;
		this.bodies = bodies;

		languages.addChangeListener(this);
		bodies.addChangeListener(this);
		this.nestedChangeListener = nestedChangeListener;

		UMLToExpression();
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param languages
	 *            The IObservableList containing Languages
	 * @param bodies
	 *            The IObservableList containing Bodies
	 */
	public ExpressionList(IObservableList languages, IObservableList bodies) {
		this(languages, bodies, null);
	}

	private void UMLToExpression() {
		int maxSize = Math.max(languages.size(), bodies.size());

		Iterator<?> languageIterator = languages.iterator();
		Iterator<?> bodyIterator = bodies.iterator();

		for (int i = 0; i < maxSize; i++) {
			Expression expression;
			if (i < expressions.size()) {
				expression = expressions.get(i);
			}
			else {
				expression = new Expression();
				if (nestedChangeListener != null) {
					expression.addChangeListener(nestedChangeListener);
				}
				expressions.add(expression);
			}

			if (languageIterator.hasNext()) {
				expression.setLanguage((String) languageIterator.next());
			}

			if (bodyIterator.hasNext()) {
				expression.setBody((String) bodyIterator.next());
			}
		}
		// remove additional entries in expressions list that are not in the UML list
		for (int i = maxSize; i < expressions.size(); i++) {
			expressions.remove(i);
		}
	}

	public void handleChange(ChangeEvent event) {
		// A change occurs on languages or bodies
		if (!ignoreChanges) {
			UMLToExpression();
		}
	}

	public void commit(AbstractEditor editor) {
		ignoreChanges = true;
		expressionToUML();
		if (languages instanceof ICommitListener) {
			((ICommitListener) languages).commit(editor);
		}

		if (bodies instanceof ICommitListener) {
			((ICommitListener) bodies).commit(editor);
		}
		ignoreChanges = false;
	}

	void expressionToUML() { // Executes two commands, one on languages, and another one on bodies
		int fillLanguage = 0, fillBody = 0;

		languages.clear();
		bodies.clear();

		Iterator<Expression> iterator = expressions.iterator();
		while (iterator.hasNext()) {
			Expression expression = iterator.next();
			if (expression == null) {
				iterator.remove();
				continue;
			}

			String language = expression.getLanguage();
			String body = expression.getBody();
			if (language == null && body == null) {
				iterator.remove();
				continue;
			}

			if (language != null && body != null) {
				addLanguage(language, fillLanguage);
				addBody(body, fillBody);

				fillBody = fillLanguage = 0;
			}

			if (language == null) {
				fillLanguage++;
				addBody(body, fillBody);
				fillBody = 0;
			} else if (body == null) {
				fillBody++;
				addLanguage(language, fillLanguage);
				fillLanguage = 0;
			}
		}
	}

	private void addBody(String body, int fillBody) {
		for (int i = 0; i < fillBody; i++) {
			bodies.add(""); //$NON-NLS-1$
		}

		bodies.add(body);
	}

	private void addLanguage(String language, int fillLanguage) {
		for (int i = 0; i < fillLanguage; i++) {
			languages.add(""); //$NON-NLS-1$
		}

		languages.add(language);
	}

	public Object getObserved() {
		return //
		(languages instanceof IObserving) ? ((IObserving) languages).getObserved() : //
				(bodies instanceof IObserving) ? ((IObserving) bodies).getObserved() : //
						null;
	}

	/**
	 * A helper class to aggregate the expression body and language in a single
	 * object
	 *
	 * @author Camille Letavernier, Ansgar Radermacher (made observable for handling bug 433647,
	 *         update expression editor, if UML expression changes)
	 */
	public static class Expression extends AbstractObservable {

		public Expression() {
			super(Realm.getDefault());
		}

		String language;

		String body;

		/**
		 * @return this Expression's language
		 */
		public String getLanguage() {
			return language;
		}

		/**
		 * @return this Expression's body
		 */
		public String getBody() {
			return body;
		}

		/**
		 * Sets this Expression's language
		 *
		 * @param language
		 */
		public void setLanguage(String language) {
			if (!StringHelper.equals(language, this.language)) {
				this.language = language;
				fireChange();
			}
		}

		/**
		 * Sets this Expression's body
		 *
		 * @param body
		 */
		public void setBody(String body) {
			if (!StringHelper.equals(body, this.body)) {
				this.body = body;
				fireChange();
			}
		}

		@Override
		public String toString() {
			return language;
		}

		@Override
		public int hashCode() {
			return language == null ? 0 : language.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Expression)) {
				return false;
			}

			Expression otherExpression = (Expression) other;
			if (otherExpression.getLanguage() == null) {
				return getLanguage() == null;
			}

			return otherExpression.getLanguage().equals(getLanguage());
		}

		public boolean isStale() {
			return false;
		}
	}
}
