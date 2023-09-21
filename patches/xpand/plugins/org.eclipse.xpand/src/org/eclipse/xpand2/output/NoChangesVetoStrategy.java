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
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class NoChangesVetoStrategy implements VetoStrategy {
	
	private final Logger log = LogManager.getLogger(getClass());

	public boolean hasVeto(FileHandle handle) {
		return !hasChanges(handle);
	}

	public boolean hasChanges(FileHandle h) {
		File f = new File(h.getAbsolutePath());
		if (f.exists()) {
			try {
				InputStream oldIs = new FileInputStream(f);
				byte[] bytes = getBytes(h);
				try {
					byte[] lbuffer = new byte[bytes.length];
					oldIs.read(lbuffer);
					if (oldIs.read() ==-1) {
						for (int i = 0; i < lbuffer.length; i++) {
							if (lbuffer[i]!=bytes[i])
								return true;
						}
					} else {
						return true;
					}
					return false;
				} finally {
					oldIs.close();
				}
			} catch (Exception e) {
				log.error("Couldn't compare content of file "+h.getAbsolutePath(), e);
				log.error("File "+h.getAbsolutePath()+" will not be overwritten");
				return false;
			}
		}
		return true;
	}
	
	public byte[] getBytes(FileHandle h) {
		if (h.getFileEncoding() != null) {
			try {
				return h.getBuffer().toString().getBytes(h.getFileEncoding());
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage(), e);
			}
		}
		return h.getBuffer().toString().getBytes();
	}
}
