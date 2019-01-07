package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.net4j.util.om.monitor.OMMonitor;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zeligsoft.cx.codegen.ui.actions.WorkflowJobFactory;
import com.zeligsoft.cx.codegen.ui.transformregistry.WorkflowEntry;
import com.zeligsoft.cx.ui.wizard.ZeligsoftModelWizardContentCreator;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.DataCollectingRhapsodyProjectLocator;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.IRhapsodyProjectLocationStrategy;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.LocalRhapsodyProjectLocator;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.LocateProjectViaRhapsodyAPI;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImport;

public class ModelServicesImpl implements ICXModelServices {

	/**
	 * The uml2 model root is shared between two threads. It should only be
	 * accessed through its synchronized accessors {@link #getUml2ModelRoot()}
	 * and {@link #setUml2ModelRoot(org.eclipse.uml2.uml.Package)}.
	 */
	private org.eclipse.uml2.uml.Package uml2ModelRoot;
	
	private IStatus validationStatus;

	protected synchronized org.eclipse.uml2.uml.Package getUml2ModelRoot() {
		return uml2ModelRoot;
	}

	protected synchronized void setUml2ModelRoot(
			org.eclipse.uml2.uml.Package pkg) {
		this.uml2ModelRoot = pkg;
	}

	@Override
	public boolean transformToUML2(final String modelName) {
		final UIJob createModelJob = getCreateUml2ModelJob(modelName);

		final IRhapsodyProjectLocationStrategy projectLocator = new LocateProjectViaRhapsodyAPI();

		final Job transformFromRhapsodyJob = getTransformToUml2Job(projectLocator);

		try {
			createModelJob.schedule();
			createModelJob.join();
			boolean success = createModelJob.getResult().isOK();
			if (success) {
				transformFromRhapsodyJob.schedule();
				transformFromRhapsodyJob.join();
				success = transformFromRhapsodyJob.getResult().isOK();
			}
			return success;
		} catch (InterruptedException e) {
			return false;
		}
	}

