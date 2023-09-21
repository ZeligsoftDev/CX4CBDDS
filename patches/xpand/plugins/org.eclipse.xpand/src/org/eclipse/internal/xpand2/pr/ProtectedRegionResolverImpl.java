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
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.internal.xpand2.pr.util.BASE64;
import org.eclipse.internal.xpand2.pr.util.FSIO;
import org.eclipse.internal.xpand2.pr.util.GenericFileFilter;

/**
 * Default implementation of the {@link ProtectedRegionResolver} interface.
 */
public class ProtectedRegionResolverImpl implements ProtectedRegionResolver {
	private static final Logger LOG = LogManager.getLogger(ProtectedRegionResolverImpl.class);

	private static final String ENABLED = "ENABLED";

	public static class ProtectedRegionImpl implements ProtectedRegion {
		private SoftReference<String> body;

		private String fileEncoding;

		private int endIndex;

		private File file;

		private String id;

		private int startIndex;

		private boolean disabled = true;

		private boolean useBASE64;

		public ProtectedRegionImpl(final String id, final boolean disabled, final File file, final String fileEncoding,
				final boolean useBASE64, final int startIndex, final int endIndex, final String body) {
			this.id = id;
			this.disabled = disabled;

			this.file = file;
			this.fileEncoding = fileEncoding;
			this.useBASE64 = useBASE64;
			this.startIndex = startIndex;
			this.endIndex = endIndex;

			this.body = new SoftReference<String>(body);
		}

		public void setBody(final String body) {
			this.body = new SoftReference<String>(body);
		}

		public String getBody(final String startComment, final String endComment) throws ProtectedRegionSyntaxException {
			String body = this.body.get();

			if (body == null) {
				try {
					body = FSIO.readSingleFile(file, fileEncoding).substring(startIndex, endIndex);
                } catch (final IOException e) {
					throw new RuntimeException("Unexpected I/O exception (source files removed?)", e);
				}
			}

			final int endCommentIndex = body.indexOf(endComment);

			if ((endCommentIndex < 0) || (body.substring(0, endCommentIndex).trim().length() > 0))
				throw new ProtectedRegionSyntaxException("Start of protected region " + id
						+ " does not end with comment " + endComment);

			final int startCommentIndex = body.lastIndexOf(startComment);

			if ((startCommentIndex < 0)
					|| (body.substring(startCommentIndex + startComment.length()).trim().length() > 0))
				throw new ProtectedRegionSyntaxException("End of protected region " + id
						+ " does not start with comment " + startComment);

			return body.substring(endCommentIndex + endComment.length(), startCommentIndex);
		}

		public String getEndString(final String startComment, final String endComment) {
			return startComment + PROTECT_END + endComment;
		}

		public File getFile() {
			return file;
		}

		public String getId() {
			return id;
		}

		public String getFileEncoding() {
			return fileEncoding;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public boolean isDisabled() {
			return disabled;
		}

		public boolean isUseBASE64() {
			return useBASE64;
		}

		public String getStartString(final String startComment, final String endComment) {
			if (useBASE64) {
				try {
					return (startComment + PROTECT_BEGIN + PROTECT_B64_BEFORE_ID + BASE64.toString(id)
							+ PROTECT_B64_AFTER_ID + " " + (!disabled ? ENABLED + " " : "") + PROTECT_START_END + endComment);
                } catch (final IOException ie) {
					// fallback to old style if BASE64Encoder fails
				}
			}

			return (startComment + PROTECT_BEGIN + PROTECT_BEFORE_ID + id + PROTECT_AFTER_ID + " "
					+ (!disabled ? ENABLED + " " : "") + PROTECT_START_END + endComment);
		}

	}

	private static final String PROTECT_AFTER_ID = ")";

	private static final String PROTECT_B64_AFTER_ID = "]";

	private static final String PROTECT_B64_BEFORE_ID = "[";

	private static final String PROTECT_BEFORE_ID = "(";

	private static final String PROTECT_BEGIN = "PROTECTED REGION ID";

	private static final String PROTECT_END = "PROTECTED REGION END";

	private static final String PROTECT_START_END = "START";

	private final Logger log = LogManager.getLogger(getClass());

	private File[] srcPaths = null;

	private boolean defaultExcludes = true;

	protected boolean useBASE64 = false;

	protected String encoding;

	private String ignoreList = null;

	/**
	 * This map stores all scanned protected regions.
	 * <p>
	 * Key: Protected Region ID<br>
	 * Value: The Protected Region
	 */
	private Map<String, ProtectedRegionImpl> regionMap = null;

	/**
     * All already queried Protected Region Ids. Is used for detecting ambigious usage of
     * Protected Regions.
	 */
	private Set<String> usedSet = null;

