/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class EssentialOCLHighlightingConfiguration extends DefaultHighlightingConfiguration
{
	public final static String CROSS_REF = "CrossReference";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(CROSS_REF, "Cross References", crossReferenceTextStyle());
		super.configure(acceptor);
	}

	public TextStyle crossReferenceTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}
