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
package com.zeligsoft.domain.omg.ccm.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * @author smcfee
 * 
 */
public class AddHomeToComponentAction extends Action implements ICXAction {

	protected EObject context;

	private NamedElement newElement = null;

	@Override
	public ImageDescriptor getImageDescriptor() {
		IElementType type = ZDLElementTypeUtil.getElementType(context,
				CCMNames.HOME);
		return new ElementTypeImageDescriptor(type);
	}

	@Override
	public void run() {
//		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
//				UMLModeler.getEditingDomain(),
//				"AddHomeToComponent", //$NON-NLS-1$
//				Collections.EMPTY_MAP, null) {
//
//			@Override
//			protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
//					IAdaptable arg1) throws ExecutionException {
//
//				Class concept = ZDLUtil.getZDLConcept(context.eContainer(),
//						CCMNames.HOME);
//				Profile profile = ZDLUtil.getZDLProfile(context.eContainer(),
//						concept);
//				String id = ZDLElementTypeUtil
//						.getZDLSpecializationElementTypeId(profile, concept);
//
//				CreateElementRequest request = new CreateElementRequest(
//						context.eContainer(), BaseUIUtil.getElementType(id));
//				CommandResult result = BaseUIUtil.createModelElement(request);
//				newElement = (NamedElement) result.getReturnValue();
//				if (newElement != null) {
//					newElement.setName(EMFCoreUtil.getName(context) + "Home"); //$NON-NLS-1$
//					Element manages = newElement
//							.createDependency((Component) context);
//					ZDLUtil.addZDLConcept(manages, CCMNames.MANAGES);
//				}
//				return CommandResult.newOKCommandResult();
//			}
//		};
//
//		try {
//			OperationHistoryFactory.getOperationHistory().execute(editCommand,
//					null, null);
//		} catch (ExecutionException e) {
//			Activator.getDefault().error(
//					"Error creating home", e); //$NON-NLS-1$
//		}
//
//		performPostCreateAction();
	}

	public void setSelection(EObject context) {
		this.context = context;
	}

//	/**
//	 * Perform post create actions
//	 */
//	private void performPostCreateAction() {
//
//		if (newElement != null) {
//			BaseUIUtil.startInLineEdit(newElement);
//		}
//	}
}