	/**
	 * Retrieves all Protected Regions from a source file.
     * @param file The source file to scan.
	 * @return All found Protected Regions in the specified file.
     * @throws ProtectedRegionSyntaxException If one of the Protected Regions in the file is incomplete or invalid.
     * @throws IOException On errors occuring when reading the file
	 */
    protected Collection<ProtectedRegionImpl> getAllRegions(final File file) throws ProtectedRegionSyntaxException, IOException {
		final List<ProtectedRegionImpl> regions = new ArrayList<ProtectedRegionImpl>();

		final String source = FSIO.readSingleFile(file, encoding);

		final int beginLength = PROTECT_BEGIN.length();
		final int startEndLength = PROTECT_START_END.length();
		final int idBeginLength = PROTECT_BEFORE_ID.length();
		final int idEndLength = PROTECT_AFTER_ID.length();

		int start = source.indexOf(PROTECT_BEGIN);

		while (start >= 0) {
			final int blockStart = start + beginLength;

			boolean isB64 = false;
			int idStart = source.indexOf(PROTECT_BEFORE_ID, blockStart);

			if (idStart != blockStart) {
				// IP System.out.println("IDSTART:"+idStart);
				idStart = source.indexOf(PROTECT_B64_BEFORE_ID, blockStart);
				isB64 = true;
			}
			idStart += idBeginLength;

			final int end = source.indexOf(PROTECT_END, idStart);
			final int next = source.indexOf(PROTECT_BEGIN, idStart);

			if ((end < 0) || ((next >= 0) && (next < end)))
				throw new ProtectedRegionSyntaxException("Protected region at index " + start + " in file '" + file
						+ "' is incomplete");

			final int idEnd = source.indexOf(isB64 ? PROTECT_B64_AFTER_ID : PROTECT_AFTER_ID, idStart);

			if ((idEnd <= idStart) || (end < idEnd))
				throw new ProtectedRegionSyntaxException("Protected region Id at index " + start + " in file '" + file
						+ "' is incomplete");

			String id = new String(source.substring(idStart, idEnd));

			if (isB64) {
				try {
					id = new String(BASE64.toByteArray(id));
                } catch (final IOException ie) {
					throw new ProtectedRegionSyntaxException("Protected region Id at index " + start + " in file '"
							+ file + "' is incomplete", ie);
				}
			}

			final int startEnd = source.indexOf(PROTECT_START_END, idEnd + idEndLength);

			if (end < startEnd)
				throw new ProtectedRegionSyntaxException("Protected region start at index " + start + " in file '"
						+ file + "' is incomplete");

			String type = new String(source.substring(idEnd + idEndLength, startEnd).trim().toUpperCase());

			// If start marker is wrapped
			if (type.startsWith(ENABLED) && type.substring(ENABLED.length()).contains("\n*")) {
				type = ENABLED;
			}
				
			if (!(type.equals("") || type.equals(ENABLED)))
				throw new ProtectedRegionSyntaxException("Protected region start at index " + start + " in file "
                        + file + " has illegal type '" + type+ "'");
			if (type.equals(ENABLED)) {
				final String body = new String(source.substring(startEnd + startEndLength, end));
				regions.add(new ProtectedRegionImpl(id, false, file, encoding, useBASE64, startEnd + startEndLength,
						end, body));
			}
			start = next;
		}

		return regions;
	}

	public ProtectedRegion createProtectedRegion(final String id, final boolean disabled) {
		return new ProtectedRegionImpl(id, disabled, null, null, useBASE64, 0, 0, null);
	}

	public ProtectedRegion getProtectedRegion(final String id) {
		init();
//        if (!usedSet.isEmpty()) {  // Fix:No error if Handle is not used
//            return null;
//        }
		if (!usedSet.add(id)) {
			// id was not added to usedSet -> id was already queried before!
			log.warn("Protected region with ID '" + id + "' referenced more than once");
		}

		return regionMap.get(id);
	}

