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
package org.eclipse.ocl.xtext.base.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

public class BaseAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider
{
//	@Override
//	protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
//		acceptor.accept(singleLineTerminals.newInstance("/*", "*/"),IDocument.DEFAULT_CONTENT_TYPE);
//		acceptor.accept(multiLineTerminals.newInstance("/*"," * ", "*/"),IDocument.DEFAULT_CONTENT_TYPE);
//		acceptor.accept(multiLineTerminals.newInstance("/*"," * ", "*/"),TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
//	}

//	@Override
//	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
//		acceptor.accept(singleLineTerminals.newInstance("{", "}"),IDocument.DEFAULT_CONTENT_TYPE);
//		acceptor.accept(multiLineTerminals.newInstance("{", null, "}"),IDocument.DEFAULT_CONTENT_TYPE);
//	}

//	@Override
//	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
//		acceptor.accept(singleLineTerminals.newInstance("[", "]"),IDocument.DEFAULT_CONTENT_TYPE);
//		acceptor.accept(multiLineTerminals.newInstance("[", null, "]"),IDocument.DEFAULT_CONTENT_TYPE);
//	}

//	@Override
//	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
//		acceptor.accept(singleLineTerminals.newInstance("(", ")"),IDocument.DEFAULT_CONTENT_TYPE);
//		acceptor.accept(multiLineTerminals.newInstance("(", null, ")"),IDocument.DEFAULT_CONTENT_TYPE);
//	}

	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		// Clone of the inherited method excluding the double quote functionality
		acceptor.accept(partitionInsert.newInstance("'","'"),IDocument.DEFAULT_CONTENT_TYPE);
		// The following two are registered for the default content type, because on deletion
		// the command.offset is cursor-1, which is outside the partition of terminals.length = 1.
		// How crude is that?
		// Note that in case you have two string literals following each other directly, the deletion strategy wouldn't apply.
		// One could add the same strategy for the STRING partition in addition to solve this
		acceptor.accept(partitionDeletion.newInstance("'","'"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionEndSkippingEditStrategy.get(),TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
	}
}
