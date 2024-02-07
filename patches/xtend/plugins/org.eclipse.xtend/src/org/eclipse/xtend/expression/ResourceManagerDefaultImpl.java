/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.expression;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.util.internal.icu.CharsetDetector;
import org.eclipse.internal.xtend.util.internal.icu.CharsetMatch;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.XtendResourceParser;
import org.eclipse.xtend.check.CheckUtils;

public class ResourceManagerDefaultImpl implements ResourceManager {

	private final Logger log = LogManager.getLogger(getClass());

	private String fileEncoding = null;

	private final Map<String, Resource> resources = new HashMap<String, Resource>();

	public ResourceManagerDefaultImpl() {
		XtendResourceParser xtendResourceParser = new XtendResourceParser();
		registeredParsers.put(XtendFile.FILE_EXTENSION, xtendResourceParser);
		registeredParsers.put(CheckUtils.FILE_EXTENSION, xtendResourceParser);
	}

	public Resource loadResource(final String fullyQualifiedName, final String extension) {
		final String resourceName = fullyQualifiedName.replace(SyntaxConstants.NS_DELIM, "/") + "." + extension;
		if (resources.containsKey(resourceName)) {
			return resources.get(resourceName);
		}
		final InputStream in = ResourceLoaderFactory.createResourceLoader().getResourceAsStream(resourceName);

		if (in == null) {
			return null;
		}
		Reader reader = createReader(in);
		final ResourceParser parser = registeredParsers.get(extension);
		if (parser == null) {
			throw new RuntimeException("No Parser registered for extension '" + extension + "'! Known extensions are '" + registeredParsers.keySet()
					+ "'");
		}
		final Resource res = parser.parse(reader, resourceName);
		res.setFullyQualifiedName(fullyQualifiedName);
		resources.put(resourceName, res);
		return res;
	}

	/**
	 * Creates a Reader for the given InputStream. If no explicit file encoding is set this method will try to autodetect the file's encoding.
	 * 
	 * @param in
	 *            Some resource input stream
	 * @return A Reader for the stream
	 * @since 4.2
	 */
	protected Reader createReader(final InputStream in) {
		Reader reader = null;
		if (fileEncoding != null) {
			try {
				reader = new InputStreamReader(in, fileEncoding);
			} catch (final UnsupportedEncodingException e) {
				log.error("Unsupported encoding falling back to default...", e);
				reader = new InputStreamReader(in);
			}
		} else {
			Charset encoding = null;
			// Buffer the original stream since we want to re-read it
			BufferedInputStream is = new BufferedInputStream(in);

			try {
				// Read some bytes from the stream
				is.mark(65);
				byte[] buf = new byte[64];
				is.read(buf);
				// reset the stream
				is.reset();

				// Special handling for Xpand files on Mac: Try to detect
				// the opening Guillemot bracket for MacRoman encoding
				for (byte element : buf) {
					if (element == -57) { // opening Guillemot bracket
						encoding = Charset.forName("MacRoman");
						break;
					}
				}
				// Use com.ibm.icu for autodetection
				if (encoding == null) {
					CharsetDetector det = new CharsetDetector();
					det.setText(buf);
					CharsetMatch match = det.detect();
					if (match != null) {
						encoding = Charset.forName(match.getName());
					}
				}

				// Create the reader with the detected encoding
				if (encoding != null) {
					reader = new InputStreamReader(is, encoding);
				} else {
					log.warn("Failed autodetecting encoding. Falling back to default...");
					reader = new InputStreamReader(is);
				}
			} catch (IOException e) {
				log.warn("Failed autodetecting encoding. Falling back to default...", e);
				reader = new InputStreamReader(in);
			}
		}
		return reader;
	}

	public void setFileEncoding(final String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}

	protected Map<String, ResourceParser> registeredParsers = new HashMap<String, ResourceParser>();

	public void registerParser(final String extension, final ResourceParser parser) {
		registeredParsers.put(extension, parser);
	}

}
