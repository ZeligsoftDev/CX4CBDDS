/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Profile Migration Diagnostic class to mark resources that have been migrated and provide a message for
 * successful migration (warning) and failed migration (error).
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public class ProfileMigrationDiagnostic implements Resource.Diagnostic {

	/**
	 * Message containing information about this diagnostic.
	 */
	private String message;

	/**
	 * Creates a new diagnostic with the given message.
	 * 
	 * @param message
	 *            diagnostic message
	 */
	public ProfileMigrationDiagnostic(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getLocation() {
		return null;
	}

	public int getLine() {
		return 0;
	}

	public int getColumn() {
		return 0;
	}

}
