package com.zeligsoft.domain.idl3plus.ui.internal.editpolicies;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.decorator.DecoratorService;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.papyrus.uml.diagram.common.providers.ValidationDecoratorProvider.StatusDecorator;

/**
 * Decoration service to address Issue #248
 * 
 * @author Young-Soo Roh
 *
 */
@SuppressWarnings("restriction")
public class InterfacePortDecorationEditPolicy extends DecorationEditPolicy {

	@SuppressWarnings("rawtypes")
	@Override
	public void refresh() {
		if (decorators == null) {
			decorators = new HashMap();
			DecoratorService.getInstance().createDecorators(new DecoratorTarget());
		}
		for (Iterator iter = decorators.values().iterator(); iter.hasNext();) {
			IDecorator decorator = (IDecorator) iter.next();
			if (decorator instanceof StatusDecorator) {
				// skip this one to avoid permanent arrow image on the port
				continue;
			}
			decorator.refresh();
		}
	}
}
