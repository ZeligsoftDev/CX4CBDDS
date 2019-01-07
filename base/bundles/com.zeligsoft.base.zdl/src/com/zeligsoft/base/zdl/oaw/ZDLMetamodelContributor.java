/**
 * Copyright 2018 ADLINK Technology Limited.
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
package com.zeligsoft.base.zdl.oaw;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.uml2.uml.Model;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.shared.ui.MetamodelContributor;
import org.eclipse.xtend.typesystem.MetaModel;


/**
 * Contributor of ZDL metamodels into the oAW type-system for editing oAW
 * resources in the workspace. This contributor functions much like the stock
 * oAW contributors, in particular:
 * 
 * <ul>
 * <li>ZDL models are discovered from the classpath of the contextual project</li>
 * <li>deployed plug-ins in the required-plugins classpath container are
 * included in the scope</li>
 * <li>other workspace projects (with the JDT nature, oAW nature not required)
 * in the classpath are included in the scope</li>
 * </ul>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLMetamodelContributor
		implements MetamodelContributor {

	private static final String PDE_REQUIRED_PLUGINS_CONTAINER = "org.eclipse.pde.core.requiredPlugins"; //$NON-NLS-1$

	private IWorkspaceRoot wsroot = ResourcesPlugin.getWorkspace().getRoot();

	/**
	 * Initializes me.
	 */
	public ZDLMetamodelContributor() {
		super();
	}

	public MetaModel[] getMetamodels(IJavaProject project, TypeSystem ctx) {
		List<MetaModel> result = new java.util.ArrayList<MetaModel>();

		Map<IFile, Model> workspaceZDLs;

		try {
			workspaceZDLs = ZDLMetamodelManager.INSTANCE
				.getWorkspaceZDLModels();
		} catch (ZDLsNotAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new MetaModel[0];
		}

		IClasspathEntry[] classpathEntries;

		try {
			classpathEntries = project.getRawClasspath();
			collectZDLModelsFromClasspath(project, result, workspaceZDLs,
				classpathEntries);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result.toArray(new MetaModel[result.size()]);
	}

	/**
	 * Finds ZDL models in the classpath defined by the given entries, in the
	 * context of a JDT project that includes these entries in its classpath.
	 * Only classpath entries of the source, project, and library types are
	 * considered. The "required plugins" container entry, if any, is resolved
	 * and processed recursively. Currently, variable-based entries are not
	 * supported.
	 * 
	 * @param project
	 *            the contextual Java project
	 * @param metamodels
	 *            collector argument for the metamodels that we are gathering
	 * @param workspaceZDLs
	 *            mapping of ZDLs known to exist in the entire workspace. The
	 *            source and project classpath entries are resolved against this
	 *            map
	 * @param classpath
	 *            the classpath entries to search
	 * 
	 * @throws JavaModelException
	 *             on any problem in processing the classpath
	 */
	private void collectZDLModelsFromClasspath(IJavaProject project,
			List<MetaModel> metamodels, Map<IFile, Model> workspaceZDLs,
			IClasspathEntry[] classpath)
			throws JavaModelException {

		for (IClasspathEntry entry : classpath) {
			IPath path = entry.getPath();

			switch (entry.getEntryKind()) {
				case IClasspathEntry.CPE_SOURCE :
					collectWorkspaceZDLModels(metamodels, path, workspaceZDLs);
					break;
				case IClasspathEntry.CPE_PROJECT :
					collectWorkspaceZDLModels(metamodels, path, workspaceZDLs);

					// recursively follow the classpath of the project
					IProject proj = wsroot.getProject(path.lastSegment());
					if (proj.exists() && proj.isOpen()) {
						IJavaProject dependency = JavaCore.create(proj);
						collectZDLModelsFromClasspath(dependency, metamodels,
							workspaceZDLs, dependency.getRawClasspath());
					}

					break;
				case IClasspathEntry.CPE_LIBRARY :
					Set<Model> deployed = ZDLMetamodelManager.INSTANCE
						.getDeployedZDLModels(path);

					for (Model next : deployed) {
						metamodels.add(new ZDLMetamodel(next));
					}
					break;
				case IClasspathEntry.CPE_CONTAINER :
					if (path.segment(0).equals(PDE_REQUIRED_PLUGINS_CONTAINER)) {
						IClasspathContainer container = JavaCore
							.getClasspathContainer(path, project);
						collectZDLModelsFromClasspath(project, metamodels,
							workspaceZDLs, container.getClasspathEntries());
					}
					break;
			}
		}
	}

	/**
	 * Collects into the specified list of metamodels those that are contained
	 * within the specified container <tt>path</tt> in the workspace.
	 * 
	 * @param metamodels
	 *            the metamodels collector list
	 * @param path
	 *            a container path in the workspace (from a source or project
	 *            classpath entry)
	 * @param workspaceZDLs
	 *            the map of all known ZDL models in the workspace
	 */
	private void collectWorkspaceZDLModels(List<MetaModel> metamodels,
			IPath path, Map<IFile, Model> workspaceZDLs) {

		IResource res = wsroot.findMember(path);

		if ((res != null) && res.exists()) {
			for (Map.Entry<IFile, Model> zdl : workspaceZDLs.entrySet()) {
				if (res.contains(zdl.getKey())) {
					metamodels.add(new ZDLMetamodel(zdl.getValue()));
				}
			}
		}
	}
}
