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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * This will contain all ocl-export extension that have been parsed from the
 * extension point.
 */
public class ValidityExporterRegistry
{
	public static final @NonNull ValidityExporterRegistry INSTANCE = new ValidityExporterRegistry();

	public static void initialize(@NonNull ValidityExporterRegistry registry) {
		registry.addExporter(HTMLExporter.INSTANCE);
		registry.addExporter(ModelExporter.INSTANCE);
		registry.addExporter(TextExporter.INSTANCE);
	}
	
	/** List of extensions created from the extension point contributions. */
	private final Map<String, IValidityExporterDescriptor> EXTENSIONS = new HashMap<String, IValidityExporterDescriptor>();

	/**
	 * Utility classes don't need a default constructor.
	 */
	private ValidityExporterRegistry() {
		// hides constructor
	}

	/**
	 * Adds an extension to the registry.
	 * 
	 * @param exporter
	 */
	public void addExporter(@NonNull IValidityExporterDescriptor exporter) {
		EXTENSIONS.put(exporter.getExporterType(), exporter);
	}

	/**
	 * Removes all extensions from the registry. This will be called at plugin
	 * stopping.
	 */
	public void clearRegistry() {
		EXTENSIONS.clear();
	}

	public @Nullable IValidityExporter getExporter(@NonNull String exporterType) {
		IValidityExporterDescriptor exporter = EXTENSIONS.get(exporterType);
		return exporter != null ? exporter.getExporter() : null;
	}

	/**
	 * Returns a copy of the registered extensions list.
	 * 
	 * @return A copy of the registered extensions list.
	 */
	public Collection<IValidityExporterDescriptor> getRegisteredExtensions() {
		return EXTENSIONS.values();
	}

	/**
	 * Removes a phantom from the registry.
	 * 
	 * @param exporterType
	 */
	public void removeExtension(@NonNull String exporterType) {
		EXTENSIONS.remove(exporterType);
	}
}
