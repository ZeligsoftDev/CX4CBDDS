package com.zeligsoft.domain.sca.build.xtend.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IPathVariableManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.ce.build.factory.ProjectFactory;


/**
 * Helper utilities for build environment generation scripts.
 * 
 * @author tniro
 * 
 */
public class BuildEnvFuncs {

	private static final String HOST_OS = "hostOS";							//$NON-NLS-1$
	private static final String TARGET_OS = "targetOS";						//$NON-NLS-1$
	private static final String TARGET_PROCESSOR = "targetProcessor";		//$NON-NLS-1$
	private static final String TOOLCHAIN = "toolchain";					//$NON-NLS-1$
	
	private static final String OBJ_EXTENSION = "objExtension";				//$NON-NLS-1$
	private static final String EXE_EXTENSION = "exeExtension";				//$NON-NLS-1$
	private static final String LIB_EXTENSION = "libExtension";				//$NON-NLS-1$
	private static final String LIB_PREFIX = "libPrefix";					//$NON-NLS-1$
	
	private static final String MAKE = "make";								//$NON-NLS-1$
	
	private static final String COMPILER = "compiler";						//$NON-NLS-1$
	private static final String CC_DEFINE = "define";						//$NON-NLS-1$
	private static final String CC_UNDEFINE = "undefine";					//$NON-NLS-1$
	private static final String CC_INCLUDE = "include";						//$NON-NLS-1$
	private static final String CC_FLAGS = "compilerFlags";					//$NON-NLS-1$
	private static final String CC_PREPROCESSOR_FLAGS ="preprocessorFlags"; //$NON-NLS-1$
	private static final String CC_DEFINE_OPTION = "defineOption";			//$NON-NLS-1$
	private static final String CC_UNDEFINE_OPTION = "undefineOption";		//$NON-NLS-1$
	private static final String CC_OBJ_OPTION = "objectOption";				//$NON-NLS-1$
	private static final String CC_INC_OPTION = "includeOption";			//$NON-NLS-1$
	
	private static final String LINKER = "linker";							//$NON-NLS-1$
	private static final String LD_LIBRARIES = "library";					//$NON-NLS-1$
	private static final String LD_LIBRARY_PATHS = "libraryPath";			//$NON-NLS-1$
	private static final String LD_FLAGS = "linkerFlags";					//$NON-NLS-1$
	private static final String LD_LIB_OPTION = "linkerLibOption";			//$NON-NLS-1$
	private static final String LD_LIBPATH_OPTION = "linkerLibPathOption";	//$NON-NLS-1$
	private static final String LD_OUT_OPTION = "linkerOutOption";			//$NON-NLS-1$

	private static final String ARCHIVER = "archiver";						//$NON-NLS-1$
	private static final String AR_FLAGS = "archiverFlags";					//$NON-NLS-1$	
	private static final String AR_OUT_OPTION = "archiveOutOption";			//$NON-NLS-1$

	private static final String C_EXT = ".c";								//$NON-NLS-1$
	private static final String CPP_EXT = ".cpp";							//$NON-NLS-1$

	
	public static final String PATH_SPACE = " ";			 				//$NON-NLS-1$
	public static final String PATH_SPACE_REPLACE = "|";	 				//$NON-NLS-1$
	
	private static final String EMPTY = "";					 				//$NON-NLS-1$
	
	
	
	
	
	/**
	 * Access name of given element
	 * 
	 * @author tniro
	 * 
	 */	
	public static String getName(Object obj) {
		if (obj != null) {
			if ( obj instanceof NamedElement )
				return ((NamedElement)obj).getName();
		}
		return EMPTY;
	}
	
	/**
	 * Return the name of the given build environment.
	 * 
	 * @author tniro
	 * 
	 */	
	public static String getBuildEnvName(Property buildEnv){
		if ( buildEnv == null 
				|| buildEnv.getDefaultValue() == null) {
			return EMPTY;
		}
		
		ValueSpecification vs = buildEnv.getDefaultValue();
		if ( vs == null ) {
			return EMPTY;
		}
		
		if ( !(vs instanceof InstanceValue) ) {
			return EMPTY;
		}
		
		InstanceSpecification is = ((InstanceValue)vs).getInstance();
		if ( is == null ) {
			return EMPTY;
		}
		
		return is.getName();		
	}
	
