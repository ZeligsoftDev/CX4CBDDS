/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 */
public class MarkupFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
// It's usually a good idea to activate the following three statements.
// They will add and preserve newlines around comments
//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getSL_COMMENTRule());
//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getML_COMMENTRule());
//		c.setLinewrap(0, 1, 1).after(getGrammarAccess().getML_COMMENTRule());
	}
}
