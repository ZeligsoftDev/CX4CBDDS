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

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.TextStyle;


/**
 * The Enum of Styler used for UML label customization.
 * @since 3.0
 */
public enum LabelStylersEnum {

	/** Default style is apply(from facet customisation) */
	DEFAULT((Styler) null, "default"), //$NON-NLS-1$

	/** The Black */
	BLACK(new RGB(0, 0, 0), "black"), //$NON-NLS-1$

	/** The blue Styler enum(the return Styler return is null) */
	BLUE(StyledString.COUNTER_STYLER, "blue"), //$NON-NLS-1$

	/** The gold Styler enum(the return Styler return is null) */
	GOLD(StyledString.DECORATIONS_STYLER, "gold"), //$NON-NLS-1$

	/** The grey Styler enum(the return Styler return is null) */
	GREY(StyledString.QUALIFIER_STYLER, "grey"); //$NON-NLS-1$

	/** The literal. */
	private String literal;

	/** The styler */
	private Styler styler;

	/**
	 * Instantiates a new label style enum.
	 *
	 * @param styler
	 *            The styler.
	 * @param literal
	 *            The literal.
	 */
	private LabelStylersEnum(final Styler styler, final String literal) {
		this.styler = styler;
		this.literal = literal;
	}

	/**
	 * Instantiates a new label style enum.
	 *
	 * @param color
	 *            The rgb color.
	 * @param literal
	 *            The literal.
	 */
	private LabelStylersEnum(final RGB color, final String literal) {
		JFaceResources.getColorRegistry().put(literal, color);
		this.styler = new DefaultStyler(literal, null);
		this.literal = literal;
	}

	/**
	 * Gets the line style.
	 *
	 * @return the line style
	 */
	public Styler getStyler() {
		return styler;
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
	private static final LabelStylersEnum[] STYLER_ARRAY = new LabelStylersEnum[] { DEFAULT, BLACK, BLUE, GOLD, GREY };

	/**
	 * Gets the by literal.
	 *
	 * @param literal
	 *            the literal
	 * @return the Enum by literal
	 */
	public static LabelStylersEnum getByLiteral(final String literal) {
		for (int i = 0; i < STYLER_ARRAY.length; ++i) {
			LabelStylersEnum result = STYLER_ARRAY[i];
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

	private static class DefaultStyler extends Styler {
		private final String fForegroundColorName;
		private final String fBackgroundColorName;

		public DefaultStyler(String foregroundColorName,
				String backgroundColorName) {
			fForegroundColorName = foregroundColorName;
			fBackgroundColorName = backgroundColorName;
		}

		@Override
		public void applyStyles(TextStyle textStyle) {
			ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
			if (fForegroundColorName != null) {
				textStyle.foreground = colorRegistry.get(fForegroundColorName);
			}
			if (fBackgroundColorName != null) {
				textStyle.background = colorRegistry.get(fBackgroundColorName);
			}
		}
	}
}
