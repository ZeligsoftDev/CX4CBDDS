/**
 *
 */
package org.eclipse.papyrus.uml.tools.model;

import org.eclipse.papyrus.infra.core.listenerservice.ModelListenerManager;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.IModelSnippet;

/**
 * A snippet registering adapters to the UML model.
 *
 * @author cedric dumoulin
 *
 */
public class UmlSnippet implements IModelSnippet {

	private ModelListenerManager modelListenerManager;

	/**
	 * Register the UML adapters
	 *
	 * @see org.eclipse.papyrus.infra.core.resource.IModelSnippet#start(org.eclipse.papyrus.infra.core.resource.IModel)
	 *
	 * @param startingModel
	 */
	public void start(IModel startingModel) {

		// Modl should be an uml one
		UmlModel umlModel = (UmlModel) startingModel;
		// add adapters
		modelListenerManager = new ModelListenerManager();
		umlModel.getResource().eAdapters().add(modelListenerManager);

	}

	public void dispose(IModel stoppingModel) {
		// Modl should be an uml one
		UmlModel umlModel = (UmlModel) stoppingModel;
		// add adapters
		try {
			if (umlModel.getResource() != null) {
				umlModel.getResource().eAdapters().remove(modelListenerManager);
			}
		} catch (NullPointerException e) {
			// resource is already disposed, or not loaded. Do nothing
		}

	}

}
