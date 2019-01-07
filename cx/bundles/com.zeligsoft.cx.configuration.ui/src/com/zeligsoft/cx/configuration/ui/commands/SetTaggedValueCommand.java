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

package com.zeligsoft.cx.configuration.ui.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Command to set a taggedValue for multiple <code>Element</code>s that have 
 * the same stereotype application.
 * 
 * @author jcorchis
 * 
 */
public class SetTaggedValueCommand
		extends AbstractTransactionalCommand {

	/**
	 * The element to which the stereotype is applied
	 */
	private List<? extends Element> elements = null;

	/**
	 * The concept
	 */
	private String concept = null;

	/**
	 * The name of the stereotype property
	 */
	private String taggedValueName = null;

	/**
	 * The new stereotype property to set
	 */
	private Object taggedValue = null;

	/**
	 * Constucts a new instance of SetTaggedValueCommand.
	 * 
	 * @param domain
	 *            the EditingDomain
	 * @param label
	 *            the Command label
	 * @param affectedFiles
	 *            the list of affected {@link IFile}s; may be <code>null</code>
	 * @param elements
	 *            The element to which the stereotype is applied
	 * @param stereotype
	 *            The stereotype
	 * @param taggedValueName
	 *            The name of the stereotype property
	 * @param taggedValue
	 *            The new stereotype property to set
	 */
	@SuppressWarnings("unchecked")
	public SetTaggedValueCommand(TransactionalEditingDomain domain, String label,
			List affectedFiles, List<? extends Element> elements, String concept,
			String taggedValueName, Object taggedValue) {
		super(domain, label, affectedFiles);
		
		this.elements = new ArrayList(elements);
		this.concept = concept;
		this.taggedValueName = taggedValueName;
		this.taggedValue = taggedValue;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info)
			throws ExecutionException {
		for (Iterator<? extends Element> i = elements.iterator(); i.hasNext();)
		{
			ZDLUtil.setValue(i.next(), getConcept(), getTaggedValueName(), getTaggedValue());
		}
		return CommandResult.newOKCommandResult(getTaggedValue());
	}

	/**
	 * Returns the <code>List</code> of UML Elements.
	 * @return the list of Elements.
	 */
	protected List<? extends Element> getElements() {
		return elements;
	}

	/**
	 * Returns the Stereotype
	 * @return
	 */
	protected String getConcept() {
		return concept;
	}

	/**
	 * Returns the Stereotype's property name.
	 * @return
	 */
	protected String getTaggedValueName() {
		return taggedValueName;
	}

	/**
	 * Returns the value to set on the TaggedValueName.
	 * @return
	 */
	protected Object getTaggedValue() {
		return taggedValue;
	}

}
