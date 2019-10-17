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
package com.zeligsoft.domain.dds4ccm.ui.internal.providers.decorators;

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
 * Decorate ConnectorStatusListener connections
 * 
 * @author ysroh
 * 
 */
public class ConnectorDecoratorProvider extends AbstractProvider implements
		IDecoratorProvider {

	private final String DDS4CCM_CONNECTOR_DECORATOR = "DDS4CCM Connector Decorator";//$NON-NLS-1$

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
			target.installDecorator(DDS4CCM_CONNECTOR_DECORATOR,
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

//		private static int LINE_COLOR = FigureUtilities.RGBToInteger(new RGB(
//				88, 88, 225));
//		private static int DEFAULT_COLOR = FigureUtilities
//				.RGBToInteger(ColorConstants.gray.getRGB());

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

//			if (editPart.getModel() instanceof UMLConnector) {
//				final UMLConnector connector = (UMLConnector) editPart
//						.getModel();
//
//				final EObject element = ViewUtil
//						.resolveSemanticElement((View) connector);
//				ICommand command = new AbstractTransactionalCommand(
//						TransactionUtil.getEditingDomain(element),
//						"Set LineColor", null) { //$NON-NLS-1$
//
//					@Override
//					protected CommandResult doExecuteWithResult(
//							IProgressMonitor monitor, IAdaptable info)
//							throws ExecutionException {
//						if (ZDLUtil
//								.isZDLConcept(
//										element,
//										DDS4CCMNames.CONNECTOR_STATUS_LISTENER_CONNECTION)) {
//							if (connector.getLineColor() != LINE_COLOR) {
//								connector.setLineColor(LINE_COLOR);
//							}
//						} else {
//							if (connector.getLineColor() != DEFAULT_COLOR) {
//								connector.setLineColor(DEFAULT_COLOR);
//							}
//						}
//						return CommandResult.newOKCommandResult();
//					}
//				};
//
//				try {
//					command.execute(null, null);
//				} catch (ExecutionException e) {
//					Activator.getDefault().error(e.getMessage(), e);
//				}
//			}
		}
	}
}
