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
package org.eclipse.ocl.xtext.base.serializer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.serializer.sequencer.HiddenTokenSequencer;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class BaseHiddenTokenSequencer extends HiddenTokenSequencer
{
	@Inject
 	private BaseGrammarAccess grammarAccess;

	protected void emitComments(EObject semanticChild) {
		if (semanticChild instanceof ModelElementCS) {
			Element pivot = ((ModelElementCS)semanticChild).getPivot();
			if (pivot != null) {
				List<Comment> ownedComment = pivot.getOwnedComments();
				if (ownedComment.size() > 0) {
					String commentIndent = getCommentIndent(semanticChild);
					TerminalRule ml_COMMENTRule = grammarAccess.getML_COMMENTRule();
					for (Comment comment : ownedComment) {
						String body = comment.getBody();
						if (body != null) {
							String indentedBody = body.replaceAll("\\n", "\n" + commentIndent + " * ");
							String formattedBody = "/*\n" + commentIndent + " * " + indentedBody + "\n" + commentIndent + " */";
							delegate.acceptComment(ml_COMMENTRule, formattedBody, null);
						}
						else {
							delegate.acceptComment(ml_COMMENTRule, "/**/", null);
						}
					}
				}
			}
		}
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		emitComments(semanticChild);
		return super.enterAssignedAction(action, semanticChild, node);
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		if (!super.enterAssignedParserRuleCall(rc, semanticChild, node)) {
			return false;
		}
		emitComments(semanticChild);
		return true;
	}

	private static List<String> indents = new ArrayList<String>();

	protected String getCommentIndent(EObject semanticChild) {
		int i = 0;
		EObject eObject = semanticChild;
		while (eObject != null) {
			EObject eContainer = eObject.eContainer();
			if (eContainer instanceof RootCS) {
				break;
			}
			eObject = eContainer;
			i++;
		}
		if (i >= indents.size()) {
			for (int j = indents.size(); j <= i; j++) {
				if (j == 0) {
					indents.add("");
				}
				else {
					indents.add(indents.get(j-1) + "\t");
				}
			}
		}
		return indents.get(i);
	}
}
