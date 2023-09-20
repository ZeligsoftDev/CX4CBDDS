/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.internal.xpand2.pr.util.FSIO;

/**
 * Java helper class for Stdlib extension <tt>org::eclipse::xtend::util::stdlib::cloning</tt>.
 * Contains extension functions for logging messages and errors.
 */
public class IOExtensions {
    private final static Logger log = LogManager.getLogger(IOExtensions.class);

    public final static void syserr(final Object s) {
    	System.err.println(s);
    }

    public final static void syserr(final Object s, String prefix) {
    	System.err.println("["+prefix+"] "+s);
    }

    public final static void debug(final Object s) {
        log.debug(s);
    }

    public final static void info(final Object s) {
        log.info(s);
    }

    public final static void error(final Object s) {
        log.error(s);
    }
    public final static void throwError(final Object s) {
    	throw new IllegalStateException(""+s);
    }
    
    public final static String includeFile (final String filePath, String encoding) {
    	File f = new File(filePath);
    	if (!f.exists()) {
    		log.warn("Cannot include content from file "+filePath+". The file does not exist.");
    		return "";
    	}
    	try {
    		return FSIO.readSingleFile(new File(filePath), encoding);
    	} catch (IOException e) {
    		log.warn(e.getMessage());
    		return "";
    	}
    }

}
