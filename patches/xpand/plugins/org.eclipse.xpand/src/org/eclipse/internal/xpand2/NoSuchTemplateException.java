/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xpand2;

/**
 * Indicates that a qualified template cannot be found.
 */
public class NoSuchTemplateException extends RuntimeException {

	private static final long serialVersionUID = -6939510590247142812L;

	/**
	 * Creates an instance.
	 * @param fullyQualifiedName Qualified name of the template.
	 */
	public NoSuchTemplateException(final String fullyQualifiedName) {
		super("Couldn't find template : " + fullyQualifiedName);
	}

}
