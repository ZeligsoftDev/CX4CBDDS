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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Show port type action delegate for DDS4CCM
 * 
 * @author ysroh
 * 
 */
public class ShowPortTypeActionDelegate implements IObjectActionDelegate {

	protected ISelection selection;

	protected EObject context;

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

	@Override
	public void run(IAction action) {

		if (context == null) {
			return;
		}
		Port port = (Port) context;
		Type type = port.getType();
		if (type == null) {
			return;
		}
		if (type.eContainer() instanceof Package
				&& ZDLUtil.isZDLConcept(type, ZMLMMNames.PORT_TYPE)) {
			Package container = (Package) type.eContainer();
			if (!container.getTemplateBindings().isEmpty()) {
				EObject target = null;
				for (TemplateParameterSubstitution sub : container
						.getTemplateBindings().get(0)
						.getParameterSubstitutions()) {
					EObject pe = sub.getActual();
					EObject formal = sub.getFormal()
							.getOwnedParameteredElement();
					String formalName = EMFCoreUtil.getName(formal);
					if ("T".equals(formalName.toUpperCase())) { //$NON-NLS-1$
						BaseUIUtil.showInProjectExplorer(pe);
						return;
					}
					target = pe;
				}
				BaseUIUtil.showInProjectExplorer(target);
				return;
			}
		}
		BaseUIUtil.showInProjectExplorer(type);

	}

	@Override
	public void selectionChanged(IAction action, final ISelection selection) {

		this.selection = selection;

		if (selection == null || action == null) {
			action.setEnabled(false);
			return;
		}

		context = BaseUIUtil.getEObjectFromSelection(selection);
		if (context != null && ZDLUtil.isZDLConcept(context, ZMLMMNames.PORT)) {
			action.setEnabled(true);
		} else {
			action.setEnabled(false);
		}
	}

}
