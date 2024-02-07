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
package org.eclipse.xpand2.output;

import java.io.File;

public interface FileHandle {
    public Outlet getOutlet();

    public CharSequence getBuffer();

    public void setBuffer (CharSequence buffer);

    @Deprecated
    /**
     * @deprecated in order to support other storage systems as well. Might throw exception if used with a non java.io based persistence layer. 
     * Use #getAbsolutePath instead.
     */
    public File getTargetFile();
    
    public String getAbsolutePath();

    public boolean isAppend();

    public boolean isOverwrite();

    public String getFileEncoding();

    public void writeAndClose();
}
