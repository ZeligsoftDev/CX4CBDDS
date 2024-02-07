/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;

public class BaseOutlineNodeElementOpener extends OutlineNodeElementOpener
{
	@Override
	protected void openEObject(EObject state) {
		if (state instanceof Element) {
			ElementCS csElement = ElementUtil.getCsElement((Element)state);
			if (csElement != null) {
				state = csElement;
			}
		}
		super.openEObject(state);
	}
}
