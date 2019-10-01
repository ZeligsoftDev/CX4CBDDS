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
package com.zeligsoft.base.ui.menus.actions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.context.TypeContext;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

import com.zeligsoft.base.ui.menus.Activator;
import com.zeligsoft.base.ui.menus.l10.Messages;
import com.zeligsoft.base.ui.menus.util.CXMenuUtil;

/**
 * An action to create a ZDL concept.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class CreateConceptAction extends Action {
	private EObject selectedEObject;
	private org.eclipse.uml2.uml.Class concept;
	private IElementType type;
	private String label;
	private Object result;

	static private Map<IElementType, ElementTypeImageDescriptor> imageDescriptors = new HashMap<IElementType, ElementTypeImageDescriptor>(
			11);

	/**
	 * Create me!
	 * 
	 * @param context The object that will own the created concept
	 * @param concept The concept that is to be created
	 */
	public CreateConceptAction(EObject context, org.eclipse.uml2.uml.Class concept) {
		this(context, concept, null, null);
	}

	/**
	 * Create me!
	 * 
	 * @param context  The object that will own the created concept
	 * @param concept  The concept that is to be created
	 * @param typeHint A hint to help in creating the concept
	 * @param label    The label that will be displayed
	 */
	public CreateConceptAction(EObject context, org.eclipse.uml2.uml.Class concept, String typeHint, String label) {
		this.selectedEObject = context;
		this.concept = concept;
		this.label = label;
		// get the instantiable element type
		this.type = CXMenuUtil.getTypeId(context, concept, typeHint);
	}

	@Override
	public String getText() {
		if (label != null && label.length() > 0) {
			return label;
		} else if (concept != null) {
			return concept.getLabel();
		} else if (type != null) {
			return type.getDisplayName();
		}

		return Messages.CreateConceptAction_NoLabel_msg;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return getElementTypeImageDescriptor(type);
	}

	@Override
	public void run() {
		final Command command = buildCommand();
		if (!command.canExecute()) {
			return;
		}
		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(selectedEObject),
				NLS.bind(Messages.GenericCreateConceptAction_label, getText()), Collections.EMPTY_MAP, null) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				command.execute();
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			IStatus status = OperationHistoryFactory.getOperationHistory().execute(editCommand, null, null);
			if (!status.isOK()) {
				return;
			}
		} catch (ExecutionException e) {
			Activator.getDefault().error(NLS.bind(Messages.GenericCreateConceptAction_failed, concept.getLabel()), e);
			return;
		}
	}

	protected Command buildCommand() {

		// set up the create request
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedEObject);
		IClientContext context = null;
		try {
			context = TypeContext.getContext(selectedEObject);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return UnexecutableCommand.INSTANCE;
		}
		final CreateElementRequest req = new CreateElementRequest(editingDomain, selectedEObject, type);
		final EObject target = ElementEditServiceUtils.getTargetFromContext(editingDomain, selectedEObject, req);
		if (target == null) {
			return UnexecutableCommand.INSTANCE;
		}

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(target, context);
		if (provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EReference reference = null;
		ICommand createGMFCommand = provider.getEditCommand(req);

		if (createGMFCommand != null) {
			return GMFtoEMFCommandWrapper.wrap(createGMFCommand);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Calculate the image descriptor for the given element type. It will return the
	 * default UML icon, if there isn't one specific to the domain.
	 * 
	 * @param elementType
	 * 
	 * @return The image descriptor for the concepts icon.
	 */
	private ImageDescriptor getElementTypeImageDescriptor(IElementType elementType) {
		ElementTypeImageDescriptor desc = imageDescriptors.get(elementType);
		if (desc == null) {
			desc = new ElementTypeImageDescriptor(elementType);
			imageDescriptors.put(elementType, desc);
		}
		return desc;
	}
}
