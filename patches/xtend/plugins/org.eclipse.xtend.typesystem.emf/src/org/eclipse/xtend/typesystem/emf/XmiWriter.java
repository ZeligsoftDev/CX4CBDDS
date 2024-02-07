/**
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.xtend.typesystem.emf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This component lets you write an EMF model contained in some slot to disc.
 *
 * @author Markus V�lter
 * @since 4.0
 *
 * @deprecated use org.eclipse.mwe.emf.Writer instead
 */
@SuppressWarnings({"unchecked","rawtypes"})
@Deprecated
public class XmiWriter extends AbstractWorkflowComponent {

	// default save options.
	private static final Map saveOptions = new HashMap();

	private static final String COMPONENT_NAME = "XMI Writer";

	static {
		XMIResource resource = new XMIResourceImpl();
		// default save options.
		saveOptions.putAll(resource.getDefaultSaveOptions());
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
	}

	private String modelFile;

	private String inputSlot = WorkflowContext.DEFAULT_SLOT;

	private String pathPrefix = ".";

	/**
	 * Sets the name of the model file.
	 *
	 * @param modelFile
	 *            name of file
	 */
	public void setModelFile(final String modelFile) {
		this.modelFile = modelFile;
	}

	/**
	 * Returns the name of the model file.
	 *
	 * @return name of model file
	 */
	public String getModelFile() {
		return modelFile;
	}

	/**
	 * Sets the name of the input slot.
	 *
	 * @param inputSlot
	 *            name of slot
	 */
	public void setInputSlot(final String inputSlot) {
		this.inputSlot = inputSlot;
	}

	/**
	 * Returns the name of the input slot.
	 *
	 * @return name of slot
	 */
	public String getInputSlot() {
		return inputSlot;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "slot '" + inputSlot + "' => file '" + pathPrefix + "/" + modelFile + "'";
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	public void checkConfiguration(final Issues issues) {
		modelFile = modelFile.replace('\\', '/');
		int p = modelFile.lastIndexOf("/");
		if (p >= 0) {
			pathPrefix = modelFile.substring(0, p + 1);
			modelFile = modelFile.substring(p + 1);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		final Object slotContent = ctx.get(inputSlot);
		if (slotContent == null) {
			issues.addError(this, "slot '" + inputSlot + "' is empty.");
			return;
		}
		if (!(slotContent instanceof Collection<?> || slotContent instanceof EObject)) {
			issues.addError(this, "slot '" + inputSlot + "' neither contains an EList nor an EObject", slotContent);
			return;
		}

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		final URI fileURI = URI.createFileURI(modelFile);// EcoreUtil2.getURI(modelFile);
		ResourceSetImpl rsImpl = new ResourceSetImpl();
		rsImpl.setURIConverter(new XmiWriterURIConverter(pathPrefix));
		Resource r = rsImpl.createResource(fileURI);
		if (r instanceof XMIResource) {
			XMIResource xmiRes = (XMIResource) r;
			xmiRes.getDefaultSaveOptions().putAll(saveOptions);
		}
		r.setURI(URI.createFileURI(modelFile));

		if (slotContent instanceof Collection<?>) {
			r.getContents().addAll((Collection) slotContent);
		}
		else {
			r.getContents().add((EObject) slotContent);
		}
		try {
			// Fix: EMF-Resource builds wrong file name, if used on a file
			// on windows (it places the Device-Carater immediately before
			// the last Slash). So we write explicitly to the path if the
			// URI is a file URI.
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=173604
			if (r.getURI().isFile()) {
				File file = new File(pathPrefix + "/" + modelFile);
				OutputStream os = new FileOutputStream(file);
				r.save(os, null);
				os.close();
			}
			else {
				r.save(null);
			}
		}
		catch (final IOException e) {
			throw new ConfigurationException(e);
		}

	}

	class XmiWriterURIConverter extends URIConverterImpl {
		private String pathPrefix;

		public XmiWriterURIConverter(String pathPrefix) {
			this.pathPrefix = pathPrefix;
		}

		@Override
		protected OutputStream createFileOutputStream(String filename) throws IOException {
			if (pathPrefix != null) {
				pathPrefix = pathPrefix.replace('\\', '/');
				if (!pathPrefix.endsWith("/")) {
					pathPrefix += "/";
				}
				filename = filename.replace('\\', '/');
				int lastSlashPos = filename.lastIndexOf("/");
				if (lastSlashPos >= 0) {
					filename = filename.substring(0, lastSlashPos + 1) + pathPrefix
							+ filename.substring(lastSlashPos + 1);
				}
			}
			return super.createFileOutputStream(filename);
		}
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#getComponentName()
	 */
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
