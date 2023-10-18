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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

@SuppressWarnings("deprecation")
public class EssentialOCLSemanticHighlightingCalculator implements ISemanticHighlightingCalculator,org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator
{
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource != null) {
			IParseResult parseResult = resource.getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				for (INode abstractNode : rootNode.getAsTreeIterable()) {
					if (abstractNode.getGrammarElement() instanceof CrossReference) {
						EObject semanticElement = abstractNode.getSemanticElement();
						if (!(semanticElement instanceof PathElementCS) || (((PathElementCS)semanticElement).getElementType() != null)) {
							acceptor.addPosition(abstractNode.getOffset(), abstractNode.getLength(),
								EssentialOCLHighlightingConfiguration.CROSS_REF);
						}
					}
				}
			}
		}
	}

	/**
	 * This method preserves the pre Xtext 2.9 API. It will be removed when the Xtext deprecation is enforced.
	 *
	 * @deprecated use Xtext's ide rather than ui classes.
	 */
	@Deprecated
	@Override
	public void provideHighlightingFor(XtextResource resource, org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		provideHighlightingFor(resource, acceptor, CancelIndicator.NullImpl);
	}
}
