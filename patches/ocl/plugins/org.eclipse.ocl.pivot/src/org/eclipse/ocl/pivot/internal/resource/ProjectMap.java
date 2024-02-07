/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.compatibility.EMF_2_9;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.URIUtil;

/**
 * ProjectMap extends {@link ProjectManager} to support polymorphic access in either plugin or standalone environments
 * to EMF resources and EPackages.
 *
 *<h4>Plugin Environment</h4>
 *
 * A resolvable location is perhaps <tt>platform:/plugin/org.antlr.runtime/</tt> for a bundle or
 * <tt>platform:/resource/org.eclipse.ocl.domain/</tt> for an open project.
 * <p>
 * {@link #getProjectDescriptors()} returns a map of project names, but not bundle names, to resolvable location.
 * <p>
 * {@link #initializePackageRegistry(ResourceSet)} augments the default EMF startup in a plugin environment
 * whereby the global package registry acquires a registration for each namespace URI
 * (e.g. <tt>http://www.eclipse.org/emf/2002/Ecore</tt>) defined by the
 * <tt>org.eclipse.emf.ecore.generated_package</tt> extension point in plugins.
 * The standard reguistration is auugmented where appropriate, by two further registrations for
 * the project URI (e.g. <tt>platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore</tt>) and the plugin URI
 * (e.g. <tt>platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore</tt>). These extra registrations
 * derived from the <tt>genPackages.ecorePackage</tt> referenced by the <tt>genmodel</tt>
 * <tt>org.eclipse.emf.ecore.generated_package</tt> declarations ensure that all three URIs resolve to
 * the same Resource eliminating most opportunities for meta-model schizophrenia.
 * <p>
 * {@link #initializePlatformResourceMap(boolean)} does nothing since the standard EMF Platform URI Handler
 * can open platform resources directly.
 * <p>
 * {@link #initializeGenModelLocationMap(boolean)} does nothing, since the standard EMF startup in a
 * plugin environment populates the {@link EcorePlugin#getEPackageNsURIToGenModelLocationMap()}.
 * <p>
 * {@link #initializeURIMap(ResourceSet)} installs explicit URI mappings into the {@link URIConverter}
 * so that for each project so that both <tt>platform:/resource/project</tt> and
 * <tt>platform:/plugin/<i>project</i></tt> reference <tt>platform:/resource/<i>project</i></tt>. An additional
 * backstop URI mapping redirects <tt>platform:/resource</tt> to <tt>platform:/plugin</tt>.
 * <p>
 * The explicit mapping ensures that projects are accessible as either
 * <tt>platform:/resource/<i>project</i></tt> or <tt>platform:/plugin/<i>project</i></tt>.
 * The backstop mapping ensures that plugins, that are not occluded by projects, are
 * accessible as <tt>platform:/plugin/<i>project</i></tt> or
 * <tt>platform:/resource/<i>project</i></tt>, without needing to create an
 * explicit URI map entry for each of the many hundreds of bundles in typical use.
 *
 * A global ProjectMap tracks workpsace project changes to synchronize the known open projects and the list
 * of IProjectDescriptor. This ensures that when the global ProjectMap initializes a ResourceSet it uses
 * the prevailing open projects. It does not update previously initialized ResourceSets.
 */
public class ProjectMap extends StandaloneProjectMap implements IResourceChangeListener, IResourceDeltaVisitor
{
	/**
	 * @since 1.7
	 */
	public static final @NonNull TracingOption PROJECT_MAP_RESOURCE_CHANGE = new TracingOption(PivotPlugin.PLUGIN_ID, "projectMap/resourceChange");

	public static class ProjectDescriptor extends StandaloneProjectMap.ProjectDescriptor
	{
		public ProjectDescriptor(@NonNull ProjectMap projectMap, @NonNull String name, @NonNull URI locationURI) {
			super(projectMap, name, locationURI);
		}

