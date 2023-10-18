/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation 
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.RootNode;
import org.eclipse.ocl.pivot.utilities.XMIUtil;

/**
 * Exports validation results as a model.
 */
public class ModelExporter extends AbstractExporter
{
	public static final @NonNull String EXPORTER_TYPE = "model";
	public static final @NonNull ModelExporter INSTANCE = new ModelExporter();

	/**
	 * Returns a stream containing the initial contents to be given to new
	 * exported validation results file resource instances.
	 * 
	 * @throws IOException 
	 */
	@Override
	public void createContents(@NonNull Appendable text, @NonNull RootNode rootNode, @Nullable String exportedFileName) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		Resource resource = new XMIResourceImpl(URI.createFileURI(exportedFileName));
		resource.getContents().add(rootNode);
		Map<Object, Object> saveOptions = XMIUtil.createSaveOptions();
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		resource.save(os, saveOptions);
		os.close();
		text.append(os.toString());
	}
	
	public @NonNull String getExporterType() { return EXPORTER_TYPE; }

	@Override
	public @NonNull String getPreferredExtension() { return "validity"; }
}
