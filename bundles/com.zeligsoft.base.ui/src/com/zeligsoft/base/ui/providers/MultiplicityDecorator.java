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

package com.zeligsoft.base.ui.providers;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Provides the multiplicity decoration for Zeligsoft Port and Parts. It appears
 * on a grey opaque circle.
 * 
 * @author jcorchis
 * 
 */
public class MultiplicityDecorator
		extends AbstractDecorator
		implements NotificationListener {

	/**
	 * Size of the decorator.
	 */
	private int decoratorSize = 6;

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
	 * Creates a new instance of MultiplicityDecortor for the given
	 * IDecoratorTarget.
	 * 
	 * @param decoratorTarget
	 */
	public MultiplicityDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	@Override
	public void activate() {
		// We must add our own listener since we do not own the target
		// EditPart and therefore cannot add a notificationListener on it.
		addListener();

		refresh();

	}

	@Override
	public void refresh() {

		removeDecoration();
		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
			EditPart.class);
		if (!(editPart instanceof IPrimaryEditPart)) {
			return;
		}

		View view = (View) getDecoratorTarget().getAdapter(View.class);
		EObject element = ViewUtil.resolveSemanticElement(view);

		if (element instanceof Property) {
			Property prop = (Property) element;
			if (prop.isMultivalued()) {

				int radius = MapModeUtil.getMapMode(
					((GraphicalEditPart) editPart).getFigure()).DPtoLP(
					decoratorSize);
				Ellipse filledCircle = new Ellipse();
				filledCircle.setSize(new Dimension(radius, radius));
				filledCircle.setOpaque(true);
				filledCircle.setForegroundColor(ColorConstants.lightGray);
				filledCircle.setBackgroundColor(ColorConstants.lightGray);

				setDecoration(getDecoratorTarget().addShapeDecoration(
					filledCircle, element instanceof Port
						? IDecoratorTarget.Direction.CENTER
						: IDecoratorTarget.Direction.SOUTH_WEST, getOffset(),
					false));

			}
		}

	}

	/**
	 * Explicitly call refresh() on the target EditPart when an notification
	 * message is received.
	 */
	@Override
	public void notifyChanged(Notification notification) {

		if (notification.getFeature() == null) {
			return;
		}

		if (notification.getFeature().equals(
			UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue())) {

			if (notification.getEventType() == Notification.SET) {
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

		} else if (notification.getFeature().equals(
			UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value())) {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);
			if (editPart.isActive()) {
				editPart.refresh();
			}
		}
	}

	@Override
	public void deactivate() {

		removeListener();
		super.deactivate();
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
		if (txDomain == null) {
			return;
		}
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
