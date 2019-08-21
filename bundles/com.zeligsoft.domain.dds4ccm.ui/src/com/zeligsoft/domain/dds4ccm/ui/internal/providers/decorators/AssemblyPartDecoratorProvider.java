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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.xtools.rmp.ui.diagram.figures.FigureUtilities;
import com.ibm.xtools.rmp.ui.diagram.figures.RMPDiagramColorConstants;
import com.ibm.xtools.umlnotation.UMLShape;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Decorator for assembly CCMPart
 * 
 * @author ysroh
 * 
 */
public class AssemblyPartDecoratorProvider extends AbstractProvider implements
		IDecoratorProvider {

	private final String ASSEMBLY_DECORATOR = "DDS4CCM Assembly Decorator";//$NON-NLS-1$

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
			target.installDecorator(ASSEMBLY_DECORATOR,
					new DDS4CCMAssemblyDecorator(target));
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
					&& ZDLUtil.isZDLConcept(element, CCMNames.CCMPART);
		}

		return false;
	}

	/**
	 * DDS4CCM Assembly decorator class
	 * 
	 * @author ysroh
	 * 
	 */
	public static class DDS4CCMAssemblyDecorator extends AbstractDecorator {

		private static TransactionalEditingDomain domain;
		private static final int lightBlue = FigureUtilities
				.RGBToInteger(RMPDiagramColorConstants.diagramLightBlue
						.getRGB());
		private static final int white = FigureUtilities
				.RGBToInteger(ColorConstants.white.getRGB());

		public DDS4CCMAssemblyDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		public void activate() {
			addListener();
			refresh();
		}

		@Override
		public void deactivate() {
			removeListener();
			super.deactivate();
		}

		public void refresh() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);

			if (editPart.getModel() instanceof UMLShape) {
				final UMLShape model = (UMLShape) editPart.getModel();

				EObject element = ViewUtil.resolveSemanticElement(model);

				final int color;
				if (CCMUtil.isAssemblyPart(element)) {
					color = lightBlue;
				} else {
					color = white;
				}
				if (model.getFillColor() != white
						&& model.getFillColor() != lightBlue) {
					return;
				}
				if (model.getFillColor() != color) {
					ICommand command = new AbstractTransactionalCommand(
							TransactionUtil.getEditingDomain(element),
							"Set Part FillColor", null) { //$NON-NLS-1$

						@Override
						protected CommandResult doExecuteWithResult(
								IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {
							model.setFillColor(color);
							return CommandResult.newOKCommandResult();
						}
					};
					try {
						command.execute(null, null);
					} catch (ExecutionException e) {
						Activator.getDefault().error(e.getMessage(), e);
					}
				}
			}
		}

		private ResourceSetListenerImpl listener = new ResourceSetListenerImpl() {
			@Override
			public void resourceSetChanged(ResourceSetChangeEvent event) {
				for (Notification notification : event.getNotifications()) {
					Property element = (Property) getElement();

					if (element == null || element.getType() == null) {
						return;
					}

					Type type = element.getType();
					if (notification.getFeature() != null
							&& notification
									.getFeature()
									.equals(UMLPackage.Literals.GENERALIZATION__GENERAL)) {
						if (notification.getNewValue() != null
								&& notification.getNewValue() == type) {
							refresh();
						} else if (notification.getOldValue() != null
								&& notification.getOldValue() == type) {
							refresh();
						}
					}
				}
			}
		};

		/**
		 * Adds this as listener to the DiagramEventBroker.
		 */
		private void addListener() {
			Property element = (Property) getElement();

			domain = TransactionUtil.getEditingDomain(element);
			if (domain == null) {
				return;
			}
			domain.addResourceSetListener(listener);
		}

		/**
		 * Removes this as listener to the DiagramEventBroker.
		 */
		private void removeListener() {

			if (domain == null) {
				return;
			}
			domain.removeResourceSetListener(listener);

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
