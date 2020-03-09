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
package com.zeligsoft.domain.omg.ccm.ui.internal.providers.decorator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Provides the CCMPart decoration, it appears as two small connected
 * squares.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class CCMPartDecorator
	extends AbstractDecorator{

	/**
	 * Size of the decorator
	 */
	private int decoratorSize = 6;
	
	/**
	 * Offset for the decoration in a CCMPart, an offset is necessary since
	 * it is located in the SOUTH WEST corner of the shape;
	 */
	private int partOffset = -4;
	
	/**
	 * Creates a new instance of CCMPartDecorator for the given
	 * IDecoratorTarget.
	 * 
	 * @param target
	 */
	public CCMPartDecorator(IDecoratorTarget target) {
		super(target);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#activate()
	 */
	@Override
	public void activate() {
		refresh();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#deactivate()
	 */
	@Override
	public void deactivate() {
		super.deactivate();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#refresh()
	 */
	@Override
	public void refresh() {
		removeDecoration();
		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);
		if(!(editPart instanceof IPrimaryEditPart)) {
			return;
		}
		
		EObject element = (EObject) getDecoratorTarget().getAdapter(EObject.class);
		
		if(ZDLUtil.isZDLConcept(element, CCMNames.CCMPART)) {
			EObject partType = (EObject) ZDLUtil.getValue(element, ZMLMMNames.PART, 
					ZMLMMNames.PART__DEFINITION);
			
			if(partType != null && 
					ZDLUtil.isZDLConcept(partType, CCMNames.CCMCOMPONENT)) {
				Component ccmComponent = (Component) partType;
				List<EObject> assemblyImplementations = new ArrayList<EObject>();
				List<Relationship> generalizations =
					ccmComponent.getRelationships(UMLPackage.Literals.GENERALIZATION);
				for(Relationship g : generalizations) {
					Classifier realization = ((Generalization) g).getSpecific();
					if(ZDLUtil.isZDLConcept(realization, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
						assemblyImplementations.add(realization);
					}
				}
				
				if(!assemblyImplementations.isEmpty()) {
					int radius = MapModeUtil.getMapMode(
							((GraphicalEditPart) editPart).getFigure()).DPtoLP(
							decoratorSize);
						Ellipse filledCircle = new Ellipse();
						filledCircle.setSize(new Dimension(radius, radius));
						filledCircle.setOpaque(true);
						filledCircle.setForegroundColor(ColorConstants.gray);
						filledCircle.setBackgroundColor(ColorConstants.gray);

						setDecoration(getDecoratorTarget().addShapeDecoration(
							filledCircle, element instanceof Port
								? IDecoratorTarget.Direction.CENTER
								: IDecoratorTarget.Direction.SOUTH_WEST, getOffset(),
							false));
				}
			}
		}
	}

	/**
	 * Returns the offset based on the type of the semantic element.
	 * 
	 * @return
	 */
	private int getOffset() {

		int offSet = partOffset;

		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
			EditPart.class);

		return MapModeUtil.getMapMode(((ShapeEditPart) editPart).getFigure())
			.DPtoLP(offSet);

	}
}
