/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xpand2;

import org.eclipse.xtend.expression.AnalysationIssue.AnalysationIssueType;

public interface XpandCompilerIssue {

	public final static AnalysationIssueType DEFINITION_NOT_FOUND = new AnalysationIssueType("Definition not found");

}
