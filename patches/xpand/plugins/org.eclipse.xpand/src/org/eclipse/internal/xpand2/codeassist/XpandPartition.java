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
package org.eclipse.internal.xpand2.codeassist;

import org.eclipse.internal.xtend.xtend.codeassist.Partition;

public class XpandPartition extends Partition {

    public final static XpandPartition EXPAND_STATEMENT = new XpandPartition("EXPAND_STATEMENT");
    
    public XpandPartition(String name) {
        super(name);
    }

}
