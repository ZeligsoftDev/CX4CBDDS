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
package com.zeligsoft.domain.idl3plus.ui.internal.providers.decorator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * Connector line decorator provider for CCM Connector to show solid line for
 * all CCM Connection.
 * 
 * @author ysroh
 * 
 */
public class ConnectorDecoratorProvider extends AbstractProvider implements
		IDecoratorProvider {

	private final String IDL3PLUS_CONNECTOR_DECORATOR = "IDL3Plus Connector Decorator";//$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider
	 * #createDecorators
	 * (org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 */
	public void createDecorators(IDecoratorTarget target) {
		EditPart editPart = (EditPart) target.getAdapter(EditPart.class);
		if (editPart != null && editPart instanceof IPrimaryEditPart) {
			target.installDecorator(IDL3PLUS_CONNECTOR_DECORATOR,
					new DDS4CCMConnectorDecorator(target));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse
	 * .gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if (editPart != null && editPart instanceof IPrimaryEditPart) {
			Object model = editPart.getModel();
			if (!(model instanceof View)) {
				return false;
			}
			EObject element = ViewUtil.resolveSemanticElement((View) model);
			return (element != null)
					&& ZDLUtil.isZDLConcept(element, CCMNames.CCMCONNECTOR);
		}

		return false;
	}

	/**
	 * DDS4CCM connector decorator class
	 * 
	 * @author ysroh
	 * 
	 */
	public static class DDS4CCMConnectorDecorator extends AbstractDecorator {

		public DDS4CCMConnectorDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		public void activate() {
			refresh();
		}

		public void refresh() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
			if (editPart == null || !(editPart instanceof IPrimaryEditPart)) {
				return;
			}
//			if (editPart instanceof ConnectionNodeEditPart) {
//				IFigure figure = ((ConnectionNodeEditPart) editPart)
//						.getFigure();
//				if (figure != null && figure instanceof PolylineConnectionEx) {
//					PolylineConnectionEx polyFigure = (PolylineConnectionEx) ((ConnectionNodeEditPart) editPart)
//							.getFigure();
//					polyFigure.setLineStyle(1);
//					polyFigure.refreshLine();
//				}
//			}
		}
	}
}
