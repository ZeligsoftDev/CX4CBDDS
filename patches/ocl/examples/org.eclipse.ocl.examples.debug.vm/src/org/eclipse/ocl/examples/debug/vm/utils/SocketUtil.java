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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;

public class SocketUtil
{
	protected final @NonNull VMDebugCore debugCore;
	
	public SocketUtil(@NonNull VMDebugCore debugCore) {
		this.debugCore = debugCore;
	}

	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 * 
	 * @return a free port number on localhost, or -1 if unable to find a free port
	 */
	public static int findFreePort() {
		ServerSocket socket= null;
		try {
			socket= new ServerSocket(0);
			return socket.getLocalPort();
		} catch (IOException e) { 
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		return -1;		
	}	

	public boolean close(Socket socket) {
		try {
			socket.close();
			return true;
		} catch (IOException e) {
			Trace trace = debugCore.getTrace();
	        if (trace.shouldTraceCatching()) {
	        	trace.catching(SocketUtil.class, "close(Socket socket)", e); //$NON-NLS-1$
	        }
			
	        debugCore.log(e);
		}
		
		return false;
	}
	
	public boolean close(ServerSocket socket) {
		try {
			socket.close();
			return true; 
		} catch (IOException e) {
			Trace trace = debugCore.getTrace();
	        if (trace.shouldTraceCatching()) {
	        	trace.catching(SocketUtil.class, "close(ServerSocket socket)", e); //$NON-NLS-1$
	        }
			
	        debugCore.log(e);
		}
		return false;
	}	
	
	public boolean close(InputStream is) {
		try {
			is.close();
			return true; 
		} catch (IOException e) {
			Trace trace = debugCore.getTrace();
	        if (trace.shouldTraceCatching()) {
	        	trace.catching(SocketUtil.class, "close(InputStream is)", e); //$NON-NLS-1$
	        }
			
	        debugCore.log(e);
		}
		return false;
	}
	
	public boolean close(OutputStream os) {
		try {
			os.close();
			return true; 
		} catch (IOException e) {
			Trace trace = debugCore.getTrace();
	        if (trace.shouldTraceCatching()) {
	        	trace.catching(SocketUtil.class, "close(OutputStream os)", e); //$NON-NLS-1$
	        }
			
	        debugCore.log(e);
		}
		
		return false;
	}	
}
