package com.zeligsoft.domain.sca.build.workflow;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.uml2.uml.Component;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.util.ProgressMonitorAdapter;

import com.zeligsoft.base.util.ZeligsoftURIConverter;
import com.zeligsoft.ce.build.factory.ProjectFactory;
import com.zeligsoft.domain.sca.build.l10n.Messages;



public class GenerateBuildFiles implements IRunnableWithProgress {

	public static final String PROJECT_DIRECTORY = "projectDir"; //$NON-NLS-1$
	public static final String START_ELEMENT = "startElement"; //$NON-NLS-1$
	public static final String MODEL_URI = "modelURI"; //$NON-NLS-1$

	private EObject eObject = null;
	private Map<String, String> properties = new HashMap<String,String>();
	private String workflow = "workflow/scabuild.oaw";
	
	public GenerateBuildFiles(EObject eObject) {
		super();
	
		this.eObject = eObject;
	}
	
	@SuppressWarnings("unchecked")	
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {

		Component component = null;
		
		if ( eObject instanceof Component) {
			component = (Component)eObject;
		} else
		{
			Exception e = new Exception(Messages.ExpectingComponent); 
			throw new InvocationTargetException(e);
		}
		
		// ensure that URIs resolved from relative URIs are corrected to
		// eliminate '..' segments that cause unwanted resource aliasing
		ZeligsoftURIConverter.install( component.eResource().getResourceSet() );
	
		// open a project, we expect it to exists
		IProject project = ProjectFactory.getProject( component.getModel(), monitor );
		if ( project == null ) {
			Exception e = new Exception(Messages.ExpectingProject);
			throw new InvocationTargetException(e);
		}
		
		// Where output files will be placed
		String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
			+ project.getFullPath().toOSString();
		properties.put(PROJECT_DIRECTORY, path);

		// Element from which we are to start generating build files
		properties.put(START_ELEMENT, component.getQualifiedName());
		
		// Get the corresponding MODEL URI
		properties.put(MODEL_URI,component.eResource().getURI().toString());
		
		if (monitor != null) {
			monitor.subTask(Messages.GeneratingBuildFiles);
		}

		new WorkflowRunner().run( workflow, new ProgressMonitorAdapter(monitor), 
				properties, Collections.EMPTY_MAP);
		
		if (monitor != null) {
			monitor.subTask(Messages.GeneratingBuildFilesCompleted);
		}		
	}
}
