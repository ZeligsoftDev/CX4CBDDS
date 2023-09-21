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

package org.eclipse.internal.xpand2.pr.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Configurable FilenameFilter. By default this filter does not accept well known files or directories 
 * managed by source control systems and temporary files. 
 *
 * @see "http://www.cvshome.org/docs/manual/cvs-1.11.10/cvs_18.html#SEC156"
 */
public class GenericFileFilter implements FilenameFilter {
    private final Logger log = LogManager.getLogger(getClass());

    // ignore list vom CVS and SVN.
    public final static String DEFAULTIGNORELIST =
    	      ".svn "
    	    + "RCS     SCCS    CVS     CVS.adm RCSLOG  cvslog.* "
            + "tags    TAGS    .make.state     .nse_depinfo " 
            + "*~      #*      .#*     ,*      _$*     *$ "
            + "*.old   *.bak   *.BAK   *.orig  *.rej   .del-* " 
            + "*.a     *.olb   *.o     *.obj   *.so    *.exe "
            + "*.Z     *.elc   *.ln " + "core "
            ;

    private String ivIgnoreList;

    private List<GlobbingFileFilter> fileFilters = null;

    /**
     * 
     * @param aIgnoreList List of file patterns to ignore. This list can be comma-separated or space-separated.
     * Note that file patterns containing commas can't be handled, since they will be recognized as two separated patterns.
     * @param aDefaultexcludes <code>true</code> use the default exclude list.
     */
    public GenericFileFilter(final String aIgnoreList, final boolean aDefaultexcludes) {
        ivIgnoreList = aDefaultexcludes ? DEFAULTIGNORELIST : "";
        if (aIgnoreList != null) {
            ivIgnoreList += aIgnoreList.replaceAll(",", " ");
        }
        fileFilters = buildFileFilters(ivIgnoreList);
    }

    public GenericFileFilter(final String aIgnoreList) {
        this(aIgnoreList, false);
    }

    /**
     * Creates the Filter with default excludes.
     */
    public GenericFileFilter() {
        this(null);
    }

    /**
     * Accept all files and directories not included in the ignore list.
     * @param dir Directory to search in for a file
     * @param name File name to check
     * @return <code>true</code> when the file is accepted by the filter.
     */
    public boolean accept(final File dir, final String name) {
        return accept(new File(dir, name));
    }

    /**
     * Accept all files and directories not included in the ignore list.
     * @param file File to check
     * @return <code>true</code> when the file is accepted by the filter.
     */
    public boolean accept(final File file) {
        if (!file.isFile() && !file.isDirectory())
            return false;

        for (final Iterator<GlobbingFileFilter> iter = fileFilters.iterator(); iter.hasNext();) {
            final FileFilter ffilter = iter.next();
            if (ffilter.accept(file)) {
                if (log.isDebugEnabled()) {
                    log.debug("File " + file + " excluded (pattern: " + ffilter + ").");
                }
                return false;
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("File " + file + " included.");
        }

        return true;
    }

    private List<GlobbingFileFilter> buildFileFilters(final String aIgnoreList) {
        final List<GlobbingFileFilter> fileFilters = new ArrayList<GlobbingFileFilter>();
        for (final StringTokenizer st = new StringTokenizer(aIgnoreList); st.hasMoreTokens();) {
            final String pattern = st.nextToken().trim();
            fileFilters.add(new GlobbingFileFilter(pattern));
        }
        return fileFilters;
    }

    /**
     * File filter that accepts wildcards.
     */
    private static class GlobbingFileFilter implements FileFilter {
        private String globvalue;

        /**
         * Creates a globbing file filter.
         * @param globvalue a filename pattern
         * @throws IllegalArgumentException The file pattern is invalid. Not accepted are the following situations:
         * <ol>
         * <li>The pattern contains multiple wildcards (e.g. <tt>'*test*.xml'</tt>)
         * <li>The pattern has a wildcard in the middle (e.g. <tt>'test*.xml'</tt>)
         * </ol>
         */
        public GlobbingFileFilter(final String globvalue) throws IllegalArgumentException {
            final int pos = globvalue.indexOf("*");
            if (pos>=0) {
	            if (pos != globvalue.lastIndexOf("*")) {
	                throw new IllegalArgumentException("GlobbingFileFilter does not support multiple stars (" + globvalue
	                        + ").");
	            } else if (pos > 0 && pos < (globvalue.length() - 1)) {
	                throw new IllegalArgumentException("GlobbingFileFilter does not support stars in the middle (" + globvalue
	                        + ").");
	            }
            }
            this.globvalue = globvalue;
        }

        /**
         * @param pathname A file to check this filter against
         * @return <code>true</code> if the filter accepts this file, <code>false</code> if it is rejected.
         * @see FileFilter#accept(File)
         */
        public boolean accept(final File pathname) {
            final int pos = globvalue.indexOf("*");
            if (pos == -1) {
            	// no wildcard
                return pathname.getName().equals(globvalue);
            } else if (pos == 0) {
                return pathname.getName().endsWith(globvalue.substring(pos + 1));
            } else { 
            	// must be 'pos == (globvalue.length() - 1)', since other situations already detected in constuctor 
                return pathname.getName().startsWith(globvalue.substring(0, pos));
            } 
        }

        @Override
        public String toString() {
            return globvalue;
        }
    }

    @Override
    public String toString() {
        return ivIgnoreList.replaceAll("\\s+", ", ");
    }
}
