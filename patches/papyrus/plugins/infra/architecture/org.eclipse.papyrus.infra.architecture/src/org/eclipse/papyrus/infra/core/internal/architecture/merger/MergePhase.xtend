/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger

/**
 * Which phase of the multi-phase merge algorithm is happening.
 */
package enum MergePhase {
	/** Not yet processing anything. */
	NOT_STARTED,
	/** Processing context inheritance. */
	INHERITANCE,
	/** Inferring implicit extensions for legacy merge support. */
	LEGACY,
	/** Processing context extensions. */
	EXTENSIONS,
	/** Finished */
	DONE;
}
