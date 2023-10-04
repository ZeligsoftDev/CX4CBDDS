/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext.formatting;

import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import com.google.inject.Inject;

/**
 * This class contains custom formatting description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class UmlPortFormatter extends AbstractDeclarativeFormatter {

	@Inject
	private UmlPortGrammarAccess grammarAccess;

	@Override
	protected void configureFormatting(FormattingConfig c) {
		org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess f = (org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess) getGrammarAccess();
	}
}
