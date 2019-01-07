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

package com.zeligsoft.cx.build.factory;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.cdt.codan.core.CodanRuntime;
import org.eclipse.cdt.codan.internal.core.CodanPreferencesLoader;
import org.eclipse.cdt.core.CCProjectNature;
import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.CProjectNature;
import org.eclipse.cdt.make.core.IMakeBuilderInfo;
import org.eclipse.cdt.make.core.IMakeTarget;
import org.eclipse.cdt.make.core.IMakeTargetManager;
import org.eclipse.cdt.make.core.MakeBuilder;
import org.eclipse.cdt.make.core.MakeCorePlugin;
import org.eclipse.cdt.make.core.MakeProjectNature;
import org.eclipse.cdt.newmake.core.IMakeCommonBuildInfo;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.Activator;
import com.zeligsoft.base.ZeligsoftAbstractPlugin;
import com.zeligsoft.base.l10n.Messages;
import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;

/**
 * Factory used to create an Eclipse project for a given Modeling element.
 * 
 * @author Tony Niro (tniro)
 */
@SuppressWarnings({ "deprecation", "restriction" })
public class ProjectFactory {
	/** Do not create any project */
	public static final int MODE_NO_CREATE = 0;

	/** Create a standard Eclipse project */
	public static final int MODE_CREATE_BASIC = 1;

	/** Create a C Makefile project */
	public static final int MODE_CREATE_C = 2;

	/** Create a C++ Makefile project */
	public static final int MODE_CREATE_CPP = 4;

	/** Create a Java project */
	public static final int MODE_CREATE_JAVA = 8;

	private static final String TARGET_BUILDER_ID = "org.eclipse.cdt.make.MakeTargetBuilder"; //$NON-NLS-1$

	private static final String ALL = "all"; //$NON-NLS-1$

	private static final String CLEAN = "clean"; //$NON-NLS-1$

	private final static String MODEL_CONFIGURATION = "::modelConfiguration";//$NON-NLS-1$

	private final static String PROJECT_NAME_ATTRIBUTE = "generatedProjectName"; //$NON-NLS-1$

	private final static String SOURCE_SUFFIX = "_src"; //$NON-NLS-1$
	
	private final static String PROJECT_FILE = ".project"; //$NON-NLS-1$
	
	private final static String CPROJECT_FILE = ".cproject"; //$NON-NLS-1$

