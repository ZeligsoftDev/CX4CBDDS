/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences.impl;

import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * Label provider for {@link IItemDescriptor}.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class ItemDescriptorLabelProvider extends LabelProvider {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IItemDescriptor<?>) {
			IItemDescriptor<?> desc = (IItemDescriptor<?>)element;
			return desc.getLabel();
		}
		return super.getText(element);
	}
}
