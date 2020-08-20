/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.tools.internal.emf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.zeligsoft.ddk.tools.Activator;

/**
 * An adapter for the EMF URI mapping registry that automatically injects URI
 * mappings registered in workspace plug-ins that are not also in the target
 * platform.
 * 
 * @author Christian W. Damus (Zeligsoft)
 */
@SuppressWarnings("restriction")
public final class URIMapHandler {

	private static final String URI_MAPPINGS_PT = "org.eclipse.emf.ecore.uri_mapping";

	private static final String MAPPING_ELEMENT = "mapping";

	private static final String SOURCE_ATTRIBUTE = "source";

	private static final String TARGET_ATTRIBUTE = "target";

	private static final URI PLATFORM_PLUGIN = URI
		.createURI("platform:/plugin/");

	private static final URI PLATFORM_RESOURCE = URI
		.createURI("platform:/resource/");

	private static Map<IProject, Map<URI, PathmapDescriptor>> pathmaps 
		= new java.util.HashMap<IProject, Map<URI, PathmapDescriptor>>();
	
	/**
	 * Initializes me.
	 */
	private URIMapHandler() {
		super();
	}

	public static void remap() {
		new Job("Updating Workspace URI mappings") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				doRemap();
				return Status.OK_STATUS;
			}
		}.schedule();
	}
	
	public static Map<IProject, Map<URI, PathmapDescriptor>> getPathmaps() {
		return pathmaps;
	}

	private static void doRemap() {
		IPluginModelBase[] plugins = PluginRegistry.getWorkspaceModels();

		for (IPluginModelBase next : plugins) {
			process(next);
		}

		PDECore.getDefault().getModelManager().addPluginModelListener(
			new IPluginModelListener() {

				@Override
				public void modelsChanged(PluginModelDelta delta) {
					switch (delta.getKind()) {
						case PluginModelDelta.ADDED :
						case PluginModelDelta.CHANGED :
							handleChanges(delta.getChangedEntries());
							break;
						default:
							break;
					}
				}

			});
	}

	private static void process(IPluginModelBase plugin) {
		boolean hasURIMappings = false;

		IPluginExtension[] extensions = plugin.getExtensions(true)
			.getExtensions();

		for (IPluginExtension ext : extensions) {
			if (URI_MAPPINGS_PT.equals(ext.getPoint())) {
				hasURIMappings = true;
				break;
			}
		}

		if (hasURIMappings) {
			InputStream input = null;

			try {
				File pluginXML = new File(plugin.getExtensions().getModel()
					.getInstallLocation(), "plugin.xml");
				if (pluginXML.exists() && pluginXML.isFile()) {
					@SuppressWarnings("deprecation")
					IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
						.findFilesForLocation(
								new Path(pluginXML.getAbsolutePath()));
					
					if (files.length > 0) {
						IProject project = files[0].getProject();
						input = new FileInputStream(pluginXML);
						mergePathmaps(project, process(input));
					}
				}
			} catch (Exception e) {
				Log.error(Activator.getDefault(), 0, 
						"Failed to load plug-in model", e);
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						Log.error(Activator.getDefault(), 0, 
								"Failed to close plugin.xml file", e);
					}
				}
			}
		}
	}

	private static Collection<PathmapDescriptor> process(InputStream pluginXML)
			throws IOException, SAXException, ParserConfigurationException {
		
		final List<PathmapDescriptor> result 
			= new java.util.ArrayList<PathmapDescriptor>();
		
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(pluginXML, new DefaultHandler() {

			boolean inURIMappingsPoint;

			@Override
			public void startElement(String uri, String localName, String name,
					Attributes attributes)
					throws SAXException {
				if ("extension".equals(name)) {
					if (URI_MAPPINGS_PT.equals(attributes.getValue("point"))) {
						inURIMappingsPoint = true;
					}
				} else if (inURIMappingsPoint && MAPPING_ELEMENT.equals(name)) {
					String sourceValue = attributes.getValue(SOURCE_ATTRIBUTE);
					if (sourceValue != null) {
						URI sourceURI = URI.createURI(sourceValue, true);

						String targetValue = attributes
							.getValue(TARGET_ATTRIBUTE);

						if (targetValue != null) {
							URI targetURI = URI.createURI(targetValue, true);

							if (PathmapDescriptor.isEligible(sourceURI, targetURI)) {
								result.add(new PathmapDescriptor(sourceURI, targetURI));
							}
						}
					}
				}
			}

			@Override
			public void endElement(String uri, String localName, String name)
					throws SAXException {

				if ("extension".equals(name)) {
					inURIMappingsPoint = false;
				}
			}

		});
		
		return result;
	}

	static void handleChanges(ModelEntry[] entries) {
		for (ModelEntry next : entries) {
			if (next.hasWorkspaceModels()) {
				for (IPluginModelBase plugin : next.getWorkspaceModels()) {
					process(plugin);
				}
			}
		}
	}
	
	static void mergePathmaps(IProject project, Collection<PathmapDescriptor> pathmaps) {
		Map<URI, PathmapDescriptor> descs = URIMapHandler.pathmaps.get(project);
		
		if (descs == null) {
			// all of the descriptors are new
			descs = new java.util.HashMap<URI, PathmapDescriptor>();
			URIMapHandler.pathmaps.put(project, descs);
		} else {
			// already have some.  Analyze changes
			
			// first, update the existing mappings that are changed
			for (PathmapDescriptor next : pathmaps) {
				PathmapDescriptor existing = descs.remove(next.getPathmap());
				if (existing != null) {
					next.setOriginalMapping(existing.getOriginalMapping());
				}
			}
			
			// then, unapply descriptors that are obsolete
			for (PathmapDescriptor next : descs.values()) {
				next.setEnabled(false);
				next.apply();
			}
			descs.clear();
		}
		
		// add the new and changed pathmaps and apply them
		for (PathmapDescriptor next : pathmaps) {
			descs.put(next.getPathmap(), next);
			next.apply();
		}
	}
	
	//
	// Nested classes
	//
	
	public static class PathmapDescriptor {
		private final String id;
		private final IProject project;
		private final URI pathmap;
		private URI originalMapping;
		private final URI newMapping;
		private boolean isEnabled;
		
		PathmapDescriptor(URI sourceURI, URI targetURI) {
			id = "pathmap." + sourceURI.authority();
			
			pathmap = sourceURI;
			originalMapping = targetURI;
			
			newMapping = targetURI.replacePrefix(
				PLATFORM_PLUGIN, PLATFORM_RESOURCE);

			// segment 0 is "resource"
			String projName = targetURI.segment(1);
			project = ResourcesPlugin
				.getWorkspace().getRoot().getProject(
					projName);
			
			isEnabled = !Activator.getBooleanPreference(id + ".disabled");
		}
		
		static boolean isPathmapScheme(URI uri) {
			return "pathmap".equals(uri.scheme());
		}

		static boolean isEligible(URI source, URI target) {
			return isPathmapScheme(source) && target.isPlatformPlugin();
		}
		
		public boolean isEnabled() {
			return isEnabled;
		}

		
		public void setEnabled(boolean isEnabled) {
			boolean oldEnabled = this.isEnabled;
			
			this.isEnabled = isEnabled;
			
			if (oldEnabled != isEnabled) {
				Activator.setPreference(id + ".disabled", !isEnabled);
			}
		}

		
		public String getId() {
			return id;
		}

		
		public IProject getProject() {
			return project;
		}

		
		public URI getPathmap() {
			return pathmap;
		}

		
		public URI getOriginalMapping() {
			return originalMapping;
		}

		
		public void setOriginalMapping(URI uri) {
			this.originalMapping = uri;
		}

		
		public URI getNewMapping() {
			return newMapping;
		}
		
		public void apply() {
			URI current = URIConverter.URI_MAP.get(pathmap);
			
			if (isEnabled()) {
				if (!newMapping.equals(current) && project.exists()) {
					Log.info(Activator.getDefault(),0, 
							"Workspace URI Mapping: " + pathmap);
					URIConverter.URI_MAP.put(pathmap, newMapping);
				}
			} else if (!originalMapping.equals(current)){
				Log.info(Activator.getDefault(),0,
					"Reverting workspace URI Mapping: " + pathmap);
				URIConverter.URI_MAP.put(pathmap, originalMapping);
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result;
			if (pathmap != null) {
				result += pathmap.hashCode();
			}
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final PathmapDescriptor other = (PathmapDescriptor) obj;
			if (pathmap == null) {
				if (other.pathmap != null) {
					return false;
				}
			} else if (!pathmap.equals(other.pathmap)) {
				return false;
			}
			return true;
		}
	}
}
