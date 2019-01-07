package com.zeligsoft.domain.sca.build.xtend.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.ce.build.factory.ProjectFactory;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.domain.sca.utils.CORBADomainNames;
import com.zeligsoft.domain.sca.utils.SCANames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Helper utilities for build environment generation scripts for SCA domain.
 * 
 * @author tniro
 * 
 */
public class SCABuildEnvFuncs {

	private static final String CF = "coreFramework";							//$NON-NLS-1$	
	private static final String CF_DEFINES = "coreFrameworkDefine";				//$NON-NLS-1$
	private static final String CF_INCLUDES = "coreFrameworkInclude";			//$NON-NLS-1$
	private static final String CF_LIBRARIES = "coreFrameworkLibrary";			//$NON-NLS-1$
	private static final String CF_LIBRARY_PATHS = "coreFrameworkLibraryPath";	//$NON-NLS-1$
	
	private static final String ORB = "orb";									//$NON-NLS-1$	
	private static final String ORB_DEFINES = "orbDefine";						//$NON-NLS-1$	
	private static final String ORB_INCLUDES = "orbInclude";					//$NON-NLS-1$	
	private static final String ORB_LIBRARIES = "orbLibrary";					//$NON-NLS-1$	
	private static final String ORB_LIBRARY_PATHS = "orbLibraryPath";			//$NON-NLS-1$
	
	private static final String IDL = "idlCompiler";							//$NON-NLS-1$
	private static final String IDL_FLAGS = "idlFlags";							//$NON-NLS-1$
	private static final String IDL_INCLUDES = "idlInclude";					//$NON-NLS-1$
	private static final String IDL_INC_OPTION = "idlIncludeOption";			//$NON-NLS-1$
	private static final String IDL_OUT_OPTION = "idlOutOption";				//$NON-NLS-1$

	private static final String EMPTY = "";										//$NON-NLS-1$
	
	
	
