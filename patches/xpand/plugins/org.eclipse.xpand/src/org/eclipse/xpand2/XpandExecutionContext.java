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

package org.eclipse.xpand2;

import java.util.List;

import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xpand2.model.XpandResource;
import org.eclipse.internal.xpand2.pr.ProtectedRegionResolver;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

public interface XpandExecutionContext extends ExecutionContext {

    public ProtectedRegionResolver getProtectedRegionResolver();

    public Output getOutput();

    public List<XpandDefinition> getAllDefinitions();
    
    public XpandDefinition findDefinition(String name, Type target, Type[] paramTypes);

    public XpandResource findTemplate(String templateName);

}
