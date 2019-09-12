/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation
 *  Christian W. Damus - bugs 493869, 467545
 *****************************************************************************/
package com.zeligsoft.domain.cbdds.ui.decorators;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ScaledImageFigure;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;

/**
 * Capsule Part Decorator used by the {@link CapsulePartDecoratorProvider}.
 * 
 * @author Céline JANSSENS
 *
 */
public class PortDecorator extends AbstractDecorator {

	/** Id of the plugin where is located the Decoration image */
	private static final String PLUGIN_ID = com.zeligsoft.domain.cbdds.ui.Activator.PLUGIN_ID;

	/** Path of the decoration */
	private static final String DECORATION_PATH = "icons/consumer-port.gif"; // $NON-NLS-0$

	/** Size of the Icon in Pixel */
	private static final int DECORATION_SIZE_PX = 16;

	/** Position of the Decoration */
	private static final Direction DECORATION_POSITION = Direction.NORTH_EAST;

	/** Offset of the decoration according to the Direction Corner */
	private static final int DECORATION_OFFSET = 3;

	private Image decoratorImage;

	/**
	 * 
	 * Constructor.
	 *
	 * @param decoratorTarget
	 */
	public PortDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);

	}

	@Override
	public void activate() {
		refresh();

	}

	@Override
	public void deactivate() {
		super.deactivate();

		if (decoratorImage != null) {
			decoratorImage.dispose();
			decoratorImage = null;
		}
	}

	@Override
	public void refresh() {

		final EObject eo = (EObject) getDecoratorTarget().getAdapter(EObject.class);
		if (!(eo instanceof Element) || ((Element) eo).getAppliedStereotype("cxDDS4CCM::InterfacePort") == null) {
			return;
		}
		final EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
		removeDecoration();
		if (editPart instanceof PortEditPart) {
			// Get the figure of the editpart
			final IFigure editPartFigure = ((GraphicalEditPart) editPart).getFigure();

			// Create a main figure with a flow layout. It will contains icons.
			final IFigure figure = new Figure();
			final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHorizontal(true);
			flowLayout.setMinorSpacing(0);
			figure.setLayoutManager(flowLayout);

			final ScaledImageFigure capsuleIcon = getImageNode(DECORATION_PATH);// $NON-NLS-1$
			// Add it to main figure of the decoration
			figure.add(capsuleIcon);

			// Get MapMode
			final IMapMode mm = MapModeUtil.getMapMode(editPartFigure);
			// Set the size of the decorator figure
			figure.setSize(mm.DPtoLP(DECORATION_SIZE_PX * figure.getChildren().size()) + (-1),
					mm.DPtoLP(DECORATION_SIZE_PX));

			// Set the decoration with the custom locator.
			setDecoration(getDecoratorTarget().addShapeDecoration(figure, DECORATION_POSITION, -1, false));
		}

	}

	/**
	 * Create a ScaledImageFigure for a specific relative location of a image.
	 * 
	 * @param imageLocation
	 * @return the image to the proper scale.
	 */
	private ScaledImageFigure getImageNode(final String imageLocation) {
		final ScaledImageFigure imageFigure = new ScaledImageFigure();

		if (decoratorImage == null) {
			final ImageDescriptor imageDescriptor = org.eclipse.papyrus.infra.widgets.Activator.getDefault()
					.getImageDescriptor(PLUGIN_ID, imageLocation);
			if (null != imageDescriptor) {
				decoratorImage = imageDescriptor.createImage();
			}
		}

		if (decoratorImage != null) {
			imageFigure.setImage(decoratorImage);
			imageFigure.setSize(DECORATION_SIZE_PX, DECORATION_SIZE_PX);
		}

		return imageFigure;
	}

}
