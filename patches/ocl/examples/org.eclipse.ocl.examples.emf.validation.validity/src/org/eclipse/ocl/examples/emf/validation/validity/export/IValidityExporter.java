/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.export;

import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;

/**
 * This interface defines the general contract of the validity results export mechanism.
 * <p>
 * Clients may also extends AbstractExport instead.
 * </p>
 */
public interface IValidityExporter extends IValidityExporterDescriptor
{
	/**
	 * Export the validity results and return String containing the results.
	 * 
	 * @param rootNode
	 *            The Root Node to export
	 * @param fileName
	 * 			The target file name or null if not known and not to be reported
	 */
	@NonNull String export(@NonNull RootNode rootNode, @Nullable String fileName);

	/**
	 * Export the validity results to an Appendable.
	 * 
	 * @param s
	 *            The appendable
	 * @param rootNode
	 *            The Root Node to export
	 * @param exportedFileName
	 * 			The target file name or null if not known and not to be reported
	 * @throws IOException 
	 */
	void export(@NonNull Appendable s, @NonNull RootNode rootNode, @Nullable String exportedFileName) throws IOException;

	@Nullable String getPreferredExtension();
}