		@Override
		protected @NonNull URI getResolvedGenModelURI(@NonNull IResourceDescriptor resourceDescriptor) {
			URI genModelURI = resourceDescriptor.getGenModelURI();
			return genModelURI.resolve(getLocationURI());
		}

		@Override
		public void initializeURIMap(@NonNull Map<URI, URI> uriMap) {
			if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
				super.initializeURIMap(uriMap);
			}
			else {
				if (locationURI.isPlatformResource()) {
					URI resourceURI = locationURI;
					URI pluginURI = getPlatformPluginURI();
					uriMap.put(resourceURI, resourceURI);
					uriMap.put(pluginURI, resourceURI);
					if (PROJECT_MAP_ADD_URI_MAP.isActive()) {
						PROJECT_MAP_ADD_URI_MAP.println(resourceURI + " => " + resourceURI);
						PROJECT_MAP_ADD_URI_MAP.println(pluginURI + " => " + resourceURI);
					}
				}
			}
		}
	}

	public static @Nullable StandaloneProjectMap findAdapter(@NonNull ResourceSet resourceSet) {
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			return StandaloneProjectMap.findAdapter(resourceSet);
		}
		return (StandaloneProjectMap) EcoreUtil.getAdapter(resourceSet.eAdapters(), ProjectMap.class);
	}

	public static synchronized @NonNull StandaloneProjectMap getAdapter(@NonNull ResourceSet resourceSet) {
		if (!EcorePlugin.IS_ECLIPSE_RUNNING) {
			return StandaloneProjectMap.getAdapter(resourceSet);
		}
		StandaloneProjectMap adapter = findAdapter(resourceSet);
		if (adapter == null) {
			adapter = new ProjectMap(false);
			adapter.initializeResourceSet(resourceSet);
		}
		return adapter;
	}

	/**
	 * non-null visitor when this ProjectMap is listening to resource chnages in the workspace.
	 */
	private /*@LazyNonNull*/ IResourceDeltaVisitor visitor = null;

	/**
	 * plugin.xml deltas in the current visit();
	 */
	private @Nullable List<@NonNull IResourceDelta> pluginXMLdeltas = null;

	public ProjectMap(boolean isGlobal) {
		super(isGlobal);
	}

	@Override
	protected @NonNull IProjectDescriptor createProjectDescriptor(@NonNull String projectName, @NonNull URI locationURI) {
		return new ProjectDescriptor(this, projectName, locationURI);
	}

	/**
	 * @since 1.7
	 */
	public void dispose() {
	//	super.dispose() {
		if (visitor != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			visitor = null;
		}
	}

	@Override
	public @Nullable URI getLocation(@NonNull String projectName) {
		URI uri = super.getLocation(projectName);
		if ((uri == null) && EMFPlugin.IS_ECLIPSE_RUNNING) {
			uri = URI.createPlatformPluginURI("/" + projectName + "/", true);
		}
		return uri;
	}

	/*	@Override
	public synchronized void initializeGenModelLocationMap(boolean force) {
		if (force || ((nsURI2package == null) && !EMFPlugin.IS_ECLIPSE_RUNNING)) {
			super.initializeGenModelLocationMap(force);
		}
	} */

	@Override
	public synchronized void initializePlatformResourceMap(boolean force) {
		if (force || (!initializedPlatformResourceMap && !EMFPlugin.IS_ECLIPSE_RUNNING)) {
			super.initializePlatformResourceMap(force);
		}
	}

	@Override
	public void initializeResourceSet(@Nullable ResourceSet resourceSet) {
		assert (resourceSet != null) || !EMFPlugin.IS_ECLIPSE_RUNNING;		// Diagnosing for Bug 544187.
		super.initializeResourceSet(resourceSet);
	}

	@Override
	public synchronized void initializeURIMap(@Nullable ResourceSet resourceSet) {
		super.initializeURIMap(resourceSet);
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			Map<URI, URI> uriMap = getURIMap(resourceSet);
			URI resourceURI = URI.createPlatformResourceURI("/", true);
			URI pluginURI = URI.createPlatformPluginURI("/", true);
			uriMap.put(resourceURI, pluginURI);
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return (type instanceof Class<?>) && ((Class<?>)type).isAssignableFrom(ProjectMap.class);
	}

	/**
	 * Internal call-back for a resource change visits the delta to respond to changed open/closed projects.
	 * Changes are synchronized on this.
	 */
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			synchronized (this) {
				assert pluginXMLdeltas == null;
				try {
					event.getDelta().accept(visitor);
					if (pluginXMLdeltas != null) {
						for (IResourceDelta delta : pluginXMLdeltas) {
							int kind = delta.getKind();
						//	System.out.println("Delta " + kind + " for " + delta + ((kind & IResourceDelta.ADDED) != 0 ? " ADDED" : "") + ((kind & IResourceDelta.CHANGED) != 0 ? " CHANGED" : "") + ((kind & IResourceDelta.REMOVED) != 0 ? " REMOVED" : ""));
							// FIXME Could process target platform project chnage here
						}
					}
				}
				finally {
					pluginXMLdeltas = null;
				}
			}
		} catch (CoreException e) {
		//	log.error(e.getMessage(), e);
		}
	}

	@Override
	protected void scanClassPath(@NonNull Map<@NonNull String, @NonNull IProjectDescriptor> projectDescriptors, @NonNull SAXParser saxParser) {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			super.scanClassPath(projectDescriptors, saxParser);
		}
		else {
			//			scanBundles();  -- no need to scan hundreds of bundles when a single URI map entry will handle them all.
			scanProjects(projectDescriptors);
			scanGenModels(saxParser);
		}
	}

	/*	protected void scanBundles() {
		for (IBundleGroupProvider bundleGroupProvider : Platform.getBundleGroupProviders()) {
			for (IBundleGroup bundleGroup : bundleGroupProvider.getBundleGroups()) {
				for (Bundle bundle : bundleGroup.getBundles()) {
					String bundleName = bundle.getSymbolicName();
					String projectKey = "/" + bundleName + "/";
					project2location.put(bundleName, URI.createPlatformPluginURI(projectKey, true));
				}
			}
		}
	} */

	protected void scanGenModels(@NonNull SAXParser saxParser) {
		URIConverter uriConverter = new ExtensibleURIConverterImpl();
		// FIXME Bug 576593 getEPackageNsURIToGenModelLocationMap returns empty cache for not target-platform / non-cache otherwise
		Map<String, URI> ePackageNsURIToGenModelLocationMap = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(true);
		Map<@NonNull URI, @NonNull Map<@NonNull URI, @Nullable String>> genModel2nsURI2className = new HashMap<>();
		for (String ePackageNsURI : ePackageNsURIToGenModelLocationMap.keySet()) {
			URI genModelURI = ePackageNsURIToGenModelLocationMap.get(ePackageNsURI);
			if (genModelURI != null) {
				if (genModelURI.isPlatformResource()) {			// URI mapping may not (yet) be in place.
					String platformResourcePath = genModelURI.toPlatformString(true);
					genModelURI = URI.createPlatformPluginURI(platformResourcePath, true);
				}
				Map<@NonNull URI, @Nullable String> nsURI2className = genModel2nsURI2className.get(genModelURI);
				if (nsURI2className == null) {
					nsURI2className = new HashMap<>();
					genModel2nsURI2className.put(genModelURI, nsURI2className);
				}
				nsURI2className.put(URI.createURI(ePackageNsURI), null);
			}
		}
		for (@NonNull URI genModelURI : genModel2nsURI2className.keySet()) {
			if (genModelURI.isPlatformPlugin()) {
				IProjectDescriptor projectDescriptor = getProjectDescriptorInternal(genModelURI);
				Map<@NonNull URI, @Nullable String> nsURI2className = genModel2nsURI2className.get(genModelURI);
				assert nsURI2className != null;
				@NonNull URI deresolvedGenModelURI = URIUtil.deresolve(genModelURI, projectDescriptor.getLocationURI(), true, true, true);
				@NonNull String genModelString = String.valueOf(deresolvedGenModelURI);
				IResourceDescriptor resourceDescriptor = projectDescriptor.createResourceDescriptor(genModelString, nsURI2className);
				GenModelReader genModelReader = new GenModelReader(resourceDescriptor);
				InputStream inputStream = null;
				try {
					inputStream = uriConverter.createInputStream(genModelURI);
					saxParser.parse(inputStream, genModelReader);
				} catch (Exception e) {
					logException("Failed to parse '" + genModelURI + "'", e);
				} finally {
					try {
						if (inputStream != null) {
							inputStream.close();
						}
					} catch (IOException e) {}
				}
			}
		}
	}

	private void refreshProject(@NonNull Map<String, IProjectDescriptor> projectDescriptors, @NonNull IProject project) {
		//	Map<String, IProjectDescriptor> projectDescriptors = getProjectDescriptors();
		//	if (projectDescriptors != null) {
		@SuppressWarnings("null")@NonNull String projectName = project.getName();
		boolean wasOpen = projectDescriptors.containsKey(projectName);
		boolean isOpen = project.isOpen();
		if (wasOpen) {
			if (!isOpen) {
				@SuppressWarnings("unused")
				IProjectDescriptor projectDescriptor = projectDescriptors.remove(projectName);
				//	projectDescriptor.dispose();
				if (PROJECT_MAP_RESOURCE_CHANGE.isActive()) {
					PROJECT_MAP_RESOURCE_CHANGE.println(/*NameUtil.debugSimpleName(this) +*/ "Closing " + projectName);
				}
			}
			else {
			//	System.out.println(NameUtil.debugSimpleName(this) + " still open " + projectName);
			}
		}
		else {
			if (isOpen) {
				if (PROJECT_MAP_RESOURCE_CHANGE.isActive()) {
					PROJECT_MAP_RESOURCE_CHANGE.println(/*NameUtil.debugSimpleName(this) +*/ "Opening " + projectName);
				}
				String projectKey = "/" + projectName + "/";
				@NonNull URI platformResourceURI = URI.createPlatformResourceURI(projectKey, true);
				IProjectDescriptor projectDescriptor = createProjectDescriptor(projectName, platformResourceURI);
				projectDescriptors.put(projectName, projectDescriptor);
			}
			else {
			//	System.out.println(NameUtil.debugSimpleName(this) + " still closed " + projectName);
			}
		}
	}

	protected void scanProjects(@NonNull Map<String, IProjectDescriptor> projectDescriptors) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (isGlobal && (visitor == null)) {			// Lazily install listening for a/the global ProjectMap
			visitor = this;
			workspace.addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
		}
		for (IProject project : workspace.getRoot().getProjects()) {
			if (project != null) {
				refreshProject(projectDescriptors, project);
			}
		}
	}

	/**
	 * Internal cCall-back from a resourceChanged() add/s/removes IProjectDescriptor for newly opened/closed projects.
	 */
	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (resource instanceof IWorkspaceRoot) {
			return true;
		}
		if (resource instanceof IProject) {
			Map<@NonNull String, @NonNull IProjectDescriptor> projectDescriptors2 = getProjectDescriptors();
			assert projectDescriptors2 != null;
			refreshProject(projectDescriptors2, (IProject)resource);
			return true;
		}
		if (resource instanceof IFile) {
			IFile file = (IFile)resource;
			String fileName = file.getName();
			if ("plugin.xml".equals(fileName)) {
				List<@NonNull IResourceDelta> pluginXMLdeltas2 = pluginXMLdeltas;
				if (pluginXMLdeltas2 == null) {
					pluginXMLdeltas = pluginXMLdeltas2 = new ArrayList<>();
				}
				pluginXMLdeltas2.add(delta);
			}
		}
		return false;
	}
}
