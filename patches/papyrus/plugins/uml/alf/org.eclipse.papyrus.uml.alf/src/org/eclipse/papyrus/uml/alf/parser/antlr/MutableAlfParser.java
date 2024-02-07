/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Jérémie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.parser.antlr;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * Provide an extended ALF parser
 */
public class MutableAlfParser extends AlfParser {

	/**
	 * @see org.eclipse.xtext.parser.antlr.AbstractAntlrParser#doReparse(org.eclipse.xtext.parser.IParseResult, org.eclipse.xtext.util.ReplaceRegion)
	 * 
	 * In addition to the initial doReparse method behavior, it handles the fact that reparse may fail.
	 * If it fails then previous parse results are returned.
	 */
	@Override
	protected IParseResult doReparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		IParseResult newParseResult = previousParseResult;
		try {
			newParseResult = super.doReparse(previousParseResult, replaceRegion);
		} catch (Exception e) {
			//Do nothing - It avoids the famous xtext reconcilier job error to block the user
		}
		return newParseResult;
	}
}
