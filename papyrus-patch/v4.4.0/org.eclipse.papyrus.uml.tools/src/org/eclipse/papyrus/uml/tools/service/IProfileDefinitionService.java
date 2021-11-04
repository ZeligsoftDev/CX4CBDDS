/*****************************************************************************
 * Copyright (c) 2018 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.service;

import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.uml2.uml.Profile;

/**
 * 
 * Definition of Profile Definition service.
 * 
 * @author Gabriel Pascual
 * @since 4.1
 */
public interface IProfileDefinitionService {

	/**
	 * Get associated marker of Profile.
	 * 
	 * @param profile
	 *            Profile which have to decorate or which is already decorate.
	 * @return Existing marker or create one.
	 */
	IPapyrusMarker getMarker(Profile profile);

	/**
	 * Dispose marker on Profile.
	 * 
	 * @param profile
	 *            Profile which is decorated.
	 */
	void disposeMarker(Profile profile);

}
