package org.eclipse.internal.xtend.util.internal.icu;

/**
 This code was taken from the com.ibm.icu library (3.6.1). We needed to copy it to have not
 a dependency to this large library only the need of charset recognition.
 (KTH 2007-07-30)

 The com.ibm.icu library is published under Eclipse Public License V1.0.
 */

/**
 *******************************************************************************
 * Copyright (C) 2005-2006, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This class represents a charset that has been identified by a CharsetDetector as a possible encoding for a set of input data. From an instance of
 * this class, you can ask for a confidence level in the charset identification, or for Java Reader or String to access the original byte data in
 * Unicode form.
 * <p/>
 * Instances of this class are created only by CharsetDetectors.
 * <p/>
 * Note: this class has a natural ordering that is inconsistent with equals. The natural ordering is based on the match confidence value.
 * 
 * @draft ICU 3.4
 * @provisional This API might change or be removed in a future release.
 */
@SuppressWarnings("rawtypes")
public class CharsetMatch implements Comparable {

	/**
	 * Create a java.io.Reader for reading the Unicode character data corresponding to the original byte data supplied to the Charset detect
	 * operation.
	 * <p/>
	 * CAUTION: if the source of the byte data was an InputStream, a Reader can be created for only one matching char set using this method. If more
	 * than one charset needs to be tried, the caller will need to reset the InputStream and create InputStreamReaders itself, based on the charset
	 * name.
	 * 
	 * @return the Reader for the Unicode character data.
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public Reader getReader() {
		InputStream inputStream = fInputStream;

		if (inputStream == null) {
			inputStream = new ByteArrayInputStream(fRawInput, 0, fRawLength);
		}

		try {
			inputStream.reset();
			return new InputStreamReader(inputStream, getName());
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Create a Java String from Unicode character data corresponding to the original byte data supplied to the Charset detect operation.
	 * 
	 * @return a String created from the converted input data.
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public String getString() throws java.io.IOException {
		return getString(-1);

	}

	/**
	 * Create a Java String from Unicode character data corresponding to the original byte data supplied to the Charset detect operation. The length
	 * of the returned string is limited to the specified size; the string will be trunctated to this length if necessary. A limit value of zero or
	 * less is ignored, and treated as no limit.
	 * 
	 * @param maxLength
	 *            The maximium length of the String to be created when the source of the data is an input stream, or -1 for unlimited length.
	 * @return a String created from the converted input data.
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public String getString(final int maxLength) throws java.io.IOException {
		String result = null;
		if (fInputStream != null) {
			StringBuffer sb = new StringBuffer();
			char[] buffer = new char[1024];
			Reader reader = getReader();
			int max = maxLength < 0 ? Integer.MAX_VALUE : maxLength;
			int bytesRead = 0;

			while ((bytesRead = reader.read(buffer, 0, Math.min(max, 1024))) >= 0) {
				sb.append(buffer, 0, bytesRead);
				max -= bytesRead;
			}

			reader.close();

			return sb.toString();
		}
		result = new String(fRawInput, getName());
		return result;

	}

	/**
	 * Get an indication of the confidence in the charset detected. Confidence values range from 0-100, with larger numbers indicating a better match
	 * of the input data to the characteristics of the charset.
	 * 
	 * @return the confidence in the charset match
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public int getConfidence() {
		return fConfidence;
	}

	/**
	 * Bit flag indicating the match is based on the the encoding scheme.
	 * 
	 * @see #getMatchType
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	static public final int ENCODING_SCHEME = 1;

	/**
	 * Bit flag indicating the match is based on the presence of a BOM.
	 * 
	 * @see #getMatchType
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	static public final int BOM = 2;

	/**
	 * Bit flag indicating he match is based on the declared encoding.
	 * 
	 * @see #getMatchType
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	static public final int DECLARED_ENCODING = 4;

	/**
	 * Bit flag indicating the match is based on language statistics.
	 * 
	 * @see #getMatchType
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	static public final int LANG_STATISTICS = 8;

	/**
	 * Return flags indicating what it was about the input data that caused this charset to be considered as a possible match. The result is a
	 * bitfield containing zero or more of the flags ENCODING_SCHEME, BOM, DECLARED_ENCODING, and LANG_STATISTICS. A result of zero means no
	 * information is available.
	 * <p>
	 * Note: currently, this method always returns zero.
	 * <p>
	 * 
	 * @return the type of match found for this charset.
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public int getMatchType() {
		// TODO: create a list of enum-like constants for common combinations of types of matches.
		return 0;
	}

	/**
	 * Get the name of the detected charset. The name will be one that can be used with other APIs on the platform that accept charset names. It is
	 * the "Canonical name" as defined by the class java.nio.charset.Charset; for charsets that are registered with the IANA charset registry, this is
	 * the MIME-preferred registerd name.
	 * 
	 * @see java.nio.charset.Charset
	 * @see java.io.InputStreamReader
	 * 
	 * @return The name of the charset.
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public String getName() {
		return fRecognizer.getName();
	}

	/**
	 * Get the ISO code for the language of the detected charset.
	 * 
	 * @return The ISO code for the language or <code>null</code> if the language cannot be determined.
	 * 
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public String getLanguage() {
		return fRecognizer.getLanguage();
	}

	/**
	 * Compare to other CharsetMatch objects. Comparison is based on the match confidence value, which allows CharsetDetector.detectAll() to order its
	 * results.
	 * 
	 * @param o
	 *            the CharsetMatch object to compare against.
	 * @return a negative integer, zero, or a positive integer as the confidence level of this CharsetMatch is less than, equal to, or greater than
	 *         that of the argument.
	 * @throws ClassCastException
	 *             if the argument is not a CharsetMatch.
	 * @draft ICU 3.4
	 * @provisional This API might change or be removed in a future release.
	 */
	public int compareTo(final Object o) {
		CharsetMatch other = (CharsetMatch) o;
		int compareResult = 0;
		if (fConfidence > other.fConfidence) {
			compareResult = 1;
		} else if (fConfidence < other.fConfidence) {
			compareResult = -1;
		}
		return compareResult;
	}

	/**
	 * Constructor. Implementation internal
	 * 
	 * @internal
	 */
	CharsetMatch(final CharsetDetector det, final CharsetRecognizer rec, final int conf) {
		fRecognizer = rec;
		fConfidence = conf;

		// The references to the original aplication input data must be copied out
		// of the charset recognizer to here, in case the application resets the
		// recognizer before using this CharsetMatch.
		if (det.fInputStream == null) {
			// We only want the existing input byte data if it came straight from the user,
			// not if is just the head of a stream.
			fRawInput = det.fRawInput;
			fRawLength = det.fRawLength;
		}
		fInputStream = det.fInputStream;
	}

	//
	// Private Data
	//
	private final int fConfidence;
	private final CharsetRecognizer fRecognizer;
	private byte[] fRawInput = null; // Original, untouched input bytes.
										// If user gave us a byte array, this is it.
	private int fRawLength; // Length of data in fRawInput array.

	private InputStream fInputStream = null; // User's input stream, or null if the user
												// gave us a byte array.
}
