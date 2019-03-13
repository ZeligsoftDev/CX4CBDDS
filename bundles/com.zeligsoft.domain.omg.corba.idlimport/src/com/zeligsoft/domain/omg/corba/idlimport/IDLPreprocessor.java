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
package com.zeligsoft.domain.omg.corba.idlimport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.domain.omg.corba.idlimport.l10n.Messages;

/**
 * Pre-processor for the source IDL file
 * 
 * @author ysroh
 * 
 */
public class IDLPreprocessor extends AbstractWorkflowComponent {

	private final String GPP_WINDOWS_EXECUTABLE_URI = "platform:/plugin/com.zeligsoft.domain.omg.corba.idlimport/gpp/gpp.exe"; //$NON-NLS-1$

	private final String GPP_LINUX_EXECUTABLE_URI = "platform:/plugin/com.zeligsoft.domain.omg.corba.idlimport/gpp/gpp"; //$NON-NLS-1$

	private final String INCLUDE_MARKER_OPTION = " --includemarker \"#file \\\"%:%:%\\\"\" "; //$NON-NLS-1$

	private final String USER_NAME = System.getProperty("user.name"); //$NON-NLS-1$
	
	private final String TEMP_IDL_FILENAME = USER_NAME + "_tmp.idl"; //$NON-NLS-1$

	private final String PREPROCESSED_IDL_FILENAME = USER_NAME + "_tmp_processed.idl"; //$NON-NLS-1$

	private final String SOURCE_FILES_SLOT_NAME = "sourceFileList"; //$NON-NLS-1$

	private final String INCLUDE_LIST_SLOT_NAME = "includeList"; //$NON-NLS-1$

	private final String DEFINE_LIST_SLOT_NAME = "defineList"; //$NON-NLS-1$

	private final String EXCLUDE_LIST_SLOT_NAME = "excludeList"; //$NON-NLS-1$

	private final String LINE_SEPARATOR = System.getProperty("line.separator"); //$NON-NLS-1$
	
	private String outputSlot;

	private String outputDirPath;
	
	private boolean DEBUG = false;