	/**
     * Initializes the ProtectedRegionResolver. This starts the scan over all configured paths (property 'srcPaths').
	 * <p>
     * A second call (already initialized) to this method will return immediately. 
	 * 
     * @throws IllegalStateException If a Protected Region Id is detected the second time, i.e. it is not unique.
	 */
	public void init() throws IllegalStateException {
		// Already initialized?
        if (regionMap != null) {
			return;
        }

		// Initialize the Protected Region map
		regionMap = new HashMap<String, ProtectedRegionImpl>();
		usedSet = new HashSet<String>();

        if (srcPaths==null) {
			log.warn("No source paths configured for scanning.");
			// abort
			return;
		}

		long time = 0;
		long fileCount = 0;

		if (log.isInfoEnabled()) {
			log.info("Source scan started ...");
			time = System.currentTimeMillis();
		}

		// create the file filter
		final GenericFileFilter filter = new GenericFileFilter(ignoreList, defaultExcludes);

		// Scan all configured paths
		for (int i = 0; i < srcPaths.length; i += 1) {
			try {
            	// retrieve (recursive) all files from a path matching the configured filter 
				final File[] files = FSIO.getAllFiles(srcPaths[i], filter);

				fileCount += files.length;

				// scan all files
				for (int j = 0; j < files.length; j += 1) {
					// retrieve the Protected Regions from the current file
					final Iterator<ProtectedRegionImpl> regions = getAllRegions(files[j]).iterator();

					while (regions.hasNext()) {
						final ProtectedRegionImpl region = regions.next();

						final String id = region.getId();
						// check for non-uniqueness of a Protected Region Id
                        if (regionMap.containsKey(id)) {
                            throw new IllegalStateException ("Id '" + id + "' occuring in files " + region.getFile()
                                    + " and " + regionMap.get(id).getFile()
                                    + " is not unique");
                        }
						// Store this region
						regionMap.put(id, region);
					}
				}
            } catch (final IOException e) {
				throw new RuntimeException("Unexpected I/O exception", e);
            } catch (final ProtectedRegionSyntaxException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}

		if (log.isInfoEnabled()) {
			time = System.currentTimeMillis() - time;

			log.info("Source scan finished in " + (time / 1000.0) + "s");
			log.info("Files scanned: " + fileCount);
			log.info("Regions found: " + regionMap.size());
		}

	}

	/**
     * Dumps all known protected regions to files. For each protected region a file is created. 
     * @param dumpPath Directory where the dump files are created within.
	 */
	public void reportRegions(final File dumpPath) {
		final int unused = regionMap.size() - usedSet.size();

		if (unused > 0) {
			log.warn("There are " + unused + " unused Regions:");

			if (dumpPath != null) {
				dumpPath.mkdirs();
			}

			for (final Iterator<ProtectedRegionImpl> regions = regionMap.values().iterator(); regions.hasNext();) {
				final ProtectedRegionImpl region = regions.next();

				final String id = region.getId();

				if (!usedSet.contains(id)) {
					log.warn("File: " + region.getFile());
					log.warn("ID: " + id);

					try {
						if (dumpPath != null) {
							final File file = new File(dumpPath, BASE64.toString(id));

							Writer writer;

							if (encoding == null) {
								writer = new FileWriter(file);
                            } else {
								writer = new OutputStreamWriter(new FileOutputStream(file), encoding);
							}

							writer.write(region.getStartString("", ""));
							writer.write(region.getBody("", ""));
							writer.write(region.getEndString("", ""));

							writer.close();
						}
                    } catch (final IOException e) {
						throw new RuntimeException("Unexpected I/O exception", e);
                    } catch (final ProtectedRegionSyntaxException e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		}
	}

	/**
     * This flag determines whether default file exclusion patterns should be used.
     * @param defaultExcludes <code>true</code>: Use default file exclusion patterns, <code>false</code>: ignore them, just use
     * the patterns specified by {@link #setIgnoreList(String) ignoreList}
	 */
	public void setDefaultExcludes(final boolean defaultExcludes) {
		this.defaultExcludes = defaultExcludes;
	}

	/**
	 * Sets the file encoding to be used when reading files.
     * @param encoding A valid encoding string.
	 */
	public void setFileEncoding(final String encoding) {
		this.encoding = encoding;
	}

	/**
     * Sets a custom list of file patterns that should be filtered during scanning of source files 
     * and directories.
     * @param ignoreList A comma separated list of file patterns to ignore during scan.
	 */
	public void setIgnoreList(final String ignoreList) {
		this.ignoreList = ignoreList;
	}

	/**
	 * Sets the source paths that should be scanned.
	 * 
	 * @param srcPathsAsString
	 *            A comma separated list of directory paths.
	 * @throws IllegalArgumentException
	 *             If one of the passed arguments is not a directory or does not
	 *             exist
	 */
	public void setSrcPathes(final String srcPathsAsString) throws IllegalArgumentException {
		// Split the paths and initialize the
		// file array 'srcPaths' from it
		if ("".equals(srcPathsAsString)) {
			this.srcPaths = new File[0];
        } else {
			final String[] s = srcPathsAsString.split(",");
			final List<File> validPaths = new ArrayList<File>(s.length);
			for (int i = 0; i < s.length; i++) {
				File dir = new File(s[i].trim());
				// The configured path must point to an existing directory
				if (dir.isDirectory()) {
					validPaths.add(dir);
				}
				else {
					final String msg = "Ignoring non-existing protected region path " + dir.getAbsolutePath();
					LOG.warn(msg);
					throw new IllegalArgumentException(msg);
				}
			}
	        this.srcPaths = validPaths.toArray(new File[]{});
		}
	}

	public void setUseBASE64(final boolean useBASE64) {
		this.useBASE64 = useBASE64;
	}
}