	/**
	 * Getters for sca build environment properties.
	 * 
	 * @author tniro
	 * 
	 */	
	public static String getCoreFramework(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, CF);
	}
	
	public static String getCoreFrameworkDefines(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, CF_DEFINES);
	}
	
	public static String getCoreFrameworkIncludes(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, CF_INCLUDES, 
				BuildEnvFuncs.PATH_SPACE, BuildEnvFuncs.PATH_SPACE_REPLACE);
	}
	
	public static String getCoreFrameworkLibraries(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, CF_LIBRARIES);
	}

	public static String getCoreFrameworkLibraryPaths(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, CF_LIBRARY_PATHS,
				BuildEnvFuncs.PATH_SPACE, BuildEnvFuncs.PATH_SPACE_REPLACE);
	}	
	
	public static String getORB(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, ORB);
	}
		
	public static String getORBDefines(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, ORB_DEFINES);
	}
	
	public static String getORBIncludes(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, ORB_INCLUDES,
				BuildEnvFuncs.PATH_SPACE, BuildEnvFuncs.PATH_SPACE_REPLACE);
	}
	
	public static String getORBLibraries(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, ORB_LIBRARIES);
	}
	
	public static String getORBLibraryPaths(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, ORB_LIBRARY_PATHS,
				BuildEnvFuncs.PATH_SPACE, BuildEnvFuncs.PATH_SPACE_REPLACE);
	}	

	public static String getIDLCompiler(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, IDL);		
	}
	
	public static String getIDLCompilerOptons(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, IDL_FLAGS);
	}
	
	public static String getIDLCompilerIncludePaths(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, IDL_INCLUDES,
				BuildEnvFuncs.PATH_SPACE, BuildEnvFuncs.PATH_SPACE_REPLACE);
	}

	public static String getIDLCompilerIncludeOption(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, IDL_INC_OPTION);
	}
	
	public static String getIDLCompilerOutputOption(Property buildEnv){
		return BuildEnvFuncs.getBuildEnvironmentProperty( buildEnv, IDL_OUT_OPTION);
	}
	
	/**
	 * Determine build environment name from the given SCA implementation.
	 * 
	 * @author tniro
	 * 
	 */	
	public static String getSCABuildEnvironmentName(Artifact artifact){
		//TODO  (load classes from model library)
		if (ZDLUtil.isZDLConcept(artifact, SCANames.SCAIMPLEMENTATION)) {
			for( Property property : artifact.getOwnedAttributes())
			{
				if(property.getType() != null
						&& "SCA_BuildEnvironments::SCABuildEnvironment".equals(property.getType().getQualifiedName())) //$NON-NLS-1$
				{
					return BuildEnvFuncs.getBuildEnvName(property);
				}			
			}
		}
		return EMPTY;
	}

	/**
	 * Return the build environment for the given implmentation
	 * 
	 * @author tniro
	 * 
	 */
	public static Property getSCABuildEnvironment(Artifact artifact){

		if (ZDLUtil.isZDLConcept(artifact, SCANames.SCAIMPLEMENTATION)) {
			for( Property property : artifact.getAllAttributes())
			{
				if(property.getType() != null
						&& property.getType().getQualifiedName().equals("SCA_BuildEnvironments::SCABuildEnvironment") //$NON-NLS-1$
					    && property.getDefaultValue() != null )
				{
					return property;
				}			
			}
		}
		return null;
	}
	
	
	/**
	 * Return all implementations for the given SCA component
	 * 
	 * @author tniro
	 * 
	 */	
	@SuppressWarnings("unchecked")
	public static Collection<Artifact> getSCAImplementations(Component component)
	{
		//TODO  talk to sean, sca package implmentation clashes with struc reali implementation.		
		if (!ZDLUtil.isZDLConcept(component, SCANames.SCACOMPONENT) 
				&& !ZDLUtil.isZDLConcept(component, SCANames.SCADEVICE))
			return Collections.emptyList();
		
		return (Collection<Artifact>)ZDLUtil.getValue(component, 
				SCANames.SCASOFTWARE_PACKAGE, SCANames.SCASOFTWARE_PACKAGE__IMPLEMENTATION);
		
	}	

	/**
	 * Determine if given implemenation has a build environment
	 * 
	 * @author tniro
	 * 
	 */	
	public static boolean hasSCABuild(Artifact artifact) {
		return getSCABuildEnvironment(artifact) != null;
	}
		
	/**
	 * Get the target name from the implementations code attribute.
	 * 
	 * @author tniro
	 * 
	 */	
	public static String getSCATargetName(NamedElement artifact){
	
		if (!ZDLUtil.isZDLConcept(artifact, SCANames.SCAIMPLEMENTATION))
			return EMPTY;
		
		EObject bin = (EObject)ZDLUtil.getValue(artifact, SCANames.SCAIMPLEMENTATION,
				SCANames.SCAIMPLEMENTATION__CODE);
		if ( bin == null)
			return EMPTY;
		
		String target = (String)ZDLUtil.getValue(bin, SCANames.SCABINARY, SCANames.SCABINARY__FILE);
		if ( target != null ) {
			//TODO Path
			File f = new File( target );
			target = f.getName();
		}
		
		return target;
	}

	/**
	 * Return the corresponding idl file for the interface 
	 * 
	 * @author tniro
	 * 
	 */	
	private static EObject findIdlFile(EObject idl) {
		
		if ( idl == null)
			return null;

		for (EObject e = idl.eContainer(); e != null; ) {
			if (ZDLUtil.isZDLConcept(e, CORBADomainNames.IDLFILE)) {
				return e;
			}
			e = e.eContainer();
		}	
		
		return null;
	}
	
	/**
	 * Get the idl file name from its attributes. 
	 * 
	 * @author tniro
	 * 
	 */	
	public static String getIDLName(EObject eObject) {
		
		String str = EMPTY;
		
		if (ZDLUtil.isZDLConcept(eObject, CORBADomainNames.IDLFILE)) {
			str = (String)ZDLUtil.getValue(eObject, CORBADomainNames.IDLFILE, CORBADomainNames.IDLFILE__NAME);
		} else if (ZDLUtil.isZDLConcept(eObject, CORBADomainNames.CORBAINTERFACE)) {
			EObject e = findIdlFile(eObject);
			if (e != null ) {
				str = (String)ZDLUtil.getValue(e, CORBADomainNames.IDLFILE, CORBADomainNames.IDLFILE__NAME);
			}
		}
		
		if (str == null)
			str = EMPTY;
		
		return str;
	}
	
	/**
	 * Extract the idl file location. 
	 * 
	 * @author tniro
	 * 
	 */		
	public static String getIDLDirectory(EObject eObject) {

		String directory = null;		
		
		if (ZDLUtil.isZDLConcept(eObject, CORBADomainNames.IDLFILE)) {
			directory = (String)ZDLUtil.getValue(eObject, CORBADomainNames.IDLFILE, CORBADomainNames.IDLFILE__LOCATION);
		} else if (ZDLUtil.isZDLConcept(eObject, CORBADomainNames.CORBAINTERFACE)) {		
			EObject e = findIdlFile((Interface)eObject);
			if (e != null ) {
				directory = (String)ZDLUtil.getValue(e, CORBADomainNames.IDLFILE, CORBADomainNames.IDLFILE__LOCATION);
			}
		}
		
		if (directory == null || directory.length() == 0 ) {
			return "/NOT/FOUND"; 	//$NON-NLS-1$
		}
		//TODO look at a nicer way of doing this..
		return directory.replace('\\', '/');
	}
			
	/**
	 * Build the idl target name using the build environment and the given 
	 * interaface or artifact. 
	 * 
	 * @author tniro
	 * 
	 */		
	public static String getIDLTarget(Property buildEnv, EObject eObject) {
		if (eObject == null)
			return EMPTY;
		
		String prefix = EMPTY;
		String extension = EMPTY;
		
		if ( buildEnv != null ) {
			prefix = BuildEnvFuncs.getLibraryFilePrefix(buildEnv);
			extension = BuildEnvFuncs.getLibraryFileExtension(buildEnv);
		}
					
		return prefix + getIDLName(eObject) + extension;
	}
	
	/**
	 * Add make targets to the CDT project. 
	 * 
	 * @author tniro
	 * 
	 */
	public static String addSCAMakeTarget(NamedElement element, String targetName) {
		if ( element != null && targetName != null) {
			
			IProject project = ProjectFactory.getProject(element, null);
			if ( project != null ) {
				//TODO move to non-ui plugin store...
				String buildCmd = ZeligsoftCXUIPlugin.getDefault().getPreferenceStore()
					.getString(ZeligsoftCXUIPlugin.MAKE_LOCATION);
				File f = new File(targetName);
				ProjectFactory.addTarget(project, buildCmd, f.getName());
			}
		}
		return EMPTY;
	}
	
	//TODO more templ into codegen get rid of common func.
	// talk to laura about name.
	public static String getFullInterfaceName(Interface aInterface){
		return aInterface.getNearestPackage().getName() + "_" + aInterface.getName();	//$NON-NLS-1$
	}	
	
	/**
	 * Determine IDL file dependencies for the given idl interface/file. 
	 * 
	 * @author tniro
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static Collection<EObject> getSCADependentIDLFiles(EObject idl) {
		Collection<EObject> idlFiles = new HashSet<EObject>();

		EObject e = findIdlFile(idl);
		if (e == null)
			return idlFiles;	
		
		EList<EObject> list = (EList<EObject>)ZDLUtil.getValue( e, CORBADomainNames.IDLFILE, 
				CORBADomainNames.IDLFILE__IMPORTEE );
		
		for( EObject eObject : list ) {
			EObject result = (EObject)ZDLUtil.getValue( eObject, CORBADomainNames.IDLIMPORT, 
					CORBADomainNames.IDLIMPORT__TARGET );
			if ( result != null ) {
				idlFiles.add(result);
			}
		}
		return idlFiles;
	}	
	
	/**
	 * Get all IDL interfaces for the given component. 
	 * 
	 * @author tniro
	 * 
	 */
	public static Collection<Interface> getSCAIDLInterfaces(Component component) {
		Collection<Interface> interfaces = new HashSet<Interface>();
		
		Component c = (Component)ZDLUtil.getValue(component, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
		if ( c != null) {
			interfaces.addAll(c.getProvideds());
			interfaces.addAll(c.getRequireds());
			for( Port p : c.getOwnedPorts()) {
				interfaces.addAll(p.getProvideds());
				interfaces.addAll(p.getRequireds());
			}
		}
		
		return interfaces;		
	}
	
	/**
	 * Get all IDL FIle targets for the given component. 
	 * i.e. library to build 
	 * 
	 * @author tniro
	 * 
	 */	
	public static Collection<EObject> getSCAIDLTargetFiles(Component component) {
		Collection<EObject> idlFiles = new HashSet<EObject>();
		
		for ( Interface i : getSCAIDLInterfaces(component)) {
			EObject eObj = findIdlFile(i);
			if ( eObj != null) {
				idlFiles.add(eObj);
				idlFiles.addAll(getSCADependentIDLFiles(i));
			}
		}
		
		return idlFiles;		
	}
	
	/**
	 * Determine if the given port interface has generated code. 
	 * 
	 * @author tniro
	 * 
	 */		
	public static boolean hasSCAGeneratedSource(String dir, Interface i) {
		IProject project = ProjectFactory.getProject(i, null);
		if (project ==null)
			return false;
/*				
		Path path = new Path(project.getFullPath().toString() + "/" + dir + "/" + getFullInterfaceName(i)); //$NON-NLS-1$ //$NON-NLS-2$
		boolean rc = (ResourcesPlugin.getWorkspace().getRoot().findMember(path) != null );
		return rc;		
*/
		String location = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
		+ project.getFullPath().toString() + "/" + dir + "/" + getFullInterfaceName(i);	//$NON-NLS-1$
		File file = new File( location );
		return file.exists();
	}
	
	/**
	 * Get all ports owned by this component. 
	 * 
	 * @author tniro
	 * 
	 */		
	public static Collection<Port> getSCAPorts(Component component) {
		Collection<Port> ports = new HashSet<Port>();
		
		Component c = (Component)ZDLUtil.getValue(component, ZMLMMNames.STRUCTURAL_REALIZATION, ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
		if ( c != null) {
			ports.addAll(c.getOwnedPorts());
		}
		
		return ports;
	}
}
