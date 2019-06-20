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
package com.zeligsoft.cx.deployment.test;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Command that uses a write transaction to rename a component (or part).
 * This is needed to modify the RSM model in a legal way.
 * 
 * @author smcfee
 *
 */
public class RenameModelElementRecordingCommand extends RecordingCommand {

	private NamedElement prop;
	
	private String newValue;

	public RenameModelElementRecordingCommand(TransactionalEditingDomain editingDomain,
			NamedElement prop, String newValue) {
		super(editingDomain, "Rename Model Element"); //$NON-NLS-1$
		this.prop = prop;
		this.newValue = newValue;
	}

	@Override
	protected void doExecute() {

		prop.setName(newValue);		
	}
}
