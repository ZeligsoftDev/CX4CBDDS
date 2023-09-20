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
package org.eclipse.internal.xtend.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.eclipse.internal.xtend.util.internal.icu.CharsetDetector;
import org.eclipse.internal.xtend.util.internal.icu.CharsetMatch;

/**
 * This class helps detecting the encoding of some resource by scanning the first bytes from it. 
 * @author Karsten Thoms
 * @since 4.2
 */
public class EncodingDetector {
	public static Charset detectEncoding (BufferedInputStream in) throws IOException {
		// Read some bytes from the stream
		in.mark(65);
		byte[] buf = new byte[64];
		in.read(buf);
		// reset the stream
		in.reset();
		return detectEncoding(buf);
	}

	public static Charset detectEncoding (byte[] sample) {
		Charset encoding = null;
		// Special handling for Xpand files on Mac: Try to detect
		// the opening Guillemot bracket for MacRoman encoding
		for (int i=0; i<sample.length; i++) {
			if (sample[i]==-57) { // opening Guillemot bracket
				encoding = Charset.forName("MacRoman");
				break;
			} 
		}
		// Use com.ibm.icu for autodetection
		if (encoding==null) {
			CharsetDetector det = new CharsetDetector();
			det.setText(sample);
			CharsetMatch match = det.detect();
			if (match!=null) {
				encoding = Charset.forName(match.getName());
			} else {
				// fallback: Use System encoding
				encoding = Charset.forName(System.getProperty("file.encoding"));
			}
		}
		return encoding;
	}
	
}