	/**
	 * Getters for build environment properties.
	 * 
	 * @author tniro
	 * 
	 */		
	public static String getMake(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, MAKE);
	}
	
	public static String getHostOS(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, HOST_OS);
	}
	
	public static String getTargetOS(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, TARGET_OS);
	}
	
	public static String getTargetProcessor(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, TARGET_PROCESSOR);
	}
	
	public static String getTargetToolChain(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, TOOLCHAIN);
	}
	
	public static String getObjectFileExtension(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, OBJ_EXTENSION);
	}


	public static String getExecutableFileExtension(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, EXE_EXTENSION);
	}


	public static String getLibraryFileExtension(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LIB_EXTENSION);
	}


	public static String getLibraryFilePrefix(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LIB_PREFIX);
	}

	public static String getCompilerObjectOutputOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_OBJ_OPTION);
	}

	public static String getCompilerIncludeOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_INC_OPTION);
	}

	public static String getArchiverOutputOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, AR_OUT_OPTION);
	}

	public static String getLinkerOutputOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LD_OUT_OPTION);
	}

	public static String getCompiler(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, COMPILER);
	}
	
	public static String getDefines(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_DEFINE);
	}

	public static String getUndefines(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_UNDEFINE);
	}

	public static String getIncludePaths(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_INCLUDE, PATH_SPACE, PATH_SPACE_REPLACE);
	}

	public static String getCFlags(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_FLAGS);
	}

	public static String getCPPFlags(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_PREPROCESSOR_FLAGS);
	}

	public static String getCompilerDefineOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_DEFINE_OPTION);
	}	

	public static String getCompilerUndefineOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, CC_UNDEFINE_OPTION);
	}
	
	public static String getLinker(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LINKER);
	}

	public static String getLibraries(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LD_LIBRARIES);
	}

	public static String getLibraryDirectories(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LD_LIBRARY_PATHS, PATH_SPACE, PATH_SPACE_REPLACE);
	}

	public static String getLinkerFlags(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LD_FLAGS);
	}

	public static String getLinkerLibaryOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LD_LIB_OPTION);
	}

	public static String getLinkerLibraryPathOption(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, LD_LIBPATH_OPTION);
	}

	public static String getArchiver(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, ARCHIVER);
	}	

	public static String getArchiverOptions(Property buildEnv){
		return getBuildEnvironmentProperty( buildEnv, AR_FLAGS);
	}	

	
	/**
	 * Extract the given build property from the build environment.
	 * Allows for substitution of string parts.
	 * 
	 * @author tniro
	 * 
	 */		
	public static String getBuildEnvironmentProperty( Property property, String attribute ) {
		return getBuildEnvironmentProperty( property, attribute, null, null);
	}
	
	public static String getBuildEnvironmentProperty( Property property, String attribute, String from, String to ) {

		String str = EMPTY;
		
		if(property == null) {
			return str;
		}
		
		ValueSpecification vs = property.getDefaultValue();
		if ( vs == null ) {
			return str;
		}
		
		if (!(vs instanceof InstanceValue)) {
			return str;
		}
		
		InstanceSpecification is = ((InstanceValue)vs).getInstance();
		if ( is == null ) {
			return str;
		}

		// find the given attribute in the given instance
		EList<Slot> slots = is.getSlots();
		
		for ( Slot slot: slots ) {
			if ( attribute.equals( slot.getDefiningFeature().getName() ) ) {
				
				EList<ValueSpecification> specs = slot.getValues();
				boolean multi = (slot.getDefiningFeature().getUpper() != 1);
				
				for ( ValueSpecification spec : specs ) {
					if ( spec.stringValue() != null) {
						if (multi) {
							str += " \\\n   ";	//$NON-NLS-1$
						}
						String tmp = spec.stringValue().trim();
						if ( from != null && to != null)
							tmp = tmp.replaceAll(from, to);
						
						str += tmp;
					}
				}
				return str;
			}
		}

		// TODO need to fix this
		//      Christian was mentioning we should be adding a ZML concept for collections
		
		// find a default value from the hierarchy
//		EList<Property> props = ((Classifier)property.getType()).getAllAttributes();
//		for ( Property p : props ) {
//
//			if ( p.getName().equals( attribute ) ) {
//				if (p.getUpper() != 1) {
//					// TODO: need to handle string array
//					break;
//				} else {
//					return p.getDefault();
//				}
//			}
//		}

		return EMPTY;
	}
	
	
	/**
	 * Extract Component from the given property.
	 * 
	 * @author tniro	
	 * TODO search if used...
	 * 
	 */		
	public static Component getComponentFromProperty(Property property) {
		if ( property == null || property.getType() == null) {
			return null;
		}
		if (property.getType() instanceof Component) {
			return (Component)property.getType();
		}
		return null;
	}

	/**
	 * Use all c and cpp files in the given directory tree as our dependencies.
	 * 
	 * @author tniro
	 * TODO workspace API for finding resources.
	 */	
	private static void addObjectDependencies( String prefix, File dir, Collection<String> dependencies) {
		File[] files = dir.listFiles();
		if ( files == null || files.length <= 0 ) {
			return;
		}
	
		for ( int i = 0; i < files.length; i++  ){
			if ( files[i].isDirectory() ) {
				addObjectDependencies(prefix + "/" + files[i].getName(), files[i], dependencies);	//$NON-NLS-1$
			} else {
				String name = files[i].getName();
				if (name.endsWith(C_EXT) || name.endsWith(CPP_EXT)) {
					int pos = name.lastIndexOf(".");	//$NON-NLS-1$
					if ( pos > 0 ) {
						name = name.substring(0,pos);
						if (!dependencies.contains(name)) {
							dependencies.add(prefix + "/" + name);	//$NON-NLS-1$
						}
					}
				}
			}
		}	
	}

	/**
	 * Get the object file dependency (c/cpp files)
	 * 
	 * @author tniro
	 * 
	 */	
	public static Collection<String> getObjectDependencies(NamedElement projectElement, String subdir) {
		Collection<String> dependencies = new ArrayList<String>();
		
		IProject project = ProjectFactory.getProject( projectElement, new NullProgressMonitor());			
		if ( project != null) {
			String location = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
				+ project.getFullPath().toString() + "/" + subdir;		//$NON-NLS-1$
			File dir = new File(location);
			addObjectDependencies( subdir, dir, dependencies);
		}
		return dependencies;
	}
	
	/**
	 * Add directories if they contain source code
	 * 
	 * @author tniro
	 * 
	 */		
	private static void addSourceDirectories( String prefix, File dir, Collection<String> dependencies) {
		File[] files = dir.listFiles();
		if ( files == null || files.length <= 0 ) {
			return;
		}
	
		for ( int i = 0; i < files.length; i++  ){
			if ( files[i].isDirectory() ) {
				addSourceDirectories( prefix, files[i], dependencies);
			} else {
				String name = files[i].getParentFile().getAbsolutePath().replace('\\', '/');
				int pos = name.indexOf(prefix);
				name = name.substring(pos);
				
				if (!dependencies.contains(name)) {
					dependencies.add(name);
				}
			}
		}	
	}
	
	/**
	 * Get directories if they contain source code
	 * 
	 * @author tniro
	 * 
	 */		
	public static Collection<String> getSourceDirectories(NamedElement projectElement, String subdir) {
		Collection<String> dependencies = new ArrayList<String>();
		
		IProject project = ProjectFactory.getProject( projectElement, new NullProgressMonitor());
		if ( project != null) {
			String location = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
				+ project.getFullPath().toString() + "/" + subdir ;		//$NON-NLS-1$
			File dir = new File(location);
			addSourceDirectories( subdir, dir, dependencies);
		}
		return dependencies;
	}
	
	/**
	 * Extract the linked resources and use them as make variables.
	 * 
	 * @author tniro
	 * 
	 */		
	public static Collection<String> getLinkedResources() {
		Collection<String> variables = new ArrayList<String>();
		
		IPathVariableManager pvm = ResourcesPlugin.getWorkspace().getPathVariableManager();
		String [] vars = pvm.getPathVariableNames();
		for(int i=0; i < vars.length; i++) {
			IPath path = pvm.getValue(vars[i]);
			String location = path.toString();
			if (path.getDevice() != null) {
				location = location.replaceFirst(path.getDevice(), EMPTY);
			}
			variables.add(vars[i] + "= " + location);		//$NON-NLS-1$
		}
		
		return variables;
	}
}