	public void checkConfiguration(Issues issues) {

		if (getOutputSlot() == null) {
			issues.addError(Messages.IDLPreprocessor_OutputNotSpecified);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {

		if (issues.getErrors().length > 0) {
			return;
		}

		StringBuffer tempIdlContent = new StringBuffer();

		Set<String> includes = new HashSet<String>();
		for (String path : (List<String>) ctx.get(SOURCE_FILES_SLOT_NAME)) {
			File aFile = new File(path);
			String filename = aFile.getName();
			if (filename != null) {
				if (filename.endsWith(".idl")) { //$NON-NLS-1$
					includes.add(aFile.getParent());
					tempIdlContent.append("#include \"" + filename + "\"" //$NON-NLS-1$//$NON-NLS-2$
							+ LINE_SEPARATOR + LINE_SEPARATOR);
				}
			}
		}

		String includeArgs = composeIncludeString(includes);
		if (ctx.get(INCLUDE_LIST_SLOT_NAME) != null) {
			includeArgs = includeArgs.concat(composeIncludeString(new HashSet<String>(
					(List<String>) ctx.get(INCLUDE_LIST_SLOT_NAME))));
		}

		List<String> defines = new ArrayList<String>();
		if (ctx.get(DEFINE_LIST_SLOT_NAME) != null) {
			defines.addAll((List<String>) ctx.get(DEFINE_LIST_SLOT_NAME));
		}
		String defineArgs = composeDefineString(defines);
		
		List<String> excludes = new ArrayList<String>();
		if (ctx.get(EXCLUDE_LIST_SLOT_NAME) != null) {
			excludes.addAll((List<String>) ctx.get(EXCLUDE_LIST_SLOT_NAME));
		}
		String excludeArgs = composeExcludeString(excludes);

		if (tempIdlContent.toString() == UML2Util.EMPTY_STRING) {
			issues.addError(Messages.IDLPreprocessor_SourceNotSpecified);
			return;
		}

		outputDirPath = System.getProperty("java.io.tmpdir") + File.separator; //$NON-NLS-1$
		
		if(DEBUG) issues.addWarning("DEBUG: Temp Dir: " + outputDirPath); //$NON-NLS-1$

		String gppUri;
		if (isWindows()) {
			gppUri = GPP_WINDOWS_EXECUTABLE_URI;
		} else {
			gppUri = GPP_LINUX_EXECUTABLE_URI;
		}

		File tempIDL = new File(outputDirPath + TEMP_IDL_FILENAME);
		if (tempIDL.exists()) {
			if (!tempIDL.delete()) {
				issues.addError(Messages.IDLPreprocessor_DeleteErrorMessage
						+ outputDirPath + TEMP_IDL_FILENAME);
				return;

			}
		}
		try {
			Writer output = new BufferedWriter(new FileWriter(tempIDL));
			output.write(tempIdlContent.toString());
			output.close();

		} catch (IOException e) {
			issues.addError(Messages.IDLPreprocessor_AccessErrorMessage + outputDirPath);
			return;
		}

		String gppPath;
		try {
			gppPath = FileLocator.toFileURL(new URL(gppUri)).getPath();
		} catch (IOException e1) {
			issues.addError(Messages.IDLPreprocessor_GPPNotFound);
			return;
		}

		// gpp executable is copied to metadata directory during runtime, 
		// but it is not executable in Linux. So make it executable.
		File gpp = new File(gppPath);
		if (!gpp.canExecute()) {
			gpp.setExecutable(true);
		}
		
		String[] command = getCommand(includeArgs, defineArgs, excludeArgs, gppPath);

		// delete existing processed IDL file
		File processedIDL = new File(outputDirPath + PREPROCESSED_IDL_FILENAME);
		if (processedIDL.exists()) {
			if (!processedIDL.delete()) {
				issues.addError(Messages.IDLPreprocessor_DeleteErrorMessage
						+ outputDirPath + PREPROCESSED_IDL_FILENAME);
				return;
			}
		}

		
		StringBuffer errMsg = new StringBuffer();
		Runtime rt = Runtime.getRuntime();

		try {

			for (int i = 0; i < 2; i++) {
				if (DEBUG) {
					issues.addWarning("DEBUG:Temp.idl read permission: " //$NON-NLS-1$
							+ tempIDL.canRead());
					issues.addWarning("DEBUG:Temp.idl write permission: " //$NON-NLS-1$
							+ tempIDL.canWrite());

					issues.addWarning("DEBUG: Preprocessor attempt " + (i + 1)); //$NON-NLS-1$
					issues.addWarning("DEBUG: Starting preprocessor with command: " //$NON-NLS-1$
							+ command);
				}
				Process p;
				if(isWindows()){
					 p = rt.exec(command[0]);
				}else{
					 p = rt.exec(command);
				}
				errMsg = new StringBuffer();
				String errStr;
				BufferedReader stderrReader = new BufferedReader(new InputStreamReader(p
						.getErrorStream()));
				while ((errStr = stderrReader.readLine()) != null) {
					errMsg.append(errStr).append(LINE_SEPARATOR);
				}

				if (!errMsg.toString().contains("Cannot open input file")) { //$NON-NLS-1$
					// we should only repeat gpp if we get this error.
					break;
				}
				// write gpp error
				if(DEBUG) issues.addWarning("DEBUG: " + errMsg.toString()); //$NON-NLS-1$
				Thread.sleep(1000);

			}

		} catch (Exception e) {
			issues.addError(Messages.IDLPreprocessor_GPPRuntimeProblem);
			return;
		}

		if ((errMsg.length() > 0 && errMsg.toString().contains("error:")) //$NON-NLS-1$
				|| !processedIDL.exists()) {
			issues.addError(Messages.IDLPreprocessor_PreprocessorErrorMsg
					+ errMsg.toString());
			return;
		}

		// save new IDL path to the slot
		ctx.set(getOutputSlot(), URI.createFileURI(outputDirPath).toString()
				+ PREPROCESSED_IDL_FILENAME);

	}

	/**
	 * Compose gpp command
	 * 
	 * @param includeArgs
	 * @param defineArgs
	 * @param gppPath
	 * @return
	 */
	private String[] getCommand(String includeArgs, String defineArgs, String excludeArgs, String gppPath) {
		// compose command string to execute gpp
		String[] command = new String[3];

		if (isWindows()) {

			if ("/".compareTo(UML2Util.EMPTY_STRING + gppPath.charAt(0)) == 0) { //$NON-NLS-1$
				gppPath = gppPath.replaceFirst("/", //$NON-NLS-1$
						UML2Util.EMPTY_STRING);
			}
			command[0] = "\"" + gppPath + "\" " + includeArgs + defineArgs + excludeArgs//$NON-NLS-1$ //$NON-NLS-2$
					+ INCLUDE_MARKER_OPTION + "\"" + outputDirPath + TEMP_IDL_FILENAME + "\"" + " -Z -o " + outputDirPath //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ PREPROCESSED_IDL_FILENAME;

		} else {
			command[0] = System.getenv("SHELL"); //$NON-NLS-1$
			command[1] = "-c"; //$NON-NLS-1$
			command[2] = gppPath + includeArgs + defineArgs + excludeArgs
					+ INCLUDE_MARKER_OPTION + outputDirPath + TEMP_IDL_FILENAME
					+ " -Z -o " + outputDirPath + PREPROCESSED_IDL_FILENAME; //$NON-NLS-1$
		}
		return command;
	}

	/**
	 * Compose define option string
	 * 
	 * @param defines
	 * @return
	 */
	private String composeDefineString(List<String> defines) {
		StringBuffer defineArgs = new StringBuffer();
		for (String define : defines) {
			if (define.compareTo(UML2Util.EMPTY_STRING) == 0)
				continue;
			defineArgs.append(" -D" + define + " "); //$NON-NLS-1$//$NON-NLS-2$
		}
		return defineArgs.toString();
	}
	
	private String composeExcludeString(List<String> excludes) {
		StringBuffer excludeArgs = new StringBuffer();
		for (String exclude : excludes) {
			if (exclude.compareTo(UML2Util.EMPTY_STRING) == 0)
				continue;
			excludeArgs.append(" -e " + exclude + " "); //$NON-NLS-1$//$NON-NLS-2$
		}
		return excludeArgs.toString();
	}

	/**
	 * Compose include option string
	 * 
	 * @param includes
	 * @return
	 */
	private String composeIncludeString(Set<String> includes) {
		StringBuffer includesArgs = new StringBuffer();
		for (String include : includes) {
			File dir = new File(include);

			if (!dir.isDirectory() || !dir.exists()) {
				// Filter out invalid include directories
				continue;
			}
			if (include.compareTo(UML2Util.EMPTY_STRING) == 0)
				continue;
			if (isWindows()) {
				includesArgs.append(" -I\"" + dir.getAbsolutePath() + "\" "); //$NON-NLS-1$//$NON-NLS-2$
			} else {
				includesArgs.append(" -I" + dir.getAbsolutePath() + " "); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return includesArgs.toString();
	}

	/**
	 * Set method for outputSlot
	 * 
	 * @param outputSlot
	 */
	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}

	/**
	 * Get method for outputSlot
	 * 
	 * @return
	 */
	public String getOutputSlot() {
		return outputSlot;
	}

	/**
	 * Query if the platform is Windows
	 * 
	 * @return
	 */
	private Boolean isWindows() {
		return System.getProperty("os.name").compareTo("Windows") > 0; //$NON-NLS-1$//$NON-NLS-2$
	}

}
