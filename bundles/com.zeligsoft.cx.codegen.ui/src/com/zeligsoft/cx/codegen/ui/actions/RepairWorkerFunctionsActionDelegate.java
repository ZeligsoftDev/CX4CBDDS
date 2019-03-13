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

package com.zeligsoft.cx.codegen.ui.actions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.ui.action.AbstractModelActionDelegate;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.WorkerFunctionRepair;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import com.zeligsoft.domain.zml.util.ZMLUtil;

/**
 * Action which allows users to manually ask for synchronization of 
 * the worker functions.
 * 
 * @author jcorchis
 *
 */
public class RepairWorkerFunctionsActionDelegate
		extends AbstractModelActionDelegate
		implements IObjectActionDelegate {

	@Override
	protected TransactionalEditingDomain getEditingDomain() {
		EObject eObject = BaseUIUtil.getEObjectFromSelection(getStructuredSelection());
		if (eObject != null) {
			return TransactionUtil.getEditingDomain(eObject);
		}
		
		return null;
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		WorkerFunctionRepair wfr = new WorkerFunctionRepair();
		wfr.repair(getComponentToRepair());
	}
	
	/**
	 * Returns all the structural realizations that I've been asked to repair.
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Set<Component> getComponentToRepair() {

		Set<Component> result = new HashSet<Component>();
		IStructuredSelection ss = getStructuredSelection();
		Iterator i = ss.iterator();
		while (i.hasNext()) {
			Object object = i.next();
			EObject eObject = null;
			if (object instanceof EObject) {
				eObject = (EObject) object;
			} else if (object instanceof IAdaptable) {
				eObject = (EObject) ((IAdaptable) object)
					.getAdapter(EObject.class);
			}

			if (eObject != null) {
				if (ZDLUtil.isZDLConcept(eObject,
					ZMLMMNames.STRUCTURAL_REALIZATION)) {
					result.add((Component) eObject);
				} else if (ZDLUtil.isZDLConcept(
					eObject, ZMLMMNames.COMPONENT_INTERFACE)) {
					result.addAll(ZMLUtil.getStructuralRealizations((Component)eObject));
				}
			}
		}
		return result;
	}

}
