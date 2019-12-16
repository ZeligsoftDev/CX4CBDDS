/**
 * Copyright 2019 Zeligsoft 2009 Limited.
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
package com.zeligsoft.domain.dds4ccm.ui.drop;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Command to create a CCM Part, add it to a parent Assembly and display it to
 * the given location
 */
public class CreatePartAndDisplayCommand extends AbstractCommand {

	protected Component targetComponent;
	protected IElementType instanceType;
	protected EReference componentFeature;
	protected EObject droppedObject;
	protected Point location;
	protected EditPart targetEditPart;

	public CreatePartAndDisplayCommand(Component targetComponent, IElementType type,
			EReference componentFeature, EObject droppedObject, Point location, EditPart targetEditPart) {
		super("");
		this.targetComponent = targetComponent;
		this.instanceType = type;
		this.componentFeature = componentFeature;
		this.droppedObject = droppedObject;
		this.location = new Point(location);
		this.targetEditPart = targetEditPart;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(targetComponent);
		} catch (ServiceException e) {
			com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(e.getMessage(), e);
			return CommandResult.newErrorCommandResult(e);
		}
		Property instance = createInstance(editingDomain);
		setInstanceType(editingDomain, instance, droppedObject);
		dropInstance(instance);

		return CommandResult.newOKCommandResult(instance);
	}

	protected void setInstanceType(TransactionalEditingDomain editingDomain, Property instance, EObject type) {
		SetRequest setRequest = new SetRequest(editingDomain, instance, UMLPackage.eINSTANCE.getTypedElement_Type(),
				type);

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetComponent);
		if (provider != null) {
			ICommand setCommand = provider.getEditCommand(setRequest);

			if (setCommand != null && setCommand.canExecute()) {
				try {
					setCommand.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * @param createdNode
	 */
	protected void dropInstance(Property createdCCMPart) {
		DropObjectsRequest dropReq = new DropObjectsRequest();
		dropReq.setObjects(Arrays.asList(createdCCMPart));
		dropReq.setLocation(location);
		Command dropReqCommand = targetEditPart.getCommand(dropReq);
		if (dropReqCommand != null && dropReqCommand.canExecute()) {
			dropReqCommand.execute();
		}
	}

	/**
	 * 
	 */
	protected Property createInstance(TransactionalEditingDomain editingDomain) {
		Property createdProperty = null;
		CreateElementRequest createElementRequest = new CreateElementRequest(editingDomain, targetComponent,
				instanceType);

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetComponent);
		if (provider != null) {
			ICommand createCommand = provider.getEditCommand(createElementRequest);

			if (createCommand != null && createCommand.canExecute()) {
				try {
					createCommand.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					com.zeligsoft.domain.dds4ccm.ui.Activator.getDefault().error(e.getMessage(), e);
					return null;
				}
				CommandResult result = createCommand.getCommandResult();
				createdProperty = getCreatedObject(result);
				return createdProperty;
			}

		}

		return createdProperty;
	}

	public static <T extends EObject> T getCreatedObject(CommandResult commandResult) {
		Object objectResult = commandResult.getReturnValue();
		if (objectResult instanceof List) {
			// Result of the semantic + graphical creation command
			List<?> listResult = (List<?>) objectResult;
			for (Object elementResult : listResult) {
				if (elementResult instanceof CreateElementRequestAdapter) {
					CreateElementRequest request = (CreateElementRequest) ((CreateElementRequestAdapter) elementResult)
							.getAdapter(CreateElementRequest.class);
					if (request != null) {
						EObject newElement = request.getNewElement();
						if (newElement instanceof EObject) {
							return (T) newElement;
						}
					}
				}
			}
		} else if (commandResult.getReturnValue() instanceof EObject) {
			// Result of the semantic creation command
			return (T) commandResult.getReturnValue();
		}

		return null;
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return null;
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
			throws ExecutionException {
		return null;
	}

}
