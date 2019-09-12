package com.zeligsoft.domain.cbdds.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Port;

import com.zeligsoft.domain.cbdds.ui.decorators.PortDecorator;

public class PortDecoratorProvider extends AbstractProvider implements IDecoratorProvider {
	private static final String GMF_DECORATION_KEY = "PortDecoration"; //$NON-NLS-1$

	@Override
	public boolean provides(IOperation operation) {
		boolean provide = false;

		EObject referenceElement = ((CreateDecoratorsOperation) operation).getDecoratorTarget()
				.getAdapter(EObject.class);

		// Test Element should be a CapsulePart
		if (referenceElement instanceof Port) {
			provide = true;

		} else {
			provide = false;
		}
		return provide;
	}

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		// TODO Auto-generated method stub
		final View node = decoratorTarget.getAdapter(View.class);
		if (node != null) {
			// Install the decorator
			decoratorTarget.installDecorator(GMF_DECORATION_KEY, new PortDecorator(decoratorTarget));
		}
	}
}