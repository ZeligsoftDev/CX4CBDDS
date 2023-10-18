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

import org.eclipse.jdt.annotation.NonNull;

/**
 * This interface defines the general contract of the validity results export mechanism.
 * <p>
 * Clients may also extends AbstractExport instead.
 * </p>
 */
public interface IValidityExporterDescriptor
{	
	@NonNull IValidityExporter getExporter();
	@NonNull String getExporterType();
}
