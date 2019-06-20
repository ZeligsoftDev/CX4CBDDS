package com.zeligsoft.ce.build.test;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.ce.build.factory.ProjectFactory;



public class ProjectTest extends TestCase {
	
	protected final static String TEST_MODEL = "com.zeligsoft.ce.build.test/models/ProjectTestModel.emx";
	protected URI modelURI = null;
	protected ResourceSet resourceSet = null;	
	protected Resource resource = null;
	
	protected Package model = null;	

	public ProjectTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {

		// needed resource set
		resourceSet = new ResourceSetImpl();
				
		modelURI = URI.createPlatformPluginURI(TEST_MODEL, true);		
		resource = resourceSet.getResource(modelURI, true);
		model = (Package) EcoreUtil.getObjectByType( resource.getContents(), 
				UMLPackage.Literals.PACKAGE );		
	}

	protected void tearDown() throws Exception {
		resourceSet = null;
		modelURI = null;		
		resource = null;
		model = null;			
	}

	
	public void test_create_model() {
		
		IProgressMonitor monitor = new NullProgressMonitor();
		
		// create project for the model .
		IProject project = ProjectFactory.getProject( model, monitor);
		assertNotNull( "Unable to create project for model.", project );
		
		IProject project2 = ProjectFactory.getProject( model, monitor);
		assertEquals( "Expecting projects to be the same.", project, project2);
	}
	
	public void test_create_all() {
	
		IProgressMonitor monitor = new NullProgressMonitor();
		
		for (TreeIterator<EObject> iter = model.eAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();

			if ( eObject instanceof Component) {
				// create project for the  component.
				IProject project = ProjectFactory.getProject( eObject, monitor);
				assertNotNull( "Unable to create project.", project );
				
				IProject project2 = ProjectFactory.getProject( eObject, monitor);
				assertEquals( "Expecting projects to be the same.", project, project2);
			
			} else {
				IProject project = ProjectFactory.getProject( eObject, monitor);
				assertNull( "Expected project creattion to fail.", project );				
			}

		}
	}
	
	public void test_add_targets() {
		
		IProgressMonitor monitor = new NullProgressMonitor();
		
		for (TreeIterator<EObject> iter = model.eAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();

			if ( eObject instanceof Component) {
				// create project for the  component.
				IProject project = ProjectFactory.getProject( eObject, monitor);
				assertNotNull( "Unable to get project.", project );
				

				ProjectFactory.addTarget(project, "make "+((Component)eObject).getName() + " all", ((Component)eObject).getName()+".all");
				ProjectFactory.addTarget(project, "make clean", "clean");
				ProjectFactory.addTarget(project, "make "+((Component)eObject).getName() + " all", ((Component)eObject).getName()+".all");
				
			} else {
				IProject project = ProjectFactory.getProject( eObject, monitor);
				assertNull( "Expected project creattion to fail.", project );				
			}

		}
	}	
}
