package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.uml.tools.Activator;

public abstract class AbstractUMLValidator implements IValidator {


	protected String pluginId;


	protected IStatus error(String message) {
		return new Status(IStatus.ERROR, getPluginId(), message);
	}

	public String getPluginId() {
		if (pluginId == null) {
			return Activator.PLUGIN_ID;
		} else {
			return pluginId;
		}
	}

	protected IStatus warning(String message) {
		return new Status(IStatus.WARNING, getPluginId(), message);
	}


}
