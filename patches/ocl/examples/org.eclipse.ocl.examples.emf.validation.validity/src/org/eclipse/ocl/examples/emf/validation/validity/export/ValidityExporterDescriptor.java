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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.plugin.ValidityPlugin;

/**
 * Describes an extension as contributed to the validity-exporter extension point.
 */
public class ValidityExporterDescriptor implements IValidityExporterDescriptor {

	/** Configuration element of this descriptor. */
	private final IConfigurationElement element;

	/**
	 * Qualified class name of the exporter extension. This will be used as an
	 * id to remove contributions.
	 */
	private final @NonNull String exporterClassAttribute;

	/**
	 * The name of the exporter extension.
	 */
	private final @NonNull String exporterName;

	/**
	 * The extension attribute of the exporter.
	 */
	private final @NonNull String exporterType;

	/**
	 * We only need to create the instance once, this will keep reference to it.
	 */
	private /*@LazyNonNull*/ IValidityExporter exporter;

	/**
	 * Instantiates a descriptor with all information.
	 * 
	 * @param configuration
	 *            Configuration element from which to create this descriptor.
	 * @param exporterName 
	 * @param exporterType 
	 * @param exporterClassAttribute 
	 */
	public ValidityExporterDescriptor(IConfigurationElement configuration, @NonNull String exporterClassAttribute,
			@NonNull String exporterType, @NonNull String exporterName) {
		this.element = configuration;
		this.exporterClassAttribute = exporterClassAttribute;
		this.exporterType = exporterType;
		this.exporterName = exporterName;
//		exporterClassName = configuration.getAttribute(VALIDITY_EXPORTER_CLASS_ATTRIBUTE);
	}

	/**
	 * Returns this descriptor's "extension" class name.
	 * 
	 * @return This descriptor's "extension" class name.
	 */
//	public @NonNull String getExporterClassName() {
//		return exporterClassName;
//	}

	/**
	 * Returns this descriptor's "extension" name.
	 * 
	 * @return This descriptor's "extension" name.
	 */
	public @NonNull String getExporterType() {
		return exporterType;
	}

	/**
	 * Returns this descriptor's "exporter" extension.
	 * 
	 * @return This descriptor's "exporter" extension.
	 */
	public @NonNull String getExporterName() {
		return exporterName;
	}

	/**
	 * Creates an instance of this descriptor's {@link IValidityExporter}.
	 * 
	 * @return A new instance of this descriptor's {@link IValidityExporter}.
	 */
	public @NonNull IValidityExporter getExporter() {
		IValidityExporter exporter2 = exporter;
		if (exporter2 == null) {
			try {
				exporter = exporter2 = (IValidityExporter) element.createExecutableExtension(exporterClassAttribute);
			} catch (CoreException e) {
				ValidityPlugin.getPlugin().getLog().log(e.getStatus());
			}
		}
		assert exporter2 != null;
		return exporter2;
	}
}
