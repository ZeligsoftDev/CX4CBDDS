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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.internal.xpand2.ast.Statement;

public class FileHandleImpl implements FileHandle, InsertionPointSupport {
	private final Logger log =
			LogManager.getLogger(getClass());

	private List<CharSequence> buffers = new ArrayList<CharSequence>();
	private Map<Statement, CharSequence> namedBuffers = new HashMap<Statement, CharSequence>();
	private CharSequence currentNamedBuffer = null;
	private CharSequence currentUnnamedBuffer;

	private File targetFile =
			null;

	private Outlet outlet =
			null;

	public FileHandleImpl(final Outlet outlet, final File f) {
		this.outlet =
				outlet;
		targetFile =
				f.getAbsoluteFile();
		buffers.add(new StringBuilder(4096));
		currentUnnamedBuffer = buffers.get(0);
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public CharSequence getBuffer() {
		if (!namedBuffers.isEmpty()) {
			return currentNamedBuffer!=null ? currentNamedBuffer : currentUnnamedBuffer;
		}
		if (buffers.size()>1) {
			// no insertion point used anymore, but multiple buffers available
			// => compact to one buffer again
			StringBuilder compacted = new StringBuilder();
			for (CharSequence cs : buffers) {
				compacted.append(cs);
			}
			buffers.clear();
			buffers.add(compacted);
			currentUnnamedBuffer = compacted;
		}
		return buffers.get(0);
	}

	public void setBuffer(final CharSequence newBuffer) {
		if (currentNamedBuffer != null) {
			int idx = buffers.indexOf(currentNamedBuffer);
			while (idx>=0) {
				buffers.add(idx, newBuffer);
				buffers.remove(idx+1);
				idx = buffers.indexOf(currentNamedBuffer);
			}
			for (Statement key : namedBuffers.keySet()) {
				if (namedBuffers.get(key)==currentNamedBuffer) {
					namedBuffers.put(key, newBuffer);
				}
			}
			currentNamedBuffer = newBuffer;
		} else {
			int idx = buffers.indexOf(currentUnnamedBuffer);
			buffers.add(idx, newBuffer);
			buffers.remove(idx+1);
			currentUnnamedBuffer = newBuffer;
		}
	}

	public File getTargetFile() {
		return targetFile;
	}

	public String getAbsolutePath() {
		return getTargetFile().getAbsolutePath();
	}

	public boolean isAppend() {
		return outlet.isAppend();
	}

	public boolean isOverwrite() {
		return outlet.isOverwrite();
	}

	public String getFileEncoding() {
		return outlet.getFileEncoding();
	}

	public void writeAndClose() {
		try {
			if (!isOverwrite() && targetFile.exists()) {
				if (log.isDebugEnabled()) {
				log.debug("Skipping file : " + targetFile.getAbsolutePath() + " cause it exists already");
				}
				return;
			}
			if (log.isDebugEnabled()) {
			log.debug("Opening file : " + targetFile.getAbsolutePath());
			}
			// create all parent directories
			final File parentDir =
					targetFile.getParentFile();
			if (!parentDir.exists()) {
				parentDir.mkdirs();
				if (!parentDir.isDirectory()) {
					throw new RuntimeException("Failed to create parent directories of file "
							+ targetFile.getAbsolutePath());
				}
			}
			outlet.beforeWriteAndClose(this);
			if (outlet.shouldWrite(this)) {
				FileOutputStream out =
						null;
				try {
					out =
							new FileOutputStream(targetFile, isAppend());
					out.write(getBytes());
				}
				finally {
					if (out != null) {
						try {
							out.close();
							outlet.afterClose(this);
						}
						catch (final IOException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public byte[] getBytes() {
		CharSequence buffer = null;
		if (buffers.size()==1) {
			buffer = buffers.get(0);
		} else {
			StringBuilder tmp = new StringBuilder();
			for (CharSequence cs : buffers) {
				tmp.append(cs);
			}
			buffer = tmp;
		}
		String fileEncoding = getFileEncoding();
		if (fileEncoding != null && !"".equals(fileEncoding)) {
			try {
				return buffer.toString().getBytes(fileEncoding);
			}
			catch (final UnsupportedEncodingException e) {
				log.error(e.getMessage(), e);
			}
		}
		return buffer.toString().getBytes();
	}

	public void activateInsertionPoint(Statement stmt) {
		CharSequence buffer = namedBuffers.get(stmt);
		if (buffer == null) {
			throw new IllegalStateException ("Unknown insertion point "+stmt+".");
		}
		currentNamedBuffer = buffer;
	}

	public void deactivateInsertionPoint(Statement stmt) {
		if (currentNamedBuffer == null) {
			throw new IllegalStateException ("Insertion point for "+stmt+" was not activated.");
		}
		CharSequence buffer = namedBuffers.get(stmt);
		if (buffer == null) {
			throw new IllegalStateException ("Unknown insertion point "+stmt+".");
		}
		if (buffer != currentNamedBuffer) {
			throw new IllegalStateException ("Insertion point "+stmt+" is not the active one!");
		}
		namedBuffers.remove(stmt);
		currentNamedBuffer = null;
	}

	public void registerInsertionPoint(Statement stmt) {
		CharSequence namedBuffer = namedBuffers.get(stmt);
		if (namedBuffer == null) {
			namedBuffer = new StringBuilder();
			namedBuffers.put(stmt, namedBuffer);
		}

		buffers.add(namedBuffer);
		currentUnnamedBuffer = new StringBuilder();
		buffers.add(currentUnnamedBuffer);
	}

}
