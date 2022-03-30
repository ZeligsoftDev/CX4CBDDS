/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.ui.edithelpers;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.uml.types.core.requests.SetStereotypeValueRequest;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * 
 * @author Young-soo Roh
 *
 */
public class InterfacePortEditHelperAdvice extends AbstractEditHelperAdvice {

	private static final String CORBA_CONNECTOR_LIBRARY = "pathmap://DDS4CCM_CORBA_LIBRARIES/CCM_CORBA.uml"; //$NON-NLS-1$

	@Override
	public ICommand getAfterEditCommand(IEditCommandRequest request) {
		if (request instanceof SetStereotypeValueRequest && CCMNames.INTERFACE_PORT__CONNECTOR_TYPE
				.equals(((SetStereotypeValueRequest) request).getPropertyName())) {
			return new AbstractTransactionalCommand(request.getEditingDomain(), "Edit Value", //$NON-NLS-1$
					null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					EObject elementToEdit = (EObject) request.getElementsToEdit().get(0);
					EObject value = ZDLUtil.getEValue(elementToEdit, CCMNames.INTERFACE_PORT,
							CCMNames.INTERFACE_PORT__CONNECTOR_TYPE);
					if (value != null && "AMI4CCM_Connector".equals(((NamedElement) value).getName())) { //$NON-NLS-1$
						ZDLUtil.setValue(elementToEdit, CCMNames.INTERFACE_PORT,
								CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS, true);
					} else {
						ZDLUtil.setValue(elementToEdit, CCMNames.INTERFACE_PORT,
								CCMNames.INTERFACE_PORT__IS_ASYNCHRONOUS, false);
					}

					return CommandResult.newOKCommandResult(elementToEdit);
				}
			};
		} else if (request instanceof SetRequest) {
			final SetRequest setRequest = (SetRequest) request;
			return new AbstractTransactionalCommand(setRequest.getEditingDomain(), "Set Default Connector Type", //$NON-NLS-1$
					null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					EObject elementToEdit = (EObject) request.getElementsToEdit().get(0);

					if (setRequest.getValue() == null) {
						ZDLUtil.setValue(elementToEdit, CCMNames.INTERFACE_PORT,
								CCMNames.INTERFACE_PORT__CONNECTOR_TYPE, null);
					} else if (setRequest.getValue() instanceof Interface
							&& UMLPackage.Literals.TYPED_ELEMENT__TYPE.equals(setRequest.getFeature())) {
						EObject value = ZDLUtil.getEValue(elementToEdit, CCMNames.INTERFACE_PORT,
								CCMNames.INTERFACE_PORT__CONNECTOR_TYPE);
						org.eclipse.uml2.uml.Package model = (org.eclipse.uml2.uml.Package) EcoreUtil
								.getRootContainer(elementToEdit);
						Package connectorPackage = null;
						for (PackageImport pi : model.getPackageImports()) {
							Package pkg = pi.getImportedPackage();
							if (CORBA_CONNECTOR_LIBRARY.equals(pkg.eResource().getURI().toString())) {
								connectorPackage = pkg;
								break;
							}
						}
						if (connectorPackage == null) {
							// import CORBA4CCM connector
							URI uri = URI.createURI(CORBA_CONNECTOR_LIBRARY);
							Resource resource = model.eResource().getResourceSet().getResource(uri, true);
							if (resource != null) {
								connectorPackage = (Package) resource.getContents().get(0);
								model.createPackageImport(connectorPackage);
							}
						}

						Collection<NamedElement> result = UMLUtil.findNamedElements(connectorPackage.eResource(),
								"CCM_CORBA::CCM_CORBA::Connector_T::CORBA4CCM_Connector"); //$NON-NLS-1$

						if (!result.isEmpty()) {
							value = result.iterator().next();
							// set default value
							ZDLUtil.setValue(elementToEdit, CCMNames.INTERFACE_PORT,
									CCMNames.INTERFACE_PORT__CONNECTOR_TYPE, value);
						}
					}

					return CommandResult.newOKCommandResult(elementToEdit);
				}
			};
		}

		return null;
	}
}
