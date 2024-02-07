/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *  Obeo - Add new Icon for disabled Nodes
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.view;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.Severity;
import org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.swt.graphics.Image;

public class SeveritiesDecorator extends SideBySideImageDecorator
{
	public static Object getSeverityImage(Object element) {
		String imageName = "query.gif";
		Result worstResult = ((AbstractNode)element).getWorstResult();
		Severity worst = worstResult != null ? worstResult.getSeverity() : Severity.UNKNOWN;
		switch (worst) {
			case UNKNOWN: imageName = "disabled_ovr.gif"; break;
			case OK: imageName = "success_ovr.gif"; break;
			case INFO: imageName = "info_ovr.gif"; break;
			case WARNING: imageName = "warning_ovr.gif"; break;
			case ERROR: imageName = "error_ovr.gif"; break;
			case FATAL: imageName = "failed_ovr.gif"; break;
			default: imageName = "unknown_ovr.gif"; break;
		}
		Object image2 = ValidityUIPlugin.INSTANCE.getImage(imageName);
		return image2;
	}

	protected final @NonNull IDEValidityManager validityManager;
	
	public SeveritiesDecorator(@NonNull IDEValidityManager validityManager) {
		super(1);
		this.validityManager = validityManager;
	}

	public Image decorateImage(Image image, Object element) {
		Object image2 = getSeverityImage(element);
		return composeImages(image, image2);
	}

	public List<Result> getResults(Object element) {
		if (element instanceof ConstrainingNode) {
			return validityManager.getConstrainingNodeResults((ConstrainingNode)element);
		}
		else if (element instanceof ValidatableNode) {
			return validityManager.getValidatableNodeResults((ValidatableNode)element);
		}
		else {
			return Collections.emptyList();
		}
	}
}
