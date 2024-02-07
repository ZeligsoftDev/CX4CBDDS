/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class MarkupLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public MarkupLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

/*
	//Labels and icons can be computed like this:

	String text(MyModel ele) {
	  return "my "+ele.getName();
	}

    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
