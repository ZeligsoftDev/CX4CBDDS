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
package org.eclipse.ocl.pivot.utilities;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;

/**
 * @since 1.4
 */
public class URIUtil
{
	public static final URI PLATFORM_RESOURCE = URI.createPlatformResourceURI("/", false);

	/**
	 * Return fullURI deresolved wrt baseURI. Tnis just invokes fullURI.deresolve(baseURI) except
	 * that platform:/x/y/... URIs are preserved as is unless both x and y aare shared. This avoids
	 * references that migrate between projects in ways that tooling may not have initialized.
	 */
	public static @NonNull URI deresolve(@NonNull URI fullURI, URI baseURI) {
	    return deresolve(fullURI, baseURI, true, false, true);
	}
	public static @NonNull URI deresolve(@NonNull URI fullURI, @Nullable URI baseURI, boolean preserveRootParents, boolean anyRelPath, boolean shorterRelPath) {
		if (baseURI == null) {
			return fullURI;
		}
		if (fullURI.isPlatform() && baseURI.isPlatform()) {
			String[] segments1 = fullURI.segments();
			String[] segments2 = baseURI.segments();
			if ((segments1.length < 2) || (segments2.length < 2)) {
				return fullURI;
			}
			if (!segments1[0].equals(segments2[0]) || !segments1[1].equals(segments2[1])) {
				return fullURI;
			}
		}
		return fullURI.deresolve(baseURI, preserveRootParents, anyRelPath, shorterRelPath);
	}

	/**
	 * Convert uri to a form whereby it can be resolved relocatably within Eclipse.
	 */
	public static @NonNull URI getAbsoluteOrPlatformURI(@NonNull URI uri) {
		@SuppressWarnings("unused") boolean isHierarchical = uri.isHierarchical();
		@SuppressWarnings("unused") boolean isPlatform = uri.isPlatform();
		@SuppressWarnings("unused") boolean isRelative = uri.isRelative();
		if (uri.isRelative()) {
			return URI.createPlatformResourceURI(uri.toString(), true);
		}
		return uri;
	}

	/**
	 * Convert the naively created uri to that an implicit file: scheme is explicit to facilitate standalone usage.
	 *
	 * @since 1.18
	 */
	public static @NonNull URI getAbsoluteURI(@NonNull URI rawURI) {
		assert !rawURI.hasFragment();
	//	System.out.println("rawURI = " + rawURI);
	//	System.out.println("rawURI.hasAbsolutePath() = " + rawURI.hasAbsolutePath());
	//	System.out.println("rawURI.hasOpaquePart() = " + rawURI.hasOpaquePart());
	//	System.out.println("rawURI.hasPath() = " + rawURI.hasPath());
	//	System.out.println("rawURI.hasRelativePath() = " + rawURI.hasRelativePath());
	//	System.out.println("rawURI.isHierarchical() = " + rawURI.isHierarchical());
		URI absoluteURI;
		if (rawURI.hasOpaquePart()) {							// Windows absolute path such as c:/xxx
			String string2 = rawURI.toString();
			absoluteURI = URI.createFileURI(string2);
		}
		else if (rawURI.isPlatform()) {							// platform: must be left unchnaged
			absoluteURI = rawURI;
		}
		else if (rawURI.hasRelativePath()) {					// not-absolute
			String fileString = rawURI.toFileString();
			File relative = new File(fileString);
			File absolute = relative.getAbsoluteFile();
			absoluteURI = URI.createFileURI(absolute.toString());
		}
		else if (rawURI.hasAbsolutePath()) {					// Linux absolute path such as /xxx
			String fileString = rawURI.toString();
			absoluteURI = URI.createFileURI(fileString);
		}
		else {													// Perhaps file: already
			absoluteURI = rawURI;
		}
	//	System.out.println("absoluteURI = " + absoluteURI);
		return absoluteURI;
	}

	/**
	 * If uri is for an AS resource, return is non-AS equivalent. Otherwise just return uri.
	 */
	public static @NonNull URI getNonASURI(@NonNull URI uri) {
		if (PivotUtilInternal.isASURI(uri)) {
			uri = PivotUtilInternal.getNonASURI(uri);
		}
		return uri;
	}

	/**
	 * Return the Eclipse IFile corresponding to a URI
	 */
	public static @Nullable IFile getResolvedFile(@NonNull URI uri) {
		if (uri.isHierarchical()) {
			if (uri.isRelative() || (uri = uri.deresolve(PLATFORM_RESOURCE)).isRelative()) {
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				IFile file = workspaceRoot.getFile(new Path(uri.toString()));
				return file;
			}
		}
		return null;
	}
}
