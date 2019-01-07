/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.licensing.internal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Miscellaneous file manipulation utilities.
 * 
 * @author Christian W. Damus (cdamus)
 */
class FileUtil {

	//For Flex Licenses
	
	private static final String LICENSE_FEATURE = "FEATURE"; //$NON-NLS-1$

	private static final String LICENSE_INCREMENT = "INCREMENT"; //$NON-NLS-1$

	private static final String LICENSE_CONTINATION = "\\"; //$NON-NLS-1$
	
	//For RLM licenses
	
	private static final String RLM_SERVER = "HOST"; //$NON-NLS-1$
	
	private static final String RLM_ISV = "ISV"; //$NON-NLS-1$
	
	private static final String RLM_LICENSE = "LICENSE"; //$NON-NLS-1$
		

	/**
	 * Not instatiable by clients.
	 */
	private FileUtil() {
		super();
	}

	/**
	 * Creates the parent directory of the specified file (which may be a
	 * directory), if necessary.
	 * 
	 * @param file
	 *            the file or directory whose parent directory is required
	 */
	static void ensureDirectoryExists(File file) {
		File dir = file.getParentFile();

		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	/**
	 * Creates the specified target license file by copying the source.
	 * 
	 * @param target
	 *            the license file to create
	 * @param source
	 *            the file to copy
	 * @throws IOException
	 *             on any problem in copying the file
	 */
	static void create(File target, File source)
			throws IOException {

		ensureDirectoryExists(target);
		transferAll(new FileOutputStream(target), new FileInputStream(source));
	}

	/**
	 * Appends the contents of the specified source license file to the target.
	 * 
	 * @param target
	 *            the existing license file to append
	 * @param source
	 *            the file to copy
	 * @throws IOException
	 *             on any problem in appending the file
	 */
	static void append(File target, File source)
			throws IOException {

		transferAll(new FileOutputStream(target, true), new FileInputStream(
			source));
	}

	/**
	 * Transfers text, line by line, from the source to the target. Only
	 * <tt>FEATURE</tt> and <tt>INCREMENT</tt> lines are copied, any any
	 * subsequent that terminate in a continuation character.
	 * 
	 * @param target
	 *            the destination of the copied text
	 * @param source
	 *            the source of the copied text
	 * @throws IOException
	 *             on any problem in copying the text
	 */
	private static void transferAll(FileOutputStream target,
			FileInputStream source)
			throws IOException {
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		boolean isContinued = false;

		try {
			reader = new BufferedReader(new InputStreamReader(source));
			writer = new BufferedWriter(new OutputStreamWriter(target));

			for (String line = reader.readLine(); line != null; line = reader
				.readLine()) {

				String upperCase = line.trim().toUpperCase();
				
				if (upperCase.startsWith(LICENSE_FEATURE)
					|| upperCase.startsWith(LICENSE_INCREMENT)
					|| isContinued) {

					writer.write(line);
					writer.newLine();
				}
				
				isContinued = line.endsWith(LICENSE_CONTINATION);
			}
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// no help for it. Just don't mask a nesting exception
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// no help for it. Just don't mask a nesting exception
				}
			}
		}
	}
	
	public static void appendRlmLicense(String product, File target, File source)
														throws IOException{
		ensureDirectoryExists(target);
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		String targetServerSettings = getRlmInfo(target, "^"+RLM_SERVER+".*");   //$NON-NLS-1$ //$NON-NLS-2$
		String sourceServerSettings = getRlmInfo(source, "^"+RLM_SERVER+".*");  //$NON-NLS-1$ //$NON-NLS-2$
		
		String targetIsvSettings = getRlmInfo(target, "^"+RLM_ISV+".*");  //$NON-NLS-1$ //$NON-NLS-2$
		String sourceIsvSettings = getRlmInfo(source, "^"+RLM_ISV+".*");  //$NON-NLS-1$ //$NON-NLS-2$
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target,true)));

			//we need to propagate isv and server settings if there are any
			if (targetServerSettings == null && sourceServerSettings != null) {
				writer.newLine();
				writer.write(sourceServerSettings);
				writer.newLine();
			}
			if (targetIsvSettings == null && sourceIsvSettings != null) {
				writer.newLine();
				writer.write(sourceIsvSettings);
				writer.newLine();
			}
			
			String line = reader.readLine();
			do {
				if (line.toUpperCase().contains(product.toUpperCase())){
					//ensure that there is at least one newline between this license
					//and whatever was there before
					writer.newLine();
					writer.write(line);
					writer.newLine();
					line = reader.readLine();
					//read until the end of the multi-line license
					while (line != null && !line.toUpperCase().contains(RLM_LICENSE)){
						writer.write(line);
						writer.newLine();
						line = reader.readLine();
					}
					break;
				}
				line = reader.readLine();
			}while (line != null);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// no help for it. Just don't mask a nesting exception
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// no help for it. Just don't mask a nesting exception
				}
			}
		}
	}
	
	
	public static void appendRlmLicense(File target, String license)
													throws IOException{
		ensureDirectoryExists(target);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target,true)));

			writer.newLine();
			writer.write(license);
			writer.newLine();

		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// no help for it. Just don't mask a nesting exception
				}
			}
		}	
	}
	
	
	private static String getRlmInfo(File file, String infoRegex) throws IOException{
		
		if (!file.exists()) { return null; }
		
		String isvInfo = null;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line = reader.readLine();
			
			do {
				if (line != null && line.matches(infoRegex)) {
					return line;
				}
				line = reader.readLine();
			} while (line != null);
			
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// log and eat the exception, nothing more to be done
				}
			}
		}
		return isvInfo;
	}
	
}
