/*****************************************************************************
 * Copyright (c) 2011 Atos
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
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *  Philippe Roland (Atos) philippe.roland@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.matching;

/**
 * This interface can be implemented by facet objects to offer access to
 * an underlying object. This referenced object will be used in the matching algo
 * when using the synchronize feature for example.
 *
 * @author proland
 *
 */
public interface IReferencable {

	public Object getElementBehind();
}
