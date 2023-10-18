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

import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.jdt.annotation.NonNull;

/**
 * @author vrepeshko
 */
public class StreamsProxy implements IStreamsProxy
{
	public StreamsProxy() {
		myOutputStreamMonitor = new WriterMonitor();
		myErrStreamMonitor = new WriterMonitor();
	}
	
	public @NonNull IStreamMonitor getErrorStreamMonitor() {
		return myErrStreamMonitor;
	}

	public @NonNull IStreamMonitor getOutputStreamMonitor() {
		return myOutputStreamMonitor;
	}
	
	public @NonNull Writer getOutputWriter() {
		return myOutputStreamMonitor;
	}
	
	public @NonNull Writer getErrWriter() {
		return myErrStreamMonitor;
	}	

	public void write(String input) throws IOException {
	}
	
	private final @NonNull WriterMonitor myOutputStreamMonitor;
	private final @NonNull WriterMonitor myErrStreamMonitor;
}
