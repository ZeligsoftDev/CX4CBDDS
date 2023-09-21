/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.typesystem.uml2;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowComponentHelper;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * This workflow component writes UML2 models with their profiles to a directory.
 * 
 * <h2>Properties</h2>
 * <ul>
 * <li>inputSlot (required): Slot name containing the UML model.
 * <li>outPath: Output path (within destinationFolder)
 * <li>destinationFolder: Base path (default: './')
 * <li>useUML1x: Write .uml2 files (extension used by UML2 v1.x). Default: false.
 * </ul> 
 * @author Benedikt Niehues (Initial implementation)
 * @author Karsten Thoms (docs, maintainance)
 * @since 4.2
 */
public class UML2Writer extends AbstractWorkflowComponent {
	private static final Logger LOG = LogManager.getLogger(UML2Writer.class);

	private String outPath;

	private String destinationFolder = "./";

	private String inputSlot = WorkflowContext.DEFAULT_SLOT;
	
	private boolean useUML1x = false;

	public String getDestinationFolder() {
		return destinationFolder;
	}

	public void setDestinationFolder(final String destinationFolder) {
		this.destinationFolder = destinationFolder;
		if (!this.destinationFolder.equals("")) {
			if (!this.destinationFolder.endsWith("/")) {
				this.destinationFolder += "/";
			}
		} else {
			this.destinationFolder = "./";
		}
	}

	public void setInputSlot(final String p) {
		this.inputSlot = p;
	}

	public void setOutPath(final String p) {
		this.outPath = p;
		if (!this.outPath.endsWith("/")) {
			this.outPath += "/";
		}
		if (this.outPath.startsWith("/")) {
			this.outPath = this.outPath.substring(1);
		}
	}
	
	public void setUseUML1x(boolean useUML1x) {
		this.useUML1x = useUML1x;
	}

	public void checkConfiguration(final Issues issues) {
		if (!WorkflowComponentHelper.isParamSet(inputSlot)) {
			issues.addError("Parameter 'inputSlot' must be set");
		}
		if (!WorkflowComponentHelper.isLegalDir(destinationFolder)) {
			issues.addError("Property 'destinationFolder' does not specify a legal directory");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void invokeInternal(final WorkflowContext ctx,
			final ProgressMonitor monitor, final Issues issues) {

		LOG.info("running UML2Writer");
		final Object slotContent = ctx.get(inputSlot);
		if (slotContent == null) {
			issues.addError(this, "slot '" + inputSlot + "' is empty.");
			return;
		}
		if (!(slotContent instanceof Collection<?>
				|| slotContent instanceof org.eclipse.uml2.uml.Package)) {
			issues.addError(this, "slot '" + inputSlot
					+ "' does not contain a list, a model or a profile",
					slotContent);
			return;
		}
		ResourceSetImpl rsImpl = new ResourceSetImpl();
		//this is for Rational Software Modeler
		Resource.Factory factory = (Resource.Factory) Resource.Factory.Registry.INSTANCE
				.getExtensionToFactoryMap().get(getUMLFileExtension());
		rsImpl.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"emx", factory);
		rsImpl.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"epx", factory);

		if (slotContent instanceof Collection<?>) {
			Iterator<?> it = ((Collection<Object>) slotContent).iterator();
			while (it.hasNext()) {
				Object o = it.next();
				if (o instanceof Package) {
					Package model = (Package) o;
					saveModel(model, rsImpl);
				}
			}
		} else if (slotContent instanceof Package){
			saveModel((Package)slotContent, rsImpl);
		}
		for (Resource resource: rsImpl.getResources()) {
			resource.unload();
		}
	}

	private void saveModel(Package model, ResourceSet rsImpl) {
		// compute file name, e.g. './src-gen/myModel.uml"
		String modelFile = destinationFolder + outPath + model.getName() + "."+getUMLFileExtension();
		
		// create a resource with the model as contents
		final URI fileURI = URI.createFileURI(modelFile);
		Resource r = rsImpl.createResource(fileURI);
		r.getContents().add(model);
		// copy the contents
		for (Iterator<?> allContents = UML2Util.getAllContents(model, true, false); allContents.hasNext();) {
			EObject eObject = (EObject) allContents.next();
			if (eObject instanceof Element) {
				r.getContents().addAll(((Element) eObject).getStereotypeApplications());
			}
		}
		try {
			r.save(null);
		} catch (IOException e) {
			LOG.debug(e.getMessage());
		}
		for (Resource resource: rsImpl.getResources()) {
			resource.unload();
		}
	}
	
	/**
	 * Returns the proper UML file extension.
	 * @return "uml2" for UML2 v1.x, "uml" for UML2 v2.x
	 */
	private String getUMLFileExtension () {
		return useUML1x ? "uml2" : "uml";
	}

}
