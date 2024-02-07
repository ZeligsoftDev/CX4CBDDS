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
package org.eclipse.ocl.xtext.oclstdlib.scoping;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IParent;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.scoping.AbstractJavaClassScope;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleReference;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * A JavaClassScope supports lookup of Java class names from the OCLstdlib editor. Names are resolved against
 * a local cache. All names for completion assist are resolved against the full classpath.
 *<p>
 * This provides much less functionality that the Xtext JdtBased/ClasspathBased TypeScopes, but much less is
 * all that is needed.
 */
public class JavaClassScope extends AbstractJavaClassScope
{
	public static boolean SUPPRESS_WORK_THREAD = false;		// Set true to avoid WorkerThread delay when testing

	public static @NonNull JavaClassScope getAdapter(@NonNull BaseCSResource csResource, @NonNull ClassLoader classLoader) {
		AbstractJavaClassScope adapter = ClassUtil.getAdapter(AbstractJavaClassScope.class, csResource);
		if (adapter == null) {
			adapter = new JavaClassScope(classLoader);
			csResource.eAdapters().add(adapter);
		}
		return (JavaClassScope) adapter;
	}

	public static @NonNull JavaClassScope getAdapter(@NonNull BaseCSResource csResource, @NonNull List<@NonNull ClassLoader> classLoaders) {
		AbstractJavaClassScope adapter = ClassUtil.getAdapter(AbstractJavaClassScope.class, csResource);
		if (adapter == null) {
			adapter = new JavaClassScope(classLoaders);
			csResource.eAdapters().add(adapter);
		}
		return (JavaClassScope) adapter;
	}

	public static @NonNull JavaClassScope getAdapter(@NonNull BaseCSResource csResource, @NonNull IProject project) {
		AbstractJavaClassScope adapter = ClassUtil.getAdapter(AbstractJavaClassScope.class, csResource);
		if (adapter == null) {
			adapter = new JavaClassScope(project);
			csResource.eAdapters().add(adapter);
		}
		return (JavaClassScope) adapter;
	}

	/**
	 * ClassLoaders to help resolve references.
	 */
	private final @NonNull List<@NonNull ClassLoader> classLoaders = new ArrayList<@NonNull ClassLoader>();

	/**
	 * IProject to help resolve references in an Eclipse context.
	 */
	private final @Nullable IProject project;

	/**
	 * Map from known class names to their allocated EObjects.
	 */
	private final @NonNull Map<@NonNull String, @NonNull JavaClassCS> name2class = new HashMap<@NonNull String, @NonNull JavaClassCS>();

	private boolean doneFullScan = false;

	/* @deprecated use Iterable argument */
	@Deprecated
	public JavaClassScope(@NonNull ClassLoader classLoader) {
		this.classLoaders.add(classLoader);
		this.project = null;
	}

	public JavaClassScope(@NonNull Iterable<@NonNull ClassLoader> classLoaders) {
		this.project = null;
		addClassLoaders(classLoaders);
	}

	public JavaClassScope(@NonNull IProject project) {
		this.project = project;
	}

	@Override
	public void addClassLoaders(@NonNull Iterable<@NonNull ClassLoader> classLoaders) {
		for (@NonNull ClassLoader classLoader : classLoaders) {
			if (!this.classLoaders.contains(classLoader)) {
				this.classLoaders.add(classLoader);
			}
		}
	}

