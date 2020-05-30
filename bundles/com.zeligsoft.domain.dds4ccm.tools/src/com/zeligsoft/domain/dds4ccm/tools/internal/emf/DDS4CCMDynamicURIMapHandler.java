/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.tools.internal.emf;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;

/**
 * Dynamic URI mapping handler.
 * 
 * @author Young-Soo Roh
 *
 */
public final class DDS4CCMDynamicURIMapHandler {

	/**
	 * Initializes me.
	 */
	private DDS4CCMDynamicURIMapHandler() {
		super();
	}

	public static void remap() {
		new UIJob("Updating Workspace URI mappings") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				doRemap();
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private static void doRemap() {

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener rcl = new IResourceChangeListener() {

			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta delta = event.getDelta();
				if (delta != null) {
					ResourceSet rset = new ResourceSetImpl();
					processDelta(rset, delta);
				}
			}
		};
		workspace.addResourceChangeListener(rcl);
		ResourceSet rset = new ResourceSetImpl();
		visitAllModels(rset, ResourcesPlugin.getWorkspace().getRoot());
	}

	private static void processDelta(ResourceSet rset, IResourceDelta delta) {
		IResourceDelta[] children = delta.getAffectedChildren();
		if (children.length == 0) {
			// check if this is a uml file
			IPath path = delta.getFullPath();
			String ext = path.getFileExtension();
			if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())
					&& (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.REMOVED)) {
				URI uri = URI.createPlatformResourceURI(path.toString(), false);
				processUML(rset, uri, delta.getKind());
			}
		} else {
			for (int i = 0; i < children.length; i++) {
				processDelta(rset, children[i]);
			}
		}
	}

	private static void processUML(ResourceSet rset, URI uri) {
		processUML(rset, uri, IResourceDelta.ADDED);
	}

	private static void processUML(ResourceSet rset, URI uri, int deltaKind) {
		if (deltaKind == IResourceDelta.REMOVED) {
			CXDynamicURIConverter.removeMapping(uri);
			return;
		}
		Package model = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
		if (model != null && ZDLUtil.isZDLProfile(model, "cxDDS4CCM")) {
			// enable new URI mapping
			String pathmap = CCMUtil.getZCXAnnotationDetail((Element) model, "pathmap", "");
			if (!UML2Util.isEmpty(pathmap)) {
				String modelName = model.eResource().getURI().lastSegment();
				URI targetURI = model.eResource().getURI().trimSegments(1).appendSegment("");
				URI sourceURI = URI.createURI("pathmap" + "://" + pathmap + "/", true);
				CXDynamicURIConverter.addMapping(sourceURI, targetURI, modelName);
			}
		}
	}

	/**
	 * Load all UML resources in a folder
	 * 
	 * @param rset
	 * @param container
	 */
	public static void visitAllModels(ResourceSet rset, IContainer container) {
		try {
			IResource[] members = container.members();

			for (IResource member : members) {
				if (member instanceof IProject) {
					if (!((IProject) member).isOpen()) {
						// Ignore closed projects
						continue;
					}
				}
				if (member instanceof IContainer) {
					visitAllModels(rset, (IContainer) member);
				} else if (member instanceof IFile) {
					IFile file = (IFile) member;
					String ext = file.getFullPath().getFileExtension();
					if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						processUML(rset, uri);
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
