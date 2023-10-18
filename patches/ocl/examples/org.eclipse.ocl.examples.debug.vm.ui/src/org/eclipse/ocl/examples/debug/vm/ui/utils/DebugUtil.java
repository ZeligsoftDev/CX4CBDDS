/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintOptions;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.URIUtil;

public class DebugUtil
{
	public static @NonNull URI createDebugDocument(@NonNull EnvironmentFactory environmentFactory, @Nullable EObject contextObject, @NonNull String expression, IProgressMonitor monitor) throws CoreException, IOException {
		IdResolver idResolver = environmentFactory.getIdResolver();
		org.eclipse.ocl.pivot.Class staticType = idResolver.getStaticTypeOfValue(null, contextObject);
		org.eclipse.ocl.pivot.Class contextType = environmentFactory.getMetamodelManager().getPrimaryClass(staticType);
		//			if (contextType instanceof Metaclass) {
		//				contextType = (org.eclipse.ocl.pivot.Class)((Metaclass<?>)contextType).getInstanceType();	// FIXME cast
		//			}
		org.eclipse.ocl.pivot.Package contextPackage = contextType.getOwningPackage();
		IPath documentPath = DebugVMUIPlugin.getDefault().getStateLocation().append("debug" + EcoreUtil.generateUUID() + ".ocl");
		IFileStore documentStore = EFS.getLocalFileSystem().getStore(documentPath);
		OutputStream documentStream = documentStore.openOutputStream(0, monitor);
		PrettyPrintOptions.Global printOptions = PrettyPrinter.createOptions(null);
		printOptions.addReservedNames(PrettyPrinter.restrictedNameList);
		Writer s = new OutputStreamWriter(documentStream);
		URI externalURI = null;
		if (contextPackage != null) {
			Model containingRoot = PivotUtil.getContainingModel(contextPackage);
			if (containingRoot == null) {
				externalURI = URI.createURI(contextPackage.getURI());
			}
			else if (containingRoot != PivotUtil.getContainingModel(environmentFactory.getStandardLibrary().getOclAnyType())) {
				externalURI = URI.createURI(containingRoot.getExternalURI());
				externalURI = URIUtil.getNonASURI(externalURI);
			}
			if (externalURI != null) {
				externalURI = URIUtil.getAbsoluteOrPlatformURI(externalURI);
				s.append("import '" + externalURI + "'\n\n");
			}
		}
		s.append("context ");
		if (externalURI == null) {
			s.append("ocl::");			// FIXME use printOptions, FIXME support UML non-OCL classes
		}
		s.append(PrettyPrinter.printName(contextType, printOptions) + "\n");
		s.append("def: oclDebuggerExpression() : OclAny = \n\t");
		s.append(expression.replace("\n", "\n\t"));
		s.append("\n");
		s.close();
		java.net.URI documentURI1 = documentStore.toURI();
		@NonNull URI documentURI2 = URI.createURI(documentURI1.toString());
		return documentURI2;
	}
}
