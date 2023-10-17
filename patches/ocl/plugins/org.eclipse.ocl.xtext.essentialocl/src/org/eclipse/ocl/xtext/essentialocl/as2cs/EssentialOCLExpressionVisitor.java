/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.as2cs;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;

public class EssentialOCLExpressionVisitor extends EssentialOCLReferenceVisitor
{
	public static final Logger logger = LogManager.getLogger(EssentialOCLExpressionVisitor.class);

	public EssentialOCLExpressionVisitor(@NonNull AS2CSConversion context, @Nullable Namespace scope) {
		super(context, scope);
	}
}