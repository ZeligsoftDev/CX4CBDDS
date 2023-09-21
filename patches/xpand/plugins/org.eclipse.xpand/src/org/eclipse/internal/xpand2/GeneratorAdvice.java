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
package org.eclipse.internal.xpand2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.Generator;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowAdvice;

/**
 * Weaves aspect templates into a generator component.
 * <p>
 * <h2>Parameters</h2>
 * <table border="1">
 * <tr>
 * <th>Name</th>
 * <th>Multiplicity</th>
 * <th>Type</th>
 * <th>Description</th>
 * </tr>
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
 * <td>Comma seperated list of qualified aspect templates</td>
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
 * <td>Comma seperated list of qualified aspect extensions</td>
 * </tr>
 * 
 * <tr>
 * <td>metaModel</td>
 * <td>0..n</td>
 * <td>org.eclipse.extend.typesystem.MetaModel</td>
 * <td>Additional metamodels needed for the advices.</td>
 * </tr>
 * 
 * <tr>
 * <td>globalVarDef</td>
 * <td>0..n</td>
 * <td>GlobalVarDef</td>
 * <td>Additional global vars needed for the advices.</td>
 * </tr>
 * </table>
 */
public class GeneratorAdvice extends AbstractExpressionsUsingWorkflowAdvice {
	/** Component name. */
	private static final String COMPONENT_NAME = "Xpand Generator Advice";

	/** Xpand template advices. */
	private final List<String> advices = new ArrayList<String>();

	/** Xtend extension advices. */
	private final List<String> extensionAdvices = new ArrayList<String>();

	/** File encoding for reading templates. */
	private String fileEncoding;

	/**
	 * Adds an advice.
	 * 
	 * @param advice
	 *            the advice
	 */
	public void addAdvice(final String advice) {
		this.advices.add(advice);
	}

	/**
	 * Adds an extension advice,
	 * 
	 * @param extensionAdvice
	 *            the extension advice
	 */
	public void addExtensionAdvice(final String extensionAdvice) {
		this.extensionAdvices.add(extensionAdvice);
	}

	/**
	 * Sets the file encoding to use for the target generator.
	 * 
	 * @param fileEncoding
	 *            Encoding string, e.g. 'ISO-8859-1'
	 */
	public void setFileEncoding(final String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.ao.AbstractWorkflowAdvice#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void checkConfiguration(final Issues issues) {
		super.checkConfiguration(issues);
		if (advices.isEmpty() && extensionAdvices.isEmpty()) {
			issues.addError("Neither 'advices' nor 'extensionAdvices' configured.");
		}
	}

	/**
	 * @see org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowAdvice#weave(org.eclipse.emf.mwe.core.WorkflowComponent,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void weave(final WorkflowComponent c, final Issues issues) {
		super.weave(c, issues);
		if (!(c instanceof Generator)) {
			issues.addError(this, "advice target is not a Generator component.");
		}
		else {
			final Generator gen = (Generator) c;
			for (final String advice : advices) {
				gen.addAdvice(advice);
			}
			for (final String advice : extensionAdvices) {
				gen.addExtensionAdvice(advice);
			}
			if (fileEncoding != null) {
				gen.setFileEncoding(fileEncoding);
			}
		}
	}

	@Override
	public String getLogMessage() {
		return "extension-advices: " + buildList(extensionAdvices) + "   template-advices: " + buildList(advices);
	}

	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
