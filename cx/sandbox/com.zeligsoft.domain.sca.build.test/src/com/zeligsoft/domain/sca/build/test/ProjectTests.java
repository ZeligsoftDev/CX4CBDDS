package com.zeligsoft.domain.sca.build.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.domain.sca.build.BuildFactory;

public class ProjectTests extends AbstractBuildTests {

	private final static String FOLDER_DEVICES = "devs"; //$NON-NLS-1$
	private final static String FOLDER_COMPOPNENTS = "comps"; //$NON-NLS-1$
	private final static String FOLDER_BUILDS = "builds"; //$NON-NLS-1$
	private final static String FOLDER_COMMON = "common"; //$NON-NLS-1$
	private final static String FOLDER_MAKES = "mks"; //$NON-NLS-1$
		
	private IProject project = null;
	
	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public ProjectTests(String name) {
		super(name);
	}

	
	/**
	 * Add the given target to the Make Targets View
	 *
	 * @return nothing
	 */		
	private void createFolders( IProject project ) {
/*		
		IPath start = project.getFullPath();
		
		IPath folder = start.append(FOLDER_BUILDS).
		boolean rc = file.mkdir();
		
		ResourcesPlugin.getWorkspace().getRoot().
		
		file = start.append(FOLDER_COMMON).toFile();
		rc = file.mkdir();
		
		file = start.append(FOLDER_COMPOPNENTS).toFile();
		rc = file.mkdir();
		
		file = start.append(FOLDER_DEVICES).toFile();
		rc = file.mkdir();
		
		file = start.append(FOLDER_MAKES).toFile();
		rc = file.mkdir();
				*/
	}	
	
	/**
	 * Test creating a project based on the corresponding element
	 * 
	 * @param name
	 *            my name
	 */	
	public void test_projectCreation()
	{
		// iterate through the model
		// for every element that is a ZML Deployment SCAApplication, SCANode, SCAComponent, SCADevice
		// call createProject, first once we get one, the rest should be the same
		for (TreeIterator<EObject> iter = model.eAllContents(); iter .hasNext();) {
			EObject eObject = iter.next();

			if ( eObject instanceof Component) {
				Component component = (Component)eObject;
				if ( component.isStereotypeApplied( applicationStereotype ) 
						|| component.isStereotypeApplied(nodeStereotype) 
						|| component.isStereotypeApplied(componentStereotype)
						|| component.isStereotypeApplied(deviceStereotype)) {
					IProject tempProject = BuildFactory.createProject( eObject, new NullProgressMonitor() );
					if ( project == null ) {
						project = tempProject;
						createFolders( project );						
					} else {
						assertEquals( "Create project did not return the same project.", tempProject, project );
					}
				}
			}			
		}
	}
	
	// verify folders are created..
}
