/**
 * The Software and documentation are Copyright 2013 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls.commands;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.osgi.framework.Bundle;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.prismtech.domain.sca.ppls.vpm.Configuration;
import com.prismtech.domain.sca.ppls.vpm.VPModel;
import com.zeligsoft.base.util.WorkflowUtil;
import com.zeligsoft.cx.build.factory.ProjectFactory;

/**
 * Command generating a Spectra CX Model Variant of a superset model from a
 * Configuration in a VPModel. The generated model variant will be generated in
 * the same directory as the source VPModel. If the configuration specified that
 * XML descriptors should be generated, those will be generated separately in
 * the directory specified in the superset model.
 * 
 * @author mciobanu
 * 
 */
public class GenerateFinalModelCommand extends AbstractTransactionalCommand {
	private Configuration configuration;
	
	public GenerateFinalModelCommand(TransactionalEditingDomain domain,
			String label, Map<?, ?> options, List<?> affectedFiles, EObject configuration) {
		super(domain, label, null, affectedFiles);		
		this.configuration = (Configuration) configuration;
	}

	@Override
	protected CommandResult doExecuteWithResult(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		generateSCA(configuration);

		
		return CommandResult.newOKCommandResult();
	}

	private static void generateSCA(EObject element)
	{
		NamedElement cxTemplate = null;
		Configuration config = (Configuration)element;
		VPModel vpModel = (VPModel)config.eContainer();
		String resourceURIString = vpModel.getSource();
		Resource res = UMLModeler.getEditingDomain().getResourceSet().getResource(URI.createURI(resourceURIString, true), true);
		if( res != null && res.getErrors().isEmpty()) {
			cxTemplate = UMLUtil.findNamedElements(res, vpModel.getQualifiedName()).toArray(new NamedElement[1])[0];
		}
		IProject testProject;
		Path testProjectPath;
		
		// create project
		testProject = ProjectFactory.getProject(cxTemplate, null, ProjectFactory.MODE_CREATE_BASIC);		
				
		// generate code
		Map<String, String> parameters = new HashMap<String, String>();
		String MODEL_URI_STRING = "modelURI"; //$NON-NLS-1$
	
		String bundleName = "com.prismtech.domain.sca.ppls"; //$NON-NLS-1$
		String workflowPath = "workflow/generateCXModel.oaw"; //$NON-NLS-1$
				
		testProjectPath = (Path) testProject.getLocation();
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		String location = root.getLocation().toOSString();
		
		parameters.put("platform-uri", location);//$NON-NLS-1$
		
		// where we want to look for a build environment
		if (element instanceof NamedElement) {
			parameters.put("buildElement", //$NON-NLS-1$
				((NamedElement) element).getQualifiedName());
		}
		parameters.put("src-gen", testProjectPath.makeAbsolute().toString());//$NON-NLS-1$
		parameters.put(MODEL_URI_STRING, element.eResource().getURI().toString());
		parameters.put("generatedProject", testProject.getName()); //$NON-NLS-1$
				
		Map<String, Object> slotContents = new HashMap<String, Object>();
		slotContents.put("element", element);//$NON-NLS-1$
		slotContents.put("progressMonitor", new NullProgressMonitor());//$NON-NLS-1$
			
		Bundle bundle = Platform.getBundle(bundleName); 
		URL workflow = bundle.getResource(workflowPath);
		
		WorkflowUtil.executeWorkflow (workflow, new NullProgressMonitor(), parameters, slotContents);		
	}

}
