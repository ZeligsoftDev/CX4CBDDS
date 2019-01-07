package com.zeligsoft.base.zdl.rhapsody.test.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zeligsoft.cx.ui.wizard.ZeligsoftModelWizardContentCreator;
import com.zeligsoft.domain.dds4ccm.rhapsody.di.RhapsodyImportModule;
import com.zeligsoft.domain.dds4ccm.rhapsody.transform.RhapsodyImport;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ModelImportHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public ModelImportHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);

		Injector injector = Guice.createInjector(new RhapsodyImportModule());
		RhapsodyImport importer = injector.getInstance(RhapsodyImport.class);
		org.eclipse.uml2.uml.Package pkg = createModel("DDS4CCM");
		importer.importRhasodyModel(pkg);
		try {
			pkg.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Create new DDS4CCM project with model
	 * 
	 * @param projectName
	 * @return
	 */
	private org.eclipse.uml2.uml.Package createModel(String projectName) {

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
		return (org.eclipse.uml2.uml.Package) modelResource.getContents().get(0);
	}
}
