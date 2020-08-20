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
package com.zeligsoft.ddk.zdlgen2umlprofile.operations;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.zeligsoft.ddk.zdlgen2umlprofile.Activator;
import com.zeligsoft.ddk.zdlgen2umlprofile.util.AbstractProjectFactory;

/**
 * An internal class for finding the project to generate the model library
 * constants to. If it does not exist it will create one.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class APIProjectFactory extends AbstractProjectFactory {
    
    /**
     * There is no state so we only need a single instance.
     */
    public static final APIProjectFactory INSTANCE = new APIProjectFactory();
    
    /**
     * Initialize me
     */
    private APIProjectFactory() {
        // do nothing
    }
    
    /**
     * Helper function to create the necessary type of project to contain
     * the generated names constants.
     * 
     * @param project
     *      The project to be created
     * @param monitor
     *      The progress monitor to be used
     * @return
     *      The project that has been created
     * @throws CoreException 
     */
    @Override
	protected IProject createProject(String project, IProgressMonitor monitor) 
        throws CoreException {
        final List<String> srcFolders =  newArrayList("src", "api-gen"); //$NON-NLS-1$//$NON-NLS-2$
        final List<IProject> referencedProjects = emptyList();
        final Set<String> requiredBundles = Sets.newHashSet(
                "com.zeligsoft.base.zdl.staticapi", //$NON-NLS-1$
                "org.eclipse.uml2.uml",  //$NON-NLS-1$
                "com.zeligsoft.base.zdl", //$NON-NLS-1$
                "com.google.guava"); //$NON-NLS-1$
        final List<String> exportedPackages = emptyList();
        return createPDEProject(project, 
                srcFolders, 
                referencedProjects,
                requiredBundles,
                exportedPackages,
                monitor
                );
    }
    
    
    private static IProject createPDEProject(final String projectName,
            final List<String> srcFolders, 
            final List<IProject> referencedProjects,
            final Set<String> requiredBundles,
            final List<String> exportedPackages,
            final IProgressMonitor progressMonitor) {
        IProject project = null;
        
        try {
            progressMonitor.beginTask("", 10); //$NON-NLS-1$
            progressMonitor.subTask("Creating project: " + projectName); //$NON-NLS-1$
            
            final IWorkspace workspace = ResourcesPlugin.getWorkspace();
            project = workspace.getRoot().getProject(projectName);
            IProjectDescription projectDescription = null;
            if(!project.exists()) {            
                
                projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
                projectDescription.setLocation(null);
                project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
            } else {
                projectDescription = project.getDescription();
            }
            final IJavaProject javaProject = JavaCore.create(project);
                
            final List<IClasspathEntry> classpathEntries = Lists.newArrayList();
            if (referencedProjects.size() != 0) {
                projectDescription.setReferencedProjects(referencedProjects.toArray(new IProject[referencedProjects.size()]));
                for (final IProject referencedProject : referencedProjects) {
                    final IClasspathEntry referencedProjectClasspathEntry = 
                        JavaCore.newProjectEntry(referencedProject
                                           .getFullPath());
                        classpathEntries.add(referencedProjectClasspathEntry);
                }
            }
                  
            projectDescription.setNatureIds(new String[] { 
                    JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature"}); //$NON-NLS-1$
            
            final ICommand java = projectDescription.newCommand();
            java.setBuilderName(JavaCore.BUILDER_ID);

            final ICommand manifest = projectDescription.newCommand();
            manifest.setBuilderName("org.eclipse.pde.ManifestBuilder"); //$NON-NLS-1$

            final ICommand schema = projectDescription.newCommand();
            schema.setBuilderName("org.eclipse.pde.SchemaBuilder"); //$NON-NLS-1$

            projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema });

            project.open(new SubProgressMonitor(progressMonitor, 1));
            project.setDescription(projectDescription, IResource.KEEP_HISTORY, new SubProgressMonitor(progressMonitor, 1));

            Collections.reverse(srcFolders);
            for (final String src : srcFolders) {
                final IFolder srcContainer = project.getFolder(src);
                if (!srcContainer.exists()) {
                    srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
                }
                final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcContainer.getFullPath());
                classpathEntries.add(0, srcClasspathEntry);
            }

            classpathEntries
                    .add(JavaCore
                            .newContainerEntry(new Path(
                                    "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6"))); //$NON-NLS-1$
            classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins"))); //$NON-NLS-1$

            javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
                    new SubProgressMonitor(progressMonitor, 1));

            javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new SubProgressMonitor(progressMonitor, //$NON-NLS-1$ //$NON-NLS-2$
                    1));
            
            configureBundle(projectName, 
                    requiredBundles, progressMonitor, project); 
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
        finally {
            progressMonitor.done();
        }
        return project;
    }

    /**
     * @param projectName
     * @param progressMonitor
     * @param project
     * @throws CoreException
     */
    private static void configureBundle(final String projectName, 
            final Collection<String> requiredBundles,
            final IProgressMonitor progressMonitor, IProject project)
            throws CoreException {
        final BundleContext context = 
            Activator.getDefault().getBundle().getBundleContext();
        final ServiceReference ref = context.getServiceReference(IBundleProjectService.class.getName());
        final IBundleProjectService bundleService = (IBundleProjectService)context.getService(ref);
        IBundleProjectDescription bundleDescription = 
            bundleService.getDescription(project);
        if(Strings.isNullOrEmpty(bundleDescription.getSymbolicName())) {
            bundleDescription.setSymbolicName(projectName);
        }
        
        if (bundleDescription.getBundleVersion() == null) {
            bundleDescription.setBundleVersion(new Version(0, 7, 0,
                    "qualifier")); //$NON-NLS-1$
        }
        
        if (Strings.isNullOrEmpty(bundleDescription.getBundleVendor())) {
            bundleDescription.setBundleVendor("Zeligsoft (2009) Ltd."); //$NON-NLS-1$
        }
        if (Strings.isNullOrEmpty(bundleDescription.getActivationPolicy())) {
            bundleDescription
                    .setActivationPolicy(Constants.ACTIVATION_LAZY);
        }
        
        if (bundleDescription.getExecutionEnvironments() != null) {
            bundleDescription
                    .setExecutionEnvironments(new String[] { "JavaSE-1.6" }); //$NON-NLS-1$
        }
        
        configureBundleRequiredBundles(bundleDescription, newArrayList(requiredBundles), bundleService);
        
        bundleDescription.apply(new SubProgressMonitor(progressMonitor, 1));
        context.ungetService(ref);
    }
    
    private static void configureBundleRequiredBundles(
            IBundleProjectDescription bundleDescription, 
            List<String> requiredBundles, 
            IBundleProjectService bundleService) {
        final List<String> copyOfRequiredBundles = Lists.newArrayList(requiredBundles);
        final List<IRequiredBundleDescription> requiredBundleDescriptions = newArrayList();
        
        final IRequiredBundleDescription[] existingRequiredBundles = 
            bundleDescription.getRequiredBundles();
        if (existingRequiredBundles != null) {
            for (IRequiredBundleDescription next : existingRequiredBundles) {
                copyOfRequiredBundles.remove(next.getName());
                requiredBundleDescriptions.add(next);
            }
        }
        for(String next : copyOfRequiredBundles) {
            requiredBundleDescriptions.add(
                   bundleService.newRequiredBundle(next, null, false, false));
        }
        
        bundleDescription.setRequiredBundles(
                requiredBundleDescriptions.toArray(
                        new IRequiredBundleDescription[requiredBundleDescriptions.size()]));
    }
    
    private static void createBuildProps(final IProgressMonitor progressMonitor, final IProject project,
            final List<String> srcFolders) {
        final StringBuilder bpContent = new StringBuilder("source.. = "); //$NON-NLS-1$
        for (final Iterator<String> iterator = srcFolders.iterator(); iterator.hasNext();) {
            bpContent.append(iterator.next()).append('/');
            if (iterator.hasNext()) {
                bpContent.append(","); //$NON-NLS-1$
            }
        }
        bpContent.append("\n"); //$NON-NLS-1$
        bpContent.append("bin.includes = META-INF/,.\n"); //$NON-NLS-1$
        createFile("build.properties", project, bpContent.toString(), progressMonitor); //$NON-NLS-1$
    }

    private static void createManifest(final String projectName, final Set<String> requiredBundles,
            final List<String> exportedPackages, final IProgressMonitor progressMonitor, final IProject project)
    throws CoreException {
        final StringBuilder maniContent = new StringBuilder("Manifest-Version: 1.0\n"); //$NON-NLS-1$
        maniContent.append("Bundle-ManifestVersion: 2\n"); //$NON-NLS-1$
        maniContent.append("Bundle-Name: " + projectName + "\n");  //$NON-NLS-1$//$NON-NLS-2$
        maniContent.append("Bundle-SymbolicName: " + projectName + "; singleton:=true\n");  //$NON-NLS-1$//$NON-NLS-2$
        maniContent.append("Bundle-Version: 1.0.0\n"); //$NON-NLS-1$
        // maniContent.append("Bundle-Localization: plugin\n");
        maniContent.append("Require-Bundle: "); //$NON-NLS-1$
        for (final String entry : requiredBundles) {
            maniContent.append(" " + entry + ",\n"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        if (exportedPackages != null && !exportedPackages.isEmpty()) {
            maniContent.append("Require-Bundle: " + exportedPackages.get(0)); //$NON-NLS-1$
            for (int i = 1, x = exportedPackages.size(); i < x; i++) {
                maniContent.append(",\n " + exportedPackages.get(i)); //$NON-NLS-1$
            }
            maniContent.append("\n"); //$NON-NLS-1$
        }
        maniContent.append("Bundle-RequiredExecutionEnvironment: J2SE-1.6\r\n"); //$NON-NLS-1$

        final IFolder metaInf = project.getFolder("META-INF"); //$NON-NLS-1$
        metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
        createFile("MANIFEST.MF", metaInf, maniContent.toString(), progressMonitor); //$NON-NLS-1$
    }
    
    public static IFile createFile(final String name, final IContainer container, final String content,
            final IProgressMonitor progressMonitor) {
        final IFile file = container.getFile(new Path(name));
        
        try {
            final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
            if (file.exists()) {
                file.setContents(stream, true, true, progressMonitor);
            }
            else {
                file.create(stream, true, progressMonitor);
            }
            stream.close();
        }
        catch (final Exception e) {
            Activator.log(new Status(
                    IStatus.ERROR,
                    Activator.PLUGIN_ID,
                    "Error creating file: " + name, //$NON-NLS-1$
                    e));
        }
        progressMonitor.worked(1);

        return file;
    }
    
    public static IFile createFile(final String name, final IContainer container, final String content,
            final String charSet, final IProgressMonitor progressMonitor) throws CoreException {
        final IFile file = createFile(name, container, content, progressMonitor);
        if (file != null && charSet != null) {
            file.setCharset(charSet, progressMonitor);
        }

        return file;
    }

    
    /**
     * @param name
     *            of the destination file
     * @param container
     *            directory containing the the destination file
     * @param contentUrl
     *            Url pointing to the src of the content
     * @param progressMonitor
     *            used to interact with and show the user the current operation
     *            status
     * @return
     */
    public static IFile createFile(final String name, final IContainer container, final URL contentUrl,
            final IProgressMonitor progressMonitor) {

        final IFile file = container.getFile(new Path(name));
        InputStream inputStream = null;
        try {
            inputStream = contentUrl.openStream();
            if (file.exists()) {
                file.setContents(inputStream, true, true, progressMonitor);
            }
            else {
                file.create(inputStream, true, progressMonitor);
            }
            inputStream.close();
        }
        catch (final Exception e) {
            Activator.log(new Status(
                    IStatus.ERROR,
                    Activator.PLUGIN_ID,
                    "Error creating file: " + name, //$NON-NLS-1$
                    e));
        }
        finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                }
                catch (final IOException e) {
                    Activator.log(new Status(
                            IStatus.ERROR,
                            Activator.PLUGIN_ID,
                            "Error closing input stream for file: " + name, //$NON-NLS-1$
                            e));
                }
            }
        }
        progressMonitor.worked(1);

        return file;
    }
}