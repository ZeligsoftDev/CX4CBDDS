/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.labels;

import java.io.File;
import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

/**
 * @since 1.3
 */
public final class FileLabelGenerator extends AbstractLabelGenerator<File>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(File.class, new FileLabelGenerator());
	}

	public FileLabelGenerator() {
		super(File.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull File object) {
		try {
			labelBuilder.appendObject(object.getCanonicalPath());
		} catch (IOException e) {
			labelBuilder.appendObject(object.toString());
		}
	}
}