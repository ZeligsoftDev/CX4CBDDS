/*****************************************************************************
 * Copyright (c) 2011, 2013 Atos Origin, CEA, and others.
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
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Deprecate the current API to support non-filesystem storage. (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @deprecated Implement the {@link org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler} protocol, instead.
 */
@Deprecated
public interface IReadOnlyHandler {

	/**
	 * Check if a set of files is read-only.
	 * A set of files is usually considered read-only if at least
	 * one of them is read only.
	 *
	 * @param files
	 * @return
	 */
	boolean isReadOnly(URI[] uris, EditingDomain editingDomain);

	/**
	 * Try to enable write access on a set of files.
	 *
	 * @param files
	 * @return false if it fails to get write access.
	 */
	boolean enableWrite(URI[] uris, EditingDomain editingDomain);
}
