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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Shape;

import com.zeligsoft.base.zdl.util.ZDLUtil;
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

		EObject referenceElement = ((CreateDecoratorsOperation) operation).getDecoratorTarget()
				.getAdapter(EObject.class);

		return (referenceElement != null) && ZDLUtil.isZDLConcept(referenceElement, CCMNames.CCMPART);
	}

	/**
	 * DDS4CCM Assembly decorator class
	 * 
	 * @author ysroh
	 * 
	 */
	public static class DDS4CCMAssemblyDecorator extends AbstractDecorator {

		private static final int lightBlue = FigureUtilities
				.RGBToInteger(ColorConstants.lightGray.getRGB());

		public DDS4CCMAssemblyDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		public void activate() {
			refresh();
		}

		public void refresh() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
					EditPart.class);
			
			if (editPart.getModel() instanceof Shape) {
				final Shape model = (Shape) editPart.getModel();

				EObject element = (EObject) getDecoratorTarget().getAdapter(
						EObject.class);

				if (CCMUtil.isAssemblyPart(element)) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
					if (model.getFillColor() != lightBlue && model.getFillColor() == FigureUtilities
							.RGBToInteger(ColorConstants.white.getRGB())) {
						Command command = new RecordingCommand(domain, "Set Part FillColor") {
							@Override
							protected void doExecute() {
								model.setFillColor(lightBlue);
							}
						};

						if (command.canExecute()) {
							domain.getCommandStack().execute(command);
						}
					}
				}
			}
		}
	}

}
