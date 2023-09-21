/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Karsten Thoms - initial API and implementation
 *******************************************************************************/
package org.eclipse.xpand2.output;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.MessageFormat;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Message Pattern Variables
 * {0} : File Path (including name)
 * {1} : File name
 * {2} : LOC current file
 * {3} : LOC total
 * {4} : Number of files written by this postprocessor
 *
 * Logger Level
 * 0 = Trace
 * 1 = Debug
 * 2 = Info
 */
public class FileInfoLogger implements PostProcessor {
    private static final Logger LOG = LogManager.getLogger(FileInfoLogger.class);
    private static int loc = 0;
    private static int files = 0;
    private String messagePattern = "{1}: {2} LOC, total: {3} LOC in {4} files";
    private int logLevel = 2;

    public void afterClose(FileHandle handle) {
    	// nothing to do here
    }

    public void beforeWriteAndClose(FileHandle handle) {
        BufferedReader reader = new BufferedReader(new StringReader(handle.getBuffer().toString()));
        int lines = 0;
        try {
        	if (messagePattern.contains("{2}") || messagePattern.contains("{3}")) {
        		// just count lines if they will be reported
	            while (reader.readLine() != null) {
	                lines++;
	            }
	            loc += lines;
        	}

            files++;

            switch (logLevel) {
            case 2:
                if (LOG.isInfoEnabled()) {
                    LOG.info(getLogMessage(handle, lines));
                }
                break;
            case 1:
                if (LOG.isDebugEnabled()) {
                    LOG.debug(getLogMessage(handle, lines));
                }
                break;
            case 0:
                if (LOG.isTraceEnabled()) {
                    LOG.trace(getLogMessage(handle, lines));
                }
                break;
            }
        } catch (IOException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(handle.getAbsolutePath() + ": " + e.getMessage());
            }
        }
    }

	private String getLogMessage(FileHandle handle, int lines) {
		return MessageFormat.format(messagePattern, handle.getAbsolutePath(), handle.getAbsolutePath(), lines,  loc , files);
	}

	public void setMessagePattern(String messagePattern) {
		this.messagePattern = messagePattern;
	}

	public String getMessagePattern() {
		return messagePattern;
	}

    public int getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(int logLevel) {
		this.logLevel = logLevel;
	}

}
