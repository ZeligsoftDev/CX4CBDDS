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
 *  Mickael ADAM (ALL4TEC) - mickael.adam@all4tec.net - Bug 500219 - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.profile.definition;

/**
 * the differents type of label that can compose an UML Label.
 * @since 3.0
 */
public enum LabelTypesEnum {

	/** The default core label. */
	LABEL("label"), //$NON-NLS-1$

	/** The qualify name. */
	QUALIFIED_NAME("qualifiedName"), //$NON-NLS-1$

	/** The stereotype. */
	STEREOTYPE("stereotype"), //$NON-NLS-1$

	/** The metaclass. */
	METACLASS("metaclass"), //$NON-NLS-1$

	/** The dash Separator. */
	DASH_SEPARATOR("dashSeparator"), //$NON-NLS-1$

	/** The colon Separator. */
	COLON_SEPARATOR("colonSeparator"); //$NON-NLS-1$

	/** The literal. */
	private String literal;

	/**
	 * Instantiates a new label style enum.
	 *
	 * @param literal
	 *            the literal
	 */
	private LabelTypesEnum(final String literal) {
		this.literal = literal;
	}

	/**
	 * Gets the literal.
	 *
	 * @return the literal
	 */
	public String getLiteral() {
		return literal;
	}

	/** The Constant LINE_STYLE_ARRAY. */
	private static final LabelTypesEnum[] TYPES_ARRAY = new LabelTypesEnum[] { LABEL, STEREOTYPE, QUALIFIED_NAME, COLON_SEPARATOR, DASH_SEPARATOR, METACLASS };

	/**
	 * Gets the by literal.
	 *
	 * @param literal
	 *            the literal
	 * @return the by literal
	 */
	public static LabelTypesEnum getByLiteral(final String literal) {
		for (int i = 0; i < TYPES_ARRAY.length; ++i) {
			LabelTypesEnum result = TYPES_ARRAY[i];
			if (result.getLiteral().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return literal;
	}
}
