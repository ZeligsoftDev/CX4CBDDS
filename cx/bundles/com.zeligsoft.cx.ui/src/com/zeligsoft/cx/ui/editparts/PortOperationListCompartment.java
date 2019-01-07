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

package com.zeligsoft.cx.ui.editparts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.SemanticListCompartmentEditPart;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * ListCompartment which displays operations that can be implemented by
 * structural realization based on its component interface.
 * 
 * @author jcorchis
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PortOperationListCompartment
		extends SemanticListCompartmentEditPart {
	
	private static String WORKER_FUNCTION = "WorkerFunction"; //$NON-NLS-1$

	/**
	 * We cache the model children since getModelChildren() and
	 * getSemanticChildren() are call often immediately, one after the other.
	 * 
	 * @see ListCompartmentEditPart
	 * @see SemanticListCompartmentEditPart
	 */
	private List<Operation> workerFunctionOperationCache = null;

	public PortOperationListCompartment(EObject model) {
		super(model);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

	}

	@Override
	protected boolean hasModelChildrenChanged(Notification arg0) {
		Object feature = arg0.getFeature();
		return feature == UMLPackage.Literals.CLASS__OWNED_OPERATION;
	}

	@Override
	public String getCompartmentName() {
		return Messages.DerivedPortOperationListCompartment_label;
	}

	@Override
	protected List getSemanticChildrenList() {
		if (workerFunctionOperationCache != null)
			return workerFunctionOperationCache;
		
		List children = new ArrayList();
		
		try{
			if (resolveSemanticElement() != null) {
				children = (List) ZDLUtil.getValue(resolveSemanticElement(),
						ZMLMMNames.STRUCTURAL_REALIZATION,
						ZMLMMNames.STRUCTURAL_REALIZATION__WORKER);
			}
		}
		catch(IllegalArgumentException e){
			
			//We need to handle the case where a diagram is being drawn within
			//the context of the compare merge utility.
			//The compare merge uses its own internal resourceSet 
			//which does not have our zdl and zml profiles loaded.   
			
			//In order to work around, we filter
			//the operations based on the stereotype name.   
			//Any operations with a stereotype with the name 
			//"WorkerFunction" will be added to the childrenList.
			
			children = new ArrayList();
			
			EObject obj = resolveSemanticElement();
			if (obj instanceof Classifier){
				List<Operation> operations = ((Classifier) obj).getOperations();
				
				for(int x=0; x<operations.size();x++){
					Operation operation = operations.get(x);
					List<Stereotype> stereotypes = operation.getAppliedStereotypes();
					
					for (int y=0; y<stereotypes.size(); y++){
						Stereotype stereotype = stereotypes.get(y);
						if (stereotype.getName().equals(WORKER_FUNCTION)){
							children.add(operation);
							break;
						}						
					}					
				}
			}					
		}
		
		return children;
	}

	@Override
	protected void semanticChildAdded(EObject operation, int index) {
		if (operation != null) {
			addChild(BaseUIUtil.createWorkerFunctionEditPart((Operation)operation), index);
		}

	}

	@Override
	protected List getModelChildren() {

		List<Operation> childrenList = null;
		try {
			workerFunctionOperationCache = null;
			workerFunctionOperationCache = getSemanticChildrenList();
			childrenList = super.getModelChildren();
		} finally {
			workerFunctionOperationCache = null;
		}
		return childrenList;

	}
	
	
	// The following two methods are overridden to handles the case where the notification
	// oldValue is a List.
	@Override
	protected void semanticChildrenListChanged(Notification event) {
		// TODO: raise eclipse gmf bug
		if (isCanonicalEnabled()) {
			if (NotificationUtil.isElementRemovedFromSlot(event)
				&& event.getFeature() == UMLPackage.Literals.CLASS__OWNED_OPERATION
				&& event.getOldValue() instanceof List) {
				for (Iterator i = ((List) event.getOldValue()).iterator(); i
					.hasNext();) {
					semanticChildRemoved((EObject) i.next());
				}
			}
		}
		super.semanticChildrenListChanged(event);
	}
	
	
	@Override
	protected void semanticChildRemoved(EObject child) {
		if (children == null) {
			return;			
		}
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			GraphicalEditPart ep = (GraphicalEditPart) iter
				.next();
			if (ep.resolveSemanticElement() == child) {
				removeChild(ep);
				break;
			}
		}
	}
	
}