	private void doFullScan() {
		Set<@NonNull String> classNames = new HashSet<@NonNull String>(65536);
		for (@NonNull ClassLoader classLoader : classLoaders) {
			if (classLoader instanceof BundleReference) {
				Bundle bundle = ((BundleReference)classLoader).getBundle();
				IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(bundle.getSymbolicName());
				IJavaProject javaProject = JavaCore.create(iProject);
				try {
					IPackageFragmentRoot[] packageFragmentRoots = javaProject.getAllPackageFragmentRoots();
					scanJavaElements(packageFragmentRoots, classNames);
				} catch (JavaModelException e) {
				}
			}
		}
		if (project != null) {
			IJavaProject javaProject = JavaCore.create(project);
			try {
				IPackageFragmentRoot[] packageFragmentRoots = javaProject.getAllPackageFragmentRoots();
				scanJavaElements(packageFragmentRoots, classNames);
			} catch (JavaModelException e) {
			}
		}
		//		else {
		//			scanClassPath(classNames);
		//			scanBundles(classNames);
		//		}
		for (@NonNull String className : classNames) {
			getEObjectDescription(className);
		}
	}

	@Override
	public void getAdapter(@NonNull BaseCSResource importedResource) {
		if (classLoaders.size() > 0) {
			getAdapter(importedResource, classLoaders);
		}
		else if (project != null) {
			getAdapter(importedResource, project);
		}
	}

//	@Override
//	public Iterable<IEObjectDescription> getAllElements() {
//		Iterable<IEObjectDescription> allElements = super.getAllElements();
//		System.out.println("getAllElements => " + Iterables.size(allElements));
//		return allElements;
//	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> results = new ArrayList<IEObjectDescription>();
		if (SUPPRESS_WORK_THREAD && !doneFullScan) {
			doneFullScan = true;
			doFullScan();
		}
		if (!doneFullScan) {
			doneFullScan = true;
			Thread thread = new Thread("OCLstdlib ClassPath Scan") {
				@Override
				public void run() {
					doFullScan();
				}
			};
			thread.start();
			String name = "Try again once worker thread class path scan has completed.";
			JavaClassCS csJavaClass = OCLstdlibCSFactory.eINSTANCE.createJavaClassCS();
			csJavaClass.setName(name);
			results.add(EObjectDescription.create(name, csJavaClass));
		}
		else {
			List<@NonNull String> sortedNames = new ArrayList<@NonNull String>(name2class.keySet());
			Collections.sort(sortedNames);
			for (@NonNull String className : sortedNames) {
				results.add(getEObjectDescription(className));
			}
		}
		return results;
	}

	protected IEObjectDescription getEObjectDescription(@NonNull String name) {
		JavaClassCS csJavaClass;
		synchronized (name2class) {
			csJavaClass = name2class.get(name);
			if (csJavaClass == null) {
				csJavaClass = OCLstdlibCSFactory.eINSTANCE.createJavaClassCS();
				csJavaClass.setName(name);
				name2class.put(name, csJavaClass);
			}
		}
		return EObjectDescription.create(name, csJavaClass);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription result = getSingleElement(name);
		if (result != null)
			return singleton(result);
		return emptySet();
	}

	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(EObject object, URI uri) {
		QualifiedName qualifiedName = QualifiedName.create(((JavaClassCS)object).getName());
		return Collections.singletonList(EObjectDescription.create(qualifiedName, object));
	}

	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				if (isIgnoreCase()) {
					QualifiedName lowerCase = name.toLowerCase();
					QualifiedName inputLowerCase = input.getName().toLowerCase();
					return lowerCase.equals(inputLowerCase);
				} else {
					return name.equals(input.getName());
				}
			}
		});
		return result;
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName qualifiedName) {
		String name = qualifiedName.toString();
		if (name == null) {
			return null;
		}
		JavaClassCS csJavaClass = name2class.get(name);
		if (csJavaClass == null) {
			Class<?> loadClass = null;
			IType type = null;
			for (@NonNull ClassLoader classLoader : classLoaders) {
				try {
					loadClass = classLoader.loadClass(name);
					if (loadClass != null) {
						break;
					}
				} catch (ClassNotFoundException e) {}
			}
			IProject project2 = project;
			if (project2 != null) {
				IJavaProject javaProject = JavaCore.create(project2);
				try {
					type = javaProject.findType(name);
				} catch (JavaModelException e) {
					return null;
				}
			}
			if ((loadClass == null) && (type == null)) {
				return null;
			}
		}
		return getEObjectDescription(name);
	}

	/**
	 * Refresh the known classes in the CS Resource root.
	 */
	@Override
	public void installContents(@NonNull BaseCSResource csResource) {
		Set<JavaClassCS> javaClasses = new HashSet<JavaClassCS>();
		EList<EObject> contents = csResource.getContents();
		for (int i = contents.size(); --i >= 0; ) {
			EObject eObject = contents.get(i);
			if (eObject instanceof JavaClassCS) {
				contents.remove(i);
			}
		}
		for (TreeIterator<EObject> tit = csResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof JavaImplementationCS) {
				JavaClassCS implementation = ((JavaImplementationCS)eObject).getImplementation();
				if (implementation != null) {
					javaClasses.add(implementation);
				}
			}
		}
		contents.addAll(javaClasses);
	}

	protected @Nullable String resolveClassName(@NonNull String name) {
		if (!name.endsWith(".class")) {
			return null;
		}
		String className = name.substring(0, name.length()-6);
		int dollarIndex = className.lastIndexOf('$');
		if ((dollarIndex <= 0) || (className.length() <= dollarIndex+1) || !Character.isDigit(className.charAt(dollarIndex+1))) {
			return className.replace("/", ".");
		}
		else {
			return null;
		}
	}

	/*	private void scanJar(@NonNull File file, @NonNull Set<String> classNames) {
//		System.out.println("registerBundle " + file);
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(file);
			for (Enumeration<JarEntry> jarEntries = jarFile.entries(); jarEntries.hasMoreElements(); ) {
				JarEntry jarEntry = jarEntries.nextElement();
				if (!jarEntry.isDirectory()) {
					String name = jarEntry.getName();
					if (name != null) {
	//					System.out.println("     entry " + name);
						String className = resolveClassName(name);
						if (className != null) {
							classNames.add(className);
						}
					}
				}
			}
		} catch (Exception e) {
		} finally{
			if (jarFile != null) {
				try {
					jarFile.close();
				} catch (IOException e) {}
			}
		}

	} */

	/*	protected @Nullable IProjectDescriptor registerProject(@NonNull File file) {
		System.out.println("registerProject " + file);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
			String project = document.getDocumentElement().getElementsByTagName("name").item(0).getTextContent();
			if (project != null) {
				@SuppressWarnings("null")@NonNull URI locationURI = URI.createFileURI(file.getParentFile().getCanonicalPath() + File.separator);
//				IProjectDescriptor projectDescriptor = createProjectDescriptor(project, locationURI);
//				project2descriptor.put(project, projectDescriptor);
				return null;
			}
		} catch (Exception e) {
			logException("Couldn't read '" + file + "'", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	} */

	/*	private void scanBundles(@NonNull Set<String> classNames) {
		for (IBundleGroupProvider bundleGroupProvider : Platform.getBundleGroupProviders()) {
			for (IBundleGroup bundleGroup : bundleGroupProvider.getBundleGroups()) {
				for (Bundle bundle : bundleGroup.getBundles()) {
					try {
						String bundleName = bundle.getSymbolicName();
						if (bundleName != null) {
							String location = bundle.getLocation();
	//						System.out.println(bundleName + " => " + location);
							if (location.startsWith("reference:")) {
								location = location.substring(10);
							}
							else {
								logger.warn("Unknown bundle location " + location);
							}
						    java.net.URI locationURI = new java.net.URI(location);
						    File file = URIUtil.toFile(locationURI);
						    if (file != null) {
								if (location.endsWith(".jar")) {
									scanJar(file, classNames);
								}
								else {
									scanFolder(file, classNames, "", bundleName);
								}
						    }
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	} */

	/*	private void scanClassPath(@NonNull IClasspathEntry @NonNull [] resolvedClasspath, @NonNull Set<String> classNames) {
//		String property = System.getProperty("java.class.path");
//		String separator = System.getProperty("path.separator");
//		if (property != null) {
//			String[] entries = property.split(separator);
//			for (String entry : entries) {
		for (IClasspathEntry classpathEntry : resolvedClasspath) {
			int entryKind = classpathEntry.getEntryKind();
			if (entryKind == IClasspathEntry.CPE_SOURCE) {
				IPath path = classpathEntry.getPath();
				File fileEntry = path.toFile();
				try {
					File f = fileEntry.getCanonicalFile();
					if (f.getPath().endsWith(".jar")) {
						scanJar(f, classNames);
					} else {
						scanFolder(f, classNames, "", path.toString());
//					}
						// eclipse bin folder?
/*						File parentFile = f.getParentFile();
						File dotProject = new File(parentFile, ".project");
						if (dotProject.exists()) {
							IProjectDescriptor projectDescriptor = registerProject(dotProject);
							if (projectDescriptor != null) {
								File plugIn = new File(parentFile, "plugin.xml");
								if (plugIn.exists()) {
									PluginReader pluginReader = new PluginReader(projectDescriptor);
									saxParser.parse(plugIn, pluginReader);
									pluginReader.scanContents(saxParser);
								}
							}
						} * /
					}
				} catch (Exception e) {}
			}
		}
	} */

	/*	protected boolean scanFolder(@NonNull File f, @NonNull Set<String> alreadyVisited, int depth) {
		try {
			if (!alreadyVisited.add(f.getCanonicalPath()))
				return true;
		} catch (Exception e) {
			logException("Failed to scan '" + f + "'", e);
			return true;
		}
		File[] files = f.listFiles();
		boolean containsProject = false;
		File dotProject = null;
		if (files != null) {
			for (File file : files) {
				if (file.exists() && file.isDirectory() && (depth < 2) && !file.getName().startsWith(".")) {
					containsProject |= scanFolder(file, alreadyVisited, depth + 1);
				} else if (".project".equals(file.getName())) {
					dotProject = file;
				} else if (file.getName().endsWith(".jar")) {
					scanJar(file);
				}
			}
		}
		if (!containsProject && dotProject != null)
			registerProject(dotProject);
		return containsProject || dotProject != null;
	} */

	/*	private void scanFolder(@NonNull File folder, @NonNull Set<String> classNames, @NonNull String prefix, @NonNull String bundle) {
//		System.out.println("scanFolder " + folder);
		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.exists()) {
					String name = file.getName();
					if (name != null) {
						int prefixLength = prefix.length();
						if (file.isDirectory()) {
							if ((prefixLength < 10000) && !file.getName().startsWith(".")) {
								if (prefixLength > 0) {
									scanFolder(file, classNames, prefix + "." + name, bundle);
								}
								else if (bundle.startsWith(name)) {
									scanFolder(file, classNames, name, bundle);
								}
								else {		// Skip over output path
									scanFolder(file, classNames, prefix, bundle);
								}
							}
						}
						else {
//							System.out.println("     entry " + name);
							String className = resolveClassName(name);
							if (className != null) {
								System.out.println("     entry " + prefix + "." + className);
								classNames.add(prefix + "." + className);
							}
						}
					}
				}
			}
		}
	} */

	private void scanJavaElements(IJavaElement[] elements, Set<String> classNames) {
		for (IJavaElement element : elements) {
			//			System.out.println(getClass().getSimpleName() + " : " + element);
			if (element instanceof IType) {
				IType iType = (IType)element;
				classNames.add(iType.getFullyQualifiedName());
				try {
					if (iType.hasChildren()) {
						scanJavaElements(iType.getChildren(), classNames);
					}
				} catch (JavaModelException e) {}
			}
			else if ((element instanceof IParent) && !(element instanceof IMember)) {
				try {
					IParent iParent = (IParent)element;
					if (iParent.hasChildren()) {
						scanJavaElements(iParent.getChildren(), classNames);
					}
				} catch (JavaModelException e) {}
			}
		}
	}
}
