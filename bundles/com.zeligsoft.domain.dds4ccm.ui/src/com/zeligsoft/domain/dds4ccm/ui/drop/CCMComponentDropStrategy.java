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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Drop strategy to create a CCM part
 */
public class CCMComponentDropStrategy extends TransactionalDropStrategy {

	/**
	 * Constructor.
	 */
	public CCMComponentDropStrategy() {
	}

	@Override
	public String getLabel() {
		return "CCMComponent drop to create CCMPart";
	}

	@Override
	public String getDescription() {
		return "CCMComponent drop to create CCMPart";
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public String getID() {
		return com.zeligsoft.domain.dds4ccm.ui.Activator.PLUGIN_ID + ".CCMComponentToCCMPartDrop";
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		if (!(request instanceof DropObjectsRequest)) {
			return null;
		}
		DropObjectsRequest dropReq = getDropObjectsRequest(request);
		if (dropReq == null) {
			return null;
		}
		List<Component> handledDroppedObjects = getDroppedCCMComponents(dropReq);
		EObject targetElement = getTargetSemanticElement(targetEditPart);

		if (!canHandleRequest(handledDroppedObjects, targetElement)) {
			return null;
		}

		Point location = dropReq.getLocation();
		CompoundCommand compoundCommand = new CompoundCommand();
		for (EObject droppedObject : handledDroppedObjects) {
			compoundCommand.add(
					getCreateAndDropObjectCommand(droppedObject, (Component) targetElement, location, targetEditPart));
			location.performTranslate(20, 20);
		}
		return compoundCommand;

	}

	/**
	 * @param droppedObject
	 * @param targetActivity
	 * @param location
	 * @param targetEditPart
	 * @return
	 */
	protected Command getCreateAndDropObjectCommand(EObject droppedObject, Component targetComponent, Point location,
			EditPart targetEditPart) {
		IElementType type = ZDLElementTypeUtil.getElementType(targetComponent, CCMNames.CCMPART);
		String partName = EMFCoreUtil.getName(droppedObject);
		partName = Character.toLowerCase(partName.charAt(0)) + partName.substring(1);
		partName = NamingUtil.generateUniqueName(partName, targetComponent.getOwnedAttributes());
		CreatePartAndDisplayCommand command = new CreatePartAndDisplayCommand(targetComponent, type,
				UMLPackage.eINSTANCE.getNamespace_OwnedMember(), droppedObject, location, targetEditPart, partName);
		return new ICommandProxy(command);
	}

	protected List<Component> getDroppedCCMComponents(Request req) {
		List<EObject> droppedObjects = getSourceEObjects(req);
		List<Component> result = new ArrayList<Component>();
		if (droppedObjects != null) {
			for (EObject droppedObject : droppedObjects) {
				if (ZDLUtil.isZDLConcept(droppedObject, CCMNames.CCMCOMPONENT)) {
					result.add((Component) droppedObject);
				}
			}
		}
		return result;
	}

	protected boolean canHandleRequest(List<Component> droppedObjects, EObject targetElement) {
		boolean result = false;
		if (!droppedObjects.isEmpty()) {
			result = ZDLUtil.isZDLConcept(targetElement, CCMNames.ASSEMBLY_IMPLEMENTATION);
		}
		return result;
	}

}