	/**
	 * Returns the project that corresponds to the given element. If the project
	 * does not exist and the mode is not NO_CREATE the project will be created.
	 * If the project exists and the mode is not NO_CREATE the project will have
	 * the appropriate natures and builders applied to it if not already
	 * applied.
	 * 
	 * @return project or null
	 */
	public static IProject getProject(EObject eObject,
			IProgressMonitor progressMonitor, int mode) {
		// make sure we have something to create a project for
		if (eObject == null) {
			return null;
		}

		// allocate a default progress monitor if one is not passed in
		IProgressMonitor monitor = progressMonitor;
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		IProject project = null;

		// We're creating projects for a given model.
		if (eObject instanceof NamedElement) {
			// findProject method deals exclusively with resource handles, 
			// independent of whether the resources exist in the workspace. 
			project = findProject(eObject, mode);
			if (project == null) {
				return null;
			}

			// if exists, return current project
			if (project.exists()) {
				// if not open, we open it
				if (!project.isOpen()) {
					try {
						project.open(monitor);
					} catch (CoreException e) {
						// this can happen since findProject() just deals with resource handles 
						// independent of whether the resources exist in the workspace.
						// just ignore the exception
					}
				}
			} else if (mode == MODE_NO_CREATE) {
				project = null;
			} else {
				try {
					project.create(monitor);
					project.open(monitor);
				} catch (CoreException e) {
					e.printStackTrace();

					try {
						project.delete(true, true, monitor);
					} catch (CoreException e2) {
						e2.printStackTrace();
					} finally {
						project = null;
					}
				}
			}

			if (project != null) {
				if (0 != (mode & MODE_CREATE_C)) {
					try {
						if (!project.hasNature(CProjectNature.C_NATURE_ID)) {
							createCProject(project, monitor);
							addTarget(project, ALL);
							addTarget(project, CLEAN);
							setDefaultBuildCommandLocation(project);
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				if (0 != (mode & MODE_CREATE_CPP)) {
					try {
						if (!project.hasNature(CCProjectNature.CC_NATURE_ID)) {
							createCPPProject(project, monitor);
							addTarget(project, ALL);
							addTarget(project, CLEAN);
							setDefaultBuildCommandLocation(project);
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				if (0 != (mode & MODE_CREATE_JAVA)) {
					try {
						if (!project.hasNature(JavaCore.NATURE_ID)) {
							createJavaProject(project, monitor);
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return project;
	}

	/**
	 * Extracts the name of the project from the Model Configuration for the
	 * given eObject and creates an IProject handle.
	 * 
	 * @return project or null
	 */
	private static IProject findProject(EObject eObject, int mode) {
		
		
		if (0 != (mode & MODE_CREATE_C)) {
			return ResourcesPlugin.getWorkspace().getRoot()
			.getProject(getSrcProjectName(eObject)+getCPath());
			
		}
		else if (0 != (mode & MODE_CREATE_CPP)) {
			return ResourcesPlugin.getWorkspace().getRoot()
			.getProject(getSrcProjectName(eObject)+getCPPPath());
			
		} else {
			return ResourcesPlugin.getWorkspace().getRoot()
					.getProject(getSrcProjectName(eObject));
		}
	}

	/**
	 * Returns the source project name that corresponds to the given element.
	 * 
	 * @return source project name
	 */
	public static String getSrcProjectName(EObject eObject) {
		
		String result = UML2Util.EMPTY_STRING;
		
		EObject root = EcoreUtil.getRootContainer(eObject);

		if (root instanceof Package) {
			Package pack = (Package) root;
			String name = pack.getName() + MODEL_CONFIGURATION;
			Collection<NamedElement> elements = UMLUtil.findNamedElements(
					pack.eResource(), name);

			if (!elements.isEmpty()) {
				for (NamedElement element : elements) {
					if (element instanceof InstanceSpecification
							&& element.eResource() == root.eResource()) {
						EList<Slot> slots = ((InstanceSpecification) element)
								.getSlots();

						for (Slot slot : slots) {
							if (PROJECT_NAME_ATTRIBUTE.equals(slot
									.getDefiningFeature().getName())) {
								EList<ValueSpecification> specs = slot
										.getValues();

								for (ValueSpecification spec : specs) {
									if (spec.stringValue() != null) {
										result = spec.stringValue().trim();
									}
								}
							}
						}
					}
				}
			}
		}
		if (UML2Util.isEmpty(result)) {
			IFile f = WorkspaceSynchronizer.getFile(eObject.eResource());
			if(f != null) {
				return f.getProject().getName();
			}
			else {
				return ((NamedElement)root).getName() + SOURCE_SUFFIX;
			}
		}
		return result;
	}

 	/**
 	 * Sets the source project name that corresponds to the given element.
 	 * 
 	 */
	public static void setSrcProjectName(EObject eObject, String srcProjectName) {
		EObject root = EcoreUtil.getRootContainer(eObject);
	 
		if (root instanceof Package) {
			Package pack = (Package) root;
			String name = pack.getName() + MODEL_CONFIGURATION;
			Collection<NamedElement> elements = UMLUtil.findNamedElements(
					pack.eResource(), name);
	
			if (!elements.isEmpty()) {
				for (NamedElement element : elements) {
					if (element instanceof InstanceSpecification
							&& element.eResource() == root.eResource()) {
						EList<Slot> slots = ((InstanceSpecification) element)
								.getSlots();
	
						for (Slot slot : slots) {
							if (PROJECT_NAME_ATTRIBUTE.equals(slot
									.getDefiningFeature().getName())) {
								EList<ValueSpecification> specs = slot
										.getValues();
	
								for (ValueSpecification spec : specs) {
									if (spec.stringValue() != null) {
										((LiteralString)spec).setValue(srcProjectName + SOURCE_SUFFIX);
									}
								}
							}
						}
					}
				}
			}
		}
	}	
	
	/**
	 * Returns the project that corresponds to the given element. If the project
	 * does not exist, it will not be created.
	 * 
	 * @return project or null
	 */
	public static IProject getProject(EObject eObject,
			IProgressMonitor progressMonitor) {
		return getProject(eObject, progressMonitor, MODE_NO_CREATE);
	}

	/**
	 * Adds the CDT C Nature to the project.
	 */
	private static void createCProject(IProject project,
			IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		description.setLocation(null);

		CCorePlugin.getDefault().createCProject(description, project, monitor,
				MakeCorePlugin.CFG_DATA_PROVIDER_ID);
		MakeProjectNature.addNature(project, monitor);
		disableCodeAnalysis(project);
	}

	/**
	 * Adds the CDT C++ Nature to the project.
	 */
	private static void createCPPProject(IProject project,
			IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		description.setLocation(null);

		CCorePlugin.getDefault().createCProject(description, project, monitor,
				MakeCorePlugin.CFG_DATA_PROVIDER_ID);
		CCProjectNature.addCCNature(project, monitor);
		MakeProjectNature.addNature(project, monitor);
		disableCodeAnalysis(project);
	}

	/**
	 * Add the given target to the Make Targets View
	 */
	public static void addTarget(IProject project, String targetName) {
		if (project == null || targetName == null || targetName.length() == 0) {
			// TODO: log this..
			return;
		}

		IMakeTargetManager manager = MakeCorePlugin.getDefault()
				.getTargetManager();
		try {
			// remove target if it currently exists
			IMakeTarget target = manager.findTarget(project, targetName);
			if (target != null) {
				manager.removeTarget(target);
			}

			String buildCmd = getBuildCommand();

			// create a new target.
			target = manager.createTarget(project, targetName,
					TARGET_BUILDER_ID);
			target.setStopOnError(true);
			target.setRunAllBuilders(false);

			IMakeBuilderInfo projectInfo = MakeCorePlugin.createBuildInfo(
					project, MakeBuilder.BUILDER_ID);

			if (buildCmd == null || buildCmd.length() <= 0) {
				target.setUseDefaultBuildCmd(true);
			} else {
				target.setUseDefaultBuildCmd(false);
				target.setBuildAttribute(IMakeCommonBuildInfo.BUILD_COMMAND,
						buildCmd);

				if (!projectInfo
						.getBuildAttribute(IMakeCommonBuildInfo.BUILD_COMMAND,
								"").equals(buildCmd)) //$NON-NLS-1$
				{
					projectInfo.setBuildAttribute(
							IMakeCommonBuildInfo.BUILD_COMMAND, buildCmd);
					projectInfo.setUseDefaultBuildCmd(false);
				}
			}

			// set the build arguments specified in Linked Resources
			Collection<String> linkedResources = getLinkedResources();
			if (!linkedResources.isEmpty()) {
				Map<String, String> env = new HashMap<String, String>();
				for (String linkedRes : linkedResources) {
					try {
						String var = linkedRes.substring(0,
								linkedRes.indexOf('='));
						String val = linkedRes
								.substring(linkedRes.indexOf('=') + 1);
						env.put(var, val);

					} catch (IndexOutOfBoundsException e) {
						// don't add it to the env
					}
				}
				if (!env.isEmpty()) {
					projectInfo.setEnvironment(env);
				}
			}

			target.setBuildAttribute(IMakeTarget.BUILD_TARGET, targetName);
			manager.addTarget(project, target);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Determines the value of the build command
	 * 
	 * @return the build command or null
	 */
	private static String getBuildCommand() {
		String cmd = CXActivator.getDefault().getPluginPreferences()
				.getString(CXPreferenceConstants.MAKE_LOCATION);
		return cmd != null ? cmd.trim() : null;
	}

	/**
	 * Extract the linked resources and use them as make variables.
	 * 
	 * @author tniro, moved here by tmcguire
	 */
	private static Collection<String> getLinkedResources() {
		Collection<String> variables = new ArrayList<String>();

		IPathVariableManager pvm = ResourcesPlugin.getWorkspace()
				.getPathVariableManager();

		for (String var : pvm.getPathVariableNames()) {
			IPath path = pvm.getValue(var);
			variables.add(var + "=" + path.toString()); //$NON-NLS-1$
		}

		return variables;
	}

	/**
	 * Sets up the default build command for the ALL and CLEAN targets.
	 */
	private static void setDefaultBuildCommandLocation(IProject project)
			throws CoreException {
		IMakeTargetManager manager = MakeCorePlugin.getDefault()
				.getTargetManager();

		if (manager != null) {
			String buildCmd = getBuildCommand();

			IMakeTarget target = manager.findTarget(project, ALL);

			if (target != null) {
				if (buildCmd == null || buildCmd.length() <= 0) {
					target.setUseDefaultBuildCmd(true);
				} else {
					target.setUseDefaultBuildCmd(false);
					target.setBuildAttribute(
							IMakeCommonBuildInfo.BUILD_COMMAND, buildCmd);
				}
			}

			target = manager.findTarget(project, CLEAN);

			if (target != null) {
				if (buildCmd == null || buildCmd.length() <= 0) {
					target.setUseDefaultBuildCmd(true);
				} else {
					target.setUseDefaultBuildCmd(false);
					target.setBuildAttribute(
							IMakeCommonBuildInfo.BUILD_COMMAND, buildCmd);
				}
			}
		}
	}

	/**
	 * Adds the Java Nature to the project.
	 */
	private static void createJavaProject(IProject project,
			IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		description.setLocation(null);

		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = JavaCore.NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, monitor);

		JavaCore.create(project);
	}
	
	
	/**
	 *  Moves the specified workspace project to the destination specified in destinationPath. 
	 *
	 * @param projectName Name of project to lookup in the current workspace for relocation
	 * @param destinationPath The absolute path to the destination directory where the project will be moved
	 * @param options StandardCopyOption to use when moving the project folder
	 * @param keepProjectFiles Whether or not to keep the .cproject and .project files after moving the project
	 * @throws IOException
	 * @throws CoreException
	 */
	public static void moveProject(String projectName, Path destinationPath, boolean keepProjectFiles, StandardCopyOption... options) throws IOException, CoreException{
		boolean success = false;		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

		if(project != null && project.exists()){
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
			Path sourcePath = Paths.get(project.getLocation().makeAbsolute().toOSString());
			destinationPath = destinationPath.resolve(project.getName());
			//Create intermediary directories
			Files.createDirectories(destinationPath);
			try{
				Files.deleteIfExists(destinationPath);
			}catch (DirectoryNotEmptyException e) {		
				Files.walkFileTree(destinationPath, new SimpleFileVisitor<Path>(){
					@Override
					public FileVisitResult visitFile(Path file,
							BasicFileAttributes attrs) throws IOException {
						Files.delete(file);
						return FileVisitResult.CONTINUE;
					}
					
					@Override
					public FileVisitResult visitFileFailed(Path file,
							IOException exc) throws IOException {
						Files.delete(file);
						return FileVisitResult.CONTINUE;
					}
					
					@Override
					public FileVisitResult postVisitDirectory(Path dir,
							IOException exc) throws IOException {
						if (exc == null)
			            {
			                Files.delete(dir);
			                return FileVisitResult.CONTINUE;
			            }
			            else
			            {
			                // Directory iteration failed. Propagate exception.
			                throw exc;
			            }
					}
				});
			}
			IProjectDescription description = project.getDescription();			
			project.close(null);
		
			Path moved = Files.move(sourcePath, destinationPath, options);
			if(Files.exists(moved)){
				success = true;
			}
			if(success){
				description.setLocationURI(destinationPath.toUri());
				project.delete(true, true, null);
				if(!keepProjectFiles){
					if(destinationPath.toString().endsWith(ProjectFactory.getSrcSuffix()+ProjectFactory.getCPPPath())
							|| destinationPath.toString().endsWith(ProjectFactory.getSrcSuffix()+ProjectFactory.getCPath())){
						Files.delete(destinationPath.resolve(CPROJECT_FILE));
					}
					Files.delete(destinationPath.resolve(PROJECT_FILE));
				}
			}
		}

		if(!success){		
			System.err.println(NLS.bind(Messages.MoveProjectFailed,
					new String[]{projectName, destinationPath.toAbsolutePath().toString()}));
		}
	}
	
	public static String getCPPLanguage() {
		return "CPP"; //$NON-NLS-1$
	}
	
	public static String getCPPPath() {
		return "_"+getCPPLanguage(); //$NON-NLS-1$
	}
	public static String getCLanguage() {
		return "C"; //$NON-NLS-1$
	}
	
	public static String getCPath() {
		return "_"+getCLanguage(); //$NON-NLS-1$
	}
	
	public static String getSrcSuffix(){
		return SOURCE_SUFFIX;
	}
	
	
	@SuppressWarnings({ "nls" })
	private static void disableCodeAnalysis(IProject project)
	{
	
		IEclipsePreferences codanpp = CodanPreferencesLoader
				.getProjectNode(project);
		CodanPreferencesLoader codanPreferencesLoader = new CodanPreferencesLoader();
		codanPreferencesLoader.setInput(CodanRuntime.getInstance()
				.getCheckersRegistry().getWorkspaceProfile());
		codanpp.put("org.eclipse.cdt.codan.checkers.errnoreturn", "Warning");
		codanpp.put("org.eclipse.cdt.codan.checkers.errnoreturn.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.checkers.errnoreturn"));
		codanpp.put("org.eclipse.cdt.codan.checkers.errreturnvalue", "Error");
		codanpp.put("org.eclipse.cdt.codan.checkers.errreturnvalue.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.checkers.errreturnvalue"));
		codanpp.put("org.eclipse.cdt.codan.checkers.noreturn", "Error");
		codanpp.put("org.eclipse.cdt.codan.checkers.noreturn.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.checkers.noreturn"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AbstractClassCreation", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AbstractClassCreation.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.AbstractClassCreation"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AmbiguousProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AmbiguousProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.AmbiguousProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AssignmentInConditionProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AssignmentInConditionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.AssignmentInConditionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AssignmentToItselfProblem", "Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.AssignmentToItselfProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.AssignmentToItselfProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.CaseBreakProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.CaseBreakProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.CaseBreakProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.CatchByReference", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.CatchByReference.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.CatchByReference"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.CircularReferenceProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.CircularReferenceProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.CircularReferenceProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.ClassMembersInitialization", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.ClassMembersInitialization.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.ClassMembersInitialization"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.FieldResolutionProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.FieldResolutionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.FieldResolutionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.FunctionResolutionProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.FunctionResolutionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.FunctionResolutionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.InvalidArguments", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.InvalidArguments.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.InvalidArguments"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.InvalidTemplateArgumentsProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.InvalidTemplateArgumentsProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.InvalidTemplateArgumentsProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.LabelStatementNotFoundProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.LabelStatementNotFoundProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.LabelStatementNotFoundProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.MemberDeclarationNotFoundProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.MemberDeclarationNotFoundProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.MemberDeclarationNotFoundProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.MethodResolutionProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.MethodResolutionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.MethodResolutionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.NamingConventionFunctionChecker", "-Info");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.NamingConventionFunctionChecker.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.NamingConventionFunctionChecker"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.NonVirtualDestructorProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.NonVirtualDestructorProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.NonVirtualDestructorProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.OverloadProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.OverloadProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.OverloadProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.RedeclarationProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.RedeclarationProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.RedeclarationProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.RedefinitionProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.RedefinitionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.RedefinitionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.ReturnStyleProblem", "-Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.ReturnStyleProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.ReturnStyleProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.ScanfFormatStringSecurityProblem", "-Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.ScanfFormatStringSecurityProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.ScanfFormatStringSecurityProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.StatementHasNoEffectProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.StatementHasNoEffectProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.StatementHasNoEffectProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.SuggestedParenthesisProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.SuggestedParenthesisProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.SuggestedParenthesisProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.SuspiciousSemicolonProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.SuspiciousSemicolonProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.SuspiciousSemicolonProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.TypeResolutionProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.TypeResolutionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.TypeResolutionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.UnusedFunctionDeclarationProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.UnusedFunctionDeclarationProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.UnusedFunctionDeclarationProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.UnusedStaticFunctionProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.UnusedStaticFunctionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.UnusedStaticFunctionProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.UnusedVariableDeclarationProblem", "Warning");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.UnusedVariableDeclarationProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.UnusedVariableDeclarationProblem"));
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.VariableResolutionProblem", "-Error");
		codanpp.put("org.eclipse.cdt.codan.internal.checkers.VariableResolutionProblem.params", codanPreferencesLoader.getPreferencesString("org.eclipse.cdt.codan.internal.checkers.VariableResolutionProblem"));
		codanpp.put("useParentScope", "false");
		
		try {
			codanpp.flush();
		} catch (BackingStoreException e) {
			ZeligsoftAbstractPlugin.error(Activator.getDefault(), e.getMessage(), e);
		}
	}
	
}
