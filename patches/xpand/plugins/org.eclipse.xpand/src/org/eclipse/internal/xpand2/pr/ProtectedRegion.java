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

package org.eclipse.internal.xpand2.pr;

import java.io.File;

public interface ProtectedRegion {

    public String getBody(String startComment, String endComment) throws ProtectedRegionSyntaxException;

    public String getStartString(String startComment, String endComment);

    public String getEndString(String startComment, String endComment);

    public boolean isDisabled ();
    
	public int getStartIndex();

	public int getEndIndex();
	
	public String getFileEncoding();
	
	public File getFile();
	
	public boolean isUseBASE64();
}
