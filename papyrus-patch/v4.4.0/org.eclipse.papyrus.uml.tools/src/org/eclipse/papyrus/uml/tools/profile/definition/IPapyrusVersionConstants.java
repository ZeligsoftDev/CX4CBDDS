/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.profile.definition;

/**
 * Constant fields for papyrus profile version
 */
public interface IPapyrusVersionConstants {

	/** source for eAnnotation that qualifies the profile definition */
	public final String PAPYRUS_EANNOTATION_SOURCE = "PapyrusVersion";

	/** key for version detail */
	public final String PAPYRUS_VERSION_KEY = "Version";

	/** key for author detail */
	public final String PAPYRUS_AUTHOR_KEY = "Author";

	/** key for copyright detail */
	public final String PAPYRUS_COPYRIGHT_KEY = "Copyright";

	/** key for date detail */
	public final String PAPYRUS_DATE_KEY = "Date";

	/** key for comment detail */
	public final String PAPYRUS_COMMENT_KEY = "Comment";

}
