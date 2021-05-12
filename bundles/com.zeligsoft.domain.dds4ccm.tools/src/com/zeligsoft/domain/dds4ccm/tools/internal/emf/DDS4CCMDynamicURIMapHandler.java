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

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.pathmap.CXDynamicURIConverter;
import com.zeligsoft.cx.ui.pathmap.CXPathmapDescriptor;
import com.zeligsoft.domain.dds4ccm.tools.Activator;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Dynamic URI mapping handler.
 * 
 * @author Young-Soo Roh
 *
 */
@SuppressWarnings("nls")
public final class DDS4CCMDynamicURIMapHandler {

	
	private static ResourceSet rset = new ResourceSetImpl();
	
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
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IResourceChangeListener rcl = new IResourceChangeListener() {

					@Override
					public void resourceChanged(IResourceChangeEvent event) {
						IResourceDelta delta = event.getDelta();
						if (delta != null) {
							processDelta(rset, delta);
						}
					}
				};
				workspace.addResourceChangeListener(rcl);
				remapDynamicURI();
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	public static void remapDynamicURI() {

		for(CXPathmapDescriptor desc: CXDynamicURIConverter.PATHMAPS.values()) {
			desc.setEnabled(false);
			desc.apply();
		}
		CXDynamicURIConverter.PATHMAPS.clear();
		visitAllModels(ResourcesPlugin.getWorkspace().getRoot(), uri -> processUML(uri));
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
				processUML(uri, delta.getKind());
			}
		} else {
			for (int i = 0; i < children.length; i++) {
				processDelta(rset, children[i]);
			}
		}
	}

	private static void processUML(URI uri) {
		processUML(uri, IResourceDelta.ADDED);
	}

	private static void processUML(URI uri, int deltaKind) {
		Package model = UML2Util.load(rset, uri, UMLPackage.Literals.PACKAGE);
		if (model == null || !ZDLUtil.isZDLProfile(model, "cxDDS4CCM")) {
			return;
		}
		
		// search dynamic pathmap
		String pathmap = CCMUtil.getZCXAnnotationDetail((Element) model, "pathmap", "");
		URI pathmapUri = null;
		if (!UML2Util.isEmpty(pathmap)) {
			pathmapUri = URI.createURI("pathmap" + "://" + pathmap + "/", true);
		}
		if (deltaKind == IResourceDelta.REMOVED) {
			if (pathmapUri != null) {
				// Found pathmap registered so check if there is dependent model
				checkDependentModels(uri);
			}
			CXDynamicURIConverter.removeMapping(uri);
			Resource r = rset.getResource(uri, false);
			if(r != null) {
				r.unload();
			}
			remapDynamicURI();
		} else {
			if (pathmapUri != null) {
				CXDynamicURIConverter.addMapping(pathmapUri, uri);
			}
		}
	}
	
	/**
	 * Check workspace models for dependent model
	 * 
	 * @param uri
	 * @return
	 */
	static boolean checkDependentModels(URI pathmapUri) {
		Set<URI> dependentModels = new HashSet<URI>();
		visitAllModels(ResourcesPlugin.getWorkspace().getRoot(),
				modelUri -> containsReferenceToPathmap(pathmapUri, modelUri, dependentModels));
		if (!dependentModels.isEmpty()) {
			// found dependent models so do something.
			StringBuffer sb = new StringBuffer("Dynamic model library removed: ");
			sb.append(pathmapUri.toString()).append(System.lineSeparator());
			sb.append("Found following dependent model(s) to the model being removed:");
			sb.append(System.lineSeparator()).append(System.lineSeparator());
			for (URI uri : dependentModels) {
				sb.append(uri.toString()).append(System.lineSeparator());
			}
			sb.append(System.lineSeparator());
			sb.append("Validate above model(s) and fix the broken reference(s).");
			Activator.getDefault().warning(sb.toString());
			Display display = PlatformUI.getWorkbench().getDisplay();
			if (display != null) {
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Warning", sb.toString());
					}
				});
			}
		}
		return true;
	}
	
	static void containsReferenceToPathmap(URI pathmapUri, URI modelUri, Set<URI> dependentModels) {
		Package model = UML2Util.load(rset, modelUri, UMLPackage.Literals.PACKAGE);
		if (model == null || !ZDLUtil.isZDLProfile(model, "cxDDS4CCM")) {
			return;
		}
		TreeIterator<EObject> itor = model.eAllContents();
		while (itor.hasNext()) {
			EObject next = itor.next();
			if(!(next instanceof NamedElement)) {
				itor.prune();
			} else {
				EObject type = null;
				if (ZDLUtil.isZDLConcept(next, ZMLMMNames.TYPED_ELEMENT)) {
					type = ZDLUtil.getEValue(next, ZMLMMNames.TYPED_ELEMENT, ZMLMMNames.TYPED_ELEMENT__TYPE);
				} else if (next instanceof Property) {
					Property p = (Property) next;
					type = p.getType();
				}
				if (type != null && type.eResource() != null && type.eResource() != next.eResource()) {
					URI targetUri = URIConverter.INSTANCE.normalize(type.eResource().getURI());
					if (targetUri.equals(pathmapUri)) {
						dependentModels.add(modelUri);
						return;
					}
				}
			}
		}
	}

	/**
	 * Load all UML resources in a folder
	 * 
	 * @param rset
	 * @param container
	 */
	public static void visitAllModels(IContainer container, Consumer<URI> lambda) {
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
					visitAllModels((IContainer) member, lambda);
				} else if (member instanceof IFile) {
					IFile file = (IFile) member;
					String ext = file.getFullPath().getFileExtension();
					if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						lambda.accept(uri);
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
