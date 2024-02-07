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
import java.io.Writer;
import java.text.MessageFormat;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;

/**
 * A basic logger backed-up with {@link Writer}. 
 * 
 * @author dvorak
 * 
 * @noextend This class is not intended to be subclassed by clients.
 */
public class WriterLog implements Log {
	
	private static final String LINE_SEP = System.getProperty("line.separator"); //$NON-NLS-1$
	
	protected final @NonNull VMDebugCore debugCore;
	private final @NonNull Writer fWriter;	
	private String fRecordSeparator;
	private boolean fFlush;
	private boolean fErrorLogged;
	
	/**
	 * Constructs a log for the given writer object.
	 * 
	 * @param writer
	 *            the writer object to receive the log record data
	 * @throws IllegalArgumentException
	 *             if the passed <code>writer</code> is <code>null</code>
	 */
//	public WriterLog(Writer writer) {
//		this(writer, true);
//	}
	
	/**
	 * Constructs a log for the given writer object.
	 * @param debugCore 
	 * 
	 * @param writer
	 *            the writer object to receive the log record data
	 * @param flush
	 *            if <code>true</code>, the writer gets flushed with every
	 *            record logged. If set to <code>false</code>, the flushing
	 *            behavior is dependent on the writer implementation used
	 * @throws IllegalArgumentException
	 *             if the passed <code>writer</code> is <code>null</code>
	 */
	public WriterLog(@NonNull VMDebugCore debugCore, @NonNull Writer writer, boolean flush) {
		this.debugCore = debugCore;
		fWriter = writer; 
		fRecordSeparator = LINE_SEP;
		fErrorLogged = false;
		fFlush = flush;
	}	
	
	protected final Writer getWriter() {
		return fWriter;
	}
	
	public void log(int level, String message, Object param) {
		String recordStr = MessageFormat.format("Level {0} - {1}, data: {2}", level, message, String.valueOf(param)); //$NON-NLS-1$
		logRecord(recordStr);
	}
	
	public void log(int level, String message) {
		String recordStr = MessageFormat.format("Level {0} - {1}", level, message); //$NON-NLS-1$
		logRecord(recordStr);
	}

	public void log(String message, Object param) {
		String recordStr = MessageFormat.format("{0}, data: {1}", message, String.valueOf(param)); //$NON-NLS-1$
		logRecord(recordStr);
	}		
	
	public void log(String message) {
		logRecord(message);
	}
	
	private void logRecord(String recordStr) {
		try {
			fWriter.write(recordStr);
			fWriter.write(fRecordSeparator);
			if(fFlush) {
				fWriter.flush();
			}
		} catch (IOException e) {
			if(!fErrorLogged) {
				debugCore.error(e);
				fErrorLogged = true;
			}
		}
	}	
}
