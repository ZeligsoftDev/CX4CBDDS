/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Singleton;

@Singleton
public class BaseTerminalsTokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper
{
	public final static String STRING_LITERAL_PARTITION1 = "__string1";
	public final static String STRING_LITERAL_PARTITION2 = "__string2";
	public final static String ML_STRING_LITERAL_PARTITION = "__ml_string";
	public final static String ESCAPED_ID_PARTITION = "__escaped_id";

	protected static final String[] BASE_SUPPORTED_PARTITIONS = new String[]{
		COMMENT_PARTITION,
		STRING_LITERAL_PARTITION1,
		STRING_LITERAL_PARTITION2,
		ML_STRING_LITERAL_PARTITION,
		ESCAPED_ID_PARTITION,
		IDocument.DEFAULT_CONTENT_TYPE
	};

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_ML_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_SL_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_DOUBLE_QUOTED_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION1;
		} else if ("RULE_SINGLE_QUOTED_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION2;
		} else if ("RULE_ML_SINGLE_QUOTED_STRING".equals(tokenName)) {
			return ML_STRING_LITERAL_PARTITION;
		} else if ("RULE_ESCAPED_ID".equals(tokenName)) {
			return ESCAPED_ID_PARTITION;
		}
		return IDocument.DEFAULT_CONTENT_TYPE;
	}

	@Override
	public String[] getSupportedPartitionTypes() {
		return BASE_SUPPORTED_PARTITIONS;
	}
}