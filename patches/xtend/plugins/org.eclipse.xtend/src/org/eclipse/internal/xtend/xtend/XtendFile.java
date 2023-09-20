/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend;

import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.xtend.ast.Around;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.ResourceManager;

public interface XtendFile extends Resource {

    public static final String FILE_EXTENSION = "ext";

    List<Extension> getExtensions();
    
    List<Around> getArounds();

    List<Extension> getPublicExtensions(ResourceManager resourceManager,ExecutionContext ctx);

    /**
     * This method is public only for technical reasons - do not call directly!
     */
    List<Extension> getPublicExtensions(ResourceManager resourceManager,  ExecutionContext ctx, Set<String> flowoverCache);

    void analyze(ExecutionContext ctx, Set<AnalysationIssue> issues);

}
