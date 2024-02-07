/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.ui.labeling.BaseLabelProvider;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;

import com.google.inject.Inject;

/**
 * Provides labels for OCLstdlibCS objects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class OCLstdlibLabelProvider extends BaseLabelProvider {

	@Inject
	public OCLstdlibLabelProvider(@NonNull AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

    String image(JavaClassCS ele) {
      return "/org.eclipse.ocl.xtext.oclstdlib.ui/icons/class_obj.gif";
    }
}
