/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * This interface adds 2 methods to allow to the content provider to ignore or not the properties base_ExtendedMetaclass
 * in the stereotype properties
 *
 * @author Vincent Lorenzo
 *
 */
public interface IIgnoreStereotypeBasePropertyContentProvider extends IStructuredContentProvider {

	/**
	 *
	 * @param ignoreBaseProperty
	 *            the new value to use for the content provider. if <code>true</code> the base properties won't be returned
	 */
	public void setIgnoreBaseProperty(final boolean ignoreBaseProperty);

	/**
	 *
	 * @return
	 *         <code>true</code> if the content provider doesn't return the base properties
	 */
	public boolean isIgnoringBaseProperty();
}
