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

package com.zeligsoft.cx.ui.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.diagram.utils.BaseDiagramUtil;
import com.zeligsoft.base.ui.commands.CreatePackageWithoutDiagramCommand;
import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeManager;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;

/**
 * Action delegate for "Add Package" context menu.
 * 
 * @author ysroh
 * 
 */

public class AddCXPackageAction extends Action implements ICXAction {

	protected EObject context;

	/**
	 * The IElementType for Package
	 */
	public static IElementType PACKAGE_ELEMENT_TYPE = ZDLElementTypeManager.INSTANCE
			.getElementTypeFromHint("package");//$NON-NLS-1$;

	/**
	 * Returns a new CreateElementRequest and set the element to be create to
	 * <code>PACKAGE_ELEMENT_TYPE</code>
	 * 
	 * @return CreateElementRequest
	 */

	@Override
	public void setSelection(EObject context) {
		this.context = context;
	}

	@Override
	public void run() {
		if (context == null) {
			return;
		}

		ICommand command = new CreatePackageWithoutDiagramCommand(context);
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
					"Failed to create a package", e); //$NON-NLS-1$
			return;
		}
		CommandResult result = command.getCommandResult();
		if (result != null && result.getReturnValue() != null) {
			if (result.getReturnValue() instanceof Package) {
				Package pkg = (Package) result.getReturnValue();
				if (!BaseDiagramUtil.startInlineEdit(pkg)) {
					BaseUIUtil.startInLineEdit(pkg);
				}
			}
		}
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return new ElementTypeImageDescriptor(PACKAGE_ELEMENT_TYPE);
	}

}
