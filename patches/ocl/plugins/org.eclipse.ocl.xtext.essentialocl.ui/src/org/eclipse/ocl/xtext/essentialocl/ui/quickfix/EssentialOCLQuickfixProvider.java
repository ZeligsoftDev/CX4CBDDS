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
package org.eclipse.ocl.xtext.essentialocl.ui.quickfix;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.xtext.base.ui.quickfix.BaseQuickfixProvider;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.validation.Issue;

public class EssentialOCLQuickfixProvider extends BaseQuickfixProvider
{
	private static final Logger logger = LogManager.getLogger(EssentialOCLQuickfixProvider.class);

	protected class EssentialOCLQuickfixProcessor extends QuickfixProcessor
	{
		public EssentialOCLQuickfixProcessor(IXtextDocument xtextDocument, Issue issue,
				IssueResolutionAcceptor issueResolutionAcceptor) {
			super(xtextDocument, issue, issueResolutionAcceptor);
		}

		@Override
		public void createResolution(String issueString, IEObjectDescription solution, String ruleName, Keyword keyword, boolean caseInsensitive) {
			String replacement = qualifiedNameConverter.toString(solution.getName());
			String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
			EObject eObjectOrProxy = solution.getEObjectOrProxy();
			if (eObjectOrProxy instanceof Element) {
				replaceLabel += " - " + PrettyPrinter.print((Element) eObjectOrProxy);
			}
			if (keyword != null) {
				if (caseInsensitive && !replacement.equalsIgnoreCase(keyword.getValue()))
					return;
				if (!caseInsensitive && !replacement.equals(keyword.getValue()))
					return;
			} else if (ruleName != null) {
				replacement = valueConverter.toString(replacement, ruleName);
			} else {
				logger.error("either keyword or ruleName have to present", new IllegalStateException());
			}
			issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel, fixCrossReferenceImage(
					issueString, replacement), new ReplaceModification(issue, replacement));
		}
	}
	@Override
	protected QuickfixProcessor createQuickfixProcessor(IXtextDocument xtextDocument,
			Issue issue, IssueResolutionAcceptor issueResolutionAcceptor) {
		return new EssentialOCLQuickfixProcessor(xtextDocument, issue, issueResolutionAcceptor);
	}
}
