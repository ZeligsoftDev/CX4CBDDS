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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.viewers.ISelection;
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
public class ShowPortTypeActionHandler extends AbstractHandler {

	protected ISelection selection;

	protected EObject context;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		context = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		Port port = (Port) context;
		Type type = port.getType();
		if (type == null) {
			return null;
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
						BaseUIUtil.revealTarget(pe);
						return null;
					}
					target = pe;
				}
				BaseUIUtil.revealTarget(target);
				return null;
			}
		}
		BaseUIUtil.revealTarget(type);
		return null;
	}
}
