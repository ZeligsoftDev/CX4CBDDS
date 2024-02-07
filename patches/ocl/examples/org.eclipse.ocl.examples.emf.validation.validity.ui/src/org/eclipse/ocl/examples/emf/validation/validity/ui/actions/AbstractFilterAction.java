/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.actions;

import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.emf.validation.validity.ui.plugin.ValidityUIPlugin;
import org.eclipse.ocl.examples.emf.validation.validity.ui.view.ValidityView;

public abstract class AbstractFilterAction extends Action
{
	protected final @NonNull ValidityView validityView;
	protected final boolean isValidatableAction;
	
	public AbstractFilterAction(String text, int style, @NonNull ValidityView validityView, boolean isValidatableAction) {
		super(text, style);
		this.validityView = validityView;
		this.isValidatableAction = isValidatableAction;
	}

	protected void setImage(String imageLocation) {
		URL imageURL = (URL) ValidityUIPlugin.INSTANCE.getImage(imageLocation);
		setImageDescriptor(ImageDescriptor.createFromURL(imageURL));
	}
}
