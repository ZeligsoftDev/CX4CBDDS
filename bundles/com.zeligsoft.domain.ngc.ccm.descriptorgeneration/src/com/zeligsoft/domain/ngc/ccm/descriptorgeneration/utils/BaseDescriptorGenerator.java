package com.zeligsoft.domain.ngc.ccm.descriptorgeneration.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.ngc.ccm.descriptorgeneration.l10n.Messages;

public abstract class BaseDescriptorGenerator extends AbstractWorkflowComponent {

	public static final String MODEL_URI_STRING = "modelURI";
	public static final String SRC_GEN = "src-gen";
	public static final String ELEMENT_STRING = "element";
	private String srcGen;
	private String pathnamesSlot;

	public BaseDescriptorGenerator() {
		super();
	}

	public void checkConfiguration(Issues issues) {
	}

	/**
	 * Pathnames of generated files will be written into.
	 * 
	 * @param value
	 */
	public void setPathnamesSlot(String value) {
		this.pathnamesSlot = value;
	}

	/**
	 * @return Pathnames of generated files will be written into.
	 */
	public String getPathnamesSlot() {
		return pathnamesSlot;
	}

	public void setSrcGen(String srcGenPath) {
		srcGen = srcGenPath;
	}

	protected void executeWorkflow(Element umlElement, String workflow, ProgressMonitor monitor, Set<String> pathnames,
			Issues issues) {
		// Gather the workflow parameters
		String modelUriString = umlElement.eResource().getURI().toString();

		Map<String, String> properties = new HashMap<String, String>();
		properties.put(MODEL_URI_STRING, modelUriString);
		properties.put(SRC_GEN, srcGen);

		HashMap<String, Object> externalSlotContents = new HashMap<String, Object>();
		externalSlotContents.put(ELEMENT_STRING, umlElement);

		WorkflowEngine workflowEngine = new WorkflowEngine();
		IssuesImpl subWorkflowIssues = new IssuesImpl();

		String[] bindingsForErrorMessages = { workflow, getElementQNameOrURI(umlElement), modelUriString };

		// Prepare workflow engine
		final boolean configOK = workflowEngine.prepare(workflow, new NullProgressMonitor(), properties);
		if (!configOK) {
			issues.addError(NLS.bind(Messages.GenerateDescriptors_FailurePreparingWorkflow, bindingsForErrorMessages));
		}

		// Check if the user has cancelled the operation
		if (monitor.isCanceled()) {
			return;
		}

		// Execute workflow
		final boolean executeOK = workflowEngine.executeWorkflow(externalSlotContents, subWorkflowIssues);
		if (!executeOK || subWorkflowIssues.getErrors().length > 0) {
			StringBuilder errorStrBuilder = new StringBuilder();
			errorStrBuilder
					.append(NLS.bind(Messages.GenerateDescriptors_FailureExecutingWorkflow, bindingsForErrorMessages));
			for (MWEDiagnostic issue : subWorkflowIssues.getErrors()) {
				errorStrBuilder.append(System.getProperty("line.separator"));
				errorStrBuilder.append(issue.getMessage());
			}
			issues.addError(errorStrBuilder.toString());
		}

		// Get workflow output: set of paths
		@SuppressWarnings("unchecked")
		final Set<String> paths = (Set<String>) workflowEngine.getContext().get(getPathnamesSlot());
		if (paths != null) {
			pathnames.addAll(paths);
		}
	}

	private String getElementQNameOrURI(Element umlElement) {
		if (umlElement instanceof NamedElement) {
			return ((NamedElement) umlElement).getQualifiedName();
		}
		return EcoreUtil.getURI(umlElement).toPlatformString(true);
	}

	public void generateAllDescriptorsFor(String concept, Namespace umlNamespace, String workflow,
			ProgressMonitor monitor, Set<String> pathnames, Issues issues) {
		List<Element> elements = ZDLUtil.getAllElementsByConcept(umlNamespace, concept);
		int numberOfElements = elements.size();
		monitor.beginTask(NLS.bind(Messages.GenerateAllDescriptors_TaskTitle, umlNamespace.getQualifiedName()),
				numberOfElements);
		for (Element element : elements) {
			if (monitor.isCanceled()) {
				break;
			}
			executeWorkflow(element, workflow, monitor, pathnames, issues);
		}
		monitor.done();
	}

}