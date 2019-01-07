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
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.WorkflowComponentWithID;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.domain.omg.corba.idlimport.l10n.Messages;

/**
 * IDL parser workflow component
 * 
 * @author ysroh
 * 
 */
public class IDLParserComponent 
	extends AbstractWorkflowComponent2 
	implements WorkflowComponent, WorkflowComponentWithID {

	private String processedIDLFileSlot = null;
	private String outputSlot = null;
	
	private final String resourceSetSlot = "rset"; //$NON-NLS-1$
	
	/**
	 * Delegated invoke. Parse a .idl file using the generated Xtext Idl parser.
	 * Put the result of parsing the file in the outputSlot, specified.
	 */
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {

		if (ctx.get(processedIDLFileSlot) == null) {
			return;
		}

		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(getModelFile(ctx));
		ResourceSet rs = (ResourceSet)ctx.get(resourceSetSlot);
		Resource res = rs.getResource(uri, true);
		EObject result = null;

		if (res == null) {
			issues.addError(uri.toFileString() + "= null."); //$NON-NLS-1$
		} else if (!res.getErrors().isEmpty()) {
			issues.addError(Messages.IDLParserComponent_SyntaxError);

			@SuppressWarnings("unchecked")
			List<String> sourceFileList = (List<String>) ctx
					.get("sourceFileList"); //$NON-NLS-1$
			Set<String> filenames = new HashSet<String>();
			for (Diagnostic error : res.getErrors()) {
				String filename = getSourceFilename(uri, error);
				if (!UML2Util.isEmpty(filename)
						&& !filenames.contains(filename)) {
					filenames.add(filename);
					for (String sourceFile : sourceFileList) {
						if (sourceFile.endsWith(filename)) {
							// Load the original IDL file to get parse error
							Resource errorRes = rs.getResource(
									URI.createFileURI(sourceFile), true);
							if (res != null) {
								for (Diagnostic sourceError : errorRes
										.getErrors()) {
									issues.addError(sourceFile
											+ ":" //$NON-NLS-1$
											+ sourceError.getLine()
											+ ": " //$NON-NLS-1$
											+ sourceError.getMessage());
								}
								errorRes.unload();
								rs.getResources().remove(errorRes);
							}
						}
					}
				} else if (UML2Util.isEmpty(filename)) {
					issues.addError(error.getMessage());
				}
			}
		}

		if(null != res && !res.getContents().isEmpty()) {
			result = res.getContents().get(0);
			ctx.set(getOutputSlot(), result);
			res.unload();
			rs.getResources().remove(res);
		} 
	}

	/**
	 * Get source IDL filename
	 * 
	 * @param resource
	 * @param error
	 * @return
	 */
	private String getSourceFilename(org.eclipse.emf.common.util.URI resource,
			Diagnostic error) {
		String filename = UML2Util.EMPTY_STRING;
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(resource.devicePath());
		} catch (FileNotFoundException e) {
			return filename;
		}

		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int lineNum = 0;
		String line;
		Pattern pat = Pattern.compile("#file \"[0-9]+:(.*\\.idl):.*"); //$NON-NLS-1$
		try {
			while ((line = br.readLine()) != null && lineNum < error.getLine()) {
				lineNum++;
				Matcher mat = pat.matcher(line);
				if (mat.find()) {
					filename = mat.group(1);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		return filename;
	}
	
	
	private String getModelFile(WorkflowContext ctx) {
		Object val = ctx.get(processedIDLFileSlot);
		
		if(val instanceof String) {
			return (String) val;
		} else {
			throw new IllegalArgumentException(Messages.IDLParserComponent_InvalidProcessedIDLFileSlot);
		}
	}



	@Override
	public void checkConfigurationInternal(Issues issues) {
		if (processedIDLFileSlot == null) {
			issues.addError(Messages.IDLParserComponent_MissingOutputIDLSlotNameError);
		}
	}

	/**
	 * Setter for processedIDLFileSlot
	 * 
	 * @param modelFileSlot
	 */
	public void setProcessedIDLFileSlot(String modelFileSlot) {
		this.processedIDLFileSlot = modelFileSlot;
	}

	/**
	 * Setter for processedIDLFileSlot
	 * 
	 * @return
	 */
	public String getProcessedIDLFileSlot() {
		return processedIDLFileSlot;
	}



	public String getOutputSlot() {
		return outputSlot;
	}



	public void setOutputSlot(String ouptutSlot) {
		this.outputSlot = ouptutSlot;
	}
}
