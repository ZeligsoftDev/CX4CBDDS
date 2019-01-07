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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;

/**
 * Decorator provider which installs an instance of the MultiplicityDecorator
 * on target which are IPrimaryEditParts and have a Property as their model
 * element.
 * 
 * @author jcorchis
 * 
 */
public class MultiplicityDecoratorProvider extends AbstractProvider implements
		IDecoratorProvider {

	private final String MULTIPLICITY_DECORATOR = "Multiplicity Decorator";//$NON-NLS-1$

	@Override
	public void createDecorators(IDecoratorTarget target) {
		EditPart editPart = (EditPart) target.getAdapter(EditPart.class);
		if (editPart != null && editPart instanceof IPrimaryEditPart) {
			target.installDecorator(MULTIPLICITY_DECORATOR,
					new MultiplicityDecorator(target));
		}

	}

	@Override
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
			return element instanceof Property;
		}

		return false;
	}

}
