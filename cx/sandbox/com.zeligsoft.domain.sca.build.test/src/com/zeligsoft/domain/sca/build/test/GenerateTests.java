package com.zeligsoft.domain.sca.build.test;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.ce.build.factory.ProjectFactory;
import com.zeligsoft.domain.sca.build.workflow.GenerateBuildFiles;

public class GenerateTests extends AbstractBuildTests {

	public GenerateTests(String name) {
		super(name);
	}

	public void test_generate() {

		// iterate through the model
		// find an SCA Component
		// and generate the information for it
		
		for (TreeIterator<EObject> iter = model.eAllContents(); iter.hasNext();) {
			EObject eObject = iter.next();

			if ( eObject instanceof Component) {
				Component component = (Component)eObject;
				if ( component.isStereotypeApplied(applicationStereotype) ) {
					
					IProject project = ProjectFactory.getProject( component.getModel(), new NullProgressMonitor() );
					assertNotNull( "Unable to create project.", project );
					
					String root = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + project.getFullPath().toOSString();

					GenerateBuildFiles generator = new GenerateBuildFiles(eObject);
					try {
						boolean rc = new File( root + "/comps" ).mkdir();
						rc = new File( root + "/comps/Sender" ).mkdir();
						rc = new File( root + "/comps/Sender/file1.cpp" ).createNewFile();
						rc = new File( root + "/comps/Sender/file1.h" ).createNewFile();
						rc = new File( root + "/comps/Sender/file2.cpp" ).createNewFile();
						rc = new File( root + "/comps/Sender/file2.h" ).createNewFile();
						rc = new File( root + "/comps/Sender/file3.cpp" ).createNewFile();
						rc = new File( root + "/comps/Sender/file3.h" ).createNewFile();
						
						rc = new File( root + "/comps/Sender/worker" ).mkdir();
						rc = new File( root + "/comps/Sender/worker/file4.cpp" ).createNewFile();
						rc = new File( root + "/comps/Sender/worker/file4.h" ).createNewFile();
										
						rc = new File( root + "/comps/Receiver" ).mkdir();
						rc = new File( root + "/comps/Receiver/file1.cpp" ).createNewFile();
						rc = new File( root + "/comps/Receiver/file1.h" ).createNewFile();
						rc = new File( root + "/comps/Receiver/file2.cpp" ).createNewFile();
						rc = new File( root + "/comps/Receiver/file2.h" ).createNewFile();
						rc = new File( root + "/comps/Receiver/file3.cpp" ).createNewFile();
						rc = new File( root + "/comps/Receiver/file3.h" ).createNewFile();
						
						rc = new File( root + "/comps/Receiver/worker" ).mkdir();
						rc = new File( root + "/comps/Receiver/worker/file4.cpp" ).createNewFile();
						rc = new File( root + "/comps/Receiver/worker/file4.h" ).createNewFile();
						
						
						rc = new File( root + "/ports" ).mkdir();
						rc = new File( root + "/ports/Outgoing" ).mkdir();
						rc = new File( root + "/ports/Outgoing/file1.cpp" ).createNewFile();
						rc = new File( root + "/ports/Outgoing/file1.h" ).createNewFile();
						rc = new File( root + "/ports/Outgoing/file2.cpp" ).createNewFile();
						rc = new File( root + "/ports/Outgoing/file2.h" ).createNewFile();
						rc = new File( root + "/ports/Outgoing/file3.cpp" ).createNewFile();
						rc = new File( root + "/ports/Outgoing/file3.h" ).createNewFile();
						
						rc = new File( root + "/ports/Incoming" ).mkdir();
						rc = new File( root + "/ports/Incoming/file1.cpp" ).createNewFile();
						rc = new File( root + "/ports/Incoming/file1.h" ).createNewFile();
						rc = new File( root + "/ports/Incoming/file2.cpp" ).createNewFile();
						rc = new File( root + "/ports/Incoming/file2.h" ).createNewFile();
						rc = new File( root + "/ports/Incoming/file3.cpp" ).createNewFile();
						rc = new File( root + "/ports/Incoming/file3.h" ).createNewFile();
						
						rc =new File( root + "/devs" ).mkdir();						
						project.refreshLocal(100, null);						
						generator.run( new NullProgressMonitor() );
					} catch ( Exception e ) {
						e.printStackTrace();
					}
					return;
				}
			}			
		}
		
	}
}
