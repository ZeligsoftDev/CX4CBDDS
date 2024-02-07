/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.utils;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ocl.examples.debug.vm.DebugVMPlugin;
import org.eclipse.ocl.examples.debug.vm.messages.VMMessages;
import org.eclipse.osgi.util.NLS;

/**
 * @author pkobiakov
 */
public class MiscUtil {
	private MiscUtil() {}

    
    public static IStatus makeErrorStatus(Exception e) {
        return new Status(IStatus.ERROR, DebugVMPlugin.PLUGIN_ID, IStatus.ERROR, NLS.bind(VMMessages.MiscUtil_ErrorMessage, e.getMessage()), e);
    }
    
	public static IStatus makeErrorStatus(String message, Exception e) {
		return new Status(IStatus.ERROR, DebugVMPlugin.PLUGIN_ID, IStatus.ERROR, message, e);
	}

	public static IStatus makeErrorStatus(String message) {
		return new Status(IStatus.ERROR, DebugVMPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
	}	
	
//	public static String readStream(CFile file) throws IOException {
//	    return readAndClose(CFileUtil.getReader(file));
//	}

	public static String readAndClose(Reader reader) throws IOException {
	    StringBuffer contents = new StringBuffer();
	    try {
	        char[] buf = new char[4096];
	        int read;
	        while((read=reader.read(buf)) > 0) {
	            contents.append(buf, 0, read);
	        }
	    }
	    finally {
	        try { reader.close(); } catch(IOException e) {}
	    }
	 
	    return contents.toString();
	}	
	
	public static int getLineNumber(CharSequence data, int pos) {
		int length = data.length();
		pos = Math.min(pos, length);
		int line = 1;
		for(int i = 0; i < pos; i++) {
			if(data.charAt(i) == '\n') {
				line++;
			}
		}
		
		return line;
    }
	
}
