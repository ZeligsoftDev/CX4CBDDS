/*******************************************************************************
 * Copyright (c) 2011 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css3.ui.highlighting;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CssTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ElementSelector;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.FuncTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IdentifierTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.StringTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.SymbolTok;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.URLType;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.simple_selector;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class CSSHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, true);
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof ElementSelector) {
				final ICompositeNode n = NodeModelUtils.getNode((EObject) o);
				if (n != null) {
					acceptor.addPosition(n.getOffset(), n.getLength(), CSSHighlightingConfiguration.ELEMENT);
				}
			} else if (o instanceof IdentifierTok) {
				final ICompositeNode n = NodeModelUtils.getNode((EObject) o);
				if (n != null) {
					acceptor.addPosition(n.getOffset(), n.getLength(), DefaultHighlightingConfiguration.DEFAULT_ID);
				}
			} else if (o instanceof css_declaration) {
				css_declaration dec = (css_declaration) o;
				if (dec.getProperty() != null && dec.getProperty().getName() != null && dec.getProperty().getName().trim().length() > 0) {
					ICompositeNode n = NodeModelUtils.getNode(dec);
					if (n != null) {
						if (n.hasChildren()) {
							acceptor.addPosition(n.getFirstChild().getOffset(), n.getFirstChild().getLength(), CSSHighlightingConfiguration.DECLARATIONNAME);
						}
					}
				}
			} else if (o instanceof simple_selector) {
				final ICompositeNode n = NodeModelUtils.getNode((EObject) o);
				if (n != null) {
					acceptor.addPosition(n.getOffset(), n.getLength(), CSSHighlightingConfiguration.SELECTOR);
				}
			} else if (o instanceof URLType) {
				final URLType url = (URLType) o;
				final ICompositeNode n = NodeModelUtils.getNode(url);
				if (n != null) {
					acceptor.addPosition(n.getOffset(), 4, CSSHighlightingConfiguration.FUNCTION);
					acceptor.addPosition(n.getOffset() + 4, n.getLength() - 5, CSSHighlightingConfiguration.URL);
					acceptor.addPosition(n.getOffset() + n.getLength() - 1, 1, CSSHighlightingConfiguration.FUNCTION);
				}
			} else if (o instanceof FuncTok) {
				final FuncTok funcTok = (FuncTok) o;
				final ICompositeNode n = NodeModelUtils.getNode(funcTok);
				int nameLength = funcTok.getName().getName().length();
				if (n != null) {
					acceptor.addPosition(n.getOffset(), nameLength + 1, CSSHighlightingConfiguration.FUNCTION);
				}
				for (CssTok tok : ((FuncTok) o).getParams()) {
					if (tok instanceof SymbolTok) {
						if (",".equals(((SymbolTok) tok).getSymbol())) { //$NON-NLS-1$
							ICompositeNode colonNode = NodeModelUtils.getNode(tok);
							if (colonNode != null) {
								acceptor.addPosition(colonNode.getOffset(), colonNode.getLength(), CSSHighlightingConfiguration.FUNCTION);
							}
						}
					}
				}
				if (n != null) {
					acceptor.addPosition(n.getOffset() + n.getLength() - 1, 1, CSSHighlightingConfiguration.FUNCTION);
				}
			} else if (o instanceof StringTok) {
				final ICompositeNode n = NodeModelUtils.getNode((EObject) o);
				if (n != null) {
					acceptor.addPosition(n.getOffset(), n.getLength(), DefaultHighlightingConfiguration.STRING_ID);
				}
			}
		}
	}
}
