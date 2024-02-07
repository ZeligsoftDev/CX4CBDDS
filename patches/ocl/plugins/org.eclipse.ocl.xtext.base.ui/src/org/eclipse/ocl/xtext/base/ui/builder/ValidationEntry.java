/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.builder.nature.XtextNature
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.builder;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.ui.builder.MultiValidationJob.MarkerData;

/**
 * A ValidationEntry identifies an IFile to be validated and the Marker id for its problems.
 */
public class ValidationEntry
{
	protected final @NonNull IFile file;
	protected final @NonNull String markerId;

	/**
	 * The results of the validation, assigned non-null after validation completes.
	 */
	private @Nullable List<@NonNull MarkerData> markerDatas = null;

	/**
	 * The failure of the validation, assign non-null on failure.
	 */
	private @Nullable Throwable throwable = null;

	public ValidationEntry(@NonNull IFile file, @NonNull String markerId) {
		this.file = file;
		this.markerId = markerId;
	}

	public @NonNull OCL createOCL() {
		ASResourceFactoryRegistry registry = ASResourceFactoryRegistry.INSTANCE;
		String fileExtension = file.getFileExtension();
		ASResourceFactory asResourceFactory = registry.getASResourceFactoryForExtension(fileExtension);
		if (asResourceFactory instanceof ASResourceFactory.ASResourceFactoryExtension2) {
			EnvironmentFactory environmentFactory = ((ASResourceFactory.ASResourceFactoryExtension2)asResourceFactory).createEnvironmentFactory(ProjectManager.CLASS_PATH);
			return environmentFactory.createOCL();
		}
		return OCL.newInstance(ProjectManager.CLASS_PATH);
	}

	public void deleteMarkers() throws CoreException {
		file.deleteMarkers(markerId, true, IResource.DEPTH_ZERO);
	}

	public @NonNull IFile getFile() {
		return file;
	}

	public @Nullable List<@NonNull MarkerData> getMarkerDatas() {
		return markerDatas;
	}

	public @NonNull String getMarkerId() {
		return markerId;
	}

	public @Nullable Throwable getThrowable() {
		return throwable;
	}

	public void setMarkerDatas(@NonNull List<@NonNull MarkerData> markerDatas) {
		this.markerDatas = markerDatas;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	@Override
	public String toString() {
		return file + " => " + markerId;
	}
}
