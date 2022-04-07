/*****************************************************************************
 * Copyright (c) 2012, 2014 Atos Origin, CEA, and others.
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
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;

@SuppressWarnings("rawtypes")
public class ReadOnlyAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (((IReadOnlyHandler.class == adapterType) || (IReadOnlyHandler2.class == adapterType)) && (adaptableObject instanceof EditingDomain)) {
			return ReadOnlyManager.getReadOnlyHandler((EditingDomain) adaptableObject);
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { EditingDomain.class };
	}
}
