/*******************************************************************************
 * Copyright (c) 2005, 2013 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.expression;

/**
 * A ResourceManager is responsible for loading Xpand related resources.
 */
public interface ResourceManager {

	/**
	 * Loads a resource.
	 * 
	 * @param fullyQualifiedName
	 *            Resource path
	 * @param extension
	 *            Valid Xpand extension (xpt,ext,chk)
	 * @return The loaded resource
	 */
	Resource loadResource(String fullyQualifiedName, String extension);

	/**
	 * Sets the encoding the ResourceManager should use to load resources.
	 * 
	 * @param fileEncoding
	 *            Valid file encoding
	 */
	void setFileEncoding(String fileEncoding);

	/**
	 * Registers a ResourceParser to the manager.
	 * 
	 * @param extension
	 *            Xpand file extension (xpt,ext,chk)
	 * @param parser
	 *            The parser for the resource type
	 */
	void registerParser(String extension, ResourceParser parser);
}
