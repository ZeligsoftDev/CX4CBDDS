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
package com.zeligsoft.domain.omg.ccm.ui.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Drag drop policy for CCMComponent
 * 
 * @author ysroh
 * 
 */
public class CCMComponentDragDropPolicy extends DragDropEditPolicy {

	@Override
	protected Command getDropElementCommand(final EObject element,
			DropObjectsRequest request) {
		if (ZDLUtil.isZDLConcept(element, CORBADomainNames.CORBAINTERFACE)) {

			return new ICommandProxy(new AbstractTransactionalCommand(TransactionUtil
					.getEditingDomain(element),
					Messages.CCMComponentDragDropPolicy_CommandLabel, null) {

				protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
						IAdaptable info) {
					Component component = (Component) ViewUtil
							.resolveSemanticElement((View) getHost().getModel());

					CreateElementRequest createRequest = new CreateElementRequest(
							component, ZDLElementTypeUtil.getElementType(component,
									CCMNames.INTERFACE_PORT));
					createRequest.setParameter("uml.port.type", element); //$NON-NLS-1$
					try {
						BaseUIUtil.createModelElement(createRequest);
					} catch (ExecutionException e) {
						Activator.getDefault().error(
								"Failed to create an interface port", e); //$NON-NLS-1$
					}
					return CommandResult.newOKCommandResult();
				}
			});
		}
		return null;
	}
}
