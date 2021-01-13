/**
 * Copyright 2021 Northrop Grumman Systems Corporation.
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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.geoshapes.internal.editparts.GeoShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Shape;

/**
 * Decorator for geometric shapes to disable gradient feature
 * 
 * @author ysroh
 * 
 */
@SuppressWarnings("restriction")
public class GeoShapePartDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	private final String GEOSHAPE_DECORATOR = "GeoShape Decorator";//$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider
	 * #createDecorators
	 * (org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 */
	public void createDecorators(IDecoratorTarget target) {
		EditPart editPart = (EditPart) target.getAdapter(EditPart.class);
		if (editPart != null && editPart instanceof IPrimaryEditPart) {
			target.installDecorator(GEOSHAPE_DECORATOR, new GeoShapeDecorator(target));
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

		EditPart targetPart = ((CreateDecoratorsOperation) operation).getDecoratorTarget().getAdapter(EditPart.class);

		return (targetPart instanceof GeoShapeEditPart);
	}

	/**
	 * Geo Shape decorator class
	 * 
	 * @author ysroh
	 * 
	 */
	public static class GeoShapeDecorator extends AbstractDecorator {

		public GeoShapeDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		public void activate() {
			refresh();
		}

		public void refresh() {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			final Shape model = (Shape) editPart.getModel();
			EObject element = (EObject) getDecoratorTarget().getAdapter(EObject.class);
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(element);
			
			if (model.getGradient() != null && !domain.isReadOnly(element.eResource())) {

				Command command = new RecordingCommand(domain, "Deactivate Gradient") {
					@Override
					protected void doExecute() {
						// disable gradient feature
						model.setGradient(null);
					}
				};

				if (command.canExecute()) {
					domain.getCommandStack().execute(command);
				}
			}
		}
	}

}
