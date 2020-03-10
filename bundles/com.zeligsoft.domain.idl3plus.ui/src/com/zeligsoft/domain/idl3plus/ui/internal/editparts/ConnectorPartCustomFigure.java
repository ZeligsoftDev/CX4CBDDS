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
package com.zeligsoft.domain.idl3plus.ui.internal.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.composite.custom.figures.PropertyPartFigure;

/**
 * Connector custom figure
 * 
 * @author ysroh
 * 
 */
public class ConnectorPartCustomFigure extends PropertyPartFigure {

	public ConnectorPartCustomFigure() {
		setOpaque(true);
		
		Dimension dim = new Dimension(MapModeUtil.getMapMode().DPtoLP(1), MapModeUtil.getMapMode().DPtoLP(1));
		setSize(dim);
		setBorder(null);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setLayoutManager(new ConstrainedToolbarLayout());
	}

	@Override
	public void paintFigure(Graphics graphics) {
		Rectangle rectangle = new Rectangle(getClientArea().getCopy());
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.setForegroundColor(ColorConstants.black);
		graphics.fillOval(rectangle);
		graphics.drawOval(rectangle);
		graphics.setLineWidth(0);
	}
}