	/**
	 * Create new DDS4CCM project with model
	 * 
	 * @param projectName
	 * @return
	 */
	private org.eclipse.uml2.uml.Package createUml2Model(
			final String projectName) {

		String modelFolder = "ModelFiles";
		String templatePluginPath = "/com.zeligsoft.domain.dds4ccm.ui/templates/dds4ccmModelTemplate.emx";
		String perspectiveId = "com.zeligsoft.domain.dds4ccm.ui.perspectives.DDS4CCMPerspective";
		String modelConcept = "DDS4CCM::DDS4CCM::DDS4CCMModel";
		String modelName = projectName;

		URI templateURI = URI.createPlatformPluginURI(templatePluginPath, true); //$NON-NLS-1$

		boolean result = ZeligsoftModelWizardContentCreator.createContent(
				projectName, null, modelFolder, projectName, modelConcept,
				null, templateURI, modelName, perspectiveId);

		if (result != true) {
			return null;
		}
		String modelPath;
		modelPath = projectName + System.getProperty("file.separator")
				+ modelFolder + System.getProperty("file.separator")
				+ modelName + ".emx";

		URI modelURI = URI.createPlatformResourceURI(modelPath, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource modelResource = resourceSet.getResource(modelURI, true);

		final org.eclipse.uml2.uml.Package rootPackage = (org.eclipse.uml2.uml.Package) modelResource
				.getContents().get(0);
		return rootPackage;
	}

	public boolean transformToUML2WithProgress(final String modelName,
			final OMMonitor monitor) {
		monitor.begin(4);

		UIJob createModelJob = getCreateUml2ModelJob(modelName);

		final DataCollectingRhapsodyProjectLocator projectLocator = new DataCollectingRhapsodyProjectLocator();

		Job transformFromRhapsodyJob = getTransformToUml2Job(projectLocator);

		try {
		final IStatus status = new JobQueueMonitor.Builder()
			.job(createModelJob,20)
			.job(transformFromRhapsodyJob,80)
			.build()
			.run(monitor);
		
			return status.isOK();
		} finally {
			monitor.done();
			projectLocator.getDataCollector().dump("c:\\tmp\\RP-usageData.txt");
		}

	}

	public Job getTransformToUml2Job(
			final IRhapsodyProjectLocationStrategy projectLocator) {
		Job transformFromRhapsodyJob = new Job("Transform from Rhapsody") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Injector injector = Guice
						.createInjector(new RhapsodyImportModule());
				RhapsodyImport importer = injector
						.getInstance(RhapsodyImport.class);
				org.eclipse.uml2.uml.Package pkg = getUml2ModelRoot();
				importer.importRhapsodyModel(pkg, projectLocator);
				try {
					pkg.eResource().save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					return new Status(
							Status.ERROR,
							"com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server",
							"Exception saving model", e);
				}
				return Status.OK_STATUS;
			}

		};
		return transformFromRhapsodyJob;
	}

	public boolean fastTransformToUML2WithProgress(final String projectName,
			final Object project, final OMMonitor monitor) {
		monitor.begin(4);

		UIJob createModelJob = getCreateUml2ModelJob(projectName);

		IRhapsodyProjectLocationStrategy projectLocator = new LocalRhapsodyProjectLocator(
				project);
		Job transformFromRhapsodyJob = getTransformToUml2Job(projectLocator);

		try {
			createModelJob.schedule();
			createModelJob.join();
			monitor.worked(1);
			boolean success = createModelJob.getResult().isOK();
			if (success) {
				transformFromRhapsodyJob.schedule();
				transformFromRhapsodyJob.join();
				monitor.worked(3);
				success = transformFromRhapsodyJob.getResult().isOK();
			}
			return success;
		} catch (InterruptedException e) {
			return false;
		} finally {
			monitor.done();
		}
	}

	public UIJob getCreateUml2ModelJob(final String projectName) {
		UIJob createModelJob = new UIJob("Create uml2 model") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				setUml2ModelRoot(createUml2Model(projectName));
				return Status.OK_STATUS;
			}

		};
		return createModelJob;
	}

	public Job getCXTransformJob(final String zdlConcept,
			final String modelElementQualifiedName, final String transformId) {
		final WorkflowJobFactory.IElementLocator elementLocator = new WorkflowJobFactory.IElementLocator() {

			@Override
			public EObject getElement() {
				// Convert a Rhapsody qualified name into a UML2 qualified name.
				return convertRpQNameToUml2QName(modelElementQualifiedName);
			}
		};
		final WorkflowJobFactory.IWorkflowsLocator workflowsLocator = new WorkflowJobFactory.IWorkflowsLocator() {
			
			@Override
			public List<WorkflowEntry> getWorkflows() {
				final EObject element = elementLocator.getElement();
				final List<WorkflowEntry> workflows = WorkflowEntry.getWorkflows("Package".equals(zdlConcept)?"com.ibm.xtools.uml.package":zdlConcept, element);
				if("All".equals(transformId)) {
					return workflows;
				}
				for (WorkflowEntry entry : workflows) {
					if(transformId.equals(entry.getDisplayLabel())) {
						return Collections.singletonList(entry);
					}
				}
				return Collections.emptyList();
			}
		};
		
		return new WorkflowJobFactory(elementLocator, workflowsLocator).createJob();
	}

	public Job getModelValidationJob(final String rpElementQName) {
		
		final Job job = new Job("Validate") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final IBatchValidator validator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
				validator.setIncludeLiveConstraints(true);
				final EObject uml2Element = convertRpQNameToUml2QName(rpElementQName);
				setValidationStatus(validator.validate(uml2Element));
				return Status.OK_STATUS;
			}
		};
		return job;
	}

	protected EObject convertRpQNameToUml2QName(
			final String modelElementQualifiedName) {
		final Package uml2Root = getUml2ModelRoot();
		final String umlQualifiedName = uml2Root.getName() + "::" + modelElementQualifiedName.replaceAll("\\.", "::");
		
		// TODO  Might need to be better than this... look for the one with zdlConcept
		final Collection<NamedElement> foundElement = UMLUtil.findNamedElements(uml2Root.eResource(), umlQualifiedName);
		return foundElement.isEmpty() ? uml2Root : foundElement.iterator().next();
	}

	public synchronized IStatus getValidationStatus() {
		return validationStatus;
	}

	protected synchronized void setValidationStatus(IStatus validationStatus) {
		this.validationStatus = validationStatus;
	}
}
