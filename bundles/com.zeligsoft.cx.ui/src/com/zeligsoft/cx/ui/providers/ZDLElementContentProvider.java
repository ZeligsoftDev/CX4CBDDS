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
package com.zeligsoft.cx.ui.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;

/**
 * ZDL Element content provider
 * 
 * @author ysroh
 * 
 */
public class ZDLElementContentProvider implements IStructuredContentProvider, ITreeContentProvider {

	private EObject context;

	private List<String> concepts;

	private IFilter filter;

	private boolean includeImportedPackages;

	private Set<EObject> contentList = new HashSet<EObject>();

	private Set<EObject> workspaceContentList = new HashSet<EObject>();

	private Set<EObject> projectContentList = new HashSet<EObject>();

	private static List<URI> testedResources = new ArrayList<URI>();
	
	private static List<URI> loadedResources = new ArrayList<URI>();
	
	private ResourceSet tmpRset = null;

	/**
	 * Constructor
	 * 
	 * @param context
	 * @param interfaceType
	 *            ZDL Concept of the interface
	 */
	public ZDLElementContentProvider(EObject context, List<String> concepts,
			IFilter filter, boolean includeImportedPackages) {
		super();
		this.context = context;
		this.concepts = concepts;
		this.filter = filter;
		this.includeImportedPackages = includeImportedPackages;
		testedResources.add(context.eResource().getURI());
		loadedResources.add(context.eResource().getURI());
	}
	private ResourceSet getTmpResourceSet() {
		if(tmpRset == null) {
			tmpRset = new ResourceSetImpl();
		}
		return tmpRset;
	}
	/**
	 * Load all UML resources in a folder
	 * 
	 * @param rset
	 * @param container
	 */
	public void loadAllResources(ResourceSet rset, IContainer container) {
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
					loadAllResources(rset, (IContainer) member);
				} else if (member instanceof IFile) {
					IFile file = (IFile) member;
					String ext = file.getFullPath().getFileExtension();
					if (!UML2Util.isEmpty(ext) && "uml".equals(ext.toLowerCase())) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						if (!testedResources.contains(uri)) {
							testedResources.add(uri);
							Package root = UML2Util.load(getTmpResourceSet(), uri, UMLPackage.Literals.PACKAGE);
							if (root != null && ZDLUtil.isZDLProfile(root, "cxDDS4CCM")) {
								boolean found = false;
								for(Resource r: rset.getResources()) {
									if(uri.equals(rset.getURIConverter().normalize(r.getURI()))){
										found = true;
										break;
									}
								}
								if(!found) {
									rset.getResource(uri, true);
								}
								loadedResources.add(uri);
							}
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all proper contents
	 * 
	 * @return
	 */
	private Object[] getContents() {

		final IEclipsePreferences store = InstanceScope.INSTANCE
				.getNode(ZeligsoftCXUIPlugin.PLUGIN_ID);
		boolean searchWorkspace = store.getBoolean(
				CXPreferenceConstants.SEARCH_WORKSPACE,
				CXPreferenceConstants.DEFAULT_SEARCH_WORKSPACE);

		boolean searchProject = store.getBoolean(
				CXPreferenceConstants.SEARCH_PROJECT,
				CXPreferenceConstants.DEFAULT_SEARCH_PROJECT);

		
		ResourceSet rset = context.eResource().getResourceSet();
		if (searchWorkspace) {
			if (workspaceContentList.isEmpty()) {
				loadAllResources(rset, ResourcesPlugin.getWorkspace().getRoot());
				for (URI o : loadedResources) {
					Resource res = rset.getResource(o, true);
					workspaceContentList.addAll(getZDLElements(res, includeImportedPackages));
				}
			}
			return workspaceContentList.toArray();
		} else if (searchProject) {
			IProject project = WorkspaceSynchronizer.getFile(
					context.eResource()).getProject();
			if (projectContentList.isEmpty()) {
				loadAllResources(rset, project);
				projectContentList.addAll(getZDLElements(context.eResource(),
						includeImportedPackages));
				for (URI o : loadedResources) {
					Resource res = rset.getResource(o, true);
					IFile f = WorkspaceSynchronizer.getFile((Resource) res);
					if (f != null && !res.equals(context.eResource())) {
						IProject thisProject = WorkspaceSynchronizer.getFile(
								(Resource) res).getProject();
						if (project.equals(thisProject)) {
							projectContentList.addAll(getZDLElements(
									(Resource) res, includeImportedPackages));
						}
					}
				}
			}
			return projectContentList.toArray();
		}
		if (contentList.isEmpty()) {
			contentList.addAll(getZDLElements(context.eResource(),
					includeImportedPackages));
		}
		return contentList.toArray();
	}

	/**
	 * Get filtered elements for the given concepts and the filter
	 * 
	 * @param rootPkg
	 * @return
	 */
	private List<EObject> getZDLElements(Resource resource,
			boolean searchPackageImport) {
		ArrayList<EObject> list = new ArrayList<EObject>();
		if (resource == null) {
			return list;
		}
		TreeIterator<EObject> itor = resource.getAllContents();

		while (itor.hasNext()) {

			EObject o = itor.next();

			if (!(o instanceof Element)) {
				continue;
			}
			if (o instanceof PackageImport && searchPackageImport) {
				list.addAll(getZDLElements(((PackageImport) o)
						.getImportedPackage().eResource(), false));
				continue;
			}

			if(isValid(o) && !list.contains(o)) {
				list.add(o);
			}
		}

		return list;
	}
	
	boolean isValid(EObject o) {
		if (filter != null) {
			if (!filter.select(o)) {
				return false;
			}
			if (concepts.isEmpty()) {
				return true;
			}
		}

		for (String concept : concepts) {
			if (ZDLUtil.isZDLConcept(o, concept)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java
	 * .lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {

		Object[] contentArray = getContents();
		Arrays.sort(contentArray, new Comparator<Object>() {

			@Override
			public int compare(Object object1, Object object2) {
				String name1 = EMFCoreUtil.getName((EObject) object1);
				String name2 = EMFCoreUtil.getName((EObject) object2);
				return name1.compareTo(name2);
			}
		});

		ArrayList<EObject> filteredList = new ArrayList<EObject>();

		if (!(inputElement instanceof String)) {
			return contentArray;
		}

		String searchText = (String) inputElement;
		if (UML2Util.isEmpty(searchText)) {
			return contentArray;
		}

		for (Object o : contentArray) {

			EObject eObject = (EObject) o;
			String name = EMFCoreUtil.getName(eObject) + " - " //$NON-NLS-1$
					+ EMFCoreUtil.getQualifiedName(eObject, true);
			String regex = searchText.toLowerCase()
					.replace("*", ".*").replace("?", ".") //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					.concat(".*"); //$NON-NLS-1$
			if (name.toLowerCase().matches(regex)) {
				filteredList.add(eObject);
			}
		}

		return filteredList.toArray();
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing to do

	}

	public void setFilter(IFilter filter) {
		this.filter = filter;
	}

	@Override
	public Object[] getChildren(Object element) {
		List<Object> result = new ArrayList<Object>();
		if (element instanceof Package) {
			for (NamedElement child : ((Package) element).getMembers()) {
				if (child instanceof Package) {
					result.add(child);
				} else {
					if (isValid(child)) {
						result.add(child);
					}
				}
			}
			return result.toArray();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length != 0;
	}

}