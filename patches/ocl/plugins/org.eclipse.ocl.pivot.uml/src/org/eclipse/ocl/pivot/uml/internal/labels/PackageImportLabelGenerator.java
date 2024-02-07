/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.uml.internal.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.uml2.uml.PackageImport;

public final class PackageImportLabelGenerator extends AbstractLabelGenerator<PackageImport>
{
	public static void initialize(Registry registry) {
		registry.install(PackageImport.class, new PackageImportLabelGenerator());		
	}
	
	public PackageImportLabelGenerator() {
		super(PackageImport.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull PackageImport object) {
		org.eclipse.uml2.uml.Package importedPackage = object.getImportedPackage();
		String name = importedPackage != null ? importedPackage.getName() : null;
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-packaged-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}