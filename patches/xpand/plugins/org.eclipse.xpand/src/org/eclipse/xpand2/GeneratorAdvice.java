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

package org.eclipse.xpand2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.ao.AbstractWorkflowAdvice;
import org.eclipse.emf.mwe.core.issues.Issues;

/**
 * Weaves aspect templates into a generator component.
 * <p>
 * <h2>Parameters</h2>
 * <table border="1">
 * <tr><th>Name</th><th>Multiplicity</th><th>Type</th><th>Description</th></tr>
 * 
 * <tr>
 * <td>adviceTarget</td>
 * <td>1</td>
 * <td>String</td>
 * <td>The id of a {@link Generator} component</td>
 * </tr>
 * 
 * <tr>
 * <td>advices</td>
 * <td>0..n</td>
 * <td>String</td>
 * <td>Comma separated list of qualified aspect templates</td>
 * </tr>
 * 
 * <tr>
 * <td>advice</td>
 * <td>0..n</td>
 * <td>String</td>
 * <td>Qualified name of an aspect template</td>
 * </tr>
 * 
 * 
 * <tr>
 * <td>extensionAdvice</td>
 * <td>0..n</td>
 * <td>String</td>
 * <td>Comma separated list of qualified aspect extensions</td>
 * </tr>
 * </table>
 */
public class GeneratorAdvice extends AbstractWorkflowAdvice {

	private List<String> advices = new ArrayList<String>();

    private List<String> extensionAdvices = new ArrayList<String>();
    
    private String fileEncoding;

    public void addAdvices(String advices) {
		this.advices.add( advices );
	}

    public void addExtensionAdvices(String extensionAdvices) {
		this.extensionAdvices.add( extensionAdvices );
	}
	
    public void addAdvice(String advices) {
		this.advices.add( advices );
	}

    public void addExtensionAdvice(String extensionAdvices) {
		this.extensionAdvices.add( extensionAdvices );
	}

    /**
     * Sets the file encoding to use for the target generator.
     * @param fileEncoding Encoding string, e.g. 'ISO-8859-1'
     * @since 4.2
     * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=195042">Bug 195042</a>
     */
	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}


	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (advices.isEmpty() && extensionAdvices.isEmpty()) {
			issues.addError("Neither 'advices' nor 'extensionAdvices' configured.");
		}
	}

	@Override
	public void weave(WorkflowComponent c, Issues issues ) {
		if ( !(c instanceof Generator) ) {
			issues.addError(this, "advice target is not a Generator component.");
		} else {
			Generator gen = (Generator)c;
			for (String advice : advices) {
				gen.addAdvice(advice);
			}
			for (String advice : extensionAdvices) {
				gen.addExtensionAdvice(advice);
			}
			if (fileEncoding!=null) {
				gen.setFileEncoding(fileEncoding);
			}
		}
	}

	@Override
	public String getLogMessage() {
		return "extension-advices: "+buildList( extensionAdvices )+"   template-advices: "+buildList(advices);
	}

	
}
