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
package com.zeligsoft.domain.ngc.ccm.ui;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Triangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class PortDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	private final String CCM_PORT_DECORATOR = "CCM Port Decorator";//$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 */
	public void createDecorators(IDecoratorTarget target) {
		EditPart editPart = (EditPart) target.getAdapter(EditPart.class);
		if(editPart != null && editPart instanceof IPrimaryEditPart) {
			target.installDecorator(CCM_PORT_DECORATOR, 
					new CCMPortDecorator(target));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if(!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if(editPart != null && editPart instanceof IPrimaryEditPart) {
			Object model = editPart.getModel();
			if(!(model instanceof View)) {
				return false;
			}
			EObject element = ViewUtil.resolveSemanticElement((View) model);
			return element instanceof Property;
		}
		
		return false;
	}
	
	public static class CCMPortDecorator
		extends AbstractDecorator
		implements NotificationListener {

		/**
		 * Size of the decorator.
		 */
		private int decoratorSize = 8;

		/**
		 * Offset for the decoration in a Part, an offset is necessary since it is
		 * located in the SOUTH WEST corner of the shape.
		 */
		private int partOffset = -4;

		/**
		 * Offset for the decoration in a Port, in this case an offset is not
		 * necessary since the decoration has a CENTRE location.
		 */
		private int portOffset = 0;
		
		/**
		 * @param decoratorTarget
		 */
		public CCMPortDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		public void notifyChanged(Notification notification) {
			if (notification.getFeature() == null) {
				return;
			}

			if (notification.getFeature().equals(
				UMLPackage.eINSTANCE.getPort_Required()) || 
				notification.getFeature().equals(
						UMLPackage.eINSTANCE.getPort_Provided())) {

				if (notification.getEventType() == Notification.ADD ||
						notification.getEventType() == Notification.REMOVE) {
					if (notification.getNewValue() != null
						&& notification.getOldValue() == null) {
						TransactionalEditingDomain txDomain = TransactionUtil
							.getEditingDomain(getElement());
						DiagramEventBroker.getInstance(txDomain)
							.addNotificationListener(
								((Property) getElement()).getUpperValue(), this);
					} else if (notification.getNewValue() == null
						&& notification.getOldValue() != null) {
						TransactionalEditingDomain txDomain = TransactionUtil
							.getEditingDomain(getElement());
						DiagramEventBroker.getInstance(txDomain)
							.removeNotificationListener(
								((Property) getElement()).getUpperValue(), this);
					}
				}
				EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
				if (editPart.isActive()) {
					editPart.refresh();
				}

			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#activate()
		 */
		public void activate() {
			addListener();
			refresh();
			
		}
		
		@Override
		public void deactivate() {

			removeListener();
			super.deactivate();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator#refresh()
		 */
		public void refresh() {
			removeDecoration();
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if(!(editPart instanceof IPrimaryEditPart)) {
				return;
			}
			
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			EObject element = ViewUtil.resolveSemanticElement(view);
			
			if(ZDLUtil.isZDLConcept(element, CCMNames.EVENT_PORT)) {
				Port port = (Port) element;
				if(port.getRequireds().isEmpty()) {
					int radius = MapModeUtil.getMapMode(
							((GraphicalEditPart) editPart).getFigure()).DPtoLP(
							decoratorSize);
						Triangle filledTriangle = new Triangle();
						filledTriangle.setSize(new Dimension(radius, radius));
						filledTriangle.setOpaque(true);
						filledTriangle.setForegroundColor(ColorConstants.green);
						filledTriangle.setBackgroundColor(ColorConstants.green);

						setDecoration(getDecoratorTarget().addShapeDecoration(
								filledTriangle, element instanceof Port
								? IDecoratorTarget.Direction.CENTER
								: IDecoratorTarget.Direction.SOUTH_WEST, getOffset(),
							false));
				} else {
					int radius = MapModeUtil.getMapMode(
							((GraphicalEditPart) editPart).getFigure()).DPtoLP(
							decoratorSize);
						Triangle filledTriangle = new Triangle();
						filledTriangle.setSize(new Dimension(radius, radius));
						filledTriangle.setOpaque(true);
						filledTriangle.setForegroundColor(ColorConstants.orange);
						filledTriangle.setBackgroundColor(ColorConstants.orange);

						setDecoration(getDecoratorTarget().addShapeDecoration(
								filledTriangle, element instanceof Port
								? IDecoratorTarget.Direction.CENTER
								: IDecoratorTarget.Direction.SOUTH_WEST, getOffset(),
							false));
				}
			} else if(ZDLUtil.isZDLConcept(element, ZMLMMNames.MESSAGE_PORT)) {
				Port port = (Port) element;
				if(port.getRequireds().isEmpty()) {
					int radius = MapModeUtil.getMapMode(
							((GraphicalEditPart) editPart).getFigure()).DPtoLP(
							decoratorSize);
						RectangleFigure shape =
							new RectangleFigure();
						shape.setSize(new Dimension(radius, radius));
						shape.setOpaque(true);
						shape.setForegroundColor(ColorConstants.green);
						shape.setBackgroundColor(ColorConstants.green);

						setDecoration(getDecoratorTarget().addShapeDecoration(
							shape, element instanceof Port
								? IDecoratorTarget.Direction.CENTER
								: IDecoratorTarget.Direction.SOUTH_WEST, getOffset(),
							false));
				} else {
					int radius = MapModeUtil.getMapMode(
							((GraphicalEditPart) editPart).getFigure()).DPtoLP(
							decoratorSize);
						RectangleFigure shape =
							new RectangleFigure();
						shape.setSize(new Dimension(radius, radius));
						shape.setOpaque(true);
						shape.setForegroundColor(ColorConstants.orange);
						shape.setBackgroundColor(ColorConstants.orange);

						setDecoration(getDecoratorTarget().addShapeDecoration(
							shape, element instanceof Port
								? IDecoratorTarget.Direction.CENTER
								: IDecoratorTarget.Direction.SOUTH_WEST, getOffset(),
							false));
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

			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view.getElement() instanceof Port) {
				offSet = portOffset;
			}

			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);

			return MapModeUtil.getMapMode(((ShapeEditPart) editPart).getFigure())
				.DPtoLP(offSet);

		}
		
		/**
		 * Adds this as listener to the DiagramEventBroker.
		 */
		private void addListener() {
			EObject element = getElement();
			TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(element);
			DiagramEventBroker.getInstance(txDomain).addNotificationListener(
				element, this);
			if (((Property) element).isMultivalued()) {
				DiagramEventBroker.getInstance(txDomain).addNotificationListener(
					((Property) element).getUpperValue(), this);
			}

		}

		/**
		 * Removes this as listener to the DiagramEventBroker.
		 */
		private void removeListener() {

			EObject element = getElement();

			if (element == null) {
				// Safe to return since the listener implementation
				// uses a weak reference to cache listeners.
				return;
			}

			TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(element);

			if (txDomain == null) {
				return;
			}
			DiagramEventBroker.getInstance(txDomain).removeNotificationListener(
				element, this);

			if (((Property) element).isMultivalued()) {
				DiagramEventBroker.getInstance(txDomain)
					.removeNotificationListener(
						((Property) element).getUpperValue(), this);
			}

		}

		/**
		 * Returns the model element which is represented by the target.
		 * 
		 * @return
		 */
		private EObject getElement() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);
			Object model = editPart.getModel();
			if (!(model instanceof View)) {
				return null;
			}
			return ViewUtil.resolveSemanticElement((View) model);

		}
	}
}
