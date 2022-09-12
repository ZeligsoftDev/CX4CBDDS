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
package com.zeligsoft.domain.omg.corba.ui.edithelpers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.util.CORBAUtil;

/**
 * Add return type to newly created CX operation and apply correct stereotype to
 * the return parameter
 * 
 * @author ysroh
 * 
 */
public class PackageEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateCommand(final CreateElementRequest request) {
		final EObject container = request.getContainer();

		return new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(container), "CORBAPackageAdvice", //$NON-NLS-1$
				null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				EObject newObject = request.getNewElement();
				if (newObject == null) {
					return CommandResult.newOKCommandResult(newObject);
				}

				if (ZDLUtil.isZDLConcept(newObject, CXDomainNames.CXARRAY)
						|| ZDLUtil.isZDLConcept(newObject, CXDomainNames.CXSEQUENCE)) {
					DataType array = (DataType) newObject;
					if (array.getOwnedAttribute(CORBAUtil.MEMBERS_ATTRIBUE_NAME, null) == null) {
						Property attr = array.createOwnedAttribute(CORBAUtil.MEMBERS_ATTRIBUE_NAME, null);
						attr.setUpper(-1);
						attr.setLower(0);
					}
				} else if (ZDLUtil.isZDLConcept(newObject, CXDomainNames.CXUNION)) {
					DataType union = (DataType) newObject;
					if (union.getOwnedAttribute(CORBAUtil.SWITCH_ATTRIBUTE_NAME, null) == null) {
						Property attr = union.createOwnedAttribute(CORBAUtil.SWITCH_ATTRIBUTE_NAME, null);
						attr.setUpper(1);
						attr.setLower(0);
					}
				}

				return CommandResult.newOKCommandResult(newObject);
			}
		};
	}

}
