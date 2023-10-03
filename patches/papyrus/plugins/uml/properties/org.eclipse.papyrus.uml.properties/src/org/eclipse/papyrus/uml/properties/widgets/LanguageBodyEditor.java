/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.widgets;

/**
 * This class allows to manage the change of the language to use in a body editor.
 * This interface has been created to fix the Bug 536594: [Properties][OpaqueExpression][XText] the change of the language to use doesn't work propertly with Xtext editor
 * 
 * @author Vincent LORENZO
 * @since 3.2
 */
public interface LanguageBodyEditor extends BodyEditor {

	/**
	 * 
	 * @param language
	 *            the language associated to the editor, it can't be <code>null</code>
	 */
	public default void setLanguage(final String language) { // default to ensure implementation and avoid API break
		// do nothing
	}

	/**
	 * 
	 * @return
	 * 		the language associated to the editor, it can be an empty string if the language is not yet defined
	 *         it can't return <code>null</code>
	 */
	public default String getLanguage() {
		return ""; //$NON-NLS-1$ //to ensure implementation and avoid API break
	}
}
